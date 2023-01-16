package net.bytebuddy.jar.asm;

import java.util.regex.Pattern;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:net/bytebuddy/jar/asm/Constants.class */
public final class Constants {
    static final String CONSTANT_VALUE = "ConstantValue";
    static final String CODE = "Code";
    static final String STACK_MAP_TABLE = "StackMapTable";
    static final String EXCEPTIONS = "Exceptions";
    static final String INNER_CLASSES = "InnerClasses";
    static final String ENCLOSING_METHOD = "EnclosingMethod";
    static final String SYNTHETIC = "Synthetic";
    static final String SIGNATURE = "Signature";
    static final String SOURCE_FILE = "SourceFile";
    static final String SOURCE_DEBUG_EXTENSION = "SourceDebugExtension";
    static final String LINE_NUMBER_TABLE = "LineNumberTable";
    static final String LOCAL_VARIABLE_TABLE = "LocalVariableTable";
    static final String LOCAL_VARIABLE_TYPE_TABLE = "LocalVariableTypeTable";
    static final String DEPRECATED = "Deprecated";
    static final String RUNTIME_VISIBLE_ANNOTATIONS = "RuntimeVisibleAnnotations";
    static final String RUNTIME_INVISIBLE_ANNOTATIONS = "RuntimeInvisibleAnnotations";
    static final String RUNTIME_VISIBLE_PARAMETER_ANNOTATIONS = "RuntimeVisibleParameterAnnotations";
    static final String RUNTIME_INVISIBLE_PARAMETER_ANNOTATIONS = "RuntimeInvisibleParameterAnnotations";
    static final String RUNTIME_VISIBLE_TYPE_ANNOTATIONS = "RuntimeVisibleTypeAnnotations";
    static final String RUNTIME_INVISIBLE_TYPE_ANNOTATIONS = "RuntimeInvisibleTypeAnnotations";
    static final String ANNOTATION_DEFAULT = "AnnotationDefault";
    static final String BOOTSTRAP_METHODS = "BootstrapMethods";
    static final String METHOD_PARAMETERS = "MethodParameters";
    static final String MODULE = "Module";
    static final String MODULE_PACKAGES = "ModulePackages";
    static final String MODULE_MAIN_CLASS = "ModuleMainClass";
    static final String NEST_HOST = "NestHost";
    static final String NEST_MEMBERS = "NestMembers";
    static final String PERMITTED_SUBCLASSES = "PermittedSubclasses";
    static final String RECORD = "Record";
    static final int ACC_CONSTRUCTOR = 262144;
    static final int F_INSERT = 256;
    static final int LDC_W = 19;
    static final int LDC2_W = 20;
    static final int ILOAD_0 = 26;
    static final int ILOAD_1 = 27;
    static final int ILOAD_2 = 28;
    static final int ILOAD_3 = 29;
    static final int LLOAD_0 = 30;
    static final int LLOAD_1 = 31;
    static final int LLOAD_2 = 32;
    static final int LLOAD_3 = 33;
    static final int FLOAD_0 = 34;
    static final int FLOAD_1 = 35;
    static final int FLOAD_2 = 36;
    static final int FLOAD_3 = 37;
    static final int DLOAD_0 = 38;
    static final int DLOAD_1 = 39;
    static final int DLOAD_2 = 40;
    static final int DLOAD_3 = 41;
    static final int ALOAD_0 = 42;
    static final int ALOAD_1 = 43;
    static final int ALOAD_2 = 44;
    static final int ALOAD_3 = 45;
    static final int ISTORE_0 = 59;
    static final int ISTORE_1 = 60;
    static final int ISTORE_2 = 61;
    static final int ISTORE_3 = 62;
    static final int LSTORE_0 = 63;
    static final int LSTORE_1 = 64;
    static final int LSTORE_2 = 65;
    static final int LSTORE_3 = 66;
    static final int FSTORE_0 = 67;
    static final int FSTORE_1 = 68;
    static final int FSTORE_2 = 69;
    static final int FSTORE_3 = 70;
    static final int DSTORE_0 = 71;
    static final int DSTORE_1 = 72;
    static final int DSTORE_2 = 73;
    static final int DSTORE_3 = 74;
    static final int ASTORE_0 = 75;
    static final int ASTORE_1 = 76;
    static final int ASTORE_2 = 77;
    static final int ASTORE_3 = 78;
    static final int WIDE = 196;
    static final int GOTO_W = 200;
    static final int JSR_W = 201;
    static final int WIDE_JUMP_OPCODE_DELTA = 33;
    static final int ASM_OPCODE_DELTA = 49;
    static final int ASM_IFNULL_OPCODE_DELTA = 20;
    static final int ASM_IFEQ = 202;
    static final int ASM_IFNE = 203;
    static final int ASM_IFLT = 204;
    static final int ASM_IFGE = 205;
    static final int ASM_IFGT = 206;
    static final int ASM_IFLE = 207;
    static final int ASM_IF_ICMPEQ = 208;
    static final int ASM_IF_ICMPNE = 209;
    static final int ASM_IF_ICMPLT = 210;
    static final int ASM_IF_ICMPGE = 211;
    static final int ASM_IF_ICMPGT = 212;
    static final int ASM_IF_ICMPLE = 213;
    static final int ASM_IF_ACMPEQ = 214;
    static final int ASM_IF_ACMPNE = 215;
    static final int ASM_GOTO = 216;
    static final int ASM_JSR = 217;
    static final int ASM_IFNULL = 218;
    static final int ASM_IFNONNULL = 219;
    static final int ASM_GOTO_W = 220;

    private Constants() {
    }

    /* access modifiers changed from: package-private */
    public static void checkAsmExperimental(Object caller) {
        Class<?> callerClass = caller.getClass();
        String internalName = callerClass.getName().replace('.', '/');
        if (!isWhitelisted(internalName)) {
            checkIsPreview(callerClass.getClassLoader().getResourceAsStream(internalName + ".class"));
        }
    }

    static boolean isWhitelisted(String internalName) {
        if (!internalName.startsWith("net/bytebuddy/jar/asm/")) {
            return false;
        }
        return internalName.contains("Test$") || Pattern.matches(new StringBuilder().append("net/bytebuddy/jar/asm/util/Trace").append("(Annotation|Class|Field|Method|Module|RecordComponent|Signature)").append("Visitor(\\$.*)?").toString(), internalName) || Pattern.matches(new StringBuilder().append("net/bytebuddy/jar/asm/util/Check").append("(Annotation|Class|Field|Method|Module|RecordComponent|Signature)").append("Adapter(\\$.*)?").toString(), internalName);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:9:0x0029
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static void checkIsPreview(java.io.InputStream r5) {
        /*
            r0 = r5
            if (r0 != 0) goto L_0x000f
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Bytecode not available, can't check class version"
            r1.<init>(r2)
            throw r0
        L_0x000f:
            java.io.DataInputStream r0 = new java.io.DataInputStream     // Catch: IOException -> 0x003c
            r1 = r0
            r2 = r5
            r1.<init>(r2)     // Catch: IOException -> 0x003c
            r7 = r0
            r0 = r7
            int r0 = r0.readInt()     // Catch: IOException -> 0x003c, Throwable -> 0x0029
            r0 = r7
            int r0 = r0.readUnsignedShort()     // Catch: IOException -> 0x003c, Throwable -> 0x0029
            r6 = r0
            r0 = r7
            r0.close()     // Catch: IOException -> 0x003c
            goto L_0x0039
        L_0x0029:
            r8 = move-exception
            r0 = r7
            r0.close()     // Catch: Throwable -> 0x0031, IOException -> 0x003c
            goto L_0x0037
        L_0x0031:
            r9 = move-exception
            r0 = r8
            r1 = r9
        L_0x0037:
            r0 = r8
            throw r0     // Catch: IOException -> 0x003c
        L_0x0039:
            goto L_0x0049
        L_0x003c:
            r7 = move-exception
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "I/O error, can't check class version"
            r3 = r7
            r1.<init>(r2, r3)
            throw r0
        L_0x0049:
            r0 = r6
            r1 = 65535(0xffff, float:9.1834E-41)
            if (r0 == r1) goto L_0x005b
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "ASM9_EXPERIMENTAL can only be used by classes compiled with --enable-preview"
            r1.<init>(r2)
            throw r0
        L_0x005b:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: net.bytebuddy.jar.asm.Constants.checkIsPreview(java.io.InputStream):void");
    }
}
