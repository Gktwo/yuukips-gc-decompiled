package emu.grasscutter.server.event.entity;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.server.event.types.EntityEvent;
import emu.grasscutter.utils.Location;
import javax.annotation.Nullable;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/entity/EntityDeathEvent.class */
public final class EntityDeathEvent extends EntityEvent {
    private final Location deathLocation;
    @Nullable
    private final GameEntity killer;

    public Location getDeathLocation() {
        return this.deathLocation;
    }

    @Nullable
    public GameEntity getKiller() {
        return this.killer;
    }

    public EntityDeathEvent(GameEntity entity, int killerId) {
        super(entity);
        this.deathLocation = new Location(entity.getScene(), entity.getPosition());
        this.killer = entity.getScene().getEntityById(killerId);
    }
}
