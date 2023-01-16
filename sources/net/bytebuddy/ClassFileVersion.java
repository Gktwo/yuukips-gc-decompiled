package net.bytebuddy;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import edu.umd.p012cs.findbugs.annotations.SuppressFBWarnings;
import java.io.IOException;
import java.security.AccessController;
import java.security.PrivilegedAction;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.type.TypeDescription;
import net.bytebuddy.dynamic.ClassFileLocator;
import net.bytebuddy.jar.asm.Opcodes;
import net.bytebuddy.utility.OpenedClassReader;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/ClassFileVersion.class */
public class ClassFileVersion implements Comparable<ClassFileVersion> {
    protected static final int BASE_VERSION = 44;
    public static final ClassFileVersion JAVA_V1 = new ClassFileVersion(196653);
    public static final ClassFileVersion JAVA_V2 = new ClassFileVersion(46);
    public static final ClassFileVersion JAVA_V3 = new ClassFileVersion(47);
    public static final ClassFileVersion JAVA_V4 = new ClassFileVersion(48);
    public static final ClassFileVersion JAVA_V5 = new ClassFileVersion(49);
    public static final ClassFileVersion JAVA_V6 = new ClassFileVersion(50);
    public static final ClassFileVersion JAVA_V7 = new ClassFileVersion(51);
    public static final ClassFileVersion JAVA_V8 = new ClassFileVersion(52);
    public static final ClassFileVersion JAVA_V9 = new ClassFileVersion(53);
    public static final ClassFileVersion JAVA_V10 = new ClassFileVersion(54);
    public static final ClassFileVersion JAVA_V11 = new ClassFileVersion(55);
    public static final ClassFileVersion JAVA_V12 = new ClassFileVersion(56);
    public static final ClassFileVersion JAVA_V13 = new ClassFileVersion(57);
    public static final ClassFileVersion JAVA_V14 = new ClassFileVersion(58);
    public static final ClassFileVersion JAVA_V15 = new ClassFileVersion(59);
    public static final ClassFileVersion JAVA_V16 = new ClassFileVersion(60);
    public static final ClassFileVersion JAVA_V17 = new ClassFileVersion(61);
    private static final VersionLocator VERSION_LOCATOR = (VersionLocator) AccessController.doPrivileged(VersionLocator.Resolver.INSTANCE);
    private final int versionNumber;

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.versionNumber == ((ClassFileVersion) obj).versionNumber;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return (getClass().hashCode() * 31) + this.versionNumber;
    }

    protected ClassFileVersion(int versionNumber) {
        this.versionNumber = versionNumber;
    }

    public static ClassFileVersion ofMinorMajor(int versionNumber) {
        ClassFileVersion classFileVersion = new ClassFileVersion(versionNumber);
        if (classFileVersion.getMajorVersion() > 44) {
            return classFileVersion;
        }
        throw new IllegalArgumentException("Class version " + versionNumber + " is not valid");
    }

    public static ClassFileVersion ofJavaVersionString(String javaVersionString) {
        if (javaVersionString.equals("1.1")) {
            return JAVA_V1;
        }
        if (javaVersionString.equals("1.2")) {
            return JAVA_V2;
        }
        if (javaVersionString.equals("1.3")) {
            return JAVA_V3;
        }
        if (javaVersionString.equals("1.4")) {
            return JAVA_V4;
        }
        if (javaVersionString.equals("1.5") || javaVersionString.equals("5")) {
            return JAVA_V5;
        }
        if (javaVersionString.equals("1.6") || javaVersionString.equals("6")) {
            return JAVA_V6;
        }
        if (javaVersionString.equals("1.7") || javaVersionString.equals("7")) {
            return JAVA_V7;
        }
        if (javaVersionString.equals("1.8") || javaVersionString.equals("8")) {
            return JAVA_V8;
        }
        if (javaVersionString.equals("1.9") || javaVersionString.equals("9")) {
            return JAVA_V9;
        }
        if (javaVersionString.equals("1.10") || javaVersionString.equals(C3P0Substitutions.TRACE)) {
            return JAVA_V10;
        }
        if (javaVersionString.equals("1.11") || javaVersionString.equals("11")) {
            return JAVA_V11;
        }
        if (javaVersionString.equals("1.12") || javaVersionString.equals("12")) {
            return JAVA_V12;
        }
        if (javaVersionString.equals("1.13") || javaVersionString.equals("13")) {
            return JAVA_V13;
        }
        if (javaVersionString.equals("1.14") || javaVersionString.equals("14")) {
            return JAVA_V14;
        }
        if (javaVersionString.equals("1.15") || javaVersionString.equals("15")) {
            return JAVA_V15;
        }
        if (javaVersionString.equals("1.16") || javaVersionString.equals("16")) {
            return JAVA_V16;
        }
        if (javaVersionString.equals("1.17") || javaVersionString.equals("17")) {
            return JAVA_V17;
        }
        if (OpenedClassReader.EXPERIMENTAL) {
            try {
                int version = Integer.parseInt(javaVersionString.startsWith("1.") ? javaVersionString.substring(2) : javaVersionString);
                if (version > 0) {
                    return new ClassFileVersion(44 + version);
                }
            } catch (NumberFormatException e) {
            }
        }
        throw new IllegalArgumentException("Unknown Java version string: " + javaVersionString);
    }

    public static ClassFileVersion ofJavaVersion(int javaVersion) {
        switch (javaVersion) {
            case 1:
                return JAVA_V1;
            case 2:
                return JAVA_V2;
            case 3:
                return JAVA_V3;
            case 4:
                return JAVA_V4;
            case 5:
                return JAVA_V5;
            case 6:
                return JAVA_V6;
            case 7:
                return JAVA_V7;
            case 8:
                return JAVA_V8;
            case 9:
                return JAVA_V9;
            case 10:
                return JAVA_V10;
            case 11:
                return JAVA_V11;
            case 12:
                return JAVA_V12;
            case 13:
                return JAVA_V13;
            case 14:
                return JAVA_V14;
            case 15:
                return JAVA_V15;
            case 16:
                return JAVA_V16;
            case 17:
                return JAVA_V17;
            default:
                if (OpenedClassReader.EXPERIMENTAL && javaVersion > 0) {
                    return new ClassFileVersion(44 + javaVersion);
                }
                throw new IllegalArgumentException("Unknown Java version: " + javaVersion);
        }
    }

    public static ClassFileVersion ofThisVm() {
        return VERSION_LOCATOR.resolve();
    }

    @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback")
    public static ClassFileVersion ofThisVm(ClassFileVersion fallback) {
        try {
            return ofThisVm();
        } catch (Exception e) {
            return fallback;
        }
    }

    /* renamed from: of */
    public static ClassFileVersion m352of(Class<?> type) throws IOException {
        return m351of(type, ClassFileLocator.ForClassLoader.m232of(type.getClassLoader()));
    }

    /* renamed from: of */
    public static ClassFileVersion m351of(Class<?> type, ClassFileLocator classFileLocator) throws IOException {
        return m350of(TypeDescription.ForLoadedType.m247of(type), classFileLocator);
    }

    /* renamed from: of */
    public static ClassFileVersion m350of(TypeDescription typeDescription, ClassFileLocator classFileLocator) throws IOException {
        return ofClassFile(classFileLocator.locate(typeDescription.getName()).resolve());
    }

    public static ClassFileVersion ofClassFile(byte[] binaryRepresentation) {
        if (binaryRepresentation.length >= 7) {
            return ofMinorMajor((binaryRepresentation[6] << 8) | (binaryRepresentation[7] & 255));
        }
        throw new IllegalArgumentException("Supplied byte array is too short to be a class file with " + binaryRepresentation.length + " byte");
    }

    public int getMinorMajorVersion() {
        return this.versionNumber;
    }

    public short getMajorVersion() {
        return (short) (this.versionNumber & 255);
    }

    public short getMinorVersion() {
        return (short) (this.versionNumber >> 16);
    }

    public int getJavaVersion() {
        return getMajorVersion() - 44;
    }

    public boolean isAtLeast(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > -1;
    }

    public boolean isGreaterThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) > 0;
    }

    public boolean isAtMost(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 1;
    }

    public boolean isLessThan(ClassFileVersion classFileVersion) {
        return compareTo(classFileVersion) < 0;
    }

    public ClassFileVersion asPreviewVersion() {
        return new ClassFileVersion(this.versionNumber | Opcodes.V_PREVIEW);
    }

    public boolean isPreviewVersion() {
        return (this.versionNumber & Opcodes.V_PREVIEW) == -65536;
    }

    public int compareTo(ClassFileVersion other) {
        int i;
        if (getMajorVersion() == other.getMajorVersion()) {
            i = getMinorVersion() - other.getMinorVersion();
        } else {
            i = getMajorVersion() - other.getMajorVersion();
        }
        return Integer.signum(i);
    }

    @Override // java.lang.Object
    public String toString() {
        return "Java " + getJavaVersion() + " (" + getMinorMajorVersion() + ")";
    }

    /* access modifiers changed from: protected */
    /* loaded from: grasscutter.jar:net/bytebuddy/ClassFileVersion$VersionLocator.class */
    public interface VersionLocator {
        public static final String JAVA_VERSION = "java.version";

        ClassFileVersion resolve();

        /* loaded from: grasscutter.jar:net/bytebuddy/ClassFileVersion$VersionLocator$Resolver.class */
        public enum Resolver implements PrivilegedAction<VersionLocator> {
            INSTANCE;

            @Override // java.security.PrivilegedAction
            @SuppressFBWarnings(value = {"REC_CATCH_EXCEPTION"}, justification = "Exception should not be rethrown but trigger a fallback")
            public VersionLocator run() {
                try {
                    return new Resolved(ClassFileVersion.ofJavaVersion(((Integer) Class.forName(Runtime.class.getName() + "$Version").getMethod("major", new Class[0]).invoke(Runtime.class.getMethod("version", new Class[0]).invoke(null, new Object[0]), new Object[0])).intValue()));
                } catch (Throwable th) {
                    try {
                        String versionString = System.getProperty(VersionLocator.JAVA_VERSION);
                        if (versionString == null) {
                            throw new IllegalStateException("Java version property is not set");
                        } else if (versionString.equals("0")) {
                            return new Resolved(ClassFileVersion.JAVA_V6);
                        } else {
                            int[] versionIndex = new int[3];
                            versionIndex[0] = -1;
                            versionIndex[1] = 0;
                            versionIndex[2] = 0;
                            for (int index = 1; index < 3; index++) {
                                versionIndex[index] = versionString.indexOf(46, versionIndex[index - 1] + 1);
                                if (versionIndex[index] == -1) {
                                    throw new IllegalStateException("This JVM's version string does not seem to be valid: " + versionString);
                                }
                            }
                            return new Resolved(ClassFileVersion.ofJavaVersion(Integer.parseInt(versionString.substring(versionIndex[1] + 1, versionIndex[2]))));
                        }
                    } catch (Throwable throwable) {
                        return new Unresolved(throwable.getMessage());
                    }
                }
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/ClassFileVersion$VersionLocator$Resolved.class */
        public static class Resolved implements VersionLocator {
            private final ClassFileVersion classFileVersion;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.classFileVersion.equals(((Resolved) obj).classFileVersion);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.classFileVersion.hashCode();
            }

            protected Resolved(ClassFileVersion classFileVersion) {
                this.classFileVersion = classFileVersion;
            }

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                return this.classFileVersion;
            }
        }

        @HashCodeAndEqualsPlugin.Enhance
        /* loaded from: grasscutter.jar:net/bytebuddy/ClassFileVersion$VersionLocator$Unresolved.class */
        public static class Unresolved implements VersionLocator {
            private final String message;

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return obj != null && getClass() == obj.getClass() && this.message.equals(((Unresolved) obj).message);
            }

            public int hashCode() {
                return (getClass().hashCode() * 31) + this.message.hashCode();
            }

            protected Unresolved(String message) {
                this.message = message;
            }

            @Override // net.bytebuddy.ClassFileVersion.VersionLocator
            public ClassFileVersion resolve() {
                throw new IllegalStateException("Failed to resolve the class file version of the current VM: " + this.message);
            }
        }
    }
}
