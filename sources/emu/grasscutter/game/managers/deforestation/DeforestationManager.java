package emu.grasscutter.game.managers.deforestation;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.GameData;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.HitTreeNotifyOuterClass;
import emu.grasscutter.net.proto.VectorOuterClass;
import emu.grasscutter.utils.Position;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/deforestation/DeforestationManager.class */
public class DeforestationManager extends BasePlayerManager {
    static final int RECORD_EXPIRED_SECONDS = 300;
    static final int RECORD_MAX_TIMES = 3;
    static final int RECORD_MAX_TIMES_OTHER_HIT_TREE = 10;
    private final ArrayList<HitTreeRecord> currentRecord = new ArrayList<>();
    private static final HashMap<Integer, Integer> ColliderTypeToWoodItemID = new HashMap<>();

    static {
        ColliderTypeToWoodItemID.put(1, 101301);
        ColliderTypeToWoodItemID.put(2, 101302);
        ColliderTypeToWoodItemID.put(3, 101303);
        ColliderTypeToWoodItemID.put(4, 101304);
        ColliderTypeToWoodItemID.put(5, 101305);
        ColliderTypeToWoodItemID.put(6, 101306);
        ColliderTypeToWoodItemID.put(7, 101307);
        ColliderTypeToWoodItemID.put(8, 101308);
        ColliderTypeToWoodItemID.put(9, 101309);
        ColliderTypeToWoodItemID.put(10, 101310);
        ColliderTypeToWoodItemID.put(11, 101311);
        ColliderTypeToWoodItemID.put(12, 101312);
        ColliderTypeToWoodItemID.put(13, 101313);
        ColliderTypeToWoodItemID.put(14, 101314);
        ColliderTypeToWoodItemID.put(15, 101315);
        ColliderTypeToWoodItemID.put(16, 101316);
        ColliderTypeToWoodItemID.put(17, 101317);
    }

    public DeforestationManager(Player player) {
        super(player);
    }

    public void resetWood() {
        synchronized (this.currentRecord) {
            this.currentRecord.clear();
        }
    }

    public void onDeforestationInvoke(HitTreeNotifyOuterClass.HitTreeNotify hit) {
        synchronized (this.currentRecord) {
            VectorOuterClass.Vector hitPosition = hit.getTreePos();
            int woodType = hit.getTreeType();
            if (ColliderTypeToWoodItemID.containsKey(Integer.valueOf(woodType))) {
                Scene scene = this.player.getScene();
                int itemId = ColliderTypeToWoodItemID.get(Integer.valueOf(woodType)).intValue();
                int positionHash = hitPosition.hashCode();
                HitTreeRecord record = searchRecord(positionHash);
                if (record == null) {
                    record = new HitTreeRecord(positionHash);
                } else {
                    this.currentRecord.remove(record);
                }
                this.currentRecord.add(record);
                if (this.currentRecord.size() > 10) {
                    this.currentRecord.remove(0);
                }
                if (record.record()) {
                    scene.addEntity(new EntityItem(scene, null, GameData.getItemDataMap().get(itemId), new Position(hitPosition.getX(), hitPosition.getY(), hitPosition.getZ()), 1, false));
                }
            } else {
                Grasscutter.getLogger().warn("No wood type {} found.", Integer.valueOf(woodType));
            }
        }
    }

    private HitTreeRecord searchRecord(int id) {
        Iterator<HitTreeRecord> it = this.currentRecord.iterator();
        while (it.hasNext()) {
            HitTreeRecord record = it.next();
            if (record.getUnique() == id) {
                return record;
            }
        }
        return null;
    }
}
