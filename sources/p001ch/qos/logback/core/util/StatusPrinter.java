package p001ch.qos.logback.core.util;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.List;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;
import p001ch.qos.logback.core.helpers.ThrowableToStringArray;
import p001ch.qos.logback.core.status.Status;
import p001ch.qos.logback.core.status.StatusManager;
import p001ch.qos.logback.core.status.StatusUtil;

/* renamed from: ch.qos.logback.core.util.StatusPrinter */
/* loaded from: grasscutter.jar:ch/qos/logback/core/util/StatusPrinter.class */
public class StatusPrinter {

    /* renamed from: ps */
    private static PrintStream f21ps = System.out;
    static CachingDateFormatter cachingDateFormat = new CachingDateFormatter("HH:mm:ss,SSS");

    public static void setPrintStream(PrintStream printStream) {
        f21ps = printStream;
    }

    public static void printInCaseOfErrorsOrWarnings(Context context) {
        printInCaseOfErrorsOrWarnings(context, 0);
    }

    public static void printInCaseOfErrorsOrWarnings(Context context, long threshold) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager sm = context.getStatusManager();
        if (sm == null) {
            f21ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else if (new StatusUtil(context).getHighestLevel(threshold) >= 1) {
            print(sm, threshold);
        }
    }

    public static void printIfErrorsOccured(Context context) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager sm = context.getStatusManager();
        if (sm == null) {
            f21ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else if (new StatusUtil(context).getHighestLevel(0) == 2) {
            print(sm);
        }
    }

    public static void print(Context context) {
        print(context, 0);
    }

    public static void print(Context context, long threshold) {
        if (context == null) {
            throw new IllegalArgumentException("Context argument cannot be null");
        }
        StatusManager sm = context.getStatusManager();
        if (sm == null) {
            f21ps.println("WARN: Context named \"" + context.getName() + "\" has no status manager");
        } else {
            print(sm, threshold);
        }
    }

    public static void print(StatusManager sm) {
        print(sm, 0);
    }

    public static void print(StatusManager sm, long threshold) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, StatusUtil.filterStatusListByTimeThreshold(sm.getCopyOfStatusList(), threshold));
        f21ps.println(sb.toString());
    }

    public static void print(List<Status> statusList) {
        StringBuilder sb = new StringBuilder();
        buildStrFromStatusList(sb, statusList);
        f21ps.println(sb.toString());
    }

    private static void buildStrFromStatusList(StringBuilder sb, List<Status> statusList) {
        if (statusList != null) {
            for (Status s : statusList) {
                buildStr(sb, "", s);
            }
        }
    }

    private static void appendThrowable(StringBuilder sb, Throwable t) {
        String[] stringRep = ThrowableToStringArray.convert(t);
        for (String s : stringRep) {
            if (!s.startsWith(CoreConstants.CAUSED_BY)) {
                if (Character.isDigit(s.charAt(0))) {
                    sb.append("\t... ");
                } else {
                    sb.append("\tat ");
                }
            }
            sb.append(s).append(CoreConstants.LINE_SEPARATOR);
        }
    }

    public static void buildStr(StringBuilder sb, String indentation, Status s) {
        String prefix;
        if (s.hasChildren()) {
            prefix = indentation + "+ ";
        } else {
            prefix = indentation + "|-";
        }
        if (cachingDateFormat != null) {
            sb.append(cachingDateFormat.format(s.getDate().longValue())).append(" ");
        }
        sb.append(prefix).append(s).append(CoreConstants.LINE_SEPARATOR);
        if (s.getThrowable() != null) {
            appendThrowable(sb, s.getThrowable());
        }
        if (s.hasChildren()) {
            Iterator<Status> ite = s.iterator();
            while (ite.hasNext()) {
                buildStr(sb, indentation + "  ", ite.next());
            }
        }
    }
}
