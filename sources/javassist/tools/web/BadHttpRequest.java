package javassist.tools.web;

/* loaded from: grasscutter.jar:javassist/tools/web/BadHttpRequest.class */
public class BadHttpRequest extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: e */
    private Exception f3045e;

    public BadHttpRequest() {
        this.f3045e = null;
    }

    public BadHttpRequest(Exception _e) {
        this.f3045e = _e;
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        if (this.f3045e == null) {
            return toString();
        }
        return this.f3045e.toString();
    }
}
