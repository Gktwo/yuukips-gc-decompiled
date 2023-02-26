package emu.grasscutter.game.drop;

import dev.morphia.mapping.Mapper;
import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.DropItemData;
import emu.grasscutter.data.excels.DropMaterialData;
import emu.grasscutter.data.excels.DropTableData;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.inventory.ItemType;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.scripts.data.SceneMonster;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketDropHintNotify;
import emu.grasscutter.server.packet.send.PacketGadgetAutoPickDropInfoNotify;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/drop/DropSystem.class */
public class DropSystem extends BaseGameSystem {
    private final int[] bossLevel = {36, 37, 41, 50, 62, 72, 83, 91, 93};
    private final Random rand = new Random();
    private final Int2ObjectMap<DropTableData> dropTable = GameData.getDropTableDataMap();
    private final Map<String, List<BaseDropData>> chestReward = new HashMap();
    private final Map<String, List<BaseDropData>> monsterDrop = new HashMap();

    public DropSystem(GameServer server) {
        super(server);
        try {
            for (ChestDropData i : DataLoader.loadList("ChestDrop.json", ChestDropData.class)) {
                String indexid = i.getIndex();
                if (!this.chestReward.containsKey(indexid)) {
                    this.chestReward.put(indexid, new ArrayList());
                }
                this.chestReward.get(indexid).add(i);
            }
        } catch (Exception e) {
            Grasscutter.getLogger().error("Unable to load chest drop data.Please place ChestDrop.json in data folder.");
        }
        try {
            for (BaseDropData i2 : DataLoader.loadList("MonsterDrop.json", BaseDropData.class)) {
                if (!this.monsterDrop.containsKey(i2.getIndex())) {
                    this.monsterDrop.put(i2.getIndex(), new ArrayList());
                }
                this.monsterDrop.get(i2.getIndex()).add(i2);
            }
        } catch (Exception e2) {
            Grasscutter.getLogger().error("Unable to load monster drop data.Please place MonsterDrop.json in data folder.");
        }
    }

    private int queryDropData(String dropTag, int level, Map<String, List<BaseDropData>> rewards) {
        if (!rewards.containsKey(dropTag)) {
            return 0;
        }
        BaseDropData dropData = null;
        int minLevel = 0;
        for (BaseDropData i : rewards.get(dropTag)) {
            if (level >= i.getMinLevel() && i.getMinLevel() > minLevel) {
                minLevel = i.getMinLevel();
                dropData = i;
            }
        }
        if (dropData == null) {
            return 0;
        }
        return dropData.getDropId();
    }

    public boolean handleMonsterDrop(EntityMonster monster) {
        int dropId;
        int level = monster.getLevel();
        SceneMonster sceneMonster = monster.getMetaMonster();
        if (sceneMonster == null) {
            dropId = monster.getMonsterData().getKillDropId();
        } else if (sceneMonster.drop_tag != null) {
            dropId = queryDropData(sceneMonster.drop_tag, level, this.monsterDrop);
        } else {
            dropId = sceneMonster.drop_id;
        }
        if (!this.dropTable.containsKey(dropId)) {
            return false;
        }
        DropTableData dropData = this.dropTable.get(dropId);
        List<GameItem> items = new ArrayList<>();
        processDrop(dropData, 1, items);
        if (dropData.isFallToGround()) {
            for (Player p : monster.getScene().getPlayers()) {
                dropItems(items, ActionReason.MonsterDie, monster, p, true);
            }
            return true;
        }
        for (Player p2 : monster.getScene().getPlayers()) {
            p2.getInventory().addItems(items, ActionReason.MonsterDie);
        }
        return true;
    }

    public boolean handleChestDrop(int chestDropId, int dropCount, GameEntity bornFrom) {
        if (!this.dropTable.containsKey(chestDropId)) {
            return false;
        }
        DropTableData dropData = this.dropTable.get(chestDropId);
        List<GameItem> items = new ArrayList<>();
        processDrop(dropData, dropCount, items);
        if (dropData.isFallToGround()) {
            dropItems(items, ActionReason.OpenChest, bornFrom, bornFrom.getWorld().getHost(), false);
            return true;
        }
        bornFrom.getWorld().getHost().getInventory().addItems(items, ActionReason.OpenChest);
        return true;
    }

    public boolean handleChestDrop(String dropTag, int level, GameEntity bornFrom) {
        int dropId = queryDropData(dropTag, level, this.chestReward);
        if (dropId == 0) {
            return false;
        }
        return handleChestDrop(dropId, 1, bornFrom);
    }

    public boolean handleBossChestDrop(String dropTag, Player player) {
        int dropId = queryDropData(dropTag, this.bossLevel[player.getWorldLevel()], this.chestReward);
        if (!this.dropTable.containsKey(dropId)) {
            return false;
        }
        DropTableData dropData = this.dropTable.get(dropId);
        List<GameItem> items = new ArrayList<>();
        processDrop(dropData, 1, items);
        player.getInventory().addItems(items, ActionReason.OpenWorldBossChest);
        player.sendPacket(new PacketGadgetAutoPickDropInfoNotify(items));
        return true;
    }

    private void processDrop(DropTableData dropData, int count, List<GameItem> items) {
        int amount;
        if (count > 1) {
            for (int i = 0; i < count; i++) {
                processDrop(dropData, 1, items);
            }
        } else if (dropData.getRandomType() == 0) {
            int weightSum = 0;
            for (DropItemData i2 : dropData.getDropVec()) {
                if (i2.getId() != 0) {
                    weightSum += i2.getWeight();
                }
            }
            if (weightSum != 0) {
                int weight = this.rand.nextInt(weightSum);
                int sum = 0;
                for (DropItemData i3 : dropData.getDropVec()) {
                    int id = i3.getId();
                    if (id != 0) {
                        sum += i3.getWeight();
                        if (weight < sum) {
                            int amount2 = calculateDropAmount(i3) * count;
                            if (amount2 > 0) {
                                if (this.dropTable.containsKey(id)) {
                                    processDrop(this.dropTable.get(id), amount2, items);
                                    return;
                                }
                                boolean flag = true;
                                Iterator<GameItem> it = items.iterator();
                                while (true) {
                                    if (!it.hasNext()) {
                                        break;
                                    }
                                    GameItem j = it.next();
                                    if (j.getItemId() == id) {
                                        j.setCount(j.getCount() + amount2);
                                        flag = false;
                                        break;
                                    }
                                }
                                if (flag) {
                                    items.add(new GameItem(id, amount2));
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                    }
                }
            }
        } else if (dropData.getRandomType() == 1) {
            for (DropItemData i4 : dropData.getDropVec()) {
                int id2 = i4.getId();
                if (id2 != 0 && this.rand.nextInt(10000) < i4.getWeight() && (amount = calculateDropAmount(i4) * count) > 0) {
                    if (this.dropTable.containsKey(id2)) {
                        processDrop(this.dropTable.get(id2), amount, items);
                    } else {
                        boolean flag2 = true;
                        Iterator<GameItem> it2 = items.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                break;
                            }
                            GameItem j2 = it2.next();
                            if (j2.getItemId() == id2) {
                                j2.setCount(j2.getCount() + amount);
                                flag2 = false;
                                break;
                            }
                        }
                        if (flag2) {
                            items.add(new GameItem(id2, amount));
                        }
                    }
                }
            }
        }
    }

    private int calculateDropAmount(DropItemData i) {
        int amount;
        if (i.getCountRange().contains(";")) {
            String[] ranges = i.getCountRange().split(";");
            amount = this.rand.nextInt(Integer.parseInt(ranges[0]), Integer.parseInt(ranges[1]) + 1);
        } else if (i.getCountRange().contains(Mapper.IGNORED_FIELDNAME)) {
            double expectAmount = Double.parseDouble(i.getCountRange());
            amount = (int) expectAmount;
            if (this.rand.nextDouble() < expectAmount - ((double) amount)) {
                amount++;
            }
        } else {
            amount = Integer.parseInt(i.getCountRange());
        }
        return amount;
    }

    private void dropItem(GameItem item, ActionReason reason, Player player, GameEntity bornFrom, boolean share) {
        DropMaterialData drop = GameData.getDropMaterialDataMap().get(item.getItemId());
        if ((drop == null || !drop.isAutoPick()) && !(item.getItemData().getItemType() == ItemType.ITEM_VIRTUAL && item.getItemData().getGadgetId() == 0)) {
            player.getScene().addDropEntity(item, bornFrom, player, share);
        } else {
            giveItem(item, reason, player, share);
        }
    }

    private void dropItems(List<GameItem> items, ActionReason reason, GameEntity bornFrom, Player player, boolean share) {
        for (GameItem i : items) {
            dropItem(i, reason, player, bornFrom, share);
        }
    }

    private void giveItem(GameItem item, ActionReason reason, Player player, boolean share) {
        if (share) {
            for (Player p : player.getScene().getPlayers()) {
                p.getInventory().addItem(item, reason);
                p.sendPacket(new PacketDropHintNotify(item.getItemId(), player.getPosition().toProto()));
            }
            return;
        }
        player.getInventory().addItem(item, reason);
        player.sendPacket(new PacketDropHintNotify(item.getItemId(), player.getPosition().toProto()));
    }

    private void giveItems(List<GameItem> items, ActionReason reason, Player player, boolean share) {
        if (share) {
            for (Player p : player.getScene().getPlayers()) {
                p.getInventory().addItems(items, reason);
                p.sendPacket(new PacketDropHintNotify(items, player.getPosition().toProto()));
            }
            return;
        }
        player.getInventory().addItems(items, reason);
        player.sendPacket(new PacketDropHintNotify(items, player.getPosition().toProto()));
    }
}
