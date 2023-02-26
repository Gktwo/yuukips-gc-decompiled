package emu.grasscutter.server.packet.send;

import emu.grasscutter.net.packet.BasePacket;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketPlayerStoreNotify.class */
public class PacketPlayerStoreNotify extends BasePacket {
    /*  JADX ERROR: Dependency scan failed at insn: 0x0061: INVOKE_CUSTOM r-3, r-2
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
    /*  JADX ERROR: Failed to decode insn: 0x0061: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.server.packet.send.PacketPlayerStoreNotify.<init>(emu.grasscutter.game.player.Player):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Failed to load items () from ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Failed to load items () from ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public PacketPlayerStoreNotify(emu.grasscutter.game.player.Player r5) {
        /*
            r4 = this;
            r0 = r4
            r1 = 605(0x25d, float:8.48E-43)
            r0.<init>(r1)
            r0 = r4
            r1 = 2
            emu.grasscutter.net.packet.BasePacket r0 = r0.buildHeader(r1)
            emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass$PlayerStoreNotify$Builder r0 = emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass.PlayerStoreNotify.newBuilder()
            emu.grasscutter.net.proto.StoreTypeOuterClass$StoreType r1 = emu.grasscutter.net.proto.StoreTypeOuterClass.StoreType.STORE_TYPE_PACK
            emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass$PlayerStoreNotify$Builder r0 = r0.setStoreType(r1)
            emu.grasscutter.config.ConfigContainer$GameOptions r1 = emu.grasscutter.config.Configuration.GAME_OPTIONS
            emu.grasscutter.config.ConfigContainer$GameOptions$InventoryLimits r1 = r1.inventoryLimits
            int r1 = r1.all
            emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass$PlayerStoreNotify$Builder r0 = r0.setWeightLimit(r1)
            r6 = r0
            r0 = r5
            emu.grasscutter.game.inventory.Inventory r0 = r0.getInventory()
            java.util.Iterator r0 = r0.iterator()
            r7 = r0
            r0 = r7
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x007c
            r0 = r7
            java.lang.Object r0 = r0.next()
            emu.grasscutter.game.inventory.GameItem r0 = (emu.grasscutter.game.inventory.GameItem) r0
            r8 = r0
            r0 = r8
            emu.grasscutter.net.proto.ItemOuterClass$Item r0 = r0.toProto()
            r9 = r0
            r0 = r6
            r1 = r9
            emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass$PlayerStoreNotify$Builder r0 = r0.addItemList(r1)
            goto L_0x0079
            r9 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r8
            int r1 = r1.getItemId()
            r2 = r5
            emu.grasscutter.game.Account r2 = r2.getAccount()
            java.lang.String r2 = r2.getUsername()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;)Ljava/lang/String;}, Failed to load items () from ]}
            r2 = r9
            r0.error(r1, r2)
            r0 = r5
            emu.grasscutter.game.inventory.Inventory r0 = r0.getInventory()
            r1 = r8
            boolean r0 = r0.removeItem(r1)
            r0 = r5
            r0.save()
            goto L_0x002b
            r0 = r4
            r1 = r6
            emu.grasscutter.net.proto.PlayerStoreNotifyOuterClass$PlayerStoreNotify r1 = r1.build()
            r0.setData(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.server.packet.send.PacketPlayerStoreNotify.<init>(emu.grasscutter.game.player.Player):void");
    }
}
