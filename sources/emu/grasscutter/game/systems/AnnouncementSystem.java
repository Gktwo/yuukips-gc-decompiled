package emu.grasscutter.game.systems;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.proto.AnnounceDataOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketServerAnnounceNotify;
import emu.grasscutter.server.packet.send.PacketServerAnnounceRevokeNotify;
import emu.grasscutter.utils.Utils;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/systems/AnnouncementSystem.class */
public class AnnouncementSystem extends BaseGameSystem {
    private final Map<Integer, AnnounceConfigItem> announceConfigItemMap = new HashMap();

    /* loaded from: grasscutter.jar:emu/grasscutter/game/systems/AnnouncementSystem$AnnounceType.class */
    public enum AnnounceType {
        CENTER,
        COUNTDOWN
    }

    public Map<Integer, AnnounceConfigItem> getAnnounceConfigItemMap() {
        return this.announceConfigItemMap;
    }

    public AnnouncementSystem(GameServer server) {
        super(server);
        loadConfig();
    }

    private int loadConfig() {
        try {
            List<AnnounceConfigItem> announceConfigItems = DataLoader.loadList("Announcement.json", AnnounceConfigItem.class);
            this.announceConfigItemMap.clear();
            announceConfigItems.forEach(i -> {
                this.announceConfigItemMap.put(Integer.valueOf(i.getTemplateId()), i);
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load server announce config.", (Throwable) e);
        }
        return this.announceConfigItemMap.size();
    }

    public List<Player> getOnlinePlayers() {
        return getServer().getWorlds().stream().map((v0) -> {
            return v0.getPlayers();
        }).flatMap((v0) -> {
            return v0.stream();
        }).toList();
    }

    public void broadcast(List<AnnounceConfigItem> tpl) {
        if (tpl != null && tpl.size() != 0) {
            List<AnnounceDataOuterClass.AnnounceData> list = tpl.stream().map((v0) -> {
                return v0.toProto();
            }).map((v0) -> {
                return v0.build();
            }).toList();
            getOnlinePlayers().forEach(i -> {
                i.sendPacket(new PacketServerAnnounceNotify(list));
            });
        }
    }

    public int refresh() {
        return loadConfig();
    }

    public void revoke(int tplId) {
        getOnlinePlayers().forEach(i -> {
            i.sendPacket(new PacketServerAnnounceRevokeNotify(tplId));
        });
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/systems/AnnouncementSystem$AnnounceConfigItem.class */
    public class AnnounceConfigItem {
        private int templateId;
        private AnnounceType type;
        private int frequency;
        private String content;
        private Date beginTime;
        private Date endTime;
        private boolean tick;
        private int interval;

        /*  JADX ERROR: Dependency scan failed at insn: 0x0020: INVOKE_CUSTOM r-8, r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
        /*  JADX ERROR: Failed to decode insn: 0x0020: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, r7, method: emu.grasscutter.game.systems.AnnouncementSystem.AnnounceConfigItem.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/game/systems/AnnouncementSystem$AnnounceType;, I, Ljava/lang/String;, Ljava/util/Date;, Ljava/util/Date;, Z, I)Ljava/lang/String;}, AnnouncementSystem.AnnounceConfigItem(templateId=, type=, frequency=, content=, beginTime=, endTime=, tick=, interval=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/game/systems/AnnouncementSystem$AnnounceType;, I, Ljava/lang/String;, Ljava/util/Date;, Ljava/util/Date;, Z, I)Ljava/lang/String;}, AnnouncementSystem.AnnounceConfigItem(templateId=, type=, frequency=, content=, beginTime=, endTime=, tick=, interval=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r9 = this;
                r0 = r9
                int r0 = r0.getTemplateId()
                r1 = r9
                emu.grasscutter.game.systems.AnnouncementSystem$AnnounceType r1 = r1.getType()
                r2 = r9
                int r2 = r2.getFrequency()
                r3 = r9
                java.lang.String r3 = r3.getContent()
                r4 = r9
                java.util.Date r4 = r4.getBeginTime()
                r5 = r9
                java.util.Date r5 = r5.getEndTime()
                r6 = r9
                boolean r6 = r6.isTick()
                r7 = r9
                int r7 = r7.getInterval()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Lemu/grasscutter/game/systems/AnnouncementSystem$AnnounceType;, I, Ljava/lang/String;, Ljava/util/Date;, Ljava/util/Date;, Z, I)Ljava/lang/String;}, AnnouncementSystem.AnnounceConfigItem(templateId=, type=, frequency=, content=, beginTime=, endTime=, tick=, interval=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.systems.AnnouncementSystem.AnnounceConfigItem.toString():java.lang.String");
        }

        public AnnounceConfigItem() {
        }

        public void setTemplateId(int templateId) {
            this.templateId = templateId;
        }

        public void setType(AnnounceType type) {
            this.type = type;
        }

        public void setFrequency(int frequency) {
            this.frequency = frequency;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public void setBeginTime(Date beginTime) {
            this.beginTime = beginTime;
        }

        public void setEndTime(Date endTime) {
            this.endTime = endTime;
        }

        public void setTick(boolean tick) {
            this.tick = tick;
        }

        public void setInterval(int interval) {
            this.interval = interval;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof AnnounceConfigItem)) {
                return false;
            }
            AnnounceConfigItem other = (AnnounceConfigItem) o;
            if (!other.canEqual(this) || getTemplateId() != other.getTemplateId() || getFrequency() != other.getFrequency() || isTick() != other.isTick() || getInterval() != other.getInterval()) {
                return false;
            }
            Object this$type = getType();
            Object other$type = other.getType();
            if (this$type == null) {
                if (other$type != null) {
                    return false;
                }
            } else if (!this$type.equals(other$type)) {
                return false;
            }
            Object this$content = getContent();
            Object other$content = other.getContent();
            if (this$content == null) {
                if (other$content != null) {
                    return false;
                }
            } else if (!this$content.equals(other$content)) {
                return false;
            }
            Object this$beginTime = getBeginTime();
            Object other$beginTime = other.getBeginTime();
            if (this$beginTime == null) {
                if (other$beginTime != null) {
                    return false;
                }
            } else if (!this$beginTime.equals(other$beginTime)) {
                return false;
            }
            Object this$endTime = getEndTime();
            Object other$endTime = other.getEndTime();
            return this$endTime == null ? other$endTime == null : this$endTime.equals(other$endTime);
        }

        protected boolean canEqual(Object other) {
            return other instanceof AnnounceConfigItem;
        }

        public int hashCode() {
            int result = (((((((1 * 59) + getTemplateId()) * 59) + getFrequency()) * 59) + (isTick() ? 79 : 97)) * 59) + getInterval();
            Object $type = getType();
            int result2 = (result * 59) + ($type == null ? 43 : $type.hashCode());
            Object $content = getContent();
            int result3 = (result2 * 59) + ($content == null ? 43 : $content.hashCode());
            Object $beginTime = getBeginTime();
            int result4 = (result3 * 59) + ($beginTime == null ? 43 : $beginTime.hashCode());
            Object $endTime = getEndTime();
            return (result4 * 59) + ($endTime == null ? 43 : $endTime.hashCode());
        }

        public int getTemplateId() {
            return this.templateId;
        }

        public AnnounceType getType() {
            return this.type;
        }

        public int getFrequency() {
            return this.frequency;
        }

        public String getContent() {
            return this.content;
        }

        public Date getBeginTime() {
            return this.beginTime;
        }

        public Date getEndTime() {
            return this.endTime;
        }

        public boolean isTick() {
            return this.tick;
        }

        public int getInterval() {
            return this.interval;
        }

        public AnnounceDataOuterClass.AnnounceData.Builder toProto() {
            AnnounceDataOuterClass.AnnounceData.Builder proto = AnnounceDataOuterClass.AnnounceData.newBuilder();
            proto.setConfigId(this.templateId).setBeginTime(Utils.getCurrentSeconds() + 1).setEndTime(Utils.getCurrentSeconds() + 10);
            if (this.type == AnnounceType.CENTER) {
                proto.setCenterSystemText(this.content).setCenterSystemFrequency(this.frequency);
            } else {
                proto.setCountDownText(this.content).setCountDownFrequency(this.frequency);
            }
            return proto;
        }
    }
}
