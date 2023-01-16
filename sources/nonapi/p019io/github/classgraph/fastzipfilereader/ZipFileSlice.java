package nonapi.p019io.github.classgraph.fastzipfilereader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Objects;
import nonapi.p019io.github.classgraph.fileslice.Slice;
import nonapi.p019io.github.classgraph.scanspec.WhiteBlackList;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;

/* renamed from: nonapi.io.github.classgraph.fastzipfilereader.ZipFileSlice */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/ZipFileSlice.class */
public class ZipFileSlice {
    private final ZipFileSlice parentZipFileSlice;
    protected final PhysicalZipFile physicalZipFile;
    private final String pathWithinParentZipFileSlice;
    public Slice slice;

    /* access modifiers changed from: package-private */
    public ZipFileSlice(PhysicalZipFile physicalZipFile) {
        this.parentZipFileSlice = null;
        this.physicalZipFile = physicalZipFile;
        this.slice = physicalZipFile.slice;
        this.pathWithinParentZipFileSlice = physicalZipFile.getPathStr();
    }

    /* access modifiers changed from: package-private */
    public ZipFileSlice(PhysicalZipFile physicalZipFile, FastZipEntry zipEntry) {
        this.parentZipFileSlice = zipEntry.parentLogicalZipFile;
        this.physicalZipFile = physicalZipFile;
        this.slice = physicalZipFile.slice;
        this.pathWithinParentZipFileSlice = zipEntry.entryName;
    }

    /* access modifiers changed from: package-private */
    public ZipFileSlice(FastZipEntry zipEntry) throws IOException, InterruptedException {
        this.parentZipFileSlice = zipEntry.parentLogicalZipFile;
        this.physicalZipFile = zipEntry.parentLogicalZipFile.physicalZipFile;
        this.slice = zipEntry.getSlice();
        this.pathWithinParentZipFileSlice = zipEntry.entryName;
    }

    /* access modifiers changed from: package-private */
    public ZipFileSlice(ZipFileSlice other) {
        this.parentZipFileSlice = other.parentZipFileSlice;
        this.physicalZipFile = other.physicalZipFile;
        this.slice = other.slice;
        this.pathWithinParentZipFileSlice = other.pathWithinParentZipFileSlice;
    }

    public boolean isWhitelistedAndNotBlacklisted(WhiteBlackList.WhiteBlackListLeafname jarWhiteBlackList) {
        return jarWhiteBlackList.isWhitelistedAndNotBlacklisted(this.pathWithinParentZipFileSlice) && (this.parentZipFileSlice == null || this.parentZipFileSlice.isWhitelistedAndNotBlacklisted(jarWhiteBlackList));
    }

    public ZipFileSlice getParentZipFileSlice() {
        return this.parentZipFileSlice;
    }

    public String getPathWithinParentZipFileSlice() {
        return this.pathWithinParentZipFileSlice;
    }

    private void appendPath(StringBuilder buf) {
        if (this.parentZipFileSlice != null) {
            this.parentZipFileSlice.appendPath(buf);
            if (buf.length() > 0) {
                buf.append("!/");
            }
        }
        buf.append(this.pathWithinParentZipFileSlice);
    }

    public String getPath() {
        StringBuilder buf = new StringBuilder();
        appendPath(buf);
        return buf.toString();
    }

    public File getPhysicalFile() {
        Path path = this.physicalZipFile.getPath();
        if (path == null) {
            return this.physicalZipFile.getFile();
        }
        try {
            return path.toFile();
        } catch (UnsupportedOperationException e) {
            return null;
        }
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof ZipFileSlice)) {
            return false;
        }
        ZipFileSlice other = (ZipFileSlice) o;
        return Objects.equals(this.physicalZipFile, other.physicalZipFile) && Objects.equals(this.slice, other.slice) && Objects.equals(this.pathWithinParentZipFileSlice, other.pathWithinParentZipFileSlice);
    }

    public int hashCode() {
        return Objects.hash(this.physicalZipFile, this.slice, this.pathWithinParentZipFileSlice);
    }

    public String toString() {
        String path = getPath();
        String fileStr = this.physicalZipFile.getPath() == null ? null : this.physicalZipFile.getPath().toString();
        if (fileStr == null) {
            fileStr = this.physicalZipFile.getFile() == null ? null : this.physicalZipFile.getFile().toString();
        }
        return "[" + ((fileStr == null || fileStr.equals(path)) ? path : path + " -> " + fileStr) + " ; byte range: " + this.slice.sliceStartPos + CallerDataConverter.DEFAULT_RANGE_DELIMITER + (this.slice.sliceStartPos + this.slice.sliceLength) + " / " + this.physicalZipFile.length() + "]";
    }
}
