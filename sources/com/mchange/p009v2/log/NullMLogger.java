package com.mchange.p009v2.log;

import java.util.ResourceBundle;

/* renamed from: com.mchange.v2.log.NullMLogger */
/* loaded from: grasscutter.jar:com/mchange/v2/log/NullMLogger.class */
public class NullMLogger implements MLogger {
    private static final MLogger INSTANCE = new NullMLogger();
    private static final String NAME = "NullMLogger";

    public static MLogger instance() {
        return INSTANCE;
    }

    private NullMLogger() {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void addHandler(Object obj) throws SecurityException {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void config(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void entering(String str, String str2) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void entering(String str, String str2, Object obj) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void entering(String str, String str2, Object[] objArr) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void exiting(String str, String str2) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void exiting(String str, String str2, Object obj) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void fine(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void finer(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void finest(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public Object getFilter() {
        return null;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public Object[] getHandlers() {
        return null;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public MLevel getLevel() {
        return MLevel.OFF;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public String getName() {
        return NAME;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public ResourceBundle getResourceBundle() {
        return null;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public String getResourceBundleName() {
        return null;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public boolean getUseParentHandlers() {
        return false;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void info(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public boolean isLoggable(MLevel mLevel) {
        return false;
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void log(MLevel mLevel, String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void log(MLevel mLevel, String str, Object obj) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void log(MLevel mLevel, String str, Object[] objArr) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void log(MLevel mLevel, String str, Throwable th) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logp(MLevel mLevel, String str, String str2, String str3) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logp(MLevel mLevel, String str, String str2, String str3, Object obj) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logp(MLevel mLevel, String str, String str2, String str3, Object[] objArr) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logp(MLevel mLevel, String str, String str2, String str3, Throwable th) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logrb(MLevel mLevel, String str, String str2, String str3, String str4) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object obj) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Object[] objArr) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void logrb(MLevel mLevel, String str, String str2, String str3, String str4, Throwable th) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void removeHandler(Object obj) throws SecurityException {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void setFilter(Object obj) throws SecurityException {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void setLevel(MLevel mLevel) throws SecurityException {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void setUseParentHandlers(boolean z) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void severe(String str) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void throwing(String str, String str2, Throwable th) {
    }

    @Override // com.mchange.p009v2.log.MLogger
    public void warning(String str) {
    }
}
