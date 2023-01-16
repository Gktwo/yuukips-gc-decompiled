package javassist.util;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import com.sun.tools.attach.VirtualMachine;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.lang.instrument.ClassDefinition;
import java.lang.instrument.Instrumentation;
import java.lang.instrument.UnmodifiableClassException;
import java.lang.management.ManagementFactory;
import java.util.jar.Attributes;
import java.util.jar.JarEntry;
import java.util.jar.JarOutputStream;
import java.util.jar.Manifest;
import javassist.CannotCompileException;
import javassist.ClassPool;
import javassist.CtClass;
import javassist.NotFoundException;

/* loaded from: grasscutter.jar:javassist/util/HotSwapAgent.class */
public class HotSwapAgent {
    private static Instrumentation instrumentation = null;

    public Instrumentation instrumentation() {
        return instrumentation;
    }

    public static void premain(String agentArgs, Instrumentation inst) throws Throwable {
        agentmain(agentArgs, inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) throws Throwable {
        if (!inst.isRedefineClassesSupported()) {
            throw new RuntimeException("this JVM does not support redefinition of classes");
        }
        instrumentation = inst;
    }

    public static void redefine(Class<?> oldClass, CtClass newClass) throws NotFoundException, IOException, CannotCompileException {
        redefine(new Class[]{oldClass}, new CtClass[]{newClass});
    }

    public static void redefine(Class<?>[] oldClasses, CtClass[] newClasses) throws NotFoundException, IOException, CannotCompileException {
        startAgent();
        ClassDefinition[] defs = new ClassDefinition[oldClasses.length];
        for (int i = 0; i < oldClasses.length; i++) {
            defs[i] = new ClassDefinition(oldClasses[i], newClasses[i].toBytecode());
        }
        try {
            instrumentation.redefineClasses(defs);
        } catch (ClassNotFoundException e) {
            throw new NotFoundException(e.getMessage(), e);
        } catch (UnmodifiableClassException e2) {
            throw new CannotCompileException(e2.getMessage(), (Throwable) e2);
        }
    }

    private static void startAgent() throws NotFoundException {
        if (instrumentation == null) {
            try {
                File agentJar = createJarFile();
                String nameOfRunningVM = ManagementFactory.getRuntimeMXBean().getName();
                VirtualMachine vm = VirtualMachine.attach(nameOfRunningVM.substring(0, nameOfRunningVM.indexOf(64)));
                vm.loadAgent(agentJar.getAbsolutePath(), (String) null);
                vm.detach();
                for (int sec = 0; sec < 10; sec++) {
                    if (instrumentation == null) {
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            Thread.currentThread().interrupt();
                        }
                    } else {
                        return;
                    }
                }
                throw new NotFoundException("hotswap agent (timeout)");
            } catch (Exception e2) {
                throw new NotFoundException("hotswap agent", e2);
            }
        }
    }

    public static File createAgentJarFile(String fileName) throws IOException, CannotCompileException, NotFoundException {
        return createJarFile(new File(fileName));
    }

    private static File createJarFile() throws IOException, CannotCompileException, NotFoundException {
        File jar = File.createTempFile("agent", ".jar");
        jar.deleteOnExit();
        return createJarFile(jar);
    }

    private static File createJarFile(File jar) throws IOException, CannotCompileException, NotFoundException {
        Manifest manifest = new Manifest();
        Attributes attrs = manifest.getMainAttributes();
        attrs.put(Attributes.Name.MANIFEST_VERSION, "1.0");
        attrs.put(new Attributes.Name("Premain-Class"), HotSwapAgent.class.getName());
        attrs.put(new Attributes.Name("Agent-Class"), HotSwapAgent.class.getName());
        attrs.put(new Attributes.Name("Can-Retransform-Classes"), C3P0Substitutions.DEBUG);
        attrs.put(new Attributes.Name("Can-Redefine-Classes"), C3P0Substitutions.DEBUG);
        JarOutputStream jos = null;
        try {
            jos = new JarOutputStream(new FileOutputStream(jar), manifest);
            String cname = HotSwapAgent.class.getName();
            jos.putNextEntry(new JarEntry(cname.replace('.', '/') + ".class"));
            jos.write(ClassPool.getDefault().get(cname).toBytecode());
            jos.closeEntry();
            if (jos != null) {
                jos.close();
            }
            return jar;
        } catch (Throwable th) {
            if (jos != null) {
                jos.close();
            }
            throw th;
        }
    }
}
