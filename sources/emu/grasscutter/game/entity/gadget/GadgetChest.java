package emu.grasscutter.game.entity.gadget;

import emu.grasscutter.Grasscutter;
import emu.grasscutter.game.drop.DropSystem;
import emu.grasscutter.game.entity.EntityGadget;
import emu.grasscutter.game.entity.gadget.chest.BossChestInteractHandler;
import emu.grasscutter.game.entity.gadget.chest.ChestInteractHandler;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.WatcherTriggerType;
import emu.grasscutter.net.proto.BossChestInfoOuterClass;
import emu.grasscutter.net.proto.GadgetInteractReqOuterClass;
import emu.grasscutter.net.proto.InterOpTypeOuterClass;
import emu.grasscutter.net.proto.InteractTypeOuterClass;
import emu.grasscutter.net.proto.ResinCostTypeOuterClass;
import emu.grasscutter.net.proto.SceneGadgetInfoOuterClass;
import emu.grasscutter.scripts.data.SceneBossChest;
import emu.grasscutter.scripts.data.SceneGadget;
import emu.grasscutter.server.packet.send.PacketGadgetInteractRsp;
import emu.grasscutter.server.packet.send.PacketWorldChestOpenNotify;
import java.util.List;
import java.util.Map;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/gadget/GadgetChest.class */
public class GadgetChest extends GadgetContent {
    public GadgetChest(EntityGadget gadget) {
        super(gadget);
    }

    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public boolean onInteract(Player player, GadgetInteractReqOuterClass.GadgetInteractReq req) {
        boolean success;
        SceneGadget chest = getGadget().getMetaGadget();
        DropSystem dropSystem = player.getServer().getDropSystem();
        if (chest == null || chest.boss_chest == null || chest.drop_tag == null) {
            if (player != player.getWorld().getHost()) {
                return false;
            }
            boolean status = false;
            if (chest != null && chest.drop_tag != null) {
                status = dropSystem.handleChestDrop(chest.drop_tag, chest.level, getGadget());
            } else if (!(chest == null || chest.chest_drop_id == 0)) {
                status = dropSystem.handleChestDrop(chest.chest_drop_id, chest.drop_count, getGadget());
            }
            if (chest != null && status) {
                getGadget().updateState(102);
                player.sendPacket(new PacketGadgetInteractRsp(getGadget(), InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_CHEST, InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH));
                player.sendPacket(new PacketWorldChestOpenNotify(getGadget().getGroupId(), player.getSceneId(), chest.config_id));
                return true;
            }
        } else if (req.getOpType() == InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_START) {
            player.sendPacket(new PacketGadgetInteractRsp(getGadget(), InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_CHEST, InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_START));
            return false;
        } else if (player.getResinManager().useResin(chest.boss_chest.resin) && dropSystem.handleBossChestDrop(chest.drop_tag, player)) {
            player.getBattlePassManager().triggerMission(WatcherTriggerType.TRIGGER_WORLD_BOSS_REWARD, chest.boss_chest.monster_config_id, 1);
            getGadget().updateState(102);
            player.sendPacket(new PacketGadgetInteractRsp(getGadget(), InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_CHEST, InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH));
            return true;
        }
        Grasscutter.getLogger().warn("Can not solve chest drop (GadgetId {}). Fallback to legacy drop system.", Integer.valueOf(getGadget().getGadgetId()));
        Map<String, ChestInteractHandler> chestInteractHandlerMap = getGadget().getScene().getWorld().getServer().getWorldDataSystem().getChestInteractHandlerMap();
        String namachs = getGadget().getGadgetData().getJsonName();
        ChestInteractHandler handler = chestInteractHandlerMap.get(namachs);
        if (handler == null) {
            Grasscutter.getLogger().warn("Could not found the handler of this type of Chests {}->{}", namachs, req.getOpType().name());
            return false;
        } else if (req.getOpType() != InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_START || !handler.isTwoStep()) {
            if (handler instanceof BossChestInteractHandler) {
                success = ((BossChestInteractHandler) handler).onInteract(this, player, req.getResinCostType() == ResinCostTypeOuterClass.ResinCostType.RESIN_COST_TYPE_CONDENSE);
            } else {
                success = handler.onInteract(this, player);
            }
            if (!success) {
                return false;
            }
            getGadget().updateState(102);
            player.sendPacket(new PacketGadgetInteractRsp(getGadget(), InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_CHEST, InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_FINISH));
            return true;
        } else {
            player.sendPacket(new PacketGadgetInteractRsp(getGadget(), InteractTypeOuterClass.InteractType.INTERACT_TYPE_OPEN_CHEST, InterOpTypeOuterClass.InterOpType.INTER_OP_TYPE_START));
            return false;
        }
    }

    @Override // emu.grasscutter.game.entity.gadget.GadgetContent
    public void onBuildProto(SceneGadgetInfoOuterClass.SceneGadgetInfo.Builder gadgetInfo) {
        SceneBossChest bossChest;
        if (getGadget().getMetaGadget() != null && (bossChest = getGadget().getMetaGadget().boss_chest) != null) {
            List<Integer> players = getGadget().getScene().getPlayers().stream().map((v0) -> {
                return v0.getUid();
            }).toList();
            gadgetInfo.setBossChest(BossChestInfoOuterClass.BossChestInfo.newBuilder().setMonsterConfigId(bossChest.monster_config_id).setResin(bossChest.resin).addAllQualifyUidList(players).addAllRemainUidList(players).build());
        }
    }
}
