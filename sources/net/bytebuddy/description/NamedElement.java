package net.bytebuddy.description;

/* loaded from: grasscutter.jar:net/bytebuddy/description/NamedElement.class */
public interface NamedElement {
    public static final String NO_NAME = null;
    public static final String EMPTY_NAME = "";

    /* loaded from: grasscutter.jar:net/bytebuddy/description/NamedElement$WithDescriptor.class */
    public interface WithDescriptor extends NamedElement {
        public static final String NON_GENERIC_SIGNATURE = null;

        String getDescriptor();

        String getGenericSignature();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/NamedElement$WithGenericName.class */
    public interface WithGenericName extends WithRuntimeName {
        String toGenericString();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/NamedElement$WithOptionalName.class */
    public interface WithOptionalName extends NamedElement {
        boolean isNamed();
    }

    /* loaded from: grasscutter.jar:net/bytebuddy/description/NamedElement$WithRuntimeName.class */
    public interface WithRuntimeName extends NamedElement {
        String getName();

        String getInternalName();
    }

    String getActualName();
}
