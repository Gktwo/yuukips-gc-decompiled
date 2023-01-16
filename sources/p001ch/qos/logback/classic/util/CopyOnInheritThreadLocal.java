package p001ch.qos.logback.classic.util;

import java.util.HashMap;

/* renamed from: ch.qos.logback.classic.util.CopyOnInheritThreadLocal */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/CopyOnInheritThreadLocal.class */
public class CopyOnInheritThreadLocal extends InheritableThreadLocal<HashMap<String, String>> {
    /* access modifiers changed from: protected */
    public HashMap<String, String> childValue(HashMap<String, String> parentValue) {
        if (parentValue == null) {
            return null;
        }
        return new HashMap<>(parentValue);
    }
}
