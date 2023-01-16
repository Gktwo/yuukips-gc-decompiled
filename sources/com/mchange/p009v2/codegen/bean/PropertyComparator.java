package com.mchange.p009v2.codegen.bean;

/* renamed from: com.mchange.v2.codegen.bean.PropertyComparator */
/* loaded from: grasscutter.jar:com/mchange/v2/codegen/bean/PropertyComparator.class */
class PropertyComparator {
    PropertyComparator() {
    }

    public int compare(Object obj, Object obj2) {
        return ((Property) obj).getName().compareTo(((Property) obj2).getName());
    }
}
