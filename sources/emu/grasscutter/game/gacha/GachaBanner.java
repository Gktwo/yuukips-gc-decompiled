package emu.grasscutter.game.gacha;

import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.ActivityInfoOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.utils.Utils;
import org.eclipse.jetty.websocket.api.StatusCode;

/* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/GachaBanner.class */
public class GachaBanner {
    private int gachaType;
    private boolean important;
    private int scheduleId;
    private String prefabPath;
    private String previewPrefabPath;
    private String titlePath;
    private int beginTime;
    private int endTime;
    private int sortId;
    private int costItemId = 0;
    private int costItemAmount = 1;
    private int costItemId10 = 0;
    private int costItemAmount10 = 10;
    private int gachaTimesLimit = Integer.MAX_VALUE;
    private int[] rateUpItems4 = new int[0];
    private int[] rateUpItems5 = new int[0];
    private int[] fallbackItems3 = {11301, 11302, 11306, RetcodeOuterClass.Retcode.RET_GCG_LEVEL_REWARD_LEVEL_ERROR_VALUE, RetcodeOuterClass.Retcode.RET_GCG_LEVEL_REWARD_ALREADY_TAKEN_VALUE, 12305, 13303, 14301, 14302, 14304, 15301, 15302, 15304};
    private int[] fallbackItems4Pool1 = {StatusCode.INVALID_UPSTREAM_RESPONSE, 1020, 1023, 1024, PacketOpcodes.ProudSkillExtraLevelNotify, PacketOpcodes.ProudSkillChangeNotify, 1031, ActivityInfoOuterClass.ActivityInfo.TREASURE_SEELIE_INFO_FIELD_NUMBER, 1034, 1036, PacketOpcodes.AvatarSkillUpgradeReq, PacketOpcodes.BigTalentPointConvertRsp, 1044, 1045, PacketOpcodes.AvatarSkillUpgradeRsp, 1053, 1055, 1056, 1064};
    private int[] fallbackItems4Pool2 = {11401, 11402, 11403, 11405, 12401, 12402, 12403, 12405, 13401, 13407, 14401, 14402, 14403, 14409, 15401, 15402, 15403, 15405};
    private int[] fallbackItems5Pool1 = {1003, 1016, PacketOpcodes.CanUseSkillNotify, 1035, 1041};
    private int[] fallbackItems5Pool2 = {11501, 11502, 12501, 12502, 13502, 13505, 14501, 14502, 15501, 15502};
    private boolean removeC6FromPool = false;
    private boolean autoStripRateUpFromFallback = true;
    private int[][] weights4 = {new int[]{1, 510}, new int[]{8, 510}, new int[]{10, 10000}};
    private int[][] weights5 = {new int[]{1, 75}, new int[]{73, 150}, new int[]{90, 10000}};
    private int[][] poolBalanceWeights4 = {new int[]{1, 255}, new int[]{17, 255}, new int[]{21, 10455}};
    private int[][] poolBalanceWeights5 = {new int[]{1, 30}, new int[]{147, 150}, new int[]{181, 10230}};
    private int eventChance4 = 50;
    private int eventChance5 = 50;
    private BannerType bannerType = BannerType.STANDARD;
    private int wishMaxProgress = 2;
    @Deprecated
    private int[] rateUpItems1 = new int[0];
    @Deprecated
    private int[] rateUpItems2 = new int[0];
    @Deprecated
    private int eventChance = -1;
    @Deprecated
    private int costItem = 0;
    @Deprecated
    private int softPity = -1;
    @Deprecated
    private int hardPity = -1;
    @Deprecated
    private int minItemType = -1;
    @Deprecated
    private int maxItemType = -1;

    /* loaded from: grasscutter.jar:emu/grasscutter/game/gacha/GachaBanner$BannerType.class */
    public enum BannerType {
        STANDARD,
        EVENT,
        WEAPON
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x0005: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x0005: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.gacha.GachaBanner.warnDeprecated(java.lang.String, java.lang.String):void
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Deprecated field found in Banners.json:  was replaced back in early May 2022, use  instead. If you do not remove this key from your config, it will refuse to load in a future Grasscutter version.]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Deprecated field found in Banners.json:  was replaced back in early May 2022, use  instead. If you do not remove this key from your config, it will refuse to load in a future Grasscutter version.]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    private static void warnDeprecated(java.lang.String r4, java.lang.String r5) {
        /*
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r4
            r2 = r5
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, Deprecated field found in Banners.json:  was replaced back in early May 2022, use  instead. If you do not remove this key from your config, it will refuse to load in a future Grasscutter version.]}
            r0.error(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.gacha.GachaBanner.warnDeprecated(java.lang.String, java.lang.String):void");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x001A: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001A: INVOKE_CUSTOM r0, method: emu.grasscutter.game.gacha.GachaBanner.getPreviewPrefabPath():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, UI_Tab_]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, UI_Tab_]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String getPreviewPrefabPath() {
        /*
            r2 = this;
            r0 = r2
            java.lang.String r0 = r0.previewPrefabPath
            if (r0 == 0) goto L_0x0016
            r0 = r2
            java.lang.String r0 = r0.previewPrefabPath
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x0016
            r0 = r2
            java.lang.String r0 = r0.previewPrefabPath
            return r0
            r0 = r2
            java.lang.String r0 = r0.prefabPath
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, UI_Tab_]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.gacha.GachaBanner.getPreviewPrefabPath():java.lang.String");
    }

    /*  JADX ERROR: Dependency scan failed at insn: 0x003B: INVOKE_CUSTOM r-2, r-1, r0, r1, r2
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x0074: INVOKE_CUSTOM r-3, r-2, r-1, r0, r1
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
    /*  JADX ERROR: Failed to decode insn: 0x003B: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.game.gacha.GachaBanner.toProto(emu.grasscutter.game.player.Player):emu.grasscutter.net.proto.GachaInfoOuterClass$GachaInfo
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/String;, I)Ljava/lang/String;}, http://:/gacha?s=&gachaType=]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/String;, I)Ljava/lang/String;}, http://:/gacha?s=&gachaType=]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x0074: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.game.gacha.GachaBanner.toProto(emu.grasscutter.game.player.Player):emu.grasscutter.net.proto.GachaInfoOuterClass$GachaInfo
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/String;, I)Ljava/lang/String;}, http://:/gacha/details?s=&scheduleId=]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/String;, I)Ljava/lang/String;}, http://:/gacha/details?s=&scheduleId=]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public emu.grasscutter.net.proto.GachaInfoOuterClass.GachaInfo toProto(emu.grasscutter.game.player.Player r7) {
        /*
        // Method dump skipped, instructions count: 523
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.gacha.GachaBanner.toProto(emu.grasscutter.game.player.Player):emu.grasscutter.net.proto.GachaInfoOuterClass$GachaInfo");
    }

    public int getGachaType() {
        return this.gachaType;
    }

    public boolean isImportant() {
        return this.important;
    }

    public int getScheduleId() {
        return this.scheduleId;
    }

    public String getPrefabPath() {
        return this.prefabPath;
    }

    public String getTitlePath() {
        return this.titlePath;
    }

    public int getBeginTime() {
        return this.beginTime;
    }

    public int getEndTime() {
        return this.endTime;
    }

    public int getSortId() {
        return this.sortId;
    }

    public int getGachaTimesLimit() {
        return this.gachaTimesLimit;
    }

    public int[] getFallbackItems3() {
        return this.fallbackItems3;
    }

    public int[] getFallbackItems4Pool1() {
        return this.fallbackItems4Pool1;
    }

    public int[] getFallbackItems4Pool2() {
        return this.fallbackItems4Pool2;
    }

    public int[] getFallbackItems5Pool1() {
        return this.fallbackItems5Pool1;
    }

    public int[] getFallbackItems5Pool2() {
        return this.fallbackItems5Pool2;
    }

    public boolean isRemoveC6FromPool() {
        return this.removeC6FromPool;
    }

    public boolean isAutoStripRateUpFromFallback() {
        return this.autoStripRateUpFromFallback;
    }

    public BannerType getBannerType() {
        return this.bannerType;
    }

    public int getWishMaxProgress() {
        return this.wishMaxProgress;
    }

    public void onLoad() {
        if (this.eventChance != -1) {
            warnDeprecated("eventChance", "eventChance4 & eventChance5");
        }
        if (this.costItem != 0) {
            warnDeprecated("costItem", "costItemId");
        }
        if (this.softPity != -1) {
            warnDeprecated("softPity", "weights5");
        }
        if (this.hardPity != -1) {
            warnDeprecated("hardPity", "weights5");
        }
        if (this.minItemType != -1) {
            warnDeprecated("minItemType", "fallbackItems[4,5]Pool[1,2]");
        }
        if (this.maxItemType != -1) {
            warnDeprecated("maxItemType", "fallbackItems[4,5]Pool[1,2]");
        }
        if (this.rateUpItems1.length > 0) {
            warnDeprecated("rateUpItems1", "rateUpItems5");
        }
        if (this.rateUpItems2.length > 0) {
            warnDeprecated("rateUpItems2", "rateUpItems4");
        }
    }

    public ItemParamData getCost(int numRolls) {
        switch (numRolls) {
            case 10:
                return new ItemParamData(this.costItemId10 > 0 ? this.costItemId10 : getCostItem(), this.costItemAmount10);
            default:
                return new ItemParamData(getCostItem(), this.costItemAmount * numRolls);
        }
    }

    public int getCostItem() {
        return this.costItem > 0 ? this.costItem : this.costItemId;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    public int[] getRateUpItems4() {
        return this.rateUpItems2.length > 0 ? this.rateUpItems2 : this.rateUpItems4;
    }

    public int[] getRateUpItems5() {
        return this.rateUpItems1.length > 0 ? this.rateUpItems1 : this.rateUpItems5;
    }

    public boolean hasEpitomized() {
        return this.bannerType.equals(BannerType.WEAPON);
    }

    public int getWeight(int rarity, int pity) {
        switch (rarity) {
            case 4:
                return Utils.lerp(pity, this.weights4);
            default:
                return Utils.lerp(pity, this.weights5);
        }
    }

    public int getPoolBalanceWeight(int rarity, int pity) {
        switch (rarity) {
            case 4:
                return Utils.lerp(pity, this.poolBalanceWeights4);
            default:
                return Utils.lerp(pity, this.poolBalanceWeights5);
        }
    }

    public int getEventChance(int rarity) {
        switch (rarity) {
            case 4:
                return this.eventChance4;
            default:
                return this.eventChance > -1 ? this.eventChance : this.eventChance5;
        }
    }
}
