package p001ch.qos.logback.core.recovery;

/* renamed from: ch.qos.logback.core.recovery.RecoveryCoordinator */
/* loaded from: grasscutter.jar:ch/qos/logback/core/recovery/RecoveryCoordinator.class */
public class RecoveryCoordinator {
    public static final long BACKOFF_COEFFICIENT_MIN = 20;
    public static final long BACKOFF_MULTIPLIER = 4;
    private long backOffCoefficient;
    private long currentTime;
    private long next;
    static long BACKOFF_COEFFICIENT_MAX = 327680;
    private static long UNSET = -1;

    public RecoveryCoordinator() {
        this.backOffCoefficient = 20;
        this.currentTime = UNSET;
        this.next = getCurrentTime() + getBackoffCoefficient();
    }

    public RecoveryCoordinator(long currentTime) {
        this.backOffCoefficient = 20;
        this.currentTime = UNSET;
        this.currentTime = currentTime;
        this.next = getCurrentTime() + getBackoffCoefficient();
    }

    public boolean isTooSoon() {
        long now = getCurrentTime();
        if (now <= this.next) {
            return true;
        }
        this.next = now + getBackoffCoefficient();
        return false;
    }

    void setCurrentTime(long forcedTime) {
        this.currentTime = forcedTime;
    }

    private long getCurrentTime() {
        if (this.currentTime != UNSET) {
            return this.currentTime;
        }
        return System.currentTimeMillis();
    }

    private long getBackoffCoefficient() {
        long currentCoeff = this.backOffCoefficient;
        if (this.backOffCoefficient < BACKOFF_COEFFICIENT_MAX) {
            this.backOffCoefficient *= 4;
        }
        return currentCoeff;
    }
}
