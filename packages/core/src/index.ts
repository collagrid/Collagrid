import {ClientSideRowModelModule, createGrid, GridApi, GridOptions, ModuleRegistry} from "ag-grid-community";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
// Row Data Interface
interface IRow {
    recordId: string;
}

interface CollaGridOption{

}

// CollaGrid Class
class CollaGrid {
    private gridApi: GridApi | undefined;
    private gridOptions: GridOptions<IRow>;

    constructor(option: CollaGridOption) {
        console.log('option is', option);
        (window as any).d = new Map([
            ["Tesla", {make: "Tesla", model: "Model Y", price: 64950, electric: true}],
            ["Ford", {make: "Ford", model: "F-Series", price: 33850, electric: false}],
            ["Toyota", {make: "Toyota", model: "Corolla", price: 29600, electric: false}],
            ["Mercedes", {make: "Mercedes", model: "EQA", price: 48890, electric: true}],
            ["Fiat", {make: "Fiat", model: "500", price: 15774, electric: false}],
            ["Nissan", {make: "Nissan", model: "Juke", price: 20675, electric: false}]
        ]);
        this.gridOptions = {
            rowData: [
                {recordId: "Tesla",},
                {recordId: "Ford",},
                {recordId: "Toyota",},
                {recordId: "Mercedes",},
                {recordId: "Fiat",},
                {recordId: "Nissan",},
            ],
            columnDefs: [
                {field: "make", valueGetter: (p) => {
                        return (window as any).d.get(p.data.recordId).make;
                    }},
                {field: "model", valueGetter: (p) => {
                        return (window as any).d.get(p.data.recordId).model;
                    }},
                {field: "price", valueGetter: (p) => {
                        return (window as any).d.get(p.data.recordId).price;
                    }},
                {field: "electric", valueGetter: (p) => {
                        return (window as any).d.get(p.data.recordId).electric;
                    }},
            ],
            defaultColDef: {
                flex: 1,
            },
        };
    }

    // Initialize the grid
    mount(domId: string) {
        console.log('xx', Array.from((window as any).d.keys()));
        // Register modules
        ModuleRegistry.registerModules([ClientSideRowModelModule]);
        console.log('xxmsms');
        // Create Grid
        this.gridApi = createGrid(
            document.querySelector<HTMLElement>(`${domId}`)!,
            this.gridOptions
        );
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

