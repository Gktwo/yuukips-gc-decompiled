package p013io.github.classgraph;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: io.github.classgraph.AnnotationParameterValueList */
/* loaded from: grasscutter.jar:io/github/classgraph/AnnotationParameterValueList.class */
public class AnnotationParameterValueList extends MappableInfoList<AnnotationParameterValue> {
    private static final long serialVersionUID = 1;
    static final AnnotationParameterValueList EMPTY_LIST = new AnnotationParameterValueList();

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static AnnotationParameterValueList emptyList() {
        return EMPTY_LIST;
    }

    public AnnotationParameterValueList() {
    }

    public AnnotationParameterValueList(int sizeHint) {
        super(sizeHint);
    }

    public AnnotationParameterValueList(Collection<AnnotationParameterValue> annotationParameterValueCollection) {
        super(annotationParameterValueCollection);
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((AnnotationParameterValue) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    /* access modifiers changed from: package-private */
    public void convertWrapperArraysToPrimitiveArrays(ClassInfo annotationClassInfo) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((AnnotationParameterValue) it.next()).convertWrapperArraysToPrimitiveArrays(annotationClassInfo);
        }
    }

    public Object getValue(String parameterName) {
        AnnotationParameterValue apv = get(parameterName);
        if (apv == null) {
            return null;
        }
        return apv.getValue();
    }
}
