package com.mchange.p009v2.beans.swing;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.beans.IntrospectionException;
import java.beans.PropertyEditor;
import java.util.HashSet;
import java.util.Set;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.event.ChangeListener;

/* renamed from: com.mchange.v2.beans.swing.SetPropertyElementBoundButtonModel */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/SetPropertyElementBoundButtonModel.class */
class SetPropertyElementBoundButtonModel implements ButtonModel {
    Object putativeElement;
    ButtonModel inner;
    PropertyComponentBindingUtility pcbu;

    public static void bind(AbstractButton[] abstractButtonArr, Object[] objArr, Object obj, String str) throws IntrospectionException {
        int length = abstractButtonArr.length;
        for (int i = 0; i < length; i++) {
            AbstractButton abstractButton = abstractButtonArr[i];
            abstractButton.setModel(new SetPropertyElementBoundButtonModel(abstractButton.getModel(), obj, str, objArr[i]));
        }
    }

    public SetPropertyElementBoundButtonModel(ButtonModel buttonModel, Object obj, String str, Object obj2) throws IntrospectionException {
        this.inner = buttonModel;
        this.putativeElement = obj2;
        this.pcbu = new PropertyComponentBindingUtility(new MyHbi(), obj, str, false);
        this.pcbu.resync();
    }

    public boolean isArmed() {
        return this.inner.isArmed();
    }

    public boolean isSelected() {
        return this.inner.isSelected();
    }

    public boolean isEnabled() {
        return this.inner.isEnabled();
    }

    public boolean isPressed() {
        return this.inner.isPressed();
    }

    public boolean isRollover() {
        return this.inner.isRollover();
    }

    public void setArmed(boolean z) {
        this.inner.setArmed(z);
    }

    public void setSelected(boolean z) {
        this.inner.setSelected(z);
    }

    public void setEnabled(boolean z) {
        this.inner.setEnabled(z);
    }

    public void setPressed(boolean z) {
        this.inner.setPressed(z);
    }

    public void setRollover(boolean z) {
        this.inner.setRollover(z);
    }

    public void setMnemonic(int i) {
        this.inner.setMnemonic(i);
    }

    public int getMnemonic() {
        return this.inner.getMnemonic();
    }

    public void setActionCommand(String str) {
        this.inner.setActionCommand(str);
    }

    public String getActionCommand() {
        return this.inner.getActionCommand();
    }

    public void setGroup(ButtonGroup buttonGroup) {
        this.inner.setGroup(buttonGroup);
    }

    public Object[] getSelectedObjects() {
        return this.inner.getSelectedObjects();
    }

    public void addActionListener(ActionListener actionListener) {
        this.inner.addActionListener(actionListener);
    }

    public void removeActionListener(ActionListener actionListener) {
        this.inner.removeActionListener(actionListener);
    }

    public void addItemListener(ItemListener itemListener) {
        this.inner.addItemListener(itemListener);
    }

    public void removeItemListener(ItemListener itemListener) {
        this.inner.removeItemListener(itemListener);
    }

    public void addChangeListener(ChangeListener changeListener) {
        this.inner.addChangeListener(changeListener);
    }

    public void removeChangeListener(ChangeListener changeListener) {
        this.inner.removeChangeListener(changeListener);
    }

    /* renamed from: com.mchange.v2.beans.swing.SetPropertyElementBoundButtonModel$MyHbi */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/SetPropertyElementBoundButtonModel$MyHbi.class */
    class MyHbi implements HostBindingInterface {
        MyHbi() {
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void syncToValue(PropertyEditor propertyEditor, Object obj) {
            if (obj == null) {
                SetPropertyElementBoundButtonModel.this.setSelected(false);
            } else {
                SetPropertyElementBoundButtonModel.this.setSelected(((Set) obj).contains(SetPropertyElementBoundButtonModel.this.putativeElement));
            }
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void addUserModificationListeners() {
            SetPropertyElementBoundButtonModel.this.addActionListener(new ActionListener() { // from class: com.mchange.v2.beans.swing.SetPropertyElementBoundButtonModel.MyHbi.1
                public void actionPerformed(ActionEvent actionEvent) {
                    SetPropertyElementBoundButtonModel.this.pcbu.userModification();
                }
            });
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public Object fetchUserModification(PropertyEditor propertyEditor, Object obj) {
            HashSet hashSet;
            if (obj != null) {
                hashSet = new HashSet((Set) obj);
            } else if (!SetPropertyElementBoundButtonModel.this.isSelected()) {
                return null;
            } else {
                hashSet = new HashSet();
            }
            if (SetPropertyElementBoundButtonModel.this.isSelected()) {
                hashSet.add(SetPropertyElementBoundButtonModel.this.putativeElement);
            } else {
                hashSet.remove(SetPropertyElementBoundButtonModel.this.putativeElement);
            }
            return hashSet;
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void alertErroneousInput() {
            Toolkit.getDefaultToolkit().beep();
        }
    }
}
