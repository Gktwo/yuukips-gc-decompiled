package emu.grasscutter.database;

import dev.morphia.annotations.AbstractC1283Id;
import dev.morphia.annotations.Entity;

@Entity(value = "counters", useDiscriminator = false)
/* loaded from: grasscutter.jar:emu/grasscutter/database/DatabaseCounter.class */
public class DatabaseCounter {
    @AbstractC1283Id

    /* renamed from: id */
    private String f556id;
    private int count;

    public DatabaseCounter() {
    }

    public DatabaseCounter(String id) {
        this.f556id = id;
        this.count = 10000;
    }

    public int getNextId() {
        int id = this.count + 1;
        this.count = id;
        return id;
    }

    public int getCounter() {
        return this.count;
    }

    public int setCounter(int count) {
        this.count = count;
        return count;
    }
}
