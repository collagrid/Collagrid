// main.ts

// 定义一个简单的 Button 组件类
class Button {
    private text: string;

    constructor(text: string) {
        this.text = text;
    }

    render(): HTMLElement {
        const button = document.createElement('button');
        button.textContent = this.text;
        return button;
    }
}

// 导出组件库的主要接口
export { Button };
