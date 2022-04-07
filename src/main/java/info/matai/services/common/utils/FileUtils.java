package info.matai.services.common.utils;

import java.io.File;
import java.io.IOException;
import java.util.logging.Logger;

public class FileUtils {

    private static final Logger LOGGER = Logger.getLogger(FileUtils.class.getName());

    public static File getFile(String fileName) {
        return new File(fileName);
    }

    public static File createFile(String fileName) {
        File file = new File(fileName);
        try {
            file.createNewFile();
        } catch (IOException e) {
            LOGGER.severe("Can't create file: " + fileName);
        }
        return file;
    }

    public static File getOrCreateFile(String fileName) {
        final File file = getFile(fileName);

        if (notExist(file)) {
            return createFile(fileName);
        }
        return file;
    }

    public static boolean exist(File file) {
        return file.exists();
    }

    public static boolean notExist(File file) {
        return !exist(file);
    }
}
