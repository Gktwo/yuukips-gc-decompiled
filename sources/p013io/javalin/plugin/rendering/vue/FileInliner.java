package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.text.Regex;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

/* compiled from: VueHandler.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n��\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\b\u001a\u00020\t*\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0005\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0006\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��R\u000e\u0010\u0007\u001a\u00020\u0004X\u0004¢\u0006\u0002\n��¨\u0006\r²\u0006\u0012\u0010\u000e\u001a\n \u000f*\u0004\u0018\u00010\t0\tX\u0002"}, m373d2 = {"Lio/javalin/plugin/rendering/vue/FileInliner;", "", "()V", "devRegex", "Lkotlin/text/Regex;", "newlineRegex", "notDevRegex", "unconditionalRegex", "inlineFiles", "", "nonVueFiles", "", "Ljava/nio/file/Path;", "javalin", "matchingFileContent", "kotlin.jvm.PlatformType"})
/* renamed from: io.javalin.plugin.rendering.vue.FileInliner */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/FileInliner.class */
public final class FileInliner {
    @NotNull
    public static final FileInliner INSTANCE = new FileInliner();
    @NotNull
    private static final Regex newlineRegex = new Regex("\\r?\\n");
    @NotNull
    private static final Regex unconditionalRegex = new Regex("@inlineFile\\(\".*\"\\)");
    @NotNull
    private static final Regex devRegex = new Regex("@inlineFileDev\\(\".*\"\\)");
    @NotNull
    private static final Regex notDevRegex = new Regex("@inlineFileNotDev\\(\".*\"\\)");

    private FileInliner() {
    }

    @NotNull
    public final String inlineFiles(@NotNull String $this$inlineFiles, @NotNull List<? extends Path> list) {
        Intrinsics.checkNotNullParameter($this$inlineFiles, "<this>");
        Intrinsics.checkNotNullParameter(list, "nonVueFiles");
        List<? extends Path> $this$associateBy$iv = list;
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associateBy$iv, 10)), 16));
        for (Object element$iv$iv : $this$associateBy$iv) {
            destination$iv$iv.put("\"/vue/" + StringsKt.substringAfter$default(StringsKt.replace$default(((Path) element$iv$iv).toString(), "\\", "/", false, 4, (Object) null), "/vue/", (String) null, 2, (Object) null) + '\"', element$iv$iv);
        }
        return CollectionsKt.joinToString$default(newlineRegex.split($this$inlineFiles, 0), "\n", null, null, 0, null, new Function1<String, CharSequence>(destination$iv$iv) { // from class: io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1
            final /* synthetic */ Map<String, Path> $pathMap;

            /* JADX DEBUG: Multi-variable search result rejected for r4v0, resolved type: java.util.Map<java.lang.String, ? extends java.nio.file.Path> */
            /* JADX WARN: Multi-variable type inference failed */
            /* access modifiers changed from: package-private */
            {
                this.$pathMap = r4;
            }

            @NotNull
            public final CharSequence invoke(@NotNull String line) {
                Object obj;
                String str;
                String str2;
                Intrinsics.checkNotNullParameter(line, "line");
                if (!StringsKt.contains$default((CharSequence) line, (CharSequence) "@inlineFile", false, 2, (Object) null)) {
                    return line;
                }
                Iterator<T> it = this.$pathMap.keySet().iterator();
                while (true) {
                    if (!it.hasNext()) {
                        obj = null;
                        break;
                    }
                    Object next = it.next();
                    if (StringsKt.contains$default((CharSequence) line, (CharSequence) ((String) next), false, 2, (Object) null)) {
                        obj = next;
                        break;
                    }
                }
                String matchingKey = (String) obj;
                if (matchingKey == null) {
                    throw new IllegalStateException(Intrinsics.stringPlus("Invalid path found: ", line));
                }
                Lazy matchingFileContent$delegate = LazyKt.lazy(
                /*  JADX ERROR: Method code generation error
                    jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x009a: INVOKE  (r0v22 'matchingFileContent$delegate' kotlin.Lazy) = 
                      (wrap: io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1$matchingFileContent$2 : 0x0094: CONSTRUCTOR  (r0v20 io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1$matchingFileContent$2 A[REMOVE]) = 
                      (wrap: java.util.Map<java.lang.String, java.nio.file.Path> : 0x0090: IGET  (r2v2 java.util.Map<java.lang.String, java.nio.file.Path> A[REMOVE]) = 
                      (r6v0 'this' io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1 A[D('this' io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1), IMMUTABLE_TYPE, THIS])
                     io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1.$pathMap java.util.Map)
                      (r0v17 'matchingKey' java.lang.String A[D('matchingKey' java.lang.String)])
                     call: io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1$matchingFileContent$2.<init>(java.util.Map, java.lang.String):void type: CONSTRUCTOR)
                     type: STATIC call: kotlin.LazyKt.lazy(kotlin.jvm.functions.Function0):kotlin.Lazy in method: io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1.invoke(java.lang.String):java.lang.CharSequence, file: grasscutter.jar:io/javalin/plugin/rendering/vue/FileInliner$inlineFiles$1.class
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
                    	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
                    	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.dex.regions.Region.generate(Region.java:35)
                    	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
                    	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
                    	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
                    	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
                    	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
                    	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
                    	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
                    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
                    	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                    	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
                    Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1$matchingFileContent$2, state: NOT_LOADED
                    	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:259)
                    	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:675)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:393)
                    	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
                    	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
                    	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
                    	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
                    	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
                    	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
                    	... 23 more
                    */
                /*
                // Method dump skipped, instructions count: 363
                */
                throw new UnsupportedOperationException("Method not decompiled: p013io.javalin.plugin.rendering.vue.FileInliner$inlineFiles$1.invoke(java.lang.String):java.lang.CharSequence");
            }

            /* renamed from: invoke$lambda-1  reason: not valid java name */
            private static final String m5894invoke$lambda1(Lazy<String> lazy) {
                return lazy.getValue();
            }
        }, 30, null);
    }
}
