package emu.grasscutter.data.binout.routes;

import emu.grasscutter.net.proto.RouteOuterClass;
import java.util.Arrays;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/routes/Route.class */
public class Route {
    private int localId;
    private String name;
    private RouteType type = RouteType.Unknown;
    private RoutePoint[] points;
    private float arriveRange;
    private RotType rotType;
    private RotAngleType rotAngleType;

    /*  JADX ERROR: Dependency scan failed at insn: 0x001F: INVOKE_CUSTOM r-7, r-6, r-5, r-4, r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x001F: INVOKE_CUSTOM r0, r1, r2, r3, r4, r5, r6, method: emu.grasscutter.data.binout.routes.Route.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Lemu/grasscutter/data/binout/routes/RouteType;, Ljava/lang/String;, F, Lemu/grasscutter/data/binout/routes/RotType;, Lemu/grasscutter/data/binout/routes/RotAngleType;)Ljava/lang/String;}, Route(localId=, name=, type=, points=, arriveRange=, rotType=, rotAngleType=)]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Lemu/grasscutter/data/binout/routes/RouteType;, Ljava/lang/String;, F, Lemu/grasscutter/data/binout/routes/RotType;, Lemu/grasscutter/data/binout/routes/RotAngleType;)Ljava/lang/String;}, Route(localId=, name=, type=, points=, arriveRange=, rotType=, rotAngleType=)]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r8 = this;
            r0 = r8
            int r0 = r0.getLocalId()
            r1 = r8
            java.lang.String r1 = r1.getName()
            r2 = r8
            emu.grasscutter.data.binout.routes.RouteType r2 = r2.getType()
            r3 = r8
            emu.grasscutter.data.binout.routes.RoutePoint[] r3 = r3.getPoints()
            java.lang.String r3 = java.util.Arrays.deepToString(r3)
            r4 = r8
            float r4 = r4.getArriveRange()
            r5 = r8
            emu.grasscutter.data.binout.routes.RotType r5 = r5.getRotType()
            r6 = r8
            emu.grasscutter.data.binout.routes.RotAngleType r6 = r6.getRotAngleType()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (I, Ljava/lang/String;, Lemu/grasscutter/data/binout/routes/RouteType;, Ljava/lang/String;, F, Lemu/grasscutter/data/binout/routes/RotType;, Lemu/grasscutter/data/binout/routes/RotAngleType;)Ljava/lang/String;}, Route(localId=, name=, type=, points=, arriveRange=, rotType=, rotAngleType=)]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.data.binout.routes.Route.toString():java.lang.String");
    }

    public void setLocalId(int localId) {
        this.localId = localId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(RouteType type) {
        this.type = type;
    }

    public void setPoints(RoutePoint[] points) {
        this.points = points;
    }

    public void setArriveRange(float arriveRange) {
        this.arriveRange = arriveRange;
    }

    public void setRotType(RotType rotType) {
        this.rotType = rotType;
    }

    public void setRotAngleType(RotAngleType rotAngleType) {
        this.rotAngleType = rotAngleType;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof Route)) {
            return false;
        }
        Route other = (Route) o;
        if (!other.canEqual(this) || getLocalId() != other.getLocalId() || Float.compare(getArriveRange(), other.getArriveRange()) != 0) {
            return false;
        }
        Object this$name = getName();
        Object other$name = other.getName();
        if (this$name == null) {
            if (other$name != null) {
                return false;
            }
        } else if (!this$name.equals(other$name)) {
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
        if (!Arrays.deepEquals(getPoints(), other.getPoints())) {
            return false;
        }
        Object this$rotType = getRotType();
        Object other$rotType = other.getRotType();
        if (this$rotType == null) {
            if (other$rotType != null) {
                return false;
            }
        } else if (!this$rotType.equals(other$rotType)) {
            return false;
        }
        Object this$rotAngleType = getRotAngleType();
        Object other$rotAngleType = other.getRotAngleType();
        return this$rotAngleType == null ? other$rotAngleType == null : this$rotAngleType.equals(other$rotAngleType);
    }

    protected boolean canEqual(Object other) {
        return other instanceof Route;
    }

    public int hashCode() {
        int result = (((1 * 59) + getLocalId()) * 59) + Float.floatToIntBits(getArriveRange());
        Object $name = getName();
        int result2 = (result * 59) + ($name == null ? 43 : $name.hashCode());
        Object $type = getType();
        int result3 = (((result2 * 59) + ($type == null ? 43 : $type.hashCode())) * 59) + Arrays.deepHashCode(getPoints());
        Object $rotType = getRotType();
        int result4 = (result3 * 59) + ($rotType == null ? 43 : $rotType.hashCode());
        Object $rotAngleType = getRotAngleType();
        return (result4 * 59) + ($rotAngleType == null ? 43 : $rotAngleType.hashCode());
    }

    public int getLocalId() {
        return this.localId;
    }

    public String getName() {
        return this.name;
    }

    public RouteType getType() {
        return this.type;
    }

    public RoutePoint[] getPoints() {
        return this.points;
    }

    public float getArriveRange() {
        return this.arriveRange;
    }

    public RotType getRotType() {
        return this.rotType;
    }

    public RotAngleType getRotAngleType() {
        return this.rotAngleType;
    }

    public RouteOuterClass.Route toProto() {
        RouteOuterClass.Route.Builder builder = RouteOuterClass.Route.newBuilder().setRouteType(this.type.getValue());
        if (this.points != null) {
            for (RoutePoint routePoint : this.points) {
                builder.addRoutePoints(routePoint.toProto().setArriveRange(this.arriveRange));
            }
        }
        return builder.build();
    }
}
