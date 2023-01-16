package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AllWidgetDataNotifyOuterClass;
import emu.grasscutter.net.proto.LunchBoxDataOuterClass;
import emu.grasscutter.net.proto.WidgetSlotDataOuterClass;
import emu.grasscutter.net.proto.WidgetSlotTagOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAllWidgetDataNotify.class */
public class PacketAllWidgetDataNotify extends BasePacket {
    public PacketAllWidgetDataNotify(Player player) {
        super(PacketOpcodes.AllWidgetDataNotify);
        AllWidgetDataNotifyOuterClass.AllWidgetDataNotify.Builder proto = AllWidgetDataNotifyOuterClass.AllWidgetDataNotify.newBuilder().setLunchBoxData(LunchBoxDataOuterClass.LunchBoxData.newBuilder().build()).addAllOneoffGatherPointDetectorDataList(List.of()).addAllCoolDownGroupDataList(List.of()).addAllAnchorPointList(List.of()).addAllClientCollectorDataList(List.of()).addAllNormalCoolDownDataList(List.of());
        if (player.getWidgetId() == 0) {
            proto.addAllSlotList(List.of());
        } else {
            proto.addSlotList(WidgetSlotDataOuterClass.WidgetSlotData.newBuilder().setIsActive(true).setMaterialId(player.getWidgetId()).build());
            proto.addSlotList(WidgetSlotDataOuterClass.WidgetSlotData.newBuilder().setTag(WidgetSlotTagOuterClass.WidgetSlotTag.WIDGET_SLOT_TAG_ATTACH_AVATAR).build());
        }
        setData(proto.build());
    }
}
