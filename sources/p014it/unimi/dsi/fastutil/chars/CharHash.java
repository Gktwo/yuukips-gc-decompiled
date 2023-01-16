package p014it.unimi.dsi.fastutil.chars;

/* renamed from: it.unimi.dsi.fastutil.chars.CharHash */
/* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharHash.class */
public interface CharHash {

    /* renamed from: it.unimi.dsi.fastutil.chars.CharHash$Strategy */
    /* loaded from: grasscutter.jar:it/unimi/dsi/fastutil/chars/CharHash$Strategy.class */
    public interface Strategy {
        int hashCode(char c);

        boolean equals(char c, char c2);
    }
}
