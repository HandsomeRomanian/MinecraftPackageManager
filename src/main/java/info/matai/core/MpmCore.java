package info.matai.core;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;

import com.google.gson.Gson;

import info.matai.commands.subcommands.InitializeCommand;
import info.matai.models.configuration.Server;
import info.matai.models.configuration.ServerLock;

public class MpmCore {
    final String serverPath = "./";
    final String pluginsPath = "./plugins";

    private Server server;
    private ServerLock serverLock;

    private static MpmCore instance;

    public ServerLock getPluginLockInfo() {
        return serverLock;
    }

    public void setPluginLockInfo(ServerLock pluginLockInfo) {
        this.serverLock = pluginLockInfo;
    }

    public Server getPluginInfo() {
        return server;
    }

    public void setPluginInfo(Server pluginInfo) {
        this.server = pluginInfo;
    }

    public static MpmCore getInstance() {
        if (instance == null) {
            instance = new MpmCore();
        }
        return instance;
    }

    private MpmCore() {
        try {
            this.loadPluginsFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String test() {
        return "Hello World!";
    }

    private void loadPluginsFile() throws IOException {
        try {

            String pluginJson = Files.readString(Path.of("./plugin.json"));
            this.server = new Gson().fromJson(pluginJson, Server.class);
        } catch (NoSuchFileException e) {
            new InitializeCommand().call();
        }

        try {
            String pluginLockJson = Files.readString(Path.of("./plugin-lock.json"));
            this.serverLock = new Gson().fromJson(pluginLockJson, ServerLock.class);
        } catch (NoSuchFileException e) {
            // TODO well boohooo

        }
    }
}
