package emu.grasscutter.server.game;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/* loaded from: grasscutter.jar:emu/grasscutter/server/game/Ratelimit.class */
public class Ratelimit {
    private int count = 0;
    private Date time = new Date();
    private int set_count = 0;
    private int set_time = 0;
    private String set_key = "";
    private static final Map<String, Ratelimit> nextWaitCMD = new HashMap();

    private void New() {
        if (nextWaitCMD != null) {
            this.time = new Date(new Date().getTime() + (((long) this.set_time) * 1000));
            this.count = 0;
            nextWaitCMD.replace(this.set_key, this);
        }
    }

    private void Count() {
        if (nextWaitCMD != null) {
            this.count++;
            nextWaitCMD.replace(this.set_key, this);
        }
    }

    public int GetCount() {
        return this.count;
    }

    private Date GetTime() {
        return this.time;
    }

    public long GetMs() {
        return TimeUnit.MILLISECONDS.toSeconds(this.time.getTime() - new Date().getTime());
    }

    public void Set(String key, int time, int count) {
        Ratelimit last = nextWaitCMD.get(key);
        this.set_key = key;
        this.set_time = time;
        this.set_count = count;
        if (last == null) {
            this.time = new Date(new Date().getTime() + (((long) this.set_time) * 1000));
            this.count = 0;
            nextWaitCMD.put(key, this);
            return;
        }
        this.count = last.GetCount();
        this.time = last.GetTime();
    }

    /* renamed from: Is */
    public boolean m1192Is() {
        if (GetMs() <= 0) {
            New();
            return false;
        } else if (GetCount() >= this.set_count) {
            return true;
        } else {
            Count();
            return false;
        }
    }
}
