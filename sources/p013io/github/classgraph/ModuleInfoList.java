package p013io.github.classgraph;

import java.util.Collection;
import java.util.Iterator;

/* renamed from: io.github.classgraph.ModuleInfoList */
/* loaded from: grasscutter.jar:io/github/classgraph/ModuleInfoList.class */
public class ModuleInfoList extends MappableInfoList<ModuleInfo> {
    private static final long serialVersionUID = 1;

    @FunctionalInterface
    /* renamed from: io.github.classgraph.ModuleInfoList$ModuleInfoFilter */
    /* loaded from: grasscutter.jar:io/github/classgraph/ModuleInfoList$ModuleInfoFilter.class */
    public interface ModuleInfoFilter {
        boolean accept(ModuleInfo moduleInfo);
    }

    ModuleInfoList() {
    }

    ModuleInfoList(int sizeHint) {
        super(sizeHint);
    }

    /* access modifiers changed from: package-private */
    public ModuleInfoList(Collection<ModuleInfo> moduleInfoCollection) {
        super(moduleInfoCollection);
    }

    public ModuleInfoList filter(ModuleInfoFilter filter) {
        ModuleInfoList moduleInfoFiltered = new ModuleInfoList();
        Iterator it = iterator();
        while (it.hasNext()) {
            ModuleInfo resource = (ModuleInfo) it.next();
            if (filter.accept(resource)) {
                moduleInfoFiltered.add(resource);
            }
        }
        return moduleInfoFiltered;
    }
}
