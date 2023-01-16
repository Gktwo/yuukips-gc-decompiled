package com.mchange.p009v2.cmdline;

/* renamed from: com.mchange.v2.cmdline.ParsedCommandLine */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/ParsedCommandLine.class */
public interface ParsedCommandLine {
    String[] getRawArgs();

    String getSwitchPrefix();

    boolean includesSwitch(String str);

    String getSwitchArg(String str);

    String[] getUnswitchedArgs();
}
