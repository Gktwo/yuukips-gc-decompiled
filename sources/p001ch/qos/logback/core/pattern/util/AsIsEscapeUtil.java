package p001ch.qos.logback.core.pattern.util;

/* renamed from: ch.qos.logback.core.pattern.util.AsIsEscapeUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/util/AsIsEscapeUtil.class */
public class AsIsEscapeUtil implements IEscapeUtil {
    @Override // p001ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String escapeChars, StringBuffer buf, char next, int pointer) {
        buf.append("\\");
        buf.append(next);
    }
}
