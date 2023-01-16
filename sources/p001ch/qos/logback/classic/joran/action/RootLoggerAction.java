package p001ch.qos.logback.classic.joran.action;

import org.xml.sax.Attributes;
import p001ch.qos.logback.classic.Level;
import p001ch.qos.logback.classic.Logger;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.core.joran.action.Action;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.classic.joran.action.RootLoggerAction */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/joran/action/RootLoggerAction.class */
public class RootLoggerAction extends Action {
    Logger root;
    boolean inError = false;

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String name, Attributes attributes) {
        this.inError = false;
        this.root = ((LoggerContext) this.context).getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME);
        String levelStr = ec.subst(attributes.getValue("level"));
        if (!OptionHelper.isEmpty(levelStr)) {
            Level level = Level.toLevel(levelStr);
            addInfo("Setting level of ROOT logger to " + level);
            this.root.setLevel(level);
        }
        ec.pushObject(this.root);
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
        if (!this.inError) {
            Object o = ec.peekObject();
            if (o != this.root) {
                addWarn("The object on the top the of the stack is not the root logger");
                addWarn("It is: " + o);
                return;
            }
            ec.popObject();
        }
    }

    public void finish(InterpretationContext ec) {
    }
}
