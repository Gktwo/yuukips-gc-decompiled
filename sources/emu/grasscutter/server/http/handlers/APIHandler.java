package emu.grasscutter.server.http.handlers;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.command.CommandHandler;
import emu.grasscutter.command.CommandMap;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.http.Router;
import emu.grasscutter.server.http.objects.JsonRequest;
import emu.grasscutter.server.http.objects.JsonResponse;
import emu.grasscutter.utils.RateLimiter;
import emu.grasscutter.utils.Utils;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import org.quartz.jobs.NativeJob;
import p013io.javalin.Javalin;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/handlers/APIHandler.class */
public final class APIHandler implements Router {
    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        javalin.get("/api/command", APIHandler::commandRes);
        javalin.post("/opencommand/api", APIHandler::commandRes);
    }

    private static void commandRes(Context ctx) {
        String address = Utils.getClientIpAddress(ctx);
        String player_id = "";
        String token = "";
        String runcmd = "";
        boolean isOpenCommand = false;
        if (Objects.equals(ctx.endpointHandlerPath(), "/opencommand/api")) {
            JsonRequest req = (JsonRequest) ctx.bodyAsClass(JsonRequest.class);
            if (req.action.equals("verify")) {
                String[] acc = req.token.split("\\|", -1);
                if (acc.length == 2) {
                    player_id = acc[0];
                    token = acc[1];
                    runcmd = "help";
                } else {
                    ctx.json(new JsonResponse(403, "Format must be [uid|code] get code in-game /remote on"));
                    return;
                }
            } else if (req.action.equals("ping")) {
                ctx.json(new JsonResponse());
                return;
            } else if (req.action.equals("sendCode")) {
                ctx.json(new JsonResponse(403, "Use Console Tab instead Player Tab!"));
                return;
            } else if (req.action.equals(NativeJob.PROP_COMMAND)) {
                String[] acc2 = req.token.split("\\|", -1);
                if (acc2.length == 2) {
                    player_id = acc2[0];
                    token = acc2[1];
                    runcmd = (String) req.data;
                    isOpenCommand = true;
                } else {
                    ctx.json(new JsonResponse(403, "Go back to remote tab and set [uid|code] on token"));
                }
            } else {
                ctx.json(new JsonResponse(403, "Access denied2"));
                return;
            }
        } else {
            token = ctx.queryParam("token");
            player_id = ctx.queryParam("player");
            runcmd = ctx.queryParam("cmd");
        }
        try {
            RateLimiter.rateLimit(player_id, Utils.getClientIpAddress(ctx), 1, TimeUnit.MINUTES, 20);
            if (player_id == null || player_id.isEmpty()) {
                ctx.json(new JsonResponse(404, "no player id found"));
            } else if (token == null || token.isEmpty()) {
                ctx.json(new JsonResponse(404, "no token found"));
            } else if (runcmd == null || runcmd.isEmpty()) {
                ctx.json(new JsonResponse(404, "cmd no found"));
            } else {
                try {
                    int tmp_id = Integer.parseInt(player_id);
                    Grasscutter.getLogger().info("Player Remote {}: (ID {}) (Token {}) run {}", address, player_id, token, runcmd);
                    Player sender = Grasscutter.getGameServer().getPlayerByUid(tmp_id);
                    if (sender == null) {
                        if (!Configuration.GAME_INFO.serverAccount.token_private.contains(token)) {
                            if (isOpenCommand) {
                                ctx.json(new JsonResponse(200, "", "Error: This player is not online"));
                                return;
                            } else {
                                ctx.json(new JsonResponse(201, "This player is not online"));
                                return;
                            }
                        }
                    } else if (Configuration.GAME_INFO.serverAccount.token_public.contains(token)) {
                        CommandHandler.sendMessage(sender, "(Token Public) Someone accessed command from outside.");
                    } else if (sender.getAccount().getTokenAPI() == null || sender.getAccount().getTokenAPI().isEmpty()) {
                        ctx.json(new JsonResponse(403, "Code not set. use /remote on from in-game"));
                        return;
                    } else if (!sender.getAccount().getTokenAPI().contains(token)) {
                        ctx.json(new JsonResponse(403, "Wrong remote access code"));
                        return;
                    } else {
                        CommandHandler.sendMessage(sender, "(Code) Someone accessed command from outside, if this is not yours please change passcode.");
                    }
                    CommandMap.getInstance().invoke(sender, null, runcmd);
                    if (isOpenCommand) {
                        ctx.json(new JsonResponse(200, "", "Succeed"));
                    } else {
                        ctx.json(new JsonResponse());
                    }
                } catch (Exception e) {
                    ctx.json(new JsonResponse(403, "Player must use uid not username/email"));
                }
            }
        } catch (Exception e2) {
            if (isOpenCommand) {
                ctx.json(new JsonResponse(200, "", "Error: Can only run 20 commands per minute"));
                Grasscutter.getLogger().info("{} has been rate limit using commands from OpenCommand", address);
                return;
            }
            ctx.json(new JsonResponse(403, "Can only run 20 commands per minute"));
            Grasscutter.getLogger().info("{} has been rate limit using commands from API Web", address);
        }
    }
}
