package org.eclipse.jetty.util.ssl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.eclipse.jetty.util.component.Dumpable;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslSelectionDump.class */
class SslSelectionDump implements Dumpable {
    final String type;
    final CaptionedList enabled = new CaptionedList("Enabled");
    final CaptionedList disabled = new CaptionedList("Disabled");

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/SslSelectionDump$CaptionedList.class */
    static class CaptionedList extends ArrayList<String> implements Dumpable {
        private final String caption;

        public CaptionedList(String caption) {
            this.caption = caption;
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public String dump() {
            return Dumpable.dump(this);
        }

        @Override // org.eclipse.jetty.util.component.Dumpable
        public void dump(Appendable out, String indent) throws IOException {
            Object[] array = toArray();
            Dumpable.dumpObjects(out, indent, this.caption + " size=" + array.length, array);
        }
    }

    public SslSelectionDump(String type, String[] supportedByJVM, String[] enabledByJVM, String[] excludedByConfig, String[] includedByConfig) {
        this.type = type;
        List<String> jvmEnabled = Arrays.asList(enabledByJVM);
        List<Pattern> excludedPatterns = (List) Arrays.stream(excludedByConfig).map(entry -> {
            return Pattern.compile(entry);
        }).collect(Collectors.toList());
        List<Pattern> includedPatterns = (List) Arrays.stream(includedByConfig).map(entry -> {
            return Pattern.compile(entry);
        }).collect(Collectors.toList());
        Arrays.stream(supportedByJVM).sorted(Comparator.naturalOrder()).forEach(entry -> {
            boolean isPresent = true;
            StringBuilder s = new StringBuilder();
            s.append(jvmEnabled);
            Iterator it = excludedPatterns.iterator();
            while (it.hasNext()) {
                Pattern pattern = (Pattern) it.next();
                if (pattern.matcher(jvmEnabled).matches()) {
                    if (isPresent) {
                        s.append(" -");
                        isPresent = false;
                    } else {
                        s.append(",");
                    }
                    s.append(" ConfigExcluded:'").append(pattern.pattern()).append('\'');
                }
            }
            boolean isIncluded = false;
            if (!excludedPatterns.isEmpty()) {
                Iterator it2 = excludedPatterns.iterator();
                while (true) {
                    if (it2.hasNext()) {
                        if (((Pattern) it2.next()).matcher(jvmEnabled).matches()) {
                            isIncluded = true;
                            break;
                        }
                    } else {
                        break;
                    }
                }
                if (!isIncluded) {
                    if (isPresent) {
                        s.append(" -");
                        isPresent = false;
                    } else {
                        s.append(",");
                    }
                    s.append(" ConfigIncluded:NotSelected");
                }
            }
            if (!isIncluded && !includedPatterns.contains(jvmEnabled)) {
                if (isPresent) {
                    s.append(" -");
                    isPresent = false;
                }
                s.append(" JVM:disabled");
            }
            if (isPresent) {
                this.enabled.add(s.toString());
            } else {
                this.disabled.add(s.toString());
            }
        });
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public String dump() {
        return Dumpable.dump(this);
    }

    @Override // org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        Dumpable.dumpObjects(out, indent, this, this.enabled, this.disabled);
    }

    public String toString() {
        return String.format("%s Selections", this.type);
    }
}
