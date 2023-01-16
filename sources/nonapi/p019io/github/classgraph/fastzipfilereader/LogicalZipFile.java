package nonapi.p019io.github.classgraph.fastzipfilereader;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.util.AbstractMap;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import nonapi.p019io.github.classgraph.utils.LogNode;
import p013io.github.classgraph.ClassGraphException;

/* renamed from: nonapi.io.github.classgraph.fastzipfilereader.LogicalZipFile */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/LogicalZipFile.class */
public class LogicalZipFile extends ZipFileSlice {
    public List<FastZipEntry> entries;
    private boolean isMultiReleaseJar;
    Set<String> classpathRoots = Collections.newSetFromMap(new ConcurrentHashMap());
    public String classPathManifestEntryValue;
    public String bundleClassPathManifestEntryValue;
    public String addExportsManifestEntryValue;
    public String addOpensManifestEntryValue;
    public String automaticModuleNameManifestEntryValue;
    public boolean isJREJar;
    static final String META_INF_PATH_PREFIX = "META-INF/";
    private static final String MANIFEST_PATH = "META-INF/MANIFEST.MF";
    public static final String MULTI_RELEASE_PATH_PREFIX = "META-INF/versions/";
    private static final byte[] IMPLEMENTATION_TITLE_KEY = manifestKeyToBytes("Implementation-Title");
    private static final byte[] SPECIFICATION_TITLE_KEY = manifestKeyToBytes("Specification-Title");
    private static final byte[] CLASS_PATH_KEY = manifestKeyToBytes("Class-Path");
    private static final byte[] BUNDLE_CLASSPATH_KEY = manifestKeyToBytes("Bundle-ClassPath");
    private static final byte[] SPRING_BOOT_CLASSES_KEY = manifestKeyToBytes("Spring-Boot-Classes");
    private static final byte[] SPRING_BOOT_LIB_KEY = manifestKeyToBytes("Spring-Boot-Lib");
    private static final byte[] MULTI_RELEASE_KEY = manifestKeyToBytes("Multi-Release");
    private static final byte[] ADD_EXPORTS_KEY = manifestKeyToBytes("Add-Exports");
    private static final byte[] ADD_OPENS_KEY = manifestKeyToBytes("Add-Opens");
    private static final byte[] AUTOMATIC_MODULE_NAME_KEY = manifestKeyToBytes("Automatic-Module-Name");
    private static byte[] toLowerCase = new byte[256];

    static {
        for (int i = 32; i < 127; i++) {
            toLowerCase[i] = (byte) Character.toLowerCase((char) i);
        }
    }

    /* access modifiers changed from: package-private */
    public LogicalZipFile(ZipFileSlice zipFileSlice, NestedJarHandler nestedJarHandler, LogNode log) throws IOException, InterruptedException {
        super(zipFileSlice);
        readCentralDirectory(nestedJarHandler, log);
    }

    private static Map.Entry<String, Integer> getManifestValue(byte[] manifest, int startIdx) {
        String val;
        boolean isLineEnd;
        int curr = startIdx;
        int len = manifest.length;
        while (curr < len && manifest[curr] == 32) {
            curr++;
        }
        boolean isMultiLine = false;
        while (true) {
            if (curr >= len || 0 != 0) {
                break;
            }
            byte b = manifest[curr];
            if (b == 13 && curr < len - 1 && manifest[curr + 1] == 10) {
                if (curr < len - 2 && manifest[curr + 2] == 32) {
                    isMultiLine = true;
                }
            } else if (b == 13 || b == 10) {
                break;
            } else {
                curr++;
            }
        }
        if (curr < len - 1 && manifest[curr + 1] == 32) {
            isMultiLine = true;
        }
        if (!isMultiLine) {
            val = new String(manifest, curr, curr - curr, StandardCharsets.UTF_8);
        } else {
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            curr = curr;
            while (curr < len) {
                byte b2 = manifest[curr];
                if (b2 == 13 && curr < len - 1 && manifest[curr + 1] == 10) {
                    curr += 2;
                    isLineEnd = true;
                } else if (b2 == 13 || b2 == 10) {
                    curr++;
                    isLineEnd = true;
                } else {
                    buf.write(b2);
                    isLineEnd = false;
                }
                if (!isLineEnd || curr >= len || manifest[curr] == 32) {
                    curr++;
                }
            }
            try {
                val = buf.toString("UTF-8");
            } catch (UnsupportedEncodingException e) {
                throw ClassGraphException.newClassGraphException("UTF-8 encoding unsupported", e);
            }
        }
        return new AbstractMap.SimpleEntry(val.endsWith(" ") ? val.trim() : val, Integer.valueOf(curr));
    }

    private static byte[] manifestKeyToBytes(String key) {
        byte[] bytes = new byte[key.length()];
        for (int i = 0; i < key.length(); i++) {
            bytes[i] = (byte) Character.toLowerCase(key.charAt(i));
        }
        return bytes;
    }

    private static boolean keyMatchesAtPosition(byte[] manifest, byte[] key, int pos) {
        if (pos + key.length + 1 > manifest.length || manifest[pos + key.length] != 58) {
            return false;
        }
        for (int i = 0; i < key.length; i++) {
            if (toLowerCase[manifest[i + pos]] != key[i]) {
                return false;
            }
        }
        return true;
    }

    private void parseManifest(FastZipEntry manifestZipEntry, LogNode log) throws IOException, InterruptedException {
        byte[] manifest = manifestZipEntry.getSlice().load();
        int i = 0;
        while (i < manifest.length) {
            boolean skip = false;
            if (manifest[i] == 10 || manifest[i] == 13) {
                skip = true;
            } else if (keyMatchesAtPosition(manifest, IMPLEMENTATION_TITLE_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx = getManifestValue(manifest, i + IMPLEMENTATION_TITLE_KEY.length + 1);
                if (manifestValueAndEndIdx.getKey().equalsIgnoreCase("Java Runtime Environment")) {
                    this.isJREJar = true;
                }
                i = manifestValueAndEndIdx.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, SPECIFICATION_TITLE_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx2 = getManifestValue(manifest, i + SPECIFICATION_TITLE_KEY.length + 1);
                if (manifestValueAndEndIdx2.getKey().equalsIgnoreCase("Java Platform API Specification")) {
                    this.isJREJar = true;
                }
                i = manifestValueAndEndIdx2.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, CLASS_PATH_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx3 = getManifestValue(manifest, i + CLASS_PATH_KEY.length + 1);
                this.classPathManifestEntryValue = manifestValueAndEndIdx3.getKey();
                if (log != null) {
                    log.log("Found Class-Path entry in manifest file: " + this.classPathManifestEntryValue);
                }
                i = manifestValueAndEndIdx3.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, BUNDLE_CLASSPATH_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx4 = getManifestValue(manifest, i + BUNDLE_CLASSPATH_KEY.length + 1);
                this.bundleClassPathManifestEntryValue = manifestValueAndEndIdx4.getKey();
                if (log != null) {
                    log.log("Found Bundle-ClassPath entry in manifest file: " + this.bundleClassPathManifestEntryValue);
                }
                i = manifestValueAndEndIdx4.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, SPRING_BOOT_CLASSES_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx5 = getManifestValue(manifest, i + SPRING_BOOT_CLASSES_KEY.length + 1);
                String springBootClassesFieldVal = manifestValueAndEndIdx5.getKey();
                if (springBootClassesFieldVal.equals("BOOT-INF/classes") || springBootClassesFieldVal.equals("BOOT-INF/classes/") || springBootClassesFieldVal.equals("WEB-INF/classes") || springBootClassesFieldVal.equals("WEB-INF/classes/")) {
                    i = manifestValueAndEndIdx5.getValue().intValue();
                } else {
                    throw new IOException("Spring boot classes are at \"" + springBootClassesFieldVal + "\" rather than the standard location \"BOOT-INF/classes/\" or \"WEB-INF/classes/\" -- please report this at https://github.com/classgraph/classgraph/issues");
                }
            } else if (keyMatchesAtPosition(manifest, SPRING_BOOT_LIB_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx6 = getManifestValue(manifest, i + SPRING_BOOT_LIB_KEY.length + 1);
                String springBootLibFieldVal = manifestValueAndEndIdx6.getKey();
                if (springBootLibFieldVal.equals("BOOT-INF/lib") || springBootLibFieldVal.equals("BOOT-INF/lib/") || springBootLibFieldVal.equals("WEB-INF/lib") || springBootLibFieldVal.equals("WEB-INF/lib/")) {
                    i = manifestValueAndEndIdx6.getValue().intValue();
                } else {
                    throw new IOException("Spring boot lib jars are at \"" + springBootLibFieldVal + "\" rather than the standard location \"BOOT-INF/lib/\" or \"WEB-INF/lib/\" -- please report this at https://github.com/classgraph/classgraph/issues");
                }
            } else if (keyMatchesAtPosition(manifest, MULTI_RELEASE_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx7 = getManifestValue(manifest, i + MULTI_RELEASE_KEY.length + 1);
                if (manifestValueAndEndIdx7.getKey().equalsIgnoreCase(C3P0Substitutions.DEBUG)) {
                    this.isMultiReleaseJar = true;
                }
                i = manifestValueAndEndIdx7.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, ADD_EXPORTS_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx8 = getManifestValue(manifest, i + ADD_EXPORTS_KEY.length + 1);
                this.addExportsManifestEntryValue = manifestValueAndEndIdx8.getKey();
                if (log != null) {
                    log.log("Found Add-Exports entry in manifest file: " + this.addExportsManifestEntryValue);
                }
                i = manifestValueAndEndIdx8.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, ADD_OPENS_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx9 = getManifestValue(manifest, i + ADD_OPENS_KEY.length + 1);
                this.addExportsManifestEntryValue = manifestValueAndEndIdx9.getKey();
                if (log != null) {
                    log.log("Found Add-Opens entry in manifest file: " + this.addOpensManifestEntryValue);
                }
                i = manifestValueAndEndIdx9.getValue().intValue();
            } else if (keyMatchesAtPosition(manifest, AUTOMATIC_MODULE_NAME_KEY, i)) {
                Map.Entry<String, Integer> manifestValueAndEndIdx10 = getManifestValue(manifest, i + AUTOMATIC_MODULE_NAME_KEY.length + 1);
                this.automaticModuleNameManifestEntryValue = manifestValueAndEndIdx10.getKey();
                if (log != null) {
                    log.log("Found Automatic-Module-Name entry in manifest file: " + this.automaticModuleNameManifestEntryValue);
                }
                i = manifestValueAndEndIdx10.getValue().intValue();
            } else {
                skip = true;
            }
            if (skip) {
                while (true) {
                    if (i < manifest.length - 2) {
                        if (manifest[i] == 13 && manifest[i + 1] == 10 && manifest[i + 2] != 32) {
                            i += 2;
                            break;
                        } else if ((manifest[i] == 13 || manifest[i] == 10) && manifest[i + 1] != 32) {
                            i++;
                            break;
                        } else {
                            i++;
                        }
                    } else {
                        break;
                    }
                }
                if (i >= manifest.length - 2) {
                    return;
                }
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:217:0x0968
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private void readCentralDirectory(nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler r18, nonapi.p019io.github.classgraph.utils.LogNode r19) throws java.io.IOException, java.lang.InterruptedException {
        /*
        // Method dump skipped, instructions count: 3119
        */
        throw new UnsupportedOperationException("Method not decompiled: nonapi.p019io.github.classgraph.fastzipfilereader.LogicalZipFile.readCentralDirectory(nonapi.io.github.classgraph.fastzipfilereader.NestedJarHandler, nonapi.io.github.classgraph.utils.LogNode):void");
    }

    @Override // nonapi.p019io.github.classgraph.fastzipfilereader.ZipFileSlice
    public boolean equals(Object o) {
        return equals(o);
    }

    @Override // nonapi.p019io.github.classgraph.fastzipfilereader.ZipFileSlice
    public int hashCode() {
        return hashCode();
    }

    @Override // nonapi.p019io.github.classgraph.fastzipfilereader.ZipFileSlice
    public String toString() {
        return getPath();
    }
}
