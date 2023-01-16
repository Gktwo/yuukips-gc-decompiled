package org.jline.reader.impl.completer;

import java.util.Objects;
import org.jline.reader.Candidate;

/* loaded from: grasscutter.jar:org/jline/reader/impl/completer/EnumCompleter.class */
public class EnumCompleter extends StringsCompleter {
    public EnumCompleter(Class<? extends Enum<?>> source) {
        Objects.requireNonNull(source);
        for (Enum<?> n : (Enum[]) source.getEnumConstants()) {
            this.candidates.add(new Candidate(n.name().toLowerCase()));
        }
    }
}
