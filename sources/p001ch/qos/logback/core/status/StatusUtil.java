package p001ch.qos.logback.core.status;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import p001ch.qos.logback.core.Context;
import p001ch.qos.logback.core.CoreConstants;

/* renamed from: ch.qos.logback.core.status.StatusUtil */
/* loaded from: grasscutter.jar:ch/qos/logback/core/status/StatusUtil.class */
public class StatusUtil {

    /* renamed from: sm */
    StatusManager f19sm;

    public StatusUtil(StatusManager sm) {
        this.f19sm = sm;
    }

    public StatusUtil(Context context) {
        this.f19sm = context.getStatusManager();
    }

    public static boolean contextHasStatusListener(Context context) {
        List<StatusListener> listeners;
        StatusManager sm = context.getStatusManager();
        if (sm == null || (listeners = sm.getCopyOfStatusListenerList()) == null || listeners.size() == 0) {
            return false;
        }
        return true;
    }

    public static List<Status> filterStatusListByTimeThreshold(List<Status> rawList, long threshold) {
        List<Status> filteredList = new ArrayList<>();
        for (Status s : rawList) {
            if (s.getDate().longValue() >= threshold) {
                filteredList.add(s);
            }
        }
        return filteredList;
    }

    public void addStatus(Status status) {
        if (this.f19sm != null) {
            this.f19sm.add(status);
        }
    }

    public void addInfo(Object caller, String msg) {
        addStatus(new InfoStatus(msg, caller));
    }

    public void addWarn(Object caller, String msg) {
        addStatus(new WarnStatus(msg, caller));
    }

    public void addError(Object caller, String msg, Throwable t) {
        addStatus(new ErrorStatus(msg, caller, t));
    }

    public boolean hasXMLParsingErrors(long threshold) {
        return containsMatch(threshold, 2, CoreConstants.XML_PARSING);
    }

    public boolean noXMLParsingErrorsOccurred(long threshold) {
        return !hasXMLParsingErrors(threshold);
    }

    public int getHighestLevel(long threshold) {
        int maxLevel = 0;
        for (Status s : filterStatusListByTimeThreshold(this.f19sm.getCopyOfStatusList(), threshold)) {
            if (s.getLevel() > maxLevel) {
                maxLevel = s.getLevel();
            }
        }
        return maxLevel;
    }

    public boolean isErrorFree(long threshold) {
        return 2 > getHighestLevel(threshold);
    }

    public boolean isWarningOrErrorFree(long threshold) {
        return 1 > getHighestLevel(threshold);
    }

    public boolean containsMatch(long threshold, int level, String regex) {
        List<Status> filteredList = filterStatusListByTimeThreshold(this.f19sm.getCopyOfStatusList(), threshold);
        Pattern p = Pattern.compile(regex);
        for (Status status : filteredList) {
            if (level == status.getLevel() && p.matcher(status.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public boolean containsMatch(int level, String regex) {
        return containsMatch(0, level, regex);
    }

    public boolean containsMatch(String regex) {
        Pattern p = Pattern.compile(regex);
        for (Status status : this.f19sm.getCopyOfStatusList()) {
            if (p.matcher(status.getMessage()).lookingAt()) {
                return true;
            }
        }
        return false;
    }

    public int matchCount(String regex) {
        int count = 0;
        Pattern p = Pattern.compile(regex);
        for (Status status : this.f19sm.getCopyOfStatusList()) {
            if (p.matcher(status.getMessage()).lookingAt()) {
                count++;
            }
        }
        return count;
    }

    public boolean containsException(Class<?> exceptionType) {
        for (Status status : this.f19sm.getCopyOfStatusList()) {
            for (Throwable t = status.getThrowable(); t != null; t = t.getCause()) {
                if (t.getClass().getName().equals(exceptionType.getName())) {
                    return true;
                }
            }
        }
        return false;
    }

    public long timeOfLastReset() {
        List<Status> statusList = this.f19sm.getCopyOfStatusList();
        if (statusList == null) {
            return -1;
        }
        for (int i = statusList.size() - 1; i >= 0; i--) {
            Status s = statusList.get(i);
            if (CoreConstants.RESET_MSG_PREFIX.equals(s.getMessage())) {
                return s.getDate().longValue();
            }
        }
        return -1;
    }
}
