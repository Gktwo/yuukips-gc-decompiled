package nonapi.p019io.github.classgraph.json;

/* access modifiers changed from: package-private */
/* renamed from: nonapi.io.github.classgraph.json.JSONReference */
/* loaded from: grasscutter.jar:nonapi/io/github/classgraph/json/JSONReference.class */
public class JSONReference {
    Object idObject;

    public JSONReference(Object idObject) {
        if (idObject == null) {
            throw new IllegalArgumentException("idObject cannot be null");
        }
        this.idObject = idObject;
    }
}
