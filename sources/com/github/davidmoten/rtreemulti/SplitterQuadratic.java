package com.github.davidmoten.rtreemulti;

import com.github.davidmoten.guavamini.Lists;
import com.github.davidmoten.guavamini.Preconditions;
import com.github.davidmoten.guavamini.annotations.VisibleForTesting;
import com.github.davidmoten.rtreemulti.geometry.HasGeometry;
import com.github.davidmoten.rtreemulti.geometry.ListPair;
import com.github.davidmoten.rtreemulti.geometry.Rectangle;
import com.github.davidmoten.rtreemulti.internal.Util;
import com.github.davidmoten.rtreemulti.internal.util.Pair;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/SplitterQuadratic.class */
public final class SplitterQuadratic implements Splitter {
    public static final SplitterQuadratic INSTANCE = new SplitterQuadratic();

    private SplitterQuadratic() {
    }

    @Override // com.github.davidmoten.rtreemulti.Splitter
    public <T extends HasGeometry> ListPair<T> split(List<T> items, int minSize) {
        Preconditions.checkArgument(items.size() >= 2);
        Pair<T> worstCombination = worstCombination(items);
        ArrayList newArrayList = Lists.newArrayList(worstCombination.value1());
        ArrayList newArrayList2 = Lists.newArrayList(worstCombination.value2());
        ArrayList arrayList = new ArrayList(items);
        arrayList.remove(worstCombination.value1());
        arrayList.remove(worstCombination.value2());
        int minGroupSize = items.size() / 2;
        while (arrayList.size() > 0) {
            assignRemaining(newArrayList, newArrayList2, arrayList, minGroupSize);
        }
        return new ListPair<>(newArrayList, newArrayList2);
    }

    /* JADX DEBUG: Multi-variable search result rejected for r6v0, resolved type: java.util.List<T extends com.github.davidmoten.rtreemulti.geometry.HasGeometry> */
    /* JADX DEBUG: Multi-variable search result rejected for r7v0, resolved type: java.util.List<T extends com.github.davidmoten.rtreemulti.geometry.HasGeometry> */
    /* JADX WARN: Multi-variable type inference failed */
    private <T extends HasGeometry> void assignRemaining(List<T> group1, List<T> group2, List<T> remaining, int minGroupSize) {
        Rectangle mbr1 = Util.mbr(group1);
        Rectangle mbr2 = Util.mbr(group2);
        HasGeometry bestCandidateForGroup = getBestCandidateForGroup(remaining, group1, mbr1);
        HasGeometry bestCandidateForGroup2 = getBestCandidateForGroup(remaining, group2, mbr2);
        boolean volume1LessThanVolume2 = bestCandidateForGroup.geometry().mbr().add(mbr1).volume() <= bestCandidateForGroup2.geometry().mbr().add(mbr2).volume();
        if ((!volume1LessThanVolume2 || (group2.size() + remaining.size()) - 1 < minGroupSize) && (volume1LessThanVolume2 || group1.size() + remaining.size() != minGroupSize)) {
            group2.add(bestCandidateForGroup2);
            remaining.remove(bestCandidateForGroup2);
            return;
        }
        group1.add(bestCandidateForGroup);
        remaining.remove(bestCandidateForGroup);
    }

    @VisibleForTesting
    static <T extends HasGeometry> T getBestCandidateForGroup(List<T> list, List<T> group, Rectangle groupMbr) {
        Optional<T> minEntry = Optional.empty();
        Optional<Double> minVolume = Optional.empty();
        for (T entry : list) {
            double volume = groupMbr.add(entry.geometry().mbr()).volume();
            if (!minVolume.isPresent() || volume < minVolume.get().doubleValue()) {
                minVolume = Optional.of(Double.valueOf(volume));
                minEntry = Optional.of(entry);
            }
        }
        return minEntry.get();
    }

    @VisibleForTesting
    static <T extends HasGeometry> Pair<T> worstCombination(List<T> items) {
        Optional<T> e1 = Optional.empty();
        Optional<T> e2 = Optional.empty();
        Optional<Double> maxVolume = Optional.empty();
        for (int i = 0; i < items.size(); i++) {
            for (int j = i + 1; j < items.size(); j++) {
                T entry1 = items.get(i);
                T entry2 = items.get(j);
                double volume = entry1.geometry().mbr().add(entry2.geometry().mbr()).volume();
                if (!maxVolume.isPresent() || volume > maxVolume.get().doubleValue()) {
                    e1 = Optional.of(entry1);
                    e2 = Optional.of(entry2);
                    maxVolume = Optional.of(Double.valueOf(volume));
                }
            }
        }
        if (e1.isPresent()) {
            return new Pair<>(e1.get(), e2.get());
        }
        return new Pair<>(items.get(0), items.get(1));
    }
}
