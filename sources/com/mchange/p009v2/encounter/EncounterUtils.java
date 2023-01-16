package com.mchange.p009v2.encounter;

import com.mchange.p006v1.identicator.IdHashMap;
import com.mchange.p006v1.identicator.IdWeakHashMap;
import com.mchange.p006v1.identicator.Identicator;

/* renamed from: com.mchange.v2.encounter.EncounterUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/encounter/EncounterUtils.class */
public final class EncounterUtils {
    public static EncounterCounter createStrong(Identicator identicator) {
        return new GenericEncounterCounter(new IdHashMap(identicator));
    }

    public static EncounterCounter createWeak(Identicator identicator) {
        return new GenericEncounterCounter(new IdWeakHashMap(identicator));
    }

    public static EncounterCounter syncWrap(final EncounterCounter encounterCounter) {
        return new EncounterCounter() { // from class: com.mchange.v2.encounter.EncounterUtils.1
            @Override // com.mchange.p009v2.encounter.EncounterCounter
            public synchronized long encounter(Object obj) {
                return encounterCounter.encounter(obj);
            }

            @Override // com.mchange.p009v2.encounter.EncounterCounter
            public synchronized long reset(Object obj) {
                return encounterCounter.reset(obj);
            }

            @Override // com.mchange.p009v2.encounter.EncounterCounter
            public synchronized void resetAll() {
                encounterCounter.resetAll();
            }
        };
    }

    private EncounterUtils() {
    }
}
