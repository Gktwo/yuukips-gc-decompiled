package emu.grasscutter.game.mail;

import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.server.packet.send.PacketDelMailRsp;
import emu.grasscutter.server.packet.send.PacketMailChangeNotify;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:emu/grasscutter/game/mail/MailHandler.class */
public class MailHandler extends BasePlayerManager {
    private final List<Mail> mail = new ArrayList();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0049: INVOKE_CUSTOM r-8, r-7
        java.lang.IndexOutOfBoundsException: Index 4 out of bounds for length 4
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInsn(UsageInfoVisitor.java:130)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.lambda$processInstructions$0(UsageInfoVisitor.java:79)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processInstructions(UsageInfoVisitor.java:77)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processMethod(UsageInfoVisitor.java:62)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.processClass(UsageInfoVisitor.java:51)
        	at jadx.core.dex.visitors.usage.UsageInfoVisitor.init(UsageInfoVisitor.java:36)
        	at jadx.core.dex.nodes.RootNode.runPreDecompileStage(RootNode.java:267)
        */
    /*  JADX ERROR: Failed to decode insn: 0x0049: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.mail.MailHandler.sendMail(emu.grasscutter.game.mail.Mail):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Mail sent to user [:]!]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Mail sent to user [:]!]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void sendMail(emu.grasscutter.game.mail.Mail r7) {
        /*
            r6 = this;
            emu.grasscutter.server.event.player.PlayerReceiveMailEvent r0 = new emu.grasscutter.server.event.player.PlayerReceiveMailEvent
            r1 = r0
            r2 = r6
            emu.grasscutter.game.player.Player r2 = r2.getPlayer()
            r3 = r7
            r1.<init>(r2, r3)
            r8 = r0
            r0 = r8
            r0.call()
            r0 = r8
            boolean r0 = r0.isCanceled()
            if (r0 == 0) goto L_0x0019
            return
            r0 = r8
            emu.grasscutter.game.mail.Mail r0 = r0.getMessage()
            r7 = r0
            r0 = r7
            r1 = r6
            emu.grasscutter.game.player.Player r1 = r1.getPlayer()
            int r1 = r1.getUid()
            r0.setOwnerUid(r1)
            r0 = r7
            r0.save()
            r0 = r6
            java.util.List<emu.grasscutter.game.mail.Mail> r0 = r0.mail
            r1 = r7
            boolean r0 = r0.add(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            emu.grasscutter.game.player.Player r1 = r1.getPlayer()
            int r1 = r1.getUid()
            r2 = r6
            emu.grasscutter.game.player.Player r2 = r2.getPlayer()
            java.lang.String r2 = r2.getNickname()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Mail sent to user [:]!]}
            r0.debug(r1)
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            boolean r0 = r0.isOnline()
            if (r0 == 0) goto L_0x006e
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.server.packet.send.PacketMailChangeNotify r1 = new emu.grasscutter.server.packet.send.PacketMailChangeNotify
            r2 = r1
            r3 = r6
            emu.grasscutter.game.player.Player r3 = r3.getPlayer()
            r4 = r7
            r2.<init>(r3, r4)
            r0.sendPacket(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.mail.MailHandler.sendMail(emu.grasscutter.game.mail.Mail):void");
    }

    public MailHandler(Player player) {
        super(player);
    }

    public List<Mail> getMail() {
        return this.mail;
    }

    public boolean deleteMail(int mailId) {
        Mail message = getMailById(mailId);
        if (message == null) {
            return false;
        }
        getMail().remove(mailId);
        message.expireTime = 0;
        message.save();
        return true;
    }

    public void deleteMail(List<Integer> mailList) {
        List<Integer> sortedMailList = new ArrayList<>();
        sortedMailList.addAll(mailList);
        Collections.sort(sortedMailList, Collections.reverseOrder());
        List<Integer> deleted = new ArrayList<>();
        for (Integer num : sortedMailList) {
            int id = num.intValue();
            if (deleteMail(id)) {
                deleted.add(Integer.valueOf(id));
            }
        }
        this.player.getSession().send(new PacketDelMailRsp(this.player, deleted));
        this.player.getSession().send(new PacketMailChangeNotify(this.player, null, deleted));
    }

    public Mail getMailById(int index) {
        return this.mail.get(index);
    }

    public int getMailIndex(Mail message) {
        return this.mail.indexOf(message);
    }

    public boolean replaceMailByIndex(int index, Mail message) {
        if (getMailById(index) == null) {
            return false;
        }
        this.mail.set(index, message);
        message.save();
        return true;
    }

    public void loadFromDatabase() {
        for (Mail mail : DatabaseHelper.getAllMail(getPlayer())) {
            getMail().add(mail);
        }
    }
}
