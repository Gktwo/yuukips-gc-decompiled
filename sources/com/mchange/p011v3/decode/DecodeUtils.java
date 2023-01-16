package com.mchange.p011v3.decode;

import com.mchange.p009v2.log.MLevel;
import com.mchange.p009v2.log.MLog;
import com.mchange.p009v2.log.MLogger;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/* renamed from: com.mchange.v3.decode.DecodeUtils */
/* loaded from: grasscutter.jar:com/mchange/v3/decode/DecodeUtils.class */
public final class DecodeUtils {
    private static final List<DecoderFinder> finders;
    public static final String DECODER_CLASS_DOT_KEY = ".decoderClass";
    private static final Object[] DECODER_CLASS_DOT_KEY_OBJ_ARRAY = {DECODER_CLASS_DOT_KEY};
    public static final String DECODER_CLASS_NO_DOT_KEY = "decoderClass";
    private static final Object[] DECODER_CLASS_NO_DOT_KEY_OBJ_ARRAY = {DECODER_CLASS_NO_DOT_KEY};
    private static final MLogger logger = MLog.getLogger(DecodeUtils.class);
    private static final String[] finderClassNames = {"com.mchange.sc.v1.decode.ScalaMapDecoderFinder"};

    static {
        LinkedList linkedList = new LinkedList();
        linkedList.add(new JavaMapDecoderFinder());
        int length = finderClassNames.length;
        for (int i = 0; i < length; i++) {
            try {
                linkedList.add((DecoderFinder) Class.forName(finderClassNames[i]).newInstance());
            } catch (Exception e) {
                if (logger.isLoggable(MLevel.INFO)) {
                    logger.log(MLevel.INFO, "Could not load DecoderFinder '" + finderClassNames[i] + "'", (Throwable) e);
                }
            }
        }
        finders = Collections.unmodifiableList(linkedList);
    }

    /* renamed from: com.mchange.v3.decode.DecodeUtils$JavaMapDecoderFinder */
    /* loaded from: grasscutter.jar:com/mchange/v3/decode/DecodeUtils$JavaMapDecoderFinder.class */
    static class JavaMapDecoderFinder implements DecoderFinder {
        JavaMapDecoderFinder() {
        }

        @Override // com.mchange.p011v3.decode.DecoderFinder
        public String decoderClassName(Object obj) throws CannotDecodeException {
            if (!(obj instanceof Map)) {
                return null;
            }
            Map map = (Map) obj;
            String str = (String) map.get(DecodeUtils.DECODER_CLASS_DOT_KEY);
            if (str == null) {
                str = (String) map.get(DecodeUtils.DECODER_CLASS_NO_DOT_KEY);
            }
            if (str != null) {
                return str;
            }
            throw new CannotDecodeException("Could not find the decoder class for java.util.Map: " + obj);
        }
    }

    static final String findDecoderClassName(Object obj) throws CannotDecodeException {
        for (DecoderFinder decoderFinder : finders) {
            String decoderClassName = decoderFinder.decoderClassName(obj);
            if (decoderClassName != null) {
                return decoderClassName;
            }
        }
        throw new CannotDecodeException("Could not find a decoder class name for object: " + obj);
    }

    public static Object decode(String str, Object obj) throws CannotDecodeException {
        try {
            return ((Decoder) Class.forName(str).newInstance()).decode(obj);
        } catch (Exception e) {
            throw new CannotDecodeException("An exception occurred while attempting to decode " + obj, e);
        }
    }

    public static Object decode(Object obj) throws CannotDecodeException {
        return decode(findDecoderClassName(obj), obj);
    }

    private DecodeUtils() {
    }
}
