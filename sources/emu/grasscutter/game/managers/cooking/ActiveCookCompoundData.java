package emu.grasscutter.game.managers.cooking;

import dev.morphia.annotations.Entity;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/cooking/ActiveCookCompoundData.class */
public class ActiveCookCompoundData {
    private final int costTime;
    private final int compoundId;
    private int totalCount;
    private int startTime;

    public int getCompoundId() {
        return this.compoundId;
    }

    public int getTotalCount() {
        return this.totalCount;
    }

    public ActiveCookCompoundData(int compoundId, int processTime, int count, int startTime) {
        this.compoundId = compoundId;
        this.costTime = processTime;
        this.totalCount = count;
        this.startTime = startTime;
    }

    public int getOutputCount(int currentTime) {
        int cnt = (currentTime - this.startTime) / this.costTime;
        return cnt > this.totalCount ? this.totalCount : cnt;
    }

    public int getWaitCount(int currentTime) {
        return this.totalCount - getOutputCount(currentTime);
    }

    public int getOutputTime(int currentTime) {
        int cnt = getOutputCount(currentTime);
        if (cnt == this.totalCount) {
            return 0;
        }
        return this.startTime + ((cnt + 1) * this.costTime);
    }

    public void addCompound(int count, int currentTime) {
        if (getOutputCount(currentTime) == this.totalCount) {
            this.startTime = currentTime - (this.totalCount * this.costTime);
        }
        this.totalCount += count;
    }

    public int takeCompound(int currentTime) {
        int count = getOutputCount(currentTime);
        this.startTime += this.costTime * count;
        this.totalCount -= count;
        return count;
    }
}
