package emu.grasscutter.server.packet.recv;

import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ReadMailNotifyOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketMailChangeNotify;
import java.util.ArrayList;
import java.util.List;

@Opcodes(PacketOpcodes.ReadMailNotify)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerReadMailNotify.class */
public class HandlerReadMailNotify extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        ReadMailNotifyOuterClass.ReadMailNotify req = ReadMailNotifyOuterClass.ReadMailNotify.parseFrom(payload);
        List<Mail> updatedMail = new ArrayList<>();
        for (Integer num : req.getMailIdListList()) {
            int mailId = num.intValue();
            Mail message = session.getPlayer().getMail(mailId);
            message.isRead = true;
            session.getPlayer().replaceMailByIndex(mailId, message);
            updatedMail.add(message);
        }
        session.send(new PacketMailChangeNotify(session.getPlayer(), updatedMail));
    }
}
