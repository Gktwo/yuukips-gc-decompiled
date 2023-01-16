package emu.grasscutter.data.common;

import com.google.gson.annotations.SerializedName;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/DropItemData.class */
public class DropItemData {
    @SerializedName("itemId")

    /* renamed from: id */
    private int f506id;
    private String countRange;
    private int weight;

    public int getId() {
        return this.f506id;
    }

    public String getCountRange() {
        return this.countRange;
    }

    public int getWeight() {
        return this.weight;
    }
}
