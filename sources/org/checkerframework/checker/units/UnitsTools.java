package org.checkerframework.checker.units;

import emu.grasscutter.net.packet.PacketOpcodes;

/* loaded from: grasscutter.jar:org/checkerframework/checker/units/UnitsTools.class */
public class UnitsTools {
    public static final int mPERs2 = 1;
    public static final double rad = 1.0d;
    public static final double deg = 1.0d;
    public static final int mm2 = 1;

    /* renamed from: m2 */
    public static final int f3079m2 = 1;
    public static final int km2 = 1;

    /* renamed from: A */
    public static final int f3080A = 1;

    /* renamed from: cd */
    public static final int f3081cd = 1;

    /* renamed from: mm */
    public static final int f3082mm = 1;

    /* renamed from: m */
    public static final int f3083m = 1;

    /* renamed from: km */
    public static final int f3084km = 1;

    /* renamed from: g */
    public static final int f3085g = 1;

    /* renamed from: kg */
    public static final int f3086kg = 1;
    public static final int mPERs = 1;
    public static final int kmPERh = 1;
    public static final int mol = 1;

    /* renamed from: K */
    public static final int f3087K = 1;

    /* renamed from: C */
    public static final int f3088C = 1;

    /* renamed from: s */
    public static final int f3089s = 1;
    public static final int min = 1;

    /* renamed from: h */
    public static final int f3090h = 1;

    public static double toRadians(double angdeg) {
        return Math.toRadians(angdeg);
    }

    public static double toDegrees(double angrad) {
        return Math.toDegrees(angrad);
    }

    public static int fromMilliMeterToMeter(int mm) {
        return mm / 1000;
    }

    public static int fromMeterToMilliMeter(int m) {
        return m * 1000;
    }

    public static int fromMeterToKiloMeter(int m) {
        return m / 1000;
    }

    public static int fromKiloMeterToMeter(int km) {
        return km * 1000;
    }

    public static int fromGramToKiloGram(int g) {
        return g / 1000;
    }

    public static int fromKiloGramToGram(int kg) {
        return kg * 1000;
    }

    public static double fromMeterPerSecondToKiloMeterPerHour(double mps) {
        return mps * 3.6d;
    }

    public static double fromKiloMeterPerHourToMeterPerSecond(double kmph) {
        return kmph / 3.6d;
    }

    public static int fromKelvinToCelsius(int k) {
        return k - PacketOpcodes.SceneCreateEntityRsp;
    }

    public static int fromCelsiusToKelvin(int c) {
        return c + PacketOpcodes.SceneCreateEntityRsp;
    }

    public static int fromSecondToMinute(int s) {
        return s / 60;
    }

    public static int fromMinuteToSecond(int min2) {
        return min2 * 60;
    }

    public static int fromMinuteToHour(int min2) {
        return min2 / 60;
    }

    public static int fromHourToMinute(int h) {
        return h * 60;
    }
}
