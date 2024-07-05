import {ClientSideRowModelModule, createGrid, GridApi, GridOptions, ModuleRegistry} from "ag-grid-community";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
// Row Data Interface
interface IRow {
    recordId?: string;
    [key: string]: any;
}

interface CollaGridOption{

}

// CollaGrid Class
class CollaGrid {
    private gridApi: GridApi | undefined;
    private gridOptions: GridOptions<IRow>;
    private instance: Map<string, IRow>;

    constructor(option: CollaGridOption) {
        console.log('option is', option);
        this.instance = new Map<string, IRow>([
            ["asx", { make: "asx", model: "Model Y", price: 64950, electric: true }],
            ["Tesla", { make: "Tesla", model: "Model Y", price: 64950, electric: true }],
            ["Ford", { make: "Ford", model: "F-Series", price: 33850, electric: false }],
            ["Toyota", { make: "Toyota", model: "Corolla", price: 29600, electric: false }],
            ["Mercedes", { make: "Mercedes", model: "EQA", price: 48890, electric: true }],
            ["Fiat", { make: "Fiat", model: "500", price: 15774, electric: false }],
            ["Nissan", { make: "Nissan", model: "Juke", price: 20675, electric: false }]
        ]);

        this.gridOptions = {
            rowData: [
                { recordId: "Tesla" },
                { recordId: "Ford" },
                { recordId: "Toyota" },
                { recordId: "Mercedes" },
                { recordId: "Fiat" },
                { recordId: "Nissan" }
            ],
            columnDefs: [
                { field: "make", enableCellChangeFlash: true,
                    valueGetter: (p) => this.getValue(p, "make") },
                { field: "model", valueGetter: (p) => this.getValue(p, "model") },
                { field: "price", valueGetter: (p) => this.getValue(p, "price") },
                { field: "electric", valueGetter: (p) => this.getValue(p, "electric") }
            ],
            getRowId: (data) => {
                return data.data.recordId as string;
            },
            defaultColDef: {
                flex: 1
            }
        };
    }

    private getValue(params: any, field: string) {
        const dataMap = this.instance;
        const rowData = dataMap.get(params.data.recordId);
        return rowData ? rowData[field] : undefined;
    }

    private refreshGrid() {
        if (this.gridApi) {
            this.gridApi.refreshCells({ force: true });
        }
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

    // Method to update map and refresh grid
    updateData(recordId: string, newData: Partial<IRow>) {
        const dataMap = this.instance;
        const existingData = dataMap.get(recordId);
        if (existingData) {
            dataMap.set(recordId, { ...existingData, ...newData });
            // this.refreshGrid();
            this.refreshSpecificCell(recordId, 'make');
        }
    }


    // Initialize the grid
    mount(domId: string) {
        console.log('xx', Array.from(this.instance.keys()));
        // Register modules
        ModuleRegistry.registerModules([ClientSideRowModelModule]);
        console.log('xxmsms');
        // Create Grid
        this.gridApi = createGrid(
            document.querySelector<HTMLElement>(`${domId}`)!,
            this.gridOptions
        );
        setTimeout(() => {
            this.updateData("Tesla", { make: 'xxx'});
        }, 3000);
        setTimeout(() => {
            const newRowData = [
                {recordId: "asx"}
            ];
            this.gridOptions.rowData = newRowData;
            this.gridApi?.applyTransaction({ add: newRowData });
        }, 5000);
    }
}

const createCollaGrid = (option: CollaGridOption) => {
    return new CollaGrid(option);
}

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

export {createCollaGrid, CollaGrid, add};
export type { CollaGridOption };

