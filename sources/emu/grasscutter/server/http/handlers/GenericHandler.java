package emu.grasscutter.server.http.handlers;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.objects.JsonResponse;
import emu.grasscutter.server.http.objects.StatusServer;
import emu.grasscutter.server.http.objects.WebStaticVersionResponse;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/handlers/GenericHandler.class */
public final class GenericHandler implements Router {
    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        javalin.get("/*/mdk/agreement/api/getAgreementInfos", new JsonResponse(0, "OK", "{\"marketing_agreements\":[]}"));
        allRoutes(javalin, "/*/combo/granter/api/compareProtocolVersion", new JsonResponse(0, "OK", "{\"modified\":true,\"protocol\":{\"id\":0,\"app_id\":4,\"language\":\"en\",\"user_proto\":\"\",\"priv_proto\":\"\",\"major\":7,\"minimum\":0,\"create_time\":\"0\",\"teenager_proto\":\"\",\"third_proto\":\"\"}}"));
        allRoutes(javalin, "/account/risky/api/check", new JsonResponse(0, "OK", "{\"id\":\"none\",\"action\":\"ACTION_NONE\",\"geetest\":null}"));
        javalin.get("/combo/box/api/config/sdk/combo", new JsonResponse(0, "OK", "{\"vals\":{\"disable_email_bind_skip\":\"false\",\"email_bind_remind_interval\":\"7\",\"email_bind_remind\":\"true\"}}"));
        javalin.get("/*/combo/granter/api/getConfig", new JsonResponse(0, "OK", "{\"protocol\":true,\"qr_enabled\":false,\"log_level\":\"INFO\",\"announce_url\":\"https://webstatic-sea.hoyoverse.com/hk4e/announcement/index.html?sdk_presentation_style=fullscreen\\u0026sdk_screen_transparent=true\\u0026game_biz=hk4e_global\\u0026auth_appid=announcement\\u0026game=hk4e#/\",\"push_alias_type\":2,\"disable_ysdk_guard\":false,\"enable_announce_pic_popup\":true}"));
        allRoutes(javalin, "/*/mdk/shield/api/loadConfig", new JsonResponse(0, "OK", "{\"id\":6,\"game_key\":\"hk4e_global\",\"client\":\"PC\",\"identity\":\"I_IDENTITY\",\"guest\":false,\"ignore_versions\":\"\",\"scene\":\"S_NORMAL\",\"name\":\"原神海外\",\"disable_regist\":false,\"enable_email_captcha\":false,\"thirdparty\":[\"fb\",\"tw\"],\"disable_mmt\":false,\"server_guest\":false,\"thirdparty_ignore\":{\"tw\":\"\",\"fb\":\"\"},\"enable_ps_bind_account\":false,\"thirdparty_login_configs\":{\"tw\":{\"token_type\":\"TK_GAME_TOKEN\",\"game_token_expires_in\":604800},\"fb\":{\"token_type\":\"TK_GAME_TOKEN\",\"game_token_expires_in\":604800}}}"));
        javalin.get("/admin/mi18n/plat_oversea/*", new WebStaticVersionResponse());
        javalin.get("/api/ping", new JsonResponse());
        javalin.get("/status/server", GenericHandler::serverStatus);
    }

    private static void serverStatus(Context ctx) {
        try {
            ctx.json(new StatusServer().getOutput());
        } catch (Exception e) {
            Grasscutter.getLogger().error("Error Status: ", (Throwable) e);
            ctx.json(new JsonResponse(404, "Error Get Status"));
        }
    }
}
