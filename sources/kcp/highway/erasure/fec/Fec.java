package kcp.highway.erasure.fec;

import emu.grasscutter.net.packet.PacketOpcodes;

/* loaded from: grasscutter.jar:kcp/highway/erasure/fec/Fec.class */
public class Fec {
    public static int fecHeaderSize = 6;
    public static int fecDataSize = 2;
    public static int fecHeaderSizePlus2 = fecHeaderSize + fecDataSize;
    public static int typeData = PacketOpcodes.PlayerEnterSceneInfoNotify;
    public static int typeParity = 242;
}
