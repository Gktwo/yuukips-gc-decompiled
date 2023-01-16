package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketSetChatEmojiCollectionRsp.class */
public class PacketSetChatEmojiCollectionRsp extends BasePacket {
    public PacketSetChatEmojiCollectionRsp() {
        super(PacketOpcodes.SetChatEmojiCollectionRsp);
    }
}
