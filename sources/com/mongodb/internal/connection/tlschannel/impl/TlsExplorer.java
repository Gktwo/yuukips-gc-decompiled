package com.mongodb.internal.connection.tlschannel.impl;

import java.nio.BufferUnderflowException;
import java.nio.ByteBuffer;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.SNIHostName;
import javax.net.ssl.SNIServerName;
import javax.net.ssl.SSLProtocolException;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsExplorer.class */
public final class TlsExplorer {
    public static final int RECORD_HEADER_SIZE = 5;

    private TlsExplorer() {
    }

    public static int getRequiredSize(ByteBuffer source) {
        if (source.remaining() < 5) {
            throw new BufferUnderflowException();
        }
        source.mark();
        try {
            byte firstByte = source.get();
            source.get();
            byte thirdByte = source.get();
            if ((firstByte & 128) != 0 && thirdByte == 1) {
                return 5;
            }
            int i = (((source.get() & 255) << 8) | (source.get() & 255)) + 5;
            source.reset();
            return i;
        } finally {
            source.reset();
        }
    }

    public static Map<Integer, SNIServerName> explore(ByteBuffer source) throws SSLProtocolException {
        if (source.remaining() < 5) {
            throw new BufferUnderflowException();
        }
        source.mark();
        try {
            byte firstByte = source.get();
            ignore(source, 1);
            byte thirdByte = source.get();
            if ((firstByte & 128) != 0 && thirdByte == 1) {
                HashMap hashMap = new HashMap();
                source.reset();
                return hashMap;
            } else if (firstByte == 22) {
                Map<Integer, SNIServerName> exploreTLSRecord = exploreTLSRecord(source, firstByte);
                source.reset();
                return exploreTLSRecord;
            } else {
                throw new SSLProtocolException("Not handshake record");
            }
        } catch (Throwable th) {
            source.reset();
            throw th;
        }
    }

    private static Map<Integer, SNIServerName> exploreTLSRecord(ByteBuffer input, byte firstByte) throws SSLProtocolException {
        if (firstByte != 22) {
            throw new SSLProtocolException("Not handshake record");
        }
        int recordLength = getInt16(input);
        if (recordLength <= input.remaining()) {
            return exploreHandshake(input, recordLength);
        }
        throw new BufferUnderflowException();
    }

    private static Map<Integer, SNIServerName> exploreHandshake(ByteBuffer input, int recordLength) throws SSLProtocolException {
        if (input.get() != 1) {
            throw new SSLProtocolException("Not initial handshaking");
        }
        int handshakeLength = getInt24(input);
        if (handshakeLength > recordLength - 4) {
            throw new SSLProtocolException("Handshake message spans multiple records");
        }
        input.limit(handshakeLength + input.position());
        return exploreClientHello(input);
    }

    private static Map<Integer, SNIServerName> exploreClientHello(ByteBuffer input) throws SSLProtocolException {
        ignore(input, 2);
        ignore(input, 32);
        ignoreByteVector8(input);
        ignoreByteVector16(input);
        ignoreByteVector8(input);
        return input.remaining() > 0 ? exploreExtensions(input) : new HashMap();
    }

    private static Map<Integer, SNIServerName> exploreExtensions(ByteBuffer input) throws SSLProtocolException {
        int length = getInt16(input);
        while (length > 0) {
            int extType = getInt16(input);
            int extLen = getInt16(input);
            if (extType == 0) {
                return exploreSNIExt(input, extLen);
            }
            ignore(input, extLen);
            length -= extLen + 4;
        }
        return new HashMap();
    }

    private static Map<Integer, SNIServerName> exploreSNIExt(ByteBuffer input, int extLen) throws SSLProtocolException {
        SNIServerName serverName;
        Map<Integer, SNIServerName> sniMap = new HashMap<>();
        int remains = extLen;
        if (extLen >= 2) {
            int listLen = getInt16(input);
            if (listLen == 0 || listLen + 2 != extLen) {
                throw new SSLProtocolException("Invalid server name indication extension");
            }
            remains -= 2;
            while (remains > 0) {
                int code = getInt8(input);
                int snLen = getInt16(input);
                if (snLen > remains) {
                    throw new SSLProtocolException("Not enough data to fill declared vector size");
                }
                byte[] encoded = new byte[snLen];
                input.get(encoded);
                switch (code) {
                    case 0:
                        if (encoded.length != 0) {
                            serverName = new SNIHostName(encoded);
                            break;
                        } else {
                            throw new SSLProtocolException("Empty HostName in server name indication");
                        }
                    default:
                        serverName = new UnknownServerName(code, encoded);
                        break;
                }
                if (sniMap.put(Integer.valueOf(serverName.getType()), serverName) != null) {
                    throw new SSLProtocolException("Duplicated server name of type " + serverName.getType());
                }
                remains -= encoded.length + 3;
            }
        } else if (extLen == 0) {
            throw new SSLProtocolException("Not server name indication extension in client");
        }
        if (remains == 0) {
            return sniMap;
        }
        throw new SSLProtocolException("Invalid server name indication extension");
    }

    private static int getInt8(ByteBuffer input) {
        return input.get();
    }

    private static int getInt16(ByteBuffer input) {
        return ((input.get() & 255) << 8) | (input.get() & 255);
    }

    private static int getInt24(ByteBuffer input) {
        return ((input.get() & 255) << 16) | ((input.get() & 255) << 8) | (input.get() & 255);
    }

    private static void ignoreByteVector8(ByteBuffer input) {
        ignore(input, getInt8(input));
    }

    private static void ignoreByteVector16(ByteBuffer input) {
        ignore(input, getInt16(input));
    }

    private static void ignore(ByteBuffer input, int length) {
        if (length != 0) {
            input.position(input.position() + length);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:com/mongodb/internal/connection/tlschannel/impl/TlsExplorer$UnknownServerName.class */
    public static class UnknownServerName extends SNIServerName {
        UnknownServerName(int code, byte[] encoded) {
            super(code, encoded);
        }
    }
}
