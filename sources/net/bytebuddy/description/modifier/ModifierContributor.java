package net.bytebuddy.description.modifier;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import net.bytebuddy.build.HashCodeAndEqualsPlugin;

/* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor.class */
public interface ModifierContributor {
    public static final int EMPTY_MASK = 0;

    /* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor$ForField.class */
    public interface ForField extends ModifierContributor {
        public static final int MASK = 151775;
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor$ForMethod.class */
    public interface ForMethod extends ModifierContributor {
        public static final int MASK = 7679;
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor$ForParameter.class */
    public interface ForParameter extends ModifierContributor {
        public static final int MASK = 36880;
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor$ForType.class */
    public interface ForType extends ModifierContributor {
        public static final int MASK = 161311;
    }

    int getMask();

    int getRange();

    boolean isDefault();

    @HashCodeAndEqualsPlugin.Enhance
    /* loaded from: grasscutter.jar:net/bytebuddy/description/modifier/ModifierContributor$Resolver.class */
    public static class Resolver<T extends ModifierContributor> {
        private final Collection<? extends T> modifierContributors;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && this.modifierContributors.equals(((Resolver) obj).modifierContributors);
        }

        public int hashCode() {
            return (getClass().hashCode() * 31) + this.modifierContributors.hashCode();
        }

        protected Resolver(Collection<? extends T> modifierContributors) {
            this.modifierContributors = modifierContributors;
        }

        /* renamed from: of */
        public static Resolver<ForType> m251of(ForType... modifierContributor) {
            return m255of(Arrays.asList(modifierContributor));
        }

        /* renamed from: of */
        public static Resolver<ForField> m254of(ForField... modifierContributor) {
            return m255of(Arrays.asList(modifierContributor));
        }

        /* renamed from: of */
        public static Resolver<ForMethod> m253of(ForMethod... modifierContributor) {
            return m255of(Arrays.asList(modifierContributor));
        }

        /* renamed from: of */
        public static Resolver<ForParameter> m252of(ForParameter... modifierContributor) {
            return m255of(Arrays.asList(modifierContributor));
        }

        /* renamed from: of */
        public static <S extends ModifierContributor> Resolver<S> m255of(Collection<? extends S> modifierContributors) {
            return new Resolver<>(modifierContributors);
        }

        public int resolve() {
            return resolve(0);
        }

        public int resolve(int modifiers) {
            Iterator<? extends T> it = this.modifierContributors.iterator();
            while (it.hasNext()) {
                ModifierContributor modifierContributor = (ModifierContributor) it.next();
                modifiers = (modifiers & (modifierContributor.getRange() ^ -1)) | modifierContributor.getMask();
            }
            return modifiers;
        }
    }
}
