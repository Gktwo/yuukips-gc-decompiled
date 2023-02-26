package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ScenePlayerLocationNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketScenePlayerLocationNotify.class */
public class PacketScenePlayerLocationNotify extends BasePacket {
    public PacketScenePlayerLocationNotify(Scene scene) {
        super(278);
        if (scene != null) {
            ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotify.Builder proto = ScenePlayerLocationNotifyOuterClass.ScenePlayerLocationNotify.newBuilder().setSceneId(scene.getId());
            for (Player p : scene.getPlayers()) {
                proto.addPlayerLocList(p.getPlayerLocationInfo());
            }
            setData(proto);
        }
    }
}
