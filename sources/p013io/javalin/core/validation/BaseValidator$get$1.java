package p013io.javalin.core.validation;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

/* compiled from: BaseValidator.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 3, m369xi = 48, m374d1 = {"��\"\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010��\u0010��\u001a\u00060\u0001j\u0002`\u0002\"\u0004\b��\u0010\u00032\u001e\u0010\u0004\u001a\u001a\u0012\u0004\u0012\u00020\u0006\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\b0\u00070\u0005H\n"}, m373d2 = {"<anonymous>", "Ljava/lang/Exception;", "Lkotlin/Exception;", "T", "it", "", "", "", "Lio/javalin/core/validation/ValidationError;", ""})
/* renamed from: io.javalin.core.validation.BaseValidator$get$1 */
/* loaded from: grasscutter.jar:io/javalin/core/validation/BaseValidator$get$1.class */
final class BaseValidator$get$1 extends Lambda implements Function1<Map<String, ? extends List<? extends ValidationError<Object>>>, Exception> {
    public static final BaseValidator$get$1 INSTANCE = new BaseValidator$get$1();

    BaseValidator$get$1() {
        super(1);
    }

    @NotNull
    public final Exception invoke(@NotNull Map<String, ? extends List<ValidationError<Object>>> map) {
        Intrinsics.checkNotNullParameter(map, "it");
        return new ValidationException(map);
    }

    /* Return type fixed from 'java.lang.Object' to match base method */
    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object] */
    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Exception invoke(Map<String, ? extends List<? extends ValidationError<Object>>> map) {
        return invoke((Map<String, ? extends List<ValidationError<Object>>>) map);
    }
}
