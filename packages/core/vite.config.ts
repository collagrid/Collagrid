import { defineConfig } from 'vite';
import dts from 'vite-plugin-dts';
import * as path from 'path';

export default defineConfig({
    // 在这里配置你的 Vite 项目
    plugins: [
        // 将插件添加到 Vite 配置中
        dts({
            // 配置生成的类型声明文件的输出目录
            outDir: './dist/types',
            // 配置要包含的 TypeScript 文件或目录（可选）
            include: './src/**/*.ts',
            // 配置要排除的 TypeScript 文件或目录（可选）
            exclude: './src/**/*.spec.ts',
        }),
    ],
    build: {
        rollupOptions: {
            input: {
                library: path.resolve(__dirname, 'src/index.ts'),
                main: path.resolve(__dirname, 'src/main.ts')
            },
            output: {
                dir: 'dist',
                format: 'es',
                entryFileNames: '[name].js',
            }
        }
    }
    // build: {
    //     lib: {
    //         entry: './src/main.ts',
    //         name: 'collagrid', // 你的库的名称，用于全局访问
    //     },
    //     terserOptions: {
    //         toplevel: true, // 保留顶级作用域符号不混淆
    //     },
    //     rollupOptions: {
    //         // 确保输出文件格式为 'es'，以便可以在浏览器中直接使用
    //         output: {
    //             format: 'es',
    //         },
    //     },
    // },
});
