package com.mchange.p009v2.cmdline;

import java.util.HashMap;
import java.util.LinkedList;

/* renamed from: com.mchange.v2.cmdline.ParsedCommandLineImpl */
/* loaded from: grasscutter.jar:com/mchange/v2/cmdline/ParsedCommandLineImpl.class */
class ParsedCommandLineImpl implements ParsedCommandLine {
    String[] argv;
    String switchPrefix;
    String[] unswitchedArgs;
    HashMap foundSwitches = new HashMap();

    /* access modifiers changed from: package-private */
    public ParsedCommandLineImpl(String[] strArr, String str, String[] strArr2, String[] strArr3, String[] strArr4) throws BadCommandLineException {
        this.argv = strArr;
        this.switchPrefix = str;
        LinkedList linkedList = new LinkedList();
        int length = str.length();
        int i = 0;
        while (i < strArr.length) {
            if (strArr[i].startsWith(str)) {
                String substring = strArr[i].substring(length);
                String str2 = null;
                int indexOf = substring.indexOf(61);
                if (indexOf >= 0) {
                    str2 = substring.substring(indexOf + 1);
                    substring = substring.substring(0, indexOf);
                } else if (contains(substring, strArr4) && i < strArr.length - 1 && !strArr[i + 1].startsWith(str)) {
                    i++;
                    str2 = strArr[i];
                }
                if (strArr2 != null && !contains(substring, strArr2)) {
                    throw new UnexpectedSwitchException("Unexpected Switch: " + substring, substring);
                } else if (strArr4 == null || str2 == null || contains(substring, strArr4)) {
                    this.foundSwitches.put(substring, str2);
                } else {
                    throw new UnexpectedSwitchArgumentException("Switch \"" + substring + "\" should not have an argument. Argument \"" + str2 + "\" found.", substring, str2);
                }
            } else {
                linkedList.add(strArr[i]);
            }
            i++;
        }
        if (strArr3 != null) {
            for (int i2 = 0; i2 < strArr3.length; i2++) {
                if (!this.foundSwitches.containsKey(strArr3[i2])) {
                    throw new MissingSwitchException("Required switch \"" + strArr3[i2] + "\" not found.", strArr3[i2]);
                }
            }
        }
        this.unswitchedArgs = new String[linkedList.size()];
        linkedList.toArray(this.unswitchedArgs);
    }

    @Override // com.mchange.p009v2.cmdline.ParsedCommandLine
    public String getSwitchPrefix() {
        return this.switchPrefix;
    }

    @Override // com.mchange.p009v2.cmdline.ParsedCommandLine
    public String[] getRawArgs() {
        return (String[]) this.argv.clone();
    }

    @Override // com.mchange.p009v2.cmdline.ParsedCommandLine
    public boolean includesSwitch(String str) {
        return this.foundSwitches.containsKey(str);
    }

    @Override // com.mchange.p009v2.cmdline.ParsedCommandLine
    public String getSwitchArg(String str) {
        return (String) this.foundSwitches.get(str);
    }

    @Override // com.mchange.p009v2.cmdline.ParsedCommandLine
    public String[] getUnswitchedArgs() {
        return (String[]) this.unswitchedArgs.clone();
    }

    private static boolean contains(String str, String[] strArr) {
        int length = strArr.length;
        do {
            length--;
            if (length < 0) {
                return false;
            }
        } while (!strArr[length].equals(str));
        return true;
    }
}
