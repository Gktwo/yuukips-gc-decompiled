package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ActivityShopData;
import emu.grasscutter.game.activity.ActivityConfigItem;
import emu.grasscutter.game.activity.ActivityManager;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityShopSheetInfoOuterClass;
import emu.grasscutter.net.proto.GetActivityShopSheetInfoRspOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetActivityShopSheetInfoRsp.class */
public class PacketGetActivityShopSheetInfoRsp extends BasePacket {
    public PacketGetActivityShopSheetInfoRsp(int shopType) {
        super(PacketOpcodes.GetActivityShopSheetInfoRsp);
        ActivityShopData sheetInfo = GameData.getActivityShopDataMap().get(shopType);
        ActivityConfigItem activityConfigItem = sheetInfo != null ? ActivityManager.getScheduleActivityConfigMap().get(Integer.valueOf(sheetInfo.getScheduleId())) : null;
        if (sheetInfo == null || activityConfigItem == null) {
            setData(GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRsp.newBuilder().setShopType(shopType).setRetcode(RetcodeOuterClass.Retcode.RET_SHOP_NOT_OPEN_VALUE).build());
            return;
        }
        List<ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo> sheetInfos = new ArrayList<>(sheetInfo.getSheetList().size());
        for (Integer num : sheetInfo.getSheetList()) {
            sheetInfos.add(ActivityShopSheetInfoOuterClass.ActivityShopSheetInfo.newBuilder().setSheetId(num.intValue()).setBeginTime(activityConfigItem.getBeginTime()).setEndTime(activityConfigItem.getEndTime()).build());
        }
        setData(GetActivityShopSheetInfoRspOuterClass.GetActivityShopSheetInfoRsp.newBuilder().setShopType(shopType).addAllSheetInfoList(sheetInfos).build());
    }
}
