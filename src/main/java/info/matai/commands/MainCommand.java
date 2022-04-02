package info.matai.commands;

import java.io.File;
import java.util.concurrent.Callable;
import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Option;
import picocli.CommandLine.Parameters;
import picocli.CommandLine.ParentCommand;

@Command(name = "mpm")
public class MainCommand implements Callable<String> {
  static final String serverPath = "./";
  static final String pluginsPath = "./plugins";

  private File pluginFile;
  private File pluginLockFile;

  @Command(name = "install")
  public String install() {
    loadPluginsFile();
    return "";
  }

  @Command(name = "update")
  public String update() {
    return "";
  }

  @Command(name = "delete")
  public String delete() {
    return "";
  }

  @Override
  public String call() throws Exception {
    // TODO Auto-generated method stub

    return null;
  }


  //TODO Init command eventually?

  private void loadPluginsFile() {
    pluginFile = new File(serverPath, "plugin.json");
    pluginLockFile = new File(serverPath, "plugin-lock.json");

    if (pluginFile.exists() && !pluginLockFile.exists()) {
      try {
        pluginLockFile.createNewFile();
        downloadAllPlugins();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }else if(!pluginFile.exists() && !pluginLockFile.exists()){
      try {
        pluginFile.createNewFile();
        createPluginFileFromLockJson();
      } catch (Exception e) {
        e.printStackTrace();
      }
    }else if(!pluginFile.exists() && !pluginLockFile.exists()){
        initializeJSONFiles();
    }

  }

  private void downloadAllPlugins() {
    // TODO Code that goes & fetches all the plugin jars & data from the plugin list in the plugin.json file
    // Also needs to write down what was actually fetch in the locked json file.



  }

  private void initializeJSONFiles(){
      //TODO Initialize the new JsonFiles and use scanner perhaps for server version & type
  }

  private void createPluginFileFromLockJson(){

  }
}
