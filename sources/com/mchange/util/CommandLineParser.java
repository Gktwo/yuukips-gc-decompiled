package com.mchange.util;

/* loaded from: grasscutter.jar:com/mchange/util/CommandLineParser.class */
public interface CommandLineParser {
    boolean checkSwitch(String str);

    String findSwitchArg(String str);

    boolean checkArgv();

    int findLastSwitched();

    String[] findUnswitchedArgs();
}
