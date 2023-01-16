package p013io.javalin.http.util;

import dev.morphia.mapping.Mapper;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Tuples;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.p016io.IOStreams;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.http.UploadedFile;

/* compiled from: MultipartUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��B\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0018\u0002\n��\n\u0002\u0010\u000b\n��\n\u0002\u0018\u0002\n\u0002\b\u0003\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\r\u001a\u0014\u0012\u0004\u0012\u00020\u0004\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00040\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\u0007J\u001e\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004H\u0002J\u0014\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u0010\u001a\u00020\u0007J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u000f2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0004J\u0010\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n��R&\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u000e¢\u0006\u000e\n��\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\f¨\u0006\u001b"}, m373d2 = {"Lio/javalin/http/util/MultipartUtil;", "", "()V", "MULTIPART_CONFIG_ATTRIBUTE", "", "preUploadFunction", "Lkotlin/Function1;", "Ljavax/servlet/http/HttpServletRequest;", "", "getPreUploadFunction", "()Lkotlin/jvm/functions/Function1;", "setPreUploadFunction", "(Lkotlin/jvm/functions/Function1;)V", "getFieldMap", "", "", "req", "getPartValue", "partName", "getUploadedFiles", "Lio/javalin/http/UploadedFile;", "isField", "", "filePart", "Ljavax/servlet/http/Part;", "isFile", "toUploadedFile", "javalin"})
/* renamed from: io.javalin.http.util.MultipartUtil */
/* loaded from: grasscutter.jar:io/javalin/http/util/MultipartUtil.class */
public final class MultipartUtil {
    @NotNull
    private static final String MULTIPART_CONFIG_ATTRIBUTE = "org.eclipse.jetty.multipartConfig";
    @NotNull
    public static final MultipartUtil INSTANCE = new MultipartUtil();
    @NotNull
    private static Function1<? super HttpServletRequest, Unit> preUploadFunction = MultipartUtil$preUploadFunction$1.INSTANCE;

    private MultipartUtil() {
    }

    /* JADX DEBUG: Type inference failed for r0v0. Raw type applied. Possible types: kotlin.jvm.functions.Function1<? super javax.servlet.http.HttpServletRequest, kotlin.Unit>, kotlin.jvm.functions.Function1<javax.servlet.http.HttpServletRequest, kotlin.Unit> */
    @NotNull
    public final Function1<HttpServletRequest, Unit> getPreUploadFunction() {
        return preUploadFunction;
    }

    public final void setPreUploadFunction(@NotNull Function1<? super HttpServletRequest, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "<set-?>");
        preUploadFunction = function1;
    }

    @NotNull
    public final List<UploadedFile> getUploadedFiles(@NotNull HttpServletRequest req, @NotNull String partName) {
        Intrinsics.checkNotNullParameter(req, "req");
        Intrinsics.checkNotNullParameter(partName, "partName");
        preUploadFunction.invoke(req);
        Iterable parts = req.getParts();
        Intrinsics.checkNotNullExpressionValue(parts, "req.parts");
        Iterable $this$filter$iv = parts;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Part it = (Part) element$iv$iv;
            MultipartUtil multipartUtil = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (multipartUtil.isFile(it) && Intrinsics.areEqual(it.getName(), partName)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Part> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Part p0 : $this$map$iv) {
            destination$iv$iv2.add(toUploadedFile(p0));
        }
        return (List) destination$iv$iv2;
    }

    @NotNull
    public final List<UploadedFile> getUploadedFiles(@NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        preUploadFunction.invoke(req);
        Iterable parts = req.getParts();
        Intrinsics.checkNotNullExpressionValue(parts, "req.parts");
        Iterable $this$filter$iv = parts;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            if (isFile((Part) element$iv$iv)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Part> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Part p0 : $this$map$iv) {
            destination$iv$iv2.add(toUploadedFile(p0));
        }
        return (List) destination$iv$iv2;
    }

    @NotNull
    public final Map<String, List<String>> getFieldMap(@NotNull HttpServletRequest req) {
        Intrinsics.checkNotNullParameter(req, "req");
        preUploadFunction.invoke(req);
        Iterable parts = req.getParts();
        Intrinsics.checkNotNullExpressionValue(parts, "req.parts");
        Iterable<Part> $this$associate$iv = parts;
        Map destination$iv$iv = new LinkedHashMap(RangesKt.coerceAtLeast(MapsKt.mapCapacity(CollectionsKt.collectionSizeOrDefault($this$associate$iv, 10)), 16));
        for (Part part : $this$associate$iv) {
            String name = part.getName();
            MultipartUtil multipartUtil = INSTANCE;
            String name2 = part.getName();
            Intrinsics.checkNotNullExpressionValue(name2, "part.name");
            Pair pair = Tuples.m366to(name, multipartUtil.getPartValue(req, name2));
            destination$iv$iv.put(pair.getFirst(), pair.getSecond());
        }
        return destination$iv$iv;
    }

    private final List<String> getPartValue(HttpServletRequest req, String partName) {
        Iterable parts = req.getParts();
        Intrinsics.checkNotNullExpressionValue(parts, "req.parts");
        Iterable $this$filter$iv = parts;
        Collection destination$iv$iv = new ArrayList();
        for (Object element$iv$iv : $this$filter$iv) {
            Part it = (Part) element$iv$iv;
            MultipartUtil multipartUtil = INSTANCE;
            Intrinsics.checkNotNullExpressionValue(it, "it");
            if (multipartUtil.isField(it) && Intrinsics.areEqual(it.getName(), partName)) {
                destination$iv$iv.add(element$iv$iv);
            }
        }
        Iterable<Part> $this$map$iv = (List) destination$iv$iv;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (Part filePart : $this$map$iv) {
            InputStream inputStream = filePart.getInputStream();
            Intrinsics.checkNotNullExpressionValue(inputStream, "filePart.inputStream");
            byte[] readBytes = IOStreams.readBytes(inputStream);
            Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue(forName, "forName(\"UTF-8\")");
            destination$iv$iv2.add(new String(readBytes, forName));
        }
        return CollectionsKt.toList((List) destination$iv$iv2);
    }

    private final UploadedFile toUploadedFile(Part filePart) {
        InputStream inputStream = filePart.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "filePart.inputStream");
        String contentType = filePart.getContentType();
        String submittedFileName = filePart.getSubmittedFileName();
        Intrinsics.checkNotNullExpressionValue(submittedFileName, "filePart.submittedFileName");
        String submittedFileName2 = filePart.getSubmittedFileName();
        Intrinsics.checkNotNullExpressionValue(submittedFileName2, "filePart.submittedFileName");
        return new UploadedFile(inputStream, contentType, submittedFileName, StringsKt.replaceBeforeLast$default(submittedFileName2, Mapper.IGNORED_FIELDNAME, "", (String) null, 4, (Object) null), filePart.getSize());
    }

    private final boolean isField(Part filePart) {
        return filePart.getSubmittedFileName() == null;
    }

    private final boolean isFile(Part filePart) {
        return !isField(filePart);
    }
}
