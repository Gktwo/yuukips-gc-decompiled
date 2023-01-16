package org.eclipse.jetty.server;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/SymlinkAllowedResourceAliasChecker.class */
public class SymlinkAllowedResourceAliasChecker extends AllowedResourceAliasChecker {
    private static final Logger LOG = Log.getLogger(SymlinkAllowedResourceAliasChecker.class);

    public SymlinkAllowedResourceAliasChecker(ContextHandler contextHandler) {
        super(contextHandler);
    }

    @Override // org.eclipse.jetty.server.AllowedResourceAliasChecker
    protected boolean check(String pathInContext, Path path) {
        if (this._base == null) {
            return false;
        }
        if (File.separatorChar != '/' && pathInContext.indexOf(File.separatorChar) >= 0) {
            return false;
        }
        String[] segments = pathInContext.substring(1).split("/");
        Path fromBase = this._base;
        StringBuilder realURI = new StringBuilder();
        try {
            for (String segment : segments) {
                fromBase = fromBase.resolve(segment);
                realURI.append("/").append(fromBase.toRealPath(NO_FOLLOW_LINKS).getFileName());
                if (Files.isSymbolicLink(fromBase)) {
                    return !getContextHandler().isProtectedTarget(realURI.toString());
                }
                if (!isAllowed(fromBase)) {
                    return false;
                }
            }
            return isSameFile(fromBase, path);
        } catch (Throwable t) {
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("Failed to check alias", t);
            return false;
        }
    }
}
