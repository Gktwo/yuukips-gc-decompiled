package org.eclipse.jetty.webapp;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Consumer;
import org.eclipse.jetty.util.TopologicalSort;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/RelativeOrdering.class */
public class RelativeOrdering implements Ordering {
    protected MetaData _metaData;

    public RelativeOrdering(MetaData metaData) {
        this._metaData = metaData;
    }

    @Override // org.eclipse.jetty.webapp.Ordering
    public List<Resource> order(List<Resource> jars) {
        TopologicalSort<Resource> sort = new TopologicalSort<>();
        List<Resource> sorted = new ArrayList<>(jars);
        Set<Resource> others = new HashSet<>();
        Set<Resource> beforeOthers = new HashSet<>();
        Set<Resource> afterOthers = new HashSet<>();
        for (Resource jar : jars) {
            if (this._metaData.getFragment(jar) == null) {
                others.add(jar);
            } else {
                switch (fragment.getOtherType()) {
                    case None:
                        others.add(jar);
                        continue;
                    case Before:
                        beforeOthers.add(jar);
                        continue;
                    case After:
                        afterOthers.add(jar);
                        continue;
                }
            }
        }
        Set<Resource> referenced = new HashSet<>();
        for (Resource jar2 : jars) {
            FragmentDescriptor fragment = this._metaData.getFragment(jar2);
            if (fragment != null) {
                for (String name : fragment.getAfters()) {
                    Resource after = this._metaData.getJarForFragment(name);
                    sort.addDependency(jar2, after);
                    referenced.add(after);
                }
                for (String name2 : fragment.getBefores()) {
                    Resource before = this._metaData.getJarForFragment(name2);
                    sort.addDependency(before, jar2);
                    referenced.add(before);
                }
                switch (fragment.getOtherType()) {
                    case Before:
                        Consumer<Resource> addBefore = other -> {
                            if (!referenced.contains(other)) {
                                sort.addDependency(other, jar2);
                            }
                        };
                        others.forEach(addBefore);
                        afterOthers.forEach(addBefore);
                        continue;
                    case After:
                        Consumer<Resource> addAfter = other -> {
                            if (!referenced.contains(other)) {
                                sort.addDependency(jar2, other);
                            }
                        };
                        beforeOthers.forEach(addAfter);
                        others.forEach(addAfter);
                        continue;
                }
            }
            referenced.clear();
        }
        sort.sort(sorted);
        return sorted;
    }
}
