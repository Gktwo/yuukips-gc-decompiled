package emu.grasscutter.game.managers.mapmark;

import dev.morphia.annotations.Entity;
import emu.grasscutter.net.proto.MapMarkFromTypeOuterClass;
import emu.grasscutter.net.proto.MapMarkPointOuterClass;
import emu.grasscutter.net.proto.MapMarkPointTypeOuterClass;
import emu.grasscutter.utils.Position;

@Entity
/* loaded from: grasscutter.jar:emu/grasscutter/game/managers/mapmark/MapMark.class */
public class MapMark {
    private int sceneId;
    private String name;
    private Position position;
    private MapMarkPointTypeOuterClass.MapMarkPointType mapMarkPointType;
    private int monsterId;
    private MapMarkFromTypeOuterClass.MapMarkFromType mapMarkFromType;
    private int questId;

    @Deprecated(forRemoval = true)
    public MapMark() {
        this.mapMarkPointType = MapMarkPointTypeOuterClass.MapMarkPointType.MAP_MARK_POINT_TYPE_MONSTER;
        this.mapMarkFromType = MapMarkFromTypeOuterClass.MapMarkFromType.MAP_MARK_FROM_TYPE_MONSTER;
    }

    public MapMark(MapMarkPointOuterClass.MapMarkPoint mapMarkPoint) {
        this.sceneId = mapMarkPoint.getSceneId();
        this.name = mapMarkPoint.getName();
        this.position = new Position(mapMarkPoint.getPos());
        this.mapMarkPointType = mapMarkPoint.getPointType();
        this.monsterId = mapMarkPoint.getMonsterId();
        this.mapMarkFromType = mapMarkPoint.getFromType();
        this.questId = mapMarkPoint.getQuestId();
    }

    public int getSceneId() {
        return this.sceneId;
    }

    public String getName() {
        return this.name;
    }

    public Position getPosition() {
        return this.position;
    }

    public MapMarkPointTypeOuterClass.MapMarkPointType getMapMarkPointType() {
        return this.mapMarkPointType;
    }

    public int getMonsterId() {
        return this.monsterId;
    }

    public MapMarkFromTypeOuterClass.MapMarkFromType getMapMarkFromType() {
        return this.mapMarkFromType;
    }

    public int getQuestId() {
        return this.questId;
    }
}
