package p013io.github.classgraph;

import java.io.File;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import nonapi.p019io.github.classgraph.utils.JarUtils;
import nonapi.p019io.github.classgraph.utils.Join;
import nonapi.p019io.github.classgraph.utils.ReflectionUtils;

/* renamed from: io.github.classgraph.ModulePathInfo */
/* loaded from: grasscutter.jar:io/github/classgraph/ModulePathInfo.class */
public class ModulePathInfo {
    public final Set<String> modulePath = new LinkedHashSet();
    public final Set<String> addModules = new LinkedHashSet();
    public final Set<String> patchModules = new LinkedHashSet();
    public final Set<String> addExports = new LinkedHashSet();
    public final Set<String> addOpens = new LinkedHashSet();
    public final Set<String> addReads = new LinkedHashSet();
    private final List<Set<String>> fields = Arrays.asList(this.modulePath, this.addModules, this.patchModules, this.addExports, this.addOpens, this.addReads);
    private static final List<String> argSwitches = Arrays.asList("--module-path=", "--add-modules=", "--patch-module=", "--add-exports=", "--add-opens=", "--add-reads=");
    private static final List<Character> argPartSeparatorChars = Arrays.asList(Character.valueOf(File.pathSeparatorChar), ',', (char) 0, (char) 0, (char) 0, (char) 0);

    public ModulePathInfo() {
        Class<?> managementFactory = ReflectionUtils.classForNameOrNull("java.lang.management.ManagementFactory");
        Object runtimeMXBean = managementFactory == null ? null : ReflectionUtils.invokeStaticMethod(managementFactory, "getRuntimeMXBean", false);
        List<String> commandlineArguments = runtimeMXBean == null ? null : (List) ReflectionUtils.invokeMethod(runtimeMXBean, "getInputArguments", false);
        if (commandlineArguments != null) {
            for (String arg : commandlineArguments) {
                for (int i = 0; i < this.fields.size(); i++) {
                    String argSwitch = argSwitches.get(i);
                    if (arg.startsWith(argSwitch)) {
                        String argParam = arg.substring(argSwitch.length());
                        Set<String> argField = this.fields.get(i);
                        char sepChar = argPartSeparatorChars.get(i).charValue();
                        if (sepChar == 0) {
                            argField.add(argParam);
                        } else {
                            for (String argPart : JarUtils.smartPathSplit(argParam, sepChar, null)) {
                                argField.add(argPart);
                            }
                        }
                    }
                }
            }
        }
    }

    public String toString() {
        StringBuilder buf = new StringBuilder(1024);
        if (!this.modulePath.isEmpty()) {
            buf.append("--module-path=");
            buf.append(Join.join(File.pathSeparator, this.modulePath));
        }
        if (!this.addModules.isEmpty()) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append("--add-modules=");
            buf.append(Join.join(",", this.addModules));
        }
        for (String patchModulesEntry : this.patchModules) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append("--patch-module=");
            buf.append(patchModulesEntry);
        }
        for (String addExportsEntry : this.addExports) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append("--add-exports=");
            buf.append(addExportsEntry);
        }
        for (String addOpensEntry : this.addOpens) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append("--add-opens=");
            buf.append(addOpensEntry);
        }
        for (String addReadsEntry : this.addReads) {
            if (buf.length() > 0) {
                buf.append(' ');
            }
            buf.append("--add-reads=");
            buf.append(addReadsEntry);
        }
        return buf.toString();
    }
}
