package emu.grasscutter.game.managers;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.FurnitureMakeConfigData;
import emu.grasscutter.game.home.FurnitureMakeSlotItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.proto.ItemParamOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.packet.send.PacketFurnitureMakeRsp;
import emu.grasscutter.server.packet.send.PacketFurnitureMakeStartRsp;
import emu.grasscutter.server.packet.send.PacketTakeFurnitureMakeRsp;
import emu.grasscutter.server.packet.send.PacketUnlockedFurnitureFormulaDataNotify;
import emu.grasscutter.server.packet.send.PacketUnlockedFurnitureSuiteDataNotify;
import emu.grasscutter.utils.Utils;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/FurnitureManager.class */
public class FurnitureManager extends BasePlayerManager {
    public FurnitureManager(Player player) {
        super(player);
    }

    public void onLogin() {
        notifyUnlockFurniture();
        notifyUnlockFurnitureSuite();
    }

    public void notifyUnlockFurniture() {
        this.player.getSession().send(new PacketUnlockedFurnitureFormulaDataNotify(this.player.getUnlockedFurniture()));
    }

    public void notifyUnlockFurnitureSuite() {
        this.player.getSession().send(new PacketUnlockedFurnitureSuiteDataNotify(this.player.getUnlockedFurnitureSuite()));
    }

    public boolean unlockFurnitureFormula(int id) {
        if (!this.player.getUnlockedFurniture().add(Integer.valueOf(id))) {
            return false;
        }
        notifyUnlockFurniture();
        return true;
    }

    public boolean unlockFurnitureSuite(int id) {
        if (!this.player.getUnlockedFurnitureSuite().add(Integer.valueOf(id))) {
            return false;
        }
        notifyUnlockFurnitureSuite();
        return true;
    }

    public void startMake(int makeId, int avatarId) {
        FurnitureMakeConfigData makeData = GameData.getFurnitureMakeConfigDataMap().get(makeId);
        if (makeData == null) {
            this.player.getSession().send(new PacketFurnitureMakeStartRsp(RetcodeOuterClass.Retcode.RET_FURNITURE_MAKE_CONFIG_ERROR_VALUE, null));
        } else if (this.player.getHome().getLevelData().getFurnitureMakeSlotCount() <= this.player.getHome().getFurnitureMakeSlotItemList().size()) {
            this.player.getSession().send(new PacketFurnitureMakeStartRsp(RetcodeOuterClass.Retcode.RET_FURNITURE_MAKE_SLOT_FULL_VALUE, null));
        } else if (!this.player.getInventory().payItems(makeData.getMaterialItems())) {
            this.player.getSession().send(new PacketFurnitureMakeStartRsp(RetcodeOuterClass.Retcode.RET_HOME_FURNITURE_COUNT_NOT_ENOUGH_VALUE, null));
        } else {
            this.player.getHome().getFurnitureMakeSlotItemList().add(FurnitureMakeSlotItem.m1203of().avatarId(avatarId).makeId(makeId).beginTime(Utils.getCurrentSeconds()).durTime(makeData.getMakeTime()).build());
            this.player.getSession().send(new PacketFurnitureMakeStartRsp(0, this.player.getHome().getFurnitureMakeSlotItemList().stream().map((v0) -> {
                return v0.toProto();
            }).toList()));
            this.player.getHome().save();
        }
    }

    public void queryStatus() {
        if (this.player.getHome().getFurnitureMakeSlotItemList() == null) {
            this.player.getHome().setFurnitureMakeSlotItemList(new ArrayList());
        }
        this.player.sendPacket(new PacketFurnitureMakeRsp(this.player.getHome()));
    }

    public void take(int index, int makeId, boolean isFastFinish) {
        FurnitureMakeConfigData makeData = GameData.getFurnitureMakeConfigDataMap().get(makeId);
        if (makeData == null) {
            this.player.getSession().send(new PacketTakeFurnitureMakeRsp(RetcodeOuterClass.Retcode.RET_FURNITURE_MAKE_CONFIG_ERROR_VALUE, makeId, null, null));
            return;
        }
        Optional<FurnitureMakeSlotItem> slotItem = this.player.getHome().getFurnitureMakeSlotItemList().stream().filter(x -> {
            return x.getIndex() == index && x.getMakeId() == makeId;
        }).findFirst();
        if (slotItem.isEmpty()) {
            this.player.getSession().send(new PacketTakeFurnitureMakeRsp(RetcodeOuterClass.Retcode.RET_FURNITURE_MAKE_NO_MAKE_DATA_VALUE, makeId, null, null));
        } else if (!isFastFinish || this.player.getInventory().payItem(107013, 1)) {
            this.player.getInventory().addItem(makeData.getFurnitureItemID(), makeData.getCount());
            this.player.getHome().getFurnitureMakeSlotItemList().remove(slotItem.get());
            this.player.getInventory().addItem(121, makeData.getExp(), ActionReason.FurnitureMakeTake);
            this.player.getSession().send(new PacketTakeFurnitureMakeRsp(0, makeId, List.of(ItemParamOuterClass.ItemParam.newBuilder().setItemId(makeData.getFurnitureItemID()).setCount(makeData.getCount()).build()), this.player.getHome().getFurnitureMakeSlotItemList().stream().map((v0) -> {
                return v0.toProto();
            }).toList()));
            this.player.getHome().save();
        } else {
            this.player.getSession().send(new PacketTakeFurnitureMakeRsp(RetcodeOuterClass.Retcode.RET_FURNITURE_MAKE_UNFINISH_VALUE, makeId, null, null));
        }
    }
}
