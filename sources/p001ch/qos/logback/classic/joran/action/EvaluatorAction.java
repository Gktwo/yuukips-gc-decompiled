package p001ch.qos.logback.classic.joran.action;

import p001ch.qos.logback.classic.boolex.JaninoEventEvaluator;
import p001ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction;

/* renamed from: ch.qos.logback.classic.joran.action.EvaluatorAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/EvaluatorAction.class */
public class EvaluatorAction extends AbstractEventEvaluatorAction {
    @Override // p001ch.qos.logback.core.joran.action.AbstractEventEvaluatorAction
    protected String defaultClassName() {
        return JaninoEventEvaluator.class.getName();
    }
}
