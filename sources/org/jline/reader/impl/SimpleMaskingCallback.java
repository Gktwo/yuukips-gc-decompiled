package org.jline.reader.impl;

import java.util.Objects;
import org.jline.reader.MaskingCallback;

/* loaded from: grasscutter.jar:org/jline/reader/impl/SimpleMaskingCallback.class */
public final class SimpleMaskingCallback implements MaskingCallback {
    private final Character mask;

    public SimpleMaskingCallback(Character mask) {
        this.mask = (Character) Objects.requireNonNull(mask, "mask must be a non null character");
    }

    @Override // org.jline.reader.MaskingCallback
    public String display(String line) {
        if (this.mask.equals((char) 0)) {
            return "";
        }
        StringBuilder sb = new StringBuilder(line.length());
        int i = line.length();
        while (true) {
            i--;
            if (i <= 0) {
                return sb.toString();
            }
            sb.append(this.mask.charValue());
        }
    }

    @Override // org.jline.reader.MaskingCallback
    public String history(String line) {
        return null;
    }
}
