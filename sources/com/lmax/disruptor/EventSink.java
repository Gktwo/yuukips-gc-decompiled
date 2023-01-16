package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventSink.class */
public interface EventSink<E> {
    void publishEvent(EventTranslator<E> eventTranslator);

    boolean tryPublishEvent(EventTranslator<E> eventTranslator);

    <A> void publishEvent(EventTranslatorOneArg<E, A> eventTranslatorOneArg, A a);

    <A> boolean tryPublishEvent(EventTranslatorOneArg<E, A> eventTranslatorOneArg, A a);

    <A, B> void publishEvent(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, A a, B b);

    <A, B> boolean tryPublishEvent(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, A a, B b);

    <A, B, C> void publishEvent(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, A a, B b, C c);

    <A, B, C> boolean tryPublishEvent(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, A a, B b, C c);

    void publishEvent(EventTranslatorVararg<E> eventTranslatorVararg, Object... objArr);

    boolean tryPublishEvent(EventTranslatorVararg<E> eventTranslatorVararg, Object... objArr);

    void publishEvents(EventTranslator<E>[] eventTranslatorArr);

    void publishEvents(EventTranslator<E>[] eventTranslatorArr, int i, int i2);

    boolean tryPublishEvents(EventTranslator<E>[] eventTranslatorArr);

    boolean tryPublishEvents(EventTranslator<E>[] eventTranslatorArr, int i, int i2);

    <A> void publishEvents(EventTranslatorOneArg<E, A> eventTranslatorOneArg, A[] aArr);

    <A> void publishEvents(EventTranslatorOneArg<E, A> eventTranslatorOneArg, int i, int i2, A[] aArr);

    <A> boolean tryPublishEvents(EventTranslatorOneArg<E, A> eventTranslatorOneArg, A[] aArr);

    <A> boolean tryPublishEvents(EventTranslatorOneArg<E, A> eventTranslatorOneArg, int i, int i2, A[] aArr);

    <A, B> void publishEvents(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, A[] aArr, B[] bArr);

    <A, B> void publishEvents(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, int i, int i2, A[] aArr, B[] bArr);

    <A, B> boolean tryPublishEvents(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, A[] aArr, B[] bArr);

    <A, B> boolean tryPublishEvents(EventTranslatorTwoArg<E, A, B> eventTranslatorTwoArg, int i, int i2, A[] aArr, B[] bArr);

    <A, B, C> void publishEvents(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, A[] aArr, B[] bArr, C[] cArr);

    <A, B, C> void publishEvents(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, int i, int i2, A[] aArr, B[] bArr, C[] cArr);

    <A, B, C> boolean tryPublishEvents(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, A[] aArr, B[] bArr, C[] cArr);

    <A, B, C> boolean tryPublishEvents(EventTranslatorThreeArg<E, A, B, C> eventTranslatorThreeArg, int i, int i2, A[] aArr, B[] bArr, C[] cArr);

    void publishEvents(EventTranslatorVararg<E> eventTranslatorVararg, Object[]... objArr);

    void publishEvents(EventTranslatorVararg<E> eventTranslatorVararg, int i, int i2, Object[]... objArr);

    boolean tryPublishEvents(EventTranslatorVararg<E> eventTranslatorVararg, Object[]... objArr);

    boolean tryPublishEvents(EventTranslatorVararg<E> eventTranslatorVararg, int i, int i2, Object[]... objArr);
}
