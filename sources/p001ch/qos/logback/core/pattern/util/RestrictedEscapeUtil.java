package p001ch.qos.logback.core.pattern.util;

/* renamed from: ch.qos.logback.core.pattern.util.RestrictedEscapeUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/util/RestrictedEscapeUtil.class */
public class RestrictedEscapeUtil implements IEscapeUtil {
    @Override // p001ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String escapeChars, StringBuffer buf, char next, int pointer) {
        if (escapeChars.indexOf(next) >= 0) {
            buf.append(next);
            return;
        }
        buf.append("\\");
        buf.append(next);
    }
}
