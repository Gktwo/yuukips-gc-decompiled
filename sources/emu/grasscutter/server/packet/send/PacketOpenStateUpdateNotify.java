package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.player.PlayerProgressManager;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.OpenStateUpdateNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketOpenStateUpdateNotify.class */
public class PacketOpenStateUpdateNotify extends BasePacket {
    public PacketOpenStateUpdateNotify(Player player) {
        super(107);
        OpenStateUpdateNotifyOuterClass.OpenStateUpdateNotify.Builder proto = OpenStateUpdateNotifyOuterClass.OpenStateUpdateNotify.newBuilder();
        GameData.getOpenStateList().stream().map((v0) -> {
            return v0.getId();
        }).forEach(id -> {
            if (player.getOpenStates().containsKey(id)) {
                proto.putOpenStateMap(id.intValue(), player.getProgressManager().getOpenState(id.intValue()));
            } else if (PlayerProgressManager.DEFAULT_OPEN_STATES.contains(id)) {
                proto.putOpenStateMap(id.intValue(), 1);
            }
        });
        setData(proto);
    }

    public PacketOpenStateUpdateNotify() {
        super(107);
        OpenStateUpdateNotifyOuterClass.OpenStateUpdateNotify.Builder proto = OpenStateUpdateNotifyOuterClass.OpenStateUpdateNotify.newBuilder();
        for (int i = 1; i < 5000; i++) {
            proto.putOpenStateMap(i, 1);
        }
        setData(proto);
    }
}
