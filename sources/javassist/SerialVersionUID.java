package javassist;

import javassist.bytecode.Descriptor;

/* loaded from: grasscutter.jar:javassist/SerialVersionUID.class */
public class SerialVersionUID {
    public static void setSerialVersionUID(CtClass clazz) throws CannotCompileException, NotFoundException {
        try {
            clazz.getDeclaredField("serialVersionUID");
        } catch (NotFoundException e) {
            if (isSerializable(clazz)) {
                CtField field = new CtField(CtClass.longType, "serialVersionUID", clazz);
                field.setModifiers(26);
                clazz.addField(field, calculateDefault(clazz) + "L");
            }
        }
    }

    private static boolean isSerializable(CtClass clazz) throws NotFoundException {
        return clazz.subtypeOf(clazz.getClassPool().get("java.io.Serializable"));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r17v0 */
    /* JADX WARN: Type inference failed for: r17v1, types: [long] */
    /* JADX WARN: Type inference failed for: r17v4 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long calculateDefault(javassist.CtClass r5) throws javassist.CannotCompileException {
        /*
        // Method dump skipped, instructions count: 534
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.SerialVersionUID.calculateDefault(javassist.CtClass):long");
    }

    private static String javaName(CtClass clazz) {
        return Descriptor.toJavaName(Descriptor.toJvmName(clazz));
    }

    private static String javaName(String name) {
        return Descriptor.toJavaName(Descriptor.toJvmName(name));
    }
}
