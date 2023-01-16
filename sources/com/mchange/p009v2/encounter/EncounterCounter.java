package com.mchange.p009v2.encounter;

/* renamed from: com.mchange.v2.encounter.EncounterCounter */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/EncounterCounter.class */
public interface EncounterCounter {
    long encounter(Object obj);

    long reset(Object obj);

    void resetAll();
}
