package kotlin.internal;

import kotlin.KotlinVersion;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* compiled from: PlatformImplementations.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 2, m369xi = 48, m374d1 = {"��\u001e\n��\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010��\n\u0002\b\u0004\u001a \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\u0005H\u0001\u001a\"\u0010\b\u001a\u0002H\t\"\n\b��\u0010\t\u0018\u0001*\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\b¢\u0006\u0002\u0010\f\u001a\b\u0010\r\u001a\u00020\u0005H\u0002\"\u0010\u0010��\u001a\u00020\u00018��X\u0004¢\u0006\u0002\n��¨\u0006\u000e"}, m373d2 = {"IMPLEMENTATIONS", "Lkotlin/internal/PlatformImplementations;", "apiVersionIsAtLeast", "", "major", "", "minor", "patch", "castToBaseType", "T", "", "instance", "(Ljava/lang/Object;)Ljava/lang/Object;", "getJavaVersion", "kotlin-stdlib"})
/* loaded from: grasscutter.jar:kotlin/internal/PlatformImplementationsKt.class */
public final class PlatformImplementationsKt {
    @JvmField
    @NotNull
    public static final PlatformImplementations IMPLEMENTATIONS;

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:76:0x0013 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:81:0x0101 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v16, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v27 */
    /* JADX WARN: Type inference failed for: r0v28 */
    /* JADX WARN: Type inference failed for: r0v29 */
    /* JADX WARN: Type inference failed for: r0v30 */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00fd, code lost:
        if (r0 < 65536) goto L_0x0101;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000f, code lost:
        if (r0 < 65536) goto L_0x0013;
     */
    /* JADX WARNING: Unknown variable types count: 1 */
    static {
        /*
        // Method dump skipped, instructions count: 494
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementationsKt.m8276clinit():void");
    }

    @InlineOnly
    private static final /* synthetic */ <T> T castToBaseType(Object instance) {
        try {
            Intrinsics.reifiedOperationMarker(1, "T");
            return (T) instance;
        } catch (ClassCastException e) {
            ClassLoader instanceCL = instance.getClass().getClassLoader();
            Intrinsics.reifiedOperationMarker(4, "T");
            ClassLoader baseTypeCL = Object.class.getClassLoader();
            if (!Intrinsics.areEqual(instanceCL, baseTypeCL)) {
                throw new ClassNotFoundException("Instance class was loaded from a different classloader: " + instanceCL + ", base type classloader: " + baseTypeCL, e);
            }
            throw e;
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:8:0x0023
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    private static final int getJavaVersion() {
        /*
            r0 = 65542(0x10006, float:9.1844E-41)
            r7 = r0
            java.lang.String r0 = "java.specification.version"
            java.lang.String r0 = java.lang.System.getProperty(r0)
            r1 = r0
            if (r1 != 0) goto L_0x000f
            r0 = r7
            return r0
        L_0x000f:
            r8 = r0
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 46
            r2 = 0
            r3 = 0
            r4 = 6
            r5 = 0
            int r0 = kotlin.text.StringsKt.indexOf$default(r0, r1, r2, r3, r4, r5)
            r9 = r0
            r0 = r9
            if (r0 >= 0) goto L_0x0035
            r0 = r8
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: NumberFormatException -> 0x002f
            r1 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0 * r1
            r10 = r0
            goto L_0x0033
        L_0x002f:
            r11 = move-exception
            r0 = r7
            r10 = r0
        L_0x0033:
            r0 = r10
            return r0
        L_0x0035:
            r0 = r8
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            r1 = 46
            r2 = r9
            r3 = 1
            int r2 = r2 + r3
            r3 = 0
            r4 = 4
            r5 = 0
            int r0 = kotlin.text.StringsKt.indexOf$default(r0, r1, r2, r3, r4, r5)
            r10 = r0
            r0 = r10
            if (r0 >= 0) goto L_0x004e
            r0 = r8
            int r0 = r0.length()
            r10 = r0
        L_0x004e:
            r0 = r8
            r12 = r0
            r0 = 0
            r13 = r0
            r0 = r12
            r1 = r13
            r2 = r9
            java.lang.String r0 = r0.substring(r1, r2)
            r1 = r0
            java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r11 = r0
            r0 = r8
            r13 = r0
            r0 = r9
            r1 = 1
            int r0 = r0 + r1
            r14 = r0
            r0 = r13
            r1 = r14
            r2 = r10
            java.lang.String r0 = r0.substring(r1, r2)
            r1 = r0
            java.lang.String r2 = "this as java.lang.String…ing(startIndex, endIndex)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r2)
            r12 = r0
            r0 = r11
            int r0 = java.lang.Integer.parseInt(r0)     // Catch: NumberFormatException -> 0x0090
            r1 = 65536(0x10000, float:9.18355E-41)
            int r0 = r0 * r1
            r1 = r12
            int r1 = java.lang.Integer.parseInt(r1)     // Catch: NumberFormatException -> 0x0090
            int r0 = r0 + r1
            r13 = r0
            goto L_0x0095
        L_0x0090:
            r14 = move-exception
            r0 = r7
            r13 = r0
        L_0x0095:
            r0 = r13
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.internal.PlatformImplementationsKt.getJavaVersion():int");
    }

    @SinceKotlin(version = "1.2")
    @PublishedApi
    public static final boolean apiVersionIsAtLeast(int major, int minor, int patch) {
        return KotlinVersion.CURRENT.isAtLeast(major, minor, patch);
    }
}
