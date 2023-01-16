package emu.grasscutter.game.managers.stamina;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/stamina/Consumption.class */
public class Consumption {
    public ConsumptionType type;
    public int amount;

    public Consumption(ConsumptionType type, int amount) {
        this.type = ConsumptionType.None;
        this.amount = 0;
        this.type = type;
        this.amount = amount;
    }

    public Consumption(ConsumptionType type) {
        this(type, type.amount);
    }

    public Consumption() {
        this.type = ConsumptionType.None;
        this.amount = 0;
    }
}
