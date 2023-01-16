package emu.grasscutter.data.excels;

import emu.grasscutter.data.GameResource;
import emu.grasscutter.data.ResourceType;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import p014it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;

@ResourceType(name = {"DailyDungeonConfigData.json"})
/* loaded from: grasscutter.jar:emu/grasscutter/data/excels/DailyDungeonData.class */
public class DailyDungeonData extends GameResource {

    /* renamed from: id */
    private int f525id;
    private int[] monday;
    private int[] tuesday;
    private int[] wednesday;
    private int[] thursday;
    private int[] friday;
    private int[] saturday;
    private int[] sunday;
    private static final int[] empty = new int[0];
    private final Int2ObjectMap<int[]> map = new Int2ObjectOpenHashMap();

    @Override // emu.grasscutter.data.GameResource
    public int getId() {
        return this.f525id;
    }

    public int[] getDungeonsByDay(int day) {
        return this.map.getOrDefault(day, (int) empty);
    }

    @Override // emu.grasscutter.data.GameResource
    public void onLoad() {
        this.map.put(2, (int) this.monday);
        this.map.put(3, (int) this.tuesday);
        this.map.put(4, (int) this.wednesday);
        this.map.put(5, (int) this.thursday);
        this.map.put(6, (int) this.friday);
        this.map.put(7, (int) this.saturday);
        this.map.put(1, (int) this.sunday);
    }
}
