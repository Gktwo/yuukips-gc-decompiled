package com.mchange.p009v2.encounter;

import java.util.Map;

/* renamed from: com.mchange.v2.encounter.AbstractEncounterCounter */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/AbstractEncounterCounter.class */
class AbstractEncounterCounter implements EncounterCounter {
    static final Long ONE = new Long(1);

    /* renamed from: m */
    Map f421m;

    /* access modifiers changed from: package-private */
    public AbstractEncounterCounter(Map map) {
        this.f421m = map;
    }

    /* JADX WARN: Type inference failed for: r0v10, types: [long] */
    @Override // com.mchange.p009v2.encounter.EncounterCounter
    public long encounter(Object obj) {
        char c;
        Long l;
        Long l2 = (Long) this.f421m.get(obj);
        if (l2 == null) {
            c = 0;
            l = ONE;
        } else {
            c = l2.longValue();
            l = new Long(c + 1);
        }
        this.f421m.put(obj, l);
        return c;
    }

    @Override // com.mchange.p009v2.encounter.EncounterCounter
    public long reset(Object obj) {
        long encounter = encounter(obj);
        this.f421m.remove(obj);
        return encounter;
    }

    @Override // com.mchange.p009v2.encounter.EncounterCounter
    public void resetAll() {
        this.f421m.clear();
    }
}
