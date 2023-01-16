package dev.morphia.geo;

import com.mongodb.client.model.geojson.PolygonCoordinates;
import com.mongodb.lang.Nullable;
import dev.morphia.annotations.AbstractC1283Id;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.bson.types.ObjectId;

@Deprecated(since = "2.0", forRemoval = true)
/* loaded from: grasscutter.jar:dev/morphia/geo/Polygon.class */
public class Polygon implements Geometry {
    @AbstractC1283Id

    /* renamed from: id */
    private ObjectId f477id;
    private final LineString exteriorBoundary;
    private final List<LineString> interiorBoundaries;

    /*  JADX ERROR: Dependency scan failed at insn: 0x0008: INVOKE_CUSTOM r-2, r-1
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
    /*  JADX ERROR: Failed to decode insn: 0x0008: INVOKE_CUSTOM r0, r1, method: dev.morphia.geo.Polygon.toString():java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/geo/LineString;, Ljava/util/List;)Ljava/lang/String;}, Polygon{exteriorBoundary=, interiorBoundaries=}]}
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
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/geo/LineString;, Ljava/util/List;)Ljava/lang/String;}, Polygon{exteriorBoundary=, interiorBoundaries=}]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String toString() {
        /*
            r3 = this;
            r0 = r3
            dev.morphia.geo.LineString r0 = r0.exteriorBoundary
            r1 = r3
            java.util.List<dev.morphia.geo.LineString> r1 = r1.interiorBoundaries
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ldev/morphia/geo/LineString;, Ljava/util/List;)Ljava/lang/String;}, Polygon{exteriorBoundary=, interiorBoundaries=}]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.geo.Polygon.toString():java.lang.String");
    }

    private Polygon() {
        this.exteriorBoundary = null;
        this.interiorBoundaries = new ArrayList();
    }

    /* access modifiers changed from: package-private */
    public Polygon(LineString exteriorBoundary, LineString... interiorBoundaries) {
        this.exteriorBoundary = exteriorBoundary;
        this.interiorBoundaries = Arrays.asList(interiorBoundaries);
    }

    /* access modifiers changed from: package-private */
    public Polygon(List<LineString> boundaries) {
        this.exteriorBoundary = boundaries.get(0);
        if (boundaries.size() > 1) {
            this.interiorBoundaries = boundaries.subList(1, boundaries.size());
        } else {
            this.interiorBoundaries = new ArrayList();
        }
    }

    @Override // dev.morphia.geo.Geometry
    public List<LineString> getCoordinates() {
        List<LineString> polygonBoundaries = new ArrayList<>();
        polygonBoundaries.add(this.exteriorBoundary);
        polygonBoundaries.addAll(this.interiorBoundaries);
        return polygonBoundaries;
    }

    public LineString getExteriorBoundary() {
        return this.exteriorBoundary;
    }

    public List<LineString> getInteriorBoundaries() {
        return Collections.unmodifiableList(this.interiorBoundaries);
    }

    public int hashCode() {
        return (31 * this.exteriorBoundary.hashCode()) + this.interiorBoundaries.hashCode();
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Polygon polygon = (Polygon) o;
        if (!this.exteriorBoundary.equals(polygon.exteriorBoundary)) {
            return false;
        }
        return this.interiorBoundaries.equals(polygon.interiorBoundaries);
    }

    @Override // dev.morphia.geo.Geometry
    public com.mongodb.client.model.geojson.Polygon convert() {
        return convert((CoordinateReferenceSystem) null);
    }

    @Override // dev.morphia.geo.Geometry
    public com.mongodb.client.model.geojson.Polygon convert(@Nullable CoordinateReferenceSystem crs) {
        return new com.mongodb.client.model.geojson.Polygon(crs != null ? crs.convert() : null, new PolygonCoordinates(this.exteriorBoundary.convert().getCoordinates(), (List[]) GeoJson.convertLineStrings(this.interiorBoundaries).toArray(new List[0])));
    }
}
