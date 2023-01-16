package dev.morphia.query.experimental.filters;

import com.mongodb.QueryOperators;
import com.mongodb.client.model.geojson.Geometry;
import com.mongodb.client.model.geojson.MultiPolygon;
import com.mongodb.client.model.geojson.Point;
import com.mongodb.client.model.geojson.Polygon;
import dev.morphia.aggregation.experimental.codecs.ExpressionHelper;
import dev.morphia.aggregation.experimental.expressions.impls.Expression;
import dev.morphia.mapping.Mapper;
import dev.morphia.query.Type;
import java.util.Arrays;
import org.bson.BsonWriter;
import org.bson.Document;
import org.bson.codecs.EncoderContext;

/* loaded from: grasscutter.jar:dev/morphia/query/experimental/filters/Filters.class */
public final class Filters {
    private Filters() {
    }

    public static Filter all(String field, Object val) {
        return new Filter(QueryOperators.ALL, field, val);
    }

    public static Filter and(Filter... filters) {
        return new LogicalFilter(QueryOperators.AND, filters);
    }

    public static Filter bitsAllClear(String field, int[] positions) {
        return new Filter("$bitsAllClear", field, positions);
    }

    public static Filter bitsAllClear(String field, int bitMask) {
        return new Filter("$bitsAllClear", field, Integer.valueOf(bitMask));
    }

    public static Filter bitsAllSet(String field, int bitMask) {
        return new Filter("$bitsAllSet", field, Integer.valueOf(bitMask));
    }

    public static Filter bitsAllSet(String field, int[] positions) {
        return new Filter("$bitsAllSet", field, positions);
    }

    public static Filter bitsAnyClear(String field, Object val) {
        return new Filter("$bitsAnyClear", field, val);
    }

    public static Filter bitsAnySet(String field, Object val) {
        return new Filter("$bitsAnySet", field, val);
    }

    public static Filter box(String field, Point bottomLeft, Point upperRight) {
        return new Box(field, bottomLeft, upperRight);
    }

    public static Filter center(String field, Point center, double radius) {
        return new CenterFilter(QueryOperators.CENTER, field, center, radius);
    }

    public static Filter centerSphere(String field, Point center, double radius) {
        return new CenterFilter(QueryOperators.CENTER_SPHERE, field, center, radius);
    }

    public static Filter comment(String field, Object val) {
        return new Filter("$comment", field, val);
    }

    public static Filter elemMatch(String field, Filter... filters) {
        return new ElemMatchFilter(field, Arrays.asList(filters));
    }

    /* renamed from: eq */
    public static Filter m1223eq(String field, Object val) {
        return new Filter("$eq", field, val) { // from class: dev.morphia.query.experimental.filters.Filters.1
            @Override // dev.morphia.query.experimental.filters.Filter
            public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                if (isNot()) {
                    ExpressionHelper.document(writer, path(mapper), ()
                    /*  JADX ERROR: Method code generation error
                        jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0016: INVOKE  
                          (r9v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter)])
                          (wrap: java.lang.String : 0x000a: INVOKE  (r1v3 java.lang.String A[REMOVE]) = 
                          (r7v0 'this' dev.morphia.query.experimental.filters.Filters$1 A[D('this' dev.morphia.query.experimental.filters.Filters$1), IMMUTABLE_TYPE, THIS])
                          (r8v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper)])
                         type: VIRTUAL call: dev.morphia.query.experimental.filters.Filters.1.path(dev.morphia.mapping.Mapper):java.lang.String)
                          (wrap: java.lang.Runnable : 0x0011: INVOKE_CUSTOM (r2v5 java.lang.Runnable A[REMOVE]) = 
                          (r7v0 'this' dev.morphia.query.experimental.filters.Filters$1 A[D('this' dev.morphia.query.experimental.filters.Filters$1), DONT_INLINE, IMMUTABLE_TYPE, THIS])
                          (r9v0 'writer' org.bson.BsonWriter A[D('writer' org.bson.BsonWriter), DONT_INLINE])
                          (r8v0 'mapper' dev.morphia.mapping.Mapper A[D('mapper' dev.morphia.mapping.Mapper), DONT_INLINE])
                          (r10v0 'context' org.bson.codecs.EncoderContext A[D('context' org.bson.codecs.EncoderContext), DONT_INLINE])
                        
                         handle type: INVOKE_DIRECT
                         lambda: java.lang.Runnable.run():void
                         call insn: ?: INVOKE  
                          (r2 I:dev.morphia.query.experimental.filters.Filters$1)
                          (r3 I:org.bson.BsonWriter)
                          (r4 I:dev.morphia.mapping.Mapper)
                          (r5 I:org.bson.codecs.EncoderContext)
                         type: DIRECT call: dev.morphia.query.experimental.filters.Filters.1.lambda$encode$1(org.bson.BsonWriter, dev.morphia.mapping.Mapper, org.bson.codecs.EncoderContext):void)
                         type: STATIC call: dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(org.bson.BsonWriter, java.lang.String, java.lang.Runnable):void in method: dev.morphia.query.experimental.filters.Filters.1.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void, file: grasscutter.jar:dev/morphia/query/experimental/filters/Filters$1.class
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                        	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                        	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:94)
                        	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:137)
                        	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:137)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.dex.regions.Region.generate(Region.java:35)
                        	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                        	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                        	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                        	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                        	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                        	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                        	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                        	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                        	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                        Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
                        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
                        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
                        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
                        	at java.base/java.util.Objects.checkIndex(Objects.java:359)
                        	at java.base/java.util.ArrayList.get(ArrayList.java:427)
                        	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
                        	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                        	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                        	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                        	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                        	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                        	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                        	... 21 more
                        */
                    /*
                        this = this;
                        r0 = r7
                        boolean r0 = r0.isNot()
                        if (r0 == 0) goto L_0x001c
                        r0 = r9
                        r1 = r7
                        r2 = r8
                        java.lang.String r1 = r1.path(r2)
                        r2 = r7
                        r3 = r9
                        r4 = r8
                        r5 = r10
                        void r2 = () -> { // java.lang.Runnable.run():void
                            r2.lambda$encode$1(r3, r4, r5);
                        }
                        dev.morphia.aggregation.experimental.codecs.ExpressionHelper.document(r0, r1, r2)
                        goto L_0x002d
                    L_0x001c:
                        r0 = r7
                        r1 = r7
                        r2 = r8
                        java.lang.String r1 = r1.path(r2)
                        r2 = r7
                        r3 = r8
                        java.lang.Object r2 = r2.getValue(r3)
                        r3 = r8
                        r4 = r9
                        r5 = r10
                        r0.writeNamedValue(r1, r2, r3, r4, r5)
                    L_0x002d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: dev.morphia.query.experimental.filters.Filters.C13341.encode(dev.morphia.mapping.Mapper, org.bson.BsonWriter, org.bson.codecs.EncoderContext):void");
                }
            };
        }

        public static Filter exists(String field) {
            return new Filter(QueryOperators.EXISTS, field, null) { // from class: dev.morphia.query.experimental.filters.Filters.2
                @Override // dev.morphia.query.experimental.filters.Filter
                public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                    writer.writeStartDocument(path(mapper));
                    writer.writeName(getName());
                    writer.writeBoolean(!isNot());
                    writer.writeEndDocument();
                }
            };
        }

        public static Filter expr(Expression expression) {
            return new Filter("$expr", null, expression) { // from class: dev.morphia.query.experimental.filters.Filters.3
                @Override // dev.morphia.query.experimental.filters.Filter
                public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                    writer.writeName("$expr");
                    Expression value = getValue();
                    if (value != null) {
                        value.encode(mapper, writer, context);
                    } else {
                        writer.writeNull();
                    }
                }

                @Override // dev.morphia.query.experimental.filters.Filter
                public Expression getValue() {
                    return (Expression) getValue();
                }
            };
        }

        public static Filter geoIntersects(String field, Geometry val) {
            return new GeoIntersectsFilter(field, val);
        }

        public static GeoWithinFilter geoWithin(String field, Polygon polygon) {
            return new GeoWithinFilter(field, polygon);
        }

        public static GeoWithinFilter geoWithin(String field, MultiPolygon polygon) {
            return new GeoWithinFilter(field, polygon);
        }

        public static Filter geometry(String field, Object val) {
            return new Filter("$geometry", field, val);
        }

        /* renamed from: gt */
        public static Filter m1222gt(String field, Object val) {
            return new Filter(QueryOperators.f429GT, field, val);
        }

        public static Filter gte(String field, Object val) {
            return new Filter(QueryOperators.GTE, field, val);
        }

        /* renamed from: in */
        public static Filter m1221in(String field, Iterable<?> val) {
            return new Filter(QueryOperators.f432IN, field, val);
        }

        @Deprecated(forRemoval = true)
        public static Filter jsonSchema(String field, Object val) {
            return jsonSchema(Document.parse(val.toString()));
        }

        public static Filter jsonSchema(final Document schema) {
            return new Filter("$jsonSchema", null, schema) { // from class: dev.morphia.query.experimental.filters.Filters.4
                @Override // dev.morphia.query.experimental.filters.Filter
                public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                    ExpressionHelper.value(mapper, writer, "$jsonSchema", schema, context);
                }
            };
        }

        /* renamed from: lt */
        public static Filter m1220lt(String field, Object val) {
            return new Filter(QueryOperators.f430LT, field, val);
        }

        public static Filter lte(String field, Object val) {
            return new Filter(QueryOperators.LTE, field, val);
        }

        public static Filter maxDistance(String field, Object val) {
            return new Filter(QueryOperators.MAX_DISTANCE, field, val);
        }

        public static Filter minDistance(String field, Object val) {
            return new Filter("$minDistance", field, val);
        }

        public static Filter mod(String field, final long divisor, final long remainder) {
            return new Filter(QueryOperators.MOD, field, null) { // from class: dev.morphia.query.experimental.filters.Filters.5
                @Override // dev.morphia.query.experimental.filters.Filter
                public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                    writer.writeStartDocument(path(mapper));
                    writer.writeName(getName());
                    writer.writeStartArray();
                    writeUnnamedValue(Long.valueOf(divisor), mapper, writer, context);
                    writeUnnamedValue(Long.valueOf(remainder), mapper, writer, context);
                    writer.writeEndArray();
                    writer.writeEndDocument();
                }
            };
        }

        /* renamed from: ne */
        public static Filter m1219ne(String field, Object val) {
            return new Filter(QueryOperators.f431NE, field, val);
        }

        public static NearFilter near(String field, Point point) {
            return new NearFilter(QueryOperators.NEAR, field, point);
        }

        public static NearFilter nearSphere(String field, Point point) {
            return new NearFilter(QueryOperators.NEAR_SPHERE, field, point);
        }

        public static Filter nin(String field, Object val) {
            return new Filter(QueryOperators.NIN, field, val);
        }

        public static Filter nor(Filter... filters) {
            return new LogicalFilter(QueryOperators.NOR, filters);
        }

        /* renamed from: or */
        public static Filter m1218or(Filter... filters) {
            return new LogicalFilter(QueryOperators.f428OR, filters);
        }

        public static Filter polygon(String field, Point... points) {
            return new PolygonFilter(field, points);
        }

        public static RegexFilter regex(String field) {
            return new RegexFilter(field);
        }

        public static Filter size(String field, int size) {
            return new Filter(QueryOperators.SIZE, field, Integer.valueOf(size));
        }

        public static TextSearchFilter text(String textSearch) {
            return new TextSearchFilter(textSearch);
        }

        public static Filter type(String field, Type val) {
            return new Filter("$type", field, val.toString().toLowerCase());
        }

        public static Filter uniqueDocs(String field, Object val) {
            return new Filter(QueryOperators.UNIQUE_DOCS, field, val);
        }

        public static Filter where(String val) {
            return new Filter(QueryOperators.WHERE, null, val) { // from class: dev.morphia.query.experimental.filters.Filters.6
                @Override // dev.morphia.query.experimental.filters.Filter
                public void encode(Mapper mapper, BsonWriter writer, EncoderContext context) {
                    writer.writeName(getName());
                    Object where = getValue(mapper);
                    if (where != null) {
                        String value = where.toString().trim();
                        if (!value.startsWith("function()")) {
                            value = String.format("function() { %s }", value);
                        }
                        writer.writeString(value);
                        return;
                    }
                    writer.writeNull();
                }
            };
        }
    }
