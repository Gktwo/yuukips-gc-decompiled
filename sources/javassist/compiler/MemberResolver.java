package javassist.compiler;

import dev.morphia.mapping.Mapper;
import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.CtField;
import javassist.Modifier;
import javassist.NotFoundException;
import javassist.bytecode.ClassFile;
import javassist.bytecode.Descriptor;
import javassist.bytecode.MethodInfo;
import javassist.compiler.ast.ASTList;
import javassist.compiler.ast.ASTree;
import javassist.compiler.ast.Declarator;
import javassist.compiler.ast.Keyword;
import javassist.compiler.ast.Symbol;
import okhttp3.HttpUrl;

/* loaded from: grasscutter.jar:javassist/compiler/MemberResolver.class */
public class MemberResolver implements TokenId {
    private ClassPool classPool;
    private static final int YES = 0;

    /* renamed from: NO */
    private static final int f3039NO = -1;
    private static final String INVALID = "<invalid>";
    private static Map<ClassPool, Reference<Map<String, String>>> invalidNamesMap = new WeakHashMap();
    private Map<String, String> invalidNames = null;

    public MemberResolver(ClassPool cp) {
        this.classPool = cp;
    }

    public ClassPool getClassPool() {
        return this.classPool;
    }

    private static void fatal() throws CompileError {
        throw new CompileError("fatal");
    }

    /* loaded from: grasscutter.jar:javassist/compiler/MemberResolver$Method.class */
    public static class Method {
        public CtClass declaring;
        public MethodInfo info;
        public int notmatch;

        public Method(CtClass c, MethodInfo i, int n) {
            this.declaring = c;
            this.info = i;
            this.notmatch = n;
        }

        public boolean isStatic() {
            return (this.info.getAccessFlags() & 8) != 0;
        }
    }

    public Method lookupMethod(CtClass clazz, CtClass currentClass, MethodInfo current, String methodName, int[] argTypes, int[] argDims, String[] argClassNames) throws CompileError {
        int res;
        Method maybe = null;
        if (current != null && clazz == currentClass && current.getName().equals(methodName) && (res = compareSignature(current.getDescriptor(), argTypes, argDims, argClassNames)) != -1) {
            Method r = new Method(clazz, current, res);
            if (res == 0) {
                return r;
            }
            maybe = r;
        }
        Method m = lookupMethod(clazz, methodName, argTypes, argDims, argClassNames, maybe != null);
        if (m != null) {
            return m;
        }
        return maybe;
    }

    private Method lookupMethod(CtClass clazz, String methodName, int[] argTypes, int[] argDims, String[] argClassNames, boolean onlyExact) throws CompileError {
        CtClass pclazz;
        int res;
        Method maybe = null;
        ClassFile cf = clazz.getClassFile2();
        if (cf != null) {
            for (MethodInfo minfo : cf.getMethods()) {
                if (minfo.getName().equals(methodName) && (minfo.getAccessFlags() & 64) == 0 && (res = compareSignature(minfo.getDescriptor(), argTypes, argDims, argClassNames)) != -1) {
                    Method r = new Method(clazz, minfo, res);
                    if (res == 0) {
                        return r;
                    }
                    if (maybe == null || maybe.notmatch > res) {
                        maybe = r;
                    }
                }
            }
        }
        if (onlyExact) {
            maybe = null;
        } else if (maybe != null) {
            return maybe;
        }
        boolean isIntf = Modifier.isInterface(clazz.getModifiers());
        if (!isIntf) {
            try {
                CtClass pclazz2 = clazz.getSuperclass();
                if (pclazz2 != null) {
                    Method r2 = lookupMethod(pclazz2, methodName, argTypes, argDims, argClassNames, onlyExact);
                    if (r2 != null) {
                        return r2;
                    }
                }
            } catch (NotFoundException e) {
            }
        }
        try {
            for (CtClass intf : clazz.getInterfaces()) {
                Method r3 = lookupMethod(intf, methodName, argTypes, argDims, argClassNames, onlyExact);
                if (r3 != null) {
                    return r3;
                }
            }
            if (isIntf && (pclazz = clazz.getSuperclass()) != null) {
                Method r4 = lookupMethod(pclazz, methodName, argTypes, argDims, argClassNames, onlyExact);
                if (r4 != null) {
                    return r4;
                }
            }
        } catch (NotFoundException e2) {
        }
        return maybe;
    }

    private int compareSignature(String desc, int[] argTypes, int[] argDims, String[] argClassNames) throws CompileError {
        int result = 0;
        int i = 1;
        int nArgs = argTypes.length;
        if (nArgs != Descriptor.numOfParameters(desc)) {
            return -1;
        }
        int len = desc.length();
        int n = 0;
        while (i < len) {
            i++;
            char c = desc.charAt(i);
            if (c == ')') {
                if (n == nArgs) {
                    return result;
                }
                return -1;
            } else if (n >= nArgs) {
                return -1;
            } else {
                int dim = 0;
                while (c == '[') {
                    dim++;
                    i++;
                    c = desc.charAt(i);
                }
                if (argTypes[n] == 412) {
                    if (dim == 0 && c != 'L') {
                        return -1;
                    }
                    if (c == 'L') {
                        i = desc.indexOf(59, i) + 1;
                    }
                } else if (argDims[n] != dim) {
                    if (dim != 0 || c != 'L' || !desc.startsWith("java/lang/Object;", i)) {
                        return -1;
                    }
                    i = desc.indexOf(59, i) + 1;
                    result++;
                    if (i <= 0) {
                        return -1;
                    }
                } else if (c == 'L') {
                    int j = desc.indexOf(59, i);
                    if (j < 0 || argTypes[n] != 307) {
                        return -1;
                    }
                    String cname = desc.substring(i, j);
                    if (!cname.equals(argClassNames[n])) {
                        try {
                            if (!lookupClassByJvmName(argClassNames[n]).subtypeOf(lookupClassByJvmName(cname))) {
                                return -1;
                            }
                            result++;
                        } catch (NotFoundException e) {
                            result++;
                        }
                    }
                    i = j + 1;
                } else {
                    int t = descToType(c);
                    int at = argTypes[n];
                    if (t == at) {
                        continue;
                    } else if (t != 324) {
                        return -1;
                    } else {
                        if (at != 334 && at != 303 && at != 306) {
                            return -1;
                        }
                        result++;
                    }
                }
                n++;
            }
        }
        return -1;
    }

    public CtField lookupFieldByJvmName2(String jvmClassName, Symbol fieldSym, ASTree expr) throws NoFieldException {
        String field = fieldSym.get();
        try {
            CtClass cc = lookupClass(jvmToJavaName(jvmClassName), true);
            try {
                return cc.getField(field);
            } catch (NotFoundException e) {
                throw new NoFieldException(javaToJvmName(cc.getName()) + "$" + field, expr);
            }
        } catch (CompileError e2) {
            throw new NoFieldException(jvmClassName + "/" + field, expr);
        }
    }

    public CtField lookupFieldByJvmName(String jvmClassName, Symbol fieldName) throws CompileError {
        return lookupField(jvmToJavaName(jvmClassName), fieldName);
    }

    public CtField lookupField(String className, Symbol fieldName) throws CompileError {
        try {
            return lookupClass(className, false).getField(fieldName.get());
        } catch (NotFoundException e) {
            throw new CompileError("no such field: " + fieldName.get());
        }
    }

    public CtClass lookupClassByName(ASTList name) throws CompileError {
        return lookupClass(Declarator.astToClassName(name, '.'), false);
    }

    public CtClass lookupClassByJvmName(String jvmName) throws CompileError {
        return lookupClass(jvmToJavaName(jvmName), false);
    }

    public CtClass lookupClass(Declarator decl) throws CompileError {
        return lookupClass(decl.getType(), decl.getArrayDim(), decl.getClassName());
    }

    public CtClass lookupClass(int type, int dim, String classname) throws CompileError {
        String cname;
        if (type == 307) {
            CtClass clazz = lookupClassByJvmName(classname);
            if (dim <= 0) {
                return clazz;
            }
            cname = clazz.getName();
        } else {
            cname = getTypeName(type);
        }
        while (true) {
            dim--;
            if (dim <= 0) {
                return lookupClass(cname, false);
            }
            cname = cname + HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
        }
    }

    /* access modifiers changed from: package-private */
    public static String getTypeName(int type) throws CompileError {
        String cname = "";
        switch (type) {
            case 301:
                cname = "boolean";
                break;
            case 303:
                cname = "byte";
                break;
            case TokenId.CHAR /* 306 */:
                cname = "char";
                break;
            case TokenId.DOUBLE /* 312 */:
                cname = "double";
                break;
            case 317:
                cname = "float";
                break;
            case 324:
                cname = "int";
                break;
            case TokenId.LONG /* 326 */:
                cname = "long";
                break;
            case TokenId.SHORT /* 334 */:
                cname = "short";
                break;
            case TokenId.VOID /* 344 */:
                cname = "void";
                break;
            default:
                fatal();
                break;
        }
        return cname;
    }

    public CtClass lookupClass(String name, boolean notCheckInner) throws CompileError {
        CtClass cc;
        Map<String, String> cache = getInvalidNames();
        String found = cache.get(name);
        if (found == INVALID) {
            throw new CompileError("no such class: " + name);
        }
        if (found != null) {
            try {
                return this.classPool.get(found);
            } catch (NotFoundException e) {
            }
        }
        try {
            cc = lookupClass0(name, notCheckInner);
        } catch (NotFoundException e2) {
            cc = searchImports(name);
        }
        cache.put(name, cc.getName());
        return cc;
    }

    public static int getInvalidMapSize() {
        return invalidNamesMap.size();
    }

    private Map<String, String> getInvalidNames() {
        Map<String, String> ht = this.invalidNames;
        if (ht == null) {
            synchronized (MemberResolver.class) {
                Reference<Map<String, String>> ref = invalidNamesMap.get(this.classPool);
                if (ref != null) {
                    ht = ref.get();
                }
                if (ht == null) {
                    ht = new Hashtable();
                    invalidNamesMap.put(this.classPool, new WeakReference(ht));
                }
            }
            this.invalidNames = ht;
        }
        return ht;
    }

    private CtClass searchImports(String orgName) throws CompileError {
        if (orgName.indexOf(46) < 0) {
            Iterator<String> it = this.classPool.getImportedPackages();
            while (it.hasNext()) {
                String pac = it.next();
                try {
                    return this.classPool.get(pac.replaceAll("\\.$", "") + Mapper.IGNORED_FIELDNAME + orgName);
                } catch (NotFoundException e) {
                    if (pac.endsWith(Mapper.IGNORED_FIELDNAME + orgName)) {
                        return this.classPool.get(pac);
                    }
                    continue;
                }
            }
        }
        getInvalidNames().put(orgName, INVALID);
        throw new CompileError("no such class: " + orgName);
    }

    private CtClass lookupClass0(String classname, boolean notCheckInner) throws NotFoundException {
        CtClass cc = null;
        do {
            try {
                cc = this.classPool.get(classname);
            } catch (NotFoundException e) {
                int i = classname.lastIndexOf(46);
                if (notCheckInner || i < 0) {
                    throw e;
                }
                StringBuffer sbuf = new StringBuffer(classname);
                sbuf.setCharAt(i, '$');
                classname = sbuf.toString();
            }
        } while (cc == null);
        return cc;
    }

    public String resolveClassName(ASTList name) throws CompileError {
        if (name == null) {
            return null;
        }
        return javaToJvmName(lookupClassByName(name).getName());
    }

    public String resolveJvmClassName(String jvmName) throws CompileError {
        if (jvmName == null) {
            return null;
        }
        return javaToJvmName(lookupClassByJvmName(jvmName).getName());
    }

    public static CtClass getSuperclass(CtClass c) throws CompileError {
        try {
            CtClass sc = c.getSuperclass();
            if (sc != null) {
                return sc;
            }
        } catch (NotFoundException e) {
        }
        throw new CompileError("cannot find the super class of " + c.getName());
    }

    public static CtClass getSuperInterface(CtClass c, String interfaceName) throws CompileError {
        try {
            CtClass[] intfs = c.getInterfaces();
            for (int i = 0; i < intfs.length; i++) {
                if (intfs[i].getName().equals(interfaceName)) {
                    return intfs[i];
                }
            }
        } catch (NotFoundException e) {
        }
        throw new CompileError("cannot find the super interface " + interfaceName + " of " + c.getName());
    }

    public static String javaToJvmName(String classname) {
        return classname.replace('.', '/');
    }

    public static String jvmToJavaName(String classname) {
        return classname.replace('/', '.');
    }

    public static int descToType(char c) throws CompileError {
        switch (c) {
            case 'B':
                return 303;
            case 'C':
                return TokenId.CHAR;
            case 'D':
                return TokenId.DOUBLE;
            case 'E':
            case 'G':
            case 'H':
            case 'K':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'T':
            case 'U':
            case 'W':
            case 'X':
            case 'Y':
            default:
                fatal();
                return TokenId.VOID;
            case 'F':
                return 317;
            case 'I':
                return 324;
            case 'J':
                return TokenId.LONG;
            case 'L':
            case '[':
                return 307;
            case 'S':
                return TokenId.SHORT;
            case 'V':
                return TokenId.VOID;
            case 'Z':
                return 301;
        }
    }

    public static int getModifiers(ASTList mods) {
        int m = 0;
        while (mods != null) {
            Keyword k = (Keyword) mods.head();
            mods = mods.tail();
            switch (k.get()) {
                case 300:
                    m |= 1024;
                    break;
                case 315:
                    m |= 16;
                    break;
                case 330:
                    m |= 2;
                    break;
                case TokenId.PROTECTED /* 331 */:
                    m |= 4;
                    break;
                case TokenId.PUBLIC /* 332 */:
                    m |= 1;
                    break;
                case 335:
                    m |= 8;
                    break;
                case TokenId.SYNCHRONIZED /* 338 */:
                    m |= 32;
                    break;
                case 342:
                    m |= 128;
                    break;
                case 345:
                    m |= 64;
                    break;
                case 347:
                    m |= 2048;
                    break;
            }
        }
        return m;
    }
}
