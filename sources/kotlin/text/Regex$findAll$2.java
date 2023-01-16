package kotlin.text;

import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jline.builtins.Tmux;

/* compiled from: Regex.kt */
/* access modifiers changed from: package-private */
@Metadata(m371mv = {1, 6, 0}, m372k = 3, m369xi = 48)
/* loaded from: grasscutter.jar:kotlin/text/Regex$findAll$2.class */
public /* synthetic */ class Regex$findAll$2 extends FunctionReferenceImpl implements Function1<MatchResult, MatchResult> {
    public static final Regex$findAll$2 INSTANCE = new Regex$findAll$2();

    Regex$findAll$2() {
        super(1, MatchResult.class, Tmux.CMD_NEXT, "next()Lkotlin/text/MatchResult;", 0);
    }

    @Nullable
    public final MatchResult invoke(@NotNull MatchResult p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return p0.next();
    }
}
