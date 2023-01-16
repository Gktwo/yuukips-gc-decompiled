package org.reflections.scanners;

import java.util.List;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/TypeAnnotationsScanner.class */
public class TypeAnnotationsScanner extends AbstractScanner {
    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ List scan(ClassFile classFile) {
        return scan(classFile);
    }

    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ String index() {
        return index();
    }

    @Deprecated
    public TypeAnnotationsScanner() {
        super(Scanners.TypesAnnotated);
    }
}
