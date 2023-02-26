package org.eclipse.jetty.http;

import dev.morphia.mapping.Mapper;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import org.eclipse.jetty.util.BufferUtil;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.log.Logger;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/MimeTypes.class */
public class MimeTypes {
    private static final Logger LOG;
    private static final Trie<ByteBuffer> TYPES;
    private static final Map<String, String> __dftMimeMap;
    private static final Map<String, String> __inferredEncodings;
    private static final Map<String, String> __assumedEncodings;
    public static final Trie<Type> CACHE;
    private final Map<String, String> _mimeMap = new HashMap();

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:26:0x0171
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    static {
        /*
        // Method dump skipped, instructions count: 763
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.MimeTypes.m9570clinit():void");
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/http/MimeTypes$Type.class */
    public enum Type {
        FORM_ENCODED("application/x-www-form-urlencoded"),
        MESSAGE_HTTP("message/http"),
        MULTIPART_BYTERANGES("multipart/byteranges"),
        MULTIPART_FORM_DATA(ContentType.FORM_DATA),
        TEXT_HTML(ContentType.HTML),
        TEXT_PLAIN(ContentType.PLAIN),
        TEXT_XML(ContentType.XML),
        TEXT_JSON("text/json", StandardCharsets.UTF_8),
        APPLICATION_JSON(ContentType.JSON, StandardCharsets.UTF_8),
        TEXT_HTML_8859_1("text/html;charset=iso-8859-1", TEXT_HTML),
        TEXT_HTML_UTF_8("text/html;charset=utf-8", TEXT_HTML),
        TEXT_PLAIN_8859_1("text/plain;charset=iso-8859-1", TEXT_PLAIN),
        TEXT_PLAIN_UTF_8("text/plain;charset=utf-8", TEXT_PLAIN),
        TEXT_XML_8859_1("text/xml;charset=iso-8859-1", TEXT_XML),
        TEXT_XML_UTF_8("text/xml;charset=utf-8", TEXT_XML),
        TEXT_JSON_8859_1("text/json;charset=iso-8859-1", TEXT_JSON),
        TEXT_JSON_UTF_8("text/json;charset=utf-8", TEXT_JSON),
        APPLICATION_JSON_8859_1("application/json;charset=iso-8859-1", APPLICATION_JSON),
        APPLICATION_JSON_UTF_8("application/json;charset=utf-8", APPLICATION_JSON);
        
        private final String _string;
        private final Type _base;
        private final ByteBuffer _buffer;
        private final Charset _charset;
        private final String _charsetString;
        private final boolean _assumedCharset;
        private final HttpField _field;

        Type(String s) {
            this._string = s;
            this._buffer = BufferUtil.toBuffer(s);
            this._base = this;
            this._charset = null;
            this._charsetString = null;
            this._assumedCharset = false;
            this._field = new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, this._string);
        }

        Type(String s, Type base) {
            this._string = s;
            this._buffer = BufferUtil.toBuffer(s);
            this._base = base;
            this._charset = Charset.forName(s.substring(s.indexOf(";charset=") + 9));
            this._charsetString = this._charset.toString().toLowerCase(Locale.ENGLISH);
            this._assumedCharset = false;
            this._field = new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, this._string);
        }

        Type(String s, Charset cs) {
            this._string = s;
            this._base = this;
            this._buffer = BufferUtil.toBuffer(s);
            this._charset = cs;
            this._charsetString = this._charset == null ? null : this._charset.toString().toLowerCase(Locale.ENGLISH);
            this._assumedCharset = true;
            this._field = new PreEncodedHttpField(HttpHeader.CONTENT_TYPE, this._string);
        }

        public ByteBuffer asBuffer() {
            return this._buffer.asReadOnlyBuffer();
        }

        public Charset getCharset() {
            return this._charset;
        }

        public String getCharsetString() {
            return this._charsetString;
        }

        /* renamed from: is */
        public boolean m37is(String s) {
            return this._string.equalsIgnoreCase(s);
        }

        public String asString() {
            return this._string;
        }

        @Override // java.lang.Enum, java.lang.Object
        public String toString() {
            return this._string;
        }

        public boolean isCharsetAssumed() {
            return this._assumedCharset;
        }

        public HttpField getContentTypeField() {
            return this._field;
        }

        public Type getBaseType() {
            return this._base;
        }
    }

    public synchronized Map<String, String> getMimeMap() {
        return this._mimeMap;
    }

    public void setMimeMap(Map<String, String> mimeMap) {
        this._mimeMap.clear();
        if (mimeMap != null) {
            for (Map.Entry<String, String> ext : mimeMap.entrySet()) {
                this._mimeMap.put(StringUtil.asciiToLowerCase(ext.getKey()), normalizeMimeType(ext.getValue()));
            }
        }
    }

    public static String getDefaultMimeByExtension(String filename) {
        String type = null;
        if (filename != null) {
            int i = -1;
            while (type == null) {
                i = filename.indexOf(Mapper.IGNORED_FIELDNAME, i + 1);
                if (i < 0 || i >= filename.length()) {
                    break;
                }
                String ext = StringUtil.asciiToLowerCase(filename.substring(i + 1));
                if (type == null) {
                    type = __dftMimeMap.get(ext);
                }
            }
        }
        if (type == null) {
            type = __dftMimeMap.get("*");
        }
        return type;
    }

    public String getMimeByExtension(String filename) {
        String type = null;
        if (filename != null) {
            int i = -1;
            while (type == null) {
                i = filename.indexOf(Mapper.IGNORED_FIELDNAME, i + 1);
                if (i < 0 || i >= filename.length()) {
                    break;
                }
                String ext = StringUtil.asciiToLowerCase(filename.substring(i + 1));
                if (this._mimeMap != null) {
                    type = this._mimeMap.get(ext);
                }
                if (type == null) {
                    type = __dftMimeMap.get(ext);
                }
            }
        }
        if (type == null) {
            if (this._mimeMap != null) {
                type = this._mimeMap.get("*");
            }
            if (type == null) {
                type = __dftMimeMap.get("*");
            }
        }
        return type;
    }

    public void addMimeMapping(String extension, String type) {
        this._mimeMap.put(StringUtil.asciiToLowerCase(extension), normalizeMimeType(type));
    }

    public static Set<String> getKnownMimeTypes() {
        return new HashSet(__dftMimeMap.values());
    }

    private static String normalizeMimeType(String type) {
        Type t = CACHE.get(type);
        if (t != null) {
            return t.asString();
        }
        return StringUtil.asciiToLowerCase(type);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:92:0x0180, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getCharsetFromContentType(java.lang.String r5) {
        /*
        // Method dump skipped, instructions count: 408
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.http.MimeTypes.getCharsetFromContentType(java.lang.String):java.lang.String");
    }

    public static Map<String, String> getInferredEncodings() {
        return __inferredEncodings;
    }

    public static Map<String, String> getAssumedEncodings() {
        return __assumedEncodings;
    }

    @Deprecated
    public static String inferCharsetFromContentType(String contentType) {
        return getCharsetAssumedFromContentType(contentType);
    }

    public static String getCharsetInferredFromContentType(String contentType) {
        return __inferredEncodings.get(contentType);
    }

    public static String getCharsetAssumedFromContentType(String contentType) {
        return __assumedEncodings.get(contentType);
    }

    public static String getContentTypeWithoutCharset(String value) {
        int end = value.length();
        int state = 0;
        int start = 0;
        boolean quote = false;
        StringBuilder builder = null;
        for (int i = 0; i < end; i++) {
            char b = value.charAt(i);
            if ('\"' == b) {
                quote = !quote;
                switch (state) {
                    case 9:
                        builder = new StringBuilder();
                        builder.append((CharSequence) value, 0, start + 1);
                        state = 10;
                        continue;
                    case 10:
                        break;
                    case 11:
                        builder.append(b);
                        continue;
                    default:
                        start = i;
                        state = 0;
                        continue;
                }
            } else if (!quote) {
                switch (state) {
                    case 0:
                        if (';' != b) {
                            if (' ' != b) {
                                start = i;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            state = 1;
                            continue;
                        }
                    case 1:
                        if ('c' != b) {
                            if (' ' != b) {
                                state = 0;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            state = 2;
                            continue;
                        }
                    case 2:
                        if ('h' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 3;
                            continue;
                        }
                    case 3:
                        if ('a' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 4;
                            continue;
                        }
                    case 4:
                        if ('r' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 5;
                            continue;
                        }
                    case 5:
                        if ('s' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 6;
                            continue;
                        }
                    case 6:
                        if ('e' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 7;
                            continue;
                        }
                    case 7:
                        if ('t' != b) {
                            state = 0;
                            break;
                        } else {
                            state = 8;
                            continue;
                        }
                    case 8:
                        if ('=' != b) {
                            if (' ' != b) {
                                state = 0;
                                break;
                            } else {
                                break;
                            }
                        } else {
                            state = 9;
                            continue;
                        }
                    case 9:
                        if (' ' == b) {
                            break;
                        } else {
                            builder = new StringBuilder();
                            builder.append((CharSequence) value, 0, start + 1);
                            state = 10;
                            continue;
                        }
                    case 10:
                        if (';' == b) {
                            builder.append(b);
                            state = 11;
                            break;
                        } else {
                            continue;
                        }
                    case 11:
                        if (' ' == b) {
                            break;
                        } else {
                            builder.append(b);
                            continue;
                        }
                }
            } else if (!(builder == null || state == 10)) {
                builder.append(b);
            }
        }
        if (builder == null) {
            return value;
        }
        return builder.toString();
    }
}
