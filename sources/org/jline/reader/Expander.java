package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/Expander.class */
public interface Expander {
    String expandHistory(History history, String str);

    String expandVar(String str);
}
