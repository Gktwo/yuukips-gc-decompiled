package p013io.github.classgraph;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: io.github.classgraph.FieldInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/FieldInfoList.class */
public class FieldInfoList extends MappableInfoList<FieldInfo> {
    private static final long serialVersionUID = 1;
    static final FieldInfoList EMPTY_LIST = new FieldInfoList();

    @FunctionalInterface
    /* renamed from: io.github.classgraph.FieldInfoList$FieldInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/FieldInfoList$FieldInfoFilter.class */
    public interface FieldInfoFilter {
        boolean accept(FieldInfo fieldInfo);
    }

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static FieldInfoList emptyList() {
        return EMPTY_LIST;
    }

    public FieldInfoList() {
    }

    public FieldInfoList(int sizeHint) {
        super(sizeHint);
    }

    public FieldInfoList(Collection<FieldInfo> fieldInfoCollection) {
        super(fieldInfoCollection);
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((FieldInfo) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    public FieldInfoList filter(FieldInfoFilter filter) {
        FieldInfoList fieldInfoFiltered = new FieldInfoList();
        Iterator it = iterator();
        while (it.hasNext()) {
            FieldInfo resource = (FieldInfo) it.next();
            if (filter.accept(resource)) {
                fieldInfoFiltered.add(resource);
            }
        }
        return fieldInfoFiltered;
    }
}
