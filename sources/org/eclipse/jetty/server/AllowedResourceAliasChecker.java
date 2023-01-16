package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.component.LifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AllowedResourceAliasChecker.class */
public class AllowedResourceAliasChecker extends AbstractLifeCycle implements ContextHandler.AliasCheck {
    private static final Logger LOG = Log.getLogger(AllowedResourceAliasChecker.class);
    protected static final LinkOption[] FOLLOW_LINKS = new LinkOption[0];
    protected static final LinkOption[] NO_FOLLOW_LINKS = {LinkOption.NOFOLLOW_LINKS};
    private final ContextHandler _contextHandler;
    private final List<Path> _protected = new ArrayList();
    private final AllowedResourceAliasCheckListener _listener = new AllowedResourceAliasCheckListener();
    protected Path _base;

    public AllowedResourceAliasChecker(ContextHandler contextHandler) {
        this._contextHandler = (ContextHandler) Objects.requireNonNull(contextHandler);
    }

    protected ContextHandler getContextHandler() {
        return this._contextHandler;
    }

    protected void initialize() {
        this._base = getPath(this._contextHandler.getBaseResource());
        if (this._base != null) {
            try {
                if (Files.exists(this._base, NO_FOLLOW_LINKS)) {
                    this._base = this._base.toRealPath(FOLLOW_LINKS);
                }
                String[] protectedTargets = this._contextHandler.getProtectedTargets();
                if (protectedTargets != null) {
                    for (String s : protectedTargets) {
                        this._protected.add(this._base.getFileSystem().getPath(this._base.toString(), s));
                    }
                }
            } catch (IOException e) {
                LOG.warn("Base resource failure ({} is disabled): {}", getClass().getName(), this._base, e);
                this._base = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._contextHandler.isStarted()) {
            initialize();
        } else {
            this._contextHandler.addLifeCycleListener(this._listener);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        this._contextHandler.removeLifeCycleListener(this._listener);
        this._base = null;
        this._protected.clear();
    }

    @Override // org.eclipse.jetty.server.handler.ContextHandler.AliasCheck
    public boolean check(String pathInContext, Resource resource) {
        Path path;
        if (this._base == null) {
            return false;
        }
        try {
            if (resource.exists() && (path = getPath(resource)) != null) {
                return check(pathInContext, path);
            }
            return false;
        } catch (Throwable t) {
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("Failed to check alias", t);
            return false;
        }
    }

    protected boolean check(String pathInContext, Path path) {
        return isAllowed(getRealPath(path));
    }

    protected boolean isAllowed(Path path) {
        if (path == null || !Files.exists(path, new LinkOption[0])) {
            return false;
        }
        while (path != null) {
            if (isSameFile(path, this._base)) {
                return true;
            }
            for (Path p : this._protected) {
                if (isSameFile(path, p)) {
                    return false;
                }
            }
            path = path.getParent();
        }
        return false;
    }

    protected boolean isSameFile(Path path1, Path path2) {
        if (Objects.equals(path1, path2)) {
            return true;
        }
        try {
            if (Files.isSameFile(path1, path2)) {
                return true;
            }
            return false;
        } catch (Throwable t) {
            if (!LOG.isDebugEnabled()) {
                return false;
            }
            LOG.debug("ignored", t);
            return false;
        }
    }

    private static Path getRealPath(Path path) {
        if (path == null || !Files.exists(path, new LinkOption[0])) {
            return null;
        }
        try {
            path = path.toRealPath(FOLLOW_LINKS);
            if (Files.exists(path, new LinkOption[0])) {
                return path;
            }
            return null;
        } catch (IOException e) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.debug("No real path for {}", path, e);
            return null;
        }
    }

    protected Path getPath(Resource resource) {
        try {
            if (resource instanceof PathResource) {
                return ((PathResource) resource).getPath();
            }
            if (resource == null) {
                return null;
            }
            return resource.getFile().toPath();
        } catch (Throwable t) {
            LOG.ignore(t);
            return null;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/AllowedResourceAliasChecker$AllowedResourceAliasCheckListener.class */
    private class AllowedResourceAliasCheckListener implements LifeCycle.Listener {
        private AllowedResourceAliasCheckListener() {
        }

        @Override // org.eclipse.jetty.util.component.LifeCycle.Listener
        public void lifeCycleStarted(LifeCycle event) {
            AllowedResourceAliasChecker.this.initialize();
        }
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        String[] protectedTargets = this._contextHandler.getProtectedTargets();
        Object[] objArr = new Object[4];
        objArr[0] = getClass().getSimpleName();
        objArr[1] = Integer.valueOf(hashCode());
        objArr[2] = this._base;
        objArr[3] = protectedTargets == null ? null : Arrays.asList(protectedTargets);
        return String.format("%s@%x{base=%s,protected=%s}", objArr);
    }
}
