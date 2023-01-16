package com.github.davidmoten.rtreemulti.internal;

import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/internal/Util.class */
public final class Util {
    private Util() {
    }

    public static Rectangle mbr(Collection<? extends HasGeometry> items) {
        Preconditions.checkArgument(!items.isEmpty());
        Rectangle result = null;
        for (HasGeometry item : items) {
            Rectangle r = item.geometry().mbr();
            if (result == null) {
                result = r;
            } else {
                result = result.add(r);
            }
        }
        return result;
    }

    public static <T> List<T> add(List<T> list, T element) {
        ArrayList<T> result = new ArrayList<>(list.size() + 2);
        result.addAll(list);
        result.add(element);
        return result;
    }

    public static <T> List<T> remove(List<? extends T> list, List<? extends T> elements) {
        ArrayList<T> result = new ArrayList<>(list);
        result.removeAll(elements);
        return result;
    }

    public static <T> List<? extends T> replace(List<? extends T> list, T element, List<T> replacements) {
        ArrayList arrayList = new ArrayList(list.size() + replacements.size());
        for (Object obj : list) {
            if (obj != element) {
                arrayList.add(obj);
            }
        }
        arrayList.addAll(replacements);
        return arrayList;
    }
}
