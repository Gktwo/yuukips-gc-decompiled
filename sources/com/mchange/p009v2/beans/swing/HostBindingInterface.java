package com.mchange.p009v2.beans.swing;

import java.beans.PropertyEditor;

/* renamed from: com.mchange.v2.beans.swing.HostBindingInterface */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/HostBindingInterface.class */
interface HostBindingInterface {
    void syncToValue(PropertyEditor propertyEditor, Object obj);

    void addUserModificationListeners();

    Object fetchUserModification(PropertyEditor propertyEditor, Object obj);

    void alertErroneousInput();
}
