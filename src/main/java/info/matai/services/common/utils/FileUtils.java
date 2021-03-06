package info.matai.services.common.utils;

import java.io.File;
import java.nio.file.Files;

public class FileUtils {

  public static File getFile(String fileName) {
    return new File(fileName);
  }

  public static String readFile(File file) {
//    try {
//      return Files.readString(file.toPath());
//    } catch (Exception e) {
//      return null;
//    }
    return null;
  }

  public static boolean exist(File file) {
    return file.exists();
  }

  public static boolean notExist(File file) {
    return !exist(file);
  }

  public static boolean isEmpty(File file) {
    return file.length() == 0;
  }

  public static boolean isNotEmpty(File file) {
    return !isEmpty(file);
  }
}
