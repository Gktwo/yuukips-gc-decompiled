package emu.grasscutter.game.dailytask;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.DailyTaskInfoOuterClass;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/dailytask/DailyTask.class */
public class DailyTask {
    private int rewardId;
    private int taskId;
    private int finishProgress;
    private int progress;
    private boolean finished;

    public int getRewardId() {
        return this.rewardId;
    }

    public int getTaskId() {
        return this.taskId;
    }

    public int getFinishProgress() {
        return this.finishProgress;
    }

    public int getProgress() {
        return this.progress;
    }

    public boolean isFinished() {
        return this.finished;
    }

    public DailyTask(int rewardId, int taskId, int finishProgress, int progress) {
        this.rewardId = rewardId;
        this.taskId = taskId;
        this.finishProgress = finishProgress;
        this.progress = progress;
    }

    public void finish() {
        if (!this.finished) {
            this.finished = true;
            this.progress = this.finishProgress;
        }
    }

    public DailyTaskInfoOuterClass.DailyTaskInfo toProto() {
        return DailyTaskInfoOuterClass.DailyTaskInfo.newBuilder().setRewardId(this.rewardId).setDailyTaskId(this.taskId).setFinishProgress(this.finishProgress).setProgress(this.progress).setIsFinished(this.finished).build();
    }
}
