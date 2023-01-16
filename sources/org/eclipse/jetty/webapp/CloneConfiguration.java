package org.eclipse.jetty.webapp;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/CloneConfiguration.class */
public class CloneConfiguration extends AbstractConfiguration {
    final WebAppContext _template;

    CloneConfiguration(WebAppContext template) {
        this._template = template;
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void configure(WebAppContext context) throws Exception {
        for (Configuration configuration : this._template.getConfigurations()) {
            configuration.cloneConfigure(this._template, context);
        }
    }

    @Override // org.eclipse.jetty.webapp.AbstractConfiguration, org.eclipse.jetty.webapp.Configuration
    public void deconfigure(WebAppContext context) throws Exception {
        for (Configuration configuration : this._template.getConfigurations()) {
            configuration.deconfigure(context);
        }
    }
}
