package javax.servlet;

import javax.servlet.annotation.ServletSecurity;

/* loaded from: grasscutter.jar:javax/servlet/HttpConstraintElement.class */
public class HttpConstraintElement {
    private ServletSecurity.EmptyRoleSemantic emptyRoleSemantic;
    private ServletSecurity.TransportGuarantee transportGuarantee;
    private String[] rolesAllowed;

    public HttpConstraintElement() {
        this(ServletSecurity.EmptyRoleSemantic.PERMIT);
    }

    public HttpConstraintElement(ServletSecurity.EmptyRoleSemantic semantic) {
        this(semantic, ServletSecurity.TransportGuarantee.NONE, new String[0]);
    }

    public HttpConstraintElement(ServletSecurity.TransportGuarantee guarantee, String... roleNames) {
        this(ServletSecurity.EmptyRoleSemantic.PERMIT, guarantee, roleNames);
    }

    public HttpConstraintElement(ServletSecurity.EmptyRoleSemantic semantic, ServletSecurity.TransportGuarantee guarantee, String... roleNames) {
        if (semantic != ServletSecurity.EmptyRoleSemantic.DENY || roleNames.length <= 0) {
            this.emptyRoleSemantic = semantic;
            this.transportGuarantee = guarantee;
            this.rolesAllowed = copyStrings(roleNames);
            return;
        }
        throw new IllegalArgumentException("Deny semantic with rolesAllowed");
    }

    public ServletSecurity.EmptyRoleSemantic getEmptyRoleSemantic() {
        return this.emptyRoleSemantic;
    }

    public ServletSecurity.TransportGuarantee getTransportGuarantee() {
        return this.transportGuarantee;
    }

    public String[] getRolesAllowed() {
        return copyStrings(this.rolesAllowed);
    }

    private String[] copyStrings(String[] strings) {
        String[] arr = null;
        if (strings != null) {
            int len = strings.length;
            arr = new String[len];
            if (len > 0) {
                System.arraycopy(strings, 0, arr, 0, len);
            }
        }
        return arr != null ? arr : new String[0];
    }
}
