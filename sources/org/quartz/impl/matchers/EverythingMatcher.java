package org.quartz.impl.matchers;

import org.quartz.JobKey;
import org.quartz.Matcher;
import org.quartz.TriggerKey;
import org.quartz.utils.Key;

/* loaded from: grasscutter.jar:org/quartz/impl/matchers/EverythingMatcher.class */
public class EverythingMatcher<T extends Key<?>> implements Matcher<T> {
    private static final long serialVersionUID = 202300056681974058L;

    protected EverythingMatcher() {
    }

    public static EverythingMatcher<JobKey> allJobs() {
        return new EverythingMatcher<>();
    }

    public static EverythingMatcher<TriggerKey> allTriggers() {
        return new EverythingMatcher<>();
    }

    @Override // org.quartz.Matcher
    public boolean isMatch(T key) {
        return true;
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass().equals(getClass());
    }

    @Override // org.quartz.Matcher, java.lang.Object
    public int hashCode() {
        return getClass().getName().hashCode();
    }
}
