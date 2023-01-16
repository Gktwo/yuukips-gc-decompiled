package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.binout.SceneNpcBornEntry;
import emu.grasscutter.game.quest.QuestGroupSuite;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.GroupSuiteNotifyOuterClass;
import java.util.Collection;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGroupSuiteNotify.class */
public class PacketGroupSuiteNotify extends BasePacket {
    public PacketGroupSuiteNotify(List<SceneNpcBornEntry> npcBornEntries) {
        super(PacketOpcodes.GroupSuiteNotify);
        GroupSuiteNotifyOuterClass.GroupSuiteNotify.Builder proto = GroupSuiteNotifyOuterClass.GroupSuiteNotify.newBuilder();
        npcBornEntries.stream().filter(x -> {
            return x.getGroupId() > 0 && x.getSuiteIdList() != null;
        }).forEach(x -> {
            x.getSuiteIdList().forEach(y -> {
                proto.putGroupMap(x.getGroupId(), y.intValue());
            });
        });
        setData(proto);
    }

    public PacketGroupSuiteNotify(int groupId, int suiteId) {
        super(PacketOpcodes.GroupSuiteNotify);
        GroupSuiteNotifyOuterClass.GroupSuiteNotify.Builder proto = GroupSuiteNotifyOuterClass.GroupSuiteNotify.newBuilder();
        proto.putGroupMap(groupId, suiteId);
        setData(proto);
    }

    public PacketGroupSuiteNotify(Collection<QuestGroupSuite> questGroupSuites) {
        super(PacketOpcodes.GroupSuiteNotify);
        GroupSuiteNotifyOuterClass.GroupSuiteNotify.Builder proto = GroupSuiteNotifyOuterClass.GroupSuiteNotify.newBuilder();
        questGroupSuites.forEach(i -> {
            proto.putGroupMap(i.getGroup(), i.getSuite());
        });
        setData(proto);
    }
}
