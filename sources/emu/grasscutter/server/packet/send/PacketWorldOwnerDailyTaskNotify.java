package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dailytask.DailyTaskManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.WorldOwnerDailyTaskNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketWorldOwnerDailyTaskNotify.class */
public class PacketWorldOwnerDailyTaskNotify extends BasePacket {
    public PacketWorldOwnerDailyTaskNotify(Player player) {
        super(193);
        DailyTaskManager manager = player.getDailyTaskManager();
        WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotify.Builder notify = WorldOwnerDailyTaskNotifyOuterClass.WorldOwnerDailyTaskNotify.newBuilder();
        manager.getDailyTasks().forEach(dailyTask -> {
            notify.addTaskList(dailyTask.toProto());
        });
        notify.setFilterCityId(manager.getCityId());
        setData(notify.build());
    }
}
