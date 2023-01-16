package org.eclipse.jetty.server;

import java.io.IOException;
import java.nio.file.InvalidPathException;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.jetty.http.CompressedContentFormat;
import org.eclipse.jetty.http.HttpContent;
import org.eclipse.jetty.http.MimeTypes;
import org.eclipse.jetty.http.ResourceHttpContent;
import org.eclipse.jetty.util.resource.Resource;
import org.eclipse.jetty.util.resource.ResourceFactory;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/ResourceContentFactory.class */
public class ResourceContentFactory implements HttpContent.ContentFactory {
    private final ResourceFactory _factory;
    private final MimeTypes _mimeTypes;
    private final CompressedContentFormat[] _precompressedFormats;

    public ResourceContentFactory(ResourceFactory factory, MimeTypes mimeTypes, CompressedContentFormat[] precompressedFormats) {
        this._factory = factory;
        this._mimeTypes = mimeTypes;
        this._precompressedFormats = precompressedFormats;
    }

    @Override // org.eclipse.jetty.http.HttpContent.ContentFactory
    public HttpContent getContent(String pathInContext, int maxBufferSize) throws IOException {
        try {
            return load(pathInContext, this._factory.getResource(pathInContext), maxBufferSize);
        } catch (Throwable t) {
            throw ((InvalidPathException) new InvalidPathException(pathInContext, "Invalid PathInContext").initCause(t));
        }
    }

    private HttpContent load(String pathInContext, Resource resource, int maxBufferSize) throws IOException {
        if (resource == null || !resource.exists()) {
            return null;
        }
        if (resource.isDirectory()) {
            return new ResourceHttpContent(resource, this._mimeTypes.getMimeByExtension(resource.toString()), maxBufferSize);
        }
        String mt = this._mimeTypes.getMimeByExtension(pathInContext);
        if (this._precompressedFormats.length > 0) {
            Map<CompressedContentFormat, HttpContent> compressedContents = new HashMap<>(this._precompressedFormats.length);
            CompressedContentFormat[] compressedContentFormatArr = this._precompressedFormats;
            for (CompressedContentFormat format : compressedContentFormatArr) {
                String compressedPathInContext = pathInContext + format.getExtension();
                Resource compressedResource = this._factory.getResource(compressedPathInContext);
                if (compressedResource != null && compressedResource.exists() && compressedResource.lastModified() >= resource.lastModified() && compressedResource.length() < resource.length()) {
                    compressedContents.put(format, new ResourceHttpContent(compressedResource, this._mimeTypes.getMimeByExtension(compressedPathInContext), maxBufferSize));
                }
            }
            if (!compressedContents.isEmpty()) {
                return new ResourceHttpContent(resource, mt, maxBufferSize, compressedContents);
            }
        }
        return new ResourceHttpContent(resource, mt, maxBufferSize);
    }

    public String toString() {
        return "ResourceContentFactory[" + this._factory + "]@" + hashCode();
    }
}
