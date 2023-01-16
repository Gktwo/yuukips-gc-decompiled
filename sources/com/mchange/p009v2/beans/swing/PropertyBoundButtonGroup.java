package com.mchange.p009v2.beans.swing;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.IntrospectionException;
import java.beans.PropertyEditor;
import java.util.HashMap;
import java.util.Map;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JButton;

/* renamed from: com.mchange.v2.beans.swing.PropertyBoundButtonGroup */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundButtonGroup.class */
class PropertyBoundButtonGroup extends ButtonGroup {
    PropertyComponentBindingUtility pcbu;
    WeChangedListener wcl = new WeChangedListener();
    Map buttonsModelsToValues = new HashMap();
    Map valuesToButtonModels = new HashMap();
    JButton fakeButton = new JButton();
    HostBindingInterface myHbi = new MyHbi();

    public PropertyBoundButtonGroup(Object obj, String str) throws IntrospectionException {
        this.pcbu = new PropertyComponentBindingUtility(this.myHbi, obj, str, false);
        add(this.fakeButton, null);
        this.pcbu.resync();
    }

    public void add(AbstractButton abstractButton, Object obj) {
        add(abstractButton);
        this.buttonsModelsToValues.put(abstractButton.getModel(), obj);
        this.valuesToButtonModels.put(obj, abstractButton.getModel());
        abstractButton.addActionListener(this.wcl);
        this.pcbu.resync();
    }

    public void add(AbstractButton abstractButton) {
        System.err.println(this + "Warning: The button '" + abstractButton + "' has been implicitly associated with a null value!");
        System.err.println("To avoid this warning, please use public void add(AbstractButton button, Object associatedValue)");
        System.err.println("instead of the single-argument add method.");
        add(abstractButton);
        abstractButton.addActionListener(this.wcl);
        this.pcbu.resync();
    }

    public void remove(AbstractButton abstractButton) {
        abstractButton.removeActionListener(this.wcl);
        remove(abstractButton);
    }

    /* renamed from: com.mchange.v2.beans.swing.PropertyBoundButtonGroup$MyHbi */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundButtonGroup$MyHbi.class */
    class MyHbi implements HostBindingInterface {
        MyHbi() {
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void syncToValue(PropertyEditor propertyEditor, Object obj) {
            ButtonModel buttonModel = (ButtonModel) PropertyBoundButtonGroup.this.valuesToButtonModels.get(obj);
            if (buttonModel != null) {
                PropertyBoundButtonGroup.this.setSelected(buttonModel, true);
            } else {
                PropertyBoundButtonGroup.this.setSelected(PropertyBoundButtonGroup.this.fakeButton.getModel(), true);
            }
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void addUserModificationListeners() {
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public Object fetchUserModification(PropertyEditor propertyEditor, Object obj) {
            return PropertyBoundButtonGroup.this.buttonsModelsToValues.get(PropertyBoundButtonGroup.this.getSelection());
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void alertErroneousInput() {
            Toolkit.getDefaultToolkit().beep();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.beans.swing.PropertyBoundButtonGroup$WeChangedListener */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundButtonGroup$WeChangedListener.class */
    public class WeChangedListener implements ActionListener {
        WeChangedListener() {
        }

        public void actionPerformed(ActionEvent actionEvent) {
            PropertyBoundButtonGroup.this.pcbu.userModification();
        }
    }
}
