package info.matai.services.common.plugins;

import info.matai.models.configuration.Server;
import info.matai.models.configuration.ServerLock;
import info.matai.services.plugins.PluginFileReaderService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PluginFileReaderServiceTest {
    PluginFileReaderService pluginFileReaderService;

    @Before
    public void init() {
        pluginFileReaderService = new PluginFileReaderService();
    }

    @Test
    public void getServerFromPluginTest() {
        final Server server = pluginFileReaderService.getServerFromPlugin();

        Assert.assertNotNull(server);
        Assert.assertNotNull(server.getBuildVersion());
        Assert.assertNotNull(server.getMcVersion());
        Assert.assertNotNull(server.getServerType());
        Assert.assertNotNull(server.getPlugins());
        Assert.assertNotNull(server.getVersion());
    }

    @Test
    public void getServerFromPluginLockTest() {
        final ServerLock serverLock = pluginFileReaderService.getServerFromPluginLock();

        Assert.assertNotNull(serverLock);
        Assert.assertNotNull(serverLock.getBuildVersion());
        Assert.assertNotNull(serverLock.getMcVersion());
        Assert.assertNotNull(serverLock.getServerType());
        Assert.assertNotNull(serverLock.getPlugins());
    }
}
