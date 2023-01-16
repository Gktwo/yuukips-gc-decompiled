package emu.grasscutter.game.managers.cooking;

import emu.grasscutter.data.GameData;
import emu.grasscutter.data.common.ItemParamData;
import emu.grasscutter.data.excels.CookBonusData;
import emu.grasscutter.data.excels.CookRecipeData;
import emu.grasscutter.data.excels.ItemData;
import emu.grasscutter.game.inventory.GameItem;
import emu.grasscutter.game.player.BasePlayerManager;
import emu.grasscutter.game.player.Player;
import emu.grasscutter.game.props.ActionReason;
import emu.grasscutter.net.proto.CookRecipeDataOuterClass;
import emu.grasscutter.net.proto.PlayerCookArgsReqOuterClass;
import emu.grasscutter.net.proto.PlayerCookReqOuterClass;
import emu.grasscutter.net.proto.RetcodeOuterClass;
import emu.grasscutter.server.packet.send.PacketCookDataNotify;
import emu.grasscutter.server.packet.send.PacketCookRecipeDataNotify;
import emu.grasscutter.server.packet.send.PacketPlayerCookArgsRsp;
import emu.grasscutter.server.packet.send.PacketPlayerCookRsp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import p013io.netty.util.internal.ThreadLocalRandom;
import p014it.unimi.dsi.fastutil.objects.ObjectIterator;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/cooking/CookingManager.class */
public class CookingManager extends BasePlayerManager {
    private static final int MANUAL_PERFECT_COOK_QUALITY = 3;
    private static Set<Integer> defaultUnlockedRecipies;

    public CookingManager(Player player) {
        super(player);
    }

    public static void initialize() {
        defaultUnlockedRecipies = new HashSet();
        ObjectIterator<CookRecipeData> it = GameData.getCookRecipeDataMap().values().iterator();
        while (it.hasNext()) {
            CookRecipeData recipe = it.next();
            if (recipe.isDefaultUnlocked()) {
                defaultUnlockedRecipies.add(Integer.valueOf(recipe.getId()));
            }
        }
    }

    public boolean unlockRecipe(int id) {
        if (this.player.getUnlockedRecipies().containsKey(Integer.valueOf(id))) {
            return false;
        }
        this.player.getUnlockedRecipies().put(Integer.valueOf(id), 0);
        this.player.sendPacket(new PacketCookRecipeDataNotify(id));
        return true;
    }

    private double getSpecialtyChance(ItemData cookedItem) {
        switch (cookedItem.getRankLevel()) {
            case 1:
                return 0.25d;
            case 2:
                return 0.2d;
            case 3:
                return 0.15d;
            default:
                return 0.0d;
        }
    }

    public void handlePlayerCookReq(PlayerCookReqOuterClass.PlayerCookReq req) {
        int recipeId = req.getRecipeId();
        int quality = req.getQteQuality();
        int count = req.getCookCount();
        int avatar = req.getAssistAvatar();
        CookRecipeData recipeData = GameData.getCookRecipeDataMap().get(recipeId);
        if (recipeData == null) {
            this.player.sendPacket(new PacketPlayerCookRsp(RetcodeOuterClass.Retcode.RET_FAIL));
            return;
        }
        int proficiency = this.player.getUnlockedRecipies().getOrDefault(Integer.valueOf(recipeId), 0).intValue();
        if (!this.player.getInventory().payItems(recipeData.getInputVec(), count, ActionReason.Cook)) {
            this.player.sendPacket(new PacketPlayerCookRsp(RetcodeOuterClass.Retcode.RET_FAIL));
        }
        ItemParamData resultParam = recipeData.getQualityOutputVec().get(quality == 0 ? 2 : quality - 1);
        ItemData resultItemData = GameData.getItemDataMap().get(resultParam.getItemId());
        int specialtyCount = 0;
        double specialtyChance = getSpecialtyChance(resultItemData);
        CookBonusData bonusData = GameData.getCookBonusDataMap().get(avatar);
        if (bonusData != null && recipeId == bonusData.getRecipeId()) {
            for (int i = 0; i < count; i++) {
                if (ThreadLocalRandom.current().nextDouble() <= specialtyChance) {
                    specialtyCount++;
                }
            }
        }
        List<GameItem> cookResults = new ArrayList<>();
        GameItem cookResultNormal = new GameItem(resultItemData, resultParam.getCount() * (count - specialtyCount));
        cookResults.add(cookResultNormal);
        this.player.getInventory().addItem(cookResultNormal);
        if (specialtyCount > 0) {
            GameItem cookResultSpecialty = new GameItem(GameData.getItemDataMap().get(bonusData.getReplacementItemId()), resultParam.getCount() * specialtyCount);
            cookResults.add(cookResultSpecialty);
            this.player.getInventory().addItem(cookResultSpecialty);
        }
        if (quality == 3) {
            proficiency = Math.min(proficiency + 1, recipeData.getMaxProficiency());
            this.player.getUnlockedRecipies().put(Integer.valueOf(recipeId), Integer.valueOf(proficiency));
        }
        this.player.sendPacket(new PacketPlayerCookRsp(cookResults, quality, count, recipeId, proficiency));
    }

    public void handleCookArgsReq(PlayerCookArgsReqOuterClass.PlayerCookArgsReq req) {
        this.player.sendPacket(new PacketPlayerCookArgsRsp());
    }

    private void addDefaultUnlocked() {
        Map<Integer, Integer> unlockedRecipies = this.player.getUnlockedRecipies();
        HashSet<Integer> additionalRecipies = new HashSet<>(defaultUnlockedRecipies);
        additionalRecipies.removeAll(unlockedRecipies.keySet());
        Iterator<Integer> it = additionalRecipies.iterator();
        while (it.hasNext()) {
            unlockedRecipies.put(Integer.valueOf(it.next().intValue()), 0);
        }
    }

    public void sendCookDataNotify() {
        addDefaultUnlocked();
        Map<Integer, Integer> unlockedRecipes = this.player.getUnlockedRecipies();
        List<CookRecipeDataOuterClass.CookRecipeData> data = new ArrayList<>();
        unlockedRecipes.forEach(recipeId, proficiency -> {
            data.add(CookRecipeDataOuterClass.CookRecipeData.newBuilder().setRecipeId(recipeId.intValue()).setProficiency(proficiency.intValue()).build());
        });
        this.player.sendPacket(new PacketCookDataNotify(data));
    }
}
