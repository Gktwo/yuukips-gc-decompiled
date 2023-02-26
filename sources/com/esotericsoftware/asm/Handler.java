package com.esotericsoftware.asm;

/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Handler.class */
class Handler {

    /* renamed from: a */
    Label f129a;

    /* renamed from: b */
    Label f130b;

    /* renamed from: c */
    Label f131c;

    /* renamed from: d */
    String f132d;

    /* renamed from: e */
    int f133e;

    /* renamed from: f */
    Handler f134f;

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public static Handler m1519a(Handler handler, Label label, Label label2) {
        if (handler == null) {
            return null;
        }
        handler.f134f = m1519a(handler.f134f, label, label2);
        int i = handler.f129a.f146c;
        int i2 = handler.f130b.f146c;
        int i3 = label.f146c;
        int i4 = label2 == null ? Integer.MAX_VALUE : label2.f146c;
        if (i3 < i2 && i4 > i) {
            if (i3 <= i) {
                if (i4 >= i2) {
                    handler = handler.f134f;
                } else {
                    handler.f129a = label2;
                }
            } else if (i4 >= i2) {
                handler.f130b = label;
            } else {
                Handler handler2 = new Handler();
                handler2.f129a = label2;
                handler2.f130b = handler.f130b;
                handler2.f131c = handler.f131c;
                handler2.f132d = handler.f132d;
                handler2.f133e = handler.f133e;
                handler2.f134f = handler.f134f;
                handler.f130b = label;
                handler.f134f = handler2;
            }
        }
        return handler;
    }
}
