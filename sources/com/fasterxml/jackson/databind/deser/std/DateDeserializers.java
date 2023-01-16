package com.fasterxml.jackson.databind.deser.std;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.BeanProperty;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.annotation.JacksonStdImpl;
import com.fasterxml.jackson.databind.cfg.CoercionAction;
import com.fasterxml.jackson.databind.deser.ContextualDeserializer;
import com.fasterxml.jackson.databind.type.LogicalType;
import com.fasterxml.jackson.databind.util.ClassUtil;
import com.fasterxml.jackson.databind.util.StdDateFormat;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.TimeZone;

/* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers.class */
public class DateDeserializers {
    private static final HashSet<String> _utilClasses = new HashSet<>();

    static {
        _utilClasses.add("java.util.Calendar");
        _utilClasses.add("java.util.GregorianCalendar");
        _utilClasses.add("java.util.Date");
    }

    public static JsonDeserializer<?> find(Class<?> rawType, String clsName) {
        if (!_utilClasses.contains(clsName)) {
            return null;
        }
        if (rawType == Calendar.class) {
            return new CalendarDeserializer();
        }
        if (rawType == Date.class) {
            return DateDeserializer.instance;
        }
        if (rawType == GregorianCalendar.class) {
            return new CalendarDeserializer(GregorianCalendar.class);
        }
        return null;
    }

    public static boolean hasDeserializerFor(Class<?> rawType) {
        return _utilClasses.contains(rawType.getName());
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$DateBasedDeserializer.class */
    protected static abstract class DateBasedDeserializer<T> extends StdScalarDeserializer<T> implements ContextualDeserializer {
        protected final DateFormat _customFormat;
        protected final String _formatString;

        protected abstract DateBasedDeserializer<T> withDateFormat(DateFormat dateFormat, String str);

        protected DateBasedDeserializer(Class<?> clz) {
            super(clz);
            this._customFormat = null;
            this._formatString = null;
        }

        protected DateBasedDeserializer(DateBasedDeserializer<T> base, DateFormat format, String formatStr) {
            super(base._valueClass);
            this._customFormat = format;
            this._formatString = formatStr;
        }

        @Override // com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public LogicalType logicalType() {
            return LogicalType.DateTime;
        }

        @Override // com.fasterxml.jackson.databind.deser.ContextualDeserializer
        public JsonDeserializer<?> createContextual(DeserializationContext ctxt, BeanProperty property) throws JsonMappingException {
            DateFormat df;
            DateFormat df2;
            JsonFormat.Value format = findFormatOverrides(ctxt, property, handledType());
            if (format != null) {
                TimeZone tz = format.getTimeZone();
                Boolean lenient = format.getLenient();
                if (format.hasPattern()) {
                    String pattern = format.getPattern();
                    SimpleDateFormat df3 = new SimpleDateFormat(pattern, format.hasLocale() ? format.getLocale() : ctxt.getLocale());
                    if (tz == null) {
                        tz = ctxt.getTimeZone();
                    }
                    df3.setTimeZone(tz);
                    if (lenient != null) {
                        df3.setLenient(lenient.booleanValue());
                    }
                    return withDateFormat(df3, pattern);
                } else if (tz != null) {
                    DateFormat df4 = ctxt.getConfig().getDateFormat();
                    if (df4.getClass() == StdDateFormat.class) {
                        StdDateFormat std = ((StdDateFormat) df4).withTimeZone(tz).withLocale(format.hasLocale() ? format.getLocale() : ctxt.getLocale());
                        if (lenient != null) {
                            std = std.withLenient(lenient);
                        }
                        df2 = std;
                    } else {
                        df2 = (DateFormat) df4.clone();
                        df2.setTimeZone(tz);
                        if (lenient != null) {
                            df2.setLenient(lenient.booleanValue());
                        }
                    }
                    return withDateFormat(df2, this._formatString);
                } else if (lenient != null) {
                    DateFormat df5 = ctxt.getConfig().getDateFormat();
                    String pattern2 = this._formatString;
                    if (df5.getClass() == StdDateFormat.class) {
                        StdDateFormat std2 = ((StdDateFormat) df5).withLenient(lenient);
                        df = std2;
                        pattern2 = std2.toPattern();
                    } else {
                        df = (DateFormat) df5.clone();
                        df.setLenient(lenient.booleanValue());
                        if (df instanceof SimpleDateFormat) {
                            ((SimpleDateFormat) df).toPattern();
                        }
                    }
                    if (pattern2 == null) {
                        pattern2 = "[unknown]";
                    }
                    return withDateFormat(df, pattern2);
                }
            }
            return this;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:19:0x006b
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        @Override // com.fasterxml.jackson.databind.deser.std.StdDeserializer
        protected java.util.Date _parseDate(com.fasterxml.jackson.core.JsonParser r10, com.fasterxml.jackson.databind.DeserializationContext r11) throws java.io.IOException {
            /*
                r9 = this;
                r0 = r9
                java.text.DateFormat r0 = r0._customFormat
                if (r0 == 0) goto L_0x0092
                r0 = r10
                com.fasterxml.jackson.core.JsonToken r1 = com.fasterxml.jackson.core.JsonToken.VALUE_STRING
                boolean r0 = r0.hasToken(r1)
                if (r0 == 0) goto L_0x0092
                r0 = r10
                java.lang.String r0 = r0.getText()
                java.lang.String r0 = r0.trim()
                r12 = r0
                r0 = r12
                boolean r0 = r0.isEmpty()
                if (r0 == 0) goto L_0x0057
                r0 = r9
                r1 = r11
                r2 = r12
                com.fasterxml.jackson.databind.cfg.CoercionAction r0 = r0._checkFromStringCoercion(r1, r2)
                r13 = r0
                int[] r0 = com.fasterxml.jackson.databind.deser.std.DateDeserializers.C00491.$SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction
                r1 = r13
                int r1 = r1.ordinal()
                r0 = r0[r1]
                switch(r0) {
                    case 1: goto L_0x004c;
                    case 2: goto L_0x0055;
                    case 3: goto L_0x0055;
                    default: goto L_0x0055;
                }
            L_0x004c:
                java.util.Date r0 = new java.util.Date
                r1 = r0
                r2 = 0
                r1.<init>(r2)
                return r0
            L_0x0055:
                r0 = 0
                return r0
            L_0x0057:
                r0 = r9
                java.text.DateFormat r0 = r0._customFormat
                r1 = r0
                r13 = r1
                monitor-enter(r0)
                r0 = r9
                java.text.DateFormat r0 = r0._customFormat     // Catch: ParseException -> 0x006b, all -> 0x008a
                r1 = r12
                java.util.Date r0 = r0.parse(r1)     // Catch: ParseException -> 0x006b, all -> 0x008a
                r1 = r13
                monitor-exit(r1)     // Catch: all -> 0x008a
                return r0
            L_0x006b:
                r14 = move-exception
                r0 = r11
                r1 = r9
                java.lang.Class r1 = r1.handledType()     // Catch: all -> 0x008a
                r2 = r12
                java.lang.String r3 = "expected format \"%s\""
                r4 = 1
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch: all -> 0x008a
                r5 = r4
                r6 = 0
                r7 = r9
                java.lang.String r7 = r7._formatString     // Catch: all -> 0x008a
                r5[r6] = r7     // Catch: all -> 0x008a
                java.lang.Object r0 = r0.handleWeirdStringValue(r1, r2, r3, r4)     // Catch: all -> 0x008a
                java.util.Date r0 = (java.util.Date) r0     // Catch: all -> 0x008a
                r1 = r13
                monitor-exit(r1)     // Catch: all -> 0x008a
                return r0
            L_0x008a:
                r15 = move-exception
                r0 = r13
                monitor-exit(r0)     // Catch: all -> 0x008a
                r0 = r15
                throw r0
            L_0x0092:
                r0 = r9
                r1 = r10
                r2 = r11
                java.util.Date r0 = r0._parseDate(r1, r2)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer._parseDate(com.fasterxml.jackson.core.JsonParser, com.fasterxml.jackson.databind.DeserializationContext):java.util.Date");
        }
    }

    /* renamed from: com.fasterxml.jackson.databind.deser.std.DateDeserializers$1 */
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$1.class */
    static /* synthetic */ class C00491 {
        static final /* synthetic */ int[] $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction = new int[CoercionAction.values().length];

        static {
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsEmpty.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.AsNull.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$com$fasterxml$jackson$databind$cfg$CoercionAction[CoercionAction.TryConvert.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$CalendarDeserializer.class */
    public static class CalendarDeserializer extends DateBasedDeserializer<Calendar> {
        protected final Constructor<Calendar> _defaultCtor;

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.ContextualDeserializer
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
            return createContextual(deserializationContext, beanProperty);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ LogicalType logicalType() {
            return logicalType();
        }

        public CalendarDeserializer() {
            super(Calendar.class);
            this._defaultCtor = null;
        }

        public CalendarDeserializer(Class<? extends Calendar> cc) {
            super(cc);
            this._defaultCtor = ClassUtil.findConstructor(cc, false);
        }

        public CalendarDeserializer(CalendarDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
            this._defaultCtor = src._defaultCtor;
        }

        /* Return type fixed from 'com.fasterxml.jackson.databind.deser.std.DateDeserializers$CalendarDeserializer' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public DateBasedDeserializer<Calendar> withDateFormat(DateFormat df, String formatString) {
            return new CalendarDeserializer(this, df, formatString);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext ctxt) {
            GregorianCalendar cal = new GregorianCalendar();
            cal.setTimeInMillis(0);
            return cal;
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Calendar deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            if (this._defaultCtor == null) {
                return ctxt.constructCalendar(d);
            }
            try {
                Calendar c = this._defaultCtor.newInstance(new Object[0]);
                c.setTimeInMillis(d.getTime());
                TimeZone tz = ctxt.getTimeZone();
                if (tz != null) {
                    c.setTimeZone(tz);
                }
                return c;
            } catch (Exception e) {
                return (Calendar) ctxt.handleInstantiationProblem(handledType(), d, e);
            }
        }
    }

    @JacksonStdImpl
    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$DateDeserializer.class */
    public static class DateDeserializer extends DateBasedDeserializer<Date> {
        public static final DateDeserializer instance = new DateDeserializer();

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.ContextualDeserializer
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
            return createContextual(deserializationContext, beanProperty);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ LogicalType logicalType() {
            return logicalType();
        }

        public DateDeserializer() {
            super(Date.class);
        }

        public DateDeserializer(DateDeserializer base, DateFormat df, String formatString) {
            super(base, df, formatString);
        }

        /* Return type fixed from 'com.fasterxml.jackson.databind.deser.std.DateDeserializers$DateDeserializer' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public DateBasedDeserializer<Date> withDateFormat(DateFormat df, String formatString) {
            return new DateDeserializer(this, df, formatString);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext ctxt) {
            return new Date(0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            return _parseDate(p, ctxt);
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$SqlDateDeserializer.class */
    public static class SqlDateDeserializer extends DateBasedDeserializer<java.sql.Date> {
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.ContextualDeserializer
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
            return createContextual(deserializationContext, beanProperty);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ LogicalType logicalType() {
            return logicalType();
        }

        public SqlDateDeserializer() {
            super(java.sql.Date.class);
        }

        public SqlDateDeserializer(SqlDateDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
        }

        /* Return type fixed from 'com.fasterxml.jackson.databind.deser.std.DateDeserializers$SqlDateDeserializer' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public DateBasedDeserializer<java.sql.Date> withDateFormat(DateFormat df, String formatString) {
            return new SqlDateDeserializer(this, df, formatString);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext ctxt) {
            return new java.sql.Date(0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public java.sql.Date deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            return new java.sql.Date(d.getTime());
        }
    }

    /* loaded from: grasscutter.jar:com/fasterxml/jackson/databind/deser/std/DateDeserializers$TimestampDeserializer.class */
    public static class TimestampDeserializer extends DateBasedDeserializer<Timestamp> {
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.ContextualDeserializer
        public /* bridge */ /* synthetic */ JsonDeserializer createContextual(DeserializationContext deserializationContext, BeanProperty beanProperty) throws JsonMappingException {
            return createContextual(deserializationContext, beanProperty);
        }

        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer, com.fasterxml.jackson.databind.deser.std.StdScalarDeserializer, com.fasterxml.jackson.databind.JsonDeserializer
        public /* bridge */ /* synthetic */ LogicalType logicalType() {
            return logicalType();
        }

        public TimestampDeserializer() {
            super(Timestamp.class);
        }

        public TimestampDeserializer(TimestampDeserializer src, DateFormat df, String formatString) {
            super(src, df, formatString);
        }

        /* Return type fixed from 'com.fasterxml.jackson.databind.deser.std.DateDeserializers$TimestampDeserializer' to match base method */
        /* access modifiers changed from: protected */
        @Override // com.fasterxml.jackson.databind.deser.std.DateDeserializers.DateBasedDeserializer
        public DateBasedDeserializer<Timestamp> withDateFormat(DateFormat df, String formatString) {
            return new TimestampDeserializer(this, df, formatString);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Object getEmptyValue(DeserializationContext ctxt) {
            return new Timestamp(0);
        }

        @Override // com.fasterxml.jackson.databind.JsonDeserializer
        public Timestamp deserialize(JsonParser p, DeserializationContext ctxt) throws IOException {
            Date d = _parseDate(p, ctxt);
            if (d == null) {
                return null;
            }
            return new Timestamp(d.getTime());
        }
    }
}
