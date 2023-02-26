package emu.grasscutter.server.packet.send;

import com.google.protobuf.ByteString;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.proto.PlayerLoginRspOuterClass;
import emu.grasscutter.net.proto.QueryCurrRegionHttpRspOuterClass;
import emu.grasscutter.net.proto.RegionInfoOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.http.dispatch.RegionHandler;
import emu.grasscutter.utils.Crypto;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerLoginRsp.class */
public class PacketPlayerLoginRsp extends BasePacket {
    private static QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp regionCache;

    public PacketPlayerLoginRsp(GameSession session) {
        super(198, 1);
        RegionInfoOuterClass.RegionInfo info;
        setUseDispatchKey(true);
        if (regionCache == null) {
            RegionInfoOuterClass.RegionInfo serverRegion = RegionInfoOuterClass.RegionInfo.newBuilder().setGateserverIp(Configuration.m1214lr(Configuration.GAME_INFO.accessAddress, Configuration.GAME_INFO.bindAddress)).setGateserverPort(Configuration.m1216lr(Configuration.GAME_INFO.accessPort, Configuration.GAME_INFO.bindPort)).setSecretKey(ByteString.copyFrom(Crypto.DISPATCH_SEED)).build();
            QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp tes1 = RegionHandler.getCurrentRegion();
            if (tes1 == null) {
                info = serverRegion;
            } else {
                info = tes1.getRegionInfo();
            }
            regionCache = QueryCurrRegionHttpRspOuterClass.QueryCurrRegionHttpRsp.newBuilder().setRegionInfo(info).build();
        }
        RegionInfoOuterClass.RegionInfo info2 = regionCache.getRegionInfo();
        setData(PlayerLoginRspOuterClass.PlayerLoginRsp.newBuilder().setIsUseAbilityHash(true).setAbilityHashCode(1844674).setGameBiz("hk4e_global").setClientDataVersion(info2.getClientDataVersion()).setClientSilenceDataVersion(info2.getClientSilenceDataVersion()).setClientMd5(info2.getClientDataMd5()).setClientSilenceMd5(info2.getClientSilenceDataMd5()).setResVersionConfig(info2.getResVersionConfig()).setClientVersionSuffix(info2.getClientVersionSuffix()).setClientSilenceVersionSuffix(info2.getClientSilenceVersionSuffix()).setIsScOpen(false).setScInfo(ByteString.copyFrom(new byte[0])).setRegisterCps("mihoyo").setCountryCode("US").build().toByteArray());
    }
}
