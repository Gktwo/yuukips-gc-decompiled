package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.CookDataNotifyOuterClass;
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCookDataNotify.class */
public class PacketCookDataNotify extends BasePacket {
    public PacketCookDataNotify(List<CookRecipeDataOuterClass.CookRecipeData> recipes) {
        super(145);
        setData(CookDataNotifyOuterClass.CookDataNotify.newBuilder().addAllRecipeDataList(recipes).build());
    }
}
