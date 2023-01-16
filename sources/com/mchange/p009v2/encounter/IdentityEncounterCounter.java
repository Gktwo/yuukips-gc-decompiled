package com.mchange.p009v2.encounter;

import com.mchange.p009v2.util.WeakIdentityHashMapFactory;

/* renamed from: com.mchange.v2.encounter.IdentityEncounterCounter */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/IdentityEncounterCounter.class */
public class IdentityEncounterCounter extends AbstractEncounterCounter {
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

    public IdentityEncounterCounter() {
        super(WeakIdentityHashMapFactory.create());
    }
}
