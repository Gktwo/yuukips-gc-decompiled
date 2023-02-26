package emu.grasscutter.server.packet.send;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.CodexAnimalData;
import emu.grasscutter.data.excels.CodexMaterialData;
import emu.grasscutter.data.excels.CodexQuestData;
import emu.grasscutter.data.excels.CodexWeaponData;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.net.packet.BasePacket;
import emu.grasscutter.net.packet.PacketOpcodes;
import emu.grasscutter.net.proto.CodexDataFullNotifyOuterClass;
import emu.grasscutter.net.proto.CodexTypeDataOuterClass;
import java.util.Collections;

/* loaded from: grasscutter.jar:emu/grasscutter/server/packet/send/PacketCodexDataFullNotify.class */
public class PacketCodexDataFullNotify extends BasePacket {
    public PacketCodexDataFullNotify(Player player) {
        super((int) PacketOpcodes.CodexDataFullNotify, true);
        CodexTypeDataOuterClass.CodexTypeData.Builder questTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(1);
        CodexTypeDataOuterClass.CodexTypeData.Builder weaponTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(2);
        CodexTypeDataOuterClass.CodexTypeData.Builder animalTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(3);
        CodexTypeDataOuterClass.CodexTypeData.Builder materialTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(4);
        CodexTypeDataOuterClass.CodexTypeData.Builder bookTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(5);
        CodexTypeDataOuterClass.CodexTypeData.Builder pushTipsTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(6);
        CodexTypeDataOuterClass.CodexTypeData.Builder viewTypeData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(7);
        CodexTypeDataOuterClass.CodexTypeData.Builder reliquaryData = CodexTypeDataOuterClass.CodexTypeData.newBuilder().setTypeValue(8);
        player.getQuestManager().forEachMainQuest(mainQuest -> {
            CodexQuestData codexQuest;
            if (mainQuest.isFinished() && (codexQuest = GameData.getCodexQuestDataIdMap().get(mainQuest.getParentQuestId())) != null) {
                questTypeData.addCodexIdList(codexQuest.getId()).addAllHaveViewedList(Collections.singleton(true));
            }
        });
        player.getCodex().getUnlockedWeapon().forEach(weapon -> {
            CodexWeaponData codexWeapon = GameData.getCodexWeaponDataIdMap().get(weapon.intValue());
            if (codexWeapon != null) {
                weaponTypeData.addCodexIdList(codexWeapon.getId()).addAllHaveViewedList(Collections.singleton(true));
            }
        });
        player.getCodex().getUnlockedAnimal().forEach(animal, amount -> {
            CodexAnimalData codexAnimal = GameData.getCodexAnimalDataMap().get(animal.intValue());
            if (codexAnimal != null) {
                animalTypeData.addCodexIdList(codexAnimal.getId()).addAllHaveViewedList(Collections.singleton(true));
            }
        });
        player.getCodex().getUnlockedMaterial().forEach(material -> {
            CodexMaterialData codexMaterial = GameData.getCodexMaterialDataIdMap().get(material.intValue());
            if (codexMaterial != null) {
                materialTypeData.addCodexIdList(codexMaterial.getId()).addAllHaveViewedList(Collections.singleton(true));
            }
        });
        player.getCodex().getUnlockedReliquarySuitCodex().forEach(reliquarySuit -> {
            reliquaryData.addCodexIdList(reliquarySuit.intValue()).addAllHaveViewedList(Collections.singleton(true));
        });
        setData(CodexDataFullNotifyOuterClass.CodexDataFullNotify.newBuilder().addTypeDataList(questTypeData.build()).addTypeDataList(weaponTypeData).addTypeDataList(animalTypeData).addTypeDataList(materialTypeData).addTypeDataList(bookTypeData).addTypeDataList(pushTipsTypeData.build()).addTypeDataList(viewTypeData.build()).addTypeDataList(reliquaryData));
    }
}
