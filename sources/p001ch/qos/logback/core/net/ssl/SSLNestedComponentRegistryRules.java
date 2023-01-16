package p001ch.qos.logback.core.net.ssl;

import org.quartz.jobs.NativeJob;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;

/* renamed from: ch.qos.logback.core.net.ssl.SSLNestedComponentRegistryRules */
/* loaded from: grasscutter.jar:ch/qos/logback/core/net/ssl/SSLNestedComponentRegistryRules.class */
public class SSLNestedComponentRegistryRules {
    public static void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
        registry.add(SSLComponent.class, "ssl", SSLConfiguration.class);
        registry.add(SSLConfiguration.class, NativeJob.PROP_PARAMETERS, SSLParametersConfiguration.class);
        registry.add(SSLConfiguration.class, "keyStore", KeyStoreFactoryBean.class);
        registry.add(SSLConfiguration.class, "trustStore", KeyStoreFactoryBean.class);
        registry.add(SSLConfiguration.class, "keyManagerFactory", KeyManagerFactoryFactoryBean.class);
        registry.add(SSLConfiguration.class, "trustManagerFactory", TrustManagerFactoryFactoryBean.class);
        registry.add(SSLConfiguration.class, "secureRandom", SecureRandomFactoryBean.class);
    }
}
