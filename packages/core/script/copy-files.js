const fs = require('fs');
const path = require('path');

function copyFile(source, target) {
    fs.copyFileSync(source, target);
    console.log(`Copied ${source} to ${target}`);
}

function copyDirectory(sourceDir, targetDir) {
    fs.mkdirSync(targetDir, { recursive: true });
    const files = fs.readdirSync(sourceDir);
    files.forEach(file => {
        const srcFile = path.join(sourceDir, file);
        const destFile = path.join(targetDir, file);
        if (fs.statSync(srcFile).isDirectory()) {
            copyDirectory(srcFile, destFile);
        } else {
            fs.copyFileSync(srcFile, destFile);
            console.log(`Copied ${srcFile} to ${destFile}`);
        }
    });
}

// Retrieve command line arguments
const args = process.argv.slice(2);
if (args.length !== 2) {
    console.error('Usage: node copy-files.js <source> <target>');
    process.exit(1);
}

const sourcePath = args[0];
const targetPath = args[1];

// Check if sourcePath is a file or directory
if (fs.existsSync(sourcePath)) {
    if (fs.statSync(sourcePath).isFile()) {
        copyFile(sourcePath, targetPath);
    } else {
        copyDirectory(sourcePath, targetPath);
    }
} else {
    console.error(`Source path '${sourcePath}' does not exist.`);
    process.exit(1);
}
