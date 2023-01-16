package emu.grasscutter.game.player;

import emu.grasscutter.data.excels.BuffData;
import emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass;
import emu.grasscutter.net.proto.ServerBuffOuterClass;
import emu.grasscutter.server.packet.send.PacketServerBuffChangeNotify;
import java.util.ArrayList;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerBuffManager.class */
public class PlayerBuffManager extends BasePlayerManager {
    private int nextBuffUid;
    private final Int2ObjectMap<PlayerBuff> buffs = new Int2ObjectOpenHashMap();
    private final List<PlayerBuff> pendingBuffs = new ArrayList();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0059: INVOKE_CUSTOM r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0059: INVOKE_CUSTOM r1, method: emu.grasscutter.game.player.PlayerBuffManager.addBuff(int, float, emu.grasscutter.game.avatar.Avatar):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add addBuff: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:85)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add addBuff: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public synchronized boolean addBuff(int r8, float r9, emu.grasscutter.game.avatar.Avatar r10) {
        /*
            r7 = this;
            it.unimi.dsi.fastutil.ints.Int2ObjectMap r0 = emu.grasscutter.data.GameData.getBuffDataMap()
            r1 = r8
            java.lang.Object r0 = r0.get(r1)
            emu.grasscutter.data.excels.BuffData r0 = (emu.grasscutter.data.excels.BuffData) r0
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L_0x0015
            r0 = 0
            return r0
            r0 = 0
            r12 = r0
            r0 = r12
            r1 = r11
            java.lang.String r1 = r1.getAbilityName()
            emu.grasscutter.data.binout.AbilityData r1 = emu.grasscutter.data.GameData.getAbilityData(r1)
            java.util.Optional r1 = java.util.Optional.ofNullable(r1)
            r2 = r11
            boolean r2 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$addBuff$0(r2, v1);
            }
            java.util.Optional r1 = r1.map(r2)
            boolean r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$addBuff$1(v0);
            }
            java.util.Optional r1 = r1.map(r2)
            r2 = r10
            boolean r2 = (v1) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$addBuff$2(r2, v1);
            }
            java.util.Optional r1 = r1.map(r2)
            r2 = 0
            java.lang.Boolean r2 = java.lang.Boolean.valueOf(r2)
            java.lang.Object r1 = r1.orElse(r2)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r0 = r0 | r1
            r12 = r0
            goto L_0x0061
            r13 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add addBuff: ]}
            r0.warn(r1)
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x006d
            r0 = r11
            float r0 = r0.getTime()
            r9 = r0
            r0 = r9
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0076
            r0 = r12
            return r0
            r0 = r7
            r1 = r11
            int r1 = r1.getGroupId()
            boolean r0 = r0.removeBuff(r1)
            emu.grasscutter.game.player.PlayerBuffManager$PlayerBuff r0 = new emu.grasscutter.game.player.PlayerBuffManager$PlayerBuff
            r1 = r0
            r2 = r7
            int r2 = r2.getNextBuffUid()
            r3 = r11
            r4 = r9
            r1.<init>(r2, r3, r4)
            r13 = r0
            r0 = r7
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<emu.grasscutter.game.player.PlayerBuffManager$PlayerBuff> r0 = r0.buffs
            r1 = r13
            int r1 = r1.getGroupId()
            r2 = r13
            java.lang.Object r0 = r0.put(r1, r2)
            r0 = r7
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.server.packet.send.PacketServerBuffChangeNotify r1 = new emu.grasscutter.server.packet.send.PacketServerBuffChangeNotify
            r2 = r1
            r3 = r7
            emu.grasscutter.game.player.Player r3 = r3.getPlayer()
            emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass$ServerBuffChangeNotify$ServerBuffChangeType r4 = emu.grasscutter.net.proto.ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_ADD_SERVER_BUFF
            r5 = r13
            r2.<init>(r3, r4, r5)
            r0.sendPacket(r1)
            r0 = 1
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.player.PlayerBuffManager.addBuff(int, float, emu.grasscutter.game.avatar.Avatar):boolean");
    }

    public PlayerBuffManager(Player player) {
        super(player);
    }

    private int getNextBuffUid() {
        int i = this.nextBuffUid + 1;
        this.nextBuffUid = i;
        return i;
    }

    public synchronized boolean hasBuff(int groupId) {
        return this.buffs.containsKey(groupId);
    }

    public synchronized void clearBuffs() {
        getPlayer().sendPacket(new PacketServerBuffChangeNotify(getPlayer(), ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF, this.buffs.values()));
        this.buffs.clear();
    }

    public boolean addBuff(int buffId) {
        return addBuff(buffId, -1.0f);
    }

    public synchronized boolean addBuff(int buffId, float duration) {
        return addBuff(buffId, duration, null);
    }

    public synchronized boolean removeBuff(int buffGroupId) {
        PlayerBuff buff = this.buffs.remove(buffGroupId);
        if (buff == null) {
            return false;
        }
        getPlayer().sendPacket(new PacketServerBuffChangeNotify(getPlayer(), ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF, buff));
        return true;
    }

    public synchronized void onTick() {
        if (!this.buffs.isEmpty()) {
            long currentTime = System.currentTimeMillis();
            this.buffs.values().removeIf(buff -> {
                if (currentTime <= currentTime.getEndTime()) {
                    return false;
                }
                this.pendingBuffs.add(currentTime);
                return true;
            });
            if (this.pendingBuffs.size() > 0) {
                getPlayer().sendPacket(new PacketServerBuffChangeNotify(getPlayer(), ServerBuffChangeNotifyOuterClass.ServerBuffChangeNotify.ServerBuffChangeType.SERVER_BUFF_CHANGE_TYPE_DEL_SERVER_BUFF, this.pendingBuffs));
                this.pendingBuffs.clear();
            }
        }
    }

    /* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerBuffManager$PlayerBuff.class */
    public static class PlayerBuff {
        private final int uid;
        private final BuffData buffData;
        private final long endTime;

        public int getUid() {
            return this.uid;
        }

        public BuffData getBuffData() {
            return this.buffData;
        }

        public long getEndTime() {
            return this.endTime;
        }

        public PlayerBuff(int uid, BuffData buffData, float duration) {
            this.uid = uid;
            this.buffData = buffData;
            this.endTime = System.currentTimeMillis() + (((long) duration) * 1000);
        }

        public int getGroupId() {
            return getBuffData().getGroupId();
        }

        public ServerBuffOuterClass.ServerBuff toProto() {
            return ServerBuffOuterClass.ServerBuff.newBuilder().setServerBuffUid(getUid()).setServerBuffId(getBuffData().getId()).setServerBuffType(getBuffData().getServerBuffType().getValue()).setInstancedModifierId(1).build();
        }
    }
}
