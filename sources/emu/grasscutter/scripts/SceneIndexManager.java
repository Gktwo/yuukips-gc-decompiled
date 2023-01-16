package emu.grasscutter.scripts;

import com.github.davidmoten.rtreemulti.Entry;
import com.github.davidmoten.rtreemulti.RTree;
import com.github.davidmoten.rtreemulti.geometry.Geometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;

/* loaded from: grasscutter.jar:emu/grasscutter/scripts/SceneIndexManager.class */
public class SceneIndexManager {
    public static <T> RTree<T, Geometry> buildIndex(int dimensions, Collection<T> elements, Function<T, Geometry> extractor) {
        return RTree.dimensions(dimensions).create().add(elements.stream().map(e -> {
            return Entry.entry(e, (Geometry) extractor.apply(e));
        }).toList());
    }

    public static <T> List<T> queryNeighbors(RTree<T, Geometry> tree, double[] position, int range) {
        ArrayList<T> result = new ArrayList<>();
        if (tree == null) {
            return result;
        }
        tree.search(Rectangle.create(calRange(position, -range), calRange(position, range))).forEach(q -> {
            result.add(q.value());
        });
        return result;
    }

    private static double[] calRange(double[] position, int range) {
        double[] newPos = (double[]) position.clone();
        for (int i = 0; i < newPos.length; i++) {
            newPos[i] = newPos[i] + ((double) range);
        }
        return newPos;
    }
}
