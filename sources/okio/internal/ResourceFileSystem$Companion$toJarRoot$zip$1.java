package okio.internal;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: ResourceFileSystem.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\f\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\u0010��\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n"}, m373d2 = {"<anonymous>", "", "entry", "Lokio/internal/ZipEntry;"})
/* loaded from: grasscutter.jar:okio/internal/ResourceFileSystem$Companion$toJarRoot$zip$1.class */
public final class ResourceFileSystem$Companion$toJarRoot$zip$1 extends Lambda implements Function1<ZipEntry, Boolean> {
    public static final ResourceFileSystem$Companion$toJarRoot$zip$1 INSTANCE = new ResourceFileSystem$Companion$toJarRoot$zip$1();

    ResourceFileSystem$Companion$toJarRoot$zip$1() {
        super(1);
    }

    @NotNull
    public final Boolean invoke(@NotNull ZipEntry entry) {
        Intrinsics.checkNotNullParameter(entry, "entry");
        return Boolean.valueOf(ResourceFileSystem.Companion.keepPath(entry.getCanonicalPath()));
    }
}
