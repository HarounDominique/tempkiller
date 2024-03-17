import java.io.File;

public class Main {
    public static void main(String[] args) {
        String[] folderPaths = {
                System.getProperty("java.io.tmpdir"), // Carpeta temporal del usuario
                System.getenv("windir") + "\\temp", // Carpeta temporal del sistema en Windows
                System.getenv("windir") + "\\Prefetch", // Carpeta Prefetch en Windows
                System.getenv("windir") + "\\temp" // Carpeta Windows\Temp
        };

        for (String folderPath : folderPaths) {
            File folder = new File(folderPath);
            if (folder.exists() && folder.isDirectory()) {
                long totalSizeBytes = 0;

                File[] files = folder.listFiles();
                if (files != null) {
                    for (File file : files) {
                        totalSizeBytes += file.length();
                    }
                }

                System.out.println("Carpeta: " + folderPath);
                System.out.println("Tamaño ocupado: " + formatSize(totalSizeBytes));
                System.out.println();
            }
        }
    }

    private static String formatSize(long size) {
        if (size < 1024) {
            return size + " bytes";
        } else if (size < 1024 * 1024) {
            return size / 1024 + " KB";
        } else if (size < 1024 * 1024 * 1024) {
            return size / (1024 * 1024) + " MB";
        } else if (size < 1024L * 1024 * 1024 * 1024) {
            return size / (1024 * 1024 * 1024) + " GB";
        } else {
            return size / (1024L * 1024 * 1024 * 1024) + " TB";
        }
    }
}
