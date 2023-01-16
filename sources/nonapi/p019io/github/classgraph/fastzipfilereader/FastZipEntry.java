package nonapi.p019io.github.classgraph.fastzipfilereader;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;
import nonapi.p019io.github.classgraph.fileslice.Slice;
import nonapi.p019io.github.classgraph.fileslice.reader.RandomAccessReader;
import nonapi.p019io.github.classgraph.utils.VersionFinder;

/* renamed from: nonapi.io.github.classgraph.fastzipfilereader.FastZipEntry */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/FastZipEntry.class */
public class FastZipEntry implements Comparable<FastZipEntry> {
    final LogicalZipFile parentLogicalZipFile;
    private final long locHeaderPos;
    public final String entryName;
    final boolean isDeflated;
    public final long compressedSize;
    public final long uncompressedSize;
    private long lastModifiedTimeMillis;
    private final int lastModifiedTimeMSDOS;
    private final int lastModifiedDateMSDOS;
    public final int fileAttributes;
    private Slice slice;
    final int version;
    public final String entryNameUnversioned;

    /* JADX DEBUG: Multi-variable search result rejected for r12v0, resolved type: long */
    /* JADX DEBUG: Multi-variable search result rejected for r14v0, resolved type: long */
    /* JADX WARN: Multi-variable type inference failed */
    /* access modifiers changed from: package-private */
    public FastZipEntry(LogicalZipFile parentLogicalZipFile, long locHeaderPos, String entryName, boolean isDeflated, long compressedSize, long uncompressedSize, long lastModifiedTimeMillis, int lastModifiedTimeMSDOS, int lastModifiedDateMSDOS, int fileAttributes) {
        int nextSlashIdx;
        int i;
        this.parentLogicalZipFile = parentLogicalZipFile;
        this.locHeaderPos = locHeaderPos;
        this.entryName = entryName;
        this.isDeflated = isDeflated;
        this.compressedSize = compressedSize;
        this.uncompressedSize = (isDeflated || uncompressedSize >= 0) ? uncompressedSize : compressedSize;
        this.lastModifiedTimeMillis = lastModifiedTimeMillis;
        this.lastModifiedTimeMSDOS = lastModifiedTimeMSDOS;
        this.lastModifiedDateMSDOS = lastModifiedDateMSDOS;
        this.fileAttributes = fileAttributes;
        int entryVersion = 8;
        String entryNameWithoutVersionPrefix = entryName;
        if (entryName.startsWith(LogicalZipFile.MULTI_RELEASE_PATH_PREFIX) && entryName.length() > LogicalZipFile.MULTI_RELEASE_PATH_PREFIX.length() + 1 && (nextSlashIdx = entryName.indexOf(47, LogicalZipFile.MULTI_RELEASE_PATH_PREFIX.length())) > 0) {
            String versionStr = entryName.substring(LogicalZipFile.MULTI_RELEASE_PATH_PREFIX.length(), nextSlashIdx);
            int versionInt = 0;
            if (versionStr.length() < 6 && !versionStr.isEmpty()) {
                for (int i2 = 0; i2 < versionStr.length(); i2++) {
                    char c = versionStr.charAt(i2);
                    if (c < '0' || c > '9') {
                        versionInt = 0;
                        break;
                    }
                    if (versionInt == 0) {
                        i = c;
                    } else {
                        i = (versionInt * 10) + c;
                    }
                    versionInt = i - 48;
                }
            }
            entryVersion = versionInt != 0 ? versionInt : entryVersion;
            entryVersion = (entryVersion < 9 || entryVersion > VersionFinder.JAVA_MAJOR_VERSION) ? 8 : entryVersion;
            if (entryVersion > 8) {
                entryNameWithoutVersionPrefix = entryName.substring(nextSlashIdx + 1);
                if (entryNameWithoutVersionPrefix.startsWith("META-INF/")) {
                    entryVersion = 8;
                    entryNameWithoutVersionPrefix = entryName;
                }
            }
        }
        this.version = entryVersion;
        this.entryNameUnversioned = entryNameWithoutVersionPrefix;
    }

    public Slice getSlice() throws IOException {
        if (this.slice == null) {
            RandomAccessReader randomAccessReader = this.parentLogicalZipFile.slice.randomAccessReader();
            if (randomAccessReader.readInt(this.locHeaderPos) != 67324752) {
                throw new IOException("Zip entry has bad LOC header: " + this.entryName);
            }
            long dataStartPos = this.locHeaderPos + 30 + ((long) randomAccessReader.readShort(this.locHeaderPos + 26)) + ((long) randomAccessReader.readShort(this.locHeaderPos + 28));
            if (dataStartPos > this.parentLogicalZipFile.slice.sliceLength) {
                throw new IOException("Unexpected EOF when trying to read zip entry data: " + this.entryName);
            }
            this.slice = this.parentLogicalZipFile.slice.slice(dataStartPos, this.compressedSize, this.isDeflated, this.uncompressedSize);
        }
        return this.slice;
    }

    public String getPath() {
        return this.parentLogicalZipFile.getPath() + "!/" + this.entryName;
    }

    public long getLastModifiedTimeMillis() {
        if (this.lastModifiedTimeMillis == 0 && !(this.lastModifiedDateMSDOS == 0 && this.lastModifiedTimeMSDOS == 0)) {
            int lastModifiedSecond = (this.lastModifiedTimeMSDOS & 31) * 2;
            int lastModifiedMinute = (this.lastModifiedTimeMSDOS >> 5) & 63;
            int lastModifiedHour = this.lastModifiedTimeMSDOS >> 11;
            int lastModifiedDay = this.lastModifiedDateMSDOS & 31;
            int lastModifiedMonth = ((this.lastModifiedDateMSDOS >> 5) & 7) - 1;
            int lastModifiedYear = (this.lastModifiedDateMSDOS >> 9) + PacketOpcodes.TakeCoopRewardReq;
            Calendar lastModifiedCalendar = Calendar.getInstance(TimeZone.getTimeZone("UTC"));
            lastModifiedCalendar.set(lastModifiedYear, lastModifiedMonth, lastModifiedDay, lastModifiedHour, lastModifiedMinute, lastModifiedSecond);
            lastModifiedCalendar.set(14, 0);
            this.lastModifiedTimeMillis = lastModifiedCalendar.getTimeInMillis();
        }
        return this.lastModifiedTimeMillis;
    }

    public int compareTo(FastZipEntry o) {
        int diff0 = o.version - this.version;
        if (diff0 != 0) {
            return diff0;
        }
        int diff1 = this.entryNameUnversioned.compareTo(o.entryNameUnversioned);
        if (diff1 != 0) {
            return diff1;
        }
        int diff2 = this.entryName.compareTo(o.entryName);
        if (diff2 != 0) {
            return diff2;
        }
        long diff3 = this.locHeaderPos - o.locHeaderPos;
        if (diff3 < 0) {
            return -1;
        }
        return diff3 > 0 ? 1 : 0;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return ((this.parentLogicalZipFile.hashCode() ^ this.version) ^ this.entryName.hashCode()) ^ ((int) this.locHeaderPos);
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FastZipEntry)) {
            return false;
        }
        FastZipEntry other = (FastZipEntry) obj;
        return this.parentLogicalZipFile.equals(other.parentLogicalZipFile) && compareTo(other) == 0;
    }

    @Override // java.lang.Object
    public String toString() {
        return "jar:file:" + getPath();
    }
}
