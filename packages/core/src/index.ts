import { ClientSideRowModelModule, createGrid, GridApi, GridOptions, ModuleRegistry } from "ag-grid-community";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
import { getData } from "./api";

interface IRow {
    recordId?: string;
    [key: string]: any;
}

interface CollaGridOption {}

class CollaGrid {
    private gridApi: GridApi | undefined;
    private gridOptions: GridOptions<IRow>;
    private recordMap: any;

    constructor(option: CollaGridOption) {
        console.log('option is', option);
        this.gridOptions = {
            rowData: [],
            onRowClicked: (params: any) => {
                const val = this.recordMap[params.data.recordId];
                console.log(`create record id is ${val.createV} and v is: ${val.v} ${val.id}`);
            },
            columnDefs: [],
            getRowId: (data) => data.data.recordId as string,
            defaultColDef: {
                flex: 1
            }
        };
    }

    private getValue(params: any) {
        const fieldId = params.colDef.field;
        const recordId = params.data.recordId;
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
        getData('dst1dnr6blpf7gubsr').then((data) => {
            console.log('zzq see', data);
            const columns = data.data.meta.views[0].columns;
            const fieldMap = data.data.meta.fieldMap;
            const headers: any[] = [{
                headerName: '#',
                field: 'rowIndex',
                minWidth: 60,
                sortable: false,
                filter: false,
                resizable: false,
                valueGetter: (params: any) => params.node.rowIndex + 1
            }];
            this.recordMap = data.data.recordMap;
            columns.forEach((column: any) => {
                headers.push({
                    field: column.fieldId,
                    minWidth: 160,
                    headerName: fieldMap[column.fieldId].name,
                    valueGetter: this.getValue.bind(this)
                });
            });
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
