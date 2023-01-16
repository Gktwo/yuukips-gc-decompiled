package org.quartz.utils.counter.sampled;

/* loaded from: grasscutter.jar:org/quartz/utils/counter/sampled/SampledRateCounterImpl.class */
public class SampledRateCounterImpl extends SampledCounterImpl implements SampledRateCounter {
    private static final long serialVersionUID = 6531350452676920607L;
    private static final String OPERATION_NOT_SUPPORTED_MSG = "This operation is not supported. Use SampledCounter Or Counter instead";
    private long numeratorValue;
    private long denominatorValue;

    public SampledRateCounterImpl(SampledRateCounterConfig config) {
        super(config);
    }

    @Override // org.quartz.utils.counter.sampled.SampledRateCounter
    public synchronized void setValue(long numerator, long denominator) {
        this.numeratorValue = numerator;
        this.denominatorValue = denominator;
    }

    @Override // org.quartz.utils.counter.sampled.SampledRateCounter
    public synchronized void increment(long numerator, long denominator) {
        this.numeratorValue += numerator;
        this.denominatorValue += denominator;
    }

    @Override // org.quartz.utils.counter.sampled.SampledRateCounter
    public synchronized void decrement(long numerator, long denominator) {
        this.numeratorValue -= numerator;
        this.denominatorValue -= denominator;
    }

    @Override // org.quartz.utils.counter.sampled.SampledRateCounter
    public synchronized void setDenominatorValue(long newValue) {
        this.denominatorValue = newValue;
    }

    @Override // org.quartz.utils.counter.sampled.SampledRateCounter
    public synchronized void setNumeratorValue(long newValue) {
        this.numeratorValue = newValue;
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public synchronized long getValue() {
        if (this.denominatorValue == 0) {
            return 0;
        }
        return this.numeratorValue / this.denominatorValue;
    }

    @Override // org.quartz.utils.counter.sampled.SampledCounterImpl, org.quartz.utils.counter.sampled.SampledCounter
    public synchronized long getAndReset() {
        long prevVal = getValue();
        setValue(0, 0);
        return prevVal;
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public long getAndSet(long newValue) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public synchronized void setValue(long newValue) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public long decrement() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public long decrement(long amount) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    public long getMaxValue() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    public long getMinValue() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public long increment() {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }

    @Override // org.quartz.utils.counter.CounterImpl, org.quartz.utils.counter.Counter
    public long increment(long amount) {
        throw new UnsupportedOperationException(OPERATION_NOT_SUPPORTED_MSG);
    }
}
