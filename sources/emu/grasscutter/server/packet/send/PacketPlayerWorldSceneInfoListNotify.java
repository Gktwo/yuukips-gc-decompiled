package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass;
import emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass;
import java.util.stream.IntStream;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerWorldSceneInfoListNotify.class */
public class PacketPlayerWorldSceneInfoListNotify extends BasePacket {
    public PacketPlayerWorldSceneInfoListNotify() {
        super(PacketOpcodes.PlayerWorldSceneInfoListNotify);
        setData(PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.newBuilder().addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(1).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(3).setIsLocked(false).addSceneTagIdList(102).addSceneTagIdList(113).addSceneTagIdList(117).addSceneTagIdList(1093).addSceneTagIdList(152).addSceneTagIdList(153).addSceneTagIdList(1164).addSceneTagIdList(1166).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(4).setIsLocked(false).addSceneTagIdList(106).addSceneTagIdList(109).addSceneTagIdList(117).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(5).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(6).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(7).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(9).setIsLocked(false).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).build()));
    }
}
