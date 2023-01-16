package p013io.github.classgraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import p013io.github.classgraph.HasName;

/* renamed from: io.github.classgraph.MappableInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/MappableInfoList.class */
public class MappableInfoList<T extends HasName> extends InfoList<T> {
    private static final long serialVersionUID = 1;

    /* access modifiers changed from: package-private */
    public MappableInfoList() {
    }

    /* access modifiers changed from: package-private */
    public MappableInfoList(int sizeHint) {
        super(sizeHint);
    }

    /* access modifiers changed from: package-private */
    public MappableInfoList(Collection<T> infoCollection) {
        super(infoCollection);
    }

    public Map<String, T> asMap() {
        HashMap hashMap = new HashMap();
        Iterator it = iterator();
        while (it.hasNext()) {
            HasName hasName = (HasName) it.next();
            if (hasName != null) {
                hashMap.put(hasName.getName(), hasName);
            }
        }
        return hashMap;
    }

    public boolean containsName(String name) {
        Iterator it = iterator();
        while (it.hasNext()) {
            HasName hasName = (HasName) it.next();
            if (hasName != null && hasName.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public T get(String name) {
        Iterator it = iterator();
        while (it.hasNext()) {
            T i = (T) ((HasName) it.next());
            if (i != null && i.getName().equals(name)) {
                return i;
            }
        }
        return null;
    }
}
