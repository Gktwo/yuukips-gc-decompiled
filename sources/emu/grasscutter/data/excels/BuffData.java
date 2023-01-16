package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import emu.grasscutter.game.props.ServerBuffType;

@ResourceType(name = {"BuffExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/BuffData.class */
public class BuffData extends GameResource {
    private int groupId;
    private int serverBuffId;
    private float time;
    private boolean isPersistent;
    private ServerBuffType serverBuffType;
    private String abilityName;
    private String modifierName;

    public int getGroupId() {
        return this.groupId;
    }

    public int getServerBuffId() {
        return this.serverBuffId;
    }

    public float getTime() {
        return this.time;
    }

    public boolean isPersistent() {
        return this.isPersistent;
    }

    public ServerBuffType getServerBuffType() {
        return this.serverBuffType;
    }

    public String getAbilityName() {
        return this.abilityName;
    }

    public String getModifierName() {
        return this.modifierName;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.serverBuffId;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.serverBuffType = this.serverBuffType != null ? this.serverBuffType : ServerBuffType.SERVER_BUFF_NONE;
    }
}
