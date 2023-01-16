package javassist.tools.web;

/* loaded from: grasscutter.jar:javassist/tools/web/BadHttpRequest.class */
public class BadHttpRequest extends Exception {
    private static final long serialVersionUID = 1;

    /* renamed from: e */
    private Exception f3081e;

    public BadHttpRequest() {
        this.f3081e = null;
    }

    public BadHttpRequest(Exception _e) {
        this.f3081e = _e;
    }

    @Override // java.lang.Throwable, java.lang.Object
    public String toString() {
        if (this.f3081e == null) {
            return toString();
        }
        return this.f3081e.toString();
    }
}
