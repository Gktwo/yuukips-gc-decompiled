package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.props.FetterState;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.AvatarFetterDataNotifyOuterClass;
import emu.grasscutter.net.proto.AvatarFetterInfoOuterClass;
import emu.grasscutter.net.proto.FetterDataOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketAvatarFetterDataNotify.class */
public class PacketAvatarFetterDataNotify extends BasePacket {
    public PacketAvatarFetterDataNotify(Avatar avatar) {
        super(PacketOpcodes.AvatarFetterDataNotify);
        int fetterLevel = avatar.getFetterLevel();
        AvatarFetterInfoOuterClass.AvatarFetterInfo.Builder avatarFetter = AvatarFetterInfoOuterClass.AvatarFetterInfo.newBuilder().setExpLevel(avatar.getFetterLevel());
        if (fetterLevel != 10) {
            avatarFetter.setExpNumber(avatar.getFetterExp());
        }
        if (avatar.getFetterList() != null) {
            for (int i = 0; i < avatar.getFetterList().size(); i++) {
                avatarFetter.addFetterList(FetterDataOuterClass.FetterData.newBuilder().setFetterId(avatar.getFetterList().get(i).intValue()).setFetterState(FetterState.FINISH.getValue()));
            }
        }
        if (avatar.getPlayer().getNameCardList().contains(Integer.valueOf(avatar.getNameCardId()))) {
            avatarFetter.addRewardedFetterLevelList(10);
        }
        setData(AvatarFetterDataNotifyOuterClass.AvatarFetterDataNotify.newBuilder().putFetterInfoMap(avatar.getGuid(), avatarFetter.build()).build());
    }
}
