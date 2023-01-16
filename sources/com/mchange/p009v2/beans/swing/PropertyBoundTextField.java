package com.mchange.p009v2.beans.swing;

import com.mchange.p009v2.beans.BeansUtils;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.beans.IntrospectionException;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyEditor;
import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JTextField;

/* renamed from: com.mchange.v2.beans.swing.PropertyBoundTextField */
/* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundTextField.class */
public class PropertyBoundTextField extends JTextField {
    PropertyComponentBindingUtility pcbu;
    HostBindingInterface myHbi = new MyHbi();

    public PropertyBoundTextField(Object obj, String str, int i) throws IntrospectionException {
        super(i);
        this.pcbu = new PropertyComponentBindingUtility(this.myHbi, obj, str, true);
        this.pcbu.resync();
    }

    /* renamed from: com.mchange.v2.beans.swing.PropertyBoundTextField$MyHbi */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundTextField$MyHbi.class */
    class MyHbi implements HostBindingInterface {
        MyHbi() {
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void syncToValue(PropertyEditor propertyEditor, Object obj) {
            if (obj == null) {
                PropertyBoundTextField.this.setText("");
                return;
            }
            propertyEditor.setValue(obj);
            PropertyBoundTextField.this.setText(propertyEditor.getAsText());
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void addUserModificationListeners() {
            FocusListener weChangedListener = new WeChangedListener();
            PropertyBoundTextField.this.addActionListener(weChangedListener);
            PropertyBoundTextField.this.addFocusListener(weChangedListener);
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public Object fetchUserModification(PropertyEditor propertyEditor, Object obj) {
            String trim = PropertyBoundTextField.this.getText().trim();
            if ("".equals(trim)) {
                return null;
            }
            propertyEditor.setAsText(trim);
            return propertyEditor.getValue();
        }

        @Override // com.mchange.p009v2.beans.swing.HostBindingInterface
        public void alertErroneousInput() {
            PropertyBoundTextField.this.getToolkit().beep();
        }
    }

    /* renamed from: com.mchange.v2.beans.swing.PropertyBoundTextField$WeChangedListener */
    /* loaded from: grasscutter.jar:com/mchange/v2/beans/swing/PropertyBoundTextField$WeChangedListener.class */
    class WeChangedListener implements ActionListener, FocusListener {
        WeChangedListener() {
        }

        public void actionPerformed(ActionEvent actionEvent) {
            PropertyBoundTextField.this.pcbu.userModification();
        }

        public void focusGained(FocusEvent focusEvent) {
        }

        public void focusLost(FocusEvent focusEvent) {
            PropertyBoundTextField.this.pcbu.userModification();
        }
    }

    public static void main(String[] strArr) {
        try {
            TestBean testBean = new TestBean();
            testBean.addPropertyChangeListener(new PropertyChangeListener() { // from class: com.mchange.v2.beans.swing.PropertyBoundTextField.1
                @Override // java.beans.PropertyChangeListener
                public void propertyChange(PropertyChangeEvent propertyChangeEvent) {
                    BeansUtils.debugShowPropertyChange(propertyChangeEvent);
                }
            });
            PropertyBoundTextField propertyBoundTextField = new PropertyBoundTextField(testBean, "theString", 20);
            PropertyBoundTextField propertyBoundTextField2 = new PropertyBoundTextField(testBean, "theInt", 5);
            PropertyBoundTextField propertyBoundTextField3 = new PropertyBoundTextField(testBean, "theFloat", 5);
            JFrame jFrame = new JFrame();
            jFrame.getContentPane().setLayout(new BoxLayout(jFrame.getContentPane(), 1));
            jFrame.getContentPane().add(propertyBoundTextField);
            jFrame.getContentPane().add(propertyBoundTextField2);
            jFrame.getContentPane().add(propertyBoundTextField3);
            jFrame.pack();
            jFrame.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
