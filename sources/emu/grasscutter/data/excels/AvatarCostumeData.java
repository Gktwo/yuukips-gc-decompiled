package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameData;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"AvatarCostumeExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/AvatarCostumeData.class */
public class AvatarCostumeData extends GameResource {
    @SerializedName(value = "skinId", alternate = {"costumeId", "EMHIFNAHCOA"})
    private int skinId;
    private int itemId;
    @SerializedName(value = "characterId", alternate = {"DHIPGFMDBEN"})
    private int characterId;
    @SerializedName(value = "quality", alternate = {"AEBIGPPLCFF"})
    private int quality;

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.skinId;
    }

    public int getItemId() {
        return this.itemId;
    }

    public int getCharacterId() {
        return this.characterId;
    }

    public int getQuality() {
        return this.quality;
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        GameData.getAvatarCostumeDataItemIdMap().put(getItemId(), (int) this);
    }
}
