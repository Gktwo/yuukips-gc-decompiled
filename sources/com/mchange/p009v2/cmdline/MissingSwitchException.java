package com.mchange.p009v2.cmdline;

/* renamed from: com.mchange.v2.cmdline.MissingSwitchException */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/MissingSwitchException.class */
public class MissingSwitchException extends BadCommandLineException {

    /* renamed from: sw */
    String f409sw;

    /* access modifiers changed from: package-private */
    public MissingSwitchException(String str, String str2) {
        super(str);
        this.f409sw = str2;
    }

    public String getMissingSwitch() {
        return this.f409sw;
    }
}
