package emu.grasscutter.utils;

import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Transient;
import emu.grasscutter.game.world.Scene;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/utils/Location.class */
public class Location extends Position {
    @Transient
    private Scene scene;

    public Scene getScene() {
        return this.scene;
    }

    public void setScene(Scene scene) {
        this.scene = scene;
    }

    public Location(Scene scene, Position position) {
        set(position);
        this.scene = scene;
    }

    public Location(Scene scene, float x, float y) {
        set(x, y);
        this.scene = scene;
    }

    public Location(Scene scene, float x, float y, float z) {
        set(x, y, z);
        this.scene = scene;
    }

    @Override // emu.grasscutter.utils.Position, java.lang.Object
    public Location clone() {
        return new Location(this.scene, clone());
    }

    @Override // emu.grasscutter.utils.Position, java.lang.Object
    public String toString() {
        return String.format("%s:%s,%s,%s", Integer.valueOf(this.scene.getId()), Float.valueOf(getX()), Float.valueOf(getY()), Float.valueOf(getZ()));
    }
}
