package com.mongodb.internal.operation;

/* loaded from: grasscutter.jar:com/mongodb/internal/operation/MapReduceStatistics.class */
public class MapReduceStatistics {
    private final int inputCount;
    private final int outputCount;
    private final int emitCount;
    private final int duration;

    public MapReduceStatistics(int inputCount, int outputCount, int emitCount, int duration) {
        this.inputCount = inputCount;
        this.outputCount = outputCount;
        this.emitCount = emitCount;
        this.duration = duration;
    }

    public int getInputCount() {
        return this.inputCount;
    }

    public int getOutputCount() {
        return this.outputCount;
    }

    public int getEmitCount() {
        return this.emitCount;
    }

    public int getDuration() {
        return this.duration;
    }
}
