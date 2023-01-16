package com.lmax.disruptor;

/* loaded from: grasscutter.jar:com/lmax/disruptor/EventPoller.class */
public class EventPoller<T> {
    private final DataProvider<T> dataProvider;
    private final Sequencer sequencer;
    private final Sequence sequence;
    private final Sequence gatingSequence;

    /* loaded from: grasscutter.jar:com/lmax/disruptor/EventPoller$Handler.class */
    public interface Handler<T> {
        boolean onEvent(T t, long j, boolean z) throws Exception;
    }

    /* loaded from: grasscutter.jar:com/lmax/disruptor/EventPoller$PollState.class */
    public enum PollState {
        PROCESSING,
        GATING,
        IDLE
    }

    public EventPoller(DataProvider<T> dataProvider, Sequencer sequencer, Sequence sequence, Sequence gatingSequence) {
        this.dataProvider = dataProvider;
        this.sequencer = sequencer;
        this.sequence = sequence;
        this.gatingSequence = gatingSequence;
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r0v4, types: [long] */
    /* JADX WARN: Type inference failed for: r0v27, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.lmax.disruptor.EventPoller.PollState poll(com.lmax.disruptor.EventPoller.Handler<T> r10) throws java.lang.Exception {
        /*
            r9 = this;
            r0 = r9
            com.lmax.disruptor.Sequence r0 = r0.sequence
            long r0 = r0.get()
            r11 = r0
            r0 = r11
            r1 = 1
            long r0 = r0 + r1
            r13 = r0
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            r1 = r13
            r2 = r9
            com.lmax.disruptor.Sequence r2 = r2.gatingSequence
            long r2 = r2.get()
            long r0 = r0.getHighestPublishedSequence(r1, r2)
            r15 = r0
            r0 = r13
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0087
            r0 = r11
            r18 = r0
        L_0x002c:
            r0 = r9
            com.lmax.disruptor.DataProvider<T> r0 = r0.dataProvider     // Catch: all -> 0x0075
            r1 = r13
            java.lang.Object r0 = r0.get(r1)     // Catch: all -> 0x0075
            r20 = r0
            r0 = r10
            r1 = r20
            r2 = r13
            r3 = r13
            r4 = r15
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 != 0) goto L_0x004a
            r3 = 1
            goto L_0x004b
        L_0x004a:
            r3 = 0
        L_0x004b:
            boolean r0 = r0.onEvent(r1, r2, r3)     // Catch: all -> 0x0075
            r17 = r0
            r0 = r13
            r18 = r0
            r0 = r13
            r1 = 1
            long r0 = r0 + r1
            r13 = r0
            r0 = r13
            r1 = r15
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 > 0) goto L_0x0069
            r0 = r17
            if (r0 != 0) goto L_0x002c
        L_0x0069:
            r0 = r9
            com.lmax.disruptor.Sequence r0 = r0.sequence
            r1 = r18
            r0.set(r1)
            goto L_0x0083
        L_0x0075:
            r21 = move-exception
            r0 = r9
            com.lmax.disruptor.Sequence r0 = r0.sequence
            r1 = r18
            r0.set(r1)
            r0 = r21
            throw r0
        L_0x0083:
            com.lmax.disruptor.EventPoller$PollState r0 = com.lmax.disruptor.EventPoller.PollState.PROCESSING
            return r0
        L_0x0087:
            r0 = r9
            com.lmax.disruptor.Sequencer r0 = r0.sequencer
            long r0 = r0.getCursor()
            r1 = r13
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 < 0) goto L_0x009a
            com.lmax.disruptor.EventPoller$PollState r0 = com.lmax.disruptor.EventPoller.PollState.GATING
            return r0
        L_0x009a:
            com.lmax.disruptor.EventPoller$PollState r0 = com.lmax.disruptor.EventPoller.PollState.IDLE
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.lmax.disruptor.EventPoller.poll(com.lmax.disruptor.EventPoller$Handler):com.lmax.disruptor.EventPoller$PollState");
    }

    public static <T> EventPoller<T> newInstance(DataProvider<T> dataProvider, Sequencer sequencer, Sequence sequence, Sequence cursorSequence, Sequence... gatingSequences) {
        Sequence gatingSequence;
        if (gatingSequences.length == 0) {
            gatingSequence = cursorSequence;
        } else if (gatingSequences.length == 1) {
            gatingSequence = gatingSequences[0];
        } else {
            gatingSequence = new FixedSequenceGroup(gatingSequences);
        }
        return new EventPoller<>(dataProvider, sequencer, sequence, gatingSequence);
    }

    public Sequence getSequence() {
        return this.sequence;
    }
}
