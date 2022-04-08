package info.matai.core;

import info.matai.services.plugins.PluginFileReaderService;
import java.io.File;

public class MpmCore {
    final String serverPath = "./";
    final String pluginsPath = "./plugins";

    private File pluginFile;
    private File pluginLockFile;

    private static MpmCore instance;

    private MpmCore() {
        loadPluginsFile();
    }

    public static MpmCore getInstance() {
        if (instance == null) {
            instance = new MpmCore();
        }
        return instance;
    }

    public String test() {
        return "Waddup loser";
    }

    private void loadPluginsFile() {
        pluginFile = new File(serverPath, "plugin.json");
        pluginLockFile = new File(serverPath, "plugin-lock.json");
    }
}
