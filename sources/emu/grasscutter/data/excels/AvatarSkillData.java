package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.ElementType;

@ResourceType(name = {"AvatarSkillExcelConfigData.json"}, loadPriority = ResourceType.LoadPriority.HIGHEST)
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarSkillData.class */
public class AvatarSkillData extends GameResource {

    /* renamed from: id */
    private int f513id;
    private float cdTime;
    private float costElemVal;
    private int maxChargeNum;
    private int triggerID;
    private boolean isAttackCameraLock;
    private int proudSkillGroupId;
    private ElementType costElemType;
    private long nameTextMapHash;
    private long descTextMapHash;
    private String abilityName;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f513id;
    }

    public float getCdTime() {
        return this.cdTime;
    }

    public float getCostElemVal() {
        return this.costElemVal;
    }

    public int getMaxChargeNum() {
        return this.maxChargeNum;
    }

    public int getTriggerID() {
        return this.triggerID;
    }

    public boolean isAttackCameraLock() {
        return this.isAttackCameraLock;
    }

    public int getProudSkillGroupId() {
        return this.proudSkillGroupId;
    }

    public ElementType getCostElemType() {
        return this.costElemType;
    }

    public long getNameTextMapHash() {
        return this.nameTextMapHash;
    }

    public long getDescTextMapHash() {
        return this.descTextMapHash;
    }

    public String getAbilityName() {
        return this.abilityName;
    }
}
