package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ChatEmojiCollectionDataOuterClass;
import emu.grasscutter.net.proto.GetChatEmojiCollectionRspOuterClass;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetChatEmojiCollectionRsp.class */
public class PacketGetChatEmojiCollectionRsp extends BasePacket {
    public PacketGetChatEmojiCollectionRsp(List<Integer> emojiIds) {
        super(PacketOpcodes.GetChatEmojiCollectionRsp);
        setData(GetChatEmojiCollectionRspOuterClass.GetChatEmojiCollectionRsp.newBuilder().setChatEmojiCollectionData(ChatEmojiCollectionDataOuterClass.ChatEmojiCollectionData.newBuilder().addAllEmojiIdList(emojiIds).build()));
    }
}
