import { ClientSideRowModelModule, createGrid, GridApi, GridOptions, ModuleRegistry } from "ag-grid-community";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import {doOp, getData} from "./api";

interface IRow {
    recordId?: string;
    [key: string]: any;
}

interface CollaGridOption {}

class CollaGrid {
    private gridApi: GridApi | undefined;
    private gridOptions: GridOptions<IRow>;
    private recordMap: any;
    private revision = 0;

    constructor(option: CollaGridOption) {
        console.log('option is', option);
        this.gridOptions = {
            rowData: [],
            onRowClicked: (params: any) => {
                const val = this.recordMap[params.data.recordId];
                console.log(`create record id is ${val.createV} and v is: ${val.v} ${val.id}`, val);
            },
            columnDefs: [],
            getRowId: (data) => {
                return data.data.recordId as string;
            },
            defaultColDef: {
                flex: 1,
                editable: true
            }
        };
    }

    private getValue(params: any) {
        const fieldId = params.colDef.field;
        const recordId = params.data.recordId;
        const da = this.recordMap[recordId].data;
        if (!da || !da[fieldId]) {
            return '';
        }
        return this.recordMap[recordId].data[fieldId][0].text;
    }

    private refreshSpecificCell(recordId: string, field: string) {
        const rowNode = this.gridApi?.getRowNode(recordId);
        if (rowNode) {
            const cellRefreshParams = {
                columns: [field],
                rowNodes: [rowNode],
                force: true
            };
            this.gridApi?.refreshCells(cellRefreshParams);
        }
    }

    // Initialize the grid
    mount(domId: string) {
        getData('dstj2x0ekis73uygg1').then((data) => {
            this.revision = data.data.v;
            const columns = data.data.meta.views[0].columns;
            const fieldMap = data.data.meta.fieldMap;
            const headers: any[] = [{
                headerName: '#',
                field: 'rowIndex',
                minWidth: 60,
                width: 60,
                editable: false,
                sortable: false,
                filter: false,
                pinned: "left",
                resizable: false,
                valueGetter: (params: any) => {
                    return params.node.rowIndex + 1;
                }
            }];
            this.recordMap = data.data.recordMap;
            for (let i = 0; i < columns.length; i++) {
                const column  = columns[i];
                const he = {
                    field: column.fieldId,
                    minWidth: 160,
                    valueSetter: (params:any) => {
                        const fieldId = params.colDef.field;
                        const recordId = params.data.recordId;
                        const oldData = this.recordMap[recordId].data;
                        const recordUid = this.recordMap[recordId].uid;
                        const op = this.getOperation('dstj2x0ekis73uygg1', recordUid, recordId, fieldId, params.newValue, this.revision);
                        if (oldData) {
                            const od = oldData[fieldId];
                            if (od) {
                                op.changesets[0].operations[0].actions[0].od = od;
                            }
                            oldData[fieldId] = op.changesets[0].operations[0].actions[0].oi;
                        }
                        console.log('zzq see op', op);
                        doOp(op).then(r =>{
                            this.revision++;
                            const sdata = r.data.changesets[0].operations[0].actions[0].oi;
                            console.log('zzq see ddd', sdata);
                            oldData[fieldId] = sdata;
                            this.refreshSpecificCell(recordId, fieldId);
                        })
                        return true;
                    },
                    headerName: fieldMap[column.fieldId].name,
                    valueGetter: this.getValue.bind(this)
                };
                if (i == 0) {
                    he.pinned = 'left';
                }
                headers.push(he);
            }
            const rows = data.data.meta.views[0].rows;
            this.gridOptions.rowData = rows;
            this.gridOptions.columnDefs = headers;
            console.log('zzq see rows', this.gridOptions);
            this.gridApi = createGrid(
                document.querySelector<HTMLElement>(domId)!,
                this.gridOptions
            );
        });
        ModuleRegistry.registerModules([ClientSideRowModelModule]);
    }

    private getOperation(dstId: String, uid: number, recordId: String, fieldId: String, text: String, rv: number) {
        return JSON.parse(`
        {
    "type": "CLIENT_ROOM_CHANGE",
    "roomId": "${dstId}",
    "changesets": [
        {
            "messageId": "MN1iXJGzRyJiOa4dzOyQ",
            "baseRevision": ${rv},
            "resourceId": "${dstId}",
            "resourceType": 0,
            "operations": [
                {
                    "cmd": "SetRecords",
                    "actions": [
                        {
                            "n": "OI",
                            "rid":"${uid}",
                            "branchId":"0.01",
                            "p": [
                                "recordMap",
                                "${recordId}",
                                "data",
                                "${fieldId}"
                            ],
                            "oi": [
                                {
                                    "type": 1,
                                    "text": "${text}"
                                }
                            ]
                        }
                    ]
                }
            ]
        }
    ]
}
        `)
    }
}

const createCollaGrid = (option: CollaGridOption) => new CollaGrid(option);

/**
 * Adds two numbers together.
 * @param {number} a - The first number.
 * @param {number} b - The second number.
 * @returns {number} The sum of the two numbers.
 * @example
 * ```typescript
 * const result = add(2, 3);
 * console.log(result); // 5
 * ```
 */
function add(a: number, b: number): number {
    return a + b;
}

export { createCollaGrid, CollaGrid, add };
export type { CollaGridOption };
