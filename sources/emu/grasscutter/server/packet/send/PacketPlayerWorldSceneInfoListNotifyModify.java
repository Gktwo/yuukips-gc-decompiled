package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.PlayerWorldSceneInfoListNotifyOuterClass;
import emu.grasscutter.net.proto.PlayerWorldSceneInfoOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerWorldSceneInfoListNotifyModify.class */
public class PacketPlayerWorldSceneInfoListNotifyModify extends BasePacket {
    public PacketPlayerWorldSceneInfoListNotifyModify(int sceneId, List<Integer> addedTags) {
        super(PacketOpcodes.PlayerWorldSceneInfoListNotify);
        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder builder = PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(sceneId);
        for (Integer num : addedTags) {
            builder.addSceneTagIdList(num.intValue());
        }
        PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.Builder proto = PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.newBuilder().addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(1).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(3).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(4).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(5).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(6).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(7).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(9).setIsLocked(false).build()).addInfoList(builder.build());
        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder teapot = PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(2005).setIsLocked(false);
        for (int i = 0; i < 3000; i++) {
            teapot.addSceneTagIdList(i);
        }
        proto.addInfoList(teapot);
        setData(proto);
    }

    public PacketPlayerWorldSceneInfoListNotifyModify(int sceneId, int scenetagId) {
        super(PacketOpcodes.PlayerWorldSceneInfoListNotify);
        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder builder = PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(sceneId);
        builder.addSceneTagIdList(scenetagId);
        PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.Builder proto = PlayerWorldSceneInfoListNotifyOuterClass.PlayerWorldSceneInfoListNotify.newBuilder().addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(1).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(3).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(4).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(5).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(6).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(7).setIsLocked(false).build()).addInfoList(PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(9).setIsLocked(false).build()).addInfoList(builder.build());
        PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.Builder teapot = PlayerWorldSceneInfoOuterClass.PlayerWorldSceneInfo.newBuilder().setSceneId(2005).setIsLocked(false);
        for (int i = 0; i < 3000; i++) {
            teapot.addSceneTagIdList(i);
        }
        proto.addInfoList(teapot);
        setData(proto);
    }
}
