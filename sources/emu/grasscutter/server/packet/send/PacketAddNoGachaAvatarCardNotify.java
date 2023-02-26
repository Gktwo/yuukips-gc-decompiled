package emu.grasscutter.server.packet.send;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.AddNoGachaAvatarCardNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAddNoGachaAvatarCardNotify.class */
public class PacketAddNoGachaAvatarCardNotify extends BasePacket {
    public PacketAddNoGachaAvatarCardNotify(Avatar avatar, ActionReason reason, GameItem item) {
        super(1669, true);
        AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotify proto = AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotify.newBuilder().setAvatarId(avatar.getAvatarId()).setReason(reason.getValue()).setInitialLevel(1).setItemId(item.getItemId()).setInitialPromoteLevel(0).build();
        Grasscutter.getLogger().warn("PacketAddNoGachaAvatarCardNotify1: {}", Integer.valueOf(avatar.getAvatarId()));
        setData(proto);
    }

    public PacketAddNoGachaAvatarCardNotify(int avatarId, ActionReason reason, GameItem item) {
        super(1669, true);
        AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotify proto = AddNoGachaAvatarCardNotifyOuterClass.AddNoGachaAvatarCardNotify.newBuilder().setAvatarId(avatarId).setReason(reason.getValue()).setInitialLevel(1).setItemId(item.getItemId()).setInitialPromoteLevel(0).build();
        Grasscutter.getLogger().warn("PacketAddNoGachaAvatarCardNotify2: {}", Integer.valueOf(avatarId));
        setData(proto);
    }
}
