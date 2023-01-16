package emu.grasscutter.game.player;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.ForwardTypeOuterClass;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/player/InvokeHandler.class */
public class InvokeHandler<T> {
    private final List<T> entryListForwardAll = new ArrayList();
    private final List<T> entryListForwardAllExceptCur = new ArrayList();
    private final List<T> entryListForwardHost = new ArrayList();
    private final Class<? extends BasePacket> packetClass;

    public InvokeHandler(Class<? extends BasePacket> packetClass) {
        this.packetClass = packetClass;
    }

    public synchronized void addEntry(ForwardTypeOuterClass.ForwardType forward, T entry) {
        switch (forward) {
            case FORWARD_TYPE_TO_ALL:
                this.entryListForwardAll.add(entry);
                return;
            case FORWARD_TYPE_TO_ALL_EXCEPT_CUR:
            case FORWARD_TYPE_TO_ALL_EXIST_EXCEPT_CUR:
                this.entryListForwardAllExceptCur.add(entry);
                return;
            case FORWARD_TYPE_TO_HOST:
                this.entryListForwardHost.add(entry);
                return;
            default:
                return;
        }
    }

    public synchronized void update(Player player) {
        if (player.getWorld() == null || player.getScene() == null) {
            this.entryListForwardAll.clear();
            this.entryListForwardAllExceptCur.clear();
            this.entryListForwardHost.clear();
            return;
        }
        try {
            if (this.entryListForwardAll.size() > 0) {
                player.getScene().broadcastPacket((BasePacket) this.packetClass.getDeclaredConstructor(List.class).newInstance(this.entryListForwardAll));
                this.entryListForwardAll.clear();
            }
            if (this.entryListForwardAllExceptCur.size() > 0) {
                player.getScene().broadcastPacketToOthers(player, (BasePacket) this.packetClass.getDeclaredConstructor(List.class).newInstance(this.entryListForwardAllExceptCur));
                this.entryListForwardAllExceptCur.clear();
            }
            if (this.entryListForwardHost.size() > 0) {
                player.getWorld().getHost().sendPacket((BasePacket) this.packetClass.getDeclaredConstructor(List.class).newInstance(this.entryListForwardHost));
                this.entryListForwardHost.clear();
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("InvokeHandler error:", (Throwable) e);
        }
    }
}
