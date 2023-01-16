package emu.grasscutter.utils;

import com.github.davidmoten.rtreemulti.geometry.Point;
import com.google.gson.annotations.SerializedName;
import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.VectorOuterClass;
import java.io.Serializable;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/utils/Position.class */
public class Position implements Serializable {
    private static final long serialVersionUID = -2001232313615923575L;
    @SerializedName(value = "x", alternate = {"_x", "X"})

    /* renamed from: x */
    private float f968x;
    @SerializedName(value = "y", alternate = {"_y", "Y"})

    /* renamed from: y */
    private float f969y;
    @SerializedName(value = "z", alternate = {"_z", "Z"})

    /* renamed from: z */
    private float f970z;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0015: INVOKE_CUSTOM r-3, r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0015: INVOKE_CUSTOM r0, r1, r2, method: emu.grasscutter.utils.Position.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, (, , )]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, (, , )]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    @Override // java.lang.Object
    public java.lang.String toString() {
        /*
            r4 = this;
            r0 = r4
            float r0 = r0.getX()
            java.lang.String r0 = java.lang.Float.toString(r0)
            r1 = r4
            float r1 = r1.getY()
            java.lang.String r1 = java.lang.Float.toString(r1)
            r2 = r4
            float r2 = r2.getZ()
            java.lang.String r2 = java.lang.Float.toString(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, Ljava/lang/String;)Ljava/lang/String;}, (, , )]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.utils.Position.toString():java.lang.String");
    }

    public float getX() {
        return this.f968x;
    }

    public void setX(float x) {
        this.f968x = x;
    }

    public float getY() {
        return this.f969y;
    }

    public void setY(float y) {
        this.f969y = y;
    }

    public float getZ() {
        return this.f970z;
    }

    public void setZ(float z) {
        this.f970z = z;
    }

    public Position() {
    }

    public Position(float x, float y) {
        set(x, y);
    }

    public Position(float x, float y, float z) {
        set(x, y, z);
    }

    public Position(String p) {
        String[] split = p.split(",");
        if (split.length >= 2) {
            this.f968x = Float.parseFloat(split[0]);
            this.f969y = Float.parseFloat(split[1]);
        }
        if (split.length >= 3) {
            this.f970z = Float.parseFloat(split[2]);
        }
    }

    public Position(VectorOuterClass.Vector vector) {
        set(vector);
    }

    public Position(Position pos) {
        set(pos);
    }

    public Position set(float x, float y) {
        this.f968x = x;
        this.f969y = y;
        return this;
    }

    public Position set(Position pos) {
        return set(pos.getX(), pos.getY(), pos.getZ());
    }

    public Position set(VectorOuterClass.Vector pos) {
        return set(pos.getX(), pos.getY(), pos.getZ());
    }

    public Position set(float x, float y, float z) {
        this.f968x = x;
        this.f969y = y;
        this.f970z = z;
        return this;
    }

    public Position add(Position add) {
        this.f968x += add.getX();
        this.f969y += add.getY();
        this.f970z += add.getZ();
        return this;
    }

    public Position addX(float d) {
        this.f968x += d;
        return this;
    }

    public Position addY(float d) {
        this.f969y += d;
        return this;
    }

    public Position addZ(float d) {
        this.f970z += d;
        return this;
    }

    public Position subtract(Position sub) {
        this.f968x -= sub.getX();
        this.f969y -= sub.getY();
        this.f970z -= sub.getZ();
        return this;
    }

    public Position translate(float dist, float angle) {
        this.f968x = (float) (((double) this.f968x) + (((double) dist) * Math.sin((double) angle)));
        this.f969y = (float) (((double) this.f969y) + (((double) dist) * Math.cos((double) angle)));
        return this;
    }

    public boolean equal2d(Position other) {
        return getX() == other.getX() && getZ() == other.getZ();
    }

    public boolean equal3d(Position other) {
        return getX() == other.getX() && getY() == other.getY() && getZ() == other.getZ();
    }

    public double computeDistance(Position b) {
        double detX = (double) (getX() - b.getX());
        double detY = (double) (getY() - b.getY());
        double detZ = (double) (getZ() - b.getZ());
        return Math.sqrt((detX * detX) + (detY * detY) + (detZ * detZ));
    }

    public boolean isnull() {
        return Float.isNaN(getX()) && Float.isNaN(getY()) && Float.isNaN(getZ());
    }

    public Position nearby2d(int range) {
        Position position = clone();
        position.f970z += Utils.randomFloatRange((float) (-range), (float) range);
        position.f968x += Utils.randomFloatRange((float) (-range), (float) range);
        return position;
    }

    public Position nearby2d(float range) {
        return nearby2d((int) range);
    }

    public Position translateWithDegrees(float dist, float angle) {
        float angle2 = (float) Math.toRadians((double) angle);
        this.f968x = (float) (((double) this.f968x) + (((double) dist) * Math.sin((double) angle2)));
        this.f969y = (float) (((double) this.f969y) + (((double) (-dist)) * Math.cos((double) angle2)));
        return this;
    }

    @Override // java.lang.Object
    public Position clone() {
        return new Position(this.f968x, this.f969y, this.f970z);
    }

    public VectorOuterClass.Vector toProto() {
        return VectorOuterClass.Vector.newBuilder().setX(getX()).setY(getY()).setZ(getZ()).build();
    }

    public Point toPoint() {
        return Point.create((double) this.f968x, (double) this.f969y, (double) this.f970z);
    }

    public double[] toDoubleArray() {
        return new double[]{(double) this.f968x, (double) this.f969y, (double) this.f970z};
    }

    public double[] toXZDoubleArray() {
        return new double[]{(double) this.f968x, (double) this.f970z};
    }
}
