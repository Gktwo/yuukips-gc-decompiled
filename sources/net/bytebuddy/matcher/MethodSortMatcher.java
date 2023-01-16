package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.method.MethodDescription;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/MethodSortMatcher.class */
public class MethodSortMatcher<T extends MethodDescription> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Sort sort;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.sort.equals(((MethodSortMatcher) obj).sort);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.sort.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.MethodSortMatcher<T extends net.bytebuddy.description.method.MethodDescription> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((MethodSortMatcher<T>) ((MethodDescription) obj));
    }

    /* renamed from: of */
    public static <T extends MethodDescription> ElementMatcher.Junction<T> m95of(Sort sort) {
        return sort.getMatcher();
    }

    public MethodSortMatcher(Sort sort) {
        this.sort = sort;
    }

    public boolean matches(T target) {
        return this.sort.isSort(target);
    }

    public String toString() {
        return this.sort.getDescription();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/MethodSortMatcher$Sort.class */
    public enum Sort {
        METHOD("isMethod()") {
            @Override // net.bytebuddy.matcher.MethodSortMatcher.Sort
            protected boolean isSort(MethodDescription target) {
                return target.isMethod();
            }
        },
        CONSTRUCTOR("isConstructor()") {
            @Override // net.bytebuddy.matcher.MethodSortMatcher.Sort
            protected boolean isSort(MethodDescription target) {
                return target.isConstructor();
            }
        },
        TYPE_INITIALIZER("isTypeInitializer()") {
            @Override // net.bytebuddy.matcher.MethodSortMatcher.Sort
            protected boolean isSort(MethodDescription target) {
                return target.isTypeInitializer();
            }
        },
        VIRTUAL("isVirtual()") {
            @Override // net.bytebuddy.matcher.MethodSortMatcher.Sort
            protected boolean isSort(MethodDescription target) {
                return target.isVirtual();
            }
        },
        DEFAULT_METHOD("isDefaultMethod()") {
            @Override // net.bytebuddy.matcher.MethodSortMatcher.Sort
            protected boolean isSort(MethodDescription target) {
                return target.isDefaultMethod();
            }
        };
        
        private final String description;
        private final MethodSortMatcher<?> matcher;

        protected abstract boolean isSort(MethodDescription methodDescription);

        Sort(String description) {
            this.description = description;
            this.matcher = new MethodSortMatcher<>(this);
        }

        protected String getDescription() {
            return this.description;
        }

        protected MethodSortMatcher<?> getMatcher() {
            return this.matcher;
        }
    }
}
