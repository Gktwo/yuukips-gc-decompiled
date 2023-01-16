package com.mchange.p006v1.util;

import java.util.Map;

/* renamed from: com.mchange.v1.util.MapUtils */
/* loaded from: grasscutter.jar:com/mchange/v1/util/MapUtils.class */
public final class MapUtils {
    public static boolean equivalentDisregardingSort(Map map, Map map2) {
        if (map.size() != map2.size()) {
            return false;
        }
        for (Object obj : map.keySet()) {
            if (!map.get(obj).equals(map2.get(obj))) {
                return false;
            }
        }
        return true;
    }

    public static int hashContentsDisregardingSort(Map map) {
        int i = 0;
        for (Object obj : map.keySet()) {
            i ^= obj.hashCode() ^ map.get(obj).hashCode();
        }
        return i;
    }
}
