package com.mongodb.client.model.geojson;

import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/client/model/geojson/PolygonCoordinates.class */
public final class PolygonCoordinates {
    private final List<Position> exterior;
    private final List<List<Position>> holes;

    @SafeVarargs
    public PolygonCoordinates(List<Position> exterior, List<Position>... holes) {
        Assertions.notNull("exteriorRing", exterior);
        Assertions.doesNotContainNull("exterior", exterior);
        Assertions.isTrueArgument("ring must contain at least four positions", exterior.size() >= 4);
        Assertions.isTrueArgument("first and last position must be the same", exterior.get(0).equals(exterior.get(exterior.size() - 1)));
        this.exterior = Collections.unmodifiableList(exterior);
        List<List<Position>> holesList = new ArrayList<>(holes.length);
        for (List<Position> hole : holes) {
            Assertions.notNull("interiorRing", hole);
            Assertions.doesNotContainNull("hole", hole);
            Assertions.isTrueArgument("ring must contain at least four positions", hole.size() >= 4);
            Assertions.isTrueArgument("first and last position must be the same", hole.get(0).equals(hole.get(hole.size() - 1)));
            holesList.add(Collections.unmodifiableList(hole));
        }
        this.holes = Collections.unmodifiableList(holesList);
    }

    public List<Position> getExterior() {
        return this.exterior;
    }

    public List<List<Position>> getHoles() {
        return this.holes;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        PolygonCoordinates that = (PolygonCoordinates) o;
        if (this.exterior.equals(that.exterior) && this.holes.equals(that.holes)) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return (31 * this.exterior.hashCode()) + this.holes.hashCode();
    }

    public String toString() {
        return "PolygonCoordinates{exterior=" + this.exterior + (this.holes.isEmpty() ? "" : ", holes=" + this.holes) + '}';
    }
}
