package javassist.util.proxy;

import dev.morphia.mapping.Mapper;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.invoke.MethodHandles;
import java.security.ProtectionDomain;
import javassist.CannotCompileException;
import javassist.bytecode.ClassFile;

/* loaded from: grasscutter.jar:javassist/util/proxy/FactoryHelper.class */
public class FactoryHelper {
    public static final Class<?>[] primitiveTypes = {Boolean.TYPE, Byte.TYPE, Character.TYPE, Short.TYPE, Integer.TYPE, Long.TYPE, Float.TYPE, Double.TYPE, Void.TYPE};
    public static final String[] wrapperTypes = {"java.lang.Boolean", "java.lang.Byte", "java.lang.Character", "java.lang.Short", "java.lang.Integer", "java.lang.Long", "java.lang.Float", "java.lang.Double", "java.lang.Void"};
    public static final String[] wrapperDesc = {"(Z)V", "(B)V", "(C)V", "(S)V", "(I)V", "(J)V", "(F)V", "(D)V"};
    public static final String[] unwarpMethods = {"booleanValue", "byteValue", "charValue", "shortValue", "intValue", "longValue", "floatValue", "doubleValue"};
    public static final String[] unwrapDesc = {"()Z", "()B", "()C", "()S", "()I", "()J", "()F", "()D"};
    public static final int[] dataSize = {1, 1, 1, 1, 1, 2, 1, 2};

    public static final int typeIndex(Class<?> type) {
        for (int i = 0; i < primitiveTypes.length; i++) {
            if (primitiveTypes[i] == type) {
                return i;
            }
        }
        throw new RuntimeException("bad type:" + type.getName());
    }

    public static Class<?> toClass(ClassFile cf, ClassLoader loader) throws CannotCompileException {
        return toClass(cf, null, loader, null);
    }

    public static Class<?> toClass(ClassFile cf, ClassLoader loader, ProtectionDomain domain) throws CannotCompileException {
        return toClass(cf, null, loader, domain);
    }

    public static Class<?> toClass(ClassFile cf, Class<?> neighbor, ClassLoader loader, ProtectionDomain domain) throws CannotCompileException {
        try {
            byte[] b = toBytecode(cf);
            if (ProxyFactory.onlyPublicMethods) {
                return DefineClassHelper.toPublicClass(cf.getName(), b);
            }
            return DefineClassHelper.toClass(cf.getName(), neighbor, loader, domain, b);
        } catch (IOException e) {
            throw new CannotCompileException(e);
        }
    }

    public static Class<?> toClass(ClassFile cf, MethodHandles.Lookup lookup) throws CannotCompileException {
        try {
            return DefineClassHelper.toClass(lookup, toBytecode(cf));
        } catch (IOException e) {
            throw new CannotCompileException(e);
        }
    }

    private static byte[] toBytecode(ClassFile cf) throws IOException {
        ByteArrayOutputStream barray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(barray);
        try {
            cf.write(out);
            return barray.toByteArray();
        } finally {
            out.close();
        }
    }

    public static void writeFile(ClassFile cf, String directoryName) throws CannotCompileException {
        try {
            writeFile0(cf, directoryName);
        } catch (IOException e) {
            throw new CannotCompileException(e);
        }
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:18:0x0059 */
    /* JADX DEBUG: Multi-variable search result rejected for r8v0, resolved type: javassist.bytecode.ClassFile */
    /* JADX DEBUG: Multi-variable search result rejected for r13v1, resolved type: java.io.DataOutputStream */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [java.io.DataOutputStream] */
    /* JADX WARN: Type inference failed for: r13v3, types: [java.lang.String] */
    private static void writeFile0(ClassFile cf, String directoryName) throws CannotCompileException, IOException {
        DataOutputStream out;
        String filename = directoryName + File.separatorChar + cf.getName().replace('.', File.separatorChar) + ".class";
        int pos = filename.lastIndexOf(File.separatorChar);
        if (pos > 0) {
            out = filename.substring(0, pos);
            if (!out.equals(Mapper.IGNORED_FIELDNAME)) {
                new File((String) out).mkdirs();
            }
        }
        try {
            out = new DataOutputStream(new BufferedOutputStream(new FileOutputStream(filename)));
            try {
                cf.write(out);
                out.close();
            } catch (IOException e) {
                throw e;
            }
        } catch (Throwable th) {
            out.close();
            throw th;
        }
    }
}
