package edu.umd.p012cs.findbugs.annotations;

@Deprecated
/* renamed from: edu.umd.cs.findbugs.annotations.Priority */
/* loaded from: grasscutter.jar:edu/umd/cs/findbugs/annotations/Priority.class */
public enum Priority {
    HIGH(1),
    MEDIUM(2),
    LOW(3),
    IGNORE(5);
    
    private final int priorityValue;

    public int getPriorityValue() {
        return this.priorityValue;
    }

    Priority(int p) {
        this.priorityValue = p;
    }
}
