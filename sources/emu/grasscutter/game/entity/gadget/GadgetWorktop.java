package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.gadget.worktop.WorktopWorktopOptionHandler;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.net.proto.SelectWorktopOptionReqOuterClass;
import emu.grasscutter.net.proto.WorktopInfoOuterClass;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import p014it.unimi.dsi.fastutil.ints.IntOpenHashSet;
import p014it.unimi.dsi.fastutil.ints.IntSet;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/GadgetWorktop.class */
public class GadgetWorktop extends GadgetContent {
    private IntSet worktopOptions;
    private WorktopWorktopOptionHandler handler;

    /*  JADX ERROR: Dependency scan failed at insn: 0x000B: INVOKE_CUSTOM r-1, r0
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
    /*  JADX ERROR: Failed to decode insn: 0x000B: INVOKE_CUSTOM r1, r2, method: emu.grasscutter.game.entity.gadget.GadgetWorktop.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: Player  interact gadget with ]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: Player  interact gadget with ]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public boolean onInteract(emu.grasscutter.game.player.Player r5, emu.grasscutter.net.proto.GadgetInteractReqOuterClass.GadgetInteractReq r6) {
        /*
            r4 = this;
            ch.qos.logback.classic.Logger r0 = emu.grasscutter.Grasscutter.getLogger()
            r1 = r5
            int r1 = r1.getUid()
            r2 = r6
            int r2 = r2.getGadgetId()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, I)Ljava/lang/String;}, GadgetWorktop: Player  interact gadget with ]}
            r0.warn(r1)
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.game.entity.gadget.GadgetWorktop.onInteract(emu.grasscutter.game.player.Player, emu.grasscutter.net.proto.GadgetInteractReqOuterClass$GadgetInteractReq):boolean");
    }

    public GadgetWorktop(EntityGadget gadget) {
        super(gadget);
    }

    public IntSet getWorktopOptions() {
        if (this.worktopOptions == null) {
            this.worktopOptions = new IntOpenHashSet();
        }
        return this.worktopOptions;
    }

    public void addWorktopOptions(int[] options) {
        if (this.worktopOptions == null) {
            this.worktopOptions = new IntOpenHashSet();
        }
        IntStream stream = Arrays.stream(options);
        IntSet intSet = this.worktopOptions;
        Objects.requireNonNull(intSet);
        stream.forEach(this::add);
    }

    public void removeWorktopOption(int option) {
        if (this.worktopOptions != null) {
            this.worktopOptions.remove(option);
        }
    }

    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public void onBuildProto(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder gadgetInfo) {
        if (this.worktopOptions != null) {
            gadgetInfo.setWorktop(WorktopInfoOuterClass.WorktopInfo.newBuilder().addAllOptionList(getWorktopOptions()).build());
        }
    }

    public void setOnSelectWorktopOptionEvent(WorktopWorktopOptionHandler handler) {
        this.handler = handler;
    }

    public boolean onSelectWorktopOption(SelectWorktopOptionReqOuterClass.SelectWorktopOptionReq req) {
        if (this.handler == null) {
            return false;
        }
        this.handler.onSelectWorktopOption(this, req.getOptionId());
        return false;
    }
}
