package p013io.javalin.plugin.rendering.template;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;
import org.jetbrains.annotations.NotNull;
import org.quartz.jobs.p027ee.ejb.EJBInvokerJob;

/* compiled from: TemplateUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001e\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n��\n\u0002\u0010\u0011\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J3\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u00042\u0016\u0010\u0006\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u0007\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, m373d2 = {"Lio/javalin/plugin/rendering/template/TemplateUtil;", "", "()V", "model", "", "", EJBInvokerJob.EJB_ARGS_KEY, "", "([Ljava/lang/Object;)Ljava/util/Map;", "javalin"})
/* renamed from: io.javalin.plugin.rendering.template.TemplateUtil */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/template/TemplateUtil.class */
public final class TemplateUtil {
    @NotNull
    public static final TemplateUtil INSTANCE = new TemplateUtil();

    private TemplateUtil() {
    }

    @JvmStatic
    @NotNull
    public static final Map<String, Object> model(@NotNull Object... args) {
        Intrinsics.checkNotNullParameter(args, EJBInvokerJob.EJB_ARGS_KEY);
        if (args.length % 2 != 0) {
            throw new IllegalArgumentException("Number of arguments must be even (key value pairs).");
        }
        Sequence<List> $this$associate$iv = SequencesKt.chunked(ArraysKt.asSequence(args), 2);
        Map destination$iv$iv = new LinkedHashMap();
        for (List it : $this$associate$iv) {
            Object obj = it.get(0);
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            Pair pair = Tuples.m366to((String) obj, it.get(1));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }
}
