package com.mchange.p009v2.cmdline;

/* renamed from: com.mchange.v2.cmdline.UnexpectedSwitchException */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/UnexpectedSwitchException.class */
public class UnexpectedSwitchException extends BadCommandLineException {

    /* renamed from: sw */
    String f411sw;

    /* access modifiers changed from: package-private */
    public UnexpectedSwitchException(String str, String str2) {
        super(str);
        this.f411sw = str2;
    }

    public String getUnexpectedSwitch() {
        return this.f411sw;
    }
}
