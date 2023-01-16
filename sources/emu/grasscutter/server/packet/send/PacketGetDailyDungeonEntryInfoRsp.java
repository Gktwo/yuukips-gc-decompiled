package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.DungeonEntryData;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.DailyDungeonEntryInfoOuterClass;
import emu.grasscutter.net.proto.DungeonEntryInfoOuterClass;
import emu.grasscutter.net.proto.GetDailyDungeonEntryInfoRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetDailyDungeonEntryInfoRsp.class */
public class PacketGetDailyDungeonEntryInfoRsp extends BasePacket {
    public PacketGetDailyDungeonEntryInfoRsp(Integer sceneID) {
        super(953);
        GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRsp.Builder resp = GetDailyDungeonEntryInfoRspOuterClass.GetDailyDungeonEntryInfoRsp.newBuilder();
        for (DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo info : GameData.getDungeonEntryDataMap().values().parallelStream().filter(d -> {
            return d.getSceneId() == sceneID.intValue();
        }).map(this::getDungonEntryInfo).toList()) {
            resp.addDailyDungeonInfoList(info);
        }
        setData(resp.build());
    }

    private DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo getDungonEntryInfo(DungeonEntryData data) {
        int dungeonEntryId = data.getDungeonEntryId();
        int id = data.getId();
        DungeonEntryInfoOuterClass.DungeonEntryInfo dungeonEntryInfo = DungeonEntryInfoOuterClass.DungeonEntryInfo.newBuilder().setDungeonId(130).build();
        DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.Builder builder = DailyDungeonEntryInfoOuterClass.DailyDungeonEntryInfo.newBuilder();
        builder.setDungeonEntryId(dungeonEntryId);
        builder.setDungeonEntryConfigId(id);
        builder.setRecommendDungeonEntryInfo(dungeonEntryInfo);
        return builder.build();
    }
}
