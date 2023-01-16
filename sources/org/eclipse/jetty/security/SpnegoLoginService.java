package org.eclipse.jetty.security;

import java.util.Base64;
import java.util.Properties;
import javax.security.auth.Subject;
import javax.servlet.ServletRequest;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;
import org.ietf.jgss.Oid;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/security/SpnegoLoginService.class */
public class SpnegoLoginService extends AbstractLifeCycle implements LoginService {
    private static final Logger LOG = Log.getLogger(SpnegoLoginService.class);
    protected IdentityService _identityService;
    protected String _name;
    private String _config;
    private String _targetName;

    public SpnegoLoginService() {
    }

    public SpnegoLoginService(String name) {
        setName(name);
    }

    public SpnegoLoginService(String name, String config) {
        setName(name);
        setConfig(config);
    }

    @Override // org.eclipse.jetty.security.LoginService
    public String getName() {
        return this._name;
    }

    public void setName(String name) {
        if (isRunning()) {
            throw new IllegalStateException("Running");
        }
        this._name = name;
    }

    public String getConfig() {
        return this._config;
    }

    public void setConfig(String config) {
        if (isRunning()) {
            throw new IllegalStateException("Running");
        }
        this._config = config;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        Properties properties = new Properties();
        properties.load(Resource.newResource(this._config).getInputStream());
        this._targetName = properties.getProperty("targetName");
        LOG.debug("Target Name {}", this._targetName);
        doStart();
    }

    @Override // org.eclipse.jetty.security.LoginService
    public UserIdentity login(String username, Object credentials, ServletRequest request) {
        byte[] authToken = Base64.getDecoder().decode((String) credentials);
        GSSManager manager = GSSManager.getInstance();
        try {
            GSSContext gContext = manager.createContext(manager.createCredential(manager.createName(this._targetName, (Oid) null), Integer.MAX_VALUE, new Oid("1.3.6.1.5.5.2"), 2));
            if (gContext == null) {
                LOG.debug("SpnegoUserRealm: failed to establish GSSContext", new Object[0]);
                return null;
            }
            while (!gContext.isEstablished()) {
                authToken = gContext.acceptSecContext(authToken, 0, authToken.length);
            }
            if (!gContext.isEstablished()) {
                return null;
            }
            String clientName = gContext.getSrcName().toString();
            String role = clientName.substring(clientName.indexOf(64) + 1);
            LOG.debug("SpnegoUserRealm: established a security context", new Object[0]);
            LOG.debug("Client Principal is: " + gContext.getSrcName(), new Object[0]);
            LOG.debug("Server Principal is: " + gContext.getTargName(), new Object[0]);
            LOG.debug("Client Default Role: " + role, new Object[0]);
            SpnegoUserPrincipal user = new SpnegoUserPrincipal(clientName, authToken);
            Subject subject = new Subject();
            subject.getPrincipals().add(user);
            return this._identityService.newUserIdentity(subject, user, new String[]{role});
        } catch (GSSException gsse) {
            LOG.warn(gsse);
            return null;
        }
    }

    @Override // org.eclipse.jetty.security.LoginService
    public boolean validate(UserIdentity user) {
        return false;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void setIdentityService(IdentityService service) {
        this._identityService = service;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void logout(UserIdentity user) {
    }
}
