package emu.grasscutter.game.drop;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.game.entity.EntityItem;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.utils.Position;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/drop/DropSystemLegacy.class */
public class DropSystemLegacy extends BaseGameSystem {
    private final List<Integer> DropInfo = new ArrayList();
    private final Int2ObjectMap<List<DropData>> dropData = new Int2ObjectOpenHashMap();

    public DropSystemLegacy(GameServer server) {
        super(server);
        load();
    }

    public Int2ObjectMap<List<DropData>> getDropData() {
        return this.dropData;
    }

    public synchronized void load() {
        getDropData().clear();
        try {
            List<DropInfo> banners = DataLoader.loadList("Drop.json", DropInfo.class);
            if (banners.size() > 0) {
                for (DropInfo di : banners) {
                    getDropData().put(di.getMonsterId(), (int) di.getDropDataList());
                    this.DropInfo.add(Integer.valueOf(di.getMonsterId()));
                }
                Grasscutter.getLogger().info("Loaded {} Drop Data", Integer.valueOf(getDropData().size()));
            } else {
                Grasscutter.getLogger().error("Unable to load drop data. Drop data size is 0.");
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load drop data.", (Throwable) e);
        }
    }

    private void addDropEntity(DropData dd, Scene dropScene, ItemData itemData, Position pos, int num, Player target) {
        if (!dd.isGive() && (itemData.getItemType() != ItemType.ITEM_VIRTUAL || itemData.getGadgetId() != 0)) {
            EntityItem entity = new EntityItem(dropScene, target, itemData, pos, num, dd.isShare());
            if (!dd.isShare()) {
                dropScene.addEntityToSingleClient(target, entity);
            } else {
                dropScene.addEntity(entity);
            }
        } else if (target != null) {
            target.getInventory().addItem(new GameItem(itemData, num), ActionReason.SubfieldDrop, true);
        } else {
            dropScene.getPlayers().forEach(x -> {
                x.getInventory().addItem(new GameItem(itemData, num), ActionReason.SubfieldDrop, true);
            });
        }
    }

    private void processDrop(DropData dd, EntityMonster em, Player gp) {
        int target = Utils.randomRange(1, 10000);
        if (target >= dd.getMinWeight() && target < dd.getMaxWeight()) {
            ItemData itemData = GameData.getItemDataMap().get(dd.getItemId());
            int num = Utils.randomRange(dd.getMinCount(), dd.getMaxCount());
            if (itemData != null) {
                if (itemData.isEquip()) {
                    for (int i = 0; i < num; i++) {
                        addDropEntity(dd, em.getScene(), itemData, em.getPosition().nearby2d(2.5f + (0.05f * ((float) num))).addY(3.0f), num, gp);
                    }
                    return;
                }
                addDropEntity(dd, em.getScene(), itemData, em.getPosition().clone().addY(3.0f), num, gp);
            }
        }
    }

    public void callDrop(EntityMonster em) {
        int fakeidmonster;
        int id = em.getMonsterData().getId();
        Int2ObjectMap<List<DropData>> data = getDropData();
        if (data.containsKey(id)) {
            fakeidmonster = id;
            Grasscutter.getLogger().debug("callDrop: found {}", Integer.valueOf(id));
        } else {
            fakeidmonster = this.DropInfo.get(new Random().nextInt(this.DropInfo.size())).intValue();
            Grasscutter.getLogger().debug("callDrop: no found {} monster drop item., use fake {}", Integer.valueOf(id), Integer.valueOf(fakeidmonster));
        }
        for (DropData dd : data.get(fakeidmonster)) {
            if (dd.isShare()) {
                processDrop(dd, em, null);
            } else {
                for (Player gp : em.getScene().getPlayers()) {
                    processDrop(dd, em, gp);
                }
            }
        }
    }
}
