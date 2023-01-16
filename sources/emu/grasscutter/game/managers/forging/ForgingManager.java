package emu.grasscutter.game.managers.forging;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.ForgeData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.ForgeQueueDataOuterClass;
import emu.grasscutter.net.proto.ForgeQueueManipulateReqOuterClass;
import emu.grasscutter.net.proto.ForgeQueueManipulateTypeOuterClass;
import emu.grasscutter.net.proto.ForgeStartReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.packet.send.PacketForgeDataNotify;
import emu.grasscutter.server.packet.send.PacketForgeFormulaDataNotify;
import emu.grasscutter.server.packet.send.PacketForgeGetQueueDataRsp;
import emu.grasscutter.server.packet.send.PacketForgeQueueDataNotify;
import emu.grasscutter.server.packet.send.PacketForgeQueueManipulateRsp;
import emu.grasscutter.server.packet.send.PacketForgeStartRsp;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/forging/ForgingManager.class */
public class ForgingManager extends BasePlayerManager {
    public ForgingManager(Player player) {
        super(player);
    }

    public boolean unlockForgingBlueprint(int id) {
        if (!this.player.getUnlockedForgingBlueprints().add(Integer.valueOf(id))) {
            return false;
        }
        this.player.sendPacket(new PacketForgeFormulaDataNotify(id));
        return true;
    }

    private synchronized int determineNumberOfQueues() {
        int adventureRank = this.player.getLevel();
        if (adventureRank >= 15) {
            return 4;
        }
        if (adventureRank >= 10) {
            return 3;
        }
        return adventureRank >= 5 ? 2 : 1;
    }

    private synchronized Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> determineCurrentForgeQueueData() {
        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> res = new HashMap<>();
        int currentTime = Utils.getCurrentSeconds();
        for (int i = 0; i < this.player.getActiveForges().size(); i++) {
            ActiveForgeData activeForge = this.player.getActiveForges().get(i);
            res.put(Integer.valueOf(i + 1), ForgeQueueDataOuterClass.ForgeQueueData.newBuilder().setQueueId(i + 1).setForgeId(activeForge.getForgeId()).setFinishCount(activeForge.getFinishedCount(currentTime)).setUnfinishCount(activeForge.getUnfinishedCount(currentTime)).setTotalFinishTimestamp(activeForge.getTotalFinishTimestamp()).setNextFinishTimestamp(activeForge.getNextFinishTimestamp(currentTime)).setAvatarId(activeForge.getAvatarId()).build());
        }
        return res;
    }

    public synchronized void sendForgeDataNotify() {
        int numQueues = determineNumberOfQueues();
        this.player.sendPacket(new PacketForgeDataNotify(this.player.getUnlockedForgingBlueprints(), numQueues, determineCurrentForgeQueueData()));
    }

    public synchronized void handleForgeGetQueueDataReq() {
        this.player.sendPacket(new PacketForgeGetQueueDataRsp(RetcodeOuterClass.Retcode.RET_SUCC, determineNumberOfQueues(), determineCurrentForgeQueueData()));
    }

    private synchronized void sendForgeQueueDataNotify() {
        this.player.sendPacket(new PacketForgeQueueDataNotify(determineCurrentForgeQueueData(), List.of()));
    }

    private synchronized void sendForgeQueueDataNotify(boolean hasRemoved) {
        Map<Integer, ForgeQueueDataOuterClass.ForgeQueueData> queueData = determineCurrentForgeQueueData();
        if (hasRemoved) {
            this.player.sendPacket(new PacketForgeQueueDataNotify(Map.of(), List.of(1, 2, 3, 4)));
        }
        this.player.sendPacket(new PacketForgeQueueDataNotify(queueData, List.of()));
    }

    public synchronized void handleForgeStartReq(ForgeStartReqOuterClass.ForgeStartReq req) {
        if (this.player.getActiveForges().size() >= determineNumberOfQueues()) {
            this.player.sendPacket(new PacketForgeStartRsp(RetcodeOuterClass.Retcode.RET_FORGE_QUEUE_FULL));
        } else if (!GameData.getForgeDataMap().containsKey(req.getForgeId())) {
            this.player.sendPacket(new PacketForgeStartRsp(RetcodeOuterClass.Retcode.RET_FAIL));
        } else {
            ForgeData forgeData = GameData.getForgeDataMap().get(req.getForgeId());
            int requiredPoints = forgeData.getForgePoint() * req.getForgeCount();
            if (requiredPoints > this.player.getForgePoints()) {
                this.player.sendPacket(new PacketForgeStartRsp(RetcodeOuterClass.Retcode.RET_FORGE_POINT_NOT_ENOUGH));
                return;
            }
            List<ItemParamData> material = new ArrayList<>(forgeData.getMaterialItems());
            material.add(new ItemParamData(202, forgeData.getScoinCost()));
            if (!this.player.getInventory().payItems(material, req.getForgeCount(), ActionReason.ForgeCost)) {
                this.player.sendPacket(new PacketForgeStartRsp(RetcodeOuterClass.Retcode.RET_ITEM_COUNT_NOT_ENOUGH));
            }
            this.player.setForgePoints(this.player.getForgePoints() - requiredPoints);
            ActiveForgeData activeForge = new ActiveForgeData();
            activeForge.setForgeId(req.getForgeId());
            activeForge.setAvatarId(req.getAvatarId());
            activeForge.setCount(req.getForgeCount());
            activeForge.setStartTime(Utils.getCurrentSeconds());
            activeForge.setForgeTime(forgeData.getForgeTime());
            this.player.getActiveForges().add(activeForge);
            sendForgeQueueDataNotify();
            this.player.sendPacket(new PacketForgeStartRsp(RetcodeOuterClass.Retcode.RET_SUCC));
        }
    }

    private synchronized void obtainItems(int queueId) {
        int currentTime = Utils.getCurrentSeconds();
        ActiveForgeData forge = this.player.getActiveForges().get(queueId - 1);
        int finished = forge.getFinishedCount(currentTime);
        int unfinished = forge.getUnfinishedCount(currentTime);
        if (finished > 0) {
            ForgeData data = GameData.getForgeDataMap().get(forge.getForgeId());
            GameItem addItem = new GameItem(GameData.getItemDataMap().get(data.getResultItemId() > 0 ? data.getResultItemId() : data.getShowItemId()), data.getResultItemCount() * finished);
            this.player.getInventory().addItem(addItem);
            this.player.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_DO_FORGE, 0, finished);
            if (unfinished > 0) {
                ActiveForgeData remainingForge = new ActiveForgeData();
                remainingForge.setForgeId(forge.getForgeId());
                remainingForge.setAvatarId(forge.getAvatarId());
                remainingForge.setCount(unfinished);
                remainingForge.setForgeTime(forge.getForgeTime());
                remainingForge.setStartTime(forge.getStartTime() + (finished * forge.getForgeTime()));
                this.player.getActiveForges().set(queueId - 1, remainingForge);
                sendForgeQueueDataNotify();
            } else {
                this.player.getActiveForges().remove(queueId - 1);
                sendForgeQueueDataNotify(true);
            }
            this.player.sendPacket(new PacketForgeQueueManipulateRsp(RetcodeOuterClass.Retcode.RET_SUCC, ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT, List.of(addItem), List.of(), List.of()));
        }
    }

    private synchronized void cancelForge(int queueId) {
        int currentTime = Utils.getCurrentSeconds();
        ActiveForgeData forge = this.player.getActiveForges().get(queueId - 1);
        if (forge.getFinishedCount(currentTime) <= 0) {
            ForgeData data = GameData.getForgeDataMap().get(forge.getForgeId());
            ArrayList<GameItem> returnItems = new ArrayList<>();
            for (ItemParamData material : data.getMaterialItems()) {
                if (material.getItemId() != 0) {
                    GameItem returnItem = new GameItem(GameData.getItemDataMap().get(material.getItemId()), material.getItemCount() * forge.getCount());
                    this.player.getInventory().addItem(returnItem);
                    returnItems.add(returnItem);
                }
            }
            this.player.setMora(this.player.getMora() + (data.getScoinCost() * forge.getCount()));
            returnItems.add(new GameItem(GameData.getItemDataMap().get(202), data.getScoinCost() * forge.getCount()));
            this.player.setForgePoints(Math.min(this.player.getForgePoints() + (data.getForgePoint() * forge.getCount()), 300000));
            this.player.getActiveForges().remove(queueId - 1);
            sendForgeQueueDataNotify(true);
            this.player.sendPacket(new PacketForgeQueueManipulateRsp(RetcodeOuterClass.Retcode.RET_SUCC, ForgeQueueManipulateTypeOuterClass.ForgeQueueManipulateType.FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE, List.of(), returnItems, List.of()));
        }
    }

    public synchronized void handleForgeQueueManipulateReq(ForgeQueueManipulateReqOuterClass.ForgeQueueManipulateReq req) {
        int queueId = req.getForgeQueueId();
        switch (req.getManipulateType()) {
            case FORGE_QUEUE_MANIPULATE_TYPE_RECEIVE_OUTPUT:
                obtainItems(queueId);
                return;
            case FORGE_QUEUE_MANIPULATE_TYPE_STOP_FORGE:
                cancelForge(queueId);
                return;
            default:
                return;
        }
    }

    public synchronized void sendPlayerForgingUpdate() {
        int currentTime = Utils.getCurrentSeconds();
        if (this.player.getActiveForges().size() > 0 && this.player.getActiveForges().stream().anyMatch(forge -> {
            return forge.updateChanged(currentTime);
        })) {
            sendForgeQueueDataNotify();
            this.player.getActiveForges().stream().forEach(forge -> {
                forge.setChanged(false);
            });
        }
    }
}
