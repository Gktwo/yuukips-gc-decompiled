package p001ch.qos.logback.core.joran.conditional;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import org.codehaus.commons.compiler.CompileException;
import org.codehaus.janino.ClassBodyEvaluator;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.spi.PropertyContainer;

/* renamed from: ch.qos.logback.core.joran.conditional.PropertyEvalScriptBuilder */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/conditional/PropertyEvalScriptBuilder.class */
public class PropertyEvalScriptBuilder extends ContextAwareBase {
    private static String SCRIPT_PREFIX = "public boolean evaluate() { return ";
    private static String SCRIPT_SUFFIX = "; }";
    final PropertyContainer localPropContainer;
    Map<String, String> map = new HashMap();

    /* access modifiers changed from: package-private */
    public PropertyEvalScriptBuilder(PropertyContainer localPropContainer) {
        this.localPropContainer = localPropContainer;
    }

    public Condition build(String script) throws IllegalAccessException, CompileException, InstantiationException, SecurityException, NoSuchMethodException, IllegalArgumentException, InvocationTargetException {
        ClassBodyEvaluator cbe = new ClassBodyEvaluator();
        cbe.setImplementedInterfaces(new Class[]{Condition.class});
        cbe.setExtendedClass(PropertyWrapperForScripts.class);
        cbe.setParentClassLoader(ClassBodyEvaluator.class.getClassLoader());
        cbe.cook(SCRIPT_PREFIX + script + SCRIPT_SUFFIX);
        Class<?> clazz = cbe.getClazz();
        Condition instance = (Condition) clazz.newInstance();
        clazz.getMethod("setPropertyContainers", PropertyContainer.class, PropertyContainer.class).invoke(instance, this.localPropContainer, this.context);
        return instance;
    }
}
