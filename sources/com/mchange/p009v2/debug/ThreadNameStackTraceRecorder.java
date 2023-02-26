package com.mchange.p009v2.debug;

import com.mchange.lang.ThrowableUtils;
import emu.grasscutter.net.packet.PacketOpcodes;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import nonapi.p019io.github.classgraph.fastzipfilereader.NestedJarHandler;

/* renamed from: com.mchange.v2.debug.ThreadNameStackTraceRecorder */
/* loaded from: grasscutter.jar:com/mchange/v2/debug/ThreadNameStackTraceRecorder.class */
public class ThreadNameStackTraceRecorder {

    /* renamed from: NL */
    static final String f420NL = System.getProperty("line.separator", "\r\n");
    Set set;
    String dumpHeader;
    String stackTraceHeader;

    public ThreadNameStackTraceRecorder(String str) {
        this(str, "Debug Stack Trace.");
    }

    public ThreadNameStackTraceRecorder(String str, String str2) {
        this.set = new HashSet();
        this.dumpHeader = str;
        this.stackTraceHeader = str2;
    }

    public synchronized Object record() {
        Record record = new Record(this.stackTraceHeader);
        this.set.add(record);
        return record;
    }

    public synchronized void remove(Object obj) {
        this.set.remove(obj);
    }

    public synchronized int size() {
        return this.set.size();
    }

    public synchronized String getDump() {
        return getDump(null);
    }

    public synchronized String getDump(String str) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MMMM-yyyy HH:mm:ss.SSSS");
        StringBuffer stringBuffer = new StringBuffer((int) PacketOpcodes.ActivityScheduleInfoNotify);
        stringBuffer.append(f420NL);
        stringBuffer.append("----------------------------------------------------");
        stringBuffer.append(f420NL);
        stringBuffer.append(this.dumpHeader);
        stringBuffer.append(f420NL);
        if (str != null) {
            stringBuffer.append(str);
            stringBuffer.append(f420NL);
        }
        boolean z = true;
        for (Record record : this.set) {
            if (z) {
                z = false;
            } else {
                stringBuffer.append(NestedJarHandler.TEMP_FILENAME_LEAF_SEPARATOR);
                stringBuffer.append(f420NL);
            }
            stringBuffer.append(simpleDateFormat.format(new Date(record.time)));
            stringBuffer.append(" --> Thread Name: ");
            stringBuffer.append(record.threadName);
            stringBuffer.append(f420NL);
            stringBuffer.append("Stack Trace: ");
            stringBuffer.append(ThrowableUtils.extractStackTrace(record.stackTrace));
        }
        stringBuffer.append("----------------------------------------------------");
        stringBuffer.append(f420NL);
        return stringBuffer.toString();
    }

    /* access modifiers changed from: private */
    /* renamed from: com.mchange.v2.debug.ThreadNameStackTraceRecorder$Record */
    /* loaded from: grasscutter.jar:com/mchange/v2/debug/ThreadNameStackTraceRecorder$Record.class */
    public static final class Record implements Comparable {
        long time = System.currentTimeMillis();
        String threadName = Thread.currentThread().getName();
        Throwable stackTrace;

        Record(String str) {
            this.stackTrace = new Exception(str);
        }

        @Override // java.lang.Comparable
        public int compareTo(Object obj) {
            Record record = (Record) obj;
            if (this.time > record.time) {
                return 1;
            }
            if (this.time < record.time) {
                return -1;
            }
            int identityHashCode = System.identityHashCode(this);
            int identityHashCode2 = System.identityHashCode(record);
            if (identityHashCode > identityHashCode2) {
                return 1;
            }
            if (identityHashCode < identityHashCode2) {
                return -1;
            }
            return 0;
        }
    }
}
