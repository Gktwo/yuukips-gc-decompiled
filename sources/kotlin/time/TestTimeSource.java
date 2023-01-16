package kotlin.time;

import kotlin.Metadata;
import kotlin.SinceKotlin;

/* compiled from: TimeSources.kt */
@SinceKotlin(version = "1.3")
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n��\n\u0002\u0010\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018��2\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001��¢\u0006\u0004\b\t\u0010\nJ\u001b\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002ø\u0001��¢\u0006\u0004\b\f\u0010\nJ\b\u0010\r\u001a\u00020\u0004H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n��\u0002\u0004\n\u0002\b\u0019¨\u0006\u000e"}, m373d2 = {"Lkotlin/time/TestTimeSource;", "Lkotlin/time/AbstractLongTimeSource;", "()V", "reading", "", "overflow", "", "duration", "Lkotlin/time/Duration;", "overflow-LRDsOJo", "(J)V", "plusAssign", "plusAssign-LRDsOJo", "read", "kotlin-stdlib"})
@ExperimentalTime
/* loaded from: grasscutter.jar:kotlin/time/TestTimeSource.class */
public final class TestTimeSource extends AbstractLongTimeSource {
    private long reading;

    public TestTimeSource() {
        super(DurationUnit.NANOSECONDS);
    }

    @Override // kotlin.time.AbstractLongTimeSource
    protected long read() {
        return this.reading;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v4 */
    /* JADX WARN: Type inference failed for: r1v22, types: [long] */
    /* JADX WARN: Type inference failed for: r1v27 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* renamed from: plusAssign-LRDsOJo  reason: not valid java name */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void m8584plusAssignLRDsOJo(long r7) {
        /*
            r6 = this;
            r0 = r7
            r1 = r6
            kotlin.time.DurationUnit r1 = r1.getUnit()
            long r0 = kotlin.time.Duration.m8477toLongimpl(r0, r1)
            r9 = r0
            r0 = r6
            r1 = r9
            r2 = -9223372036854775808
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0043
            r1 = r9
            r2 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 == 0) goto L_0x0043
            r1 = r6
            long r1 = r1.reading
            r2 = r9
            long r1 = r1 + r2
            r11 = r1
            r1 = r6
            long r1 = r1.reading
            r2 = r9
            long r1 = r1 ^ r2
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 < 0) goto L_0x003e
            r1 = r6
            long r1 = r1.reading
            r2 = r11
            long r1 = r1 ^ r2
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x003e
            r1 = r6
            r2 = r7
            r1.m8585overflowLRDsOJo(r2)
        L_0x003e:
            r1 = r11
            goto L_0x0071
        L_0x0043:
            r1 = r7
            r2 = r6
            kotlin.time.DurationUnit r2 = r2.getUnit()
            double r1 = kotlin.time.Duration.m8476toDoubleimpl(r1, r2)
            r11 = r1
            r1 = r6
            long r1 = r1.reading
            double r1 = (double) r1
            r2 = r11
            double r1 = r1 + r2
            r13 = r1
            r1 = r13
            r2 = 4890909195324358656(0x43e0000000000000, double:9.223372036854776E18)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 > 0) goto L_0x0069
            r1 = r13
            r2 = -4332462841530417152(0xc3e0000000000000, double:-9.223372036854776E18)
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 >= 0) goto L_0x006e
        L_0x0069:
            r1 = r6
            r2 = r7
            r1.m8585overflowLRDsOJo(r2)
        L_0x006e:
            r1 = r13
            long r1 = (long) r1
        L_0x0071:
            r0.reading = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.time.TestTimeSource.m8584plusAssignLRDsOJo(long):void");
    }

    /* renamed from: overflow-LRDsOJo  reason: not valid java name */
    private final void m8585overflowLRDsOJo(long duration) {
        throw new IllegalStateException("TestTimeSource will overflow if its reading " + this.reading + "ns is advanced by " + ((Object) Duration.m8495toStringimpl(duration)) + '.');
    }
}
