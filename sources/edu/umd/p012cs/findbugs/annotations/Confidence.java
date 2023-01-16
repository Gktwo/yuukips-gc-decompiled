package edu.umd.p012cs.findbugs.annotations;

/* renamed from: edu.umd.cs.findbugs.annotations.Confidence */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/Confidence.class */
public enum Confidence {
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    IGNORE(5);
    
    private final int confidenceValue;

    @NonNull
    public static Confidence getConfidence(int prio) {
        Confidence[] values = values();
        for (Confidence c : values) {
            if (prio <= c.confidenceValue) {
                return c;
            }
        }
        return IGNORE;
    }

    public int getConfidenceValue() {
        return this.confidenceValue;
    }

    Confidence(int p) {
        this.confidenceValue = p;
    }
}
