package net.bytebuddy.matcher;

import net.bytebuddy.build.HashCodeAndEqualsPlugin;
import net.bytebuddy.description.ModifierReviewable;
import net.bytebuddy.matcher.ElementMatcher;

@HashCodeAndEqualsPlugin.Enhance
/* loaded from: grasscutter.jar:net/bytebuddy/matcher/ModifierMatcher.class */
public class ModifierMatcher<T extends ModifierReviewable> extends ElementMatcher.Junction.AbstractBase<T> {
    private final Mode mode;

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.mode.equals(((ModifierMatcher) obj).mode);
    }

    public int hashCode() {
        return (getClass().hashCode() * 31) + this.mode.hashCode();
    }

    /* JADX DEBUG: Multi-variable search result rejected for r3v0, resolved type: net.bytebuddy.matcher.ModifierMatcher<T extends net.bytebuddy.description.ModifierReviewable> */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // net.bytebuddy.matcher.ElementMatcher
    public /* bridge */ /* synthetic */ boolean matches(Object obj) {
        return matches((ModifierMatcher<T>) ((ModifierReviewable) obj));
    }

    /* renamed from: of */
    public static <T extends ModifierReviewable> ElementMatcher.Junction<T> m94of(Mode mode) {
        return mode.getMatcher();
    }

    public ModifierMatcher(Mode mode) {
        this.mode = mode;
    }

    public boolean matches(T target) {
        return (this.mode.getModifiers() & target.getModifiers()) != 0;
    }

    public String toString() {
        return this.mode.getDescription();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/matcher/ModifierMatcher$Mode.class */
    public enum Mode {
        PUBLIC(1, "isPublic()"),
        PROTECTED(4, "isProtected()"),
        PRIVATE(2, "isPrivate()"),
        FINAL(16, "isFinal()"),
        STATIC(8, "isStatic()"),
        SYNCHRONIZED(32, "isSynchronized()"),
        NATIVE(256, "isNative()"),
        STRICT(2048, "isStrict()"),
        VAR_ARGS(128, "isVarArgs()"),
        SYNTHETIC(4096, "isSynthetic()"),
        BRIDGE(64, "isBridge()"),
        ABSTRACT(1024, "isAbstract()"),
        INTERFACE(512, "isInterface()"),
        ANNOTATION(8192, "isAnnotation()"),
        VOLATILE(64, "isVolatile()"),
        TRANSIENT(128, "isTransient()"),
        MANDATED(32768, "isMandated()"),
        ENUMERATION(16384, "isEnum()");
        
        private final int modifiers;
        private final String description;
        private final ModifierMatcher<?> matcher = new ModifierMatcher<>(this);

        Mode(int modifiers, String description) {
            this.modifiers = modifiers;
            this.description = description;
        }

        protected String getDescription() {
            return this.description;
        }

        protected int getModifiers() {
            return this.modifiers;
        }

        protected ModifierMatcher<?> getMatcher() {
            return this.matcher;
        }
    }
}
