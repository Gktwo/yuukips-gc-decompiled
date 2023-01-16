package emu.grasscutter.data.common;

import java.util.List;
import p014it.unimi.dsi.fastutil.floats.FloatArrayList;
import p014it.unimi.dsi.fastutil.objects.Object2FloatArrayMap;
import p014it.unimi.dsi.fastutil.objects.Object2FloatMap;

/* loaded from: grasscutter.jar:emu/grasscutter/data/common/DynamicFloat.class */
public class DynamicFloat {
    public static DynamicFloat ZERO = new DynamicFloat(0.0f);
    private List<StackOp> ops;
    private boolean dynamic;
    private float constant;

    /* loaded from: grasscutter.jar:emu/grasscutter/data/common/DynamicFloat$StackOp.class */
    public static class StackOp {

        /* renamed from: op */
        public EnumC1353Op f507op;
        public float fValue;
        public String sValue;

        /* access modifiers changed from: package-private */
        /* renamed from: emu.grasscutter.data.common.DynamicFloat$StackOp$Op */
        /* loaded from: grasscutter.jar:emu/grasscutter/data/common/DynamicFloat$StackOp$Op.class */
        public enum EnumC1353Op {
            CONSTANT,
            KEY,
            ADD,
            SUB,
            MUL,
            DIV
        }

        public StackOp(String s) {
            String upperCase = s.toUpperCase();
            char c = 65535;
            switch (upperCase.hashCode()) {
                case 64641:
                    if (upperCase.equals("ADD")) {
                        c = 0;
                        break;
                    }
                    break;
                case 67697:
                    if (upperCase.equals("DIV")) {
                        c = 3;
                        break;
                    }
                    break;
                case 76708:
                    if (upperCase.equals("MUL")) {
                        c = 2;
                        break;
                    }
                    break;
                case 82464:
                    if (upperCase.equals("SUB")) {
                        c = 1;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    this.f507op = EnumC1353Op.ADD;
                    return;
                case 1:
                    this.f507op = EnumC1353Op.SUB;
                    return;
                case 2:
                    this.f507op = EnumC1353Op.MUL;
                    return;
                case 3:
                    this.f507op = EnumC1353Op.DIV;
                    return;
                default:
                    this.f507op = EnumC1353Op.KEY;
                    this.sValue = s;
                    return;
            }
        }

        public StackOp(float f) {
            this.f507op = EnumC1353Op.CONSTANT;
            this.fValue = f;
        }
    }

    public DynamicFloat(float constant) {
        this.dynamic = false;
        this.constant = 0.0f;
        this.constant = constant;
    }

    public DynamicFloat(String key) {
        this.dynamic = false;
        this.constant = 0.0f;
        this.dynamic = true;
        this.ops = List.of(new StackOp(key));
    }

    public DynamicFloat(List<StackOp> ops) {
        this.dynamic = false;
        this.constant = 0.0f;
        this.dynamic = true;
        this.ops = ops;
    }

    public float get() {
        return get(new Object2FloatArrayMap());
    }

    public float get(Object2FloatMap<String> props) {
        if (!this.dynamic) {
            return this.constant;
        }
        FloatArrayList fl = new FloatArrayList();
        for (StackOp op : this.ops) {
            switch (op.f507op) {
                case CONSTANT:
                    fl.push(op.fValue);
                    break;
                case KEY:
                    fl.push(props.getOrDefault(op.sValue, 0.0f));
                    break;
                case ADD:
                    fl.push(fl.popFloat() + fl.popFloat());
                    break;
                case SUB:
                    fl.push((-fl.popFloat()) + fl.popFloat());
                    break;
                case MUL:
                    fl.push(fl.popFloat() * fl.popFloat());
                    break;
                case DIV:
                    fl.push((1.0f / fl.popFloat()) * fl.popFloat());
                    break;
            }
        }
        return fl.popFloat();
    }
}
