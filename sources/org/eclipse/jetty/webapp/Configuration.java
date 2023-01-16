package org.eclipse.jetty.webapp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.ListIterator;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.util.annotation.Name;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Configuration.class */
public interface Configuration {
    public static final String ATTR = "org.eclipse.jetty.webapp.configuration";

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Configuration$WrapperFunction.class */
    public interface WrapperFunction {
        Configuration wrapConfiguration(Configuration configuration);
    }

    void preConfigure(WebAppContext webAppContext) throws Exception;

    void configure(WebAppContext webAppContext) throws Exception;

    void postConfigure(WebAppContext webAppContext) throws Exception;

    void deconfigure(WebAppContext webAppContext) throws Exception;

    void destroy(WebAppContext webAppContext) throws Exception;

    void cloneConfigure(WebAppContext webAppContext, WebAppContext webAppContext2) throws Exception;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Configuration$Wrapper.class */
    public static class Wrapper implements Configuration {
        private Configuration delegate;

        public Wrapper(Configuration delegate) {
            this.delegate = delegate;
        }

        public Configuration getWrapped() {
            return this.delegate;
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void preConfigure(WebAppContext context) throws Exception {
            this.delegate.preConfigure(context);
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void configure(WebAppContext context) throws Exception {
            this.delegate.configure(context);
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void postConfigure(WebAppContext context) throws Exception {
            this.delegate.postConfigure(context);
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void deconfigure(WebAppContext context) throws Exception {
            this.delegate.deconfigure(context);
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void destroy(WebAppContext context) throws Exception {
            this.delegate.destroy(context);
        }

        @Override // org.eclipse.jetty.webapp.Configuration
        public void cloneConfigure(WebAppContext template, WebAppContext context) throws Exception {
            this.delegate.cloneConfigure(template, context);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/Configuration$ClassList.class */
    public static class ClassList extends ArrayList<String> {
        public static ClassList setServerDefault(Server server) {
            ClassList cl = (ClassList) server.getBean((Class<Object>) ClassList.class);
            if (cl != null) {
                return cl;
            }
            ClassList cl2 = serverDefault(server);
            server.addBean(cl2);
            server.setAttribute(Configuration.ATTR, null);
            return cl2;
        }

        public static ClassList serverDefault(Server server) {
            if (server != null) {
                ClassList cl = (ClassList) server.getBean((Class<Object>) ClassList.class);
                if (cl != null) {
                    return new ClassList(cl);
                }
                Object attr = server.getAttribute(Configuration.ATTR);
                if (attr instanceof ClassList) {
                    return new ClassList((ClassList) attr);
                }
                if (attr instanceof String[]) {
                    return new ClassList((String[]) attr);
                }
            }
            return new ClassList();
        }

        public ClassList() {
            this(WebAppContext.DEFAULT_CONFIGURATION_CLASSES);
        }

        public ClassList(String[] classes) {
            addAll(Arrays.asList(classes));
        }

        public ClassList(List<String> classes) {
            addAll(classes);
        }

        public void addAfter(@Name("afterClass") String afterClass, @Name("configClass") String... configClass) {
            if (!(configClass == null || afterClass == null)) {
                ListIterator<String> iter = listIterator();
                while (iter.hasNext()) {
                    if (afterClass.equals(iter.next())) {
                        for (String str : configClass) {
                            iter.add(str);
                        }
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("afterClass '" + afterClass + "' not found in " + this);
        }

        public void addBefore(@Name("beforeClass") String beforeClass, @Name("configClass") String... configClass) {
            if (!(configClass == null || beforeClass == null)) {
                ListIterator<String> iter = listIterator();
                while (iter.hasNext()) {
                    if (beforeClass.equals(iter.next())) {
                        iter.previous();
                        for (String str : configClass) {
                            iter.add(str);
                        }
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("beforeClass '" + beforeClass + "' not found in " + this);
        }

        public void replace(@Name("replaceClass") String replaceClass, @Name("configClass") String configClass) {
            if (!(replaceClass == null || configClass == null)) {
                ListIterator<String> iter = listIterator();
                while (iter.hasNext()) {
                    if (replaceClass.equals(iter.next())) {
                        iter.set(configClass);
                        return;
                    }
                }
            }
            throw new IllegalArgumentException("replaceClass '" + replaceClass + "' not found in " + this);
        }
    }
}
