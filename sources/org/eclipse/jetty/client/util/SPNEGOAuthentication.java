package org.eclipse.jetty.client.util;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Path;
import java.security.PrivilegedAction;
import java.util.Arrays;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;
import javax.security.auth.Subject;
import javax.security.auth.callback.Callback;
import javax.security.auth.callback.CallbackHandler;
import javax.security.auth.callback.PasswordCallback;
import javax.security.auth.login.AppConfigurationEntry;
import javax.security.auth.login.Configuration;
import javax.security.auth.login.LoginContext;
import javax.security.auth.login.LoginException;
import org.eclipse.jetty.client.api.Authentication;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.util.Attributes;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.ietf.jgss.GSSContext;
import org.ietf.jgss.GSSManager;

/* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication.class */
public class SPNEGOAuthentication extends AbstractAuthentication {
    private static final Logger LOG = Log.getLogger(SPNEGOAuthentication.class);
    private static final String NEGOTIATE = HttpHeader.NEGOTIATE.asString();
    private final GSSManager gssManager = GSSManager.getInstance();
    private String userName;
    private String userPassword;
    private Path userKeyTabPath;
    private String serviceName;
    private boolean useTicketCache;
    private Path ticketCachePath;
    private boolean renewTGT;

    public SPNEGOAuthentication(URI uri) {
        super(uri, Authentication.ANY_REALM);
    }

    @Override // org.eclipse.jetty.client.util.AbstractAuthentication
    public String getType() {
        return NEGOTIATE;
    }

    public String getUserName() {
        return this.userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPassword() {
        return this.userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public Path getUserKeyTabPath() {
        return this.userKeyTabPath;
    }

    public void setUserKeyTabPath(Path userKeyTabPath) {
        this.userKeyTabPath = userKeyTabPath;
    }

    public String getServiceName() {
        return this.serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public boolean isUseTicketCache() {
        return this.useTicketCache;
    }

    public void setUseTicketCache(boolean useTicketCache) {
        this.useTicketCache = useTicketCache;
    }

    public Path getTicketCachePath() {
        return this.ticketCachePath;
    }

    public void setTicketCachePath(Path ticketCachePath) {
        this.ticketCachePath = ticketCachePath;
    }

    public boolean isRenewTGT() {
        return this.renewTGT;
    }

    public void setRenewTGT(boolean renewTGT) {
        this.renewTGT = renewTGT;
    }

    @Override // org.eclipse.jetty.client.api.Authentication
    public Authentication.Result authenticate(Request request, ContentResponse response, Authentication.HeaderInfo headerInfo, Attributes context) {
        SPNEGOContext spnegoContext = (SPNEGOContext) context.getAttribute(SPNEGOContext.ATTRIBUTE);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Authenticate with context {}", spnegoContext);
        }
        if (spnegoContext == null) {
            spnegoContext = login();
            context.setAttribute(SPNEGOContext.ATTRIBUTE, spnegoContext);
        }
        String b64Input = headerInfo.getBase64();
        byte[] output = (byte[]) Subject.doAs(spnegoContext.subject, initGSSContext(spnegoContext, request.getHost(), b64Input == null ? new byte[0] : Base64.getDecoder().decode(b64Input)));
        return new SPNEGOResult(null, output == null ? null : new String(Base64.getEncoder().encode(output)));
    }

    private SPNEGOContext login() {
        try {
            String user = getUserName();
            if (LOG.isDebugEnabled()) {
                LOG.debug("Logging in user {}", user);
            }
            LoginContext loginContext = new LoginContext("", (Subject) null, new PasswordCallbackHandler(), new SPNEGOConfiguration());
            loginContext.login();
            Subject subject = loginContext.getSubject();
            SPNEGOContext spnegoContext = new SPNEGOContext();
            spnegoContext.subject = subject;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Initialized {}", spnegoContext);
            }
            return spnegoContext;
        } catch (LoginException x) {
            throw new RuntimeException(x);
        }
    }

    private PrivilegedAction<byte[]> initGSSContext(SPNEGOContext spnegoContext, String host, byte[] bytes) {
        return ()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0009: RETURN  
              (wrap: java.security.PrivilegedAction<byte[]> : 0x0004: INVOKE_CUSTOM (r0v1 java.security.PrivilegedAction<byte[]> A[REMOVE]) = 
              (r5v0 'this' org.eclipse.jetty.client.util.SPNEGOAuthentication A[D('this' org.eclipse.jetty.client.util.SPNEGOAuthentication), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r6v0 'spnegoContext' org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext A[D('spnegoContext' org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext), DONT_INLINE])
              (r7v0 'host' java.lang.String A[D('host' java.lang.String), DONT_INLINE])
              (r8v0 'bytes' byte[] A[D('bytes' byte[]), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.security.PrivilegedAction.run():java.lang.Object
             call insn: ?: INVOKE  
              (r0 I:org.eclipse.jetty.client.util.SPNEGOAuthentication)
              (r1 I:org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext)
              (r2 I:java.lang.String)
              (r3 I:byte[])
             type: DIRECT call: org.eclipse.jetty.client.util.SPNEGOAuthentication.lambda$initGSSContext$0(org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext, java.lang.String, byte[]):byte[])
             in method: org.eclipse.jetty.client.util.SPNEGOAuthentication.initGSSContext(org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext, java.lang.String, byte[]):java.security.PrivilegedAction<byte[]>, file: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication.class
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
            Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
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
            r0 = r5
            r1 = r6
            r2 = r7
            r3 = r8
            java.security.PrivilegedAction<byte[]> r0 = () -> { // java.security.PrivilegedAction.run():java.lang.Object
                return r0.lambda$initGSSContext$0(r1, r2, r3);
            }
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.client.util.SPNEGOAuthentication.initGSSContext(org.eclipse.jetty.client.util.SPNEGOAuthentication$SPNEGOContext, java.lang.String, byte[]):java.security.PrivilegedAction");
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication$SPNEGOResult.class */
    public static class SPNEGOResult implements Authentication.Result {
        private final URI uri;
        private final HttpHeader header;
        private final String value;

        public SPNEGOResult(URI uri, String token) {
            this(uri, HttpHeader.AUTHORIZATION, token);
        }

        public SPNEGOResult(URI uri, HttpHeader header, String token) {
            this.uri = uri;
            this.header = header;
            this.value = SPNEGOAuthentication.NEGOTIATE + (token == null ? "" : " " + token);
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public URI getURI() {
            return this.uri;
        }

        @Override // org.eclipse.jetty.client.api.Authentication.Result
        public void apply(Request request) {
            request.header(this.header, this.value);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication$SPNEGOContext.class */
    public static class SPNEGOContext {
        private static final String ATTRIBUTE = SPNEGOContext.class.getName();
        private Subject subject;
        private GSSContext gssContext;

        private SPNEGOContext() {
        }

        public String toString() {
            return String.format("%s@%x[context=%s]", getClass().getSimpleName(), Integer.valueOf(hashCode()), this.gssContext);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication$PasswordCallbackHandler.class */
    public class PasswordCallbackHandler implements CallbackHandler {
        private PasswordCallbackHandler() {
        }

        @Override // javax.security.auth.callback.CallbackHandler
        public void handle(Callback[] callbacks) throws IOException {
            Stream stream = Arrays.stream(callbacks);
            Objects.requireNonNull(PasswordCallback.class);
            Stream filter = stream.filter((v1) -> {
                return r1.isInstance(v1);
            });
            Objects.requireNonNull(PasswordCallback.class);
            ((PasswordCallback) filter.map((v1) -> {
                return r1.cast(v1);
            }).findAny().filter(c -> {
                return c.getPrompt().contains(SPNEGOAuthentication.this.getUserName());
            }).orElseThrow(IOException::new)).setPassword(SPNEGOAuthentication.this.getUserPassword().toCharArray());
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/client/util/SPNEGOAuthentication$SPNEGOConfiguration.class */
    public class SPNEGOConfiguration extends Configuration {
        private SPNEGOConfiguration() {
        }

        public AppConfigurationEntry[] getAppConfigurationEntry(String name) {
            Map<String, Object> options = new HashMap<>();
            if (SPNEGOAuthentication.LOG.isDebugEnabled()) {
                options.put("debug", C3P0Substitutions.DEBUG);
            }
            options.put("refreshKrb5Config", C3P0Substitutions.DEBUG);
            options.put("principal", SPNEGOAuthentication.this.getUserName());
            options.put("isInitiator", C3P0Substitutions.DEBUG);
            Path keyTabPath = SPNEGOAuthentication.this.getUserKeyTabPath();
            if (keyTabPath != null) {
                options.put("doNotPrompt", C3P0Substitutions.DEBUG);
                options.put("useKeyTab", C3P0Substitutions.DEBUG);
                options.put("keyTab", keyTabPath.toAbsolutePath().toString());
                options.put("storeKey", C3P0Substitutions.DEBUG);
            }
            if (SPNEGOAuthentication.this.isUseTicketCache()) {
                options.put("useTicketCache", C3P0Substitutions.DEBUG);
                Path ticketCachePath = SPNEGOAuthentication.this.getTicketCachePath();
                if (ticketCachePath != null) {
                    options.put("ticketCache", ticketCachePath.toAbsolutePath().toString());
                }
                options.put("renewTGT", String.valueOf(SPNEGOAuthentication.this.isRenewTGT()));
            }
            return new AppConfigurationEntry[]{new AppConfigurationEntry("com.sun.security.auth.module.Krb5LoginModule", AppConfigurationEntry.LoginModuleControlFlag.REQUIRED, options)};
        }
    }
}
