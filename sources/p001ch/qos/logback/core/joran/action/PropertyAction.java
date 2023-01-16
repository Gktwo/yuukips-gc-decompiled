package p001ch.qos.logback.core.joran.action;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;
import org.xml.sax.Attributes;
import p001ch.qos.logback.core.joran.action.ActionUtil;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.pattern.util.RegularEscapeUtil;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.OptionHelper;

/* renamed from: ch.qos.logback.core.joran.action.PropertyAction */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/action/PropertyAction.class */
public class PropertyAction extends Action {
    static final String RESOURCE_ATTRIBUTE = "resource";
    static String INVALID_ATTRIBUTES = "In <property> element, either the \"file\" attribute alone, or the \"resource\" element alone, or both the \"name\" and \"value\" attributes must be set.";

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void begin(InterpretationContext ec, String localName, Attributes attributes) {
        if ("substitutionProperty".equals(localName)) {
            addWarn("[substitutionProperty] element has been deprecated. Please use the [property] element instead.");
        }
        String name = attributes.getValue("name");
        String value = attributes.getValue("value");
        ActionUtil.Scope scope = ActionUtil.stringToScope(attributes.getValue(Action.SCOPE_ATTRIBUTE));
        if (checkFileAttributeSanity(attributes)) {
            String file = ec.subst(attributes.getValue(Action.FILE_ATTRIBUTE));
            try {
                loadAndSetProperties(ec, new FileInputStream(file), scope);
            } catch (FileNotFoundException e) {
                addError("Could not find properties file [" + file + "].");
            } catch (IOException e1) {
                addError("Could not read properties file [" + file + "].", e1);
            }
        } else if (checkResourceAttributeSanity(attributes)) {
            String resource = ec.subst(attributes.getValue(RESOURCE_ATTRIBUTE));
            URL resourceURL = Loader.getResourceBySelfClassLoader(resource);
            if (resourceURL == null) {
                addError("Could not find resource [" + resource + "].");
                return;
            }
            try {
                loadAndSetProperties(ec, resourceURL.openStream(), scope);
            } catch (IOException e2) {
                addError("Could not read resource file [" + resource + "].", e2);
            }
        } else if (checkValueNameAttributesSanity(attributes)) {
            ActionUtil.setProperty(ec, name, ec.subst(RegularEscapeUtil.basicEscape(value).trim()), scope);
        } else {
            addError(INVALID_ATTRIBUTES);
        }
    }

    void loadAndSetProperties(InterpretationContext ec, InputStream istream, ActionUtil.Scope scope) throws IOException {
        Properties props = new Properties();
        props.load(istream);
        istream.close();
        ActionUtil.setProperties(ec, props, scope);
    }

    boolean checkFileAttributeSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue(Action.FILE_ATTRIBUTE)) && OptionHelper.isEmpty(attributes.getValue("name")) && OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue(RESOURCE_ATTRIBUTE));
    }

    boolean checkResourceAttributeSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue(RESOURCE_ATTRIBUTE)) && OptionHelper.isEmpty(attributes.getValue("name")) && OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue(Action.FILE_ATTRIBUTE));
    }

    boolean checkValueNameAttributesSanity(Attributes attributes) {
        return !OptionHelper.isEmpty(attributes.getValue("name")) && !OptionHelper.isEmpty(attributes.getValue("value")) && OptionHelper.isEmpty(attributes.getValue(Action.FILE_ATTRIBUTE)) && OptionHelper.isEmpty(attributes.getValue(RESOURCE_ATTRIBUTE));
    }

    @Override // p001ch.qos.logback.core.joran.action.Action
    public void end(InterpretationContext ec, String name) {
    }

    public void finish(InterpretationContext ec) {
    }
}
