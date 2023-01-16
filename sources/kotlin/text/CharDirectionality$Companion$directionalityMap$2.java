package kotlin.text;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.ranges.RangesKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: CharDirectionality.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48, m374d1 = {"��\u0010\n��\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\u0018\u0002\n��\u0010��\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001H\n¢\u0006\u0002\b\u0004"}, m373d2 = {"<anonymous>", "", "", "Lkotlin/text/CharDirectionality;", "invoke"})
/* loaded from: grasscutter.jar:kotlin/text/CharDirectionality$Companion$directionalityMap$2.class */
final class CharDirectionality$Companion$directionalityMap$2 extends Lambda implements Function0<Map<Integer, ? extends CharDirectionality>> {
    public static final CharDirectionality$Companion$directionalityMap$2 INSTANCE = new CharDirectionality$Companion$directionalityMap$2();

    CharDirectionality$Companion$directionalityMap$2() {
        super(0);
    }

    /* Return type fixed from 'java.util.Map<java.lang.Integer, kotlin.text.CharDirectionality>' to match base method */
    @Override // kotlin.jvm.functions.Function0
    @NotNull
    public final Map<Integer, ? extends CharDirectionality> invoke() {
        CharDirectionality[] values = CharDirectionality.values();
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(values.length), 16));
        for (CharDirectionality charDirectionality : values) {
            destination$iv$iv.put(Integer.valueOf(charDirectionality.getValue()), charDirectionality);
        }
        return destination$iv$iv;
    }
}
