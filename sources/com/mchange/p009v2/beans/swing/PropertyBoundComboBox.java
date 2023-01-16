package com.mchange.p009v2.beans.swing;

import com.mchange.p009v2.beans.BeansUtils;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import java.util.Collection;
import javax.swing.BoxLayout;
import javax.swing.ComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;

/* renamed from: com.mchange.v2.beans.swing.PropertyBoundComboBox */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundComboBox.class */
public class PropertyBoundComboBox extends JComboBox {
    PropertyComponentBindingUtility pcbu;
    Object nullObject;
    Object itemsSrc = null;
    MyHbi myHbi = new MyHbi();

    public PropertyBoundComboBox(Object obj, String str, Object obj2, Object obj3) throws IntrospectionException {
        this.nullObject = null;
        this.pcbu = new PropertyComponentBindingUtility(this.myHbi, obj, str, false);
        this.nullObject = obj3;
        setItemsSrc(obj2);
    }

    public Object getItemsSrc() {
        return this.itemsSrc;
    }

    public void setItemsSrc(Object obj) {
        this.myHbi.suspendNotifications();
        removeAllItems();
        if (obj instanceof Object[]) {
            for (Object obj2 : (Object[]) obj) {
                addItem(obj2);
            }
        } else if (obj instanceof Collection) {
            for (Object obj3 : (Collection) obj) {
                addItem(obj3);
            }
        } else if (obj instanceof ComboBoxModel) {
            setModel((ComboBoxModel) obj);
        } else {
            throw new IllegalArgumentException("itemsSrc must be an Object[], a Collection, or a ComboBoxModel");
        }
        this.itemsSrc = obj;
        this.pcbu.resync();
        this.myHbi.resumeNotifications();
    }

    public void setNullObject(Object obj) {
        this.nullObject = null;
        this.pcbu.resync();
    }

    public Object getNullObject() {
        return this.nullObject;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: com.mchange.v2.beans.swing.PropertyBoundComboBox$MyHbi */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundComboBox$MyHbi.class */
    public class MyHbi implements HostBindingInterface {
        boolean suspend_notice = false;

        MyHbi() {
        }

        public void suspendNotifications() {
            this.suspend_notice = true;
        }

        public void resumeNotifications() {
            this.suspend_notice = false;
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void syncToValue(PropertyEditor propertyEditor, Object obj) {
            if (obj == null) {
                PropertyBoundComboBox.this.setSelectedItem(PropertyBoundComboBox.this.nullObject);
            } else {
                PropertyBoundComboBox.this.setSelectedItem(obj);
            }
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void addUserModificationListeners() {
            PropertyBoundComboBox.this.addItemListener(new ItemListener() { // from class: com.mchange.v2.beans.swing.PropertyBoundComboBox.MyHbi.1
                public void itemStateChanged(ItemEvent itemEvent) {
                    if (!MyHbi.this.suspend_notice) {
                        PropertyBoundComboBox.this.pcbu.userModification();
                    }
                }
            });
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public Object fetchUserModification(PropertyEditor propertyEditor, Object obj) {
            Object selectedItem = PropertyBoundComboBox.this.getSelectedItem();
            if (PropertyBoundComboBox.this.nullObject != null && PropertyBoundComboBox.this.nullObject.equals(selectedItem)) {
                selectedItem = null;
            }
            return selectedItem;
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void alertErroneousInput() {
            PropertyBoundComboBox.this.getToolkit().beep();
        }
    }

    public static void main(String[] strArr) {
        try {
            TestBean testBean = new TestBean();
            testBean.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.beans.swing.PropertyBoundComboBox.1
                @Override // java.beans.PropertyChangeListener
                public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                    BeansUtils.debugShowPropertyChange(propertyChangeEvent);
                }
            });
            PropertyBoundComboBox propertyBoundComboBox = new PropertyBoundComboBox(testBean, "theString", new String[]{"SELECT", "Frog", "Fish", "Puppy"}, "SELECT");
            PropertyBoundTextField propertyBoundTextField = new PropertyBoundTextField(testBean, "theInt", 5);
            PropertyBoundTextField propertyBoundTextField2 = new PropertyBoundTextField(testBean, "theFloat", 5);
            JFrame jFrame = new JFrame();
            jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), 1));
            jFrame.getContentPane().add(propertyBoundComboBox);
            jFrame.getContentPane().add(propertyBoundTextField);
            jFrame.getContentPane().add(propertyBoundTextField2);
            jFrame.pack();
            jFrame.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
