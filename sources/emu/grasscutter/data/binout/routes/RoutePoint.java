package emu.grasscutter.data.binout.routes;

import emu.grasscutter.net.proto.RoutePointOuterClass;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/routes/RoutePoint.class */
public class RoutePoint {
    private Position pos;
    private int speedLevel;
    private float waitTime;
    private float targetVelocity;
    private boolean hasReachEvent;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0014: INVOKE_CUSTOM r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.data.binout.routes.RoutePoint.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, I, F, F, Z)Ljava/lang/String;}, RoutePoint(pos=, speedLevel=, waitTime=, targetVelocity=, hasReachEvent=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, I, F, F, Z)Ljava/lang/String;}, RoutePoint(pos=, speedLevel=, waitTime=, targetVelocity=, hasReachEvent=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r6 = this;
            r0 = r6
            emu.grasscutter.utils.Position r0 = r0.getPos()
            r1 = r6
            int r1 = r1.getSpeedLevel()
            r2 = r6
            float r2 = r2.getWaitTime()
            r3 = r6
            float r3 = r3.getTargetVelocity()
            r4 = r6
            boolean r4 = r4.isHasReachEvent()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Lemu/grasscutter/utils/Position;, I, F, F, Z)Ljava/lang/String;}, RoutePoint(pos=, speedLevel=, waitTime=, targetVelocity=, hasReachEvent=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.routes.RoutePoint.toString():java.lang.String");
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setSpeedLevel(int speedLevel) {
        this.speedLevel = speedLevel;
    }

    public void setWaitTime(float waitTime) {
        this.waitTime = waitTime;
    }

    public void setTargetVelocity(float targetVelocity) {
        this.targetVelocity = targetVelocity;
    }

    public void setHasReachEvent(boolean hasReachEvent) {
        this.hasReachEvent = hasReachEvent;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof RoutePoint)) {
            return false;
        }
        RoutePoint other = (RoutePoint) o;
        if (!other.canEqual(this) || getSpeedLevel() != other.getSpeedLevel() || Float.compare(getWaitTime(), other.getWaitTime()) != 0 || Float.compare(getTargetVelocity(), other.getTargetVelocity()) != 0 || isHasReachEvent() != other.isHasReachEvent()) {
            return false;
        }
        Object this$pos = getPos();
        Object other$pos = other.getPos();
        return this$pos == null ? other$pos == null : this$pos.equals(other$pos);
    }

    protected boolean canEqual(Object other) {
        return other instanceof RoutePoint;
    }

    public int hashCode() {
        int result = (((((((1 * 59) + getSpeedLevel()) * 59) + Float.floatToIntBits(getWaitTime())) * 59) + Float.floatToIntBits(getTargetVelocity())) * 59) + (isHasReachEvent() ? 79 : 97);
        Object $pos = getPos();
        return (result * 59) + ($pos == null ? 43 : $pos.hashCode());
    }

    public Position getPos() {
        return this.pos;
    }

    public int getSpeedLevel() {
        return this.speedLevel;
    }

    public float getWaitTime() {
        return this.waitTime;
    }

    public float getTargetVelocity() {
        return this.targetVelocity;
    }

    public boolean isHasReachEvent() {
        return this.hasReachEvent;
    }

    public RoutePointOuterClass.RoutePoint.Builder toProto() {
        RoutePointOuterClass.RoutePoint.Builder builder = RoutePointOuterClass.RoutePoint.newBuilder().setPosition(this.pos.toProto());
        if (this.waitTime != 0.0f) {
            builder.setTime(this.waitTime);
        } else if (this.targetVelocity != 0.0f) {
            builder.setVelocity(this.targetVelocity);
        }
        return builder;
    }
}
