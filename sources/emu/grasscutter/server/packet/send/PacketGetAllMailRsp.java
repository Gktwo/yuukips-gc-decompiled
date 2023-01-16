package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EquipParamOuterClass;
import emu.grasscutter.net.proto.GetAllMailRspOuterClass;
import emu.grasscutter.net.proto.MailDataOuterClass;
import emu.grasscutter.net.proto.MailItemOuterClass;
import emu.grasscutter.net.proto.MailTextContentOuterClass;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketGetAllMailRsp.class */
public class PacketGetAllMailRsp extends BasePacket {
    public PacketGetAllMailRsp(Player player, boolean isGiftMail) {
        super(PacketOpcodes.GetAllMailRsp);
        GetAllMailRspOuterClass.GetAllMailRsp.Builder proto = GetAllMailRspOuterClass.GetAllMailRsp.newBuilder();
        if (isGiftMail) {
            proto.setIsCollected(true);
        } else {
            proto.setIsTruncated(false);
            if (player.getAllMail().size() != 0) {
                List<MailDataOuterClass.MailData> mailDataList = new ArrayList<>();
                for (Mail message : player.getAllMail()) {
                    if (message.stateValue == 1 && message.expireTime > ((long) ((int) Instant.now().getEpochSecond())) && mailDataList.size() <= 1000) {
                        MailTextContentOuterClass.MailTextContent.Builder mailTextContent = MailTextContentOuterClass.MailTextContent.newBuilder();
                        mailTextContent.setTitle(message.mailContent.title);
                        mailTextContent.setContent(message.mailContent.content);
                        mailTextContent.setSender(message.mailContent.sender);
                        List<MailItemOuterClass.MailItem> mailItems = new ArrayList<>();
                        for (Mail.MailItem item : message.itemList) {
                            MailItemOuterClass.MailItem.Builder mailItem = MailItemOuterClass.MailItem.newBuilder();
                            EquipParamOuterClass.EquipParam.Builder itemParam = EquipParamOuterClass.EquipParam.newBuilder();
                            itemParam.setItemId(item.itemId);
                            itemParam.setItemNum(item.itemCount);
                            mailItem.setEquipParam(itemParam.build());
                            mailItems.add(mailItem.build());
                        }
                        MailDataOuterClass.MailData.Builder mailData = MailDataOuterClass.MailData.newBuilder();
                        mailData.setMailId(player.getMailId(message));
                        mailData.setMailTextContent(mailTextContent.build());
                        mailData.addAllItemList(mailItems);
                        mailData.setSendTime((int) message.sendTime);
                        mailData.setExpireTime((int) message.expireTime);
                        mailData.setImportance(message.importance);
                        mailData.setIsRead(message.isRead);
                        mailData.setIsAttachmentGot(message.isAttachmentGot);
                        mailData.setCollectStateValue(1);
                        mailDataList.add(mailData.build());
                    }
                }
                proto.addAllMailList(mailDataList);
                proto.setIsTruncated(mailDataList.size() > 1000);
            }
        }
        setData(proto.build());
    }
}
