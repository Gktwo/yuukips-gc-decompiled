package org.reflections.scanners;

import java.util.List;
import java.util.Map;
import javassist.bytecode.ClassFile;

@Deprecated
/* loaded from: grasscutter.jar:org/reflections/scanners/SubTypesScanner.class */
public class SubTypesScanner extends AbstractScanner {
    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public /* bridge */ /* synthetic */ String index() {
        return index();
    }

    @Deprecated
    public SubTypesScanner() {
        super(Scanners.SubTypes);
    }

    @Deprecated
    public SubTypesScanner(boolean excludeObjectClass) {
        super(excludeObjectClass ? Scanners.SubTypes : Scanners.SubTypes.filterResultsBy(s -> {
            return true;
        }));
    }

    @Override // org.reflections.scanners.AbstractScanner, org.reflections.scanners.Scanner
    public List<Map.Entry<String, String>> scan(ClassFile cls) {
        return this.scanner.scan(cls);
    }
}
