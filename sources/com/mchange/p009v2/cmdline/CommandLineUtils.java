package com.mchange.p009v2.cmdline;

/* renamed from: com.mchange.v2.cmdline.CommandLineUtils */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/CommandLineUtils.class */
public final class CommandLineUtils {
    public static ParsedCommandLine parse(String[] strArr, String str, String[] strArr2, String[] strArr3, String[] strArr4) throws BadCommandLineException {
        return new ParsedCommandLineImpl(strArr, str, strArr2, strArr3, strArr4);
    }

    private CommandLineUtils() {
    }
}
