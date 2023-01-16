package com.mchange.p009v2.encounter;

import java.util.HashMap;

/* renamed from: com.mchange.v2.encounter.StrongEqualityEncounterCounter */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/StrongEqualityEncounterCounter.class */
public class StrongEqualityEncounterCounter extends AbstractEncounterCounter {
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

    public StrongEqualityEncounterCounter() {
        super(new HashMap());
    }
}
