package org.eclipse.jetty.security;

import java.io.IOException;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.security.Authenticator;
import org.eclipse.jetty.security.authentication.DeferredAuthentication;
import org.eclipse.jetty.server.Authentication;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.HandlerWrapper;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/SecurityHandler.class */
public abstract class SecurityHandler extends HandlerWrapper implements Authenticator.AuthConfiguration {
    private static final Logger LOG = Log.getLogger(SecurityHandler.class);
    private static final List<Authenticator.Factory> __knownAuthenticatorFactories = new ArrayList();
    private Authenticator _authenticator;
    private Authenticator.Factory _authenticatorFactory;
    private String _realmName;
    private String _authMethod;
    private LoginService _loginService;
    private IdentityService _identityService;
    public static final Principal __NO_USER;
    public static final Principal __NOBODY;
    private boolean _checkWelcomeFiles = false;
    private final Map<String, String> _initParameters = new HashMap();
    private boolean _renewSession = true;

    protected abstract RoleInfo prepareConstraintInfo(String str, Request request);

    protected abstract boolean checkUserDataPermissions(String str, Request request, Response response, RoleInfo roleInfo) throws IOException;

    protected abstract boolean isAuthMandatory(Request request, Response response, Object obj);

    protected abstract boolean checkWebResourcePermissions(String str, Request request, Response response, Object obj, UserIdentity userIdentity) throws IOException;

    static {
        Iterator<Authenticator.Factory> serviceLoaderIterator = ServiceLoader.load(Authenticator.Factory.class).iterator();
        while (serviceLoaderIterator.hasNext()) {
            try {
                __knownAuthenticatorFactories.add(serviceLoaderIterator.next());
            } catch (ServiceConfigurationError error) {
                LOG.warn("Error while loading AuthenticatorFactory with ServiceLoader", error);
            }
        }
        __knownAuthenticatorFactories.add(new DefaultAuthenticatorFactory());
        __NO_USER = new Principal() { // from class: org.eclipse.jetty.security.SecurityHandler.1
            @Override // java.security.Principal
            public String getName() {
                return null;
            }

            @Override // java.security.Principal, java.lang.Object
            public String toString() {
                return "No User";
            }
        };
        __NOBODY = new Principal() { // from class: org.eclipse.jetty.security.SecurityHandler.2
            @Override // java.security.Principal
            public String getName() {
                return "Nobody";
            }

            @Override // java.security.Principal, java.lang.Object
            public String toString() {
                return getName();
            }
        };
    }

    /* access modifiers changed from: protected */
    public SecurityHandler() {
        addBean(new DumpableCollection("knownAuthenticatorFactories", __knownAuthenticatorFactories));
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public IdentityService getIdentityService() {
        return this._identityService;
    }

    public void setIdentityService(IdentityService identityService) {
        if (isStarted()) {
            throw new IllegalStateException("Started");
        }
        updateBean(this._identityService, identityService);
        this._identityService = identityService;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public LoginService getLoginService() {
        return this._loginService;
    }

    public void setLoginService(LoginService loginService) {
        if (isStarted()) {
            throw new IllegalStateException("Started");
        }
        updateBean(this._loginService, loginService);
        this._loginService = loginService;
    }

    public Authenticator getAuthenticator() {
        return this._authenticator;
    }

    public void setAuthenticator(Authenticator authenticator) {
        if (isStarted()) {
            throw new IllegalStateException("Started");
        }
        updateBean(this._authenticator, authenticator);
        this._authenticator = authenticator;
        if (this._authenticator != null) {
            this._authMethod = this._authenticator.getAuthMethod();
        }
    }

    public Authenticator.Factory getAuthenticatorFactory() {
        return this._authenticatorFactory;
    }

    public void setAuthenticatorFactory(Authenticator.Factory authenticatorFactory) {
        if (isRunning()) {
            throw new IllegalStateException("running");
        }
        updateBean(this._authenticatorFactory, authenticatorFactory);
        this._authenticatorFactory = authenticatorFactory;
    }

    public List<Authenticator.Factory> getKnownAuthenticatorFactories() {
        return __knownAuthenticatorFactories;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getRealmName() {
        return this._realmName;
    }

    public void setRealmName(String realmName) {
        if (isRunning()) {
            throw new IllegalStateException("running");
        }
        this._realmName = realmName;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getAuthMethod() {
        return this._authMethod;
    }

    public void setAuthMethod(String authMethod) {
        if (isRunning()) {
            throw new IllegalStateException("running");
        }
        this._authMethod = authMethod;
    }

    public boolean isCheckWelcomeFiles() {
        return this._checkWelcomeFiles;
    }

    public void setCheckWelcomeFiles(boolean authenticateWelcomeFiles) {
        if (isRunning()) {
            throw new IllegalStateException("running");
        }
        this._checkWelcomeFiles = authenticateWelcomeFiles;
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public String getInitParameter(String key) {
        return this._initParameters.get(key);
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public Set<String> getInitParameterNames() {
        return this._initParameters.keySet();
    }

    public String setInitParameter(String key, String value) {
        if (!isStarted()) {
            return this._initParameters.put(key, value);
        }
        throw new IllegalStateException("started");
    }

    protected LoginService findLoginService() throws Exception {
        Collection<LoginService> list = getServer().getBeans(LoginService.class);
        LoginService service = null;
        String realm = getRealmName();
        if (realm != null) {
            Iterator<LoginService> it = list.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                LoginService s = it.next();
                if (s.getName() != null && s.getName().equals(realm)) {
                    service = s;
                    break;
                }
            }
        } else if (list.size() == 1) {
            service = list.iterator().next();
        }
        return service;
    }

    protected IdentityService findIdentityService() {
        return (IdentityService) getServer().getBean((Class<Object>) IdentityService.class);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        ContextHandler.Context context = ContextHandler.getCurrentContext();
        if (context != null) {
            Enumeration<String> names = context.getInitParameterNames();
            while (names != null && names.hasMoreElements()) {
                String name = names.nextElement();
                if (name.startsWith("org.eclipse.jetty.security.") && getInitParameter(name) == null) {
                    setInitParameter(name, context.getInitParameter(name));
                }
            }
        }
        if (this._loginService == null) {
            setLoginService(findLoginService());
            if (this._loginService != null) {
                unmanage(this._loginService);
            }
        }
        if (this._identityService == null) {
            if (this._loginService != null) {
                setIdentityService(this._loginService.getIdentityService());
            }
            if (this._identityService == null) {
                setIdentityService(findIdentityService());
            }
            if (this._identityService == null) {
                setIdentityService(new DefaultIdentityService());
                manage(this._identityService);
            } else {
                unmanage(this._identityService);
            }
        }
        if (this._loginService != null) {
            if (this._loginService.getIdentityService() == null) {
                this._loginService.setIdentityService(this._identityService);
            } else if (this._loginService.getIdentityService() != this._identityService) {
                throw new IllegalStateException("LoginService has different IdentityService to " + this);
            }
        }
        if (this._authenticator == null) {
            if (this._authenticatorFactory != null) {
                Authenticator authenticator = this._authenticatorFactory.getAuthenticator(getServer(), ContextHandler.getCurrentContext(), this, this._identityService, this._loginService);
                if (authenticator != null) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Created authenticator {} with {}", authenticator, this._authenticatorFactory);
                    }
                    setAuthenticator(authenticator);
                }
            } else {
                Iterator<Authenticator.Factory> it = getKnownAuthenticatorFactories().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    Authenticator.Factory factory = it.next();
                    Authenticator authenticator2 = factory.getAuthenticator(getServer(), ContextHandler.getCurrentContext(), this, this._identityService, this._loginService);
                    if (authenticator2 != null) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Created authenticator {} with {}", authenticator2, factory);
                        }
                        setAuthenticator(authenticator2);
                    }
                }
            }
        }
        if (this._authenticator != null) {
            this._authenticator.setConfiguration(this);
        } else if (this._realmName != null) {
            LOG.warn("No Authenticator for " + this, new Object[0]);
            throw new IllegalStateException("No Authenticator");
        }
        doStart();
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        if (!isManaged(this._identityService)) {
            removeBean(this._identityService);
            this._identityService = null;
        }
        if (!isManaged(this._loginService)) {
            removeBean(this._loginService);
            this._loginService = null;
        }
        doStop();
    }

    protected boolean checkSecurity(Request request) {
        switch (request.getDispatcherType()) {
            case REQUEST:
            case ASYNC:
                return true;
            case FORWARD:
                if (!isCheckWelcomeFiles() || request.getAttribute("org.eclipse.jetty.server.welcome") == null) {
                    return false;
                }
                request.removeAttribute("org.eclipse.jetty.server.welcome");
                return true;
            default:
                return false;
        }
    }

    @Override // org.eclipse.jetty.security.Authenticator.AuthConfiguration
    public boolean isSessionRenewedOnAuthentication() {
        return this._renewSession;
    }

    public void setSessionRenewedOnAuthentication(boolean renew) {
        this._renewSession = renew;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String pathInContext, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Object previousIdentity;
        Response base_response = baseRequest.getResponse();
        Handler handler = getHandler();
        if (handler != null) {
            Authenticator authenticator = this._authenticator;
            if (checkSecurity(baseRequest)) {
                if (authenticator != null) {
                    authenticator.prepareRequest(baseRequest);
                }
                RoleInfo roleInfo = prepareConstraintInfo(pathInContext, baseRequest);
                if (checkUserDataPermissions(pathInContext, baseRequest, base_response, roleInfo)) {
                    boolean isAuthMandatory = isAuthMandatory(baseRequest, base_response, roleInfo);
                    if (!isAuthMandatory || authenticator != null) {
                        try {
                            previousIdentity = null;
                            try {
                                Authentication authentication = baseRequest.getAuthentication();
                                if (authentication == null || authentication == Authentication.NOT_CHECKED) {
                                    authentication = authenticator == null ? Authentication.UNAUTHENTICATED : authenticator.validateRequest(request, response, isAuthMandatory);
                                }
                                if (authentication instanceof Authentication.Wrapped) {
                                    request = ((Authentication.Wrapped) authentication).getHttpServletRequest();
                                    response = ((Authentication.Wrapped) authentication).getHttpServletResponse();
                                }
                                if (authentication instanceof Authentication.ResponseSent) {
                                    baseRequest.setHandled(true);
                                } else if (authentication instanceof Authentication.User) {
                                    Authentication.User userAuth = (Authentication.User) authentication;
                                    baseRequest.setAuthentication(authentication);
                                    if (this._identityService != null) {
                                        previousIdentity = this._identityService.associate(userAuth.getUserIdentity());
                                    }
                                    if (!isAuthMandatory || checkWebResourcePermissions(pathInContext, baseRequest, base_response, roleInfo, userAuth.getUserIdentity())) {
                                        handler.handle(pathInContext, baseRequest, request, response);
                                        if (authenticator != null) {
                                            authenticator.secureResponse(request, response, isAuthMandatory, userAuth);
                                        }
                                    } else {
                                        response.sendError(403, "!role");
                                        baseRequest.setHandled(true);
                                        if (this._identityService != null) {
                                            this._identityService.disassociate(previousIdentity);
                                            return;
                                        }
                                        return;
                                    }
                                } else if (authentication instanceof Authentication.Deferred) {
                                    DeferredAuthentication deferred = (DeferredAuthentication) authentication;
                                    baseRequest.setAuthentication(authentication);
                                    try {
                                        handler.handle(pathInContext, baseRequest, request, response);
                                        previousIdentity = deferred.getPreviousAssociation();
                                        if (authenticator != null) {
                                            Authentication auth = baseRequest.getAuthentication();
                                            if (auth instanceof Authentication.User) {
                                                authenticator.secureResponse(request, response, isAuthMandatory, (Authentication.User) auth);
                                            } else {
                                                authenticator.secureResponse(request, response, isAuthMandatory, null);
                                            }
                                        }
                                    } catch (Throwable th) {
                                        deferred.getPreviousAssociation();
                                        throw th;
                                    }
                                } else if (isAuthMandatory) {
                                    response.sendError(401, "unauthenticated");
                                    baseRequest.setHandled(true);
                                } else {
                                    baseRequest.setAuthentication(authentication);
                                    if (this._identityService != null) {
                                        previousIdentity = this._identityService.associate(null);
                                    }
                                    handler.handle(pathInContext, baseRequest, request, response);
                                    if (authenticator != null) {
                                        authenticator.secureResponse(request, response, isAuthMandatory, null);
                                    }
                                }
                                if (this._identityService != null) {
                                    this._identityService.disassociate(previousIdentity);
                                }
                            } catch (ServerAuthException e) {
                                response.sendError(500, e.getMessage());
                                if (this._identityService != null) {
                                    this._identityService.disassociate(previousIdentity);
                                }
                            }
                        } catch (Throwable th2) {
                            if (this._identityService != null) {
                                this._identityService.disassociate(previousIdentity);
                            }
                            throw th2;
                        }
                    } else {
                        LOG.warn("No authenticator for: " + roleInfo, new Object[0]);
                        if (!baseRequest.isHandled()) {
                            response.sendError(403);
                            baseRequest.setHandled(true);
                        }
                    }
                } else if (!baseRequest.isHandled()) {
                    response.sendError(403);
                    baseRequest.setHandled(true);
                }
            } else {
                handler.handle(pathInContext, baseRequest, request, response);
            }
        }
    }

    public static SecurityHandler getCurrentSecurityHandler() {
        ContextHandler.Context context = ContextHandler.getCurrentContext();
        if (context == null) {
            return null;
        }
        return (SecurityHandler) context.getContextHandler().getChildHandlerByClass(SecurityHandler.class);
    }

    public void logout(Authentication.User user) {
        LOG.debug("logout {}", user);
        if (user != null) {
            LoginService loginService = getLoginService();
            if (loginService != null) {
                loginService.logout(user.getUserIdentity());
            }
            IdentityService identityService = getIdentityService();
            if (identityService != null) {
                identityService.disassociate(null);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/SecurityHandler$NotChecked.class */
    public class NotChecked implements Principal {
        public NotChecked() {
        }

        @Override // java.security.Principal
        public String getName() {
            return null;
        }

        @Override // java.security.Principal, java.lang.Object
        public String toString() {
            return "NOT CHECKED";
        }

        public SecurityHandler getSecurityHandler() {
            return SecurityHandler.this;
        }
    }
}
