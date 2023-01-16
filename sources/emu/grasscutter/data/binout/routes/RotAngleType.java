package emu.grasscutter.data.binout.routes;

/* loaded from: grasscutter.jar:emu/grasscutter/data/binout/routes/RotAngleType.class */
public enum RotAngleType {
    ROT_NONE(-1),
    ROT_ANGLE_X(0),
    ROT_ANGLE_Y(1),
    ROT_ANGLE_Z(2);
    

    /* renamed from: id */
    private final int f504id;

    public int getId() {
        return this.f504id;
    }

    RotAngleType(int id) {
        this.f504id = id;
    }

    public int getValue() {
        return this.f504id;
    }
}
