package dev.morphia.aggregation.experimental.stages;

/* loaded from: grasscutter.jar:dev/morphia/aggregation/experimental/stages/CurrentOp.class */
public class CurrentOp extends Stage {
    private boolean allUsers;
    private boolean idleConnections;
    private boolean idleCursors;
    private boolean idleSessions;
    private boolean localOps;

    protected CurrentOp() {
        super("$currentOp");
    }

    public static CurrentOp currentOp() {
        return new CurrentOp();
    }

    @Deprecated(forRemoval = true)
    /* renamed from: of */
    public static CurrentOp m1251of() {
        return new CurrentOp();
    }

    public CurrentOp allUsers(boolean allUsers) {
        this.allUsers = allUsers;
        return this;
    }

    public CurrentOp idleConnections(boolean idleConnections) {
        this.idleConnections = idleConnections;
        return this;
    }

    public CurrentOp idleCursors(boolean idleCursors) {
        this.idleCursors = idleCursors;
        return this;
    }

    public CurrentOp idleSessions(boolean idleSessions) {
        this.idleSessions = idleSessions;
        return this;
    }

    public boolean isAllUsers() {
        return this.allUsers;
    }

    public boolean isIdleConnections() {
        return this.idleConnections;
    }

    public boolean isIdleCursors() {
        return this.idleCursors;
    }

    public boolean isIdleSessions() {
        return this.idleSessions;
    }

    public boolean isLocalOps() {
        return this.localOps;
    }

    public CurrentOp localOps(boolean localOps) {
        this.localOps = localOps;
        return this;
    }
}
