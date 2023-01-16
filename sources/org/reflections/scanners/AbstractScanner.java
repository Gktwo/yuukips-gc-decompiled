package org.reflections.scanners;

import java.util.List;
import java.util.Map;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/AbstractScanner.class */
class AbstractScanner implements Scanner {
    protected final Scanner scanner;

    /* access modifiers changed from: package-private */
    public AbstractScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    @Override // org.reflections.scanners.Scanner
    public String index() {
        return this.scanner.index();
    }

    @Override // org.reflections.scanners.Scanner
    public List<Map.Entry<String, String>> scan(ClassFile cls) {
        return this.scanner.scan(cls);
    }
}
