package emu.grasscutter.game.chat;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.game.GameServer;

/* loaded from: grasscutter.jar:emu/grasscutter/game/chat/ChatSystemHandler.class */
public interface ChatSystemHandler {
    GameServer getServer();

    void sendPrivateMessage(Player player, int i, String str);

    void sendPrivateMessage(Player player, int i, int i2);

    void sendTeamMessage(Player player, int i, String str);

    void sendTeamMessage(Player player, int i, int i2);

    void sendPrivateMessageFromServer(int i, String str);

    void sendPrivateMessageFromServer(int i, int i2);

    void handlePullPrivateChatReq(Player player, int i);

    void clearHistoryOnLogout(Player player);

    void handlePullRecentChatReq(Player player);
}
