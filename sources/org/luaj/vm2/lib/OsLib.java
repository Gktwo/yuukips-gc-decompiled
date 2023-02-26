package org.luaj.vm2.lib;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import org.jline.console.Printer;
import org.luaj.vm2.Buffer;
import org.luaj.vm2.Globals;
import org.luaj.vm2.LuaTable;
import org.luaj.vm2.LuaValue;
import org.luaj.vm2.Varargs;
import org.slf4j.Marker;
import p001ch.qos.logback.core.CoreConstants;

/* loaded from: grasscutter.jar:org/luaj/vm2/lib/OsLib.class */
public class OsLib extends TwoArgFunction {
    private static final int CLOCK = 0;
    private static final int DATE = 1;
    private static final int DIFFTIME = 2;
    private static final int EXECUTE = 3;
    private static final int EXIT = 4;
    private static final int GETENV = 5;
    private static final int REMOVE = 6;
    private static final int RENAME = 7;
    private static final int SETLOCALE = 8;
    private static final int TIME = 9;
    private static final int TMPNAME = 10;
    protected Globals globals;
    static Class class$org$luaj$vm2$lib$OsLib;
    public static String TMP_PREFIX = ".luaj";
    public static String TMP_SUFFIX = "tmp";
    private static final String[] NAMES = {"clock", "date", "difftime", "execute", "exit", "getenv", "remove", "rename", "setlocale", "time", "tmpname"};

    /* renamed from: t0 */
    private static final long f3303t0 = System.currentTimeMillis();
    private static long tmpnames = f3303t0;
    private static final String[] WeekdayNameAbbrev = {"Sun", "Mon", "Tue", "Wed", "Thu", "Fri", "Sat"};
    private static final String[] WeekdayName = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
    private static final String[] MonthNameAbbrev = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
    private static final String[] MonthName = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    /* loaded from: grasscutter.jar:org/luaj/vm2/lib/OsLib$OsLibFunc.class */
    class OsLibFunc extends VarArgFunction {
        private final OsLib this$0;

        public OsLibFunc(OsLib osLib, int i, String str) {
            this.this$0 = osLib;
            this.opcode = i;
            this.name = str;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r2v17 */
        /* JADX WARN: Type inference failed for: r2v53 */
        @Override // org.luaj.vm2.lib.VarArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
        public Varargs invoke(Varargs varargs) {
            try {
                switch (this.opcode) {
                    case 0:
                        return valueOf(this.this$0.clock());
                    case 1:
                        String optjstring = varargs.optjstring(1, "%c");
                        double time = varargs.isnumber(2) ? varargs.todouble(2) : this.this$0.time(null);
                        if (optjstring.equals("*t")) {
                            Calendar instance = Calendar.getInstance();
                            instance.setTime(new Date((long) ((time == Double.MIN_VALUE ? 1.0d : 0.0d) * 1000.0d)));
                            LuaTable tableOf = LuaValue.tableOf();
                            tableOf.set("year", LuaValue.valueOf(instance.get(1)));
                            tableOf.set("month", LuaValue.valueOf(instance.get(2) + 1));
                            tableOf.set("day", LuaValue.valueOf(instance.get(5)));
                            tableOf.set("hour", LuaValue.valueOf(instance.get(11)));
                            tableOf.set("min", LuaValue.valueOf(instance.get(12)));
                            tableOf.set("sec", LuaValue.valueOf(instance.get(13)));
                            tableOf.set("wday", LuaValue.valueOf(instance.get(7)));
                            tableOf.set("yday", LuaValue.valueOf(instance.get(6)));
                            tableOf.set("isdst", LuaValue.valueOf(OsLib.access$000(this.this$0, instance)));
                            return tableOf;
                        }
                        return valueOf(this.this$0.date(optjstring, ((time > -1.0d ? 1 : (time == -1.0d ? 0 : -1)) == 0 ? this.this$0.time(null) : time == Double.MIN_VALUE ? 1 : 0) == true ? 1.0d : 0.0d));
                    case 2:
                        return valueOf(this.this$0.difftime(varargs.checkdouble(1), varargs.checkdouble(2)));
                    case 3:
                        return this.this$0.execute(varargs.optjstring(1, null));
                    case 4:
                        this.this$0.exit(varargs.optint(1, 0));
                        return NONE;
                    case 5:
                        String str = this.this$0.getenv(varargs.checkjstring(1));
                        return str != null ? valueOf(str) : NIL;
                    case 6:
                        this.this$0.remove(varargs.checkjstring(1));
                        return LuaValue.TRUE;
                    case 7:
                        this.this$0.rename(varargs.checkjstring(1), varargs.checkjstring(2));
                        return LuaValue.TRUE;
                    case 8:
                        String str2 = this.this$0.setlocale(varargs.optjstring(1, null), varargs.optjstring(2, Printer.ALL));
                        return str2 != null ? valueOf(str2) : NIL;
                    case 9:
                        return valueOf(this.this$0.time(varargs.opttable(1, null)));
                    case 10:
                        return valueOf(this.this$0.tmpname());
                    default:
                        return NONE;
                }
            } catch (IOException e) {
                return varargsOf(NIL, valueOf(e.getMessage()));
            }
        }
    }

    @Override // org.luaj.vm2.lib.TwoArgFunction, org.luaj.vm2.lib.LibFunction, org.luaj.vm2.LuaValue
    public LuaValue call(LuaValue luaValue, LuaValue luaValue2) {
        this.globals = luaValue2.checkglobals();
        LuaTable luaTable = new LuaTable();
        for (int i = 0; i < NAMES.length; i++) {
            luaTable.set(NAMES[i], new OsLibFunc(this, i, NAMES[i]));
        }
        luaValue2.set("os", luaTable);
        luaValue2.get("package").get("loaded").set("os", luaTable);
        return luaTable;
    }

    protected double clock() {
        return ((double) (System.currentTimeMillis() - f3303t0)) / 1000.0d;
    }

    protected double difftime(double d, double d2) {
        return d - d2;
    }

    public String date(String str, double d) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(new Date((long) (d * 1000.0d)));
        if (str.startsWith("!")) {
            d -= (double) timeZoneOffset(instance);
            instance.setTime(new Date((long) (d * 1000.0d)));
            str = str.substring(1);
        }
        byte[] bytes = str.getBytes();
        int length = bytes.length;
        Buffer buffer = new Buffer(length);
        int i = 0;
        while (i < length) {
            i++;
            byte b = bytes[i];
            switch (b) {
                case 10:
                    buffer.append("\n");
                    break;
                case 37:
                    if (i >= length) {
                        break;
                    } else {
                        i++;
                        byte b2 = bytes[i];
                        switch (b2) {
                            case 37:
                                buffer.append((byte) 37);
                                continue;
                            case 38:
                            case 39:
                            case 40:
                            case 41:
                            case 42:
                            case 43:
                            case 44:
                            case 45:
                            case 46:
                            case 47:
                            case 48:
                            case 49:
                            case 50:
                            case 51:
                            case 52:
                            case 53:
                            case 54:
                            case 55:
                            case 56:
                            case 57:
                            case 58:
                            case 59:
                            case 60:
                            case 61:
                            case 62:
                            case 63:
                            case 64:
                            case 67:
                            case 68:
                            case 69:
                            case 70:
                            case 71:
                            case 74:
                            case 75:
                            case 76:
                            case 78:
                            case 79:
                            case 80:
                            case 81:
                            case 82:
                            case 84:
                            case 86:
                            case 90:
                            case 91:
                            case 92:
                            case 93:
                            case 94:
                            case 95:
                            case 96:
                            case 101:
                            case 102:
                            case 103:
                            case 104:
                            case 105:
                            case 107:
                            case 108:
                            case 110:
                            case 111:
                            case 113:
                            case 114:
                            case 115:
                            case 116:
                            case 117:
                            case 118:
                            default:
                                LuaValue.argerror(1, new StringBuffer().append("invalid conversion specifier '%").append((int) b2).append("'").toString());
                                continue;
                            case 65:
                                buffer.append(WeekdayName[instance.get(7) - 1]);
                                continue;
                            case 66:
                                buffer.append(MonthName[instance.get(2)]);
                                continue;
                            case 72:
                                buffer.append(String.valueOf(100 + instance.get(11)).substring(1));
                                continue;
                            case 73:
                                buffer.append(String.valueOf(100 + (instance.get(11) % 12)).substring(1));
                                continue;
                            case 77:
                                buffer.append(String.valueOf(100 + instance.get(12)).substring(1));
                                continue;
                            case 83:
                                buffer.append(String.valueOf(100 + instance.get(13)).substring(1));
                                continue;
                            case 85:
                                buffer.append(String.valueOf(weekNumber(instance, 0)));
                                continue;
                            case 87:
                                buffer.append(String.valueOf(weekNumber(instance, 1)));
                                continue;
                            case 88:
                                buffer.append(date("%H:%M:%S", d));
                                continue;
                            case 89:
                                buffer.append(String.valueOf(instance.get(1)));
                                continue;
                            case 97:
                                buffer.append(WeekdayNameAbbrev[instance.get(7) - 1]);
                                continue;
                            case 98:
                                buffer.append(MonthNameAbbrev[instance.get(2)]);
                                continue;
                            case 99:
                                buffer.append(date("%a %b %d %H:%M:%S %Y", d));
                                continue;
                            case 100:
                                buffer.append(String.valueOf(100 + instance.get(5)).substring(1));
                                continue;
                            case 106:
                                buffer.append(String.valueOf(1001 + ((int) ((instance.getTime().getTime() - beginningOfYear(instance).getTime().getTime()) / 86400000))).substring(1));
                                continue;
                            case 109:
                                buffer.append(String.valueOf(101 + instance.get(2)).substring(1));
                                continue;
                            case 112:
                                buffer.append(instance.get(11) < 12 ? "AM" : "PM");
                                continue;
                            case 119:
                                buffer.append(String.valueOf((instance.get(7) + 6) % 7));
                                continue;
                            case 120:
                                buffer.append(date("%m/%d/%y", d));
                                continue;
                            case 121:
                                buffer.append(String.valueOf(instance.get(1)).substring(2));
                                continue;
                            case 122:
                                int timeZoneOffset = timeZoneOffset(instance) / 60;
                                int abs = Math.abs(timeZoneOffset);
                                buffer.append(new StringBuffer().append(timeZoneOffset >= 0 ? Marker.ANY_NON_NULL_MARKER : "-").append(String.valueOf(100 + (abs / 60)).substring(1)).append(String.valueOf(100 + (abs % 60)).substring(1)).toString());
                                continue;
                        }
                    }
                default:
                    buffer.append(b);
                    break;
            }
        }
        return buffer.tojstring();
    }

    private Calendar beginningOfYear(Calendar calendar) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(calendar.getTime());
        instance.set(2, 0);
        instance.set(5, 1);
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        return instance;
    }

    private int weekNumber(Calendar calendar, int i) {
        Calendar beginningOfYear = beginningOfYear(calendar);
        beginningOfYear.set(5, 1 + (((i + 8) - beginningOfYear.get(7)) % 7));
        if (beginningOfYear.after(calendar)) {
            beginningOfYear.set(1, beginningOfYear.get(1) - 1);
            beginningOfYear.set(5, 1 + (((i + 8) - beginningOfYear.get(7)) % 7));
        }
        return 1 + ((int) ((calendar.getTime().getTime() - beginningOfYear.getTime().getTime()) / CoreConstants.MILLIS_IN_ONE_WEEK));
    }

    private int timeZoneOffset(Calendar calendar) {
        return calendar.getTimeZone().getOffset(1, calendar.get(1), calendar.get(2), calendar.get(5), calendar.get(7), (((calendar.get(11) * 3600) + (calendar.get(12) * 60)) + calendar.get(13)) * 1000) / 1000;
    }

    private boolean isDaylightSavingsTime(Calendar calendar) {
        return timeZoneOffset(calendar) != calendar.getTimeZone().getRawOffset() / 1000;
    }

    protected Varargs execute(String str) {
        return varargsOf(NIL, valueOf("exit"), ONE);
    }

    protected void exit(int i) {
        System.exit(i);
    }

    protected String getenv(String str) {
        return System.getProperty(str);
    }

    protected void remove(String str) throws IOException {
        throw new IOException("not implemented");
    }

    protected void rename(String str, String str2) throws IOException {
        throw new IOException("not implemented");
    }

    protected String setlocale(String str, String str2) {
        return "C";
    }

    protected double time(LuaTable luaTable) {
        Date date;
        if (luaTable == null) {
            date = new Date();
        } else {
            Calendar instance = Calendar.getInstance();
            instance.set(1, luaTable.get("year").checkint());
            instance.set(2, luaTable.get("month").checkint() - 1);
            instance.set(5, luaTable.get("day").checkint());
            instance.set(11, luaTable.get("hour").optint(12));
            instance.set(12, luaTable.get("min").optint(0));
            instance.set(13, luaTable.get("sec").optint(0));
            instance.set(14, 0);
            date = instance.getTime();
        }
        return ((double) date.getTime()) / 1000.0d;
    }

    /* access modifiers changed from: protected */
    public String tmpname() {
        Class cls;
        String stringBuffer;
        if (class$org$luaj$vm2$lib$OsLib == null) {
            cls = class$("org.luaj.vm2.lib.OsLib");
            class$org$luaj$vm2$lib$OsLib = cls;
        } else {
            cls = class$org$luaj$vm2$lib$OsLib;
        }
        synchronized (cls) {
            StringBuffer append = new StringBuffer().append(TMP_PREFIX);
            long j = tmpnames;
            tmpnames = j + 1;
            stringBuffer = append.append(j).append(TMP_SUFFIX).toString();
        }
        return stringBuffer;
    }

    static boolean access$000(OsLib osLib, Calendar calendar) {
        return osLib.isDaylightSavingsTime(calendar);
    }

    static Class class$(String str) {
        try {
            return Class.forName(str);
        } catch (ClassNotFoundException e) {
            throw new NoClassDefFoundError(e.getMessage());
        }
    }
}
