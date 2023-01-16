package org.eclipse.jetty.webapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/AbsoluteOrdering.class */
public class AbsoluteOrdering implements Ordering {
    public static final String OTHER = "@@-OTHER-@@";
    protected List<String> _order = new ArrayList();
    protected boolean _hasOther = false;
    protected MetaData _metaData;

    public AbsoluteOrdering(MetaData metaData) {
        this._metaData = metaData;
    }

    @Override // org.eclipse.jetty.webapp.Ordering
    public List<Resource> order(List<Resource> jars) {
        List<Resource> orderedList = new ArrayList<>();
        List<Resource> tmp = new ArrayList<>(jars);
        Map<String, FragmentDescriptor> others = new HashMap<>(this._metaData.getNamedFragments());
        int index = -1;
        for (String item : this._order) {
            if (item.equals(OTHER)) {
                index = orderedList.size();
            } else if (others.remove(item) != null) {
                Resource jar = this._metaData.getJarForFragment(item);
                orderedList.add(jar);
                tmp.remove(jar);
            }
        }
        if (this._hasOther) {
            orderedList.addAll(index < 0 ? 0 : index, tmp);
        }
        return orderedList;
    }

    public void add(String name) {
        this._order.add(name);
    }

    public void addOthers() {
        if (this._hasOther) {
            throw new IllegalStateException("Duplicate <other> element in absolute ordering");
        }
        this._hasOther = true;
        this._order.add(OTHER);
    }
}
