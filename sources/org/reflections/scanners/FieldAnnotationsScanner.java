package org.reflections.scanners;

import java.util.List;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/FieldAnnotationsScanner.class */
public class FieldAnnotationsScanner extends AbstractScanner {
    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ List scan(ClassFile classFile) {
        return scan(classFile);
    }

    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ String index() {
        return index();
    }

    @Deprecated
    public FieldAnnotationsScanner() {
        super(Scanners.FieldsAnnotated);
    }
}
