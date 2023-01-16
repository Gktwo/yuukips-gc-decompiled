package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.SetPlayerBirthdayReqOuterClass;
import emu.grasscutter.net.proto.SocialDetailOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketGetPlayerSocialDetailRsp;
import emu.grasscutter.server.packet.send.PacketSetPlayerBirthdayRsp;

@Opcodes(PacketOpcodes.SetPlayerBirthdayReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetPlayerBirthdayReq.class */
public class HandlerSetPlayerBirthdayReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        SetPlayerBirthdayReqOuterClass.SetPlayerBirthdayReq req = SetPlayerBirthdayReqOuterClass.SetPlayerBirthdayReq.parseFrom(payload);
        if (session.getPlayer().hasBirthday()) {
            session.send(new PacketSetPlayerBirthdayRsp((int) RetcodeOuterClass.Retcode.RET_BIRTHDAY_CANNOT_BE_SET_TWICE_VALUE));
            return;
        }
        int month = req.getBirthday().getMonth();
        int day = req.getBirthday().getDay();
        if (!isValidBirthday(month, day)) {
            session.send(new PacketSetPlayerBirthdayRsp((int) RetcodeOuterClass.Retcode.RET_BIRTHDAY_FORMAT_ERROR_VALUE));
            return;
        }
        session.getPlayer().setBirthday(day, month);
        session.getPlayer().save();
        SocialDetailOuterClass.SocialDetail.Builder detail = session.getPlayer().getSocialDetail();
        session.send(new PacketSetPlayerBirthdayRsp(session.getPlayer()));
        session.send(new PacketGetPlayerSocialDetailRsp(detail));
    }

    private boolean isValidBirthday(int month, int day) {
        switch (month) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return (day > 0) & (day <= 31);
            case 2:
                return (day > 0) & (day <= 29);
            case 4:
            case 6:
            case 9:
            case 11:
                return day > 0 && day <= 30;
            default:
                return false;
        }
    }
}
