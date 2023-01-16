package emu.grasscutter.data;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.ResourceLoader;
import emu.grasscutter.data.excels.ReliquaryAffixData;
import emu.grasscutter.data.excels.ReliquaryMainPropData;
import emu.grasscutter.game.managers.blossom.BlossomConfig;
import emu.grasscutter.game.world.SpawnDataEntry;
import emu.grasscutter.utils.WeightedList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/data/GameDepot.class */
public class GameDepot {
    public static final int[] BLOCK_SIZE = {50, 500};
    private static Int2ObjectMap<WeightedList<ReliquaryMainPropData>> relicRandomMainPropDepot = new Int2ObjectOpenHashMap();
    private static Int2ObjectMap<List<ReliquaryMainPropData>> relicMainPropDepot = new Int2ObjectOpenHashMap();
    private static Int2ObjectMap<List<ReliquaryAffixData>> relicAffixDepot = new Int2ObjectOpenHashMap();
    private static Map<String, ResourceLoader.AvatarConfig> playerAbilities = new HashMap();
    private static HashMap<SpawnDataEntry.GridBlockId, ArrayList<SpawnDataEntry>> spawnLists = new HashMap<>();
    private static BlossomConfig blossomConfig;

    public static Map<String, ResourceLoader.AvatarConfig> getPlayerAbilities() {
        return playerAbilities;
    }

    public static void setPlayerAbilities(Map<String, ResourceLoader.AvatarConfig> playerAbilities2) {
        playerAbilities = playerAbilities2;
    }

    public static HashMap<SpawnDataEntry.GridBlockId, ArrayList<SpawnDataEntry>> getSpawnLists() {
        return spawnLists;
    }

    public static BlossomConfig getBlossomConfig() {
        return blossomConfig;
    }

    public static void setBlossomConfig(BlossomConfig blossomConfig2) {
        blossomConfig = blossomConfig2;
    }

    public static void load() {
        ObjectIterator<ReliquaryMainPropData> it = GameData.getReliquaryMainPropDataMap().values().iterator();
        while (it.hasNext()) {
            ReliquaryMainPropData data = it.next();
            if (data.getWeight() > 0 && data.getPropDepotId() > 0) {
                relicMainPropDepot.computeIfAbsent(data.getPropDepotId(), k -> {
                    return new ArrayList();
                }).add(data);
                relicRandomMainPropDepot.computeIfAbsent(data.getPropDepotId(), k -> {
                    return new WeightedList();
                }).add((double) data.getWeight(), data);
            }
        }
        ObjectIterator<ReliquaryAffixData> it2 = GameData.getReliquaryAffixDataMap().values().iterator();
        while (it2.hasNext()) {
            ReliquaryAffixData data2 = it2.next();
            if (data2.getWeight() > 0 && data2.getDepotId() > 0) {
                relicAffixDepot.computeIfAbsent(data2.getDepotId(), k -> {
                    return new ArrayList();
                }).add(data2);
            }
        }
        if (relicMainPropDepot.size() == 0 || relicAffixDepot.size() == 0) {
            Grasscutter.getLogger().error("Relic properties are missing weights! Please check your ReliquaryMainPropExcelConfigData or ReliquaryAffixExcelConfigData files in your ExcelBinOutput folder.");
        }
    }

    public static ReliquaryMainPropData getRandomRelicMainProp(int depot) {
        WeightedList<ReliquaryMainPropData> depotList = relicRandomMainPropDepot.get(depot);
        if (depotList == null) {
            return null;
        }
        return depotList.next();
    }

    public static List<ReliquaryMainPropData> getRelicMainPropList(int depot) {
        return relicMainPropDepot.get(depot);
    }

    public static List<ReliquaryAffixData> getRelicAffixList(int depot) {
        return relicAffixDepot.get(depot);
    }

    public static void addSpawnListById(HashMap<SpawnDataEntry.GridBlockId, ArrayList<SpawnDataEntry>> data) {
        spawnLists.putAll(data);
    }
}
