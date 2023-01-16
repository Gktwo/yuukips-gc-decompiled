package emu.grasscutter.tools;

import emu.grasscutter.net.proto.GetGachaInfoRspOuterClass;
import emu.grasscutter.net.proto.GetShopRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/tools/Dumpers.class */
public final class Dumpers {
    public static void extractBanner(byte[] data) throws Exception {
        System.out.println(GetGachaInfoRspOuterClass.GetGachaInfoRsp.parseFrom(data));
    }

    public static void extractShop(byte[] data) throws Exception {
        System.out.println(GetShopRspOuterClass.GetShopRsp.parseFrom(data));
    }
}
