package emu.grasscutter.game.player;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.excels.CodexAnimalData;
import emu.grasscutter.game.entity.EntityMonster;
import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.server.packet.send.PacketCodexDataUpdateNotify;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/player/PlayerCodex.class */
public class PlayerCodex {
    @Transient
    private Player player;
    private Set<Integer> unlockedWeapon;
    private Map<Integer, Integer> unlockedAnimal;
    private Set<Integer> unlockedMaterial;
    private Set<Integer> unlockedBook;
    private Set<Integer> unlockedTip;
    private Set<Integer> unlockedView;
    private Set<Integer> unlockedReliquary;
    private Set<Integer> unlockedReliquarySuitCodex;

    public Set<Integer> getUnlockedWeapon() {
        return this.unlockedWeapon;
    }

    public Map<Integer, Integer> getUnlockedAnimal() {
        return this.unlockedAnimal;
    }

    public Set<Integer> getUnlockedMaterial() {
        return this.unlockedMaterial;
    }

    public Set<Integer> getUnlockedBook() {
        return this.unlockedBook;
    }

    public Set<Integer> getUnlockedTip() {
        return this.unlockedTip;
    }

    public Set<Integer> getUnlockedView() {
        return this.unlockedView;
    }

    public Set<Integer> getUnlockedReliquary() {
        return this.unlockedReliquary;
    }

    public Set<Integer> getUnlockedReliquarySuitCodex() {
        return this.unlockedReliquarySuitCodex;
    }

    public PlayerCodex() {
        this.unlockedWeapon = new HashSet();
        this.unlockedAnimal = new HashMap();
        this.unlockedMaterial = new HashSet();
        this.unlockedBook = new HashSet();
        this.unlockedTip = new HashSet();
        this.unlockedView = new HashSet();
        this.unlockedReliquary = new HashSet();
        this.unlockedReliquarySuitCodex = new HashSet();
    }

    public PlayerCodex(Player player) {
        this();
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
        fixReliquaries();
    }

    public void checkAddedItem(GameItem item) {
        item.getItemData();
        int itemId = item.getItemId();
        switch (itemData.getItemType()) {
            case ITEM_WEAPON:
                Optional.ofNullable(GameData.getCodexWeaponDataIdMap().get(itemId)).ifPresent(codexData -> {
                    if (getUnlockedWeapon().add(Integer.valueOf(itemId))) {
                        this.player.save();
                        this.player.sendPacket(new PacketCodexDataUpdateNotify(2, itemId.getId()));
                    }
                });
                return;
            case ITEM_MATERIAL:
                switch (itemData.getMaterialType()) {
                    case MATERIAL_FOOD:
                    case MATERIAL_WIDGET:
                    case MATERIAL_EXCHANGE:
                    case MATERIAL_AVATAR_MATERIAL:
                    case MATERIAL_NOTICE_ADD_HP:
                        Optional.ofNullable(GameData.getCodexMaterialDataIdMap().get(itemId)).ifPresent(codexData -> {
                            if (getUnlockedMaterial().add(Integer.valueOf(itemId))) {
                                this.player.save();
                                this.player.sendPacket(new PacketCodexDataUpdateNotify(4, itemId.getId()));
                            }
                        });
                        return;
                    default:
                        return;
                }
            case ITEM_RELIQUARY:
                int reliquaryId = (itemId / 10) * 10;
                if (getUnlockedReliquary().add(Integer.valueOf(reliquaryId))) {
                    checkUnlockedSuits(reliquaryId);
                    return;
                }
                return;
            default:
                return;
        }
    }

    public void checkAnimal(GameEntity target, CodexAnimalData.CountType countType) {
        int monsterId;
        CodexAnimalData codexAnimal;
        if ((target instanceof EntityMonster) && (codexAnimal = GameData.getCodexAnimalDataMap().get((monsterId = ((EntityMonster) target).getMonsterData().getId()))) != null) {
            CodexAnimalData.CountType animalCountType = codexAnimal.getCountType();
            if (animalCountType == countType || animalCountType == null) {
                getUnlockedAnimal().merge(Integer.valueOf(monsterId), 1, i, j -> {
                    return Integer.valueOf(i.intValue() + 1);
                });
                this.player.save();
                this.player.sendPacket(new PacketCodexDataUpdateNotify(3, monsterId));
            }
        }
    }

    public void checkUnlockedSuits(int reliquaryId) {
        GameData.getCodexReliquaryArrayList().stream().filter(x -> {
            return !getUnlockedReliquarySuitCodex().contains(Integer.valueOf(x.getId()));
        }).filter(x -> {
            return x.containsId(reliquaryId);
        }).filter(x -> {
            return getUnlockedReliquary().containsAll(x.getIds());
        }).forEach(x -> {
            int id = x.getId();
            getUnlockedReliquarySuitCodex().add(Integer.valueOf(id));
            this.player.save();
            this.player.sendPacket(new PacketCodexDataUpdateNotify(8, id));
        });
    }

    private void fixReliquaries() {
        HashSet<Integer> newReliquaries = new HashSet<>();
        this.unlockedReliquary.forEach(i -> {
            newReliquaries.add(Integer.valueOf((i.intValue() / 10) * 10));
        });
        this.unlockedReliquary = newReliquaries;
        GameData.getCodexReliquaryArrayList().stream().filter(x -> {
            return !getUnlockedReliquarySuitCodex().contains(Integer.valueOf(x.getId()));
        }).filter(x -> {
            return getUnlockedReliquary().containsAll(x.getIds());
        }).forEach(x -> {
            getUnlockedReliquarySuitCodex().add(Integer.valueOf(x.getId()));
        });
        this.player.save();
    }
}
