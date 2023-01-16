package javassist;

/* compiled from: ClassPoolTail.java */
/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:javassist/ClassPathList.class */
public final class ClassPathList {
    ClassPathList next;
    ClassPath path;

    /* access modifiers changed from: package-private */
    public ClassPathList(ClassPath p, ClassPathList n) {
        this.next = n;
        this.path = p;
    }
}
