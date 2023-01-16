package p013io.javalin.core.routing;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import org.jetbrains.annotations.NotNull;

/* compiled from: PathSegment.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\b6\u0018��2\u00020\u0001:\u0004\b\t\n\u000bB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H ¢\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0004H ¢\u0006\u0002\b\u0007\u0001\u0004\f\r\u000e\u000f¨\u0006\u0010"}, m373d2 = {"Lio/javalin/core/routing/PathSegment;", "", "()V", "asGroupedRegexString", "", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "MultipleSegments", "Normal", "Parameter", "Wildcard", "Lio/javalin/core/routing/PathSegment$Normal;", "Lio/javalin/core/routing/PathSegment$Parameter;", "Lio/javalin/core/routing/PathSegment$Wildcard;", "Lio/javalin/core/routing/PathSegment$MultipleSegments;", "javalin"})
/* renamed from: io.javalin.core.routing.PathSegment */
/* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment.class */
public abstract class PathSegment {
    @NotNull
    public abstract String asRegexString$javalin();

    @NotNull
    public abstract String asGroupedRegexString$javalin();

    public /* synthetic */ PathSegment(DefaultConstructorMarker $constructor_marker) {
        this();
    }

    private PathSegment() {
    }

    /* compiled from: PathSegment.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\b6\u0018��2\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Normal;", "Lio/javalin/core/routing/PathSegment;", "content", "", "(Ljava/lang/String;)V", "getContent", "()Ljava/lang/String;", "RegexAllowed", "RegexEscaped", "Lio/javalin/core/routing/PathSegment$Normal$RegexEscaped;", "Lio/javalin/core/routing/PathSegment$Normal$RegexAllowed;", "javalin"})
    /* renamed from: io.javalin.core.routing.PathSegment$Normal */
    /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Normal.class */
    public static abstract class Normal extends PathSegment {
        @NotNull
        private final String content;

        public /* synthetic */ Normal(String content, DefaultConstructorMarker $constructor_marker) {
            this(content);
        }

        private Normal(String content) {
            super(null);
            this.content = content;
        }

        @NotNull
        public final String getContent() {
            return this.content;
        }

        /* compiled from: PathSegment.kt */
        @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\b¨\u0006\t"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Normal$RegexEscaped;", "Lio/javalin/core/routing/PathSegment$Normal;", "content", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
        /* renamed from: io.javalin.core.routing.PathSegment$Normal$RegexEscaped */
        /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Normal$RegexEscaped.class */
        public static final class RegexEscaped extends Normal {
            /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
            public RegexEscaped(@NotNull String content) {
                super(content, null);
                Intrinsics.checkNotNullParameter(content, "content");
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asRegexString$javalin() {
                return Regex.Companion.escape(getContent());
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asGroupedRegexString$javalin() {
                return Regex.Companion.escape(getContent());
            }
        }

        /* compiled from: PathSegment.kt */
        @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\b¨\u0006\t"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Normal$RegexAllowed;", "Lio/javalin/core/routing/PathSegment$Normal;", "content", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
        /* renamed from: io.javalin.core.routing.PathSegment$Normal$RegexAllowed */
        /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Normal$RegexAllowed.class */
        public static final class RegexAllowed extends Normal {
            /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
            public RegexAllowed(@NotNull String content) {
                super(content, null);
                Intrinsics.checkNotNullParameter(content, "content");
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asRegexString$javalin() {
                return getContent();
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asGroupedRegexString$javalin() {
                return getContent();
            }
        }
    }

    /* compiled from: PathSegment.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\b6\u0018��2\u00020\u0001:\u0002\u0007\bB\u000f\b\u0004\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u0005\u0010\u0006\u0001\u0002\t\n¨\u0006\u000b"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Parameter;", "Lio/javalin/core/routing/PathSegment;", "name", "", "(Ljava/lang/String;)V", "getName", "()Ljava/lang/String;", "SlashAcceptingParameter", "SlashIgnoringParameter", "Lio/javalin/core/routing/PathSegment$Parameter$SlashIgnoringParameter;", "Lio/javalin/core/routing/PathSegment$Parameter$SlashAcceptingParameter;", "javalin"})
    /* renamed from: io.javalin.core.routing.PathSegment$Parameter */
    /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Parameter.class */
    public static abstract class Parameter extends PathSegment {
        @NotNull
        private final String name;

        public /* synthetic */ Parameter(String name, DefaultConstructorMarker $constructor_marker) {
            this(name);
        }

        /* compiled from: PathSegment.kt */
        @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\b¨\u0006\t"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Parameter$SlashIgnoringParameter;", "Lio/javalin/core/routing/PathSegment$Parameter;", "name", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
        /* renamed from: io.javalin.core.routing.PathSegment$Parameter$SlashIgnoringParameter */
        /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Parameter$SlashIgnoringParameter.class */
        public static final class SlashIgnoringParameter extends Parameter {
            /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
            public SlashIgnoringParameter(@NotNull String name) {
                super(name, null);
                Intrinsics.checkNotNullParameter(name, "name");
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asRegexString$javalin() {
                return "[^/]+?";
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asGroupedRegexString$javalin() {
                return PathSegmentKt.access$grouped(asRegexString$javalin());
            }
        }

        private Parameter(String name) {
            super(null);
            this.name = name;
        }

        @NotNull
        public final String getName() {
            return this.name;
        }

        /* compiled from: PathSegment.kt */
        @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018��2\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0005\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0003H\u0010¢\u0006\u0002\b\b¨\u0006\t"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Parameter$SlashAcceptingParameter;", "Lio/javalin/core/routing/PathSegment$Parameter;", "name", "", "(Ljava/lang/String;)V", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
        /* renamed from: io.javalin.core.routing.PathSegment$Parameter$SlashAcceptingParameter */
        /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Parameter$SlashAcceptingParameter.class */
        public static final class SlashAcceptingParameter extends Parameter {
            /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
            public SlashAcceptingParameter(@NotNull String name) {
                super(name, null);
                Intrinsics.checkNotNullParameter(name, "name");
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asRegexString$javalin() {
                return ".+?";
            }

            @Override // p013io.javalin.core.routing.PathSegment
            @NotNull
            public String asGroupedRegexString$javalin() {
                return PathSegmentKt.access$grouped(asRegexString$javalin());
            }
        }
    }

    /* compiled from: PathSegment.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\r\u0010\u0003\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u0005J\r\u0010\u0006\u001a\u00020\u0004H\u0010¢\u0006\u0002\b\u0007¨\u0006\b"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$Wildcard;", "Lio/javalin/core/routing/PathSegment;", "()V", "asGroupedRegexString", "", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    /* renamed from: io.javalin.core.routing.PathSegment$Wildcard */
    /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$Wildcard.class */
    public static final class Wildcard extends PathSegment {
        @NotNull
        public static final Wildcard INSTANCE = new Wildcard();

        private Wildcard() {
            super(null);
        }

        @Override // p013io.javalin.core.routing.PathSegment
        @NotNull
        public String asRegexString$javalin() {
            return ".*?";
        }

        @Override // p013io.javalin.core.routing.PathSegment
        @NotNull
        public String asGroupedRegexString$javalin() {
            return asRegexString$javalin();
        }
    }

    /* compiled from: PathSegment.kt */
    @Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\u0018��2\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u000b\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\fJ\r\u0010\r\u001a\u00020\u0006H\u0010¢\u0006\u0002\b\u000eR\u000e\u0010\u0005\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\b\n��\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u000f"}, m373d2 = {"Lio/javalin/core/routing/PathSegment$MultipleSegments;", "Lio/javalin/core/routing/PathSegment;", "segments", "", "(Ljava/util/List;)V", "groupedRegex", "", "innerSegments", "getInnerSegments", "()Ljava/util/List;", "regex", "asGroupedRegexString", "asGroupedRegexString$javalin", "asRegexString", "asRegexString$javalin", "javalin"})
    /* renamed from: io.javalin.core.routing.PathSegment$MultipleSegments */
    /* loaded from: grasscutter.jar:io/javalin/core/routing/PathSegment$MultipleSegments.class */
    public static final class MultipleSegments extends PathSegment {
        @NotNull
        private final List<PathSegment> innerSegments;
        @NotNull
        private final String regex;
        @NotNull
        private final String groupedRegex;

        /* JADX INFO: 'super' call moved to the top of the method (can break code semantics) */
        public MultipleSegments(@NotNull List<? extends PathSegment> $this$filterIsInstance$iv) {
            super(null);
            Intrinsics.checkNotNullParameter($this$filterIsInstance$iv, "segments");
            Collection destination$iv$iv = new ArrayList();
            for (Object element$iv$iv : $this$filterIsInstance$iv) {
                if (element$iv$iv instanceof MultipleSegments) {
                    destination$iv$iv.add(element$iv$iv);
                }
            }
            if (!((List) destination$iv$iv).isEmpty()) {
                throw new IllegalStateException("Found MultipleSegment inside MultipleSegments! This is forbidden");
            }
            Collection destination$iv$iv2 = new ArrayList();
            for (Object element$iv$iv2 : $this$filterIsInstance$iv) {
                if (!(((PathSegment) element$iv$iv2) instanceof MultipleSegments)) {
                    destination$iv$iv2.add(element$iv$iv2);
                }
            }
            this.innerSegments = (List) destination$iv$iv2;
            this.regex = CollectionsKt.joinToString$default(this.innerSegments, "", null, null, 0, null, PathSegment$MultipleSegments$regex$1.INSTANCE, 30, null);
            this.groupedRegex = CollectionsKt.joinToString$default(this.innerSegments, "", null, null, 0, null, PathSegment$MultipleSegments$groupedRegex$1.INSTANCE, 30, null);
        }

        @NotNull
        public final List<PathSegment> getInnerSegments() {
            return this.innerSegments;
        }

        @Override // p013io.javalin.core.routing.PathSegment
        @NotNull
        public String asRegexString$javalin() {
            return this.regex;
        }

        @Override // p013io.javalin.core.routing.PathSegment
        @NotNull
        public String asGroupedRegexString$javalin() {
            return this.groupedRegex;
        }
    }
}
