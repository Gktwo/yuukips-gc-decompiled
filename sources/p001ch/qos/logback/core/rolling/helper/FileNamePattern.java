package p001ch.qos.logback.core.rolling.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.pattern.Converter;
import p001ch.qos.logback.core.pattern.ConverterUtil;
import p001ch.qos.logback.core.pattern.LiteralConverter;
import p001ch.qos.logback.core.pattern.parser.Parser;
import p001ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.ScanException;

/* renamed from: ch.qos.logback.core.rolling.helper.FileNamePattern */
/* loaded from: grasscutter.jar:ch/qos/logback/core/rolling/helper/FileNamePattern.class */
public class FileNamePattern extends ContextAwareBase {
    static final Map<String, String> CONVERTER_MAP = new HashMap();
    String pattern;
    Converter<Object> headTokenConverter;

    static {
        CONVERTER_MAP.put(IntegerTokenConverter.CONVERTER_KEY, IntegerTokenConverter.class.getName());
        CONVERTER_MAP.put(DateTokenConverter.CONVERTER_KEY, DateTokenConverter.class.getName());
    }

    public FileNamePattern(String patternArg, Context contextArg) {
        setPattern(FileFilterUtil.slashify(patternArg));
        setContext(contextArg);
        parse();
        ConverterUtil.startConverters(this.headTokenConverter);
    }

    void parse() {
        try {
            Parser<Object> p = new Parser<>(escapeRightParantesis(this.pattern), new AlmostAsIsEscapeUtil());
            p.setContext(this.context);
            this.headTokenConverter = p.compile(p.parse(), CONVERTER_MAP);
        } catch (ScanException sce) {
            addError("Failed to parse pattern \"" + this.pattern + "\".", sce);
        }
    }

    String escapeRightParantesis(String in) {
        return this.pattern.replace(")", "\\)");
    }

    public String toString() {
        return this.pattern;
    }

    public int hashCode() {
        return (31 * 1) + (this.pattern == null ? 0 : this.pattern.hashCode());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        FileNamePattern other = (FileNamePattern) obj;
        if (this.pattern == null) {
            if (other.pattern != null) {
                return false;
            }
            return true;
        } else if (!this.pattern.equals(other.pattern)) {
            return false;
        } else {
            return true;
        }
    }

    public DateTokenConverter<Object> getPrimaryDateTokenConverter() {
        for (Converter<Object> p = this.headTokenConverter; p != null; p = p.getNext()) {
            if (p instanceof DateTokenConverter) {
                DateTokenConverter<Object> dtc = (DateTokenConverter) p;
                if (dtc.isPrimary()) {
                    return dtc;
                }
            }
        }
        return null;
    }

    public IntegerTokenConverter getIntegerTokenConverter() {
        for (Converter<Object> p = this.headTokenConverter; p != null; p = p.getNext()) {
            if (p instanceof IntegerTokenConverter) {
                return (IntegerTokenConverter) p;
            }
        }
        return null;
    }

    public boolean hasIntegerTokenCOnverter() {
        return getIntegerTokenConverter() != null;
    }

    public String convertMultipleArguments(Object... objectList) {
        StringBuilder buf = new StringBuilder();
        for (Converter<Object> c = this.headTokenConverter; c != null; c = c.getNext()) {
            if (c instanceof MonoTypedConverter) {
                MonoTypedConverter monoTyped = (MonoTypedConverter) c;
                for (Object o : objectList) {
                    if (monoTyped.isApplicable(o)) {
                        buf.append(c.convert(o));
                    }
                }
            } else {
                buf.append(c.convert(objectList));
            }
        }
        return buf.toString();
    }

    public String convert(Object o) {
        StringBuilder buf = new StringBuilder();
        for (Converter<Object> p = this.headTokenConverter; p != null; p = p.getNext()) {
            buf.append(p.convert(o));
        }
        return buf.toString();
    }

    public String convertInt(int i) {
        return convert(Integer.valueOf(i));
    }

    public void setPattern(String pattern) {
        if (pattern != null) {
            this.pattern = pattern.trim();
        }
    }

    public String getPattern() {
        return this.pattern;
    }

    public String toRegexForFixedDate(Date date) {
        StringBuilder buf = new StringBuilder();
        for (Converter<Object> p = this.headTokenConverter; p != null; p = p.getNext()) {
            if (p instanceof LiteralConverter) {
                buf.append(p.convert(null));
            } else if (p instanceof IntegerTokenConverter) {
                buf.append("(\\d{1,5})");
            } else if (p instanceof DateTokenConverter) {
                buf.append(p.convert(date));
            }
        }
        return buf.toString();
    }

    public String toRegex() {
        StringBuilder buf = new StringBuilder();
        for (Converter<Object> p = this.headTokenConverter; p != null; p = p.getNext()) {
            if (p instanceof LiteralConverter) {
                buf.append(p.convert(null));
            } else if (p instanceof IntegerTokenConverter) {
                buf.append("\\d{1,2}");
            } else if (p instanceof DateTokenConverter) {
                buf.append(((DateTokenConverter) p).toRegex());
            }
        }
        return buf.toString();
    }
}
