package org.eclipse.jetty.server;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.resource.Resource;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SameFileAliasChecker.class */
public class SameFileAliasChecker implements ContextHandler.AliasCheck {
    private static final Logger LOG = Log.getLogger(SameFileAliasChecker.class);

    @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
    public boolean check(String uri, Resource resource) {
        if ((File.separatorChar != '/' && uri.indexOf(File.separatorChar) >= 0) || !(resource instanceof PathResource)) {
            return false;
        }
        try {
            PathResource pathResource = (PathResource) resource;
            Path path = pathResource.getPath();
            Path alias = pathResource.getAliasPath();
            if (!Files.isSameFile(path, alias)) {
                return false;
            }
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("Allow alias to same file {} --> {}", path, alias);
            return true;
        } catch (IOException e) {
            LOG.ignore(e);
            return false;
        }
    }
}
