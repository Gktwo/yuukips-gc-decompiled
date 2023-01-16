package p001ch.qos.logback.classic.spi;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;
import p001ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.classic.spi.ThrowableProxy */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/spi/ThrowableProxy.class */
public class ThrowableProxy implements IThrowableProxy {
    private Throwable throwable;
    private String className;
    private String message;
    StackTraceElementProxy[] stackTraceElementProxyArray;
    int commonFrames;
    private ThrowableProxy cause;
    private ThrowableProxy[] suppressed;
    private transient PackagingDataCalculator packagingDataCalculator;
    private boolean calculatedPackageData;
    private boolean circular;
    private static final Method GET_SUPPRESSED_METHOD;
    static final StackTraceElementProxy[] EMPTY_STEP = new StackTraceElementProxy[0];
    private static final ThrowableProxy[] NO_SUPPRESSED = new ThrowableProxy[0];

    static {
        Method method = null;
        try {
            method = Throwable.class.getMethod("getSuppressed", new Class[0]);
        } catch (NoSuchMethodException e) {
        }
        GET_SUPPRESSED_METHOD = method;
    }

    public ThrowableProxy(Throwable throwable) {
        this(throwable, Collections.newSetFromMap(new IdentityHashMap()));
    }

    private ThrowableProxy(Throwable circular, boolean isCircular) {
        this.suppressed = NO_SUPPRESSED;
        this.calculatedPackageData = false;
        this.throwable = circular;
        this.className = circular.getClass().getName();
        this.message = circular.getMessage();
        this.stackTraceElementProxyArray = EMPTY_STEP;
        this.circular = true;
    }

    public ThrowableProxy(Throwable throwable, Set<Throwable> alreadyProcessedSet) {
        this.suppressed = NO_SUPPRESSED;
        this.calculatedPackageData = false;
        this.throwable = throwable;
        this.className = throwable.getClass().getName();
        this.message = throwable.getMessage();
        this.stackTraceElementProxyArray = ThrowableProxyUtil.steArrayToStepArray(throwable.getStackTrace());
        this.circular = false;
        alreadyProcessedSet.add(throwable);
        Throwable nested = throwable.getCause();
        if (nested != null) {
            if (alreadyProcessedSet.contains(nested)) {
                this.cause = new ThrowableProxy(nested, true);
            } else {
                this.cause = new ThrowableProxy(nested, alreadyProcessedSet);
                this.cause.commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(nested.getStackTrace(), this.stackTraceElementProxyArray);
            }
        }
        if (GET_SUPPRESSED_METHOD != null) {
            Throwable[] throwableSuppressed = extractSupressedThrowables(throwable);
            if (throwableSuppressed.length > 0) {
                List<ThrowableProxy> suppressedList = new ArrayList<>(throwableSuppressed.length);
                for (Throwable sup : throwableSuppressed) {
                    if (alreadyProcessedSet.contains(sup)) {
                        suppressedList.add(new ThrowableProxy(sup, true));
                    } else {
                        ThrowableProxy throwableProxy = new ThrowableProxy(sup, alreadyProcessedSet);
                        throwableProxy.commonFrames = ThrowableProxyUtil.findNumberOfCommonFrames(sup.getStackTrace(), this.stackTraceElementProxyArray);
                        suppressedList.add(throwableProxy);
                    }
                }
                this.suppressed = (ThrowableProxy[]) suppressedList.toArray(new ThrowableProxy[suppressedList.size()]);
            }
        }
    }

    private Throwable[] extractSupressedThrowables(Throwable t) {
        try {
            Object obj = GET_SUPPRESSED_METHOD.invoke(t, new Object[0]);
            if (obj instanceof Throwable[]) {
                return (Throwable[]) obj;
            }
            return null;
        } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
            return null;
        }
    }

    public Throwable getThrowable() {
        return this.throwable;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public String getMessage() {
        return this.message;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public String getClassName() {
        return this.className;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public StackTraceElementProxy[] getStackTraceElementProxyArray() {
        return this.stackTraceElementProxyArray;
    }

    public boolean isCyclic() {
        return this.circular;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public int getCommonFrames() {
        return this.commonFrames;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public IThrowableProxy getCause() {
        return this.cause;
    }

    @Override // p001ch.qos.logback.classic.spi.IThrowableProxy
    public IThrowableProxy[] getSuppressed() {
        return this.suppressed;
    }

    public PackagingDataCalculator getPackagingDataCalculator() {
        if (this.throwable != null && this.packagingDataCalculator == null) {
            this.packagingDataCalculator = new PackagingDataCalculator();
        }
        return this.packagingDataCalculator;
    }

    public void calculatePackagingData() {
        PackagingDataCalculator pdc;
        if (!this.calculatedPackageData && (pdc = getPackagingDataCalculator()) != null) {
            this.calculatedPackageData = true;
            pdc.calculate(this);
        }
    }

    public void fullDump() {
        StringBuilder builder = new StringBuilder();
        StackTraceElementProxy[] stackTraceElementProxyArr = this.stackTraceElementProxyArray;
        for (StackTraceElementProxy step : stackTraceElementProxyArr) {
            builder.append('\t').append(step.toString());
            ThrowableProxyUtil.subjoinPackagingData(builder, step);
            builder.append(CoreConstants.LINE_SEPARATOR);
        }
        System.out.println(builder.toString());
    }
}
