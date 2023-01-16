package org.eclipse.jetty.servlet.listener;

import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.eclipse.jetty.util.Loader;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/listener/ELContextCleaner.class */
public class ELContextCleaner implements ServletContextListener {
    private static final Logger LOG = Log.getLogger(ELContextCleaner.class);

    @Override // javax.servlet.ServletContextListener
    public void contextInitialized(ServletContextEvent sce) {
    }

    @Override // javax.servlet.ServletContextListener
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            purgeEntries(getField(Loader.loadClass("javax.el.BeanELResolver")));
            if (LOG.isDebugEnabled()) {
                LOG.debug("javax.el.BeanELResolver purged", new Object[0]);
            }
        } catch (ClassNotFoundException e) {
        } catch (IllegalAccessException | IllegalArgumentException | SecurityException e2) {
            LOG.warn("Cannot purge classes from javax.el.BeanELResolver", e2);
        } catch (NoSuchFieldException e3) {
            LOG.debug("Not cleaning cached beans: no such field javax.el.BeanELResolver.properties", new Object[0]);
        }
    }

    protected Field getField(Class<?> beanELResolver) throws SecurityException, NoSuchFieldException {
        if (beanELResolver == null) {
            return null;
        }
        return beanELResolver.getDeclaredField("properties");
    }

    protected void purgeEntries(Field properties) throws IllegalArgumentException, IllegalAccessException {
        if (properties != null) {
            if (!properties.isAccessible()) {
                properties.setAccessible(true);
            }
            Map map = (Map) properties.get(null);
            if (map != null) {
                Iterator<Class<?>> itor = map.keySet().iterator();
                while (itor.hasNext()) {
                    Class<?> clazz = itor.next();
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Clazz: " + clazz + " loaded by " + clazz.getClassLoader(), new Object[0]);
                    }
                    if (Thread.currentThread().getContextClassLoader().equals(clazz.getClassLoader())) {
                        itor.remove();
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("removed", new Object[0]);
                        }
                    } else if (LOG.isDebugEnabled()) {
                        LOG.debug("not removed: contextclassloader=" + Thread.currentThread().getContextClassLoader() + "clazz's classloader=" + clazz.getClassLoader(), new Object[0]);
                    }
                }
            }
        }
    }
}
