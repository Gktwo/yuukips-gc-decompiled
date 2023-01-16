package dev.morphia.mapping;

import java.time.ZoneId;

/* loaded from: grasscutter.jar:dev/morphia/mapping/DateStorage.class */
public enum DateStorage {
    UTC {
        @Override // dev.morphia.mapping.DateStorage
        public ZoneId getZone() {
            return ZoneId.of("UTC");
        }
    },
    SYSTEM_DEFAULT {
        @Override // dev.morphia.mapping.DateStorage
        public ZoneId getZone() {
            return ZoneId.systemDefault();
        }
    };

    public abstract ZoneId getZone();
}
