package p001ch.qos.logback.core.util;

/* access modifiers changed from: package-private */
/* renamed from: ch.qos.logback.core.util.CharSequenceState */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/CharSequenceState.class */
public class CharSequenceState {

    /* renamed from: c */
    final char f20c;
    int occurrences = 1;

    public CharSequenceState(char c) {
        this.f20c = c;
    }

    /* access modifiers changed from: package-private */
    public void incrementOccurrences() {
        this.occurrences++;
    }
}
