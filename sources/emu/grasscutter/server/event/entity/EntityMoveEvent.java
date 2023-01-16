package emu.grasscutter.server.event.entity;

import emu.grasscutter.game.entity.GameEntity;
import emu.grasscutter.net.proto.MotionStateOuterClass;
import emu.grasscutter.server.event.types.EntityEvent;
import emu.grasscutter.utils.Position;

/* loaded from: grasscutter.jar:emu/grasscutter/server/event/entity/EntityMoveEvent.class */
public final class EntityMoveEvent extends EntityEvent {
    private final Position position;
    private final Position rotation;
    private final MotionStateOuterClass.MotionState motionState;

    public EntityMoveEvent(GameEntity entity, Position position, Position rotation, MotionStateOuterClass.MotionState motionState) {
        super(entity);
        this.position = position;
        this.rotation = rotation;
        this.motionState = motionState;
    }

    public Position getPosition() {
        return this.position;
    }

    public Position getRotation() {
        return this.rotation;
    }

    public MotionStateOuterClass.MotionState getMotionState() {
        return this.motionState;
    }
}
