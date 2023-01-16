package emu.grasscutter.server.packet.send;

import com.google.protobuf.ByteString;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.GetPlayerTokenRspOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.utils.Crypto;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetPlayerTokenRsp.class */
public class PacketGetPlayerTokenRsp extends BasePacket {
    public PacketGetPlayerTokenRsp(GameSession session) {
        super(130, true);
        setUseDispatchKey(true);
        setData(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.newBuilder().setUid(session.getPlayer().getUid()).setToken(session.getAccount().getToken()).setAccountType(1).setIsProficientPlayer(session.getPlayer().getAvatars().getAvatarCount() > 0).setSecretKeySeed(Crypto.ENCRYPT_SEED).setSecurityCmdBuffer(ByteString.copyFrom(Crypto.ENCRYPT_SEED_BUFFER)).setPlatformType(3).setChannelId(1).setCountryCode("US").setClientVersionRandomKey("c25-314dd05b0b5f").setRegPlatform(3).setClientIpStr(session.getAddress()).build().toByteArray());
    }

    public PacketGetPlayerTokenRsp(GameSession session, int retcode, String msg, int blackEndTime) {
        super(130, true);
        setUseDispatchKey(true);
        setData(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.newBuilder().setUid(session.getPlayer().getUid()).setIsProficientPlayer(session.getPlayer().getAvatars().getAvatarCount() > 0).setRetcode(retcode).setMsg(msg).setBlackUidEndTime(blackEndTime).setRegPlatform(3).setCountryCode("US").setClientIpStr(session.getAddress()).build().toByteArray());
    }

    public PacketGetPlayerTokenRsp(GameSession session, String encryptedSeed, String encryptedSeedSign) {
        super(130, true);
        setUseDispatchKey(true);
        setData(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.newBuilder().setUid(session.getPlayer().getUid()).setToken(session.getAccount().getToken()).setAccountType(1).setIsProficientPlayer(session.getPlayer().getAvatars().getAvatarCount() > 0).setSecretKeySeed(Crypto.ENCRYPT_SEED).setSecurityCmdBuffer(ByteString.copyFrom(Crypto.ENCRYPT_SEED_BUFFER)).setPlatformType(3).setChannelId(1).setCountryCode("US").setClientVersionRandomKey("c25-314dd05b0b5f").setRegPlatform(3).setClientIpStr(session.getAddress()).setServerRandKey(encryptedSeed).setSign(encryptedSeedSign).build().toByteArray());
    }

    public PacketGetPlayerTokenRsp(int retcode, String msg) {
        super(130, true);
        setUseDispatchKey(true);
        setData(GetPlayerTokenRspOuterClass.GetPlayerTokenRsp.newBuilder().setRetcode(retcode).setMsg(msg).setRegPlatform(3).setCountryCode("US").build().toByteArray());
    }
}
