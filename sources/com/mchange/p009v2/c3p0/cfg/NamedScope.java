package com.mchange.p009v2.c3p0.cfg;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* access modifiers changed from: package-private */
/* renamed from: com.mchange.v2.c3p0.cfg.NamedScope */
/* loaded from: grasscutter.jar:com/mchange/v2/c3p0/cfg/NamedScope.class */
public class NamedScope {
    HashMap props;
    HashMap userNamesToOverrides;
    HashMap extensions;

    /* access modifiers changed from: package-private */
    public NamedScope() {
        this.props = new HashMap();
        this.userNamesToOverrides = new HashMap();
        this.extensions = new HashMap();
    }

    /* access modifiers changed from: package-private */
    public NamedScope(HashMap props, HashMap userNamesToOverrides, HashMap extensions) {
        this.props = props;
        this.userNamesToOverrides = userNamesToOverrides;
        this.extensions = extensions;
    }

    /* access modifiers changed from: package-private */
    public NamedScope mergedOver(NamedScope underScope) {
        HashMap mergedProps = (HashMap) underScope.props.clone();
        mergedProps.putAll(this.props);
        return new NamedScope(mergedProps, mergeUserNamesToOverrides(this.userNamesToOverrides, underScope.userNamesToOverrides), mergeExtensions(this.extensions, underScope.extensions));
    }

    /* access modifiers changed from: package-private */
    public static HashMap mergeExtensions(HashMap over, HashMap under) {
        HashMap out = (HashMap) under.clone();
        out.putAll(over);
        return out;
    }

    /* access modifiers changed from: package-private */
    public static HashMap mergeUserNamesToOverrides(HashMap over, HashMap under) {
        HashMap out = (HashMap) under.clone();
        HashSet underUserNames = new HashSet(under.keySet());
        HashSet overUserNames = new HashSet(over.keySet());
        HashSet newUserNames = (HashSet) overUserNames.clone();
        newUserNames.removeAll(underUserNames);
        Iterator ii = newUserNames.iterator();
        while (ii.hasNext()) {
            String name = (String) ii.next();
            out.put(name, ((HashMap) over.get(name)).clone());
        }
        HashSet mergeUserNames = (HashSet) overUserNames.clone();
        mergeUserNames.retainAll(underUserNames);
        Iterator ii2 = mergeUserNames.iterator();
        while (ii2.hasNext()) {
            String name2 = (String) ii2.next();
            ((HashMap) out.get(name2)).putAll((HashMap) over.get(name2));
        }
        return out;
    }
}
