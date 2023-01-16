package org.eclipse.jetty.http;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;

/* loaded from: grasscutter.jar:org/eclipse/jetty/http/DateParser.class */
public class DateParser {
    private static final TimeZone __GMT = TimeZone.getTimeZone("GMT");
    static final String[] __dateReceiveFmt = {"EEE, dd MMM yyyy HH:mm:ss zzz", "EEE, dd-MMM-yy HH:mm:ss", "EEE MMM dd HH:mm:ss yyyy", "EEE, dd MMM yyyy HH:mm:ss", "EEE dd MMM yyyy HH:mm:ss zzz", "EEE dd MMM yyyy HH:mm:ss", "EEE MMM dd yyyy HH:mm:ss zzz", "EEE MMM dd yyyy HH:mm:ss", "EEE MMM-dd-yyyy HH:mm:ss zzz", "EEE MMM-dd-yyyy HH:mm:ss", "dd MMM yyyy HH:mm:ss zzz", "dd MMM yyyy HH:mm:ss", "dd-MMM-yy HH:mm:ss zzz", "dd-MMM-yy HH:mm:ss", "MMM dd HH:mm:ss yyyy zzz", "MMM dd HH:mm:ss yyyy", "EEE MMM dd HH:mm:ss yyyy zzz", "EEE, MMM dd HH:mm:ss yyyy zzz", "EEE, MMM dd HH:mm:ss yyyy", "EEE, dd-MMM-yy HH:mm:ss zzz", "EEE dd-MMM-yy HH:mm:ss zzz", "EEE dd-MMM-yy HH:mm:ss"};
    private static final ThreadLocal<DateParser> __dateParser = new ThreadLocal<DateParser>() { // from class: org.eclipse.jetty.http.DateParser.1
        /* access modifiers changed from: protected */
        @Override // java.lang.ThreadLocal
        public DateParser initialValue() {
            return new DateParser();
        }
    };
    final SimpleDateFormat[] _dateReceive = new SimpleDateFormat[__dateReceiveFmt.length];

    static {
        __GMT.setID("GMT");
    }

    public static long parseDate(String date) {
        return __dateParser.get().parse(date);
    }

    private long parse(String dateVal) {
        for (int i = 0; i < this._dateReceive.length; i++) {
            if (this._dateReceive[i] == null) {
                this._dateReceive[i] = new SimpleDateFormat(__dateReceiveFmt[i], Locale.US);
                this._dateReceive[i].setTimeZone(__GMT);
            }
            try {
                return ((Date) this._dateReceive[i].parseObject(dateVal)).getTime();
            } catch (Exception e) {
            }
        }
        if (!dateVal.endsWith(" GMT")) {
            return -1;
        }
        String val = dateVal.substring(0, dateVal.length() - 4);
        for (SimpleDateFormat element : this._dateReceive) {
            try {
                return ((Date) element.parseObject(val)).getTime();
            } catch (Exception e2) {
            }
        }
        return -1;
    }
}
