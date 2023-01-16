package p001ch.qos.logback.core.joran.spi;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Stack;
import org.xml.sax.Locator;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.joran.event.InPlayListener;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.PropertyContainer;
import p001ch.qos.logback.core.util.OptionHelper;
import p013io.javalin.http.sse.EmitterKt;

/* renamed from: ch.qos.logback.core.joran.spi.InterpretationContext */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/spi/InterpretationContext.class */
public class InterpretationContext extends ContextAwareBase implements PropertyContainer {
    Interpreter joranInterpreter;
    final List<InPlayListener> listenerList = new ArrayList();
    DefaultNestedComponentRegistry defaultNestedComponentRegistry = new DefaultNestedComponentRegistry();
    Stack<Object> objectStack = new Stack<>();
    Map<String, Object> objectMap = new HashMap(5);
    Map<String, String> propertiesMap = new HashMap(5);

    public InterpretationContext(Context context, Interpreter joranInterpreter) {
        this.context = context;
        this.joranInterpreter = joranInterpreter;
    }

    public DefaultNestedComponentRegistry getDefaultNestedComponentRegistry() {
        return this.defaultNestedComponentRegistry;
    }

    @Override // p001ch.qos.logback.core.spi.PropertyContainer
    public Map<String, String> getCopyOfPropertyMap() {
        return new HashMap(this.propertiesMap);
    }

    /* access modifiers changed from: package-private */
    public void setPropertiesMap(Map<String, String> propertiesMap) {
        this.propertiesMap = propertiesMap;
    }

    String updateLocationInfo(String msg) {
        Locator locator = this.joranInterpreter.getLocator();
        if (locator != null) {
            return msg + locator.getLineNumber() + EmitterKt.COMMENT_PREFIX + locator.getColumnNumber();
        }
        return msg;
    }

    public Locator getLocator() {
        return this.joranInterpreter.getLocator();
    }

    public Interpreter getJoranInterpreter() {
        return this.joranInterpreter;
    }

    public Stack<Object> getObjectStack() {
        return this.objectStack;
    }

    public boolean isEmpty() {
        return this.objectStack.isEmpty();
    }

    public Object peekObject() {
        return this.objectStack.peek();
    }

    public void pushObject(Object o) {
        this.objectStack.push(o);
    }

    public Object popObject() {
        return this.objectStack.pop();
    }

    public Object getObject(int i) {
        return this.objectStack.get(i);
    }

    public Map<String, Object> getObjectMap() {
        return this.objectMap;
    }

    public void addSubstitutionProperty(String key, String value) {
        if (key != null && value != null) {
            this.propertiesMap.put(key, value.trim());
        }
    }

    public void addSubstitutionProperties(Properties props) {
        if (props != null) {
            for (String key : props.keySet()) {
                addSubstitutionProperty(key, props.getProperty(key));
            }
        }
    }

    @Override // p001ch.qos.logback.core.spi.PropertyContainer
    public String getProperty(String key) {
        String v = this.propertiesMap.get(key);
        if (v != null) {
            return v;
        }
        return this.context.getProperty(key);
    }

    public String subst(String value) {
        if (value == null) {
            return null;
        }
        return OptionHelper.substVars(value, this, this.context);
    }

    public boolean isListenerListEmpty() {
        return this.listenerList.isEmpty();
    }

    public void addInPlayListener(InPlayListener ipl) {
        if (this.listenerList.contains(ipl)) {
            addWarn("InPlayListener " + ipl + " has been already registered");
        } else {
            this.listenerList.add(ipl);
        }
    }

    public boolean removeInPlayListener(InPlayListener ipl) {
        return this.listenerList.remove(ipl);
    }

    /* access modifiers changed from: package-private */
    public void fireInPlay(SaxEvent event) {
        for (InPlayListener ipl : this.listenerList) {
            ipl.inPlay(event);
        }
    }
}
