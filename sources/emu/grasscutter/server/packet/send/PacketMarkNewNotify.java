package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.MarkNewNotifyOuterClass;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMarkNewNotify.class */
public class PacketMarkNewNotify extends BasePacket {
    public PacketMarkNewNotify(Player player, int markNewType, ArrayList<Integer> idList) {
        super(1229);
        MarkNewNotifyOuterClass.MarkNewNotify.Builder proto = MarkNewNotifyOuterClass.MarkNewNotify.newBuilder();
        proto.setMarkNewType(markNewType);
        Iterator<Integer> it = idList.iterator();
        while (it.hasNext()) {
            proto.addIdList(it.next().intValue());
        }
        setData(proto.build());
    }
}
