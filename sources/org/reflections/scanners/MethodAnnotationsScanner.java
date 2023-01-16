package org.reflections.scanners;

import java.util.List;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/MethodAnnotationsScanner.class */
public class MethodAnnotationsScanner extends AbstractScanner {
    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ List scan(ClassFile classFile) {
        return scan(classFile);
    }

    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ String index() {
        return index();
    }

    @Deprecated
    public MethodAnnotationsScanner() {
        super(Scanners.MethodsAnnotated);
    }
}
