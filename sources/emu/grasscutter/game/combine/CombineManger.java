package emu.grasscutter.game.combine;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.data.DataLoader;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.CombineData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.game.BaseGameSystem;
import emu.grasscutter.server.game.GameServer;
import emu.grasscutter.server.packet.send.PacketCombineFormulaDataNotify;
import emu.grasscutter.server.packet.send.PacketCombineRsp;
import emu.grasscutter.server.packet.send.PacketReliquaryDecomposeRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/combine/CombineManger.class */
public class CombineManger extends BaseGameSystem {
    private static final Int2ObjectMap<List<Integer>> reliquaryDecomposeData = new Int2ObjectOpenHashMap();

    public CombineManger(GameServer server) {
        super(server);
    }

    public static void initialize() {
        try {
            DataLoader.loadList("ReliquaryDecompose.json", ReliquaryDecomposeEntry.class).forEach(entry -> {
                reliquaryDecomposeData.put(entry.getConfigId(), (int) entry.getItems());
            });
        } catch (Exception ex) {
            Grasscutter.getLogger().error("Unable to load reliquary decompose data.", (Throwable) ex);
        }
        Grasscutter.getLogger().info("Loaded {} reliquary decompose entries.", Integer.valueOf(reliquaryDecomposeData.size()));
    }

    public boolean unlockCombineDiagram(Player player, int combineId) {
        if (!player.getUnlockedCombines().add(Integer.valueOf(combineId))) {
            return false;
        }
        player.sendPacket(new PacketCombineFormulaDataNotify(combineId));
        return true;
    }

    public CombineResult combineItem(Player player, int cid, int count) {
        if (!GameData.getCombineDataMap().containsKey(cid)) {
            player.getWorld().getHost().sendPacket(new PacketCombineRsp());
            return null;
        }
        CombineData combineData = GameData.getCombineDataMap().get(cid);
        if (combineData.getPlayerLevel() > player.getLevel()) {
            return null;
        }
        List<ItemParamData> material = new ArrayList<>(combineData.getMaterialItems());
        material.add(new ItemParamData(202, combineData.getScoinCost()));
        if (!player.getInventory().payItems(material, count, ActionReason.Combine)) {
            player.sendPacket(new PacketCombineRsp(700));
        }
        player.getInventory().addItem(combineData.getResultItemId(), combineData.getResultItemCount() * count);
        CombineResult result = new CombineResult();
        result.setMaterial(List.of());
        result.setResult(List.of(new ItemParamData(combineData.getResultItemId(), combineData.getResultItemCount() * count)));
        result.setExtra(List.of());
        result.setBack(List.of());
        return result;
    }

    public synchronized void decomposeReliquaries(Player player, int configId, int count, List<Long> input) {
        List<Integer> possibleDrops = reliquaryDecomposeData.get(configId);
        if (possibleDrops == null) {
            player.sendPacket(new PacketReliquaryDecomposeRsp(RetcodeOuterClass.Retcode.RET_RELIQUARY_DECOMPOSE_PARAM_ERROR));
        } else if (input.size() != count * 3) {
            player.sendPacket(new PacketReliquaryDecomposeRsp(RetcodeOuterClass.Retcode.RET_RELIQUARY_DECOMPOSE_PARAM_ERROR));
        } else {
            for (Long l : input) {
                if (player.getInventory().getItemByGuid(l.longValue()) == null) {
                    player.sendPacket(new PacketReliquaryDecomposeRsp(RetcodeOuterClass.Retcode.RET_RELIQUARY_DECOMPOSE_PARAM_ERROR));
                    return;
                }
            }
            for (Long l2 : input) {
                player.getInventory().removeItem(l2.longValue());
            }
            List<Long> resultItems = new ArrayList<>();
            for (int i = 0; i < count; i++) {
                GameItem newReliquary = new GameItem(((Integer) Utils.drawRandomListElement(possibleDrops)).intValue(), 1);
                player.getInventory().addItem(newReliquary);
                resultItems.add(Long.valueOf(newReliquary.getGuid()));
            }
            player.sendPacket(new PacketReliquaryDecomposeRsp(resultItems));
        }
    }
}
