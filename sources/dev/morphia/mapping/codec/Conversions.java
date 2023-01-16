package dev.morphia.mapping.codec;

import com.mongodb.lang.Nullable;
import java.math.BigDecimal;
import java.net.URI;
import java.time.Instant;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;
import org.bson.types.Binary;
import org.bson.types.ObjectId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/* loaded from: grasscutter.jar:dev/morphia/mapping/codec/Conversions.class */
public final class Conversions {
    private static final Logger LOG = LoggerFactory.getLogger(Conversions.class);
    private static final Map<Class<?>, Map<Class<?>, Function<?, ?>>> CONVERSIONS = new HashMap();

    static {
        registerStringConversions();
        register(Binary.class, byte[].class, (v0) -> {
            return v0.getData();
        });
        register(Date.class, Long.class, (v0) -> {
            return v0.getTime();
        });
        register(Date.class, Long.TYPE, (v0) -> {
            return v0.getTime();
        });
        register(Instant.class, Long.class, (v0) -> {
            return v0.toEpochMilli();
        });
        register(Instant.class, Long.TYPE, (v0) -> {
            return v0.toEpochMilli();
        });
        register(Double.class, Long.class, (v0) -> {
            return v0.longValue();
        }, "Converting a double value to a long.  Possible loss of precision.");
        register(Double.class, Integer.class, (v0) -> {
            return v0.intValue();
        }, "Converting a double value to an int.  Possible loss of precision.");
        register(Double.class, Float.class, (v0) -> {
            return v0.floatValue();
        }, "Converting a double value to a float.  Possible loss of precision.");
        register(Integer.class, Byte.class, (v0) -> {
            return v0.byteValue();
        });
        register(Long.class, Date.class, l -> {
            return Date.from(Instant.ofEpochMilli(l.longValue()));
        });
        register(Long.class, Double.class, (v0) -> {
            return v0.doubleValue();
        });
        register(Long.class, Float.class, (v0) -> {
            return v0.floatValue();
        });
        register(Float.class, Long.class, (v0) -> {
            return v0.longValue();
        }, "Converting a float value to a long.  Possible loss of precision.");
        register(Float.class, Integer.class, (v0) -> {
            return v0.intValue();
        }, "Converting a float value to an int.  Possible loss of precision.");
        register(URI.class, String.class, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x00d2: INVOKE  
              (wrap: java.lang.Class : 0x00c9: CONST_CLASS   java.net.URI.class)
              (wrap: java.lang.Class : 0x00cb: CONST_CLASS   java.lang.String.class)
              (wrap: java.util.function.Function : 0x00cd: INVOKE_CUSTOM (r2v14 java.util.function.Function A[REMOVE]) = 
             handle type: INVOKE_STATIC
             lambda: java.util.function.Function.apply(java.lang.Object):java.lang.Object
             call insn: ?: INVOKE  (v0 java.net.URI) type: STATIC call: dev.morphia.mapping.codec.Conversions.lambda$static$1(java.net.URI):java.lang.String)
             type: STATIC call: dev.morphia.mapping.codec.Conversions.register(java.lang.Class, java.lang.Class, java.util.function.Function):void in method: dev.morphia.mapping.codec.Conversions.<clinit>():void, file: grasscutter.jar:dev/morphia/mapping/codec/Conversions.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
            	... 15 more
            */
        /*
            java.lang.Class<dev.morphia.mapping.codec.Conversions> r0 = dev.morphia.mapping.codec.Conversions.class
            org.slf4j.Logger r0 = org.slf4j.LoggerFactory.getLogger(r0)
            dev.morphia.mapping.codec.Conversions.LOG = r0
            java.util.HashMap r0 = new java.util.HashMap
            r1 = r0
            r1.<init>()
            dev.morphia.mapping.codec.Conversions.CONVERSIONS = r0
            registerStringConversions()
            java.lang.Class<org.bson.types.Binary> r0 = org.bson.types.Binary.class
            java.lang.Class<byte[]> r1 = byte[].class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getData();
            }
            register(r0, r1, r2)
            java.lang.Class<java.util.Date> r0 = java.util.Date.class
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getTime();
            }
            register(r0, r1, r2)
            java.lang.Class<java.util.Date> r0 = java.util.Date.class
            java.lang.Class r1 = java.lang.Long.TYPE
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.getTime();
            }
            register(r0, r1, r2)
            java.lang.Class<java.time.Instant> r0 = java.time.Instant.class
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.toEpochMilli();
            }
            register(r0, r1, r2)
            java.lang.Class<java.time.Instant> r0 = java.time.Instant.class
            java.lang.Class r1 = java.lang.Long.TYPE
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.toEpochMilli();
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.longValue();
            }
            java.lang.String r3 = "Converting a double value to a long.  Possible loss of precision."
            register(r0, r1, r2, r3)
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.intValue();
            }
            java.lang.String r3 = "Converting a double value to an int.  Possible loss of precision."
            register(r0, r1, r2, r3)
            java.lang.Class<java.lang.Double> r0 = java.lang.Double.class
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.floatValue();
            }
            java.lang.String r3 = "Converting a double value to a float.  Possible loss of precision."
            register(r0, r1, r2, r3)
            java.lang.Class<java.lang.Integer> r0 = java.lang.Integer.class
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.byteValue();
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            java.lang.Class<java.util.Date> r1 = java.util.Date.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$static$0(v0);
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.doubleValue();
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.Long> r0 = java.lang.Long.class
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.floatValue();
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.longValue();
            }
            java.lang.String r3 = "Converting a float value to a long.  Possible loss of precision."
            register(r0, r1, r2, r3)
            java.lang.Class<java.lang.Float> r0 = java.lang.Float.class
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return v0.intValue();
            }
            java.lang.String r3 = "Converting a float value to an int.  Possible loss of precision."
            register(r0, r1, r2, r3)
            java.lang.Class<java.net.URI> r0 = java.net.URI.class
            java.lang.Class<java.lang.String> r1 = java.lang.String.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$static$1(v0);
            }
            register(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.Conversions.m2820clinit():void");
    }

    private Conversions() {
    }

    private static void registerStringConversions() {
        register(String.class, BigDecimal.class, BigDecimal::new);
        register(String.class, ObjectId.class, ObjectId::new);
        register(String.class, Character.class, 
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0021: INVOKE  
              (wrap: java.lang.Class : 0x0018: CONST_CLASS   java.lang.String.class)
              (wrap: java.lang.Class : 0x001a: CONST_CLASS   java.lang.Character.class)
              (wrap: java.util.function.Function : 0x001c: INVOKE_CUSTOM (r2v2 java.util.function.Function A[REMOVE]) = 
             handle type: INVOKE_STATIC
             lambda: java.util.function.Function.apply(java.lang.Object):java.lang.Object
             call insn: ?: INVOKE  (v0 java.lang.String) type: STATIC call: dev.morphia.mapping.codec.Conversions.lambda$registerStringConversions$2(java.lang.String):java.lang.Character)
             type: STATIC call: dev.morphia.mapping.codec.Conversions.register(java.lang.Class, java.lang.Class, java.util.function.Function):void in method: dev.morphia.mapping.codec.Conversions.registerStringConversions():void, file: grasscutter.jar:dev/morphia/mapping/codec/Conversions.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
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
            Caused by: java.lang.NullPointerException: Cannot invoke "jadx.core.dex.instructions.args.SSAVar.getCodeVar()" because the return value of "jadx.core.dex.instructions.args.RegisterArg.getSVar()" is null
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:900)
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
            	... 15 more
            */
        /*
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.math.BigDecimal> r1 = java.math.BigDecimal.class
            void r2 = java.math.BigDecimal::new
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<org.bson.types.ObjectId> r1 = org.bson.types.ObjectId.class
            void r2 = org.bson.types.ObjectId::new
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Character> r1 = java.lang.Character.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$registerStringConversions$2(v0);
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Boolean> r1 = java.lang.Boolean.class
            void r2 = java.lang.Boolean::parseBoolean
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Byte> r1 = java.lang.Byte.class
            void r2 = java.lang.Byte::parseByte
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Double> r1 = java.lang.Double.class
            void r2 = java.lang.Double::parseDouble
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Integer> r1 = java.lang.Integer.class
            void r2 = java.lang.Integer::valueOf
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Long> r1 = java.lang.Long.class
            void r2 = java.lang.Long::parseLong
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Float> r1 = java.lang.Float.class
            void r2 = java.lang.Float::parseFloat
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.lang.Short> r1 = java.lang.Short.class
            void r2 = java.lang.Short::parseShort
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.net.URI> r1 = java.net.URI.class
            void r2 = (v0) -> { // java.util.function.Function.apply(java.lang.Object):java.lang.Object
                return lambda$registerStringConversions$3(v0);
            }
            register(r0, r1, r2)
            java.lang.Class<java.lang.String> r0 = java.lang.String.class
            java.lang.Class<java.util.UUID> r1 = java.util.UUID.class
            void r2 = java.util.UUID::fromString
            register(r0, r1, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: dev.morphia.mapping.codec.Conversions.registerStringConversions():void");
    }

    public static <S, T> void register(Class<S> source, Class<T> target, Function<S, T> function) {
        register(source, target, function, null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.lang.Object */
    /* JADX WARN: Multi-variable type inference failed */
    @Nullable
    public static <T> T convert(@Nullable Object value, Class<T> target) {
        if (value == 0) {
            return (T) convertNull(target);
        }
        Class<?> fromType = value.getClass();
        if (fromType.equals(target)) {
            return value;
        }
        Function function = CONVERSIONS.computeIfAbsent(fromType, f -> {
            return new HashMap();
        }).get(target);
        if (function != null) {
            return (T) function.apply(value);
        }
        if (target.equals(String.class)) {
            return (T) value.toString();
        }
        if (!target.isEnum() || !fromType.equals(String.class)) {
            return value;
        }
        return (T) Enum.valueOf(target, (String) value);
    }

    @Nullable
    private static Object convertNull(Class<?> toType) {
        if (isNumber(toType)) {
            return 0;
        }
        if (isBoolean(toType)) {
            return Boolean.FALSE;
        }
        return null;
    }

    public static <S, T> void register(Class<S> source, Class<T> target, Function<S, T> function, @Nullable String warning) {
        Function<?, ?> function2;
        if (warning == null) {
            function2 = function;
        } else {
            function2 = s -> {
                if (LOG.isWarnEnabled()) {
                    LOG.warn(warning);
                }
                return function.apply(s);
            };
        }
        CONVERSIONS.computeIfAbsent(source, c -> {
            return new HashMap();
        }).put(target, function2);
    }

    private static boolean isNumber(Class<?> type) {
        return type.isPrimitive() && !type.equals(Boolean.TYPE);
    }

    private static boolean isBoolean(Class<?> type) {
        return type.equals(Boolean.TYPE);
    }
}
