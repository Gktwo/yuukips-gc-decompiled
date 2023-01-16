package p001ch.qos.logback.classic.util;

import java.io.IOException;
import java.net.URL;
import java.util.Iterator;
import java.util.Set;
import p001ch.qos.logback.classic.BasicConfigurator;
import p001ch.qos.logback.classic.LoggerContext;
import p001ch.qos.logback.classic.joran.JoranConfigurator;
import p001ch.qos.logback.classic.spi.Configurator;
import p001ch.qos.logback.core.LogbackException;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.status.ErrorStatus;
import p001ch.qos.logback.core.status.InfoStatus;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.WarnStatus;
import p001ch.qos.logback.core.util.Loader;
import p001ch.qos.logback.core.util.StatusListenerConfigHelper;

/* renamed from: ch.qos.logback.classic.util.ContextInitializer */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/util/ContextInitializer.class */
public class ContextInitializer {
    public static final String AUTOCONFIG_FILE = "logback.xml";
    public static final String TEST_AUTOCONFIG_FILE = "logback-test.xml";
    public static final String CONFIG_FILE_PROPERTY = "logback.configurationFile";
    final LoggerContext loggerContext;

    public ContextInitializer(LoggerContext loggerContext) {
        this.loggerContext = loggerContext;
    }

    public void configureByResource(URL url) throws JoranException {
        if (url == null) {
            throw new IllegalArgumentException("URL argument cannot be null");
        } else if (url.toString().endsWith("xml")) {
            JoranConfigurator configurator = new JoranConfigurator();
            configurator.setContext(this.loggerContext);
            configurator.doConfigure(url);
        } else {
            throw new LogbackException("Unexpected filename extension of file [" + url.toString() + "]. Should be .xml");
        }
    }

    void joranConfigureByResource(URL url) throws JoranException {
        JoranConfigurator configurator = new JoranConfigurator();
        configurator.setContext(this.loggerContext);
        configurator.doConfigure(url);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:27:0x0082
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    private java.net.URL findConfigFileURLFromSystemProperties(java.lang.ClassLoader r6, boolean r7) {
        /*
            r5 = this;
            java.lang.String r0 = "logback.configurationFile"
            java.lang.String r0 = p001ch.qos.logback.core.util.OptionHelper.getSystemProperty(r0)
            r8 = r0
            r0 = r8
            if (r0 == 0) goto L_0x00a4
            r0 = 0
            r9 = r0
            java.net.URL r0 = new java.net.URL     // Catch: MalformedURLException -> 0x002a, all -> 0x0093
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: MalformedURLException -> 0x002a, all -> 0x0093
            r9 = r0
            r0 = r9
            r10 = r0
            r0 = r7
            if (r0 == 0) goto L_0x0027
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            r0.statusOnResourceSearch(r1, r2, r3)
        L_0x0027:
            r0 = r10
            return r0
        L_0x002a:
            r10 = move-exception
            r0 = r8
            r1 = r6
            java.net.URL r0 = p001ch.qos.logback.core.util.Loader.getResource(r0, r1)     // Catch: all -> 0x0093
            r9 = r0
            r0 = r9
            if (r0 == 0) goto L_0x004b
            r0 = r9
            r11 = r0
            r0 = r7
            if (r0 == 0) goto L_0x0048
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            r0.statusOnResourceSearch(r1, r2, r3)
        L_0x0048:
            r0 = r11
            return r0
        L_0x004b:
            java.io.File r0 = new java.io.File     // Catch: all -> 0x0093
            r1 = r0
            r2 = r8
            r1.<init>(r2)     // Catch: all -> 0x0093
            r11 = r0
            r0 = r11
            boolean r0 = r0.exists()     // Catch: all -> 0x0093
            if (r0 == 0) goto L_0x0084
            r0 = r11
            boolean r0 = r0.isFile()     // Catch: all -> 0x0093
            if (r0 == 0) goto L_0x0084
            r0 = r11
            java.net.URI r0 = r0.toURI()     // Catch: all -> 0x0093, MalformedURLException -> 0x0082
            java.net.URL r0 = r0.toURL()     // Catch: all -> 0x0093, MalformedURLException -> 0x0082
            r9 = r0
            r0 = r9
            r12 = r0
            r0 = r7
            if (r0 == 0) goto L_0x007f
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            r0.statusOnResourceSearch(r1, r2, r3)
        L_0x007f:
            r0 = r12
            return r0
        L_0x0082:
            r12 = move-exception
        L_0x0084:
            r0 = r7
            if (r0 == 0) goto L_0x00a4
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            r0.statusOnResourceSearch(r1, r2, r3)
            goto L_0x00a4
        L_0x0093:
            r13 = move-exception
            r0 = r7
            if (r0 == 0) goto L_0x00a1
            r0 = r5
            r1 = r8
            r2 = r6
            r3 = r9
            r0.statusOnResourceSearch(r1, r2, r3)
        L_0x00a1:
            r0 = r13
            throw r0
        L_0x00a4:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: p001ch.qos.logback.classic.util.ContextInitializer.findConfigFileURLFromSystemProperties(java.lang.ClassLoader, boolean):java.net.URL");
    }

    public URL findURLOfDefaultConfigurationFile(boolean updateStatus) {
        ClassLoader myClassLoader = Loader.getClassLoaderOfObject(this);
        URL url = findConfigFileURLFromSystemProperties(myClassLoader, updateStatus);
        if (url != null) {
            return url;
        }
        URL url2 = getResource(TEST_AUTOCONFIG_FILE, myClassLoader, updateStatus);
        if (url2 != null) {
            return url2;
        }
        return getResource(AUTOCONFIG_FILE, myClassLoader, updateStatus);
    }

    private URL getResource(String filename, ClassLoader myClassLoader, boolean updateStatus) {
        URL url = Loader.getResource(filename, myClassLoader);
        if (updateStatus) {
            statusOnResourceSearch(filename, myClassLoader, url);
        }
        return url;
    }

    public void autoConfig() throws JoranException {
        StatusListenerConfigHelper.installIfAsked(this.loggerContext);
        URL url = findURLOfDefaultConfigurationFile(true);
        if (url != null) {
            configureByResource(url);
            return;
        }
        Configurator c = (Configurator) EnvUtil.loadFromServiceLoader(Configurator.class);
        if (c != null) {
            try {
                c.setContext(this.loggerContext);
                c.configure(this.loggerContext);
            } catch (Exception e) {
                Object[] objArr = new Object[1];
                objArr[0] = c != null ? c.getClass().getCanonicalName() : "null";
                throw new LogbackException(String.format("Failed to initialize Configurator: %s using ServiceLoader", objArr), e);
            }
        } else {
            BasicConfigurator basicConfigurator = new BasicConfigurator();
            basicConfigurator.setContext(this.loggerContext);
            basicConfigurator.configure(this.loggerContext);
        }
    }

    private void statusOnResourceSearch(String resourceName, ClassLoader classLoader, URL url) {
        StatusManager sm = this.loggerContext.getStatusManager();
        if (url == null) {
            sm.add(new InfoStatus("Could NOT find resource [" + resourceName + "]", this.loggerContext));
            return;
        }
        sm.add(new InfoStatus("Found resource [" + resourceName + "] at [" + url.toString() + "]", this.loggerContext));
        multiplicityWarning(resourceName, classLoader);
    }

    private void multiplicityWarning(String resourceName, ClassLoader classLoader) {
        Set<URL> urlSet = null;
        StatusManager sm = this.loggerContext.getStatusManager();
        try {
            urlSet = Loader.getResources(resourceName, classLoader);
        } catch (IOException e) {
            sm.add(new ErrorStatus("Failed to get url list for resource [" + resourceName + "]", this.loggerContext, e));
        }
        if (urlSet != null && urlSet.size() > 1) {
            sm.add(new WarnStatus("Resource [" + resourceName + "] occurs multiple times on the classpath.", this.loggerContext));
            Iterator<URL> it = urlSet.iterator();
            while (it.hasNext()) {
                sm.add(new WarnStatus("Resource [" + resourceName + "] occurs at [" + it.next().toString() + "]", this.loggerContext));
            }
        }
    }
}
