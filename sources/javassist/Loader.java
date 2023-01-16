package javassist;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.security.ProtectionDomain;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;
import javassist.bytecode.ClassFile;
import org.jline.reader.LineReader;

/* loaded from: grasscutter.jar:javassist/Loader.class */
public class Loader extends ClassLoader {
    private HashMap<String, ClassLoader> notDefinedHere;
    private Vector<String> notDefinedPackages;
    private ClassPool source;
    private Translator translator;
    private ProtectionDomain domain;
    public boolean doDelegation;

    /* loaded from: grasscutter.jar:javassist/Loader$Simple.class */
    public static class Simple extends ClassLoader {
        public Simple() {
        }

        public Simple(ClassLoader parent) {
            super(parent);
        }

        public Class<?> invokeDefineClass(CtClass cc) throws IOException, CannotCompileException {
            byte[] code = cc.toBytecode();
            return defineClass(cc.getName(), code, 0, code.length);
        }
    }

    public Loader() {
        this(null);
    }

    public Loader(ClassPool cp) {
        this.doDelegation = true;
        init(cp);
    }

    public Loader(ClassLoader parent, ClassPool cp) {
        super(parent);
        this.doDelegation = true;
        init(cp);
    }

    private void init(ClassPool cp) {
        this.notDefinedHere = new HashMap<>();
        this.notDefinedPackages = new Vector<>();
        this.source = cp;
        this.translator = null;
        this.domain = null;
        delegateLoadingOf("javassist.Loader");
    }

    public void delegateLoadingOf(String classname) {
        if (classname.endsWith(Mapper.IGNORED_FIELDNAME)) {
            this.notDefinedPackages.addElement(classname);
        } else {
            this.notDefinedHere.put(classname, this);
        }
    }

    public void setDomain(ProtectionDomain d) {
        this.domain = d;
    }

    public void setClassPool(ClassPool cp) {
        this.source = cp;
    }

    public void addTranslator(ClassPool cp, Translator t) throws NotFoundException, CannotCompileException {
        this.source = cp;
        this.translator = t;
        t.start(cp);
    }

    public static void main(String[] args) throws Throwable {
        new Loader().run(args);
    }

    public void run(String[] args) throws Throwable {
        if (args.length >= 1) {
            run(args[0], (String[]) Arrays.copyOfRange(args, 1, args.length));
        }
    }

    public void run(String classname, String[] args) throws Throwable {
        try {
            loadClass(classname).getDeclaredMethod(LineReader.MAIN, String[].class).invoke(null, args);
        } catch (InvocationTargetException e) {
            throw e.getTargetException();
        }
    }

    @Override // java.lang.ClassLoader
    protected Class<?> loadClass(String name, boolean resolve) throws ClassFormatError, ClassNotFoundException {
        Class<?> c;
        String name2 = name.intern();
        synchronized (name2) {
            c = findLoadedClass(name2);
            if (c == null) {
                c = loadClassByDelegation(name2);
            }
            if (c == null) {
                c = findClass(name2);
            }
            if (c == null) {
                c = delegateToParent(name2);
            }
            if (resolve) {
                resolveClass(c);
            }
        }
        return c;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:8:0x002b
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.lang.ClassLoader
    protected java.lang.Class<?> findClass(java.lang.String r11) throws java.lang.ClassNotFoundException {
        /*
        // Method dump skipped, instructions count: 212
        */
        throw new UnsupportedOperationException("Method not decompiled: javassist.Loader.findClass(java.lang.String):java.lang.Class");
    }

    private boolean isDefinedPackage(String name) {
        return ClassFile.MAJOR_VERSION >= 53 ? getDefinedPackage(name) == null : getPackage(name) == null;
    }

    protected Class<?> loadClassByDelegation(String name) throws ClassNotFoundException {
        Class<?> c = null;
        if (this.doDelegation && (name.startsWith("java.") || name.startsWith("javax.") || name.startsWith("sun.") || name.startsWith("com.sun.") || name.startsWith("org.w3c.") || name.startsWith("org.xml.") || notDelegated(name))) {
            c = delegateToParent(name);
        }
        return c;
    }

    private boolean notDelegated(String name) {
        if (this.notDefinedHere.containsKey(name)) {
            return true;
        }
        Iterator<String> it = this.notDefinedPackages.iterator();
        while (it.hasNext()) {
            if (name.startsWith(it.next())) {
                return true;
            }
        }
        return false;
    }

    protected Class<?> delegateToParent(String classname) throws ClassNotFoundException {
        ClassLoader cl = getParent();
        if (cl != null) {
            return cl.loadClass(classname);
        }
        return findSystemClass(classname);
    }
}
