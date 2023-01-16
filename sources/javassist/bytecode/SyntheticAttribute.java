package javassist.bytecode;

import java.io.DataInputStream;
import java.io.IOException;
import java.util.Map;

/* loaded from: grasscutter.jar:javassist/bytecode/SyntheticAttribute.class */
public class SyntheticAttribute extends AttributeInfo {
    public static final String tag = "Synthetic";

    /* access modifiers changed from: package-private */
    public SyntheticAttribute(ConstPool cp, int n, DataInputStream in) throws IOException {
        super(cp, n, in);
    }

    public SyntheticAttribute(ConstPool cp) {
        super(cp, tag, new byte[0]);
    }

    @Override // javassist.bytecode.AttributeInfo
    public AttributeInfo copy(ConstPool newCp, Map<String, String> classnames) {
        return new SyntheticAttribute(newCp);
    }
}
