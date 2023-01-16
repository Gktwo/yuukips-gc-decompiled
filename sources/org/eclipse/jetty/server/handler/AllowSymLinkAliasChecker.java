package org.eclipse.jetty.server.handler;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Iterator;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.resource.Resource;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/AllowSymLinkAliasChecker.class */
public class AllowSymLinkAliasChecker implements ContextHandler.AliasCheck {
    private static final Logger LOG = Log.getLogger(AllowSymLinkAliasChecker.class);

    public AllowSymLinkAliasChecker() {
        LOG.warn(getClass().getSimpleName() + " is deprecated", new Object[0]);
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
    public boolean check(String uri, Resource resource) {
        if (!(resource instanceof PathResource)) {
            return false;
        }
        PathResource pathResource = (PathResource) resource;
        try {
            Path path = pathResource.getPath();
            Path alias = pathResource.getAliasPath();
            if (PathResource.isSameName(alias, path) || !hasSymbolicLink(path) || !Files.isSameFile(path, alias)) {
                return false;
            }
            if (!LOG.isDebugEnabled()) {
                return true;
            }
            LOG.debug("Allow symlink {} --> {}", resource, pathResource.getAliasPath());
            return true;
        } catch (Exception e) {
            LOG.ignore(e);
            return false;
        }
    }

    private boolean hasSymbolicLink(Path path) {
        if (Files.isSymbolicLink(path)) {
            return true;
        }
        Path base = path.getRoot();
        Iterator<Path> it = path.iterator();
        while (it.hasNext()) {
            base = base.resolve(it.next());
            if (Files.isSymbolicLink(base)) {
                return true;
            }
        }
        return false;
    }
}
