package com.mchange.util.impl;

import com.mchange.util.CommandLineParser;

/* loaded from: grasscutter.jar:com/mchange/util/impl/CommandLineParserImpl.class */
public class CommandLineParserImpl implements CommandLineParser {
    String[] argv;
    String[] validSwitches;
    String[] reqSwitches;
    String[] argSwitches;
    char switch_char;

    public CommandLineParserImpl(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4, char c) {
        this.argv = strArr;
        this.validSwitches = strArr2 == null ? new String[0] : strArr2;
        this.reqSwitches = strArr3 == null ? new String[0] : strArr3;
        this.argSwitches = strArr4 == null ? new String[0] : strArr4;
        this.switch_char = c;
    }

    public CommandLineParserImpl(String[] strArr, String[] strArr2, String[] strArr3, String[] strArr4) {
        this(strArr, strArr2, strArr3, strArr4, '-');
    }

    @Override // com.mchange.util.CommandLineParser
    public boolean checkSwitch(String str) {
        for (int i = 0; i < this.argv.length; i++) {
            if (this.argv[i].charAt(0) == this.switch_char && this.argv[i].equals(this.switch_char + str)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.mchange.util.CommandLineParser
    public String findSwitchArg(String str) {
        for (int i = 0; i < this.argv.length - 1; i++) {
            if (this.argv[i].charAt(0) == this.switch_char && this.argv[i].equals(this.switch_char + str)) {
                if (this.argv[i + 1].charAt(0) == this.switch_char) {
                    return null;
                } else {
                    return this.argv[i + 1];
                }
            }
        }
        return null;
    }

    @Override // com.mchange.util.CommandLineParser
    public boolean checkArgv() {
        return checkValidSwitches() && checkRequiredSwitches() && checkSwitchArgSyntax();
    }

    boolean checkValidSwitches() {
        for (int i = 0; i < this.argv.length; i++) {
            if (this.argv[i].charAt(0) == this.switch_char) {
                for (int i2 = 0; i2 < this.validSwitches.length; i2++) {
                    if (this.argv[i].equals(this.switch_char + this.validSwitches[i2])) {
                        break;
                    }
                }
                return false;
            }
        }
        return true;
    }

    boolean checkRequiredSwitches() {
        int length = this.reqSwitches.length;
        do {
            length--;
            if (length < 0) {
                return true;
            }
        } while (checkSwitch(this.reqSwitches[length]));
        return false;
    }

    boolean checkSwitchArgSyntax() {
        String findSwitchArg;
        int length = this.argSwitches.length;
        while (true) {
            length--;
            if (length < 0) {
                return true;
            }
            if (checkSwitch(this.argSwitches[length]) && ((findSwitchArg = findSwitchArg(this.argSwitches[length])) == null || findSwitchArg.charAt(0) == this.switch_char)) {
                return false;
            }
        }
    }

    @Override // com.mchange.util.CommandLineParser
    public int findLastSwitched() {
        int length = this.argv.length;
        do {
            length--;
            if (length < 0) {
                return -1;
            }
        } while (this.argv[length].charAt(0) != this.switch_char);
        return length;
    }

    @Override // com.mchange.util.CommandLineParser
    public String[] findUnswitchedArgs() {
        String[] strArr = new String[this.argv.length];
        int i = 0;
        int i2 = 0;
        while (i2 < this.argv.length) {
            if (this.argv[i2].charAt(0) != this.switch_char) {
                i++;
                strArr[i] = this.argv[i2];
            } else if (contains(this.argv[i2].substring(1), this.argSwitches)) {
                i2++;
            }
            i2++;
        }
        String[] strArr2 = new String[i];
        System.arraycopy(strArr, 0, strArr2, 0, i);
        return strArr2;
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
