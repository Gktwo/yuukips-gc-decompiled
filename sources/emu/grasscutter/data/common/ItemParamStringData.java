package emu.grasscutter.data.common;

import dev.morphia.mapping.Mapper;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/ItemParamStringData.class */
public class ItemParamStringData {

    /* renamed from: id */
    private int f509id;
    private String count;

    public int getId() {
        return this.f509id;
    }

    public String getCount() {
        return this.count;
    }

    public ItemParamData toItemParamData() {
        if (this.count.contains(";")) {
            this.count = this.count.split(";")[this.count.split(";").length - 1];
        } else if (this.count.contains(Mapper.IGNORED_FIELDNAME)) {
            return new ItemParamData(this.f509id, (int) Math.ceil(Double.parseDouble(this.count)));
        }
        return new ItemParamData(this.f509id, Integer.parseInt(this.count));
    }
}
