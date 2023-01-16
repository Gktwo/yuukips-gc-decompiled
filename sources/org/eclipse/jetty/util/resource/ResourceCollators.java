package org.eclipse.jetty.util.resource;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/resource/ResourceCollators.class */
public class ResourceCollators {
    private static Comparator<? super Resource> BY_NAME_ASCENDING = new Comparator<Resource>() { // from class: org.eclipse.jetty.util.resource.ResourceCollators.1
        private final Collator collator = Collator.getInstance(Locale.ENGLISH);

        public int compare(Resource o1, Resource o2) {
            return this.collator.compare(o1.getName(), o2.getName());
        }
    };
    private static Comparator<? super Resource> BY_NAME_DESCENDING = Collections.reverseOrder(BY_NAME_ASCENDING);
    private static Comparator<? super Resource> BY_LAST_MODIFIED_ASCENDING = new Comparator<Resource>() { // from class: org.eclipse.jetty.util.resource.ResourceCollators.2
        public int compare(Resource o1, Resource o2) {
            return Long.compare(o1.lastModified(), o2.lastModified());
        }
    };
    private static Comparator<? super Resource> BY_LAST_MODIFIED_DESCENDING = Collections.reverseOrder(BY_LAST_MODIFIED_ASCENDING);
    private static Comparator<? super Resource> BY_SIZE_ASCENDING = new Comparator<Resource>() { // from class: org.eclipse.jetty.util.resource.ResourceCollators.3
        public int compare(Resource o1, Resource o2) {
            return Long.compare(o1.length(), o2.length());
        }
    };
    private static Comparator<? super Resource> BY_SIZE_DESCENDING = Collections.reverseOrder(BY_SIZE_ASCENDING);

    public static Comparator<? super Resource> byLastModified(boolean sortOrderAscending) {
        if (sortOrderAscending) {
            return BY_LAST_MODIFIED_ASCENDING;
        }
        return BY_LAST_MODIFIED_DESCENDING;
    }

    public static Comparator<? super Resource> byName(boolean sortOrderAscending) {
        if (sortOrderAscending) {
            return BY_NAME_ASCENDING;
        }
        return BY_NAME_DESCENDING;
    }

    public static Comparator<? super Resource> bySize(boolean sortOrderAscending) {
        if (sortOrderAscending) {
            return BY_SIZE_ASCENDING;
        }
        return BY_SIZE_DESCENDING;
    }
}
