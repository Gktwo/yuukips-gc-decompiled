package emu.grasscutter.auth;

import emu.grasscutter.game.Account;
import emu.grasscutter.server.http.objects.ComboTokenReqJson;
import emu.grasscutter.server.http.objects.ComboTokenResJson;
import emu.grasscutter.server.http.objects.LoginAccountRequestJson;
import emu.grasscutter.server.http.objects.LoginResultJson;
import emu.grasscutter.server.http.objects.LoginTokenRequestJson;
import org.jetbrains.annotations.Nullable;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/auth/AuthenticationSystem.class */
public interface AuthenticationSystem {
    void createAccount(String str, String str2);

    void resetPassword(String str);

    Account verifyUser(String str);

    Authenticator<LoginResultJson> getPasswordAuthenticator();

    Authenticator<LoginResultJson> getTokenAuthenticator();

    Authenticator<ComboTokenResJson> getSessionKeyAuthenticator();

    ExternalAuthenticator getExternalAuthenticator();

    OAuthAuthenticator getOAuthAuthenticator();

    /* loaded from: grasscutter.jar:emu/grasscutter/auth/AuthenticationSystem$AuthenticationRequest.class */
    public static class AuthenticationRequest {
        private final Context context;
        @Nullable
        private final LoginAccountRequestJson passwordRequest;
        @Nullable
        private final LoginTokenRequestJson tokenRequest;
        @Nullable
        private final ComboTokenReqJson sessionKeyRequest;
        @Nullable
        private final ComboTokenReqJson.LoginTokenData sessionKeyData;

        /* loaded from: grasscutter.jar:emu/grasscutter/auth/AuthenticationSystem$AuthenticationRequest$AuthenticationRequestBuilder.class */
        public static class AuthenticationRequestBuilder {
            private Context context;
            private LoginAccountRequestJson passwordRequest;
            private LoginTokenRequestJson tokenRequest;
            private ComboTokenReqJson sessionKeyRequest;
            private ComboTokenReqJson.LoginTokenData sessionKeyData;

            /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-5, r-4, r-3, r-2, r-1
                java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
                	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
                	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
                	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
                */
            /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.auth.AuthenticationSystem.AuthenticationRequest.AuthenticationRequestBuilder.toString():java.lang.String
                jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lio/javalin/http/Context;, Lemu/grasscutter/server/http/objects/LoginAccountRequestJson;, Lemu/grasscutter/server/http/objects/LoginTokenRequestJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson$LoginTokenData;)Ljava/lang/String;}, AuthenticationSystem.AuthenticationRequest.AuthenticationRequestBuilder(context=, passwordRequest=, tokenRequest=, sessionKeyRequest=, sessionKeyData=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
                	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
                	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
                	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
                	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
                	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
                	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
                	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lio/javalin/http/Context;, Lemu/grasscutter/server/http/objects/LoginAccountRequestJson;, Lemu/grasscutter/server/http/objects/LoginTokenRequestJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson$LoginTokenData;)Ljava/lang/String;}, AuthenticationSystem.AuthenticationRequest.AuthenticationRequestBuilder(context=, passwordRequest=, tokenRequest=, sessionKeyRequest=, sessionKeyData=)]}
                	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
                	... 8 more
                */
            public java.lang.String toString() {
                /*
                    r6 = this;
                    r0 = r6
                    io.javalin.http.Context r0 = r0.context
                    r1 = r6
                    emu.grasscutter.server.http.objects.LoginAccountRequestJson r1 = r1.passwordRequest
                    r2 = r6
                    emu.grasscutter.server.http.objects.LoginTokenRequestJson r2 = r2.tokenRequest
                    r3 = r6
                    emu.grasscutter.server.http.objects.ComboTokenReqJson r3 = r3.sessionKeyRequest
                    r4 = r6
                    emu.grasscutter.server.http.objects.ComboTokenReqJson$LoginTokenData r4 = r4.sessionKeyData
                    // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lio/javalin/http/Context;, Lemu/grasscutter/server/http/objects/LoginAccountRequestJson;, Lemu/grasscutter/server/http/objects/LoginTokenRequestJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson;, Lemu/grasscutter/server/http/objects/ComboTokenReqJson$LoginTokenData;)Ljava/lang/String;}, AuthenticationSystem.AuthenticationRequest.AuthenticationRequestBuilder(context=, passwordRequest=, tokenRequest=, sessionKeyRequest=, sessionKeyData=)]}
                    return r0
                */
                throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.auth.AuthenticationSystem.AuthenticationRequest.AuthenticationRequestBuilder.toString():java.lang.String");
            }

            AuthenticationRequestBuilder() {
            }

            public AuthenticationRequestBuilder context(Context context) {
                this.context = context;
                return this;
            }

            public AuthenticationRequestBuilder passwordRequest(@Nullable LoginAccountRequestJson passwordRequest) {
                this.passwordRequest = passwordRequest;
                return this;
            }

            public AuthenticationRequestBuilder tokenRequest(@Nullable LoginTokenRequestJson tokenRequest) {
                this.tokenRequest = tokenRequest;
                return this;
            }

            public AuthenticationRequestBuilder sessionKeyRequest(@Nullable ComboTokenReqJson sessionKeyRequest) {
                this.sessionKeyRequest = sessionKeyRequest;
                return this;
            }

            public AuthenticationRequestBuilder sessionKeyData(@Nullable ComboTokenReqJson.LoginTokenData sessionKeyData) {
                this.sessionKeyData = sessionKeyData;
                return this;
            }

            public AuthenticationRequest build() {
                return new AuthenticationRequest(this.context, this.passwordRequest, this.tokenRequest, this.sessionKeyRequest, this.sessionKeyData);
            }
        }

        public static AuthenticationRequestBuilder builder() {
            return new AuthenticationRequestBuilder();
        }

        public AuthenticationRequest(Context context, @Nullable LoginAccountRequestJson passwordRequest, @Nullable LoginTokenRequestJson tokenRequest, @Nullable ComboTokenReqJson sessionKeyRequest, @Nullable ComboTokenReqJson.LoginTokenData sessionKeyData) {
            this.context = context;
            this.passwordRequest = passwordRequest;
            this.tokenRequest = tokenRequest;
            this.sessionKeyRequest = sessionKeyRequest;
            this.sessionKeyData = sessionKeyData;
        }

        public Context getContext() {
            return this.context;
        }

        @Nullable
        public LoginAccountRequestJson getPasswordRequest() {
            return this.passwordRequest;
        }

        @Nullable
        public LoginTokenRequestJson getTokenRequest() {
            return this.tokenRequest;
        }

        @Nullable
        public ComboTokenReqJson getSessionKeyRequest() {
            return this.sessionKeyRequest;
        }

        @Nullable
        public ComboTokenReqJson.LoginTokenData getSessionKeyData() {
            return this.sessionKeyData;
        }
    }

    static AuthenticationRequest fromPasswordRequest(Context ctx, LoginAccountRequestJson jsonData) {
        return AuthenticationRequest.builder().context(ctx).passwordRequest(jsonData).build();
    }

    static AuthenticationRequest fromTokenRequest(Context ctx, LoginTokenRequestJson jsonData) {
        return AuthenticationRequest.builder().context(ctx).tokenRequest(jsonData).build();
    }

    static AuthenticationRequest fromComboTokenRequest(Context ctx, ComboTokenReqJson jsonData, ComboTokenReqJson.LoginTokenData tokenData) {
        return AuthenticationRequest.builder().context(ctx).sessionKeyRequest(jsonData).sessionKeyData(tokenData).build();
    }

    static AuthenticationRequest fromExternalRequest(Context ctx) {
        return AuthenticationRequest.builder().context(ctx).build();
    }
}
