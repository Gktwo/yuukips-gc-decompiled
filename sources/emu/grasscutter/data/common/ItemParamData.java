package emu.grasscutter.data.common;

import com.google.gson.annotations.SerializedName;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/ItemParamData.class */
public class ItemParamData {
    @SerializedName(value = "id", alternate = {"itemId", "item_id"})

    /* renamed from: id */
    private int f508id;
    @SerializedName(value = "count", alternate = {"itemCount"})
    private int count;

    public ItemParamData() {
    }

    public ItemParamData(int id, int count) {
        this.f508id = id;
        this.count = count;
    }

    public int getId() {
        return this.f508id;
    }

    public int getItemId() {
        return this.f508id;
    }

    public int getCount() {
        return this.count;
    }

    public int getItemCount() {
        return this.count;
    }
}
