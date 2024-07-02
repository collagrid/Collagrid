import { defineConfig } from 'vite';
import dts from 'vite-plugin-dts';
import * as path from 'path';

export default defineConfig({
    plugins: [
        dts({
            outDir: './dist/types',
            include: './src/**/*.ts',
            exclude: './src/**/*.spec.ts',
        }),
    ],
    build: {
        rollupOptions: {
            output: {
                assetFileNames: (assetInfo) => {
                    if (assetInfo.name && assetInfo.name.endsWith('.css')) {
                        return 'css/colla-grid.css';
                    }
                    return '[name]-[hash][extname]';
                },
            },
        },
        sourcemap: false,
        lib: {
            entry: path.resolve(__dirname, "src/index.ts"),
            name: "CollaGrid",
            fileName: (format) => `colla-grid.${format}.js`
        },
    }
});
