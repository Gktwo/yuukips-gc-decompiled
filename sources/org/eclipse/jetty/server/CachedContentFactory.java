package org.eclipse.jetty.server;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.channels.ReadableByteChannel;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.DateGenerator;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.HttpField;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.PreEncodedHttpField;
import org.eclipse.jetty.http.PrecompressedHttpContent;
import org.eclipse.jetty.http.ResourceHttpContent;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/CachedContentFactory.class */
public class CachedContentFactory implements HttpContent.ContentFactory {
    private static final Logger LOG = Log.getLogger(CachedContentFactory.class);
    private static final Map<CompressedContentFormat, CachedPrecompressedHttpContent> NO_PRECOMPRESSED = Collections.unmodifiableMap(Collections.emptyMap());
    private final ResourceFactory _factory;
    private final CachedContentFactory _parent;
    private final MimeTypes _mimeTypes;
    private final boolean _etags;
    private final CompressedContentFormat[] _precompressedFormats;
    private final boolean _useFileMappedBuffer;
    private int _maxCachedFileSize = 134217728;
    private int _maxCachedFiles = 2048;
    private int _maxCacheSize = 268435456;
    private final ConcurrentMap<String, CachedHttpContent> _cache = new ConcurrentHashMap();
    private final AtomicInteger _cachedSize = new AtomicInteger();
    private final AtomicInteger _cachedFiles = new AtomicInteger();

    public CachedContentFactory(CachedContentFactory parent, ResourceFactory factory, MimeTypes mimeTypes, boolean useFileMappedBuffer, boolean etags, CompressedContentFormat[] precompressedFormats) {
        this._factory = factory;
        this._mimeTypes = mimeTypes;
        this._parent = parent;
        this._useFileMappedBuffer = useFileMappedBuffer;
        this._etags = etags;
        this._precompressedFormats = precompressedFormats;
    }

    public int getCachedSize() {
        return this._cachedSize.get();
    }

    public int getCachedFiles() {
        return this._cachedFiles.get();
    }

    public int getMaxCachedFileSize() {
        return this._maxCachedFileSize;
    }

    public void setMaxCachedFileSize(int maxCachedFileSize) {
        this._maxCachedFileSize = maxCachedFileSize;
        shrinkCache();
    }

    public int getMaxCacheSize() {
        return this._maxCacheSize;
    }

    public void setMaxCacheSize(int maxCacheSize) {
        this._maxCacheSize = maxCacheSize;
        shrinkCache();
    }

    public int getMaxCachedFiles() {
        return this._maxCachedFiles;
    }

    public void setMaxCachedFiles(int maxCachedFiles) {
        this._maxCachedFiles = maxCachedFiles;
        shrinkCache();
    }

    public boolean isUseFileMappedBuffer() {
        return this._useFileMappedBuffer;
    }

    public void flushCache() {
        while (this._cache.size() > 0) {
            for (String path : this._cache.keySet()) {
                CachedHttpContent content = this._cache.remove(path);
                if (content != null) {
                    content.invalidate();
                }
            }
        }
    }

    @Deprecated
    public HttpContent lookup(String pathInContext) throws IOException {
        return getContent(pathInContext, this._maxCachedFileSize);
    }

    @Override // org.eclipse.jetty.http.HttpContent.ContentFactory
    public HttpContent getContent(String pathInContext, int maxBufferSize) throws IOException {
        HttpContent httpContent;
        CachedHttpContent content = this._cache.get(pathInContext);
        if (content != null && content.isValid()) {
            return content;
        }
        HttpContent loaded = load(pathInContext, this._factory.getResource(pathInContext), maxBufferSize);
        if (loaded != null) {
            return loaded;
        }
        if (this._parent == null || (httpContent = this._parent.getContent(pathInContext, maxBufferSize)) == null) {
            return null;
        }
        return httpContent;
    }

    protected boolean isCacheable(Resource resource) {
        if (this._maxCachedFiles <= 0) {
            return false;
        }
        long len = resource.length();
        return len > 0 && (this._useFileMappedBuffer || (len < ((long) this._maxCachedFileSize) && len < ((long) this._maxCacheSize)));
    }

    private HttpContent load(String pathInContext, Resource resource, int maxBufferSize) {
        CachedHttpContent content;
        if (resource == null || !resource.exists()) {
            return null;
        }
        if (resource.isDirectory()) {
            return new ResourceHttpContent(resource, this._mimeTypes.getMimeByExtension(resource.toString()), getMaxCachedFileSize());
        }
        if (isCacheable(resource)) {
            if (this._precompressedFormats.length > 0) {
                Map<CompressedContentFormat, CachedHttpContent> precompresssedContents = new HashMap<>(this._precompressedFormats.length);
                CompressedContentFormat[] compressedContentFormatArr = this._precompressedFormats;
                for (CompressedContentFormat format : compressedContentFormatArr) {
                    String compressedPathInContext = pathInContext + format.getExtension();
                    CachedHttpContent compressedContent = this._cache.get(compressedPathInContext);
                    if (compressedContent == null || compressedContent.isValid()) {
                        compressedContent = null;
                        Resource compressedResource = this._factory.getResource(compressedPathInContext);
                        if (compressedResource.exists() && compressedResource.lastModified() >= resource.lastModified() && compressedResource.length() < resource.length()) {
                            compressedContent = new CachedHttpContent(compressedPathInContext, compressedResource, null);
                            CachedHttpContent added = this._cache.putIfAbsent(compressedPathInContext, compressedContent);
                            if (added != null) {
                                compressedContent.invalidate();
                                compressedContent = added;
                            }
                        }
                    }
                    if (compressedContent != null) {
                        precompresssedContents.put(format, compressedContent);
                    }
                }
                content = new CachedHttpContent(pathInContext, resource, precompresssedContents);
            } else {
                content = new CachedHttpContent(pathInContext, resource, null);
            }
            CachedHttpContent added2 = this._cache.putIfAbsent(pathInContext, content);
            if (added2 != null) {
                content.invalidate();
                content = added2;
            }
            return content;
        }
        String mt = this._mimeTypes.getMimeByExtension(pathInContext);
        if (this._precompressedFormats.length > 0) {
            Map<CompressedContentFormat, HttpContent> compressedContents = new HashMap<>();
            CompressedContentFormat[] compressedContentFormatArr2 = this._precompressedFormats;
            for (CompressedContentFormat format2 : compressedContentFormatArr2) {
                String compressedPathInContext2 = pathInContext + format2.getExtension();
                CachedHttpContent compressedContent2 = this._cache.get(compressedPathInContext2);
                if (compressedContent2 != null && compressedContent2.isValid() && compressedContent2.getResource().lastModified() >= resource.lastModified()) {
                    compressedContents.put(format2, compressedContent2);
                }
                Resource compressedResource2 = this._factory.getResource(compressedPathInContext2);
                if (compressedResource2.exists() && compressedResource2.lastModified() >= resource.lastModified() && compressedResource2.length() < resource.length()) {
                    compressedContents.put(format2, new ResourceHttpContent(compressedResource2, this._mimeTypes.getMimeByExtension(compressedPathInContext2), maxBufferSize));
                }
            }
            if (!compressedContents.isEmpty()) {
                return new ResourceHttpContent(resource, mt, maxBufferSize, compressedContents);
            }
        }
        return new ResourceHttpContent(resource, mt, maxBufferSize);
    }

    /* access modifiers changed from: private */
    public void shrinkCache() {
        while (this._cache.size() > 0) {
            if (this._cachedFiles.get() > this._maxCachedFiles || this._cachedSize.get() > this._maxCacheSize) {
                SortedSet<CachedHttpContent> sorted = new TreeSet<>(c1, c2 -> {
                    if (c1._lastAccessed < c2._lastAccessed) {
                        return -1;
                    }
                    if (c1._lastAccessed > c2._lastAccessed) {
                        return 1;
                    }
                    if (c1._contentLengthValue < c2._contentLengthValue) {
                        return -1;
                    }
                    return c1._key.compareTo(c2._key);
                });
                sorted.addAll(this._cache.values());
                for (CachedHttpContent content : sorted) {
                    if (this._cachedFiles.get() > this._maxCachedFiles || this._cachedSize.get() > this._maxCacheSize) {
                        if (content == this._cache.remove(content.getKey())) {
                            content.invalidate();
                        }
                    }
                }
            } else {
                return;
            }
        }
    }

    protected ByteBuffer getIndirectBuffer(Resource resource) {
        try {
            return BufferUtil.toBuffer(resource, false);
        } catch (IOException | IllegalArgumentException e) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.debug(e);
            return null;
        }
    }

    protected ByteBuffer getMappedBuffer(Resource resource) {
        try {
            if (!this._useFileMappedBuffer || resource.getFile() == null || resource.length() >= 2147483647L) {
                return null;
            }
            return BufferUtil.toMappedBuffer(resource.getFile());
        } catch (IOException | IllegalArgumentException e) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.debug(e);
            return null;
        }
    }

    protected ByteBuffer getDirectBuffer(Resource resource) {
        try {
            return BufferUtil.toBuffer(resource, true);
        } catch (IOException | IllegalArgumentException e) {
            if (!LOG.isDebugEnabled()) {
                return null;
            }
            LOG.debug(e);
            return null;
        }
    }

    public String toString() {
        return "ResourceCache[" + this._parent + "," + this._factory + "]@" + hashCode();
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/CachedContentFactory$CachedHttpContent.class */
    public class CachedHttpContent implements HttpContent {
        private final String _key;
        private final Resource _resource;
        private final long _contentLengthValue;
        private final HttpField _contentType;
        private final String _characterEncoding;
        private final MimeTypes.Type _mimeType;
        private final HttpField _contentLength;
        private final HttpField _lastModified;
        private final long _lastModifiedValue;
        private final HttpField _etag;
        private final Map<CompressedContentFormat, CachedPrecompressedHttpContent> _precompressed;
        private final AtomicReference<ByteBuffer> _indirectBuffer = new AtomicReference<>();
        private final AtomicReference<ByteBuffer> _directBuffer = new AtomicReference<>();
        private final AtomicReference<ByteBuffer> _mappedBuffer = new AtomicReference<>();
        private volatile long _lastAccessed;

        CachedHttpContent(String pathInContext, Resource resource, Map<CompressedContentFormat, CachedHttpContent> precompressedResources) {
            this._key = pathInContext;
            this._resource = resource;
            String contentType = CachedContentFactory.this._mimeTypes.getMimeByExtension(this._resource.toString());
            this._contentType = contentType == null ? null : new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, contentType);
            this._characterEncoding = this._contentType == null ? null : MimeTypes.getCharsetFromContentType(contentType);
            this._mimeType = this._contentType == null ? null : MimeTypes.CACHE.get(MimeTypes.getContentTypeWithoutCharset(contentType));
            boolean exists = resource.exists();
            this._lastModifiedValue = exists ? resource.lastModified() : -1;
            this._lastModified = this._lastModifiedValue == -1 ? null : new PreEncodedHttpField(HttpHeader.LAST_MODIFIED, DateGenerator.formatDate(this._lastModifiedValue));
            this._contentLengthValue = exists ? resource.length() : 0;
            this._contentLength = new PreEncodedHttpField(HttpHeader.CONTENT_LENGTH, Long.toString(this._contentLengthValue));
            if (CachedContentFactory.this._cachedFiles.incrementAndGet() > CachedContentFactory.this._maxCachedFiles) {
                CachedContentFactory.this.shrinkCache();
            }
            this._lastAccessed = System.currentTimeMillis();
            this._etag = CachedContentFactory.this._etags ? new PreEncodedHttpField(HttpHeader.ETAG, resource.getWeakETag()) : null;
            if (precompressedResources != null) {
                this._precompressed = new HashMap(precompressedResources.size());
                for (Map.Entry<CompressedContentFormat, CachedHttpContent> entry : precompressedResources.entrySet()) {
                    this._precompressed.put(entry.getKey(), new CachedPrecompressedHttpContent(this, entry.getValue(), entry.getKey()));
                }
                return;
            }
            this._precompressed = CachedContentFactory.NO_PRECOMPRESSED;
        }

        public String getKey() {
            return this._key;
        }

        public boolean isCached() {
            return this._key != null;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Resource getResource() {
            return this._resource;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public HttpField getETag() {
            return this._etag;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public String getETagValue() {
            return this._etag.getValue();
        }

        boolean isValid() {
            if (this._lastModifiedValue == this._resource.lastModified() && this._contentLengthValue == this._resource.length()) {
                this._lastAccessed = System.currentTimeMillis();
                return true;
            } else if (this != CachedContentFactory.this._cache.remove(this._key)) {
                return false;
            } else {
                invalidate();
                return false;
            }
        }

        protected void invalidate() {
            ByteBuffer indirect = this._indirectBuffer.getAndSet(null);
            if (indirect != null) {
                CachedContentFactory.this._cachedSize.addAndGet(-BufferUtil.length(indirect));
            }
            ByteBuffer direct = this._directBuffer.getAndSet(null);
            if (direct != null) {
                CachedContentFactory.this._cachedSize.addAndGet(-BufferUtil.length(direct));
            }
            this._mappedBuffer.getAndSet(null);
            CachedContentFactory.this._cachedFiles.decrementAndGet();
            this._resource.close();
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public HttpField getLastModified() {
            return this._lastModified;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public String getLastModifiedValue() {
            if (this._lastModified == null) {
                return null;
            }
            return this._lastModified.getValue();
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public HttpField getContentType() {
            return this._contentType;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public String getContentTypeValue() {
            if (this._contentType == null) {
                return null;
            }
            return this._contentType.getValue();
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public HttpField getContentEncoding() {
            return null;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public String getContentEncodingValue() {
            return null;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public String getCharacterEncoding() {
            return this._characterEncoding;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public MimeTypes.Type getMimeType() {
            return this._mimeType;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public void release() {
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public ByteBuffer getIndirectBuffer() {
            if (this._resource.length() > ((long) CachedContentFactory.this._maxCachedFileSize)) {
                return null;
            }
            ByteBuffer buffer = this._indirectBuffer.get();
            if (buffer == null) {
                ByteBuffer buffer2 = CachedContentFactory.this.getIndirectBuffer(this._resource);
                if (buffer2 == null) {
                    if (!CachedContentFactory.LOG.isDebugEnabled()) {
                        return null;
                    }
                    CachedContentFactory.LOG.debug("Could not load indirect buffer from " + this, new Object[0]);
                    return null;
                } else if (this._indirectBuffer.compareAndSet(null, buffer2)) {
                    buffer = buffer2;
                    if (CachedContentFactory.this._cachedSize.addAndGet(BufferUtil.length(buffer)) > CachedContentFactory.this._maxCacheSize) {
                        CachedContentFactory.this.shrinkCache();
                    }
                } else {
                    buffer = this._indirectBuffer.get();
                }
            }
            if (buffer == null) {
                return null;
            }
            return buffer.asReadOnlyBuffer();
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public ByteBuffer getDirectBuffer() {
            ByteBuffer buffer = this._mappedBuffer.get();
            if (buffer == null) {
                buffer = this._directBuffer.get();
            }
            if (buffer == null) {
                ByteBuffer mapped = CachedContentFactory.this.getMappedBuffer(this._resource);
                if (mapped != null) {
                    buffer = this._mappedBuffer.compareAndSet(null, mapped) ? mapped : this._mappedBuffer.get();
                } else if (this._resource.length() < ((long) CachedContentFactory.this._maxCachedFileSize)) {
                    ByteBuffer direct = CachedContentFactory.this.getDirectBuffer(this._resource);
                    if (direct != null) {
                        if (this._directBuffer.compareAndSet(null, direct)) {
                            buffer = direct;
                            if (CachedContentFactory.this._cachedSize.addAndGet(BufferUtil.length(buffer)) > CachedContentFactory.this._maxCacheSize) {
                                CachedContentFactory.this.shrinkCache();
                            }
                        } else {
                            buffer = this._directBuffer.get();
                        }
                    } else if (CachedContentFactory.LOG.isDebugEnabled()) {
                        CachedContentFactory.LOG.debug("Could not load " + this, new Object[0]);
                    }
                }
            }
            if (buffer == null) {
                return null;
            }
            return buffer.asReadOnlyBuffer();
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public HttpField getContentLength() {
            return this._contentLength;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public long getContentLengthValue() {
            return this._contentLengthValue;
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public InputStream getInputStream() throws IOException {
            ByteBuffer indirect = getIndirectBuffer();
            if (indirect == null || !indirect.hasArray()) {
                return this._resource.getInputStream();
            }
            return new ByteArrayInputStream(indirect.array(), indirect.arrayOffset() + indirect.position(), indirect.remaining());
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public ReadableByteChannel getReadableByteChannel() throws IOException {
            return this._resource.getReadableByteChannel();
        }

        public String toString() {
            return String.format("CachedContent@%x{r=%s,e=%b,lm=%s,ct=%s,c=%d}", Integer.valueOf(hashCode()), this._resource, Boolean.valueOf(this._resource.exists()), this._lastModified, this._contentType, Integer.valueOf(this._precompressed.size()));
        }

        @Override // org.eclipse.jetty.http.HttpContent
        public Map<CompressedContentFormat, ? extends HttpContent> getPrecompressedContents() {
            if (this._precompressed.size() == 0) {
                return null;
            }
            Map<CompressedContentFormat, CachedPrecompressedHttpContent> ret = this._precompressed;
            for (Map.Entry<CompressedContentFormat, CachedPrecompressedHttpContent> entry : this._precompressed.entrySet()) {
                if (!entry.getValue().isValid()) {
                    if (ret == this._precompressed) {
                        ret = new HashMap<>(this._precompressed);
                    }
                    ret.remove(entry.getKey());
                }
            }
            return ret;
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/CachedContentFactory$CachedPrecompressedHttpContent.class */
    public class CachedPrecompressedHttpContent extends PrecompressedHttpContent {
        private final CachedHttpContent _content;
        private final CachedHttpContent _precompressedContent;
        private final HttpField _etag;

        CachedPrecompressedHttpContent(CachedHttpContent content, CachedHttpContent precompressedContent, CompressedContentFormat format) {
            super(content, precompressedContent, format);
            this._content = content;
            this._precompressedContent = precompressedContent;
            this._etag = CachedContentFactory.this._etags ? new PreEncodedHttpField(HttpHeader.ETAG, this._content.getResource().getWeakETag(format.getEtagSuffix())) : null;
        }

        public boolean isValid() {
            return this._precompressedContent.isValid() && this._content.isValid() && this._content.getResource().lastModified() <= this._precompressedContent.getResource().lastModified();
        }

        @Override // org.eclipse.jetty.http.PrecompressedHttpContent, org.eclipse.jetty.http.HttpContent
        public HttpField getETag() {
            if (this._etag != null) {
                return this._etag;
            }
            return getETag();
        }

        @Override // org.eclipse.jetty.http.PrecompressedHttpContent, org.eclipse.jetty.http.HttpContent
        public String getETagValue() {
            if (this._etag != null) {
                return this._etag.getValue();
            }
            return getETagValue();
        }

        @Override // org.eclipse.jetty.http.PrecompressedHttpContent
        public String toString() {
            return "Cached" + toString();
        }
    }
}
