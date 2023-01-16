package nonapi.p019io.github.classgraph.fastzipfilereader;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.Objects;
import nonapi.p019io.github.classgraph.fileslice.ArraySlice;
import nonapi.p019io.github.classgraph.fileslice.FileSlice;
import nonapi.p019io.github.classgraph.fileslice.PathSlice;
import nonapi.p019io.github.classgraph.fileslice.Slice;
import nonapi.p019io.github.classgraph.utils.FastPathResolver;
import nonapi.p019io.github.classgraph.utils.FileUtils;
import nonapi.p019io.github.classgraph.utils.LogNode;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.fastzipfilereader.PhysicalZipFile */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/fastzipfilereader/PhysicalZipFile.class */
public class PhysicalZipFile {
    private Path path;
    private File file;
    private final String pathStr;
    Slice slice;
    NestedJarHandler nestedJarHandler;
    private int hashCode;

    /* access modifiers changed from: package-private */
    public PhysicalZipFile(File file, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        this.nestedJarHandler = nestedJarHandler;
        FileUtils.checkCanReadAndIsFile(file);
        this.file = file;
        this.pathStr = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, file.getPath());
        this.slice = new FileSlice(file, nestedJarHandler, log);
    }

    /* access modifiers changed from: package-private */
    public PhysicalZipFile(Path path, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        this.nestedJarHandler = nestedJarHandler;
        FileUtils.checkCanReadAndIsFile(path);
        this.path = path;
        this.pathStr = FastPathResolver.resolve(FileUtils.CURR_DIR_PATH, path.toString());
        this.slice = new PathSlice(path, nestedJarHandler, log);
    }

    PhysicalZipFile(byte[] arr, File outermostFile, String pathStr, NestedJarHandler nestedJarHandler) throws IOException {
        this.nestedJarHandler = nestedJarHandler;
        this.file = outermostFile;
        this.pathStr = pathStr;
        this.slice = new ArraySlice(arr, false, 0, nestedJarHandler);
    }

    /* access modifiers changed from: package-private */
    public PhysicalZipFile(InputStream inputStream, long inputStreamLengthHint, String pathStr, NestedJarHandler nestedJarHandler, LogNode log) throws IOException {
        this.nestedJarHandler = nestedJarHandler;
        this.pathStr = pathStr;
        this.slice = nestedJarHandler.readAllBytesWithSpilloverToDisk(inputStream, pathStr, inputStreamLengthHint, log);
        this.file = this.slice instanceof FileSlice ? ((FileSlice) this.slice).file : null;
    }

    public Path getPath() {
        return this.path;
    }

    public File getFile() {
        return this.file;
    }

    public String getPathStr() {
        return this.pathStr;
    }

    public long length() {
        return this.slice.sliceLength;
    }

    public int hashCode() {
        if (this.hashCode == 0) {
            this.hashCode = this.file == null ? 0 : this.file.hashCode();
            if (this.hashCode == 0) {
                this.hashCode = 1;
            }
        }
        return this.hashCode;
    }

    public boolean equals(Object o) {
        if (o == this) {
            return true;
        }
        if (!(o instanceof PhysicalZipFile)) {
            return false;
        }
        return Objects.equals(this.file, ((PhysicalZipFile) o).file);
    }

    public String toString() {
        return this.pathStr;
    }
}
