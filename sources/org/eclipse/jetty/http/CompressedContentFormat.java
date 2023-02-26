package org.eclipse.jetty.http;

import java.util.Objects;
import org.eclipse.jetty.server.handler.gzip.GzipHandler;
import org.eclipse.jetty.util.QuotedStringTokenizer;
import org.eclipse.jetty.util.StringUtil;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/CompressedContentFormat.class */
public class CompressedContentFormat {
    public static final String ETAG_SEPARATOR = System.getProperty(CompressedContentFormat.class.getName() + ".ETAG_SEPARATOR", "--");
    public static final CompressedContentFormat GZIP = new CompressedContentFormat(GzipHandler.GZIP, ".gz");

    /* renamed from: BR */
    public static final CompressedContentFormat f3093BR = new CompressedContentFormat("br", ".br");
    public static final CompressedContentFormat[] NONE = new CompressedContentFormat[0];
    private final String _encoding;
    private final String _extension;
    private final String _etagSuffix;
    private final String _etagSuffixQuote;
    private final PreEncodedHttpField _contentEncoding;

    public CompressedContentFormat(String encoding, String extension) {
        this._encoding = StringUtil.asciiToLowerCase(encoding);
        this._extension = StringUtil.asciiToLowerCase(extension);
        this._etagSuffix = StringUtil.isEmpty(ETAG_SEPARATOR) ? "" : ETAG_SEPARATOR + this._encoding;
        this._etagSuffixQuote = this._etagSuffix + "\"";
        this._contentEncoding = new PreEncodedHttpField(HttpHeader.CONTENT_ENCODING, this._encoding);
    }

    public boolean equals(Object o) {
        if (!(o instanceof CompressedContentFormat)) {
            return false;
        }
        CompressedContentFormat ccf = (CompressedContentFormat) o;
        return Objects.equals(this._encoding, ccf._encoding) && Objects.equals(this._extension, ccf._extension);
    }

    public String getEncoding() {
        return this._encoding;
    }

    public String getExtension() {
        return this._extension;
    }

    public String getEtagSuffix() {
        return this._etagSuffix;
    }

    public HttpField getContentEncoding() {
        return this._contentEncoding;
    }

    public String etag(String etag) {
        if (StringUtil.isEmpty(ETAG_SEPARATOR)) {
            return etag;
        }
        int end = etag.length() - 1;
        if (etag.charAt(end) == '\"') {
            return etag.substring(0, end) + this._etagSuffixQuote;
        }
        return etag + this._etagSuffix;
    }

    public int hashCode() {
        return Objects.hash(this._encoding, this._extension);
    }

    public static boolean tagEquals(String etag, String etagWithSuffix) {
        if (etag.equals(etagWithSuffix)) {
            return true;
        }
        if (StringUtil.isEmpty(ETAG_SEPARATOR)) {
            return false;
        }
        boolean etagQuoted = etag.endsWith("\"");
        boolean etagSuffixQuoted = etagWithSuffix.endsWith("\"");
        int separator = etagWithSuffix.lastIndexOf(ETAG_SEPARATOR);
        if (etagQuoted == etagSuffixQuoted) {
            return separator > 0 && etag.regionMatches(0, etagWithSuffix, 0, separator);
        }
        if (etagWithSuffix.startsWith("W/") || etag.startsWith("W/")) {
            return false;
        }
        String etag2 = etagQuoted ? QuotedStringTokenizer.unquote(etag) : etag;
        String etagWithSuffix2 = etagSuffixQuoted ? QuotedStringTokenizer.unquote(etagWithSuffix) : etagWithSuffix;
        int separator2 = etagWithSuffix2.lastIndexOf(ETAG_SEPARATOR);
        if (separator2 > 0) {
            return etag2.regionMatches(0, etagWithSuffix2, 0, separator2);
        }
        return Objects.equals(etag2, etagWithSuffix2);
    }

    public String stripSuffixes(String etagsList) {
        if (StringUtil.isEmpty(ETAG_SEPARATOR)) {
            return etagsList;
        }
        while (true) {
            int i = etagsList.lastIndexOf(this._etagSuffix);
            if (i < 0) {
                return etagsList;
            }
            etagsList = etagsList.substring(0, i) + etagsList.substring(i + this._etagSuffix.length());
        }
    }

    public String toString() {
        return this._encoding;
    }
}
