package org.eclipse.jetty.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/HomeBaseWarning.class */
public class HomeBaseWarning {
    private static final Logger LOG = Log.getLogger(HomeBaseWarning.class);

    public HomeBaseWarning() {
        String home = System.getProperty("jetty.home");
        String base = System.getProperty("jetty.base");
        if (!StringUtil.isBlank(base)) {
            try {
                if (Files.isSameFile(new File(home).toPath(), new File(base).toPath())) {
                    LOG.warn("{}", "This instance of Jetty is not running from a separate {jetty.base} directory, this is not recommended.  See documentation at https://www.eclipse.org/jetty/documentation/current/startup.html");
                }
            } catch (IOException e) {
                LOG.ignore(e);
            }
        }
    }
}
