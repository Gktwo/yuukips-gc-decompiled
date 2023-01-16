package org.luaj.vm2.parser;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.io.PrintStream;
import okhttp3.internal.http2.Http2Stream;
import org.jline.reader.impl.LineReaderImpl;
import org.slf4j.Marker;
import p001ch.qos.logback.classic.pattern.CallerDataConverter;
import p001ch.qos.logback.core.FileAppender;
import p001ch.qos.logback.core.util.FileSize;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:org/luaj/vm2/parser/LuaParserTokenManager.class */
public class LuaParserTokenManager implements LuaParserConstants {
    public PrintStream debugStream;
    static final long[] jjbitVec0 = {-2, -1, -1, -1};
    static final long[] jjbitVec2 = {0, 0, -1, -1};
    static final int[] jjnextStates = {62, 63, 65, 32, 49, 50, 51, 36, 37, 38, 26, 27, 29, 22, 36, 37, 38, 46, 36, 47, 37, 38, 49, 50, 51, 59, 49, 60, 50, 51, 20, 25, 23, 24, 33, 34, 39, 40, 45, 52, 53, 58, 0, 1, 3};
    public static final String[] jjstrLiteralImages = {"", null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, "and", "break", "do", "else", "elseif", "end", "false", "for", "function", "goto", "if", "in", "local", "nil", "not", "or", "return", "repeat", "then", C3P0Substitutions.DEBUG, "until", "while", null, null, null, null, null, null, null, null, null, null, null, null, null, null, "::", null, null, null, LineReaderImpl.DEFAULT_COMMENT_BEGIN, ";", "=", ",", Mapper.IGNORED_FIELDNAME, EmitterKt.COMMENT_PREFIX, "(", ")", "[", "]", "...", "{", "}", Marker.ANY_NON_NULL_MARKER, "-", "*", "/", "^", "%", CallerDataConverter.DEFAULT_RANGE_DELIMITER, "<", "<=", ">", ">=", "==", "~="};
    public static final String[] lexStateNames = {"DEFAULT", "IN_COMMENT", "IN_LC0", "IN_LC1", "IN_LC2", "IN_LC3", "IN_LCN", "IN_LS0", "IN_LS1", "IN_LS2", "IN_LS3", "IN_LSN"};
    public static final int[] jjnewLexState = {-1, -1, -1, -1, -1, -1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
    static final long[] jjtoToken = {6926536226618998785L, 2147483618};
    static final long[] jjtoSkip = {8257598, 0};
    static final long[] jjtoSpecial = {8257536, 0};
    static final long[] jjtoMore = {268566464, 0};
    protected SimpleCharStream input_stream;
    private final int[] jjrounds;
    private final int[] jjstateSet;
    private final StringBuffer jjimage;
    private StringBuffer image;
    private int jjimageLen;
    private int lengthOfMatch;
    protected char curChar;
    int curLexState;
    int defaultLexState;
    int jjnewStateCnt;
    int jjround;
    int jjmatchedPos;
    int jjmatchedKind;

    public void setDebugStream(PrintStream printStream) {
        this.debugStream = printStream;
    }

    private int jjStopAtPos(int i, int i2) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        return i + 1;
    }

    private int jjMoveStringLiteralDfa0_2() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_2(262144);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_2(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j & 262144) != 0) {
                        return jjStopAtPos(1, 18);
                    }
                    return 2;
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa0_11() {
        return jjMoveNfa_11(6, 0);
    }

    private int jjMoveNfa_11(int i, int i2) {
        int i3 = 0;
        this.jjnewStateCnt = 7;
        int i4 = 1;
        this.jjstateSet[0] = i;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long j = 1 << this.curChar;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                        case 1:
                            if (this.curChar == '=') {
                                jjCheckNAddTwoStates(1, 2);
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == '=') {
                                int[] iArr = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr[i7] = 0;
                                break;
                            }
                            break;
                        case 4:
                            if (this.curChar == '=') {
                                int[] iArr2 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr2[i8] = 3;
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == '=') {
                                int[] iArr3 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr3[i9] = 4;
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            } else if (this.curChar < 128) {
                long j2 = 1 << (this.curChar & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 2:
                            if (this.curChar == ']' && i5 > 27) {
                                i5 = 27;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar == ']') {
                                int[] iArr4 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr4[i10] = 5;
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            } else {
                int i11 = this.curChar >> '\b';
                int i12 = i11 >> 6;
                long j3 = 1 << (i11 & 63);
                int i13 = (this.curChar & 255) >> 6;
                long j4 = 1 << (this.curChar & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                    }
                } while (i4 != i3);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i2;
                i5 = Integer.MAX_VALUE;
            }
            i2++;
            int i14 = this.jjnewStateCnt;
            i4 = i14;
            this.jjnewStateCnt = i3;
            int i15 = 7 - i3;
            i3 = i15;
            if (i14 == i15) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_10() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_10(67108864);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_10(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_10(j, 67108864);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_10(j3, 67108864);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_10(j3, 67108864);
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa4_10(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 4;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 67108864) != 0) {
                        return jjStopAtPos(4, 26);
                    }
                    return 5;
                default:
                    return 5;
            }
        } catch (IOException e) {
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa0_9() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_9(33554432);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_9(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_9(j, 33554432);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_9(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_9(j3, 33554432);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_9(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 33554432) != 0) {
                        return jjStopAtPos(3, 25);
                    }
                    return 4;
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa0_8() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_8(16777216);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_8(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_8(j, 16777216);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_8(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 16777216) != 0) {
                        return jjStopAtPos(2, 24);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa0_7() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_7(8388608);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_7(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j & 8388608) != 0) {
                        return jjStopAtPos(1, 23);
                    }
                    return 2;
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private final int jjStopStringLiteralDfa_0(int i, long j, long j2) {
        switch (i) {
            case 0:
                if ((j & 30720) != 0 || (j2 & FileAppender.DEFAULT_BUFFER_SIZE) != 0) {
                    return 14;
                }
                if ((j2 & 16810496) != 0) {
                    return 31;
                }
                if ((j & 2251799276814336L) == 0) {
                    return ((j & 66496) == 0 && (j2 & 524288) == 0) ? -1 : 7;
                }
                this.jjmatchedKind = 51;
                return 17;
            case 1:
                if ((j & 66496) != 0) {
                    return 6;
                }
                if ((j & 28672) != 0) {
                    return 13;
                }
                if ((j & 19243600969728L) != 0) {
                    return 17;
                }
                if ((j & 2232555675844608L) == 0) {
                    return -1;
                }
                if (this.jjmatchedPos == 1) {
                    return 17;
                }
                this.jjmatchedKind = 51;
                this.jjmatchedPos = 1;
                return 17;
            case 2:
                if ((j & 2219275100094464L) != 0) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 2;
                    return 17;
                } else if ((j & 24576) != 0) {
                    return 12;
                } else {
                    if ((j & 960) != 0) {
                        return 5;
                    }
                    return (j & 13280575750144L) != 0 ? 17 : -1;
                }
            case 3:
                if ((j & 896) != 0) {
                    return 4;
                }
                if ((j & 1796774872219648L) != 0) {
                    if (this.jjmatchedPos == 3) {
                        return 17;
                    }
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 3;
                    return 17;
                } else if ((j & 422500227874816L) != 0) {
                    return 17;
                } else {
                    return (j & Http2Stream.EMIT_BUFFER_SIZE) != 0 ? 9 : -1;
                }
            case 4:
                if ((j & 105699145154560L) != 0) {
                    this.jjmatchedKind = 51;
                    this.jjmatchedPos = 4;
                    return 17;
                } else if ((j & 768) != 0) {
                    return 3;
                } else {
                    return (j & 1691084316999680L) != 0 ? 17 : -1;
                }
            case 5:
                if ((j & 512) != 0) {
                    return 0;
                }
                if ((j & 105561706201088L) != 0) {
                    return 17;
                }
                if ((j & 137438953472L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 51;
                this.jjmatchedPos = 5;
                return 17;
            case 6:
                if ((j & 137438953472L) == 0) {
                    return -1;
                }
                this.jjmatchedKind = 51;
                this.jjmatchedPos = 6;
                return 17;
            default:
                return -1;
        }
    }

    private final int jjStartNfa_0(int i, long j, long j2) {
        return jjMoveNfa_0(jjStopStringLiteralDfa_0(i, j, j2), i + 1);
    }

    private int jjMoveStringLiteralDfa0_0() {
        switch (this.curChar) {
            case '#':
                return jjStopAtPos(0, 69);
            case '$':
            case '&':
            case '\'':
            case '0':
            case '1':
            case '2':
            case '3':
            case '4':
            case '5':
            case '6':
            case '7':
            case '8':
            case '9':
            case '?':
            case '@':
            case 'A':
            case 'B':
            case 'C':
            case 'D':
            case 'E':
            case 'F':
            case 'G':
            case 'H':
            case 'I':
            case 'J':
            case 'K':
            case 'L':
            case 'M':
            case 'N':
            case 'O':
            case 'P':
            case 'Q':
            case 'R':
            case 'S':
            case 'T':
            case 'U':
            case 'V':
            case 'W':
            case 'X':
            case 'Y':
            case 'Z':
            case '\\':
            case '_':
            case '`':
            case 'c':
            case 'h':
            case 'j':
            case 'k':
            case 'm':
            case 'p':
            case 'q':
            case 's':
            case 'v':
            case 'x':
            case 'y':
            case 'z':
            case '|':
            default:
                return jjMoveNfa_0(8, 0);
            case '%':
                return jjStopAtPos(0, 87);
            case '(':
                return jjStopAtPos(0, 75);
            case ')':
                return jjStopAtPos(0, 76);
            case '*':
                return jjStopAtPos(0, 84);
            case '+':
                return jjStopAtPos(0, 82);
            case ',':
                return jjStopAtPos(0, 72);
            case '-':
                this.jjmatchedKind = 83;
                return jjMoveStringLiteralDfa1_0(66496, 0);
            case '.':
                this.jjmatchedKind = 73;
                return jjMoveStringLiteralDfa1_0(0, 16809984);
            case '/':
                return jjStopAtPos(0, 85);
            case ':':
                this.jjmatchedKind = 74;
                return jjMoveStringLiteralDfa1_0(0, 2);
            case ';':
                return jjStopAtPos(0, 70);
            case '<':
                this.jjmatchedKind = 89;
                return jjMoveStringLiteralDfa1_0(0, 67108864);
            case '=':
                this.jjmatchedKind = 71;
                return jjMoveStringLiteralDfa1_0(0, 536870912);
            case '>':
                this.jjmatchedKind = 91;
                return jjMoveStringLiteralDfa1_0(0, 268435456);
            case '[':
                this.jjmatchedKind = 77;
                return jjMoveStringLiteralDfa1_0(30720, 0);
            case ']':
                return jjStopAtPos(0, 78);
            case '^':
                return jjStopAtPos(0, 86);
            case 'a':
                return jjMoveStringLiteralDfa1_0(536870912, 0);
            case 'b':
                return jjMoveStringLiteralDfa1_0(FileSize.GB_COEFFICIENT, 0);
            case 'd':
                return jjMoveStringLiteralDfa1_0(2147483648L, 0);
            case 'e':
                return jjMoveStringLiteralDfa1_0(30064771072L, 0);
            case 'f':
                return jjMoveStringLiteralDfa1_0(240518168576L, 0);
            case 'g':
                return jjMoveStringLiteralDfa1_0(274877906944L, 0);
            case 'i':
                return jjMoveStringLiteralDfa1_0(1649267441664L, 0);
            case 'l':
                return jjMoveStringLiteralDfa1_0(2199023255552L, 0);
            case 'n':
                return jjMoveStringLiteralDfa1_0(13194139533312L, 0);
            case 'o':
                return jjMoveStringLiteralDfa1_0(17592186044416L, 0);
            case 'r':
                return jjMoveStringLiteralDfa1_0(105553116266496L, 0);
            case 't':
                return jjMoveStringLiteralDfa1_0(422212465065984L, 0);
            case 'u':
                return jjMoveStringLiteralDfa1_0(562949953421312L, 0);
            case 'w':
                return jjMoveStringLiteralDfa1_0(1125899906842624L, 0);
            case '{':
                return jjStopAtPos(0, 80);
            case '}':
                return jjStopAtPos(0, 81);
            case '~':
                return jjMoveStringLiteralDfa1_0(0, FileSize.GB_COEFFICIENT);
        }
    }

    private int jjMoveStringLiteralDfa1_0(long j, long j2) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '-':
                    if ((j & 65536) != 0) {
                        this.jjmatchedKind = 16;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_0(j, 960, j2, 0);
                case '.':
                    if ((j2 & 16777216) != 0) {
                        this.jjmatchedKind = 88;
                        this.jjmatchedPos = 1;
                    }
                    return jjMoveStringLiteralDfa2_0(j, 0, j2, 32768);
                case ':':
                    if ((j2 & 2) != 0) {
                        return jjStopAtPos(1, 65);
                    }
                    break;
                case '=':
                    return (j2 & 67108864) != 0 ? jjStopAtPos(1, 90) : (j2 & 268435456) != 0 ? jjStopAtPos(1, 92) : (j2 & 536870912) != 0 ? jjStopAtPos(1, 93) : (j2 & FileSize.GB_COEFFICIENT) != 0 ? jjStopAtPos(1, 94) : jjMoveStringLiteralDfa2_0(j, 28672, j2, 0);
                case '[':
                    if ((j & 2048) != 0) {
                        return jjStopAtPos(1, 11);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa2_0(j, 34359738368L, j2, 0);
                case 'e':
                    return jjMoveStringLiteralDfa2_0(j, 105553116266496L, j2, 0);
                case 'f':
                    if ((j & 549755813888L) != 0) {
                        return jjStartNfaWithStates_0(1, 39, 17);
                    }
                    break;
                case 'h':
                    return jjMoveStringLiteralDfa2_0(j, 1266637395197952L, j2, 0);
                case 'i':
                    return jjMoveStringLiteralDfa2_0(j, 4398046511104L, j2, 0);
                case 'l':
                    return jjMoveStringLiteralDfa2_0(j, 12884901888L, j2, 0);
                case 'n':
                    return (j & 1099511627776L) != 0 ? jjStartNfaWithStates_0(1, 40, 17) : jjMoveStringLiteralDfa2_0(j, 562967670161408L, j2, 0);
                case 'o':
                    return (j & 2147483648L) != 0 ? jjStartNfaWithStates_0(1, 31, 17) : jjMoveStringLiteralDfa2_0(j, 11338713661440L, j2, 0);
                case 'r':
                    return (j & 17592186044416L) != 0 ? jjStartNfaWithStates_0(1, 44, 17) : jjMoveStringLiteralDfa2_0(j, 281476050452480L, j2, 0);
                case 'u':
                    return jjMoveStringLiteralDfa2_0(j, 137438953472L, j2, 0);
            }
            return jjStartNfa_0(0, j, j2);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(0, j, j2);
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        if ((j5 | (j4 & j3)) == 0) {
            return jjStartNfa_0(0, j, j3);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '.':
                    if ((j5 & 32768) != 0) {
                        return jjStopAtPos(2, 79);
                    }
                    break;
                case '=':
                    return jjMoveStringLiteralDfa3_0(j5, 24576, j5, 0);
                case '[':
                    return (j5 & 4096) != 0 ? jjStopAtPos(2, 12) : jjMoveStringLiteralDfa3_0(j5, 960, j5, 0);
                case 'c':
                    return jjMoveStringLiteralDfa3_0(j5, 2199023255552L, j5, 0);
                case 'd':
                    if ((j5 & 536870912) != 0) {
                        return jjStartNfaWithStates_0(2, 29, 17);
                    }
                    if ((j5 & 17179869184L) != 0) {
                        return jjStartNfaWithStates_0(2, 34, 17);
                    }
                    break;
                case 'e':
                    return jjMoveStringLiteralDfa3_0(j5, 140738562097152L, j5, 0);
                case 'i':
                    return jjMoveStringLiteralDfa3_0(j5, 1125899906842624L, j5, 0);
                case 'l':
                    return (j5 & 4398046511104L) != 0 ? jjStartNfaWithStates_0(2, 42, 17) : jjMoveStringLiteralDfa3_0(j5, 34359738368L, j5, 0);
                case 'n':
                    return jjMoveStringLiteralDfa3_0(j5, 137438953472L, j5, 0);
                case 'p':
                    return jjMoveStringLiteralDfa3_0(j5, 70368744177664L, j5, 0);
                case 'r':
                    if ((j5 & 68719476736L) != 0) {
                        return jjStartNfaWithStates_0(2, 36, 17);
                    }
                    break;
                case 's':
                    return jjMoveStringLiteralDfa3_0(j5, 12884901888L, j5, 0);
                case 't':
                    return (j5 & 8796093022208L) != 0 ? jjStartNfaWithStates_0(2, 43, 17) : jjMoveStringLiteralDfa3_0(j5, 598409203417088L, j5, 0);
                case 'u':
                    return jjMoveStringLiteralDfa3_0(j5, 281474976710656L, j5, 0);
            }
            return jjStartNfa_0(1, j5, j5);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(1, j5, j5);
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_0(long j, long j2, long j3, long j4) {
        long j5 = j2 & j;
        if ((j5 | (j4 & j3)) == 0) {
            return jjStartNfa_0(1, j, j3);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_0(j5, 17280);
                case '[':
                    if ((j5 & 64) != 0) {
                        return jjStopAtPos(3, 6);
                    }
                    if ((j5 & FileAppender.DEFAULT_BUFFER_SIZE) != 0) {
                        return jjStopAtPos(3, 13);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa4_0(j5, 2200096997376L);
                case 'c':
                    return jjMoveStringLiteralDfa4_0(j5, 137438953472L);
                case 'e':
                    if ((j5 & 4294967296L) != 0) {
                        this.jjmatchedKind = 32;
                        this.jjmatchedPos = 3;
                    } else if ((j5 & 281474976710656L) != 0) {
                        return jjStartNfaWithStates_0(3, 48, 17);
                    }
                    return jjMoveStringLiteralDfa4_0(j5, 70377334112256L);
                case 'i':
                    return jjMoveStringLiteralDfa4_0(j5, 562949953421312L);
                case 'l':
                    return jjMoveStringLiteralDfa4_0(j5, 1125899906842624L);
                case 'n':
                    if ((j5 & 140737488355328L) != 0) {
                        return jjStartNfaWithStates_0(3, 47, 17);
                    }
                    break;
                case 'o':
                    if ((j5 & 274877906944L) != 0) {
                        return jjStartNfaWithStates_0(3, 38, 17);
                    }
                    break;
                case 's':
                    return jjMoveStringLiteralDfa4_0(j5, 34359738368L);
                case 'u':
                    return jjMoveStringLiteralDfa4_0(j5, 35184372088832L);
            }
            return jjStartNfa_0(2, j5, 0);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(2, j5, 0);
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa4_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(2, j, 0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa5_0(j3, 768);
                case '[':
                    if ((j3 & 128) != 0) {
                        return jjStopAtPos(4, 7);
                    }
                    if ((j3 & Http2Stream.EMIT_BUFFER_SIZE) != 0) {
                        return jjStopAtPos(4, 14);
                    }
                    break;
                case 'a':
                    return jjMoveStringLiteralDfa5_0(j3, 70368744177664L);
                case 'e':
                    if ((j3 & 34359738368L) != 0) {
                        return jjStartNfaWithStates_0(4, 35, 17);
                    }
                    if ((j3 & 1125899906842624L) != 0) {
                        return jjStartNfaWithStates_0(4, 50, 17);
                    }
                    break;
                case 'i':
                    return jjMoveStringLiteralDfa5_0(j3, 8589934592L);
                case 'k':
                    if ((j3 & FileSize.GB_COEFFICIENT) != 0) {
                        return jjStartNfaWithStates_0(4, 30, 17);
                    }
                    break;
                case 'l':
                    if ((j3 & 2199023255552L) != 0) {
                        return jjStartNfaWithStates_0(4, 41, 17);
                    }
                    if ((j3 & 562949953421312L) != 0) {
                        return jjStartNfaWithStates_0(4, 49, 17);
                    }
                    break;
                case 'r':
                    return jjMoveStringLiteralDfa5_0(j3, 35184372088832L);
                case 't':
                    return jjMoveStringLiteralDfa5_0(j3, 137438953472L);
            }
            return jjStartNfa_0(3, j3, 0);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(3, j3, 0);
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa5_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(3, j, 0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa6_0(j3, 512);
                case '[':
                    if ((j3 & 256) != 0) {
                        return jjStopAtPos(5, 8);
                    }
                    break;
                case 'f':
                    if ((j3 & 8589934592L) != 0) {
                        return jjStartNfaWithStates_0(5, 33, 17);
                    }
                    break;
                case 'i':
                    return jjMoveStringLiteralDfa6_0(j3, 137438953472L);
                case 'n':
                    if ((j3 & 35184372088832L) != 0) {
                        return jjStartNfaWithStates_0(5, 45, 17);
                    }
                    break;
                case 't':
                    if ((j3 & 70368744177664L) != 0) {
                        return jjStartNfaWithStates_0(5, 46, 17);
                    }
                    break;
            }
            return jjStartNfa_0(4, j3, 0);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(4, j3, 0);
            return 5;
        }
    }

    private int jjMoveStringLiteralDfa6_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(4, j, 0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'o':
                    return jjMoveStringLiteralDfa7_0(j3, 137438953472L);
                case '[':
                    if ((j3 & 512) != 0) {
                        return jjStopAtPos(6, 9);
                    }
                    break;
            }
            return jjStartNfa_0(5, j3, 0);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(5, j3, 0);
            return 6;
        }
    }

    private int jjMoveStringLiteralDfa7_0(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return jjStartNfa_0(5, j, 0);
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case 'n':
                    if ((j3 & 137438953472L) != 0) {
                        return jjStartNfaWithStates_0(7, 37, 17);
                    }
                    break;
            }
            return jjStartNfa_0(6, j3, 0);
        } catch (IOException e) {
            jjStopStringLiteralDfa_0(6, j3, 0);
            return 7;
        }
    }

    private int jjStartNfaWithStates_0(int i, int i2, int i3) {
        this.jjmatchedKind = i2;
        this.jjmatchedPos = i;
        try {
            this.curChar = this.input_stream.readChar();
            return jjMoveNfa_0(i3, i + 1);
        } catch (IOException e) {
            return i + 1;
        }
    }

    private int jjMoveNfa_0(int i, int i2) {
        int i3 = 0;
        this.jjnewStateCnt = 66;
        int i4 = 1;
        this.jjstateSet[0] = i;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar >= '@') {
                if (this.curChar >= 128) {
                    int i7 = this.curChar >> '\b';
                    int i8 = i7 >> 6;
                    long j = 1 << (i7 & 63);
                    int i9 = (this.curChar & 255) >> 6;
                    long j2 = 1 << (this.curChar & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 36:
                            case 39:
                                if (jjCanMove_0(i7, i8, i9, j, j2)) {
                                    jjCheckNAddStates(7, 9);
                                    break;
                                }
                                break;
                            case 49:
                            case 52:
                                if (jjCanMove_0(i7, i8, i9, j, j2)) {
                                    jjCheckNAddStates(4, 6);
                                    break;
                                }
                                break;
                        }
                    } while (i4 != i3);
                } else {
                    long j3 = 1 << (this.curChar & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 2:
                                if (this.curChar == '[' && i5 > 10) {
                                    i5 = 10;
                                    break;
                                }
                                break;
                            case 6:
                                if (this.curChar == '[') {
                                    int[] iArr = this.jjstateSet;
                                    int i10 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i10 + 1;
                                    iArr[i10] = 5;
                                    break;
                                }
                                break;
                            case 8:
                                if ((576460745995190270L & j3) == 0) {
                                    if (this.curChar == '[') {
                                        int[] iArr2 = this.jjstateSet;
                                        int i11 = this.jjnewStateCnt;
                                        this.jjnewStateCnt = i11 + 1;
                                        iArr2[i11] = 14;
                                        break;
                                    }
                                } else {
                                    if (i5 > 51) {
                                        i5 = 51;
                                    }
                                    jjCheckNAdd(17);
                                    break;
                                }
                                break;
                            case 11:
                                if (this.curChar == '[' && i5 > 15) {
                                    i5 = 15;
                                    break;
                                }
                                break;
                            case 15:
                                if (this.curChar == '[') {
                                    int[] iArr3 = this.jjstateSet;
                                    int i12 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i12 + 1;
                                    iArr3[i12] = 14;
                                    break;
                                }
                                break;
                            case 16:
                            case 17:
                                if ((576460745995190270L & j3) != 0) {
                                    if (i5 > 51) {
                                        i5 = 51;
                                    }
                                    jjCheckNAdd(17);
                                    break;
                                }
                                break;
                            case 19:
                                if ((72057594054705152L & j3) != 0) {
                                    jjAddStates(30, 31);
                                    break;
                                }
                                break;
                            case 21:
                                if ((541165879422L & j3) != 0) {
                                    if (i5 > 52) {
                                        i5 = 52;
                                    }
                                    jjCheckNAddTwoStates(21, 22);
                                    break;
                                }
                                break;
                            case 22:
                                if ((281612415729696L & j3) != 0) {
                                    jjAddStates(32, 33);
                                    break;
                                }
                                break;
                            case 25:
                                if ((541165879422L & j3) != 0) {
                                    if (i5 > 52) {
                                        i5 = 52;
                                    }
                                    jjCheckNAddStates(10, 13);
                                    break;
                                }
                                break;
                            case 26:
                                if ((541165879422L & j3) != 0) {
                                    jjCheckNAddTwoStates(26, 27);
                                    break;
                                }
                                break;
                            case 28:
                                if ((541165879422L & j3) != 0) {
                                    if (i5 > 52) {
                                        i5 = 52;
                                    }
                                    jjCheckNAddTwoStates(28, 22);
                                    break;
                                }
                                break;
                            case 29:
                                if ((541165879422L & j3) != 0) {
                                    if (i5 > 52) {
                                        i5 = 52;
                                    }
                                    jjCheckNAddTwoStates(29, 22);
                                    break;
                                }
                                break;
                            case 32:
                                if ((137438953504L & j3) != 0) {
                                    jjAddStates(34, 35);
                                    break;
                                }
                                break;
                            case 36:
                                if ((-268435457 & j3) != 0) {
                                    jjCheckNAddStates(7, 9);
                                    break;
                                }
                                break;
                            case 38:
                                if (this.curChar == '\\') {
                                    jjAddStates(36, 38);
                                    break;
                                }
                                break;
                            case 39:
                                jjCheckNAddStates(7, 9);
                                break;
                            case 40:
                                if (this.curChar == 'u') {
                                    int[] iArr4 = this.jjstateSet;
                                    int i13 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i13 + 1;
                                    iArr4[i13] = 41;
                                    break;
                                }
                                break;
                            case 41:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr5 = this.jjstateSet;
                                    int i14 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i14 + 1;
                                    iArr5[i14] = 42;
                                    break;
                                }
                                break;
                            case 42:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr6 = this.jjstateSet;
                                    int i15 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i15 + 1;
                                    iArr6[i15] = 43;
                                    break;
                                }
                                break;
                            case 43:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr7 = this.jjstateSet;
                                    int i16 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i16 + 1;
                                    iArr7[i16] = 44;
                                    break;
                                }
                                break;
                            case 44:
                                if ((541165879422L & j3) != 0) {
                                    jjCheckNAddStates(7, 9);
                                    break;
                                }
                                break;
                            case 49:
                                if ((-268435457 & j3) != 0) {
                                    jjCheckNAddStates(4, 6);
                                    break;
                                }
                                break;
                            case 51:
                                if (this.curChar == '\\') {
                                    jjAddStates(39, 41);
                                    break;
                                }
                                break;
                            case 52:
                                jjCheckNAddStates(4, 6);
                                break;
                            case 53:
                                if (this.curChar == 'u') {
                                    int[] iArr8 = this.jjstateSet;
                                    int i17 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i17 + 1;
                                    iArr8[i17] = 54;
                                    break;
                                }
                                break;
                            case 54:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr9 = this.jjstateSet;
                                    int i18 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i18 + 1;
                                    iArr9[i18] = 55;
                                    break;
                                }
                                break;
                            case 55:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr10 = this.jjstateSet;
                                    int i19 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i19 + 1;
                                    iArr10[i19] = 56;
                                    break;
                                }
                                break;
                            case 56:
                                if ((541165879422L & j3) != 0) {
                                    int[] iArr11 = this.jjstateSet;
                                    int i20 = this.jjnewStateCnt;
                                    this.jjnewStateCnt = i20 + 1;
                                    iArr11[i20] = 57;
                                    break;
                                }
                                break;
                            case 57:
                                if ((541165879422L & j3) != 0) {
                                    jjCheckNAddStates(4, 6);
                                    break;
                                }
                                break;
                        }
                    } while (i4 != i3);
                }
            } else {
                long j4 = 1 << this.curChar;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                        case 1:
                            if (this.curChar == '=') {
                                jjCheckNAddTwoStates(1, 2);
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == '=') {
                                int[] iArr12 = this.jjstateSet;
                                int i21 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i21 + 1;
                                iArr12[i21] = 0;
                                break;
                            }
                            break;
                        case 4:
                            if (this.curChar == '=') {
                                int[] iArr13 = this.jjstateSet;
                                int i22 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i22 + 1;
                                iArr13[i22] = 3;
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == '=') {
                                int[] iArr14 = this.jjstateSet;
                                int i23 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i23 + 1;
                                iArr14[i23] = 4;
                                break;
                            }
                            break;
                        case 7:
                            if (this.curChar == '-') {
                                int[] iArr15 = this.jjstateSet;
                                int i24 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i24 + 1;
                                iArr15[i24] = 6;
                                break;
                            }
                            break;
                        case 8:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddStates(0, 3);
                            } else if (this.curChar == '\'') {
                                jjCheckNAddStates(4, 6);
                            } else if (this.curChar == '\"') {
                                jjCheckNAddStates(7, 9);
                            } else if (this.curChar == '.') {
                                jjCheckNAdd(31);
                            } else if (this.curChar == '-') {
                                int[] iArr16 = this.jjstateSet;
                                int i25 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i25 + 1;
                                iArr16[i25] = 7;
                            }
                            if (this.curChar == '0') {
                                int[] iArr17 = this.jjstateSet;
                                int i26 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i26 + 1;
                                iArr17[i26] = 19;
                                break;
                            }
                            break;
                        case 9:
                        case 10:
                            if (this.curChar == '=') {
                                jjCheckNAddTwoStates(10, 11);
                                break;
                            }
                            break;
                        case 12:
                            if (this.curChar == '=') {
                                int[] iArr18 = this.jjstateSet;
                                int i27 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i27 + 1;
                                iArr18[i27] = 9;
                                break;
                            }
                            break;
                        case 13:
                            if (this.curChar == '=') {
                                int[] iArr19 = this.jjstateSet;
                                int i28 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i28 + 1;
                                iArr19[i28] = 12;
                                break;
                            }
                            break;
                        case 14:
                            if (this.curChar == '=') {
                                int[] iArr20 = this.jjstateSet;
                                int i29 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i29 + 1;
                                iArr20[i29] = 13;
                                break;
                            }
                            break;
                        case 17:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 51) {
                                    i5 = 51;
                                }
                                int[] iArr21 = this.jjstateSet;
                                int i30 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i30 + 1;
                                iArr21[i30] = 17;
                                break;
                            }
                            break;
                        case 18:
                            if (this.curChar == '0') {
                                int[] iArr22 = this.jjstateSet;
                                int i31 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i31 + 1;
                                iArr22[i31] = 19;
                                break;
                            }
                            break;
                        case 20:
                            if (this.curChar == '.') {
                                jjCheckNAdd(21);
                                break;
                            }
                            break;
                        case 21:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(21, 22);
                                break;
                            }
                            break;
                        case 23:
                            if ((43980465111040L & j4) != 0) {
                                jjCheckNAdd(24);
                                break;
                            }
                            break;
                        case 24:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAdd(24);
                                break;
                            }
                            break;
                        case 25:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddStates(10, 13);
                                break;
                            }
                            break;
                        case 26:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddTwoStates(26, 27);
                                break;
                            }
                            break;
                        case 27:
                            if (this.curChar == '.') {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(28, 22);
                                break;
                            }
                            break;
                        case 28:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(28, 22);
                                break;
                            }
                            break;
                        case 29:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(29, 22);
                                break;
                            }
                            break;
                        case 30:
                            if (this.curChar == '.') {
                                jjCheckNAdd(31);
                                break;
                            }
                            break;
                        case 31:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(31, 32);
                                break;
                            }
                            break;
                        case 33:
                            if ((43980465111040L & j4) != 0) {
                                jjCheckNAdd(34);
                                break;
                            }
                            break;
                        case 34:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAdd(34);
                                break;
                            }
                            break;
                        case 35:
                            if (this.curChar == '\"') {
                                jjCheckNAddStates(7, 9);
                                break;
                            }
                            break;
                        case 36:
                            if ((-17179869185L & j4) != 0) {
                                jjCheckNAddStates(7, 9);
                                break;
                            }
                            break;
                        case 37:
                            if (this.curChar == '\"' && i5 > 61) {
                                i5 = 61;
                                break;
                            }
                            break;
                        case 39:
                            jjCheckNAddStates(7, 9);
                            break;
                        case 41:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr23 = this.jjstateSet;
                                int i32 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i32 + 1;
                                iArr23[i32] = 42;
                                break;
                            }
                            break;
                        case 42:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr24 = this.jjstateSet;
                                int i33 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i33 + 1;
                                iArr24[i33] = 43;
                                break;
                            }
                            break;
                        case 43:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr25 = this.jjstateSet;
                                int i34 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i34 + 1;
                                iArr25[i34] = 44;
                                break;
                            }
                            break;
                        case 44:
                        case 47:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(7, 9);
                                break;
                            }
                            break;
                        case 45:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(14, 17);
                                break;
                            }
                            break;
                        case 46:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(18, 21);
                                break;
                            }
                            break;
                        case 48:
                            if (this.curChar == '\'') {
                                jjCheckNAddStates(4, 6);
                                break;
                            }
                            break;
                        case 49:
                            if ((-549755813889L & j4) != 0) {
                                jjCheckNAddStates(4, 6);
                                break;
                            }
                            break;
                        case 50:
                            if (this.curChar == '\'' && i5 > 62) {
                                i5 = 62;
                                break;
                            }
                            break;
                        case 52:
                            jjCheckNAddStates(4, 6);
                            break;
                        case 54:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr26 = this.jjstateSet;
                                int i35 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i35 + 1;
                                iArr26[i35] = 55;
                                break;
                            }
                            break;
                        case 55:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr27 = this.jjstateSet;
                                int i36 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i36 + 1;
                                iArr27[i36] = 56;
                                break;
                            }
                            break;
                        case 56:
                            if ((287948901175001088L & j4) != 0) {
                                int[] iArr28 = this.jjstateSet;
                                int i37 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i37 + 1;
                                iArr28[i37] = 57;
                                break;
                            }
                            break;
                        case 57:
                        case 60:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(4, 6);
                                break;
                            }
                            break;
                        case 58:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(22, 25);
                                break;
                            }
                            break;
                        case 59:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddStates(26, 29);
                                break;
                            }
                            break;
                        case 61:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddStates(0, 3);
                                break;
                            }
                            break;
                        case 62:
                            if ((287948901175001088L & j4) != 0) {
                                jjCheckNAddTwoStates(62, 63);
                                break;
                            }
                            break;
                        case 63:
                            if (this.curChar == '.') {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(64, 32);
                                break;
                            }
                            break;
                        case 64:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(64, 32);
                                break;
                            }
                            break;
                        case 65:
                            if ((287948901175001088L & j4) != 0) {
                                if (i5 > 52) {
                                    i5 = 52;
                                }
                                jjCheckNAddTwoStates(65, 32);
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i2;
                i5 = Integer.MAX_VALUE;
            }
            i2++;
            int i38 = this.jjnewStateCnt;
            i4 = i38;
            this.jjnewStateCnt = i3;
            int i39 = 66 - i3;
            i3 = i39;
            if (i38 == i39) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_1() {
        return jjMoveNfa_1(4, 0);
    }

    private int jjMoveNfa_1(int i, int i2) {
        int i3 = 0;
        this.jjnewStateCnt = 4;
        int i4 = 1;
        this.jjstateSet[0] = i;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar >= '@') {
                if (this.curChar >= 128) {
                    int i7 = this.curChar >> '\b';
                    int i8 = i7 >> 6;
                    long j = 1 << (i7 & 63);
                    int i9 = (this.curChar & 255) >> 6;
                    long j2 = 1 << (this.curChar & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                            case 4:
                                if (jjCanMove_0(i7, i8, i9, j, j2)) {
                                    if (i5 > 17) {
                                        i5 = 17;
                                    }
                                    jjCheckNAddStates(42, 44);
                                    break;
                                }
                                break;
                        }
                    } while (i4 != i3);
                } else {
                    long j3 = 1 << (this.curChar & '?');
                    do {
                        i4--;
                        switch (this.jjstateSet[i4]) {
                            case 0:
                            case 4:
                                i5 = 17;
                                jjCheckNAddStates(42, 44);
                                break;
                        }
                    } while (i4 != i3);
                }
            } else {
                long j4 = 1 << this.curChar;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                            if ((-9217 & j4) != 0) {
                                i5 = 17;
                                jjCheckNAddStates(42, 44);
                                break;
                            }
                            break;
                        case 1:
                            if ((9216 & j4) != 0 && i5 > 17) {
                                i5 = 17;
                                break;
                            }
                            break;
                        case 2:
                            if (this.curChar == '\n' && i5 > 17) {
                                i5 = 17;
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == '\r') {
                                int[] iArr = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr[i10] = 2;
                                break;
                            }
                            break;
                        case 4:
                            if ((-9217 & j4) != 0) {
                                if (i5 > 17) {
                                    i5 = 17;
                                }
                                jjCheckNAddStates(42, 44);
                            } else if ((9216 & j4) != 0 && i5 > 17) {
                                i5 = 17;
                            }
                            if (this.curChar == '\r') {
                                int[] iArr2 = this.jjstateSet;
                                int i11 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i11 + 1;
                                iArr2[i11] = 2;
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i2;
                i5 = Integer.MAX_VALUE;
            }
            i2++;
            int i12 = this.jjnewStateCnt;
            i4 = i12;
            this.jjnewStateCnt = i3;
            int i13 = 4 - i3;
            i3 = i13;
            if (i12 == i13) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_6() {
        return jjMoveNfa_6(6, 0);
    }

    private int jjMoveNfa_6(int i, int i2) {
        int i3 = 0;
        this.jjnewStateCnt = 7;
        int i4 = 1;
        this.jjstateSet[0] = i;
        int i5 = Integer.MAX_VALUE;
        while (true) {
            int i6 = this.jjround + 1;
            this.jjround = i6;
            if (i6 == Integer.MAX_VALUE) {
                ReInitRounds();
            }
            if (this.curChar < '@') {
                long j = 1 << this.curChar;
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 0:
                        case 1:
                            if (this.curChar == '=') {
                                jjCheckNAddTwoStates(1, 2);
                                break;
                            }
                            break;
                        case 3:
                            if (this.curChar == '=') {
                                int[] iArr = this.jjstateSet;
                                int i7 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i7 + 1;
                                iArr[i7] = 0;
                                break;
                            }
                            break;
                        case 4:
                            if (this.curChar == '=') {
                                int[] iArr2 = this.jjstateSet;
                                int i8 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i8 + 1;
                                iArr2[i8] = 3;
                                break;
                            }
                            break;
                        case 5:
                            if (this.curChar == '=') {
                                int[] iArr3 = this.jjstateSet;
                                int i9 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i9 + 1;
                                iArr3[i9] = 4;
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            } else if (this.curChar < 128) {
                long j2 = 1 << (this.curChar & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                        case 2:
                            if (this.curChar == ']' && i5 > 22) {
                                i5 = 22;
                                break;
                            }
                            break;
                        case 6:
                            if (this.curChar == ']') {
                                int[] iArr4 = this.jjstateSet;
                                int i10 = this.jjnewStateCnt;
                                this.jjnewStateCnt = i10 + 1;
                                iArr4[i10] = 5;
                                break;
                            }
                            break;
                    }
                } while (i4 != i3);
            } else {
                int i11 = this.curChar >> '\b';
                int i12 = i11 >> 6;
                long j3 = 1 << (i11 & 63);
                int i13 = (this.curChar & 255) >> 6;
                long j4 = 1 << (this.curChar & '?');
                do {
                    i4--;
                    switch (this.jjstateSet[i4]) {
                    }
                } while (i4 != i3);
            }
            if (i5 != Integer.MAX_VALUE) {
                this.jjmatchedKind = i5;
                this.jjmatchedPos = i2;
                i5 = Integer.MAX_VALUE;
            }
            i2++;
            int i14 = this.jjnewStateCnt;
            i4 = i14;
            this.jjnewStateCnt = i3;
            int i15 = 7 - i3;
            i3 = i15;
            if (i14 == i15) {
                return i2;
            }
            try {
                this.curChar = this.input_stream.readChar();
            } catch (IOException e) {
                return i2;
            }
        }
    }

    private int jjMoveStringLiteralDfa0_5() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_5(2097152);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_5(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_5(j, 2097152);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_5(j3, 2097152);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa4_5(j3, 2097152);
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa4_5(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 4;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 2097152) != 0) {
                        return jjStopAtPos(4, 21);
                    }
                    return 5;
                default:
                    return 5;
            }
        } catch (IOException e) {
            return 4;
        }
    }

    private int jjMoveStringLiteralDfa0_4() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_4(FileSize.MB_COEFFICIENT);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_4(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_4(j, FileSize.MB_COEFFICIENT);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_4(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa3_4(j3, FileSize.MB_COEFFICIENT);
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private int jjMoveStringLiteralDfa3_4(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 3;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & FileSize.MB_COEFFICIENT) != 0) {
                        return jjStopAtPos(3, 20);
                    }
                    return 4;
                default:
                    return 4;
            }
        } catch (IOException e) {
            return 3;
        }
    }

    private int jjMoveStringLiteralDfa0_3() {
        switch (this.curChar) {
            case ']':
                return jjMoveStringLiteralDfa1_3(524288);
            default:
                return 1;
        }
    }

    private int jjMoveStringLiteralDfa1_3(long j) {
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case '=':
                    return jjMoveStringLiteralDfa2_3(j, 524288);
                default:
                    return 2;
            }
        } catch (IOException e) {
            return 1;
        }
    }

    private int jjMoveStringLiteralDfa2_3(long j, long j2) {
        long j3 = j2 & j;
        if (j3 == 0) {
            return 2;
        }
        try {
            this.curChar = this.input_stream.readChar();
            switch (this.curChar) {
                case ']':
                    if ((j3 & 524288) != 0) {
                        return jjStopAtPos(2, 19);
                    }
                    return 3;
                default:
                    return 3;
            }
        } catch (IOException e) {
            return 2;
        }
    }

    private static final boolean jjCanMove_0(int i, int i2, int i3, long j, long j2) {
        switch (i) {
            case 0:
                return (jjbitVec2[i3] & j2) != 0;
            default:
                return (jjbitVec0[i2] & j) != 0;
        }
    }

    public LuaParserTokenManager(SimpleCharStream simpleCharStream) {
        this.debugStream = System.out;
        this.jjrounds = new int[66];
        this.jjstateSet = new int[132];
        this.jjimage = new StringBuffer();
        this.image = this.jjimage;
        this.curLexState = 0;
        this.defaultLexState = 0;
        this.input_stream = simpleCharStream;
    }

    public LuaParserTokenManager(SimpleCharStream simpleCharStream, int i) {
        this(simpleCharStream);
        SwitchTo(i);
    }

    public void ReInit(SimpleCharStream simpleCharStream) {
        this.jjnewStateCnt = 0;
        this.jjmatchedPos = 0;
        this.curLexState = this.defaultLexState;
        this.input_stream = simpleCharStream;
        ReInitRounds();
    }

    private void ReInitRounds() {
        this.jjround = -2147483647;
        int i = 66;
        while (true) {
            i--;
            if (i > 0) {
                this.jjrounds[i] = Integer.MIN_VALUE;
            } else {
                return;
            }
        }
    }

    public void ReInit(SimpleCharStream simpleCharStream, int i) {
        ReInit(simpleCharStream);
        SwitchTo(i);
    }

    public void SwitchTo(int i) {
        if (i >= 12 || i < 0) {
            throw new TokenMgrError(new StringBuffer().append("Error: Ignoring invalid lexical state : ").append(i).append(". State unchanged.").toString(), 2);
        }
        this.curLexState = i;
    }

    protected Token jjFillToken() {
        int i;
        int i2;
        int i3;
        int i4;
        String str;
        if (this.jjmatchedPos < 0) {
            str = this.image == null ? "" : this.image.toString();
            int beginLine = this.input_stream.getBeginLine();
            i3 = beginLine;
            i4 = beginLine;
            int beginColumn = this.input_stream.getBeginColumn();
            i = beginColumn;
            i2 = beginColumn;
        } else {
            String str2 = jjstrLiteralImages[this.jjmatchedKind];
            str = str2 == null ? this.input_stream.GetImage() : str2;
            i4 = this.input_stream.getBeginLine();
            i2 = this.input_stream.getBeginColumn();
            i3 = this.input_stream.getEndLine();
            i = this.input_stream.getEndColumn();
        }
        Token newToken = Token.newToken(this.jjmatchedKind, str);
        newToken.beginLine = i4;
        newToken.endLine = i3;
        newToken.beginColumn = i2;
        newToken.endColumn = i;
        return newToken;
    }

    public Token getNextToken() {
        Token token = null;
        int i = 0;
        while (true) {
            try {
                this.curChar = this.input_stream.BeginToken();
                this.image = this.jjimage;
                this.image.setLength(0);
                this.jjimageLen = 0;
                while (true) {
                    switch (this.curLexState) {
                        case 0:
                            try {
                                this.input_stream.backup(0);
                                while (this.curChar <= ' ' && (4294981120L & (1 << this.curChar)) != 0) {
                                    this.curChar = this.input_stream.BeginToken();
                                }
                                this.jjmatchedKind = Integer.MAX_VALUE;
                                this.jjmatchedPos = 0;
                                i = jjMoveStringLiteralDfa0_0();
                                break;
                            } catch (IOException e) {
                                break;
                            }
                        case 1:
                            this.jjmatchedKind = 17;
                            this.jjmatchedPos = -1;
                            i = jjMoveStringLiteralDfa0_1();
                            break;
                        case 2:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_2();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 3:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_3();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 4:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_4();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 5:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_5();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 6:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_6();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 7:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_7();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 8:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_8();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 9:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_9();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 10:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_10();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                        case 11:
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            this.jjmatchedPos = 0;
                            i = jjMoveStringLiteralDfa0_11();
                            if (this.jjmatchedPos == 0 && this.jjmatchedKind > 28) {
                                this.jjmatchedKind = 28;
                                break;
                            }
                            break;
                    }
                    if (this.jjmatchedKind != Integer.MAX_VALUE) {
                        if (this.jjmatchedPos + 1 < i) {
                            this.input_stream.backup((i - this.jjmatchedPos) - 1);
                        }
                        if ((jjtoToken[this.jjmatchedKind >> 6] & (1 << (this.jjmatchedKind & 63))) != 0) {
                            Token jjFillToken = jjFillToken();
                            jjFillToken.specialToken = token;
                            if (jjnewLexState[this.jjmatchedKind] != -1) {
                                this.curLexState = jjnewLexState[this.jjmatchedKind];
                            }
                            return jjFillToken;
                        } else if ((jjtoSkip[this.jjmatchedKind >> 6] & (1 << (this.jjmatchedKind & 63))) != 0) {
                            if ((jjtoSpecial[this.jjmatchedKind >> 6] & (1 << (this.jjmatchedKind & 63))) != 0) {
                                Token jjFillToken2 = jjFillToken();
                                if (token == null) {
                                    token = jjFillToken2;
                                } else {
                                    jjFillToken2.specialToken = token;
                                    token.next = jjFillToken2;
                                    token = jjFillToken2;
                                }
                                SkipLexicalActions(jjFillToken2);
                            } else {
                                SkipLexicalActions(null);
                            }
                            if (jjnewLexState[this.jjmatchedKind] != -1) {
                                this.curLexState = jjnewLexState[this.jjmatchedKind];
                            }
                        } else {
                            this.jjimageLen += this.jjmatchedPos + 1;
                            if (jjnewLexState[this.jjmatchedKind] != -1) {
                                this.curLexState = jjnewLexState[this.jjmatchedKind];
                            }
                            i = 0;
                            this.jjmatchedKind = Integer.MAX_VALUE;
                            try {
                                this.curChar = this.input_stream.readChar();
                            } catch (IOException e2) {
                                int endLine = this.input_stream.getEndLine();
                                int endColumn = this.input_stream.getEndColumn();
                                String str = null;
                                boolean z = false;
                                try {
                                    this.input_stream.readChar();
                                    this.input_stream.backup(1);
                                } catch (IOException e3) {
                                    z = true;
                                    str = i <= 1 ? "" : this.input_stream.GetImage();
                                    if (this.curChar == '\n' || this.curChar == '\r') {
                                        endLine++;
                                        endColumn = 0;
                                    } else {
                                        endColumn++;
                                    }
                                }
                                if (!z) {
                                    this.input_stream.backup(1);
                                    str = i <= 1 ? "" : this.input_stream.GetImage();
                                }
                                throw new TokenMgrError(z, this.curLexState, endLine, endColumn, str, this.curChar, 0);
                            }
                        }
                    }
                }
            } catch (IOException e4) {
                this.jjmatchedKind = 0;
                Token jjFillToken3 = jjFillToken();
                jjFillToken3.specialToken = token;
                return jjFillToken3;
            }
        }
    }

    void SkipLexicalActions(Token token) {
        switch (this.jjmatchedKind) {
            default:
                return;
        }
    }

    private void jjCheckNAdd(int i) {
        if (this.jjrounds[i] != this.jjround) {
            int[] iArr = this.jjstateSet;
            int i2 = this.jjnewStateCnt;
            this.jjnewStateCnt = i2 + 1;
            iArr[i2] = i;
            this.jjrounds[i] = this.jjround;
        }
    }

    private void jjAddStates(int i, int i2) {
        do {
            int[] iArr = this.jjstateSet;
            int i3 = this.jjnewStateCnt;
            this.jjnewStateCnt = i3 + 1;
            iArr[i3] = jjnextStates[i];
            i++;
        } while (i != i2);
    }

    private void jjCheckNAddTwoStates(int i, int i2) {
        jjCheckNAdd(i);
        jjCheckNAdd(i2);
    }

    private void jjCheckNAddStates(int i, int i2) {
        do {
            jjCheckNAdd(jjnextStates[i]);
            i++;
        } while (i != i2);
    }
}
