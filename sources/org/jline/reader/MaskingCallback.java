package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/MaskingCallback.class */
public interface MaskingCallback {
    String display(String str);

    String history(String str);
}
