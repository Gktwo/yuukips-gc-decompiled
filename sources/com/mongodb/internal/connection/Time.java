package com.mongodb.internal.connection;

/* loaded from: grasscutter.jar:com/mongodb/internal/connection/Time.class */
public final class Time {
    static final long CONSTANT_TIME = 42;
    private static boolean isConstant;

    public static void makeTimeConstant() {
        isConstant = true;
    }

    public static void makeTimeMove() {
        isConstant = false;
    }

    public static long nanoTime() {
        return isConstant ? CONSTANT_TIME : System.nanoTime();
    }

    private Time() {
    }
}
