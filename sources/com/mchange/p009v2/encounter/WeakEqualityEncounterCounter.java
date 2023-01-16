package com.mchange.p009v2.encounter;

import java.util.WeakHashMap;

/* renamed from: com.mchange.v2.encounter.WeakEqualityEncounterCounter */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/WeakEqualityEncounterCounter.class */
public class WeakEqualityEncounterCounter extends AbstractEncounterCounter {
    @Override // com.mchange.p009v2.encounter.AbstractEncounterCounter, com.mchange.p009v2.encounter.EncounterCounter
    public /* bridge */ /* synthetic */ void resetAll() {
        resetAll();
    }

    @Override // com.mchange.p009v2.encounter.AbstractEncounterCounter, com.mchange.p009v2.encounter.EncounterCounter
    public /* bridge */ /* synthetic */ long reset(Object obj) {
        return reset(obj);
    }

    @Override // com.mchange.p009v2.encounter.AbstractEncounterCounter, com.mchange.p009v2.encounter.EncounterCounter
    public /* bridge */ /* synthetic */ long encounter(Object obj) {
        return encounter(obj);
    }

    public WeakEqualityEncounterCounter() {
        super(new WeakHashMap());
    }
}
