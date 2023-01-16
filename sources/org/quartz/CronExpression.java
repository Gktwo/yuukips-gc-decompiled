package org.quartz;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.TimeZone;
import java.util.TreeSet;

/* loaded from: grasscutter.jar:org/quartz/CronExpression.class */
public final class CronExpression implements Serializable, Cloneable {
    private static final long serialVersionUID = 12423409423L;
    protected static final int SECOND = 0;
    protected static final int MINUTE = 1;
    protected static final int HOUR = 2;
    protected static final int DAY_OF_MONTH = 3;
    protected static final int MONTH = 4;
    protected static final int DAY_OF_WEEK = 5;
    protected static final int YEAR = 6;
    protected static final int ALL_SPEC_INT = 99;
    protected static final int NO_SPEC_INT = 98;
    private final String cronExpression;
    protected transient TreeSet<Integer> seconds;
    protected transient TreeSet<Integer> minutes;
    protected transient TreeSet<Integer> hours;
    protected transient TreeSet<Integer> daysOfMonth;
    protected transient TreeSet<Integer> months;
    protected transient TreeSet<Integer> daysOfWeek;
    protected transient TreeSet<Integer> years;
    protected static final Integer ALL_SPEC = 99;
    protected static final Integer NO_SPEC = 98;
    protected static final Map<String, Integer> monthMap = new HashMap(20);
    protected static final Map<String, Integer> dayMap = new HashMap(60);
    public static final int MAX_YEAR = Calendar.getInstance().get(1) + 100;
    private TimeZone timeZone = null;
    protected transient boolean lastdayOfWeek = false;
    protected transient int nthdayOfWeek = 0;
    protected transient boolean lastdayOfMonth = false;
    protected transient boolean nearestWeekday = false;
    protected transient int lastdayOffset = 0;
    protected transient boolean expressionParsed = false;

    static {
        monthMap.put("JAN", 0);
        monthMap.put("FEB", 1);
        monthMap.put("MAR", 2);
        monthMap.put("APR", 3);
        monthMap.put("MAY", 4);
        monthMap.put("JUN", 5);
        monthMap.put("JUL", 6);
        monthMap.put("AUG", 7);
        monthMap.put("SEP", 8);
        monthMap.put("OCT", 9);
        monthMap.put("NOV", 10);
        monthMap.put("DEC", 11);
        dayMap.put("SUN", 1);
        dayMap.put("MON", 2);
        dayMap.put("TUE", 3);
        dayMap.put("WED", 4);
        dayMap.put("THU", 5);
        dayMap.put("FRI", 6);
        dayMap.put("SAT", 7);
    }

    public CronExpression(String cronExpression) throws ParseException {
        if (cronExpression == null) {
            throw new IllegalArgumentException("cronExpression cannot be null");
        }
        this.cronExpression = cronExpression.toUpperCase(Locale.US);
        buildExpression(this.cronExpression);
    }

    public CronExpression(CronExpression expression) {
        this.cronExpression = expression.getCronExpression();
        try {
            buildExpression(this.cronExpression);
            if (expression.getTimeZone() != null) {
                setTimeZone((TimeZone) expression.getTimeZone().clone());
            }
        } catch (ParseException e) {
            throw new AssertionError();
        }
    }

    public boolean isSatisfiedBy(Date date) {
        Calendar testDateCal = Calendar.getInstance(getTimeZone());
        testDateCal.setTime(date);
        testDateCal.set(14, 0);
        Date originalDate = testDateCal.getTime();
        testDateCal.add(13, -1);
        Date timeAfter = getTimeAfter(testDateCal.getTime());
        return timeAfter != null && timeAfter.equals(originalDate);
    }

    public Date getNextValidTimeAfter(Date date) {
        return getTimeAfter(date);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:15:0x0022 */
    /* JADX WARN: Type inference failed for: r9v0 */
    /* JADX WARN: Type inference failed for: r9v1 */
    /* JADX WARN: Type inference failed for: r9v2, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date getNextInvalidTimeAfter(java.util.Date r8) {
        /*
            r7 = this;
            r0 = 1000(0x3e8, double:4.94E-321)
            r9 = r0
            r0 = r7
            java.util.TimeZone r0 = r0.getTimeZone()
            java.util.Calendar r0 = java.util.Calendar.getInstance(r0)
            r11 = r0
            r0 = r11
            r1 = r8
            r0.setTime(r1)
            r0 = r11
            r1 = 14
            r2 = 0
            r0.set(r1, r2)
            r0 = r11
            java.util.Date r0 = r0.getTime()
            r12 = r0
        L_0x0022:
            r0 = r9
            r1 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0055
            r0 = r7
            r1 = r12
            java.util.Date r0 = r0.getTimeAfter(r1)
            r13 = r0
            r0 = r13
            if (r0 != 0) goto L_0x003a
            goto L_0x0055
        L_0x003a:
            r0 = r13
            long r0 = r0.getTime()
            r1 = r12
            long r1 = r1.getTime()
            long r0 = r0 - r1
            r9 = r0
            r0 = r9
            r1 = 1000(0x3e8, double:4.94E-321)
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 != 0) goto L_0x0022
            r0 = r13
            r12 = r0
            goto L_0x0022
        L_0x0055:
            java.util.Date r0 = new java.util.Date
            r1 = r0
            r2 = r12
            long r2 = r2.getTime()
            r3 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 + r3
            r1.<init>(r2)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.CronExpression.getNextInvalidTimeAfter(java.util.Date):java.util.Date");
    }

    public TimeZone getTimeZone() {
        if (this.timeZone == null) {
            this.timeZone = TimeZone.getDefault();
        }
        return this.timeZone;
    }

    public void setTimeZone(TimeZone timeZone) {
        this.timeZone = timeZone;
    }

    @Override // java.lang.Object
    public String toString() {
        return this.cronExpression;
    }

    public static boolean isValidExpression(String cronExpression) {
        try {
            new CronExpression(cronExpression);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }

    public static void validateExpression(String cronExpression) throws ParseException {
        new CronExpression(cronExpression);
    }

    protected void buildExpression(String expression) throws ParseException {
        this.expressionParsed = true;
        try {
            if (this.seconds == null) {
                this.seconds = new TreeSet<>();
            }
            if (this.minutes == null) {
                this.minutes = new TreeSet<>();
            }
            if (this.hours == null) {
                this.hours = new TreeSet<>();
            }
            if (this.daysOfMonth == null) {
                this.daysOfMonth = new TreeSet<>();
            }
            if (this.months == null) {
                this.months = new TreeSet<>();
            }
            if (this.daysOfWeek == null) {
                this.daysOfWeek = new TreeSet<>();
            }
            if (this.years == null) {
                this.years = new TreeSet<>();
            }
            int exprOn = 0;
            StringTokenizer exprsTok = new StringTokenizer(expression, " \t", false);
            while (exprsTok.hasMoreTokens() && exprOn <= 6) {
                String expr = exprsTok.nextToken().trim();
                if (exprOn == 3 && expr.indexOf(76) != -1 && expr.length() > 1 && expr.contains(",")) {
                    throw new ParseException("Support for specifying 'L' and 'LW' with other days of the month is not implemented", -1);
                } else if (exprOn == 5 && expr.indexOf(76) != -1 && expr.length() > 1 && expr.contains(",")) {
                    throw new ParseException("Support for specifying 'L' with other days of the week is not implemented", -1);
                } else if (exprOn != 5 || expr.indexOf(35) == -1 || expr.indexOf(35, expr.indexOf(35) + 1) == -1) {
                    StringTokenizer vTok = new StringTokenizer(expr, ",");
                    while (vTok.hasMoreTokens()) {
                        storeExpressionVals(0, vTok.nextToken(), exprOn);
                    }
                    exprOn++;
                } else {
                    throw new ParseException("Support for specifying multiple \"nth\" days is not implemented.", -1);
                }
            }
            if (exprOn <= 5) {
                throw new ParseException("Unexpected end of expression.", expression.length());
            }
            if (exprOn <= 6) {
                storeExpressionVals(0, "*", 6);
            }
            TreeSet<Integer> dow = getSet(5);
            boolean dayOfMSpec = !getSet(3).contains(NO_SPEC);
            boolean dayOfWSpec = !dow.contains(NO_SPEC);
            if ((!dayOfMSpec || dayOfWSpec) && (!dayOfWSpec || dayOfMSpec)) {
                throw new ParseException("Support for specifying both a day-of-week AND a day-of-month parameter is not implemented.", 0);
            }
        } catch (ParseException pe) {
            throw pe;
        } catch (Exception e) {
            throw new ParseException("Illegal cron expression format (" + e.toString() + ")", 0);
        }
    }

    protected int storeExpressionVals(int pos, String s, int type) throws ParseException {
        int incr;
        int sval;
        int incr2 = 0;
        int i = skipWhiteSpace(pos, s);
        if (i >= s.length()) {
            return i;
        }
        char c = s.charAt(i);
        if (c >= 'A' && c <= 'Z' && !s.equals("L") && !s.equals("LW") && !s.matches("^L-[0-9]*[W]?")) {
            String sub = s.substring(i, i + 3);
            int eval = -1;
            if (type == 4) {
                sval = getMonthNumber(sub) + 1;
                if (sval <= 0) {
                    throw new ParseException("Invalid Month value: '" + sub + "'", i);
                } else if (s.length() > i + 3 && s.charAt(i + 3) == '-') {
                    i += 4;
                    String sub2 = s.substring(i, i + 3);
                    eval = getMonthNumber(sub2) + 1;
                    if (eval <= 0) {
                        throw new ParseException("Invalid Month value: '" + sub2 + "'", i);
                    }
                }
            } else if (type == 5) {
                sval = getDayOfWeekNumber(sub);
                if (sval < 0) {
                    throw new ParseException("Invalid Day-of-Week value: '" + sub + "'", i);
                } else if (s.length() > i + 3) {
                    char c2 = s.charAt(i + 3);
                    if (c2 == '-') {
                        i += 4;
                        String sub3 = s.substring(i, i + 3);
                        eval = getDayOfWeekNumber(sub3);
                        if (eval < 0) {
                            throw new ParseException("Invalid Day-of-Week value: '" + sub3 + "'", i);
                        }
                    } else if (c2 == '#') {
                        try {
                            i += 4;
                            this.nthdayOfWeek = Integer.parseInt(s.substring(i));
                            if (this.nthdayOfWeek < 1 || this.nthdayOfWeek > 5) {
                                throw new Exception();
                            }
                        } catch (Exception e) {
                            throw new ParseException("A numeric value between 1 and 5 must follow the '#' option", i);
                        }
                    } else if (c2 == 'L') {
                        this.lastdayOfWeek = true;
                        i++;
                    }
                }
            } else {
                throw new ParseException("Illegal characters for this position: '" + sub + "'", i);
            }
            if (eval != -1) {
                incr2 = 1;
            }
            addToSet(sval, eval, incr2, type);
            return i + 3;
        } else if (c == '?') {
            int i2 = i + 1;
            if (i2 + 1 < s.length() && s.charAt(i2) != ' ' && s.charAt(i2 + 1) != '\t') {
                throw new ParseException("Illegal character after '?': " + s.charAt(i2), i2);
            } else if (type != 5 && type != 3) {
                throw new ParseException("'?' can only be specified for Day-of-Month or Day-of-Week.", i2);
            } else if (type == 5 && !this.lastdayOfMonth && this.daysOfMonth.last().intValue() == 98) {
                throw new ParseException("'?' can only be specified for Day-of-Month -OR- Day-of-Week.", i2);
            } else {
                addToSet(98, -1, 0, type);
                return i2;
            }
        } else if (c == '*' || c == '/') {
            if (c == '*' && i + 1 >= s.length()) {
                addToSet(99, -1, 0, type);
                return i + 1;
            } else if (c == '/' && (i + 1 >= s.length() || s.charAt(i + 1) == ' ' || s.charAt(i + 1) == '\t')) {
                throw new ParseException("'/' must be followed by an integer.", i);
            } else {
                if (c == '*') {
                    i++;
                }
                if (s.charAt(i) == '/') {
                    int i3 = i + 1;
                    if (i3 >= s.length()) {
                        throw new ParseException("Unexpected end of string.", i3);
                    }
                    incr = getNumericValue(s, i3);
                    i = i3 + 1;
                    if (incr > 10) {
                        i++;
                    }
                    checkIncrementRange(incr, type, i);
                } else {
                    incr = 1;
                }
                addToSet(99, -1, incr, type);
                return i;
            }
        } else if (c == 'L') {
            int i4 = i + 1;
            if (type == 3) {
                this.lastdayOfMonth = true;
            }
            if (type == 5) {
                addToSet(7, 7, 0, type);
            }
            if (type == 3 && s.length() > i4) {
                if (s.charAt(i4) == '-') {
                    ValueSet vs = getValue(0, s, i4 + 1);
                    this.lastdayOffset = vs.value;
                    if (this.lastdayOffset > 30) {
                        throw new ParseException("Offset from last day must be <= 30", i4 + 1);
                    }
                    i4 = vs.pos;
                }
                if (s.length() > i4 && s.charAt(i4) == 'W') {
                    this.nearestWeekday = true;
                    i4++;
                }
            }
            return i4;
        } else if (c < '0' || c > '9') {
            throw new ParseException("Unexpected character: " + c, i);
        } else {
            int val = Integer.parseInt(String.valueOf(c));
            int i5 = i + 1;
            if (i5 >= s.length()) {
                addToSet(val, -1, -1, type);
                return i5;
            }
            char c3 = s.charAt(i5);
            if (c3 >= '0' && c3 <= '9') {
                ValueSet vs2 = getValue(val, s, i5);
                val = vs2.value;
                i5 = vs2.pos;
            }
            return checkNext(i5, s, val, type);
        }
    }

    private void checkIncrementRange(int incr, int type, int idxPos) throws ParseException {
        if (incr > 59 && (type == 0 || type == 1)) {
            throw new ParseException("Increment > 60 : " + incr, idxPos);
        } else if (incr > 23 && type == 2) {
            throw new ParseException("Increment > 24 : " + incr, idxPos);
        } else if (incr > 31 && type == 3) {
            throw new ParseException("Increment > 31 : " + incr, idxPos);
        } else if (incr > 7 && type == 5) {
            throw new ParseException("Increment > 7 : " + incr, idxPos);
        } else if (incr > 12 && type == 4) {
            throw new ParseException("Increment > 12 : " + incr, idxPos);
        }
    }

    protected int checkNext(int pos, String s, int val, int type) throws ParseException {
        if (pos >= s.length()) {
            addToSet(val, -1, -1, type);
            return pos;
        }
        char c = s.charAt(pos);
        if (c == 'L') {
            if (type != 5) {
                throw new ParseException("'L' option is not valid here. (pos=" + pos + ")", pos);
            } else if (val < 1 || val > 7) {
                throw new ParseException("Day-of-Week values must be between 1 and 7", -1);
            } else {
                this.lastdayOfWeek = true;
                getSet(type).add(Integer.valueOf(val));
                return pos + 1;
            }
        } else if (c == 'W') {
            if (type == 3) {
                this.nearestWeekday = true;
                if (val > 31) {
                    throw new ParseException("The 'W' option does not make sense with values larger than 31 (max number of days in a month)", pos);
                }
                getSet(type).add(Integer.valueOf(val));
                return pos + 1;
            }
            throw new ParseException("'W' option is not valid here. (pos=" + pos + ")", pos);
        } else if (c == '#') {
            if (type != 5) {
                throw new ParseException("'#' option is not valid here. (pos=" + pos + ")", pos);
            }
            int i = pos + 1;
            try {
                this.nthdayOfWeek = Integer.parseInt(s.substring(i));
                if (this.nthdayOfWeek < 1 || this.nthdayOfWeek > 5) {
                    throw new Exception();
                }
                getSet(type).add(Integer.valueOf(val));
                return i + 1;
            } catch (Exception e) {
                throw new ParseException("A numeric value between 1 and 5 must follow the '#' option", i);
            }
        } else if (c == '-') {
            int i2 = pos + 1;
            int v = Integer.parseInt(String.valueOf(s.charAt(i2)));
            int end = v;
            int i3 = i2 + 1;
            if (i3 >= s.length()) {
                addToSet(val, end, 1, type);
                return i3;
            }
            char c2 = s.charAt(i3);
            if (c2 >= '0' && c2 <= '9') {
                ValueSet vs = getValue(v, s, i3);
                end = vs.value;
                i3 = vs.pos;
            }
            if (i3 >= s.length() || s.charAt(i3) != '/') {
                addToSet(val, end, 1, type);
                return i3;
            }
            int i4 = i3 + 1;
            int v2 = Integer.parseInt(String.valueOf(s.charAt(i4)));
            int i5 = i4 + 1;
            if (i5 >= s.length()) {
                addToSet(val, end, v2, type);
                return i5;
            }
            char c3 = s.charAt(i5);
            if (c3 < '0' || c3 > '9') {
                addToSet(val, end, v2, type);
                return i5;
            }
            ValueSet vs2 = getValue(v2, s, i5);
            addToSet(val, end, vs2.value, type);
            return vs2.pos;
        } else if (c != '/') {
            addToSet(val, -1, 0, type);
            return pos + 1;
        } else if (pos + 1 >= s.length() || s.charAt(pos + 1) == ' ' || s.charAt(pos + 1) == '\t') {
            throw new ParseException("'/' must be followed by an integer.", pos);
        } else {
            int i6 = pos + 1;
            int v22 = Integer.parseInt(String.valueOf(s.charAt(i6)));
            int i7 = i6 + 1;
            if (i7 >= s.length()) {
                checkIncrementRange(v22, type, i7);
                addToSet(val, -1, v22, type);
                return i7;
            }
            char c4 = s.charAt(i7);
            if (c4 < '0' || c4 > '9') {
                throw new ParseException("Unexpected character '" + c4 + "' after '/'", i7);
            }
            ValueSet vs3 = getValue(v22, s, i7);
            int v3 = vs3.value;
            checkIncrementRange(v3, type, i7);
            addToSet(val, -1, v3, type);
            return vs3.pos;
        }
    }

    public String getCronExpression() {
        return this.cronExpression;
    }

    public String getExpressionSummary() {
        return "seconds: " + getExpressionSetSummary(this.seconds) + "\nminutes: " + getExpressionSetSummary(this.minutes) + "\nhours: " + getExpressionSetSummary(this.hours) + "\ndaysOfMonth: " + getExpressionSetSummary(this.daysOfMonth) + "\nmonths: " + getExpressionSetSummary(this.months) + "\ndaysOfWeek: " + getExpressionSetSummary(this.daysOfWeek) + "\nlastdayOfWeek: " + this.lastdayOfWeek + "\nnearestWeekday: " + this.nearestWeekday + "\nNthDayOfWeek: " + this.nthdayOfWeek + "\nlastdayOfMonth: " + this.lastdayOfMonth + "\nyears: " + getExpressionSetSummary(this.years) + "\n";
    }

    protected String getExpressionSetSummary(Set<Integer> set) {
        if (set.contains(NO_SPEC)) {
            return "?";
        }
        if (set.contains(ALL_SPEC)) {
            return "*";
        }
        StringBuilder buf = new StringBuilder();
        boolean first = true;
        for (Integer iVal : set) {
            String val = iVal.toString();
            if (!first) {
                buf.append(",");
            }
            buf.append(val);
            first = false;
        }
        return buf.toString();
    }

    protected String getExpressionSetSummary(ArrayList<Integer> list) {
        if (list.contains(NO_SPEC)) {
            return "?";
        }
        if (list.contains(ALL_SPEC)) {
            return "*";
        }
        StringBuilder buf = new StringBuilder();
        Iterator<Integer> itr = list.iterator();
        boolean first = true;
        while (itr.hasNext()) {
            String val = itr.next().toString();
            if (!first) {
                buf.append(",");
            }
            buf.append(val);
            first = false;
        }
        return buf.toString();
    }

    protected int skipWhiteSpace(int i, String s) {
        while (i < s.length() && (s.charAt(i) == ' ' || s.charAt(i) == '\t')) {
            i++;
        }
        return i;
    }

    protected int findNextWhiteSpace(int i, String s) {
        while (i < s.length() && (s.charAt(i) != ' ' || s.charAt(i) != '\t')) {
            i++;
        }
        return i;
    }

    protected void addToSet(int val, int end, int incr, int type) throws ParseException {
        TreeSet<Integer> set = getSet(type);
        if (type == 0 || type == 1) {
            if ((val < 0 || val > 59 || end > 59) && val != 99) {
                throw new ParseException("Minute and Second values must be between 0 and 59", -1);
            }
        } else if (type == 2) {
            if ((val < 0 || val > 23 || end > 23) && val != 99) {
                throw new ParseException("Hour values must be between 0 and 23", -1);
            }
        } else if (type == 3) {
            if (!((val >= 1 && val <= 31 && end <= 31) || val == 99 || val == 98)) {
                throw new ParseException("Day of month values must be between 1 and 31", -1);
            }
        } else if (type == 4) {
            if ((val < 1 || val > 12 || end > 12) && val != 99) {
                throw new ParseException("Month values must be between 1 and 12", -1);
            }
        } else if (type == 5 && !((val != 0 && val <= 7 && end <= 7) || val == 99 || val == 98)) {
            throw new ParseException("Day-of-Week values must be between 1 and 7", -1);
        }
        if (!(incr == 0 || incr == -1) || val == 99) {
            int startAt = val;
            int stopAt = end;
            if (val == 99 && incr <= 0) {
                incr = 1;
                set.add(ALL_SPEC);
            }
            if (type == 0 || type == 1) {
                if (stopAt == -1) {
                    stopAt = 59;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 0;
                }
            } else if (type == 2) {
                if (stopAt == -1) {
                    stopAt = 23;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 0;
                }
            } else if (type == 3) {
                if (stopAt == -1) {
                    stopAt = 31;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 1;
                }
            } else if (type == 4) {
                if (stopAt == -1) {
                    stopAt = 12;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 1;
                }
            } else if (type == 5) {
                if (stopAt == -1) {
                    stopAt = 7;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 1;
                }
            } else if (type == 6) {
                if (stopAt == -1) {
                    stopAt = MAX_YEAR;
                }
                if (startAt == -1 || startAt == 99) {
                    startAt = 1970;
                }
            }
            int max = -1;
            if (stopAt < startAt) {
                switch (type) {
                    case 0:
                        max = 60;
                        break;
                    case 1:
                        max = 60;
                        break;
                    case 2:
                        max = 24;
                        break;
                    case 3:
                        max = 31;
                        break;
                    case 4:
                        max = 12;
                        break;
                    case 5:
                        max = 7;
                        break;
                    case 6:
                        throw new IllegalArgumentException("Start year must be less than stop year");
                    default:
                        throw new IllegalArgumentException("Unexpected type encountered");
                }
                stopAt += max;
            }
            for (int i = startAt; i <= stopAt; i += incr) {
                if (max == -1) {
                    set.add(Integer.valueOf(i));
                } else {
                    int i2 = i % max;
                    if (i2 == 0 && (type == 4 || type == 5 || type == 3)) {
                        i2 = max;
                    }
                    set.add(Integer.valueOf(i2));
                }
            }
        } else if (val != -1) {
            set.add(Integer.valueOf(val));
        } else {
            set.add(NO_SPEC);
        }
    }

    TreeSet<Integer> getSet(int type) {
        switch (type) {
            case 0:
                return this.seconds;
            case 1:
                return this.minutes;
            case 2:
                return this.hours;
            case 3:
                return this.daysOfMonth;
            case 4:
                return this.months;
            case 5:
                return this.daysOfWeek;
            case 6:
                return this.years;
            default:
                return null;
        }
    }

    protected ValueSet getValue(int v, String s, int i) {
        char c = s.charAt(i);
        StringBuilder s1 = new StringBuilder(String.valueOf(v));
        while (c >= '0' && c <= '9') {
            s1.append(c);
            i++;
            if (i >= s.length()) {
                break;
            }
            c = s.charAt(i);
        }
        ValueSet val = new ValueSet();
        val.pos = i < s.length() ? i : i + 1;
        val.value = Integer.parseInt(s1.toString());
        return val;
    }

    protected int getNumericValue(String s, int i) {
        return Integer.parseInt(s.substring(i, findNextWhiteSpace(i, s)));
    }

    protected int getMonthNumber(String s) {
        Integer integer = monthMap.get(s);
        if (integer == null) {
            return -1;
        }
        return integer.intValue();
    }

    protected int getDayOfWeekNumber(String s) {
        Integer integer = dayMap.get(s);
        if (integer == null) {
            return -1;
        }
        return integer.intValue();
    }

    /* JADX WARNING: Removed duplicated region for block: B:174:0x0785  */
    /* JADX WARNING: Removed duplicated region for block: B:225:0x0783 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.Date getTimeAfter(java.util.Date r8) {
        /*
        // Method dump skipped, instructions count: 2186
        */
        throw new UnsupportedOperationException("Method not decompiled: org.quartz.CronExpression.getTimeAfter(java.util.Date):java.util.Date");
    }

    protected void setCalendarHour(Calendar cal, int hour) {
        cal.set(11, hour);
        if (cal.get(11) != hour && hour != 24) {
            cal.set(11, hour + 1);
        }
    }

    public Date getTimeBefore(Date endTime) {
        return null;
    }

    public Date getFinalFireTime() {
        return null;
    }

    protected boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }

    protected int getLastDayOfMonth(int monthNum, int year) {
        switch (monthNum) {
            case 1:
                return 31;
            case 2:
                return isLeapYear(year) ? 29 : 28;
            case 3:
                return 31;
            case 4:
                return 30;
            case 5:
                return 31;
            case 6:
                return 30;
            case 7:
                return 31;
            case 8:
                return 31;
            case 9:
                return 30;
            case 10:
                return 31;
            case 11:
                return 30;
            case 12:
                return 31;
            default:
                throw new IllegalArgumentException("Illegal month number: " + monthNum);
        }
    }

    private void readObject(ObjectInputStream stream) throws IOException, ClassNotFoundException {
        stream.defaultReadObject();
        try {
            buildExpression(this.cronExpression);
        } catch (Exception e) {
        }
    }

    @Override // java.lang.Object
    @Deprecated
    public Object clone() {
        return new CronExpression(this);
    }
}
