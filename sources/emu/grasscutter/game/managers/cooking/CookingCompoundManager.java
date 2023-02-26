package emu.grasscutter.game.managers.cooking;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.CompoundData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.proto.CompoundQueueDataOuterClass;
import emu.grasscutter.net.proto.GetCompoundDataReqOuterClass;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.PlayerCompoundMaterialReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.net.proto.TakeCompoundOutputReqOuterClass;
import emu.grasscutter.server.packet.send.PackageTakeCompoundOutputRsp;
import emu.grasscutter.server.packet.send.PacketCompoundDataNotify;
import emu.grasscutter.server.packet.send.PacketGetCompoundDataRsp;
import emu.grasscutter.server.packet.send.PacketPlayerCompoundMaterialRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/cooking/CookingCompoundManager.class */
public class CookingCompoundManager extends BasePlayerManager {
    private static Set<Integer> defaultUnlockedCompounds;
    private static Map<Integer, Set<Integer>> compoundGroups;
    private static Set<Integer> unlocked;

    public CookingCompoundManager(Player player) {
        super(player);
    }

    public static void initialize() {
        defaultUnlockedCompounds = new HashSet();
        compoundGroups = new HashMap();
        GameData.getCompoundDataMap().forEach(id, compound -> {
            if (compound.isDefaultUnlocked()) {
                defaultUnlockedCompounds.add(id);
            }
            compoundGroups.computeIfAbsent(Integer.valueOf(compound.getGroupId()), gid -> {
                return new HashSet();
            }).add(id);
        });
        unlocked = new HashSet(defaultUnlockedCompounds);
        if (compoundGroups.containsKey(3)) {
            unlocked.addAll(compoundGroups.get(3));
        }
    }

    private synchronized List<CompoundQueueDataOuterClass.CompoundQueueData> getCompoundQueueData() {
        List<CompoundQueueDataOuterClass.CompoundQueueData> compoundQueueData = new ArrayList<>(this.player.getActiveCookCompounds().size());
        int currentTime = Utils.getCurrentSeconds();
        for (ActiveCookCompoundData item : this.player.getActiveCookCompounds().values()) {
            compoundQueueData.add(CompoundQueueDataOuterClass.CompoundQueueData.newBuilder().setCompoundId(item.getCompoundId()).setOutputCount(item.getOutputCount(currentTime)).setOutputTime(item.getOutputTime(currentTime)).setWaitCount(item.getWaitCount(currentTime)).build());
        }
        return compoundQueueData;
    }

    public synchronized void handleGetCompoundDataReq(GetCompoundDataReqOuterClass.GetCompoundDataReq req) {
        this.player.sendPacket(new PacketGetCompoundDataRsp(unlocked, getCompoundQueueData()));
    }

    public synchronized void handlePlayerCompoundMaterialReq(PlayerCompoundMaterialReqOuterClass.PlayerCompoundMaterialReq req) {
        ActiveCookCompoundData c;
        int id = req.getCompoundId();
        int count = req.getCount();
        CompoundData compound = GameData.getCompoundDataMap().get(id);
        Map<Integer, ActiveCookCompoundData> activeCompounds = this.player.getActiveCookCompounds();
        if (!unlocked.contains(Integer.valueOf(id))) {
            this.player.sendPacket(new PacketPlayerCompoundMaterialRsp(-1));
        } else if (activeCompounds.containsKey(Integer.valueOf(id)) && activeCompounds.get(Integer.valueOf(id)).getTotalCount() + count > compound.getQueueSize()) {
            this.player.sendPacket(new PacketPlayerCompoundMaterialRsp(614));
        } else if (!this.player.getInventory().payItems(compound.getInputVec(), count)) {
            this.player.sendPacket(new PacketPlayerCompoundMaterialRsp((int) RetcodeOuterClass.Retcode.RET_ITEM_COUNT_NOT_ENOUGH_VALUE));
        } else {
            int currentTime = Utils.getCurrentSeconds();
            if (activeCompounds.containsKey(Integer.valueOf(id))) {
                c = activeCompounds.get(Integer.valueOf(id));
                c.addCompound(count, currentTime);
            } else {
                c = new ActiveCookCompoundData(id, compound.getCostTime(), count, currentTime);
                activeCompounds.put(Integer.valueOf(id), c);
            }
            this.player.sendPacket(new PacketPlayerCompoundMaterialRsp(CompoundQueueDataOuterClass.CompoundQueueData.newBuilder().setCompoundId(id).setOutputCount(c.getOutputCount(currentTime)).setOutputTime(c.getOutputTime(currentTime)).setWaitCount(c.getWaitCount(currentTime)).build()));
        }
    }

    public synchronized void handleTakeCompoundOutputReq(TakeCompoundOutputReqOuterClass.TakeCompoundOutputReq req) {
        int groupId = req.getCompoundGroupId();
        Map<Integer, ActiveCookCompoundData> activeCompounds = this.player.getActiveCookCompounds();
        int now = Utils.getCurrentSeconds();
        boolean success = false;
        Map<Integer, GameItem> allRewards = new HashMap<>();
        for (Integer num : compoundGroups.get(Integer.valueOf(groupId))) {
            int id = num.intValue();
            if (activeCompounds.containsKey(Integer.valueOf(id))) {
                int quantity = activeCompounds.get(Integer.valueOf(id)).takeCompound(now);
                if (activeCompounds.get(Integer.valueOf(id)).getTotalCount() == 0) {
                    activeCompounds.remove(Integer.valueOf(id));
                }
                if (quantity != 0) {
                    for (ItemParamData i : GameData.getCompoundDataMap().get(id).getOutputVec()) {
                        if (i.getId() != 0) {
                            if (allRewards.containsKey(Integer.valueOf(i.getId()))) {
                                GameItem item = allRewards.get(Integer.valueOf(i.getId()));
                                item.setCount(item.getCount() + (i.getCount() * quantity));
                            } else {
                                allRewards.put(Integer.valueOf(i.getId()), new GameItem(i.getId(), i.getCount() * quantity));
                            }
                        }
                    }
                    success = true;
                }
            }
        }
        if (success) {
            this.player.getInventory().addItems(allRewards.values(), ActionReason.Compound);
            this.player.sendPacket(new PackageTakeCompoundOutputRsp(allRewards.values().stream().map(i2 -> {
                return ItemParamOuterClass.ItemParam.newBuilder().setItemId(i2.getItemId()).setCount(i2.getCount()).build();
            }).toList(), 0));
            return;
        }
        this.player.sendPacket(new PackageTakeCompoundOutputRsp(null, 615));
    }

    public void onPlayerLogin() {
        this.player.sendPacket(new PacketCompoundDataNotify(unlocked, getCompoundQueueData()));
    }
}
