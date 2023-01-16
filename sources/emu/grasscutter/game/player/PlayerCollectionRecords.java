package emu.grasscutter.game.player;

import dev.morphia.annotations.Entity;
import java.util.HashMap;
import java.util.Map;

@Entity(useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerCollectionRecords.class */
public class PlayerCollectionRecords {
    private Map<Integer, CollectionRecord> records;

    private Map<Integer, CollectionRecord> getRecords() {
        if (this.records == null) {
            this.records = new HashMap();
        }
        return this.records;
    }

    public void addRecord(int configId, long expiredMillisecond) {
        Map<Integer, CollectionRecord> records = getRecords();
        synchronized (records) {
            records.put(Integer.valueOf(configId), new CollectionRecord(configId, expiredMillisecond + System.currentTimeMillis()));
        }
    }

    public boolean findRecord(int configId) {
        Map<Integer, CollectionRecord> records = getRecords();
        synchronized (records) {
            CollectionRecord record = records.get(Integer.valueOf(configId));
            if (record == null) {
                return false;
            }
            if (!(record.getExpiredTime() < System.currentTimeMillis())) {
                return true;
            }
            records.remove(Integer.valueOf(configId));
            return false;
        }
    }

    @Entity
    /* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerCollectionRecords$CollectionRecord.class */
    public static class CollectionRecord {
        private int configId;
        private long expiredTime;

        @Deprecated(forRemoval = true)
        public CollectionRecord() {
        }

        public CollectionRecord(int configId, long expiredTime) {
            this.configId = configId;
            this.expiredTime = expiredTime;
        }

        public int getConfigId() {
            return this.configId;
        }

        public long getExpiredTime() {
            return this.expiredTime;
        }
    }
}
