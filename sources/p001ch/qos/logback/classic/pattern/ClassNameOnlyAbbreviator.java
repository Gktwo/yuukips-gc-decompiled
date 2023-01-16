package p001ch.qos.logback.classic.pattern;

/* renamed from: ch.qos.logback.classic.pattern.ClassNameOnlyAbbreviator */
/* loaded from: grasscutter.jar:ch/qos/logback/classic/pattern/ClassNameOnlyAbbreviator.class */
public class ClassNameOnlyAbbreviator implements Abbreviator {
    @Override // p001ch.qos.logback.classic.pattern.Abbreviator
    public String abbreviate(String fqClassName) {
        int lastIndex = fqClassName.lastIndexOf(46);
        if (lastIndex != -1) {
            return fqClassName.substring(lastIndex + 1, fqClassName.length());
        }
        return fqClassName;
    }
}
