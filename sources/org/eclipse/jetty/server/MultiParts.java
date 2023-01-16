package org.eclipse.jetty.server;

import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.List;
import javax.servlet.MultipartConfigElement;
import javax.servlet.http.Part;
import org.eclipse.jetty.http.HttpCompliance;
import org.eclipse.jetty.http.MultiPartFormInputStream;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.util.MultiPartInputStreamParser;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/MultiParts.class */
public interface MultiParts extends Closeable {
    Collection<Part> getParts() throws IOException;

    Part getPart(String str) throws IOException;

    boolean isEmpty();

    ContextHandler.Context getContext();

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/MultiParts$MultiPartsHttpParser.class */
    public static class MultiPartsHttpParser implements MultiParts {
        private final MultiPartFormInputStream _httpParser;
        private final ContextHandler.Context _context;
        private final Request _request;

        public MultiPartsHttpParser(InputStream in, String contentType, MultipartConfigElement config, File contextTmpDir, Request request) throws IOException {
            this._httpParser = new MultiPartFormInputStream(in, contentType, config, contextTmpDir);
            this._context = request.getContext();
            this._request = request;
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public Collection<Part> getParts() throws IOException {
            Collection<Part> parts = this._httpParser.getParts();
            setNonComplianceViolationsOnRequest();
            return parts;
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public Part getPart(String name) throws IOException {
            Part part = this._httpParser.getPart(name);
            setNonComplianceViolationsOnRequest();
            return part;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._httpParser.deleteParts();
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public boolean isEmpty() {
            return this._httpParser.isEmpty();
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public ContextHandler.Context getContext() {
            return this._context;
        }

        private void setNonComplianceViolationsOnRequest() {
            if (((List) this._request.getAttribute(HttpCompliance.VIOLATIONS_ATTR)) == null) {
                EnumSet<MultiPartFormInputStream.NonCompliance> nonComplianceWarnings = this._httpParser.getNonComplianceWarnings();
                List<String> violations = new ArrayList<>();
                Iterator it = nonComplianceWarnings.iterator();
                while (it.hasNext()) {
                    MultiPartFormInputStream.NonCompliance nc = (MultiPartFormInputStream.NonCompliance) it.next();
                    violations.add(nc.name() + ": " + nc.getURL());
                }
                this._request.setAttribute(HttpCompliance.VIOLATIONS_ATTR, violations);
            }
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/MultiParts$MultiPartsUtilParser.class */
    public static class MultiPartsUtilParser implements MultiParts {
        private final MultiPartInputStreamParser _utilParser;
        private final ContextHandler.Context _context;
        private final Request _request;

        public MultiPartsUtilParser(InputStream in, String contentType, MultipartConfigElement config, File contextTmpDir, Request request) throws IOException {
            this._utilParser = new MultiPartInputStreamParser(in, contentType, config, contextTmpDir);
            this._context = request.getContext();
            this._request = request;
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public Collection<Part> getParts() throws IOException {
            Collection<Part> parts = this._utilParser.getParts();
            setNonComplianceViolationsOnRequest();
            return parts;
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public Part getPart(String name) throws IOException {
            Part part = this._utilParser.getPart(name);
            setNonComplianceViolationsOnRequest();
            return part;
        }

        @Override // java.io.Closeable, java.lang.AutoCloseable
        public void close() {
            this._utilParser.deleteParts();
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public boolean isEmpty() {
            return this._utilParser.getParsedParts().isEmpty();
        }

        @Override // org.eclipse.jetty.server.MultiParts
        public ContextHandler.Context getContext() {
            return this._context;
        }

        private void setNonComplianceViolationsOnRequest() {
            if (((List) this._request.getAttribute(HttpCompliance.VIOLATIONS_ATTR)) == null) {
                EnumSet<MultiPartInputStreamParser.NonCompliance> nonComplianceWarnings = this._utilParser.getNonComplianceWarnings();
                List<String> violations = new ArrayList<>();
                Iterator it = nonComplianceWarnings.iterator();
                while (it.hasNext()) {
                    MultiPartInputStreamParser.NonCompliance nc = (MultiPartInputStreamParser.NonCompliance) it.next();
                    violations.add(nc.name() + ": " + nc.getURL());
                }
                this._request.setAttribute(HttpCompliance.VIOLATIONS_ATTR, violations);
            }
        }
    }
}
