package emu.grasscutter.game.managers.stamina;

/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/stamina/BeforeUpdateStaminaListener.class */
public interface BeforeUpdateStaminaListener {
    int onBeforeUpdateStamina(String str, int i, boolean z);

    Consumption onBeforeUpdateStamina(String str, Consumption consumption, boolean z);
}
