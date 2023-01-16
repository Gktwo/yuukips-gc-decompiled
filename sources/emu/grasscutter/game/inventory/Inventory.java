package emu.grasscutter.game.inventory;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.config.Configuration;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.database.DatabaseHelper;
import emu.grasscutter.game.avatar.Avatar;
import emu.grasscutter.game.avatar.AvatarStorage;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.PlayerProperty;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.game.quest.enums.QuestTrigger;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.server.packet.send.PacketAddNoGachaAvatarCardNotify;
import emu.grasscutter.server.packet.send.PacketAvatarEquipChangeNotify;
import emu.grasscutter.server.packet.send.PacketItemAddHintNotify;
import emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify;
import emu.grasscutter.server.packet.send.PacketStoreItemDelNotify;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectMap;
import p014it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/Inventory.class */
public class Inventory extends BasePlayerManager implements Iterable<GameItem> {
    private final Long2ObjectMap<GameItem> store = new Long2ObjectOpenHashMap();
    private final Int2ObjectMap<InventoryTab> inventoryTypes = new Int2ObjectOpenHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0019: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0019: INVOKE_CUSTOM r1, method: emu.grasscutter.game.inventory.Inventory.addItem(emu.grasscutter.game.inventory.GameItem):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public boolean addItem(emu.grasscutter.game.inventory.GameItem r6) {
        /*
            r5 = this;
            r0 = r6
            if (r0 != 0) goto L_0x0006
            r0 = 0
            return r0
            r0 = 0
            r7 = r0
            r0 = r5
            r1 = r6
            emu.grasscutter.game.inventory.GameItem r0 = r0.putItem(r1)
            r7 = r0
            goto L_0x0021
            r8 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r6
            int r1 = r1.getItemId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
            r0.warn(r1)
            r0 = r7
            if (r0 == 0) goto L_0x003b
            r0 = r5
            r1 = r7
            r0.triggerAddItemEvents(r1)
            r0 = r5
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify r1 = new emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify
            r2 = r1
            r3 = r7
            r2.<init>(r3)
            r0.sendPacket(r1)
            r0 = 1
            return r0
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.inventory.Inventory.addItem(emu.grasscutter.game.inventory.GameItem):boolean");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0051: INVOKE_CUSTOM r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0051: INVOKE_CUSTOM r1, method: emu.grasscutter.game.inventory.Inventory.addItems(java.util.Collection<emu.grasscutter.game.inventory.GameItem>, emu.grasscutter.game.props.ActionReason):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public void addItems(java.util.Collection<emu.grasscutter.game.inventory.GameItem> r7, emu.grasscutter.game.props.ActionReason r8) {
        /*
            r6 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = r7
            java.util.Iterator r0 = r0.iterator()
            r10 = r0
            r0 = r10
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x0070
            r0 = r10
            java.lang.Object r0 = r0.next()
            emu.grasscutter.game.inventory.GameItem r0 = (emu.grasscutter.game.inventory.GameItem) r0
            r11 = r0
            r0 = r11
            if (r0 != 0) goto L_0x002e
            goto L_0x0010
            r0 = r11
            int r0 = r0.getItemId()
            if (r0 != 0) goto L_0x0039
            goto L_0x0010
            r0 = 0
            r12 = r0
            r0 = r6
            r1 = r11
            emu.grasscutter.game.inventory.GameItem r0 = r0.putItem(r1)
            r12 = r0
            goto L_0x0059
            r13 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r11
            int r1 = r1.getItemId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Error add item: ]}
            r0.warn(r1)
            r0 = r12
            if (r0 == 0) goto L_0x006d
            r0 = r6
            r1 = r12
            r0.triggerAddItemEvents(r1)
            r0 = r9
            r1 = r12
            boolean r0 = r0.add(r1)
            goto L_0x0010
            r0 = r9
            int r0 = r0.size()
            if (r0 != 0) goto L_0x007a
            return
            r0 = r8
            if (r0 == 0) goto L_0x008e
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.server.packet.send.PacketItemAddHintNotify r1 = new emu.grasscutter.server.packet.send.PacketItemAddHintNotify
            r2 = r1
            r3 = r7
            r4 = r8
            r2.<init>(r3, r4)
            r0.sendPacket(r1)
            r0 = r6
            emu.grasscutter.game.player.Player r0 = r0.getPlayer()
            emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify r1 = new emu.grasscutter.server.packet.send.PacketStoreItemChangeNotify
            r2 = r1
            r3 = r9
            r2.<init>(r3)
            r0.sendPacket(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.inventory.Inventory.addItems(java.util.Collection, emu.grasscutter.game.props.ActionReason):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x00E1: INVOKE_CUSTOM r-15
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
    /*  JADX ERROR: Failed to decode insn: 0x00E1: INVOKE_CUSTOM r1, method: emu.grasscutter.game.inventory.Inventory.putItem(emu.grasscutter.game.inventory.GameItem):emu.grasscutter.game.inventory.GameItem
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Attempted to add a  to inventory, but item definition lacks isUseOnGain. This indicates a Resources error.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, Attempted to add a  to inventory, but item definition lacks isUseOnGain. This indicates a Resources error.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private synchronized emu.grasscutter.game.inventory.GameItem putItem(emu.grasscutter.game.inventory.GameItem r6) {
        /*
        // Method dump skipped, instructions count: 325
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.inventory.Inventory.putItem(emu.grasscutter.game.inventory.GameItem):emu.grasscutter.game.inventory.GameItem");
    }

    public Inventory(Player player) {
        super(player);
        createInventoryTab(ItemType.ITEM_WEAPON, new EquipInventoryTab(Configuration.INVENTORY_LIMITS.weapons));
        createInventoryTab(ItemType.ITEM_RELIQUARY, new EquipInventoryTab(Configuration.INVENTORY_LIMITS.relics));
        createInventoryTab(ItemType.ITEM_MATERIAL, new MaterialInventoryTab(Configuration.INVENTORY_LIMITS.materials));
        createInventoryTab(ItemType.ITEM_FURNITURE, new MaterialInventoryTab(Configuration.INVENTORY_LIMITS.furniture));
    }

    public AvatarStorage getAvatarStorage() {
        return getPlayer().getAvatars();
    }

    public Long2ObjectMap<GameItem> getItems() {
        return this.store;
    }

    public Int2ObjectMap<InventoryTab> getInventoryTypes() {
        return this.inventoryTypes;
    }

    public InventoryTab getInventoryTab(ItemType type) {
        return getInventoryTypes().get(type.getValue());
    }

    public void createInventoryTab(ItemType type, InventoryTab tab) {
        getInventoryTypes().put(type.getValue(), (int) tab);
    }

    public GameItem getItemByGuid(long id) {
        return getItems().get(id);
    }

    public boolean addItem(int itemId) {
        return addItem(itemId, 1);
    }

    public boolean addItem(int itemId, int count) {
        return addItem(itemId, count, (ActionReason) null);
    }

    public boolean addItem(int itemId, int count, ActionReason reason) {
        ItemData itemData = GameData.getItemDataMap().get(itemId);
        if (itemData != null) {
            return addItem(new GameItem(itemData, count), reason);
        }
        Grasscutter.getLogger().error("Item not found {} | add {} with {}", Integer.valueOf(itemId), Integer.valueOf(count), reason.toString());
        return false;
    }

    public boolean addItem(GameItem item, ActionReason reason) {
        return addItem(item, reason, false);
    }

    public boolean addItem(GameItem item, ActionReason reason, boolean forceNotify) {
        boolean result = addItem(item);
        if (item.getItemData().getMaterialType() == MaterialType.MATERIAL_AVATAR) {
            getPlayer().sendPacket(new PacketAddNoGachaAvatarCardNotify((item.getItemId() % 1000) + 10000000, reason, item));
        }
        if (reason != null && (forceNotify || result)) {
            getPlayer().sendPacket(new PacketItemAddHintNotify(item, reason));
        }
        return result;
    }

    public boolean addItem(ItemParamData itemParam) {
        return addItem(itemParam, (ActionReason) null);
    }

    public boolean addItem(ItemParamData itemParam, ActionReason reason) {
        if (itemParam == null) {
            return false;
        }
        return addItem(itemParam.getId(), itemParam.getCount(), reason);
    }

    public void addItems(Collection<GameItem> items) {
        addItems(items, null);
    }

    private void triggerAddItemEvents(GameItem result) {
        try {
            getPlayer().getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_OBTAIN_MATERIAL_NUM, result.getItemId(), result.getCount());
            getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_OBTAIN_ITEM, result.getItemId(), result.getCount());
        } catch (Exception e) {
        }
    }

    private void triggerRemItemEvents(GameItem item, int removeCount) {
        try {
            getPlayer().getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_COST_MATERIAL, item.getItemId(), removeCount);
            getPlayer().getQuestManager().queueEvent(QuestTrigger.QUEST_CONTENT_ITEM_LESS_THAN, item.getItemId(), item.getCount());
        } catch (Exception e) {
        }
    }

    public void addItemParams(Collection<ItemParamOuterClass.ItemParam> items) {
        addItems(items.stream().map(param -> {
            return new GameItem(param.getItemId(), param.getCount());
        }).toList(), null);
    }

    public void addItemParamDatas(Collection<ItemParamData> items) {
        addItemParamDatas(items, null);
    }

    public void addItemParamDatas(Collection<ItemParamData> items, ActionReason reason) {
        addItems(items.stream().map(param -> {
            return new GameItem(param.getItemId(), param.getCount());
        }).toList(), reason);
    }

    /* renamed from: emu.grasscutter.game.inventory.Inventory$1 */
    /* loaded from: grasscutter.jar:emu/grasscutter/game/inventory/Inventory$1.class */
    static /* synthetic */ class C13611 {
        static final /* synthetic */ int[] $SwitchMap$emu$grasscutter$game$inventory$MaterialType;
        static final /* synthetic */ int[] $SwitchMap$emu$grasscutter$game$inventory$ItemType = new int[ItemType.values().length];

        static {
            try {
                $SwitchMap$emu$grasscutter$game$inventory$ItemType[ItemType.ITEM_WEAPON.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$inventory$ItemType[ItemType.ITEM_RELIQUARY.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$inventory$ItemType[ItemType.ITEM_VIRTUAL.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            $SwitchMap$emu$grasscutter$game$inventory$MaterialType = new int[MaterialType.values().length];
            try {
                $SwitchMap$emu$grasscutter$game$inventory$MaterialType[MaterialType.MATERIAL_AVATAR.ordinal()] = 1;
            } catch (NoSuchFieldError e4) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$inventory$MaterialType[MaterialType.MATERIAL_FLYCLOAK.ordinal()] = 2;
            } catch (NoSuchFieldError e5) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$inventory$MaterialType[MaterialType.MATERIAL_COSTUME.ordinal()] = 3;
            } catch (NoSuchFieldError e6) {
            }
            try {
                $SwitchMap$emu$grasscutter$game$inventory$MaterialType[MaterialType.MATERIAL_NAMECARD.ordinal()] = 4;
            } catch (NoSuchFieldError e7) {
            }
        }
    }

    private synchronized void putItem(GameItem item, InventoryTab tab) {
        this.player.getCodex().checkAddedItem(item);
        item.setOwner(this.player);
        getItems().put(item.getGuid(), (long) item);
        if (tab != null) {
            tab.onAddItem(item);
        }
    }

    private void addVirtualItem(int itemId, int count) {
        switch (itemId) {
            case 101:
                this.player.getTeamManager().getActiveTeam().stream().map(e -> {
                    return e.getAvatar();
                }).forEach(avatar -> {
                    this.player.getServer().getInventorySystem().upgradeAvatar(this.player, count, count);
                });
                return;
            case 102:
                this.player.addExpDirectly(count);
                return;
            case 105:
                this.player.getTeamManager().getActiveTeam().stream().map(e -> {
                    return e.getAvatar();
                }).forEach(avatar -> {
                    this.player.getServer().getInventorySystem().upgradeAvatarFetterLevel(this.player, count, count * (this.player.isInMultiplayer() ? 2 : 1));
                });
                return;
            case 106:
                this.player.getResinManager().addResin(count);
                return;
            case 107:
                this.player.addLegendaryKey(count);
                return;
            case 201:
                this.player.setPrimogems(this.player.getPrimogems() + count);
                return;
            case 202:
                this.player.setMora(this.player.getMora() + count);
                return;
            case 203:
                this.player.setCrystals(this.player.getCrystals() + count);
                return;
            case 204:
                this.player.setHomeCoin(this.player.getHomeCoin() + count);
                return;
            default:
                return;
        }
    }

    private GameItem payVirtualItem(int itemId, int count) {
        switch (itemId) {
            case 106:
                this.player.getResinManager().useResin(count);
                return null;
            case 107:
                this.player.useLegendaryKey(count);
                return null;
            case 201:
                this.player.setPrimogems(this.player.getPrimogems() - count);
                return null;
            case 202:
                this.player.setMora(this.player.getMora() - count);
                return null;
            case 203:
                this.player.setCrystals(this.player.getCrystals() - count);
                return null;
            case 204:
                this.player.setHomeCoin(this.player.getHomeCoin() - count);
                return null;
            default:
                GameItem gameItem = getInventoryTab(ItemType.ITEM_MATERIAL).getItemById(itemId);
                removeItem(gameItem, count);
                return gameItem;
        }
    }

    private int getVirtualItemCount(int itemId) {
        switch (itemId) {
            case 106:
                return this.player.getProperty(PlayerProperty.PROP_PLAYER_RESIN);
            case 107:
                return this.player.getProperty(PlayerProperty.PROP_PLAYER_LEGENDARY_KEY);
            case 201:
                return this.player.getPrimogems();
            case 202:
                return this.player.getMora();
            case 203:
                return this.player.getCrystals();
            case 204:
                return this.player.getHomeCoin();
            default:
                GameItem item = getInventoryTab(ItemType.ITEM_MATERIAL).getItemById(itemId);
                if (item == null) {
                    return 0;
                }
                return item.getCount();
        }
    }

    public synchronized boolean payItem(int id, int count) {
        if (getVirtualItemCount(id) < count) {
            return false;
        }
        payVirtualItem(id, count);
        return true;
    }

    public boolean payItem(ItemParamData costItem) {
        return payItem(costItem.getId(), costItem.getCount());
    }

    public boolean payItems(ItemParamData[] costItems) {
        return payItems(costItems, 1, (ActionReason) null);
    }

    public boolean payItems(ItemParamData[] costItems, int quantity) {
        return payItems(costItems, quantity, (ActionReason) null);
    }

    public synchronized boolean payItems(ItemParamData[] costItems, int quantity, ActionReason reason) {
        for (ItemParamData cost : costItems) {
            if (getVirtualItemCount(cost.getId()) < cost.getCount() * quantity) {
                return false;
            }
        }
        for (ItemParamData cost2 : costItems) {
            payVirtualItem(cost2.getId(), cost2.getCount() * quantity);
        }
        if (reason != null) {
        }
        return true;
    }

    public boolean payItems(Iterable<ItemParamData> costItems) {
        return payItems(costItems, 1, (ActionReason) null);
    }

    public boolean payItems(Iterable<ItemParamData> costItems, int quantity) {
        return payItems(costItems, quantity, (ActionReason) null);
    }

    public synchronized boolean payItems(Iterable<ItemParamData> costItems, int quantity, ActionReason reason) {
        for (ItemParamData cost : costItems) {
            if (getVirtualItemCount(cost.getId()) < cost.getCount() * quantity) {
                return false;
            }
        }
        costItems.forEach(cost2 -> {
            payVirtualItem(quantity.getId(), quantity.getCount() * quantity);
        });
        return true;
    }

    public void removeItems(List<GameItem> items) {
        for (GameItem item : items) {
            removeItem(item, item.getCount());
        }
    }

    public boolean removeItem(long guid) {
        return removeItem(guid, 1);
    }

    public synchronized boolean removeItem(long guid, int count) {
        GameItem item = getItemByGuid(guid);
        if (item == null) {
            return false;
        }
        return removeItem(item, count);
    }

    public synchronized boolean removeItem(GameItem item) {
        return removeItem(item, item.getCount());
    }

    public synchronized boolean removeItem(GameItem item, int count) {
        if (count <= 0 || item == null) {
            return false;
        }
        if (item.getItemData().isEquip()) {
            item.setCount(0);
        } else {
            item.setCount(item.getCount() - count);
        }
        if (item.getCount() <= 0) {
            InventoryTab tab = null;
            if (item.getItemData() != null) {
                tab = getInventoryTab(item.getItemData().getItemType());
            }
            deleteItem(item, tab);
            getPlayer().sendPacket(new PacketStoreItemDelNotify(item));
        } else {
            getPlayer().sendPacket(new PacketStoreItemChangeNotify(item));
        }
        triggerRemItemEvents(item, Math.min(count, item.getCount()));
        item.save();
        return true;
    }

    private void deleteItem(GameItem item, InventoryTab tab) {
        getItems().remove(item.getGuid());
        if (tab != null) {
            tab.onRemoveItem(item);
        }
    }

    public boolean equipItem(long avatarGuid, long equipGuid) {
        Avatar avatar = getPlayer().getAvatars().getAvatarByGuid(avatarGuid);
        GameItem item = getItemByGuid(equipGuid);
        if (avatar == null || item == null) {
            return false;
        }
        return avatar.equipItem(item, true);
    }

    public boolean unequipItem(long avatarGuid, int slot) {
        Avatar avatar = getPlayer().getAvatars().getAvatarByGuid(avatarGuid);
        EquipType equipType = EquipType.getTypeByValue(slot);
        if (avatar == null || equipType == EquipType.EQUIP_WEAPON || !avatar.unequipItem(equipType)) {
            return false;
        }
        getPlayer().sendPacket(new PacketAvatarEquipChangeNotify(avatar, equipType));
        avatar.recalcStats();
        return true;
    }

    public void loadFromDatabase() {
        ItemData itemData;
        for (GameItem item : DatabaseHelper.getInventoryItems(getPlayer())) {
            if (!(item.getObjectId() == null || (itemData = GameData.getItemDataMap().get(item.getItemId())) == null)) {
                item.setItemData(itemData);
                InventoryTab tab = null;
                if (item.getItemData() != null) {
                    tab = getInventoryTab(item.getItemData().getItemType());
                }
                putItem(item, tab);
                if (item.isEquipped()) {
                    Avatar avatar = getPlayer().getAvatars().getAvatarById(item.getEquipCharacter());
                    boolean hasEquipped = false;
                    if (avatar != null) {
                        hasEquipped = avatar.equipItem(item, false);
                    }
                    if (!hasEquipped) {
                        item.setEquipCharacter(0);
                        item.save();
                    }
                }
            }
        }
    }

    @Override // java.lang.Iterable
    public Iterator<GameItem> iterator() {
        return getItems().values().iterator();
    }
}
