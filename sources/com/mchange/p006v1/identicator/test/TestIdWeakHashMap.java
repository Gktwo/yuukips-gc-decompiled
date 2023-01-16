package com.mchange.p006v1.identicator.test;

import com.mchange.p006v1.identicator.IdWeakHashMap;
import com.mchange.p006v1.identicator.Identicator;
import java.util.Iterator;
import java.util.Map;
import p001ch.qos.logback.classic.net.SyslogAppender;

/* renamed from: com.mchange.v1.identicator.test.TestIdWeakHashMap */
/* loaded from: grasscutter.jar:com/mchange/v1/identicator/test/TestIdWeakHashMap.class */
public class TestIdWeakHashMap {

    /* renamed from: id */
    static final Identicator f384id = new Identicator() { // from class: com.mchange.v1.identicator.test.TestIdWeakHashMap.1
        @Override // com.mchange.p006v1.identicator.Identicator
        public boolean identical(Object obj, Object obj2) {
            return ((String) obj).charAt(0) == ((String) obj2).charAt(0);
        }

        @Override // com.mchange.p006v1.identicator.Identicator
        public int hash(Object obj) {
            return ((String) obj).charAt(0);
        }
    };
    static final Map weak = new IdWeakHashMap(f384id);

    public static void main(String[] strArr) {
        doAdds();
        System.gc();
        show();
        setRemoveHi();
        System.gc();
        show();
    }

    static void setRemoveHi() {
        weak.put(new String("bye"), "");
        weak.keySet().remove("hi");
        show();
    }

    static void doAdds() {
        String str = new String("hello");
        String str2 = new String("yoohoo");
        String str3 = new String("poop");
        weak.put("hi", "");
        weak.put(str, "");
        weak.put(str2, "");
        weak.put(str3, "");
        show();
    }

    static void show() {
        System.out.println("elements:");
        Iterator it = weak.keySet().iterator();
        while (it.hasNext()) {
            System.out.println(SyslogAppender.DEFAULT_STACKTRACE_PATTERN + it.next());
        }
        System.out.println("size: " + weak.size());
    }
}
