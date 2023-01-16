package com.lmax.disruptor;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;

/* loaded from: grasscutter.jar:com/lmax/disruptor/SequenceGroups.class */
class SequenceGroups {
    SequenceGroups() {
    }

    /* access modifiers changed from: package-private */
    public static <T> void addSequences(T holder, AtomicReferenceFieldUpdater<T, Sequence[]> updater, Cursored cursor, Sequence... sequencesToAdd) {
        Sequence[] currentSequences;
        Sequence[] updatedSequences;
        do {
            currentSequences = updater.get(holder);
            updatedSequences = (Sequence[]) Arrays.copyOf(currentSequences, currentSequences.length + sequencesToAdd.length);
            long cursorSequence = cursor.getCursor();
            int index = currentSequences.length;
            for (Sequence sequence : sequencesToAdd) {
                sequence.set(cursorSequence);
                index++;
                updatedSequences[index] = sequence;
            }
        } while (!updater.compareAndSet(holder, currentSequences, updatedSequences));
        long cursorSequence2 = cursor.getCursor();
        for (Sequence sequence2 : sequencesToAdd) {
            sequence2.set(cursorSequence2);
        }
    }

    /* access modifiers changed from: package-private */
    public static <T> boolean removeSequence(T holder, AtomicReferenceFieldUpdater<T, Sequence[]> sequenceUpdater, Sequence sequence) {
        Sequence[] oldSequences;
        int numToRemove;
        Sequence[] newSequences;
        do {
            oldSequences = sequenceUpdater.get(holder);
            numToRemove = countMatching(oldSequences, sequence);
            if (0 == numToRemove) {
                break;
            }
            int oldSize = oldSequences.length;
            newSequences = new Sequence[oldSize - numToRemove];
            int pos = 0;
            for (Sequence testSequence : oldSequences) {
                if (sequence != testSequence) {
                    pos++;
                    newSequences[pos] = testSequence;
                }
            }
        } while (!sequenceUpdater.compareAndSet(holder, oldSequences, newSequences));
        return numToRemove != 0;
    }

    private static <T> int countMatching(T[] values, T toMatch) {
        int numToRemove = 0;
        for (T value : values) {
            if (value == toMatch) {
                numToRemove++;
            }
        }
        return numToRemove;
    }
}
