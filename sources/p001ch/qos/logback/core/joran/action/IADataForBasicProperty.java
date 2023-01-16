package p001ch.qos.logback.core.joran.action;

import p001ch.qos.logback.core.joran.util.PropertySetter;
import p001ch.qos.logback.core.util.AggregationType;

/* renamed from: ch.qos.logback.core.joran.action.IADataForBasicProperty */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/IADataForBasicProperty.class */
class IADataForBasicProperty {
    final PropertySetter parentBean;
    final AggregationType aggregationType;
    final String propertyName;
    boolean inError;

    /* access modifiers changed from: package-private */
    public IADataForBasicProperty(PropertySetter parentBean, AggregationType aggregationType, String propertyName) {
        this.parentBean = parentBean;
        this.aggregationType = aggregationType;
        this.propertyName = propertyName;
    }
}
