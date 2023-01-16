package emu.grasscutter.scripts.data;

import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/data/SceneRegion.class */
public class SceneRegion {
    public int config_id;
    public int shape;
    public Position pos;
    public Position size;
    public int radius;
    public transient SceneGroup group;

    public void setConfig_id(int config_id) {
        this.config_id = config_id;
    }

    public void setShape(int shape) {
        this.shape = shape;
    }

    public void setPos(Position pos) {
        this.pos = pos;
    }

    public void setSize(Position size) {
        this.size = size;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setGroup(SceneGroup group) {
        this.group = group;
    }

    public boolean contains(Position position) {
        switch (this.shape) {
            case 1:
                return (Math.pow((double) (this.pos.getX() - position.getX()), 2.0d) + Math.pow((double) (this.pos.getY() - position.getY()), 2.0d)) + Math.pow((double) (this.pos.getZ() - position.getZ()), 2.0d) <= ((double) (this.radius * this.radius));
            case 2:
                return Math.abs(this.pos.getX() - position.getX()) <= this.size.getX() && Math.abs(this.pos.getY() - position.getY()) <= this.size.getY() && Math.abs(this.pos.getZ() - position.getZ()) <= this.size.getZ();
            default:
                return false;
        }
    }
}
