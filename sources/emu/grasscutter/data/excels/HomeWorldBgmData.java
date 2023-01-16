package emu.grasscutter.data.excels;

import com.google.gson.annotations.SerializedName;
import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;

@ResourceType(name = {"HomeWorldBgmExcelConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/HomeWorldBgmData.class */
public class HomeWorldBgmData extends GameResource {
    @SerializedName(value = "homeBgmId", alternate = {"MJJENLEBKEF", "FBJKMMPAOOL", "PHLJNJKONMN"})
    private int homeBgmId;
    private boolean isDefaultUnlock;
    @SerializedName(value = "NBIDHGOOCKD", alternate = {"EIMHGFINNBN", "IALDGMBPLDP"})
    private boolean NBIDHGOOCKD;
    @SerializedName(value = "JJMNJMCCOKP", alternate = {"NBECKKKEOAK", "AEFNIOHOKHE"})
    private boolean JJMNJMCCOKP;
    private int cityId;
    private int sortOrder;
    @SerializedName(value = "GEGHMJBJMGB", alternate = {"BFOEMFDKHHF", "MMOBPBANDIB"})
    private String GEGHMJBJMGB;
    @SerializedName(value = "bgmNameTextMapHash", alternate = {"LMLNBMJFFML", "AAAPEEKABOO", "BIGAOMFOEBM"})
    private long bgmNameTextMapHash;

    public int getHomeBgmId() {
        return this.homeBgmId;
    }

    public boolean isDefaultUnlock() {
        return this.isDefaultUnlock;
    }

    public boolean isNBIDHGOOCKD() {
        return this.NBIDHGOOCKD;
    }

    public boolean isJJMNJMCCOKP() {
        return this.JJMNJMCCOKP;
    }

    public int getCityId() {
        return this.cityId;
    }

    public int getSortOrder() {
        return this.sortOrder;
    }

    public String getGEGHMJBJMGB() {
        return this.GEGHMJBJMGB;
    }

    public long getBgmNameTextMapHash() {
        return this.bgmNameTextMapHash;
    }

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.homeBgmId;
    }
}
