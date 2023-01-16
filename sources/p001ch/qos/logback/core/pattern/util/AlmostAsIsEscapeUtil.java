package p001ch.qos.logback.core.pattern.util;

/* renamed from: ch.qos.logback.core.pattern.util.AlmostAsIsEscapeUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/pattern/util/AlmostAsIsEscapeUtil.class */
public class AlmostAsIsEscapeUtil extends RestrictedEscapeUtil {
    @Override // p001ch.qos.logback.core.pattern.util.RestrictedEscapeUtil, p001ch.qos.logback.core.pattern.util.IEscapeUtil
    public void escape(String escapeChars, StringBuffer buf, char next, int pointer) {
        escape("%)", buf, next, pointer);
    }
}
