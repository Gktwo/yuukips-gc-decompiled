package p013io.netty.handler.codec;

import java.util.BitSet;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.TimeZone;
import p013io.netty.util.AsciiString;
import p013io.netty.util.concurrent.FastThreadLocal;
import p013io.netty.util.internal.ObjectUtil;

/* renamed from: io.netty.handler.codec.DateFormatter */
/* loaded from: grasscutter.jar:io/netty/handler/codec/DateFormatter.class */
public final class DateFormatter {
    private static final BitSet DELIMITERS = new BitSet();
    private static final String[] DAY_OF_WEEK_TO_SHORT_NAME;
    private static final String[] CALENDAR_MONTH_TO_SHORT_NAME;
    private static final FastThreadLocal<DateFormatter> INSTANCES;
    private final GregorianCalendar cal;

    /* renamed from: sb */
    private final StringBuilder f959sb;
    private boolean timeFound;
    private int hours;
    private int minutes;
    private int seconds;
    private boolean dayOfMonthFound;
    private int dayOfMonth;
    private boolean monthFound;
    private int month;
    private boolean yearFound;
    private int year;

    static {
        DELIMITERS.set(9);
        for (char c = ' '; c <= '/'; c = (char) (c + 1)) {
            DELIMITERS.set(c);
        }
        for (char c2 = ';'; c2 <= '@'; c2 = (char) (c2 + 1)) {
            DELIMITERS.set(c2);
        }
        for (char c3 = '['; c3 <= '`'; c3 = (char) (c3 + 1)) {
            DELIMITERS.set(c3);
        }
        for (char c4 = '{'; c4 <= '~'; c4 = (char) (c4 + 1)) {
            DELIMITERS.set(c4);
        }
        DAY_OF_WEEK_TO_SHORT_NAME = new String[]{"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
        CALENDAR_MONTH_TO_SHORT_NAME = new String[]{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        INSTANCES = new FastThreadLocal<DateFormatter>() { // from class: io.netty.handler.codec.DateFormatter.1
            /* access modifiers changed from: protected */
            @Override // p013io.netty.util.concurrent.FastThreadLocal
            public DateFormatter initialValue() {
                return new DateFormatter();
            }
        };
    }

    public static Date parseHttpDate(CharSequence txt) {
        return parseHttpDate(txt, 0, txt.length());
    }

    public static Date parseHttpDate(CharSequence txt, int start, int end) {
        int length = end - start;
        if (length == 0) {
            return null;
        }
        if (length < 0) {
            throw new IllegalArgumentException("Can't have end < start");
        } else if (length <= 64) {
            return formatter().parse0((CharSequence) ObjectUtil.checkNotNull(txt, "txt"), start, end);
        } else {
            throw new IllegalArgumentException("Can't parse more than 64 chars, looks like a user error or a malformed header");
        }
    }

    public static String format(Date date) {
        return formatter().format0((Date) ObjectUtil.checkNotNull(date, "date"));
    }

    public static StringBuilder append(Date date, StringBuilder sb) {
        return formatter().append0((Date) ObjectUtil.checkNotNull(date, "date"), (StringBuilder) ObjectUtil.checkNotNull(sb, "sb"));
    }

    private static DateFormatter formatter() {
        DateFormatter formatter = INSTANCES.get();
        formatter.reset();
        return formatter;
    }

    private static boolean isDelim(char c) {
        return DELIMITERS.get(c);
    }

    private static boolean isDigit(char c) {
        return c >= '0' && c <= '9';
    }

    private static int getNumericalValue(char c) {
        return c - '0';
    }

    private DateFormatter() {
        this.cal = new GregorianCalendar(TimeZone.getTimeZone("UTC"));
        this.f959sb = new StringBuilder(29);
        reset();
    }

    public void reset() {
        this.timeFound = false;
        this.hours = -1;
        this.minutes = -1;
        this.seconds = -1;
        this.dayOfMonthFound = false;
        this.dayOfMonth = -1;
        this.monthFound = false;
        this.month = -1;
        this.yearFound = false;
        this.year = -1;
        this.cal.clear();
        this.f959sb.setLength(0);
    }

    private boolean tryParseTime(CharSequence txt, int tokenStart, int tokenEnd) {
        int len = tokenEnd - tokenStart;
        if (len < 5 || len > 8) {
            return false;
        }
        int localHours = -1;
        int localMinutes = -1;
        int localSeconds = -1;
        int currentPartNumber = 0;
        int currentPartValue = 0;
        int numDigits = 0;
        for (int i = tokenStart; i < tokenEnd; i++) {
            char c = txt.charAt(i);
            if (isDigit(c)) {
                currentPartValue = (currentPartValue * 10) + getNumericalValue(c);
                numDigits++;
                if (numDigits > 2) {
                    return false;
                }
            } else if (c != ':' || numDigits == 0) {
                return false;
            } else {
                switch (currentPartNumber) {
                    case 0:
                        localHours = currentPartValue;
                        break;
                    case 1:
                        localMinutes = currentPartValue;
                        break;
                    default:
                        return false;
                }
                currentPartValue = 0;
                currentPartNumber++;
                numDigits = 0;
            }
        }
        if (numDigits > 0) {
            localSeconds = currentPartValue;
        }
        if (localHours < 0 || localMinutes < 0 || localSeconds < 0) {
            return false;
        }
        this.hours = localHours;
        this.minutes = localMinutes;
        this.seconds = localSeconds;
        return true;
    }

    private boolean tryParseDayOfMonth(CharSequence txt, int tokenStart, int tokenEnd) {
        int len = tokenEnd - tokenStart;
        if (len == 1) {
            char c0 = txt.charAt(tokenStart);
            if (!isDigit(c0)) {
                return false;
            }
            this.dayOfMonth = getNumericalValue(c0);
            return true;
        } else if (len != 2) {
            return false;
        } else {
            char c02 = txt.charAt(tokenStart);
            char c1 = txt.charAt(tokenStart + 1);
            if (!isDigit(c02) || !isDigit(c1)) {
                return false;
            }
            this.dayOfMonth = (getNumericalValue(c02) * 10) + getNumericalValue(c1);
            return true;
        }
    }

    private boolean tryParseMonth(CharSequence txt, int tokenStart, int tokenEnd) {
        if (tokenEnd - tokenStart != 3) {
            return false;
        }
        char monthChar1 = AsciiString.toLowerCase(txt.charAt(tokenStart));
        char monthChar2 = AsciiString.toLowerCase(txt.charAt(tokenStart + 1));
        char monthChar3 = AsciiString.toLowerCase(txt.charAt(tokenStart + 2));
        if (monthChar1 == 'j' && monthChar2 == 'a' && monthChar3 == 'n') {
            this.month = 0;
            return true;
        } else if (monthChar1 == 'f' && monthChar2 == 'e' && monthChar3 == 'b') {
            this.month = 1;
            return true;
        } else if (monthChar1 == 'm' && monthChar2 == 'a' && monthChar3 == 'r') {
            this.month = 2;
            return true;
        } else if (monthChar1 == 'a' && monthChar2 == 'p' && monthChar3 == 'r') {
            this.month = 3;
            return true;
        } else if (monthChar1 == 'm' && monthChar2 == 'a' && monthChar3 == 'y') {
            this.month = 4;
            return true;
        } else if (monthChar1 == 'j' && monthChar2 == 'u' && monthChar3 == 'n') {
            this.month = 5;
            return true;
        } else if (monthChar1 == 'j' && monthChar2 == 'u' && monthChar3 == 'l') {
            this.month = 6;
            return true;
        } else if (monthChar1 == 'a' && monthChar2 == 'u' && monthChar3 == 'g') {
            this.month = 7;
            return true;
        } else if (monthChar1 == 's' && monthChar2 == 'e' && monthChar3 == 'p') {
            this.month = 8;
            return true;
        } else if (monthChar1 == 'o' && monthChar2 == 'c' && monthChar3 == 't') {
            this.month = 9;
            return true;
        } else if (monthChar1 == 'n' && monthChar2 == 'o' && monthChar3 == 'v') {
            this.month = 10;
            return true;
        } else if (monthChar1 != 'd' || monthChar2 != 'e' || monthChar3 != 'c') {
            return false;
        } else {
            this.month = 11;
            return true;
        }
    }

    private boolean tryParseYear(CharSequence txt, int tokenStart, int tokenEnd) {
        int len = tokenEnd - tokenStart;
        if (len == 2) {
            char c0 = txt.charAt(tokenStart);
            char c1 = txt.charAt(tokenStart + 1);
            if (!isDigit(c0) || !isDigit(c1)) {
                return false;
            }
            this.year = (getNumericalValue(c0) * 10) + getNumericalValue(c1);
            return true;
        } else if (len != 4) {
            return false;
        } else {
            char c02 = txt.charAt(tokenStart);
            char c12 = txt.charAt(tokenStart + 1);
            char c2 = txt.charAt(tokenStart + 2);
            char c3 = txt.charAt(tokenStart + 3);
            if (!isDigit(c02) || !isDigit(c12) || !isDigit(c2) || !isDigit(c3)) {
                return false;
            }
            this.year = (getNumericalValue(c02) * 1000) + (getNumericalValue(c12) * 100) + (getNumericalValue(c2) * 10) + getNumericalValue(c3);
            return true;
        }
    }

    private boolean parseToken(CharSequence txt, int tokenStart, int tokenEnd) {
        if (!this.timeFound) {
            this.timeFound = tryParseTime(txt, tokenStart, tokenEnd);
            if (this.timeFound) {
                return this.dayOfMonthFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.dayOfMonthFound) {
            this.dayOfMonthFound = tryParseDayOfMonth(txt, tokenStart, tokenEnd);
            if (this.dayOfMonthFound) {
                return this.timeFound && this.monthFound && this.yearFound;
            }
        }
        if (!this.monthFound) {
            this.monthFound = tryParseMonth(txt, tokenStart, tokenEnd);
            if (this.monthFound) {
                return this.timeFound && this.dayOfMonthFound && this.yearFound;
            }
        }
        if (!this.yearFound) {
            this.yearFound = tryParseYear(txt, tokenStart, tokenEnd);
        }
        return this.timeFound && this.dayOfMonthFound && this.monthFound && this.yearFound;
    }

    private Date parse0(CharSequence txt, int start, int end) {
        if (!parse1(txt, start, end) || !normalizeAndValidate()) {
            return null;
        }
        return computeDate();
    }

    private boolean parse1(CharSequence txt, int start, int end) {
        int tokenStart = -1;
        for (int i = start; i < end; i++) {
            if (isDelim(txt.charAt(i))) {
                if (tokenStart == -1) {
                    continue;
                } else if (parseToken(txt, tokenStart, i)) {
                    return true;
                } else {
                    tokenStart = -1;
                }
            } else if (tokenStart == -1) {
                tokenStart = i;
            }
        }
        return tokenStart != -1 && parseToken(txt, tokenStart, txt.length());
    }

    private boolean normalizeAndValidate() {
        if (this.dayOfMonth < 1 || this.dayOfMonth > 31 || this.hours > 23 || this.minutes > 59 || this.seconds > 59) {
            return false;
        }
        if (this.year >= 70 && this.year <= 99) {
            this.year += 1900;
            return true;
        } else if (this.year >= 0 && this.year < 70) {
            this.year += 2000;
            return true;
        } else if (this.year < 1601) {
            return false;
        } else {
            return true;
        }
    }

    private Date computeDate() {
        this.cal.set(5, this.dayOfMonth);
        this.cal.set(2, this.month);
        this.cal.set(1, this.year);
        this.cal.set(11, this.hours);
        this.cal.set(12, this.minutes);
        this.cal.set(13, this.seconds);
        return this.cal.getTime();
    }

    private String format0(Date date) {
        append0(date, this.f959sb);
        return this.f959sb.toString();
    }

    private StringBuilder append0(Date date, StringBuilder sb) {
        this.cal.setTime(date);
        sb.append(DAY_OF_WEEK_TO_SHORT_NAME[this.cal.get(7) - 1]).append(", ");
        appendZeroLeftPadded(this.cal.get(5), sb).append(' ');
        sb.append(CALENDAR_MONTH_TO_SHORT_NAME[this.cal.get(2)]).append(' ');
        sb.append(this.cal.get(1)).append(' ');
        appendZeroLeftPadded(this.cal.get(11), sb).append(':');
        appendZeroLeftPadded(this.cal.get(12), sb).append(':');
        return appendZeroLeftPadded(this.cal.get(13), sb).append(" GMT");
    }

    private static StringBuilder appendZeroLeftPadded(int value, StringBuilder sb) {
        if (value < 10) {
            sb.append('0');
        }
        return sb.append(value);
    }
}
