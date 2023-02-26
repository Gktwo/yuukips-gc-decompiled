package emu.grasscutter.game.entity;

import emu.grasscutter.game.props.EntityIdType;
import emu.grasscutter.game.world.Scene;
import emu.grasscutter.net.proto.SceneEntityInfoOuterClass;
import emu.grasscutter.scripts.data.SceneRegion;
import emu.grasscutter.utils.Position;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import p014it.unimi.dsi.fastutil.ints.Int2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/game/entity/EntityRegion.class */
public class EntityRegion extends GameEntity {
    private final Position position;
    private boolean hasNewEntities;
    private boolean entityLeave;
    private final Set<Integer> entities = ConcurrentHashMap.newKeySet();
    private final SceneRegion metaRegion;

    public boolean isHasNewEntities() {
        return this.hasNewEntities;
    }

    public boolean isEntityLeave() {
        return this.entityLeave;
    }

    public Set<Integer> getEntities() {
        return this.entities;
    }

    public SceneRegion getMetaRegion() {
        return this.metaRegion;
    }

    public EntityRegion(Scene scene, SceneRegion region) {
        super(scene);
        this.f571id = getScene().getWorld().getNextEntityId(EntityIdType.REGION);
        setGroupId(region.group.f922id);
        setBlockId(region.group.block_id);
        setConfigId(region.config_id);
        this.position = region.pos.clone();
        this.metaRegion = region;
    }

    public void addEntity(GameEntity entity) {
        if (!getEntities().contains(Integer.valueOf(entity.getId()))) {
            getEntities().add(Integer.valueOf(entity.getId()));
            this.hasNewEntities = true;
        }
    }

    public boolean hasNewEntities() {
        return this.hasNewEntities;
    }

    public void resetNewEntities() {
        this.hasNewEntities = false;
    }

    public void removeEntity(int entityId) {
        getEntities().remove(Integer.valueOf(entityId));
        this.entityLeave = true;
    }

    public void removeEntity(GameEntity entity) {
        getEntities().remove(Integer.valueOf(entity.getId()));
        this.entityLeave = true;
    }

    public boolean entityLeave() {
        return this.entityLeave;
    }

    public void resetEntityLeave() {
        this.entityLeave = false;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Int2FloatMap getFightProperties() {
        return null;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getPosition() {
        return this.position;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public Position getRotation() {
        return null;
    }

    @Override // emu.grasscutter.game.entity.GameEntity
    public SceneEntityInfoOuterClass.SceneEntityInfo toProto() {
        return null;
    }

    public int getFirstEntityId() {
        return this.entities.stream().findFirst().orElse(0).intValue();
    }
}
