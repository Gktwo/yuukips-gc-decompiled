package p001ch.qos.logback.core.rolling.helper;

import p001ch.qos.logback.core.pattern.DynamicConverter;
import p001ch.qos.logback.core.pattern.FormatInfo;

/* renamed from: ch.qos.logback.core.rolling.helper.IntegerTokenConverter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/IntegerTokenConverter.class */
public class IntegerTokenConverter extends DynamicConverter<Object> implements MonoTypedConverter {
    public static final String CONVERTER_KEY = "i";

    public String convert(int i) {
        String s = Integer.toString(i);
        FormatInfo formattingInfo = getFormattingInfo();
        if (formattingInfo == null) {
            return s;
        }
        int min = formattingInfo.getMin();
        StringBuilder sbuf = new StringBuilder();
        for (int j = s.length(); j < min; j++) {
            sbuf.append('0');
        }
        return sbuf.append(s).toString();
    }

    @Override // p001ch.qos.logback.core.pattern.Converter
    public String convert(Object o) {
        if (o == null) {
            throw new IllegalArgumentException("Null argument forbidden");
        } else if (o instanceof Integer) {
            return convert(((Integer) o).intValue());
        } else {
            throw new IllegalArgumentException("Cannot convert " + o + " of type" + o.getClass().getName());
        }
    }

    @Override // p001ch.qos.logback.core.rolling.helper.MonoTypedConverter
    public boolean isApplicable(Object o) {
        return o instanceof Integer;
    }
}
