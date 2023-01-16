package com.esotericsoftware.asm;

/* access modifiers changed from: package-private */
/* loaded from: grasscutter.jar:com/esotericsoftware/asm/Item.class */
public final class Item {

    /* renamed from: a */
    int f135a;

    /* renamed from: b */
    int f136b;

    /* renamed from: c */
    int f137c;

    /* renamed from: d */
    long f138d;

    /* renamed from: g */
    String f139g;

    /* renamed from: h */
    String f140h;

    /* renamed from: i */
    String f141i;

    /* renamed from: j */
    int f142j;

    /* renamed from: k */
    Item f143k;

    /* access modifiers changed from: package-private */
    public Item() {
    }

    /* access modifiers changed from: package-private */
    public Item(int i) {
        this.f135a = i;
    }

    /* access modifiers changed from: package-private */
    public Item(int i, Item item) {
        this.f135a = i;
        this.f136b = item.f136b;
        this.f137c = item.f137c;
        this.f138d = item.f138d;
        this.f139g = item.f139g;
        this.f140h = item.f140h;
        this.f141i = item.f141i;
        this.f142j = item.f142j;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1516a(int i) {
        this.f136b = 3;
        this.f137c = i;
        this.f142j = Integer.MAX_VALUE & (this.f136b + i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1513a(long j) {
        this.f136b = 5;
        this.f138d = j;
        this.f142j = Integer.MAX_VALUE & (this.f136b + ((int) j));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1517a(float f) {
        this.f136b = 4;
        this.f137c = Float.floatToRawIntBits(f);
        this.f142j = Integer.MAX_VALUE & (this.f136b + ((int) f));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1518a(double d) {
        this.f136b = 6;
        this.f138d = Double.doubleToRawLongBits(d);
        this.f142j = Integer.MAX_VALUE & (this.f136b + ((int) d));
    }

    /* JADX INFO: Can't fix incorrect switch cases order, some code will duplicate */
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1514a(int i, String str, String str2, String str3) {
        this.f136b = i;
        this.f139g = str;
        this.f140h = str2;
        this.f141i = str3;
        switch (i) {
            case 1:
            case 8:
            case 16:
            case 30:
                break;
            case 7:
                this.f137c = 0;
                break;
            case 12:
                this.f142j = Integer.MAX_VALUE & (i + (str.hashCode() * str2.hashCode()));
                return;
            default:
                this.f142j = Integer.MAX_VALUE & (i + (str.hashCode() * str2.hashCode() * str3.hashCode()));
                return;
        }
        this.f142j = Integer.MAX_VALUE & (i + str.hashCode());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1511a(String str, String str2, int i) {
        this.f136b = 18;
        this.f138d = (long) i;
        this.f139g = str;
        this.f140h = str2;
        this.f142j = Integer.MAX_VALUE & (18 + (i * this.f139g.hashCode() * this.f140h.hashCode()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void m1515a(int i, int i2) {
        this.f136b = 33;
        this.f137c = i;
        this.f142j = i2;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean m1512a(Item item) {
        switch (this.f136b) {
            case 1:
            case 7:
            case 8:
            case 16:
            case 30:
                return item.f139g.equals(this.f139g);
            case 2:
            case 9:
            case 10:
            case 11:
            case 13:
            case 14:
            case 15:
            case 17:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
            case 28:
            case 29:
            default:
                return item.f139g.equals(this.f139g) && item.f140h.equals(this.f140h) && item.f141i.equals(this.f141i);
            case 3:
            case 4:
                return item.f137c == this.f137c;
            case 5:
            case 6:
            case 32:
                return item.f138d == this.f138d;
            case 12:
                return item.f139g.equals(this.f139g) && item.f140h.equals(this.f140h);
            case 18:
                return item.f138d == this.f138d && item.f139g.equals(this.f139g) && item.f140h.equals(this.f140h);
            case 31:
                return item.f137c == this.f137c && item.f139g.equals(this.f139g);
        }
    }
}
