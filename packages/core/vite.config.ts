import { defineConfig } from 'vite';

export default defineConfig({
    // 在这里配置你的 Vite 项目
    build: {
        lib: {
            entry: './src/main.ts',
            name: 'collagrid', // 你的库的名称，用于全局访问
        },
        rollupOptions: {
            // 确保输出文件格式为 'es'，以便可以在浏览器中直接使用
            output: {
                format: 'es',
            },
        },
    },
});
