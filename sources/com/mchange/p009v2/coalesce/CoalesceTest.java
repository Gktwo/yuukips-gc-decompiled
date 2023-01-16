package com.mchange.p009v2.coalesce;

/* renamed from: com.mchange.v2.coalesce.CoalesceTest */
/* loaded from: grasscutter.jar:com/mchange/v2/coalesce/CoalesceTest.class */
public class CoalesceTest {
    static final int NUM_ITERS = 10000;

    /* renamed from: c */
    static final Coalescer f413c = CoalescerFactory.createCoalescer(null, true, true);

    public static void main(String[] strArr) {
        doTest();
        System.gc();
        System.err.println("num coalesced after gc: " + f413c.countCoalesced());
    }

    private static void doTest() {
        String[] strArr = new String[10000];
        for (int i = 0; i < 10000; i++) {
            strArr[i] = new String("Hello");
        }
        long currentTimeMillis = System.currentTimeMillis();
        for (int i2 = 0; i2 < 10000; i2++) {
            f413c.coalesce(strArr[i2]);
        }
        System.out.println("avg time: " + (((float) (System.currentTimeMillis() - currentTimeMillis)) / 10000.0f) + "ms (10000 iterations)");
        System.err.println("num coalesced: " + f413c.countCoalesced());
    }
}
