package com.mchange.p009v2.cmdline;

/* renamed from: com.mchange.v2.cmdline.UnexpectedSwitchArgumentException */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/UnexpectedSwitchArgumentException.class */
public class UnexpectedSwitchArgumentException extends BadCommandLineException {

    /* renamed from: sw */
    String f410sw;
    String arg;

    /* access modifiers changed from: package-private */
    public UnexpectedSwitchArgumentException(String str, String str2, String str3) {
        super(str);
        this.f410sw = str2;
        this.arg = str3;
    }

    public String getSwitch() {
        return this.f410sw;
    }

    public String getUnexpectedArgument() {
        return this.arg;
    }
}
