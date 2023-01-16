package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatInfoOuterClass;
import emu.grasscutter.net.proto.PlayerChatNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerChatNotify.class */
public class PacketPlayerChatNotify extends BasePacket {
    public PacketPlayerChatNotify(Player sender, int channelId, String message) {
        super(PacketOpcodes.PlayerChatNotify);
        setData(PlayerChatNotifyOuterClass.PlayerChatNotify.newBuilder().setChannelId(channelId).setChatInfo(ChatInfoOuterClass.ChatInfo.newBuilder().setTime((int) (System.currentTimeMillis() / 1000)).setUid(sender.getUid()).setText(message).build()).build());
    }

    public PacketPlayerChatNotify(Player sender, int channelId, int emote) {
        super(PacketOpcodes.PlayerChatNotify);
        setData(PlayerChatNotifyOuterClass.PlayerChatNotify.newBuilder().setChannelId(channelId).setChatInfo(ChatInfoOuterClass.ChatInfo.newBuilder().setTime((int) (System.currentTimeMillis() / 1000)).setUid(sender.getUid()).setIcon(emote).build()).build());
    }

    public PacketPlayerChatNotify(Player sender, int channelId, ChatInfoOuterClass.ChatInfo.SystemHint systemHint) {
        super(PacketOpcodes.PlayerChatNotify);
        setData(PlayerChatNotifyOuterClass.PlayerChatNotify.newBuilder().setChannelId(channelId).setChatInfo(ChatInfoOuterClass.ChatInfo.newBuilder().setTime((int) (System.currentTimeMillis() / 1000)).setUid(sender.getUid()).setSystemHint(systemHint).build()).build());
    }
}
