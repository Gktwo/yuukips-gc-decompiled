package org.jline.style;

import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: grasscutter.jar:org/jline/style/Styler.class */
public class Styler {
    private static final Logger log = Logger.getLogger(Styler.class.getName());
    private static volatile StyleSource source = new NopStyleSource();

    private Styler() {
    }

    public static StyleSource getSource() {
        return source;
    }

    public static void setSource(StyleSource source2) {
        source = (StyleSource) Objects.requireNonNull(source2);
        if (log.isLoggable(Level.FINE)) {
            log.fine("Source: " + source2);
        }
    }

    public static StyleResolver resolver(String group) {
        return new StyleResolver(source, group);
    }

    public static StyleFactory factory(String group) {
        return new StyleFactory(resolver(group));
    }

    public static <T extends StyleBundle> T bundle(Class<T> type) {
        return (T) StyleBundleInvocationHandler.create(source, type);
    }

    public static <T extends StyleBundle> T bundle(String group, Class<T> type) {
        return (T) StyleBundleInvocationHandler.create(resolver(group), type);
    }
}
