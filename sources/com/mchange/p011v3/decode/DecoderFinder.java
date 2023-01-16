package com.mchange.p011v3.decode;

/* renamed from: com.mchange.v3.decode.DecoderFinder */
/* loaded from: grasscutter.jar:com/mchange/v3/decode/DecoderFinder.class */
public interface DecoderFinder {
    String decoderClassName(Object obj) throws CannotDecodeException;
}
