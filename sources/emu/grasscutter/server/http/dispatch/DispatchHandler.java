package emu.grasscutter.server.http.dispatch;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.auth.AuthenticationSystem;
import emu.grasscutter.auth.OAuthAuthenticator;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.objects.ComboTokenReqJson;
import emu.grasscutter.server.http.objects.LoginAccountRequestJson;
import emu.grasscutter.server.http.objects.LoginTokenRequestJson;
import emu.grasscutter.utils.JsonUtils;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/dispatch/DispatchHandler.class */
public final class DispatchHandler implements Router {
    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        javalin.post("/hk4e_global/mdk/shield/api/login", DispatchHandler::clientLogin);
        javalin.post("/hk4e_global/mdk/shield/api/verify", DispatchHandler::tokenLogin);
        javalin.post("/hk4e_global/combo/granter/login/v2/login", DispatchHandler::sessionKeyLogin);
        javalin.get("/authentication/type", ctx -> {
            ctx.result(Grasscutter.getAuthenticationSystem().getClass().getSimpleName());
        });
        javalin.post("/authentication/login", ctx -> {
            Grasscutter.getAuthenticationSystem().getExternalAuthenticator().handleLogin(AuthenticationSystem.fromExternalRequest(ctx));
        });
        javalin.post("/authentication/register", ctx -> {
            Grasscutter.getAuthenticationSystem().getExternalAuthenticator().handleAccountCreation(AuthenticationSystem.fromExternalRequest(ctx));
        });
        javalin.post("/authentication/change_password", ctx -> {
            Grasscutter.getAuthenticationSystem().getExternalAuthenticator().handlePasswordReset(AuthenticationSystem.fromExternalRequest(ctx));
        });
        javalin.post("/hk4e_global/mdk/shield/api/loginByThirdparty", ctx -> {
            Grasscutter.getAuthenticationSystem().getOAuthAuthenticator().handleLogin(AuthenticationSystem.fromExternalRequest(ctx));
        });
        javalin.get("/authentication/openid/redirect", ctx -> {
            Grasscutter.getAuthenticationSystem().getOAuthAuthenticator().handleTokenProcess(AuthenticationSystem.fromExternalRequest(ctx));
        });
        javalin.get("/Api/twitter_login", ctx -> {
            Grasscutter.getAuthenticationSystem().getOAuthAuthenticator().handleRedirection(AuthenticationSystem.fromExternalRequest(ctx), OAuthAuthenticator.ClientType.DESKTOP);
        });
        javalin.get("/sdkTwitterLogin.html", ctx -> {
            Grasscutter.getAuthenticationSystem().getOAuthAuthenticator().handleRedirection(AuthenticationSystem.fromExternalRequest(ctx), OAuthAuthenticator.ClientType.MOBILE);
        });
    }

    private static void clientLogin(Context ctx) {
        ctx.json(Grasscutter.getAuthenticationSystem().getPasswordAuthenticator().authenticate(AuthenticationSystem.fromPasswordRequest(ctx, (LoginAccountRequestJson) JsonUtils.decode(ctx.body(), LoginAccountRequestJson.class))));
    }

    private static void tokenLogin(Context ctx) {
        LoginTokenRequestJson bodyData = (LoginTokenRequestJson) JsonUtils.decode(ctx.body(), LoginTokenRequestJson.class);
        if (bodyData != null) {
            ctx.json(Grasscutter.getAuthenticationSystem().getTokenAuthenticator().authenticate(AuthenticationSystem.fromTokenRequest(ctx, bodyData)));
        }
    }

    private static void sessionKeyLogin(Context ctx) {
        ComboTokenReqJson bodyData = (ComboTokenReqJson) JsonUtils.decode(ctx.body(), ComboTokenReqJson.class);
        ctx.json(Grasscutter.getAuthenticationSystem().getSessionKeyAuthenticator().authenticate(AuthenticationSystem.fromComboTokenRequest(ctx, bodyData, (ComboTokenReqJson.LoginTokenData) JsonUtils.decode(bodyData.data, ComboTokenReqJson.LoginTokenData.class))));
    }
}
