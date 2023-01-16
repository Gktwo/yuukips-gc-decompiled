package org.eclipse.jetty.http;

import java.util.GregorianCalendar;
import java.util.TimeZone;
import org.eclipse.jetty.util.StringUtil;
import org.quartz.DateBuilder;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/DateGenerator.class */
public class DateGenerator {
    private static final TimeZone __GMT = TimeZone.getTimeZone("GMT");
    static final String[] DAYS = {"Sat", "Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    static final String[] MONTHS = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec", "Jan"};
    private static final ThreadLocal<DateGenerator> __dateGenerator = new ThreadLocal<DateGenerator>() { // from class: org.eclipse.jetty.http.DateGenerator.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateGenerator initialValue() {
            return new DateGenerator();
        }
    };
    public static final String __01Jan1970 = formatDate(0);
    private final StringBuilder buf = new StringBuilder(32);

    /* renamed from: gc */
    private final GregorianCalendar f3130gc = new GregorianCalendar(__GMT);

    static {
        __GMT.setID("GMT");
    }

    public static String formatDate(long date) {
        return __dateGenerator.get().doFormatDate(date);
    }

    public static void formatCookieDate(StringBuilder buf, long date) {
        __dateGenerator.get().doFormatCookieDate(buf, date);
    }

    public static String formatCookieDate(long date) {
        StringBuilder buf = new StringBuilder(28);
        formatCookieDate(buf, date);
        return buf.toString();
    }

    public String doFormatDate(long date) {
        this.buf.setLength(0);
        this.f3130gc.setTimeInMillis(date);
        int dayOfWeek = this.f3130gc.get(7);
        int dayOfMonth = this.f3130gc.get(5);
        int month = this.f3130gc.get(2);
        int year = this.f3130gc.get(1);
        int century = year / 100;
        int year2 = year % 100;
        int hours = this.f3130gc.get(11);
        int minutes = this.f3130gc.get(12);
        int seconds = this.f3130gc.get(13);
        this.buf.append(DAYS[dayOfWeek]);
        this.buf.append(',');
        this.buf.append(' ');
        StringUtil.append2digits(this.buf, dayOfMonth);
        this.buf.append(' ');
        this.buf.append(MONTHS[month]);
        this.buf.append(' ');
        StringUtil.append2digits(this.buf, century);
        StringUtil.append2digits(this.buf, year2);
        this.buf.append(' ');
        StringUtil.append2digits(this.buf, hours);
        this.buf.append(':');
        StringUtil.append2digits(this.buf, minutes);
        this.buf.append(':');
        StringUtil.append2digits(this.buf, seconds);
        this.buf.append(" GMT");
        return this.buf.toString();
    }

    public void doFormatCookieDate(StringBuilder buf, long date) {
        this.f3130gc.setTimeInMillis(date);
        int dayOfWeek = this.f3130gc.get(7);
        int dayOfMonth = this.f3130gc.get(5);
        int month = this.f3130gc.get(2);
        int year = this.f3130gc.get(1) % 10000;
        int epoch = (int) ((date / 1000) % DateBuilder.SECONDS_IN_MOST_DAYS);
        int seconds = epoch % 60;
        int epoch2 = epoch / 60;
        buf.append(DAYS[dayOfWeek]);
        buf.append(',');
        buf.append(' ');
        StringUtil.append2digits(buf, dayOfMonth);
        buf.append('-');
        buf.append(MONTHS[month]);
        buf.append('-');
        StringUtil.append2digits(buf, year / 100);
        StringUtil.append2digits(buf, year % 100);
        buf.append(' ');
        StringUtil.append2digits(buf, epoch2 / 60);
        buf.append(':');
        StringUtil.append2digits(buf, epoch2 % 60);
        buf.append(':');
        StringUtil.append2digits(buf, seconds);
        buf.append(" GMT");
    }
}
