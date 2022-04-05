package info.matai.services.plugins;

import info.matai.models.configuration.Server;
import info.matai.models.configuration.ServerLock;
import info.matai.services.common.utils.FileUtils;
import info.matai.services.common.utils.JsonUtils;

import java.io.File;
import java.util.logging.Logger;

public class PluginFileReaderService {

    private static final Logger LOGGER = Logger.getGlobal();

    public Server getServerFromPlugin() {
        final File pluginsFile = FileUtils.getOrCreateFile("plugins.json");
        final Server server = JsonUtils.parseJsonFromFile(pluginsFile, Server.class);

        if (server == null) {
            // TODO: Init the project?
            LOGGER.warning("plugins.json is not initialized");
            return null;
        }

        return server;
    }

    public ServerLock getServerFromPluginLock() {
        final File pluginsLockFile = FileUtils.getOrCreateFile("plugins-lock.json");
        final ServerLock serverLock = JsonUtils.parseJsonFromFile(pluginsLockFile, ServerLock.class);

        if (serverLock == null) {
            // TODO: Init the project?
            LOGGER.warning("plugins-lock.json is not initialized");
            return null;
        }

        return serverLock;
    }
}
