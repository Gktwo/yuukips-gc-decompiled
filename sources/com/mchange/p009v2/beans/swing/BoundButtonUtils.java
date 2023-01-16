package com.mchange.p009v2.beans.swing;

import java.beans.IntrospectionException;
import javax.swing.AbstractButton;

/* renamed from: com.mchange.v2.beans.swing.BoundButtonUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/BoundButtonUtils.class */
public final class BoundButtonUtils {
    public static void bindToSetProperty(AbstractButton[] abstractButtonArr, Object[] objArr, Object obj, String str) throws IntrospectionException {
        SetPropertyElementBoundButtonModel.bind(abstractButtonArr, objArr, obj, str);
    }

    public static void bindAsRadioButtonsToProperty(AbstractButton[] abstractButtonArr, Object[] objArr, Object obj, String str) throws IntrospectionException {
        PropertyBoundButtonGroup propertyBoundButtonGroup = new PropertyBoundButtonGroup(obj, str);
        for (int i = 0; i < abstractButtonArr.length; i++) {
            propertyBoundButtonGroup.add(abstractButtonArr[i], objArr[i]);
        }
    }
}
