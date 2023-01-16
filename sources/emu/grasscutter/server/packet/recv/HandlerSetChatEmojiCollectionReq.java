package emu.grasscutter.server.packet.recv;

import emu.grasscutter.net.packet.Opcodes;
import emu.grasscutter.net.packet.PacketHandler;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.SetChatEmojiCollectionReqOuterClass;
import emu.grasscutter.server.game.GameSession;
import emu.grasscutter.server.packet.send.PacketSetChatEmojiCollectionRsp;

@Opcodes(PacketOpcodes.SetChatEmojiCollectionReq)
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/recv/HandlerSetChatEmojiCollectionReq.class */
public class HandlerSetChatEmojiCollectionReq extends PacketHandler {
    @Override // emu.grasscutter.net.packet.PacketHandler
    public void handle(GameSession session, byte[] header, byte[] payload) throws Exception {
        session.getPlayer().setChatEmojiIdList(SetChatEmojiCollectionReqOuterClass.SetChatEmojiCollectionReq.parseFrom(payload).getChatEmojiCollectionData().getEmojiIdListList());
        session.send(new PacketSetChatEmojiCollectionRsp());
    }
}
