package org.eclipse.jetty.security;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.FileAttribute;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.PathWatcher;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.JarFileResource;
import org.eclipse.jetty.util.resource.PathResource;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.security.Credential;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/PropertyUserStore.class */
public class PropertyUserStore extends UserStore implements PathWatcher.Listener {
    private static final Logger LOG = Log.getLogger(PropertyUserStore.class);
    protected Path _configPath;
    protected PathWatcher _pathWatcher;
    protected boolean _hotReload = false;
    protected boolean _firstLoad = true;
    protected List<UserListener> _listeners;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/PropertyUserStore$UserListener.class */
    public interface UserListener {
        void update(String str, Credential credential, String[] strArr);

        void remove(String str);
    }

    public String getConfig() {
        if (this._configPath != null) {
            return this._configPath.toString();
        }
        return null;
    }

    public void setConfig(String config) {
        if (config == null) {
            this._configPath = null;
            return;
        }
        try {
            Resource configResource = Resource.newResource(config);
            if (configResource instanceof JarFileResource) {
                this._configPath = extractPackedFile((JarFileResource) configResource);
            } else if (configResource instanceof PathResource) {
                this._configPath = ((PathResource) configResource).getPath();
            } else if (configResource.getFile() != null) {
                setConfigFile(configResource.getFile());
            } else {
                throw new IllegalArgumentException(config);
            }
        } catch (Exception e) {
            this._configPath = null;
            throw new IllegalStateException(e);
        }
    }

    public Path getConfigPath() {
        return this._configPath;
    }

    @Deprecated
    public void setConfigPath(String configFile) {
        setConfig(configFile);
    }

    private Path extractPackedFile(JarFileResource configResource) throws IOException {
        String uri = configResource.getURI().toASCIIString();
        int colon = uri.lastIndexOf(EmitterKt.COMMENT_PREFIX);
        int bangSlash = uri.indexOf("!/");
        if (colon < 0 || bangSlash < 0 || colon > bangSlash) {
            throw new IllegalArgumentException("Not resolved JarFile resource: " + uri);
        }
        String entryPath = StringUtil.sanitizeFileSystemName(uri.substring(colon + 2));
        Path tmpDirectory = Files.createTempDirectory("users_store", new FileAttribute[0]);
        tmpDirectory.toFile().deleteOnExit();
        Path extractedPath = Paths.get(tmpDirectory.toString(), entryPath);
        Files.deleteIfExists(extractedPath);
        extractedPath.toFile().deleteOnExit();
        C5747IO.copy(configResource.getInputStream(), new FileOutputStream(extractedPath.toFile()));
        if (isHotReload()) {
            LOG.warn("Cannot hot reload from packed configuration: {}", configResource);
            setHotReload(false);
        }
        return extractedPath;
    }

    @Deprecated
    public void setConfigPath(File configFile) {
        setConfigFile(configFile);
    }

    public void setConfigFile(File configFile) {
        if (configFile == null) {
            this._configPath = null;
        } else {
            this._configPath = configFile.toPath();
        }
    }

    public void setConfigPath(Path configPath) {
        this._configPath = configPath;
    }

    public Resource getConfigResource() {
        if (this._configPath == null) {
            return null;
        }
        return new PathResource(this._configPath);
    }

    public boolean isHotReload() {
        return this._hotReload;
    }

    public void setHotReload(boolean enable) {
        if (isRunning()) {
            throw new IllegalStateException("Cannot set hot reload while user store is running");
        }
        this._hotReload = enable;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[users.count=%d,identityService=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), Integer.valueOf(getKnownUserIdentities().size()), getIdentityService());
    }

    protected void loadUsers() throws IOException {
        if (this._configPath == null) {
            throw new IllegalStateException("No config path set");
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Loading {} from {}", this, this._configPath);
        }
        Resource config = getConfigResource();
        if (!config.exists()) {
            throw new IllegalStateException("Config does not exist: " + config);
        }
        Properties properties = new Properties();
        properties.load(config.getInputStream());
        Set<String> known = new HashSet<>();
        for (Map.Entry<Object, Object> entry : properties.entrySet()) {
            String username = ((String) entry.getKey()).trim();
            String credentials = ((String) entry.getValue()).trim();
            String roles = null;
            int c = credentials.indexOf(44);
            if (c >= 0) {
                roles = credentials.substring(c + 1).trim();
                credentials = credentials.substring(0, c).trim();
            }
            if (username.length() > 0) {
                String[] roleArray = IdentityService.NO_ROLES;
                if (roles != null && roles.length() > 0) {
                    roleArray = StringUtil.csvSplit(roles);
                }
                known.add(username);
                Credential credential = Credential.getCredential(credentials);
                addUser(username, credential, roleArray);
                notifyUpdate(username, credential, roleArray);
            }
        }
        List<String> currentlyKnownUsers = new ArrayList<>(getKnownUserIdentities().keySet());
        if (!this._firstLoad) {
            for (String user : currentlyKnownUsers) {
                if (!known.contains(user)) {
                    removeUser(user);
                    notifyRemove(user);
                }
            }
        }
        this._firstLoad = false;
        if (LOG.isDebugEnabled()) {
            LOG.debug("Loaded " + this + " from " + this._configPath, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        loadUsers();
        if (isHotReload() && this._configPath != null) {
            this._pathWatcher = new PathWatcher();
            this._pathWatcher.watch(this._configPath);
            this._pathWatcher.addListener(this);
            this._pathWatcher.setNotifyExistingOnStart(false);
            this._pathWatcher.start();
        }
    }

    @Override // org.eclipse.jetty.util.PathWatcher.Listener
    public void onPathWatchEvent(PathWatcher.PathWatchEvent event) {
        try {
            if (LOG.isDebugEnabled()) {
                LOG.debug("Path watch event: {}", event.getType());
            }
            loadUsers();
        } catch (IOException e) {
            LOG.warn(e);
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        if (this._pathWatcher != null) {
            this._pathWatcher.stop();
        }
        this._pathWatcher = null;
    }

    private void notifyUpdate(String username, Credential credential, String[] roleArray) {
        if (this._listeners != null) {
            for (UserListener listener : this._listeners) {
                listener.update(username, credential, roleArray);
            }
        }
    }

    private void notifyRemove(String username) {
        if (this._listeners != null) {
            for (UserListener listener : this._listeners) {
                listener.remove(username);
            }
        }
    }

    public void registerUserListener(UserListener listener) {
        if (this._listeners == null) {
            this._listeners = new ArrayList();
        }
        this._listeners.add(listener);
    }
}
