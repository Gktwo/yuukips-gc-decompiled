package com.fasterxml.jackson.core.util;

import com.fasterxml.jackson.core.util.JacksonFeature;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/core/util/JacksonFeatureSet.class */
public final class JacksonFeatureSet<F extends JacksonFeature> {
    protected int _enabled;

    protected JacksonFeatureSet(int bitmask) {
        this._enabled = bitmask;
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromDefaults(F[] allFeatures) {
        if (allFeatures.length > 31) {
            throw new IllegalArgumentException(String.format("Can not use type `%s` with JacksonFeatureSet: too many entries (%d > 31)", allFeatures[0].getClass().getName(), Integer.valueOf(allFeatures.length)));
        }
        int flags = 0;
        for (F f : allFeatures) {
            if (f.enabledByDefault()) {
                flags |= f.getMask();
            }
        }
        return new JacksonFeatureSet<>(flags);
    }

    public static <F extends JacksonFeature> JacksonFeatureSet<F> fromBitmask(int bitmask) {
        return new JacksonFeatureSet<>(bitmask);
    }

    public JacksonFeatureSet<F> with(F feature) {
        int newMask = this._enabled | feature.getMask();
        return newMask == this._enabled ? this : new JacksonFeatureSet<>(newMask);
    }

    public JacksonFeatureSet<F> without(F feature) {
        int newMask = this._enabled & (feature.getMask() ^ -1);
        return newMask == this._enabled ? this : new JacksonFeatureSet<>(newMask);
    }

    public boolean isEnabled(F feature) {
        return (feature.getMask() & this._enabled) != 0;
    }

    public int asBitmask() {
        return this._enabled;
    }
}
