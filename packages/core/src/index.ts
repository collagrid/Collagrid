import {ClientSideRowModelModule, createGrid, GridApi, GridOptions, ModuleRegistry} from "ag-grid-community";
import "ag-grid-community/styles/ag-grid.css";
import "ag-grid-community/styles/ag-theme-quartz.css";
// Row Data Interface
interface IRow {
    make: string;
    model: string;
    price: number;
    electric: boolean;
}

export interface Option{

}

// CollaGrid Class
export default class CollaGrid {
    private gridApi: GridApi | undefined;
    private gridOptions: GridOptions<IRow>;

    constructor(option: Option) {
        this.gridOptions = {
            rowData: [
                {make: "Tesla", model: "Model Y", price: 64950, electric: true},
                {make: "Ford", model: "F-Series", price: 33850, electric: false},
                {make: "Toyota", model: "Corolla", price: 29600, electric: false},
                {make: "Mercedes", model: "EQA", price: 48890, electric: true},
                {make: "Fiat", model: "500", price: 15774, electric: false},
                {make: "Nissan", model: "Juke", price: 20675, electric: false},
            ],
            columnDefs: [
                {field: "make"},
                {field: "model"},
                {field: "price"},
                {field: "electric"},
            ],
            defaultColDef: {
                flex: 1,
            },
        };
    }

    // Initialize the grid
    mount(domId: string) {
        // Register modules
        ModuleRegistry.registerModules([ClientSideRowModelModule]);

        // Create Grid
        this.gridApi = createGrid(
            document.querySelector<HTMLElement>(`${domId}`)!,
            this.gridOptions
        );
    }
}

export const createCollaGrid = (option: Option) => {
    return new CollaGrid(option);
}
