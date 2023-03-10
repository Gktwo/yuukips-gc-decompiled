package org.jline.reader;

/* loaded from: grasscutter.jar:org/jline/reader/UserInterruptException.class */
public class UserInterruptException extends RuntimeException {
    private static final long serialVersionUID = 6172232572140736750L;
    private final String partialLine;

    public UserInterruptException(String partialLine) {
        this.partialLine = partialLine;
    }

    public String getPartialLine() {
        return this.partialLine;
    }
}
