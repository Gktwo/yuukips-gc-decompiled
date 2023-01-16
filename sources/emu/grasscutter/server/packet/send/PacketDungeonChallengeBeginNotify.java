package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.dungeons.challenge.WorldChallenge;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.DungeonChallengeBeginNotifyOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketDungeonChallengeBeginNotify.class */
public class PacketDungeonChallengeBeginNotify extends BasePacket {
    public PacketDungeonChallengeBeginNotify(WorldChallenge challenge) {
        super((int) PacketOpcodes.DungeonChallengeBeginNotify, true);
        setData(DungeonChallengeBeginNotifyOuterClass.DungeonChallengeBeginNotify.newBuilder().setChallengeId(challenge.getChallengeId()).setChallengeIndex(challenge.getChallengeIndex()).setGroupId(challenge.getGroup().f957id).addAllParamList(challenge.getParamList()).build());
    }
}
