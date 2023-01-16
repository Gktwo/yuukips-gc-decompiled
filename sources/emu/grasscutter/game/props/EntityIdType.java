package emu.grasscutter.game.props;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/EntityIdType.class */
public enum EntityIdType {
    AVATAR(1),
    MONSTER(2),
    NPC(3),
    GADGET(4),
    REGION(5),
    WEAPON(6),
    TEAM(9),
    MPLEVEL(11);
    

    /* renamed from: id */
    private final int f586id;

    EntityIdType(int id) {
        this.f586id = id;
    }

    public int getId() {
        return this.f586id;
    }
}
