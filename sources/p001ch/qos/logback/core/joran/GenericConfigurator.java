package p001ch.qos.logback.core.joran;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;
import org.xml.sax.InputSource;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.joran.event.SaxEvent;
import p001ch.qos.logback.core.joran.event.SaxEventRecorder;
import p001ch.qos.logback.core.joran.spi.DefaultNestedComponentRegistry;
import p001ch.qos.logback.core.joran.spi.ElementPath;
import p001ch.qos.logback.core.joran.spi.InterpretationContext;
import p001ch.qos.logback.core.joran.spi.Interpreter;
import p001ch.qos.logback.core.joran.spi.JoranException;
import p001ch.qos.logback.core.joran.spi.RuleStore;
import p001ch.qos.logback.core.joran.spi.SimpleRuleStore;
import p001ch.qos.logback.core.joran.util.ConfigurationWatchListUtil;
import p001ch.qos.logback.core.joran.util.beans.BeanDescriptionCache;
import p001ch.qos.logback.core.spi.ContextAwareBase;
import p001ch.qos.logback.core.status.StatusUtil;

/* renamed from: ch.qos.logback.core.joran.GenericConfigurator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/joran/GenericConfigurator.class */
public abstract class GenericConfigurator extends ContextAwareBase {
    private BeanDescriptionCache beanDescriptionCache;
    protected Interpreter interpreter;

    protected abstract void addInstanceRules(RuleStore ruleStore);

    protected abstract void addImplicitRules(Interpreter interpreter);

    public final void doConfigure(URL url) throws JoranException {
        InputStream in;
        try {
            in = null;
            try {
                informContextOfURLUsedForConfiguration(getContext(), url);
                URLConnection urlConnection = url.openConnection();
                urlConnection.setUseCaches(false);
                in = urlConnection.getInputStream();
                doConfigure(in, url.toExternalForm());
                if (in != null) {
                    try {
                        in.close();
                    } catch (IOException ioe) {
                        addError("Could not close input stream", ioe);
                        throw new JoranException("Could not close input stream", ioe);
                    }
                }
            } catch (IOException ioe2) {
                String errMsg = "Could not open URL [" + url + "].";
                addError(errMsg, ioe2);
                throw new JoranException(errMsg, ioe2);
            }
        } catch (Throwable th) {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException ioe3) {
                    addError("Could not close input stream", ioe3);
                    throw new JoranException("Could not close input stream", ioe3);
                }
            }
            throw th;
        }
    }

    public final void doConfigure(String filename) throws JoranException {
        doConfigure(new File(filename));
    }

    public final void doConfigure(File file) throws JoranException {
        FileInputStream fis = null;
        try {
            try {
                URL url = file.toURI().toURL();
                informContextOfURLUsedForConfiguration(getContext(), url);
                fis = new FileInputStream(file);
                doConfigure(fis, url.toExternalForm());
                if (fis != null) {
                    try {
                        fis.close();
                    } catch (IOException ioe) {
                        String errMsg = "Could not close [" + file.getName() + "].";
                        addError(errMsg, ioe);
                        throw new JoranException(errMsg, ioe);
                    }
                }
            } catch (IOException ioe2) {
                String errMsg2 = "Could not open [" + file.getPath() + "].";
                addError(errMsg2, ioe2);
                throw new JoranException(errMsg2, ioe2);
            }
        } catch (Throwable th) {
            if (fis != null) {
                try {
                    fis.close();
                } catch (IOException ioe3) {
                    String errMsg3 = "Could not close [" + file.getName() + "].";
                    addError(errMsg3, ioe3);
                    throw new JoranException(errMsg3, ioe3);
                }
            }
            throw th;
        }
    }

    public static void informContextOfURLUsedForConfiguration(Context context, URL url) {
        ConfigurationWatchListUtil.setMainWatchURL(context, url);
    }

    public final void doConfigure(InputStream inputStream) throws JoranException {
        doConfigure(new InputSource(inputStream));
    }

    public final void doConfigure(InputStream inputStream, String systemId) throws JoranException {
        InputSource inputSource = new InputSource(inputStream);
        inputSource.setSystemId(systemId);
        doConfigure(inputSource);
    }

    protected BeanDescriptionCache getBeanDescriptionCache() {
        if (this.beanDescriptionCache == null) {
            this.beanDescriptionCache = new BeanDescriptionCache(getContext());
        }
        return this.beanDescriptionCache;
    }

    protected void addDefaultNestedComponentRegistryRules(DefaultNestedComponentRegistry registry) {
    }

    protected ElementPath initialElementPath() {
        return new ElementPath();
    }

    /* access modifiers changed from: protected */
    public void buildInterpreter() {
        RuleStore rs = new SimpleRuleStore(this.context);
        addInstanceRules(rs);
        this.interpreter = new Interpreter(this.context, rs, initialElementPath());
        InterpretationContext interpretationContext = this.interpreter.getInterpretationContext();
        interpretationContext.setContext(this.context);
        addImplicitRules(this.interpreter);
        addDefaultNestedComponentRegistryRules(interpretationContext.getDefaultNestedComponentRegistry());
    }

    public final void doConfigure(InputSource inputSource) throws JoranException {
        long threshold = System.currentTimeMillis();
        SaxEventRecorder recorder = new SaxEventRecorder(this.context);
        recorder.recordEvents(inputSource);
        doConfigure(recorder.saxEventList);
        if (new StatusUtil(this.context).noXMLParsingErrorsOccurred(threshold)) {
            addInfo("Registering current configuration as safe fallback point");
            registerSafeConfiguration(recorder.saxEventList);
        }
    }

    public void doConfigure(List<SaxEvent> eventList) throws JoranException {
        buildInterpreter();
        synchronized (this.context.getConfigurationLock()) {
            this.interpreter.getEventPlayer().play(eventList);
        }
    }

    public void registerSafeConfiguration(List<SaxEvent> eventList) {
        this.context.putObject(CoreConstants.SAFE_JORAN_CONFIGURATION, eventList);
    }

    public List<SaxEvent> recallSafeConfiguration() {
        return (List) this.context.getObject(CoreConstants.SAFE_JORAN_CONFIGURATION);
    }
}
