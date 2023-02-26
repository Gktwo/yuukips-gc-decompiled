package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DelTeamEntityNotifyOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDelTeamEntityNotify.class */
public class PacketDelTeamEntityNotify extends BasePacket {
    public PacketDelTeamEntityNotify(int sceneId, int teamEntityId) {
        super(363);
        setData(DelTeamEntityNotifyOuterClass.DelTeamEntityNotify.newBuilder().setSceneId(sceneId).addDelEntityIdList(teamEntityId).build());
    }

    public PacketDelTeamEntityNotify(int sceneId, List<Integer> list) {
        super(363);
        setData(DelTeamEntityNotifyOuterClass.DelTeamEntityNotify.newBuilder().setSceneId(sceneId).addAllDelEntityIdList(list).build());
    }
}
