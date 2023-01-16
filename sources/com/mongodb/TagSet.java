package com.mongodb;

import com.mongodb.annotations.Immutable;
import com.mongodb.assertions.Assertions;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@Immutable
/* loaded from: grasscutter.jar:com/mongodb/TagSet.class */
public final class TagSet implements Iterable<Tag> {
    private final List<Tag> wrapped;

    public TagSet() {
        this.wrapped = Collections.emptyList();
    }

    public TagSet(Tag tag) {
        Assertions.notNull("tag", tag);
        this.wrapped = Collections.singletonList(tag);
    }

    public TagSet(List<Tag> tagList) {
        Assertions.notNull("tagList", tagList);
        Set<String> tagNames = new HashSet<>();
        for (Tag tag : tagList) {
            if (tag == null) {
                throw new IllegalArgumentException("Null tags are not allowed");
            } else if (!tagNames.add(tag.getName())) {
                throw new IllegalArgumentException("Duplicate tag names not allowed in a tag set: " + tag.getName());
            }
        }
        ArrayList<Tag> copy = new ArrayList<>(tagList);
        Collections.sort(copy, new Comparator<Tag>() { // from class: com.mongodb.TagSet.1
            public int compare(Tag o1, Tag o2) {
                return o1.getName().compareTo(o2.getName());
            }
        });
        this.wrapped = Collections.unmodifiableList(copy);
    }

    @Override // java.lang.Iterable
    public Iterator<Tag> iterator() {
        return this.wrapped.iterator();
    }

    public boolean containsAll(TagSet tagSet) {
        return this.wrapped.containsAll(tagSet.wrapped);
    }

    @Override // java.lang.Object
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass() || !this.wrapped.equals(((TagSet) o).wrapped)) {
            return false;
        }
        return true;
    }

    @Override // java.lang.Object
    public int hashCode() {
        return this.wrapped.hashCode();
    }

    @Override // java.lang.Object
    public String toString() {
        return "TagSet{" + this.wrapped + '}';
    }
}
