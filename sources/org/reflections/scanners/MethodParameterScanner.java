package org.reflections.scanners;

import java.util.List;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/MethodParameterScanner.class */
public class MethodParameterScanner extends AbstractScanner {
    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ List scan(ClassFile classFile) {
        return scan(classFile);
    }

    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ String index() {
        return index();
    }

    @Deprecated
    public MethodParameterScanner() {
        super(Scanners.MethodsParameter);
    }
}
