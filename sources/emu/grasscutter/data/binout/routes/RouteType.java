package emu.grasscutter.data.binout.routes;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/routes/RouteType.class */
public enum RouteType {
    Unknown(-1),
    OneWay(0),
    Reciprocate(1),
    Loop(2);
    

    /* renamed from: id */
    private final int f505id;

    public int getId() {
        return this.f505id;
    }

    RouteType(int id) {
        this.f505id = id;
    }

    public int getValue() {
        return this.f505id;
    }
}
