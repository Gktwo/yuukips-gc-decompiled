package org.eclipse.jetty.security;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.Serializable;
import java.net.InetAddress;
import java.nio.file.Path;
import java.security.PrivilegedAction;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import javax.security.auth.Subject;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.eclipse.jetty.security.authentication.AuthorizationService;
import org.eclipse.jetty.server.UserIdentity;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSCredential;
import org.ietf.jgss.GSSException;
import org.ietf.jgss.GSSManager;

/* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConfigurableSpnegoLoginService.class */
public class ConfigurableSpnegoLoginService extends ContainerLifeCycle implements LoginService {
    private static final Logger LOG = Log.getLogger(ConfigurableSpnegoLoginService.class);
    private final String _realm;
    private final AuthorizationService _authorizationService;
    private String _serviceName;
    private Path _keyTabPath;
    private String _hostName;
    private SpnegoContext _context;
    private final GSSManager _gssManager = GSSManager.getInstance();
    private IdentityService _identityService = new DefaultIdentityService();

    public ConfigurableSpnegoLoginService(String realm, AuthorizationService authorizationService) {
        this._realm = realm;
        this._authorizationService = authorizationService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public String getName() {
        return this._realm;
    }

    public Path getKeyTabPath() {
        return this._keyTabPath;
    }

    public void setKeyTabPath(Path keyTabFile) {
        this._keyTabPath = keyTabFile;
    }

    public String getServiceName() {
        return this._serviceName;
    }

    public void setServiceName(String serviceName) {
        this._serviceName = serviceName;
    }

    public String getHostName() {
        return this._hostName;
    }

    public void setHostName(String hostName) {
        this._hostName = hostName;
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._hostName == null) {
            this._hostName = InetAddress.getLocalHost().getCanonicalHostName();
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Retrieving credentials for service {}/{}", getServiceName(), getHostName());
        }
        LoginContext loginContext = new LoginContext("", (Subject) null, (CallbackHandler) null, new SpnegoConfiguration());
        loginContext.login();
        Subject subject = loginContext.getSubject();
        this._context = (SpnegoContext) Subject.doAs(subject, newSpnegoContext(subject));
        doStart();
    }

    private PrivilegedAction<SpnegoContext> newSpnegoContext(Subject subject) {
        return ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0007: RETURN  
              (wrap: java.security.PrivilegedAction<org.eclipse.jetty.security.ConfigurableSpnegoLoginService$SpnegoContext> : 0x0002: INVOKE_CUSTOM (r0v1 java.security.PrivilegedAction<org.eclipse.jetty.security.ConfigurableSpnegoLoginService$SpnegoContext> A[REMOVE]) = 
              (r3v0 'this' org.eclipse.jetty.security.ConfigurableSpnegoLoginService A[D('this' org.eclipse.jetty.security.ConfigurableSpnegoLoginService), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r4v0 'subject' javax.security.auth.Subject A[D('subject' javax.security.auth.Subject), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.security.PrivilegedAction.run():java.lang.Object
             call insn: ?: INVOKE  (r0 I:org.eclipse.jetty.security.ConfigurableSpnegoLoginService), (r1 I:javax.security.auth.Subject) type: DIRECT call: org.eclipse.jetty.security.ConfigurableSpnegoLoginService.lambda$newSpnegoContext$0(javax.security.auth.Subject):org.eclipse.jetty.security.ConfigurableSpnegoLoginService$SpnegoContext)
             in method: org.eclipse.jetty.security.ConfigurableSpnegoLoginService.newSpnegoContext(javax.security.auth.Subject):java.security.PrivilegedAction<org.eclipse.jetty.security.ConfigurableSpnegoLoginService$SpnegoContext>, file: grasscutter.jar:org/eclipse/jetty/security/ConfigurableSpnegoLoginService.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 1 out of bounds for length 1
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:343)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 15 more
            */
        /*
            this = this;
            r0 = r3
            r1 = r4
            java.security.PrivilegedAction<org.eclipse.jetty.security.ConfigurableSpnegoLoginService$SpnegoContext> r0 = () -> { // java.security.PrivilegedAction.run():java.lang.Object
                return r0.lambda$newSpnegoContext$0(r1);
            }
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.security.ConfigurableSpnegoLoginService.newSpnegoContext(javax.security.auth.Subject):java.security.PrivilegedAction");
    }

    @Override // org.eclipse.jetty.security.LoginService
    public UserIdentity login(String username, Object credentials, ServletRequest req) {
        Subject subject = this._context._subject;
        HttpServletRequest request = (HttpServletRequest) req;
        HttpSession httpSession = request.getSession(false);
        GSSContext gssContext = null;
        if (httpSession != null) {
            GSSContextHolder holder = (GSSContextHolder) httpSession.getAttribute(GSSContextHolder.ATTRIBUTE);
            gssContext = holder == null ? null : holder.gssContext;
        }
        if (gssContext == null) {
            gssContext = (GSSContext) Subject.doAs(subject, newGSSContext());
        }
        String token = Base64.getEncoder().encodeToString((byte[]) Subject.doAs(this._context._subject, acceptGSSContext(gssContext, Base64.getDecoder().decode((String) credentials))));
        String userName = toUserName(gssContext);
        SpnegoUserPrincipal principal = new SpnegoUserPrincipal(userName, token);
        if (gssContext.isEstablished()) {
            if (httpSession != null) {
                httpSession.removeAttribute(GSSContextHolder.ATTRIBUTE);
            }
            return new SpnegoUserIdentity(subject, principal, this._authorizationService.getUserIdentity(request, userName));
        }
        if (httpSession == null) {
            httpSession = request.getSession(true);
        }
        httpSession.setAttribute(GSSContextHolder.ATTRIBUTE, new GSSContextHolder(gssContext));
        return new SpnegoUserIdentity(subject, principal, null);
    }

    private PrivilegedAction<GSSContext> newGSSContext() {
        return () -> {
            try {
                return this._gssManager.createContext(this._context._serviceCredential);
            } catch (GSSException x) {
                throw new RuntimeException((Throwable) x);
            }
        };
    }

    private PrivilegedAction<byte[]> acceptGSSContext(GSSContext gssContext, byte[] token) {
        return () -> {
            try {
                return gssContext.acceptSecContext(token, 0, token.length);
            } catch (GSSException x) {
                throw new RuntimeException((Throwable) x);
            }
        };
    }

    private String toUserName(GSSContext gssContext) {
        try {
            String name = gssContext.getSrcName().toString();
            int at = name.indexOf(64);
            if (at < 0) {
                return name;
            }
            return name.substring(0, at);
        } catch (GSSException x) {
            throw new RuntimeException((Throwable) x);
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
    public void setIdentityService(IdentityService identityService) {
        this._identityService = identityService;
    }

    @Override // org.eclipse.jetty.security.LoginService
    public void logout(UserIdentity user) {
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConfigurableSpnegoLoginService$SpnegoConfiguration.class */
    private class SpnegoConfiguration extends Configuration {
        private SpnegoConfiguration() {
        }

        public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
            Object principal = ConfigurableSpnegoLoginService.this.getServiceName() + "/" + ConfigurableSpnegoLoginService.this.getHostName();
            Map<String, Object> options = new HashMap<>();
            if (ConfigurableSpnegoLoginService.LOG.isDebugEnabled()) {
                options.put("debug", C3P0Substitutions.DEBUG);
            }
            options.put("doNotPrompt", C3P0Substitutions.DEBUG);
            options.put("refreshKrb5Config", C3P0Substitutions.DEBUG);
            options.put("principal", principal);
            options.put("useKeyTab", C3P0Substitutions.DEBUG);
            Path keyTabPath = ConfigurableSpnegoLoginService.this.getKeyTabPath();
            if (keyTabPath != null) {
                options.put("keyTab", keyTabPath.toAbsolutePath().toString());
            }
            options.put("storeKey", C3P0Substitutions.DEBUG);
            options.put("isInitiator", "false");
            return new AppConfigurationEntry[]{new AppConfigurationEntry("com.sun.security.auth.module.Krb5LoginModule", AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, options)};
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConfigurableSpnegoLoginService$SpnegoContext.class */
    public static class SpnegoContext {
        private Subject _subject;
        private GSSCredential _serviceCredential;

        private SpnegoContext() {
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/security/ConfigurableSpnegoLoginService$GSSContextHolder.class */
    private static class GSSContextHolder implements Serializable {
        public static final String ATTRIBUTE = GSSContextHolder.class.getName();
        private final transient GSSContext gssContext;

        private GSSContextHolder(GSSContext gssContext) {
            this.gssContext = gssContext;
        }
    }
}
