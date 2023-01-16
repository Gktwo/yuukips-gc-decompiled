package p013io.netty.util;

import java.lang.reflect.Constructor;
import kotlin.jvm.internal.LongCompanionObject;
import p013io.netty.util.internal.ObjectUtil;
import p013io.netty.util.internal.PlatformDependent;
import p013io.netty.util.internal.SystemPropertyUtil;
import p013io.netty.util.internal.logging.InternalLogger;
import p013io.netty.util.internal.logging.InternalLoggerFactory;

/* renamed from: io.netty.util.ResourceLeakDetectorFactory */
/* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetectorFactory.class */
public abstract class ResourceLeakDetectorFactory {
    private static final InternalLogger logger = InternalLoggerFactory.getInstance(ResourceLeakDetectorFactory.class);
    private static volatile ResourceLeakDetectorFactory factoryInstance = new DefaultResourceLeakDetectorFactory();

    @Deprecated
    public abstract <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> cls, int i, long j);

    public static ResourceLeakDetectorFactory instance() {
        return factoryInstance;
    }

    public static void setResourceLeakDetectorFactory(ResourceLeakDetectorFactory factory) {
        factoryInstance = (ResourceLeakDetectorFactory) ObjectUtil.checkNotNull(factory, "factory");
    }

    public final <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> resource) {
        return newResourceLeakDetector(resource, ResourceLeakDetector.SAMPLING_INTERVAL);
    }

    public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> resource, int samplingInterval) {
        ObjectUtil.checkPositive(samplingInterval, "samplingInterval");
        return newResourceLeakDetector(resource, samplingInterval, LongCompanionObject.MAX_VALUE);
    }

    /* renamed from: io.netty.util.ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory */
    /* loaded from: grasscutter.jar:io/netty/util/ResourceLeakDetectorFactory$DefaultResourceLeakDetectorFactory.class */
    private static final class DefaultResourceLeakDetectorFactory extends ResourceLeakDetectorFactory {
        private final Constructor<?> obsoleteCustomClassConstructor;
        private final Constructor<?> customClassConstructor;

        DefaultResourceLeakDetectorFactory() {
            String customLeakDetector;
            try {
                customLeakDetector = SystemPropertyUtil.get("io.netty.customResourceLeakDetector");
            } catch (Throwable cause) {
                ResourceLeakDetectorFactory.logger.error("Could not access System property: io.netty.customResourceLeakDetector", cause);
                customLeakDetector = null;
            }
            if (customLeakDetector == null) {
                this.customClassConstructor = null;
                this.obsoleteCustomClassConstructor = null;
                return;
            }
            this.obsoleteCustomClassConstructor = obsoleteCustomClassConstructor(customLeakDetector);
            this.customClassConstructor = customClassConstructor(customLeakDetector);
        }

        private static Constructor<?> obsoleteCustomClassConstructor(String customLeakDetector) {
            try {
                Class<?> detectorClass = Class.forName(customLeakDetector, true, PlatformDependent.getSystemClassLoader());
                if (ResourceLeakDetector.class.isAssignableFrom(detectorClass)) {
                    return detectorClass.getConstructor(Class.class, Integer.TYPE, Long.TYPE);
                }
                ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", customLeakDetector);
                return null;
            } catch (Throwable t) {
                ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", customLeakDetector, t);
                return null;
            }
        }

        private static Constructor<?> customClassConstructor(String customLeakDetector) {
            try {
                Class<?> detectorClass = Class.forName(customLeakDetector, true, PlatformDependent.getSystemClassLoader());
                if (ResourceLeakDetector.class.isAssignableFrom(detectorClass)) {
                    return detectorClass.getConstructor(Class.class, Integer.TYPE);
                }
                ResourceLeakDetectorFactory.logger.error("Class {} does not inherit from ResourceLeakDetector.", customLeakDetector);
                return null;
            } catch (Throwable t) {
                ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector class provided: {}", customLeakDetector, t);
                return null;
            }
        }

        @Override // p013io.netty.util.ResourceLeakDetectorFactory
        public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> resource, int samplingInterval, long maxActive) {
            if (this.obsoleteCustomClassConstructor != null) {
                try {
                    ResourceLeakDetector<T> leakDetector = (ResourceLeakDetector) this.obsoleteCustomClassConstructor.newInstance(resource, Integer.valueOf(samplingInterval), Long.valueOf(maxActive));
                    ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.obsoleteCustomClassConstructor.getDeclaringClass().getName());
                    return leakDetector;
                } catch (Throwable t) {
                    ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", this.obsoleteCustomClassConstructor.getDeclaringClass().getName(), resource, t);
                }
            }
            ResourceLeakDetector<T> resourceLeakDetector = new ResourceLeakDetector<>((Class<?>) resource, samplingInterval, maxActive);
            ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", resourceLeakDetector);
            return resourceLeakDetector;
        }

        @Override // p013io.netty.util.ResourceLeakDetectorFactory
        public <T> ResourceLeakDetector<T> newResourceLeakDetector(Class<T> resource, int samplingInterval) {
            if (this.customClassConstructor != null) {
                try {
                    ResourceLeakDetector<T> leakDetector = (ResourceLeakDetector) this.customClassConstructor.newInstance(resource, Integer.valueOf(samplingInterval));
                    ResourceLeakDetectorFactory.logger.debug("Loaded custom ResourceLeakDetector: {}", this.customClassConstructor.getDeclaringClass().getName());
                    return leakDetector;
                } catch (Throwable t) {
                    ResourceLeakDetectorFactory.logger.error("Could not load custom resource leak detector provided: {} with the given resource: {}", this.customClassConstructor.getDeclaringClass().getName(), resource, t);
                }
            }
            ResourceLeakDetector<T> resourceLeakDetector = new ResourceLeakDetector<>(resource, samplingInterval);
            ResourceLeakDetectorFactory.logger.debug("Loaded default ResourceLeakDetector: {}", resourceLeakDetector);
            return resourceLeakDetector;
        }
    }
}
