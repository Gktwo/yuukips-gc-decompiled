package emu.grasscutter.server.packet.send;

import emu.grasscutter.game.mail.Mail;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.EquipParamOuterClass;
import emu.grasscutter.net.proto.MailChangeNotifyOuterClass;
import emu.grasscutter.net.proto.MailDataOuterClass;
import emu.grasscutter.net.proto.MailItemOuterClass;
import emu.grasscutter.net.proto.MailTextContentOuterClass;
import java.util.ArrayList;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketMailChangeNotify.class */
public class PacketMailChangeNotify extends BasePacket {
    public PacketMailChangeNotify(Player player, final Mail message) {
        this(player, new ArrayList<Mail>() { // from class: emu.grasscutter.server.packet.send.PacketMailChangeNotify.1
            {
                add(Mail.this);
            }
        });
    }

    public PacketMailChangeNotify(Player player, List<Mail> mailList) {
        this(player, mailList, null);
    }

    public PacketMailChangeNotify(Player player, List<Mail> mailList, List<Integer> delMailIdList) {
        super(PacketOpcodes.MailChangeNotify);
        MailChangeNotifyOuterClass.MailChangeNotify.Builder proto = MailChangeNotifyOuterClass.MailChangeNotify.newBuilder();
        if (mailList != null) {
            for (Mail message : mailList) {
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
                mailData.setCollectStateValue(message.stateValue);
                proto.addMailList(mailData.build());
            }
        }
        if (delMailIdList != null) {
            proto.addAllDelMailIdList(delMailIdList);
        }
        setData(proto.build());
    }
}
