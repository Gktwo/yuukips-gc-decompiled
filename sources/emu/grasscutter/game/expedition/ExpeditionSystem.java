package emu.grasscutter.game.expedition;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/expedition/ExpeditionSystem.class */
public class ExpeditionSystem extends BaseGameSystem {
    private final Int2ObjectMap<List<ExpeditionRewardDataList>> expeditionRewardData = new Int2ObjectOpenHashMap();

    public ExpeditionSystem(GameServer server) {
        super(server);
        load();
    }

    public Int2ObjectMap<List<ExpeditionRewardDataList>> getExpeditionRewardDataList() {
        return this.expeditionRewardData;
    }

    public synchronized void load() {
        getExpeditionRewardDataList().clear();
        try {
            List<ExpeditionRewardInfo> banners = DataLoader.loadList("ExpeditionReward.json", ExpeditionRewardInfo.class);
            if (banners.size() > 0) {
                for (ExpeditionRewardInfo di : banners) {
                    getExpeditionRewardDataList().put(di.getExpId(), (int) di.getExpeditionRewardDataList());
                }
                Grasscutter.getLogger().debug("Expedition reward successfully loaded.");
            } else {
                Grasscutter.getLogger().error("Unable to load expedition reward. Expedition reward size is 0.");
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load expedition reward.", (Throwable) e);
        }
    }
}
