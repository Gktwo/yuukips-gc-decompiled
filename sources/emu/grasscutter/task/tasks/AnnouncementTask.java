package emu.grasscutter.task.tasks;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.systems.AnnouncementSystem;
import emu.grasscutter.task.Task;
import emu.grasscutter.task.TaskHandler;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@Task(taskName = "Announcement", taskCronExpression = "0 * * * * ?", triggerName = "AnnouncementTrigger")
/* loaded from: grasscutter.jar:emu/grasscutter/task/tasks/AnnouncementTask.class */
public final class AnnouncementTask extends TaskHandler {
    static Map<Integer, Integer> intervalMap = new ConcurrentHashMap();

    @Override // emu.grasscutter.task.TaskHandler
    public void onEnable() {
        Grasscutter.getLogger().debug("[Task] Announcement task enabled.");
    }

    @Override // emu.grasscutter.task.TaskHandler
    public void onDisable() {
        Grasscutter.getLogger().debug("[Task] Announcement task disabled.");
    }

    @Override // org.quartz.Job
    public synchronized void execute(JobExecutionContext context) throws JobExecutionException {
        if (Grasscutter.getRunMode() != Grasscutter.ServerRunMode.DISPATCH_ONLY) {
            Date current = new Date();
            Map<Integer, AnnouncementSystem.AnnounceConfigItem> announceConfigItems = (Map) Grasscutter.getGameServer().getAnnouncementSystem().getAnnounceConfigItemMap().values().stream().filter((v0) -> {
                return v0.isTick();
            }).filter(i -> {
                return current.after(i.getBeginTime());
            }).filter(i -> {
                return current.before(i.getEndTime());
            }).collect(Collectors.toMap((v0) -> {
                return v0.getTemplateId();
            }, y -> {
                return y;
            }));
            announceConfigItems.values().forEach(i -> {
                intervalMap.compute(Integer.valueOf(i.getTemplateId()), k, v -> {
                    return Integer.valueOf(v == null ? 1 : v.intValue() + 1);
                });
            });
            List<AnnouncementSystem.AnnounceConfigItem> toSend = intervalMap.entrySet().stream().filter(i -> {
                return announceConfigItems.containsKey(i.getKey());
            }).filter(i -> {
                return ((Integer) i.getValue()).intValue() >= ((AnnouncementSystem.AnnounceConfigItem) announceConfigItems.get(i.getKey())).getInterval();
            }).map(i -> {
                return (AnnouncementSystem.AnnounceConfigItem) announceConfigItems.get(i.getKey());
            }).toList();
            Grasscutter.getGameServer().getAnnouncementSystem().broadcast(toSend);
            Grasscutter.getLogger().debug("Broadcast {} announcement(s) to all online players", Integer.valueOf(toSend.size()));
            toSend.forEach(i -> {
                intervalMap.put(Integer.valueOf(i.getTemplateId()), 0);
            });
        }
    }
}
