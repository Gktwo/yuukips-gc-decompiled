package emu.grasscutter.server.packet.send;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.QueryPathReqOuterClass;
import emu.grasscutter.net.proto.QueryPathRspOuterClass;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketQueryPathRsp.class */
public class PacketQueryPathRsp extends BasePacket {
    public PacketQueryPathRsp(QueryPathReqOuterClass.QueryPathReq req) {
        super(PacketOpcodes.QueryPathRsp);
        if (req.getDestinationPosCount() > 0) {
            QueryPathRspOuterClass.QueryPathRsp.Builder proto = QueryPathRspOuterClass.QueryPathRsp.newBuilder();
            proto.addCorners(req.getSourcePos()).addCorners(req.getDestinationPos(0)).setQueryId(req.getQueryId()).setQueryStatus(QueryPathRspOuterClass.QueryPathRsp.PathStatusType.PATH_STATUS_TYPE_SUCC);
            setData(proto);
            return;
        }
        Grasscutter.getLogger().debug("No Destination Pos");
    }
}
