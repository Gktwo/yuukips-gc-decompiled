package p001ch.qos.logback.classic.joran.action;

import java.lang.management.ManagementFactory;
import javax.management.MBeanServer;
import javax.management.ObjectName;
import org.xml.sax.Attributes;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.jmx.JMXConfigurator;
import p001ch.qos.logback.classic.jmx.MBeanUtil;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.ActionException;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.joran.action.JMXConfiguratorAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/JMXConfiguratorAction.class */
public class JMXConfiguratorAction extends Action {
    static final String OBJECT_NAME_ATTRIBUTE_NAME = "objectName";
    static final String CONTEXT_NAME_ATTRIBUTE_NAME = "contextName";
    static final char JMX_NAME_SEPARATOR = ',';

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) throws ActionException {
        String objectNameAsStr;
        addInfo("begin");
        String contextName = this.context.getName();
        String contextNameAttributeVal = attributes.getValue(CONTEXT_NAME_ATTRIBUTE_NAME);
        if (!OptionHelper.isEmpty(contextNameAttributeVal)) {
            contextName = contextNameAttributeVal;
        }
        String objectNameAttributeVal = attributes.getValue(OBJECT_NAME_ATTRIBUTE_NAME);
        if (OptionHelper.isEmpty(objectNameAttributeVal)) {
            objectNameAsStr = MBeanUtil.getObjectNameFor(contextName, JMXConfigurator.class);
        } else {
            objectNameAsStr = objectNameAttributeVal;
        }
        ObjectName objectName = MBeanUtil.string2ObjectName(this.context, this, objectNameAsStr);
        if (objectName == null) {
            addError("Failed construct ObjectName for [" + objectNameAsStr + "]");
            return;
        }
        MBeanServer mbs = ManagementFactory.getPlatformMBeanServer();
        if (!MBeanUtil.isRegistered(mbs, objectName)) {
            try {
                mbs.registerMBean(new JMXConfigurator((LoggerContext) this.context, mbs, objectName), objectName);
            } catch (Exception e) {
                addError("Failed to create mbean", e);
            }
        }
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) throws ActionException {
    }
}
