package org.eclipse.jetty.security;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import org.eclipse.jetty.security.AbstractLoginService;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/HashLoginService.class */
public class HashLoginService extends AbstractLoginService {
    private static final Logger LOG = Log.getLogger(HashLoginService.class);
    private String _config;
    private UserStore _userStore;
    private boolean hotReload = false;
    private boolean _userStoreAutoCreate = false;

    public HashLoginService() {
    }

    public HashLoginService(String name) {
        setName(name);
    }

    public HashLoginService(String name, String config) {
        setName(name);
        setConfig(config);
    }

    public String getConfig() {
        return this._config;
    }

    @Deprecated
    public Resource getConfigResource() {
        return null;
    }

    public void setConfig(String config) {
        this._config = config;
    }

    public boolean isHotReload() {
        return this.hotReload;
    }

    public void setHotReload(boolean enable) {
        if (isRunning()) {
            throw new IllegalStateException("Cannot set hot reload while user store is running");
        }
        this.hotReload = enable;
    }

    public void setUserStore(UserStore userStore) {
        updateBean(this._userStore, userStore);
        this._userStore = userStore;
    }

    @Override // org.eclipse.jetty.security.AbstractLoginService
    protected String[] loadRoleInfo(AbstractLoginService.UserPrincipal user) {
        Set<AbstractLoginService.RolePrincipal> roles;
        UserIdentity id = this._userStore.getUserIdentity(user.getName());
        if (id == null || (roles = id.getSubject().getPrincipals(AbstractLoginService.RolePrincipal.class)) == null) {
            return null;
        }
        return (String[]) ((List) roles.stream().map(rolePrincipal -> {
            return rolePrincipal.getName();
        }).collect(Collectors.toList())).toArray(new String[roles.size()]);
    }

    @Override // org.eclipse.jetty.security.AbstractLoginService
    protected AbstractLoginService.UserPrincipal loadUserInfo(String userName) {
        UserIdentity id = this._userStore.getUserIdentity(userName);
        if (id != null) {
            return (AbstractLoginService.UserPrincipal) id.getUserPrincipal();
        }
        return null;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        doStart();
        if (this._userStore == null) {
            if (LOG.isDebugEnabled()) {
                LOG.debug("doStart: Starting new PropertyUserStore. PropertiesFile: " + this._config + " hotReload: " + this.hotReload, new Object[0]);
            }
            PropertyUserStore propertyUserStore = new PropertyUserStore();
            propertyUserStore.setHotReload(this.hotReload);
            propertyUserStore.setConfigPath(this._config);
            setUserStore(propertyUserStore);
            this._userStoreAutoCreate = true;
        }
    }

    UserStore getUserStore() {
        return this._userStore;
    }

    boolean isUserStoreAutoCreate() {
        return this._userStoreAutoCreate;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        doStop();
        if (this._userStoreAutoCreate) {
            setUserStore(null);
            this._userStoreAutoCreate = false;
        }
    }
}
