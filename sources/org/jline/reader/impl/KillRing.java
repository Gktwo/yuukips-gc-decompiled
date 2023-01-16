package org.jline.reader.impl;

/* loaded from: grasscutter.jar:org/jline/reader/impl/KillRing.class */
public final class KillRing {
    private static final int DEFAULT_SIZE = 60;
    private final String[] slots;
    private int head;
    private boolean lastKill;
    private boolean lastYank;

    public KillRing(int size) {
        this.head = 0;
        this.lastKill = false;
        this.lastYank = false;
        this.slots = new String[size];
    }

    public KillRing() {
        this(60);
    }

    public void resetLastYank() {
        this.lastYank = false;
    }

    public void resetLastKill() {
        this.lastKill = false;
    }

    public boolean lastYank() {
        return this.lastYank;
    }

    public void add(String str) {
        this.lastYank = false;
        if (!this.lastKill || this.slots[this.head] == null) {
            this.lastKill = true;
            next();
            this.slots[this.head] = str;
            return;
        }
        StringBuilder sb = new StringBuilder();
        String[] strArr = this.slots;
        int i = this.head;
        strArr[i] = sb.append(strArr[i]).append(str).toString();
    }

    public void addBackwards(String str) {
        this.lastYank = false;
        if (!this.lastKill || this.slots[this.head] == null) {
            this.lastKill = true;
            next();
            this.slots[this.head] = str;
            return;
        }
        this.slots[this.head] = str + this.slots[this.head];
    }

    public String yank() {
        this.lastKill = false;
        this.lastYank = true;
        return this.slots[this.head];
    }

    public String yankPop() {
        this.lastKill = false;
        if (!this.lastYank) {
            return null;
        }
        prev();
        return this.slots[this.head];
    }

    private void next() {
        if (this.head != 0 || this.slots[0] != null) {
            this.head++;
            if (this.head == this.slots.length) {
                this.head = 0;
            }
        }
    }

    private void prev() {
        this.head--;
        if (this.head == -1) {
            int x = this.slots.length - 1;
            while (x >= 0 && this.slots[x] == null) {
                x--;
            }
            this.head = x;
        }
    }
}
