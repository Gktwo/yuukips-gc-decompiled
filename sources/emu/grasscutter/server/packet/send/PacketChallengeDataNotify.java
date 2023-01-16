package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChallengeDataNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketChallengeDataNotify.class */
public class PacketChallengeDataNotify extends BasePacket {
    public PacketChallengeDataNotify(WorldChallenge challenge, int index, int value) {
        super(PacketOpcodes.ChallengeDataNotify);
        setData(ChallengeDataNotifyOuterClass.ChallengeDataNotify.newBuilder().setChallengeIndex(challenge.getChallengeIndex()).setParamIndex(index).setValue(value).build());
    }
}
