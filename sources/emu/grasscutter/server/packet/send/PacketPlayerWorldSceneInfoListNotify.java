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
        setData(PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.newBuilder().addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(1).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(2).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(3).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(4).setIsLocked(false).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(5).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(7).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(9).setIsLocked(false).addAllSceneTagIdList(IntStream.range(0, 3000).boxed().toList()).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(20154).setIsLocked(false).addSceneTagIdList(1179).build()));
    }
}
