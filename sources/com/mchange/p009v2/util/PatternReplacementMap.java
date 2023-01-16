package com.mchange.p009v2.util;

import com.mchange.p006v1.util.WrapperIterator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: com.mchange.v2.util.PatternReplacementMap */
/* loaded from: grasscutter.jar:com/mchange/v2/util/PatternReplacementMap.class */
public final class PatternReplacementMap {
    List mappings = new LinkedList();

    public synchronized void addMapping(Pattern pattern, String str) {
        this.mappings.add(new Mapping(pattern, str));
    }

    public synchronized void removeMapping(Pattern pattern) {
        int size = this.mappings.size();
        for (int i = 0; i < size; i++) {
            if (((Mapping) this.mappings.get(i)).getPattern().equals(pattern)) {
                this.mappings.remove(i);
            }
        }
    }

    public synchronized Iterator patterns() {
        return new WrapperIterator(this.mappings.iterator(), true) { // from class: com.mchange.v2.util.PatternReplacementMap.1
            @Override // com.mchange.p006v1.util.WrapperIterator
            protected Object transformObject(Object obj) {
                return ((Mapping) obj).getPattern();
            }
        };
    }

    public synchronized int size() {
        return this.mappings.size();
    }

    public synchronized String attemptReplace(String str) {
        String str2 = null;
        Iterator it = this.mappings.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Mapping mapping = (Mapping) it.next();
            Matcher matcher = mapping.getPattern().matcher(str);
            if (matcher.matches()) {
                str2 = matcher.replaceAll(mapping.getReplacement());
                break;
            }
        }
        return str2;
    }

    /* renamed from: com.mchange.v2.util.PatternReplacementMap$Mapping */
    /* loaded from: grasscutter.jar:com/mchange/v2/util/PatternReplacementMap$Mapping.class */
    private static final class Mapping {
        Pattern pattern;
        String replacement;

        public Pattern getPattern() {
            return this.pattern;
        }

        public String getReplacement() {
            return this.replacement;
        }

        public Mapping(Pattern pattern, String str) {
            this.pattern = pattern;
            this.replacement = str;
        }
    }
}
