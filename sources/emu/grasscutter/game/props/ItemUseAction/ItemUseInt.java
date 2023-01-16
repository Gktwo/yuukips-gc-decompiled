package emu.grasscutter.game.props.ItemUseAction;

/* loaded from: grasscutter.jar:emu/grasscutter/game/props/ItemUseAction/ItemUseInt.class */
public abstract class ItemUseInt extends C1378ItemUseAction {

    /* renamed from: i */
    protected int f589i;

    public int getI() {
        return this.f589i;
    }

    public ItemUseInt(String[] useParam) {
        this.f589i = 0;
        try {
            this.f589i = Integer.parseInt(useParam[0]);
        } catch (NumberFormatException e) {
        }
    }
}
