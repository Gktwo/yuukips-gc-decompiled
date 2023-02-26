package emu.grasscutter.game.shop;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ShopGoodsData;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/shop/ShopSystem.class */
public class ShopSystem extends BaseGameSystem {
    private final Int2ObjectMap<List<ShopInfo>> shopData = new Int2ObjectOpenHashMap();
    private final Int2ObjectMap<List<ItemParamData>> shopChestData = new Int2ObjectOpenHashMap();
    private static final int REFRESH_HOUR = 4;
    private static final String TIME_ZONE = "Asia/Shanghai";

    /*  JADX ERROR: Dependency scan failed at insn: 0x0028: INVOKE_CUSTOM r-5
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
    /*  JADX ERROR: Failed to decode insn: 0x0028: INVOKE_CUSTOM r1, method: emu.grasscutter.game.shop.ShopSystem.loadShopChest():void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ShopChest entries.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ShopChest entries.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private void loadShopChest() {
        /*
            r4 = this;
            r0 = r4
            it.unimi.dsi.fastutil.ints.Int2ObjectMap<java.util.List<emu.grasscutter.data.common.ItemParamData>> r0 = r0.shopChestData
            r0.clear()
            java.lang.String r0 = "ShopChest.v2.json"
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            java.lang.Class<java.lang.String> r2 = java.lang.String.class
            java.util.Map r0 = emu.grasscutter.data.DataLoader.loadMap(r0, r1, r2)
            r5 = r0
            r0 = r5
            r1 = r4
            void r1 = (v1, v2) -> { // java.util.function.BiConsumer.accept(java.lang.Object, java.lang.Object):void
                r1.lambda$loadShopChest$1(v1, v2);
            }
            r0.forEach(r1)
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            int r1 = r1.size()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I)Ljava/lang/String;}, Loaded  ShopChest entries.]}
            r0.info(r1)
            goto L_0x003d
            r5 = move-exception
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            java.lang.String r1 = "Unable to load ShopChest data."
            r2 = r5
            r0.error(r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.shop.ShopSystem.loadShopChest():void");
    }

    public ShopSystem(GameServer server) {
        super(server);
        load();
    }

    public Int2ObjectMap<List<ShopInfo>> getShopData() {
        return this.shopData;
    }

    public List<ItemParamData> getShopChestData(int chestId) {
        return this.shopChestData.get(chestId);
    }

    public static int getShopNextRefreshTime(ShopInfo shopInfo) {
        switch (shopInfo.getShopRefreshType()) {
            case SHOP_REFRESH_DAILY:
                return Utils.getNextTimestampOfThisHour(4, TIME_ZONE, shopInfo.getShopRefreshParam());
            case SHOP_REFRESH_WEEKLY:
                return Utils.getNextTimestampOfThisHourInNextWeek(4, TIME_ZONE, shopInfo.getShopRefreshParam());
            case SHOP_REFRESH_MONTHLY:
                return Utils.getNextTimestampOfThisHourInNextMonth(4, TIME_ZONE, shopInfo.getShopRefreshParam());
            default:
                return 0;
        }
    }

    private void loadShop() {
        getShopData().clear();
        try {
            List<ShopTable> banners = DataLoader.loadList("Shop.json", ShopTable.class);
            if (banners.size() > 0) {
                for (ShopTable shopTable : banners) {
                    shopTable.getItems().forEach((v0) -> {
                        v0.removeVirtualCosts();
                    });
                    getShopData().put(shopTable.getShopId(), (int) shopTable.getItems());
                }
                Grasscutter.getLogger().debug("Shop data successfully loaded.");
            } else {
                Grasscutter.getLogger().error("Unable to load shop data. Shop data size is 0.");
            }
            GameData.getShopGoodsDataEntries().forEach(k, v -> {
                if (!getShopData().containsKey(k.intValue())) {
                    getShopData().put(k.intValue(), (int) new ArrayList());
                }
                Iterator it = v.iterator();
                while (it.hasNext()) {
                    getShopData().get(k.intValue()).add(new ShopInfo((ShopGoodsData) it.next()));
                }
            });
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load shop data.", (Throwable) e);
        }
    }

    public synchronized void load() {
        loadShop();
        loadShopChest();
    }

    @Override // emu.grasscutter.server.game.BaseGameSystem
    public GameServer getServer() {
        return this.server;
    }
}
