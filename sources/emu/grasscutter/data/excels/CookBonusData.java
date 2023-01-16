package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"CookBonusExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.LOW)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/CookBonusData.class */
public class CookBonusData extends GameResource {
    private int avatarId;
    private int recipeId;
    private int[] paramVec;
    private int[] complexParamVec;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.avatarId;
    }

    public int getAvatarId() {
        return this.avatarId;
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public int[] getParamVec() {
        return this.paramVec;
    }

    public int[] getComplexParamVec() {
        return this.complexParamVec;
    }

    public int getReplacementItemId() {
        return this.paramVec[0];
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
    }
}
