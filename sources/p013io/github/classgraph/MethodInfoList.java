package p013io.github.classgraph;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* renamed from: io.github.classgraph.MethodInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/MethodInfoList.class */
public class MethodInfoList extends InfoList<MethodInfo> {
    private static final long serialVersionUID = 1;
    static final MethodInfoList EMPTY_LIST = new MethodInfoList();

    @FunctionalInterface
    /* renamed from: io.github.classgraph.MethodInfoList$MethodInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/MethodInfoList$MethodInfoFilter.class */
    public interface MethodInfoFilter {
        boolean accept(MethodInfo methodInfo);
    }

    static {
        EMPTY_LIST.makeUnmodifiable();
    }

    public static MethodInfoList emptyList() {
        return EMPTY_LIST;
    }

    public MethodInfoList() {
    }

    public MethodInfoList(int sizeHint) {
        super(sizeHint);
    }

    public MethodInfoList(Collection<MethodInfo> methodInfoCollection) {
        super(methodInfoCollection);
    }

    /* access modifiers changed from: protected */
    public void findReferencedClassInfo(Map<String, ClassInfo> classNameToClassInfo, Set<ClassInfo> refdClassInfo) {
        Iterator it = iterator();
        while (it.hasNext()) {
            ((MethodInfo) it.next()).findReferencedClassInfo(classNameToClassInfo, refdClassInfo);
        }
    }

    public Map<String, MethodInfoList> asMap() {
        Map<String, MethodInfoList> methodNameToMethodInfoList = new HashMap<>();
        Iterator it = iterator();
        while (it.hasNext()) {
            MethodInfo methodInfo = (MethodInfo) it.next();
            String name = methodInfo.getName();
            MethodInfoList methodInfoList = methodNameToMethodInfoList.get(name);
            if (methodInfoList == null) {
                methodInfoList = new MethodInfoList(1);
                methodNameToMethodInfoList.put(name, methodInfoList);
            }
            methodInfoList.add(methodInfo);
        }
        return methodNameToMethodInfoList;
    }

    public boolean containsName(String methodName) {
        Iterator it = iterator();
        while (it.hasNext()) {
            if (((MethodInfo) it.next()).getName().equals(methodName)) {
                return true;
            }
        }
        return false;
    }

    public MethodInfoList get(String methodName) {
        boolean hasMethodWithName = false;
        Iterator it = iterator();
        while (true) {
            if (it.hasNext()) {
                if (((MethodInfo) it.next()).getName().equals(methodName)) {
                    hasMethodWithName = true;
                    break;
                }
            } else {
                break;
            }
        }
        if (!hasMethodWithName) {
            return EMPTY_LIST;
        }
        MethodInfoList matchingMethods = new MethodInfoList(2);
        Iterator it2 = iterator();
        while (it2.hasNext()) {
            MethodInfo mi = (MethodInfo) it2.next();
            if (mi.getName().equals(methodName)) {
                matchingMethods.add(mi);
            }
        }
        return matchingMethods;
    }

    public MethodInfo getSingleMethod(String methodName) {
        int numMethodsWithName = 0;
        MethodInfo lastFoundMethod = null;
        Iterator it = iterator();
        while (it.hasNext()) {
            MethodInfo mi = (MethodInfo) it.next();
            if (mi.getName().equals(methodName)) {
                numMethodsWithName++;
                lastFoundMethod = mi;
            }
        }
        if (numMethodsWithName == 0) {
            return null;
        }
        if (numMethodsWithName == 1) {
            return lastFoundMethod;
        }
        throw new IllegalArgumentException("There are multiple methods named \"" + methodName + "\" in class " + ((MethodInfo) iterator().next()).getName());
    }

    public MethodInfoList filter(MethodInfoFilter filter) {
        MethodInfoList methodInfoFiltered = new MethodInfoList();
        Iterator it = iterator();
        while (it.hasNext()) {
            MethodInfo resource = (MethodInfo) it.next();
            if (filter.accept(resource)) {
                methodInfoFiltered.add(resource);
            }
        }
        return methodInfoFiltered;
    }
}
