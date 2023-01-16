package com.mchange.p011v3.filecache;

import com.mchange.p006v1.p008io.InputStreamUtils;
import com.mchange.p006v1.p008io.OutputStreamUtils;
import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import com.mchange.p009v2.p010io.DirectoryDescentUtils;
import com.mchange.p009v2.p010io.FileIterator;
import dev.morphia.mapping.Mapper;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/* renamed from: com.mchange.v3.filecache.FileCache */
/* loaded from: grasscutter.jar:com/mchange/v3/filecache/FileCache.class */
public final class FileCache {
    final File cacheDir;
    final int buffer_size;
    final boolean read_only;
    final List<URLFetcher> fetchers;
    static final MLogger logger = MLog.getLogger(FileCache.class);
    static final FileFilter NOT_DIR_FF = new FileFilter() { // from class: com.mchange.v3.filecache.FileCache.1
        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isDirectory();
        }
    };

    private InputStream fetchURL(URL url) throws IOException {
        LinkedList linkedList = null;
        for (URLFetcher uRLFetcher : this.fetchers) {
            try {
                return uRLFetcher.openStream(url, logger);
            } catch (FileNotFoundException e) {
                throw e;
            } catch (IOException e2) {
                if (logger.isLoggable(MLevel.FINE)) {
                    logger.log(MLevel.FINE, "URLFetcher " + uRLFetcher + " failed on Exception. Will try next fetcher, if any.", (Throwable) e2);
                }
                if (linkedList == null) {
                    linkedList = new LinkedList();
                }
                linkedList.add(e2);
            }
        }
        if (logger.isLoggable(MLevel.WARNING)) {
            logger.log(MLevel.WARNING, "All URLFetchers failed on URL " + url);
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                logger.log(MLevel.WARNING, "URLFetcher Exception #" + (i + 1), (Throwable) linkedList.get(i));
            }
        }
        throw new IOException("Failed to fetch URL '" + url + "'.");
    }

    public FileCache(File file, int i, boolean z) throws IOException {
        this(file, i, z, Collections.singletonList(URLFetchers.DEFAULT));
    }

    public FileCache(File file, int i, boolean z, URLFetcher... uRLFetcherArr) throws IOException {
        this(file, i, z, Arrays.asList(uRLFetcherArr));
    }

    public FileCache(File file, int i, boolean z, List<URLFetcher> list) throws IOException {
        this.cacheDir = file;
        this.buffer_size = i;
        this.read_only = z;
        this.fetchers = Collections.unmodifiableList(list);
        if (file.exists()) {
            if (!file.isDirectory()) {
                loggedIOException(MLevel.SEVERE, file + "exists and is not a directory. Can't use as cacheDir.");
            } else if (!file.canRead()) {
                loggedIOException(MLevel.SEVERE, file + "must be readable.");
            } else if (!file.canWrite() && !z) {
                loggedIOException(MLevel.SEVERE, file + "not writable, and not read only.");
            }
        } else if (!file.mkdir()) {
            loggedIOException(MLevel.SEVERE, file + "does not exist and could not be created.");
        }
    }

    public void ensureCached(FileCacheKey fileCacheKey, boolean z) throws IOException {
        BufferedOutputStream bufferedOutputStream;
        BufferedInputStream bufferedInputStream;
        File file = file(fileCacheKey);
        if (!this.read_only) {
            if (z || !file.exists()) {
                try {
                    bufferedInputStream = null;
                    bufferedOutputStream = null;
                    try {
                        if (logger.isLoggable(MLevel.FINE)) {
                            logger.log(MLevel.FINE, "Caching file for " + fileCacheKey + " to " + file.getAbsolutePath() + "...");
                        }
                        File parentFile = file.getParentFile();
                        if (!parentFile.exists()) {
                            parentFile.mkdirs();
                        }
                        bufferedInputStream = new BufferedInputStream(fetchURL(fileCacheKey.getURL()), this.buffer_size);
                        bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file), this.buffer_size);
                        for (int read = bufferedInputStream.read(); read >= 0; read = bufferedInputStream.read()) {
                            bufferedOutputStream.write(read);
                        }
                        if (logger.isLoggable(MLevel.INFO)) {
                            logger.log(MLevel.INFO, "Cached file for " + fileCacheKey + Mapper.IGNORED_FIELDNAME);
                        }
                    } catch (IOException e) {
                        logger.log(MLevel.WARNING, "An exception occurred while caching file for " + fileCacheKey + ". Deleting questionable cached file.", (Throwable) e);
                        file.delete();
                        throw e;
                    }
                } finally {
                    InputStreamUtils.attemptClose(bufferedInputStream);
                    OutputStreamUtils.attemptClose(bufferedOutputStream);
                }
            } else if (logger.isLoggable(MLevel.FINE)) {
                logger.log(MLevel.FINE, "File for " + fileCacheKey + " already exists and force_reacquire is not set.");
            }
        } else if (z) {
            IllegalArgumentException illegalArgumentException = new IllegalArgumentException("force_reacquire canot be set on a read_only FileCache.");
            logger.log(MLevel.WARNING, "force_reacquire canot be set on a read_only FileCache.", (Throwable) illegalArgumentException);
            throw illegalArgumentException;
        } else if (!file.exists()) {
            String str = "Cache is read only, and file for key '" + fileCacheKey + "' does not exist.";
            FileNotCachedException fileNotCachedException = new FileNotCachedException(str);
            logger.log(MLevel.FINE, str, (Throwable) fileNotCachedException);
            throw fileNotCachedException;
        }
    }

    public InputStream fetch(FileCacheKey fileCacheKey, boolean z) throws IOException {
        ensureCached(fileCacheKey, z);
        return new FileInputStream(file(fileCacheKey));
    }

    public boolean isCached(FileCacheKey fileCacheKey) throws IOException {
        return file(fileCacheKey).exists();
    }

    /* renamed from: com.mchange.v3.filecache.FileCache$NotDirAndFileFilter */
    /* loaded from: grasscutter.jar:com/mchange/v3/filecache/FileCache$NotDirAndFileFilter.class */
    static class NotDirAndFileFilter implements FileFilter {

        /* renamed from: ff */
        FileFilter f424ff;

        NotDirAndFileFilter(FileFilter fileFilter) {
            this.f424ff = fileFilter;
        }

        @Override // java.io.FileFilter
        public boolean accept(File file) {
            return !file.isDirectory() && this.f424ff.accept(file);
        }
    }

    public int countCached() throws IOException {
        int i = 0;
        FileIterator depthFirstEagerDescent = DirectoryDescentUtils.depthFirstEagerDescent(this.cacheDir, NOT_DIR_FF, false);
        while (depthFirstEagerDescent.hasNext()) {
            depthFirstEagerDescent.next();
            i++;
        }
        return i;
    }

    public int countCached(FileFilter fileFilter) throws IOException {
        int i = 0;
        FileIterator depthFirstEagerDescent = DirectoryDescentUtils.depthFirstEagerDescent(this.cacheDir, new NotDirAndFileFilter(fileFilter), false);
        while (depthFirstEagerDescent.hasNext()) {
            depthFirstEagerDescent.next();
            i++;
        }
        return i;
    }

    public File fileForKey(FileCacheKey fileCacheKey) {
        return file(fileCacheKey);
    }

    private File file(FileCacheKey fileCacheKey) {
        return new File(this.cacheDir, fileCacheKey.getCacheFilePath());
    }

    private void loggedIOException(MLevel mLevel, String str) throws IOException {
        IOException iOException = new IOException(str);
        logger.log(mLevel, str, (Throwable) iOException);
        throw iOException;
    }
}
