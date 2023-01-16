package okhttp3.internal.platform.android;

import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import p001ch.qos.logback.core.joran.util.beans.BeanUtil;

/* compiled from: CloseGuard.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"�� \n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n��\n\u0002\u0010\u000b\n\u0002\b\u0003\b��\u0018�� \r2\u00020\u0001:\u0001\rB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u0006\u0010\b\u001a\u00020\tJ\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n��¨\u0006\u000e"}, m373d2 = {"Lokhttp3/internal/platform/android/CloseGuard;", "", "getMethod", "Ljava/lang/reflect/Method;", "openMethod", "warnIfOpenMethod", "(Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;Ljava/lang/reflect/Method;)V", "createAndOpen", "closer", "", "warnIfOpen", "", "closeGuardInstance", "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/internal/platform/android/CloseGuard.class */
public final class CloseGuard {
    @NotNull
    public static final Companion Companion = new Companion(null);
    @Nullable
    private final Method getMethod;
    @Nullable
    private final Method openMethod;
    @Nullable
    private final Method warnIfOpenMethod;

    public CloseGuard(@Nullable Method getMethod, @Nullable Method openMethod, @Nullable Method warnIfOpenMethod) {
        this.getMethod = getMethod;
        this.openMethod = openMethod;
        this.warnIfOpenMethod = warnIfOpenMethod;
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x000d
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    @org.jetbrains.annotations.Nullable
    public final java.lang.Object createAndOpen(@org.jetbrains.annotations.NotNull java.lang.String r7) {
        /*
            r6 = this;
            r0 = r7
            java.lang.String r1 = "closer"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r0, r1)
            r0 = r6
            java.lang.reflect.Method r0 = r0.getMethod
            if (r0 == 0) goto L_0x0035
            r0 = r6
            java.lang.reflect.Method r0 = r0.getMethod     // Catch: Exception -> 0x0034
            r1 = 0
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Exception -> 0x0034
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: Exception -> 0x0034
            r8 = r0
            r0 = r6
            java.lang.reflect.Method r0 = r0.openMethod     // Catch: Exception -> 0x0034
            r1 = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: Exception -> 0x0034
            r1 = r8
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Exception -> 0x0034
            r9 = r2
            r2 = r9
            r3 = 0
            r4 = r7
            r2[r3] = r4     // Catch: Exception -> 0x0034
            r2 = r9
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: Exception -> 0x0034
            r0 = r8
            return r0
        L_0x0034:
            r8 = move-exception
        L_0x0035:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.android.CloseGuard.createAndOpen(java.lang.String):java.lang.Object");
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockSplitter
        jadx.core.utils.exceptions.JadxRuntimeException: Unexpected missing predecessor for block: B:4:0x0006
        	at jadx.core.dex.visitors.blocks.BlockSplitter.addTempConnectionsForExcHandlers(BlockSplitter.java:232)
        	at jadx.core.dex.visitors.blocks.BlockSplitter.visit(BlockSplitter.java:54)
        */
    public final boolean warnIfOpen(@org.jetbrains.annotations.Nullable java.lang.Object r5) {
        /*
            r4 = this;
            r0 = 0
            r6 = r0
            r0 = r5
            if (r0 == 0) goto L_0x001e
            r0 = r4
            java.lang.reflect.Method r0 = r0.warnIfOpenMethod     // Catch: Exception -> 0x001d
            r1 = r0
            kotlin.jvm.internal.Intrinsics.checkNotNull(r1)     // Catch: Exception -> 0x001d
            r1 = r5
            r2 = 0
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Exception -> 0x001d
            java.lang.Object r0 = r0.invoke(r1, r2)     // Catch: Exception -> 0x001d
            r0 = 1
            r6 = r0
            goto L_0x001e
        L_0x001d:
            r7 = move-exception
        L_0x001e:
            r0 = r6
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.platform.android.CloseGuard.warnIfOpen(java.lang.Object):boolean");
    }

    /* compiled from: CloseGuard.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n��\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, m373d2 = {"Lokhttp3/internal/platform/android/CloseGuard$Companion;", "", "()V", BeanUtil.PREFIX_GETTER_GET, "Lokhttp3/internal/platform/android/CloseGuard;", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/internal/platform/android/CloseGuard$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final CloseGuard get() {
            Method warnIfOpenMethod;
            Method openMethod;
            Method getMethod;
            try {
                Class closeGuardClass = Class.forName("dalvik.system.CloseGuard");
                getMethod = closeGuardClass.getMethod(BeanUtil.PREFIX_GETTER_GET, new Class[0]);
                openMethod = closeGuardClass.getMethod("open", String.class);
                warnIfOpenMethod = closeGuardClass.getMethod("warnIfOpen", new Class[0]);
            } catch (Exception e) {
                getMethod = null;
                openMethod = null;
                warnIfOpenMethod = null;
            }
            return new CloseGuard(getMethod, openMethod, warnIfOpenMethod);
        }
    }
}
