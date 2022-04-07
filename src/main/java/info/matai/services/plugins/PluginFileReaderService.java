package info.matai.services.plugins;

import info.matai.models.configuration.Server;
import info.matai.models.configuration.ServerLock;
import info.matai.services.common.utils.FileUtils;
import info.matai.services.common.utils.JsonUtils;

import java.io.File;

public class PluginFileReaderService {

    public boolean isInitialized() {
        // LOGGER.warning("Server is not initialized, please run `mpm init`");
        return getServerFromPlugin() != null && getServerFromPluginLock() != null;
    }

    public Server getServerFromPlugin() {
        final File pluginsFile = FileUtils.getOrCreateFile("plugins.json");
        final Server server = JsonUtils.parseJsonFromFile(pluginsFile, Server.class);

        if (server == null) {
            // TODO: Init the project?
            return null;
        }

        return server;
    }

    public ServerLock getServerFromPluginLock() {
        final File pluginsLockFile = FileUtils.getOrCreateFile("plugins-lock.json");
        final ServerLock serverLock = JsonUtils.parseJsonFromFile(pluginsLockFile, ServerLock.class);

        if (serverLock == null) {
            // TODO: Init the project?
            return null;
        }

        return serverLock;
    }
}
