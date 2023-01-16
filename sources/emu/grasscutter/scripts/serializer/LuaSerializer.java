package emu.grasscutter.scripts.serializer;

import com.esotericsoftware.reflectasm.ConstructorAccess;
import com.esotericsoftware.reflectasm.MethodAccess;
import emu.grasscutter.Grasscutter;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import javax.annotation.Nullable;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/serializer/LuaSerializer.class */
public class LuaSerializer implements Serializer {
    private static final Map<Class<?>, MethodAccess> methodAccessCache = new ConcurrentHashMap();
    private static final Map<Class<?>, ConstructorAccess<?>> constructorCache = new ConcurrentHashMap();
    private static final Map<Class<?>, Map<String, FieldMeta>> fieldMetaCache = new ConcurrentHashMap();

    /*  JADX ERROR: Dependency scan failed at insn: 0x0019: INVOKE_CUSTOM r-1
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
    /*  JADX ERROR: Dependency scan failed at insn: 0x002C: INVOKE_CUSTOM r-4, r-3
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
    /*  JADX ERROR: Failed to decode insn: 0x0019: INVOKE_CUSTOM r0, method: emu.grasscutter.scripts.serializer.LuaSerializer.getSetterName(java.lang.String):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, set]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, set]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    /*  JADX ERROR: Failed to decode insn: 0x002C: INVOKE_CUSTOM r0, r1, method: emu.grasscutter.scripts.serializer.LuaSerializer.getSetterName(java.lang.String):java.lang.String
        jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (C, Ljava/lang/String;)Ljava/lang/String;}, set]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
        	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
        	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
        	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
        	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
        	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
        	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
        	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
        	at jadx.core.ProcessClass.process(ProcessClass.java:53)
        	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
        	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
        Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (C, Ljava/lang/String;)Ljava/lang/String;}, set]}
        	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
        	... 11 more
        */
    public java.lang.String getSetterName(java.lang.String r5) {
        /*
            r4 = this;
            r0 = r5
            if (r0 == 0) goto L_0x000b
            r0 = r5
            int r0 = r0.length()
            if (r0 != 0) goto L_0x000d
            r0 = 0
            return r0
            r0 = r5
            int r0 = r0.length()
            r1 = 1
            if (r0 != r1) goto L_0x001f
            r0 = r5
            java.lang.String r0 = r0.toUpperCase()
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;)Ljava/lang/String;}, set]}
            return r0
            r0 = r5
            r1 = 0
            char r0 = r0.charAt(r1)
            char r0 = java.lang.Character.toUpperCase(r0)
            r1 = r5
            r2 = 1
            java.lang.String r1 = r1.substring(r2)
            // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (C, Ljava/lang/String;)Ljava/lang/String;}, set]}
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.serializer.LuaSerializer.getSetterName(java.lang.String):java.lang.String");
    }

    @Override // emu.grasscutter.scripts.serializer.Serializer
    public <T> List<T> toList(Class<T> type, Object obj) {
        return serializeList(type, (LuaTable) obj);
    }

    @Override // emu.grasscutter.scripts.serializer.Serializer
    public <T> T toObject(Class<T> type, Object obj) {
        return (T) serialize(type, null, (LuaTable) obj);
    }

    @Override // emu.grasscutter.scripts.serializer.Serializer
    public <T> Map<String, T> toMap(Class<T> type, Object obj) {
        return serializeMap(type, (LuaTable) obj);
    }

    private <T> Map<String, T> serializeMap(Class<T> type, LuaTable table) {
        Object obj;
        HashMap hashMap = new HashMap();
        if (table == null) {
            return hashMap;
        }
        try {
            LuaValue[] keys = table.keys();
            for (LuaValue k : keys) {
                LuaValue keyValue = table.get(k);
                if (keyValue.istable()) {
                    obj = serialize(type, null, keyValue.checktable());
                } else {
                    try {
                        if (keyValue.isint()) {
                            obj = Integer.valueOf(keyValue.toint());
                        } else if (keyValue.isnumber()) {
                            obj = Float.valueOf(keyValue.tofloat());
                        } else if (keyValue.isstring()) {
                            obj = keyValue.tojstring();
                        } else if (keyValue.isboolean()) {
                            obj = Boolean.valueOf(keyValue.toboolean());
                        } else {
                            obj = keyValue;
                        }
                    } catch (Exception e) {
                    }
                }
                if (obj != null) {
                    hashMap.put(String.valueOf(k), obj);
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return hashMap;
    }

    public <T> List<T> serializeList(Class<T> type, LuaTable table) {
        Object obj;
        ArrayList arrayList = new ArrayList();
        if (table == null) {
            return arrayList;
        }
        try {
            for (LuaValue k : table.keys()) {
                LuaValue keyValue = table.get(k);
                if (keyValue.istable()) {
                    obj = serialize(type, null, keyValue.checktable());
                } else {
                    try {
                        if (keyValue.isint()) {
                            obj = Integer.valueOf(keyValue.toint());
                        } else if (keyValue.isnumber()) {
                            obj = Float.valueOf(keyValue.tofloat());
                        } else if (keyValue.isstring()) {
                            obj = keyValue.tojstring();
                        } else if (keyValue.isboolean()) {
                            obj = Boolean.valueOf(keyValue.toboolean());
                        } else {
                            obj = keyValue;
                        }
                    } catch (Exception e) {
                    }
                }
                if (obj != null) {
                    arrayList.add(obj);
                }
            }
        } catch (Exception e2) {
            Grasscutter.getLogger().debug("Error serialize1:", (Throwable) e2);
        }
        return arrayList;
    }

    private Class<?> getListType(Class<?> type, @Nullable Field field) {
        if (field == null) {
            return type.getTypeParameters()[0].getClass();
        }
        Type fieldType = field.getGenericType();
        if (fieldType instanceof ParameterizedType) {
            return (Class) ((ParameterizedType) fieldType).getActualTypeArguments()[0];
        }
        return null;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:40:0x01b7
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public <T> T serialize(java.lang.Class<T> r12, @javax.annotation.Nullable java.lang.reflect.Field r13, org.luaj.vm2.LuaTable r14) {
        /*
        // Method dump skipped, instructions count: 478
        */
        throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.serializer.LuaSerializer.serialize(java.lang.Class, java.lang.reflect.Field, org.luaj.vm2.LuaTable):java.lang.Object");
    }

    public <T> Map<String, FieldMeta> cacheType(Class<T> type) {
        if (fieldMetaCache.containsKey(type)) {
            return fieldMetaCache.get(type);
        }
        if (!constructorCache.containsKey(type)) {
            constructorCache.putIfAbsent(type, ConstructorAccess.get(type));
        }
        MethodAccess methodAccess = (MethodAccess) Optional.ofNullable(methodAccessCache.get(type)).orElse(MethodAccess.get(type));
        methodAccessCache.putIfAbsent(type, methodAccess);
        HashMap<String, FieldMeta> fieldMetaMap = new HashMap<>();
        HashSet<String> methodNameSet = new HashSet<>(Arrays.stream(methodAccess.getMethodNames()).toList());
        Arrays.stream(type.getDeclaredFields()).filter(field -> {
            return methodNameSet.contains(getSetterName(methodNameSet.getName()));
        }).forEach(field -> {
            String setter = getSetterName(fieldMetaMap.getName());
            methodAccess.put(fieldMetaMap.getName(), new FieldMeta(fieldMetaMap.getName(), setter, methodAccess.getIndex(setter), fieldMetaMap.getType(), fieldMetaMap));
        });
        Arrays.stream(type.getFields()).filter(field -> {
            return !fieldMetaMap.containsKey(field.getName());
        }).filter(field -> {
            return methodNameSet.contains(getSetterName(methodNameSet.getName()));
        }).forEach(field -> {
            String setter = getSetterName(fieldMetaMap.getName());
            methodAccess.put(fieldMetaMap.getName(), new FieldMeta(fieldMetaMap.getName(), setter, methodAccess.getIndex(setter), fieldMetaMap.getType(), fieldMetaMap));
        });
        fieldMetaCache.put(type, fieldMetaMap);
        return fieldMetaMap;
    }

    /* access modifiers changed from: package-private */
    /* loaded from: grasscutter.jar:emu/grasscutter/scripts/serializer/LuaSerializer$FieldMeta.class */
    public static class FieldMeta {
        private String name;
        private String setter;
        private int index;
        private Class<?> type;
        @Nullable
        private Field field;

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
        /*  JADX ERROR: Failed to decode insn: 0x0014: INVOKE_CUSTOM r0, r1, r2, r3, r4, method: emu.grasscutter.scripts.serializer.LuaSerializer.FieldMeta.toString():java.lang.String
            jadx.core.utils.exceptions.JadxRuntimeException: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/Class;, Ljava/lang/reflect/Field;)Ljava/lang/String;}, LuaSerializer.FieldMeta(name=, setter=, index=, type=, field=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:55)
            	at jadx.core.dex.instructions.InsnDecoder.invoke(InsnDecoder.java:568)
            	at jadx.core.dex.instructions.InsnDecoder.decode(InsnDecoder.java:438)
            	at jadx.core.dex.instructions.InsnDecoder.lambda$process$0(InsnDecoder.java:48)
            	at jadx.plugins.input.java.data.code.JavaCodeReader.visitInstructions(JavaCodeReader.java:82)
            	at jadx.core.dex.instructions.InsnDecoder.process(InsnDecoder.java:43)
            	at jadx.core.dex.nodes.MethodNode.load(MethodNode.java:194)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:309)
            	at jadx.core.dex.nodes.ClassNode.load(ClassNode.java:315)
            	at jadx.core.ProcessClass.process(ProcessClass.java:53)
            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:87)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:300)
            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:265)
            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/Class;, Ljava/lang/reflect/Field;)Ljava/lang/String;}, LuaSerializer.FieldMeta(name=, setter=, index=, type=, field=)]}
            	at jadx.core.dex.instructions.InvokeCustomBuilder.build(InvokeCustomBuilder.java:42)
            	... 12 more
            */
        public java.lang.String toString() {
            /*
                r6 = this;
                r0 = r6
                java.lang.String r0 = r0.getName()
                r1 = r6
                java.lang.String r1 = r1.getSetter()
                r2 = r6
                int r2 = r2.getIndex()
                r3 = r6
                java.lang.Class r3 = r3.getType()
                r4 = r6
                java.lang.reflect.Field r4 = r4.getField()
                // decode failed: 'invoke-custom' instruction processing error: Failed to process invoke-custom instruction: CallSite{[{ENCODED_METHOD_HANDLE: INVOKE_STATIC: Ljava/lang/invoke/StringConcatFactory;->makeConcatWithConstants(Ljava/lang/invoke/MethodHandles$Lookup;Ljava/lang/String;Ljava/lang/invoke/MethodType;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/invoke/CallSite;}, makeConcatWithConstants, {ENCODED_METHOD_TYPE: (Ljava/lang/String;, Ljava/lang/String;, I, Ljava/lang/Class;, Ljava/lang/reflect/Field;)Ljava/lang/String;}, LuaSerializer.FieldMeta(name=, setter=, index=, type=, field=)]}
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: emu.grasscutter.scripts.serializer.LuaSerializer.FieldMeta.toString():java.lang.String");
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setSetter(String setter) {
            this.setter = setter;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setType(Class<?> type) {
            this.type = type;
        }

        public void setField(@Nullable Field field) {
            this.field = field;
        }

        public boolean equals(Object o) {
            if (o == this) {
                return true;
            }
            if (!(o instanceof FieldMeta)) {
                return false;
            }
            FieldMeta other = (FieldMeta) o;
            if (!other.canEqual(this) || getIndex() != other.getIndex()) {
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
            Object this$setter = getSetter();
            Object other$setter = other.getSetter();
            if (this$setter == null) {
                if (other$setter != null) {
                    return false;
                }
            } else if (!this$setter.equals(other$setter)) {
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
            Object this$field = getField();
            Object other$field = other.getField();
            return this$field == null ? other$field == null : this$field.equals(other$field);
        }

        protected boolean canEqual(Object other) {
            return other instanceof FieldMeta;
        }

        public int hashCode() {
            int result = (1 * 59) + getIndex();
            Object $name = getName();
            int result2 = (result * 59) + ($name == null ? 43 : $name.hashCode());
            Object $setter = getSetter();
            int result3 = (result2 * 59) + ($setter == null ? 43 : $setter.hashCode());
            Object $type = getType();
            int result4 = (result3 * 59) + ($type == null ? 43 : $type.hashCode());
            Object $field = getField();
            return (result4 * 59) + ($field == null ? 43 : $field.hashCode());
        }

        public FieldMeta(String name, String setter, int index, Class<?> type, @Nullable Field field) {
            this.name = name;
            this.setter = setter;
            this.index = index;
            this.type = type;
            this.field = field;
        }

        public String getName() {
            return this.name;
        }

        public String getSetter() {
            return this.setter;
        }

        public int getIndex() {
            return this.index;
        }

        public Class<?> getType() {
            return this.type;
        }

        @Nullable
        public Field getField() {
            return this.field;
        }
    }
}
