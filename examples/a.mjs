import {CollaGrid} from "../packages/core/dist/core.mjs";

export class A {

    constructor(id) {
        const myCollaGrid = new CollaGrid(id);

        // 初始化 Grid
        myCollaGrid.initializeGrid();
    }
}
