package p013io.javalin.core.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import p013io.javalin.apibuilder.CrudFunctionHandler;
import p013io.javalin.core.event.HandlerMetaInfo;
import p013io.javalin.core.event.WsHandlerMetaInfo;
import p013io.javalin.http.HandlerType;
import p013io.javalin.websocket.WsHandlerType;

/* compiled from: RouteOverviewUtil.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��&\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010 \n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J$\u0010\t\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0007J$\u0010\u000f\u001a\u00020\u00042\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bH\u0007R\u001e\u0010\u0003\u001a\u00020\u0004*\u00020\u00018FX\u0004¢\u0006\f\u0012\u0004\b\u0005\u0010\u0006\u001a\u0004\b\u0007\u0010\b¨\u0006\u0010"}, m373d2 = {"Lio/javalin/core/util/RouteOverviewUtil;", "", "()V", "metaInfo", "", "getMetaInfo$annotations", "(Ljava/lang/Object;)V", "getMetaInfo", "(Ljava/lang/Object;)Ljava/lang/String;", "createHtmlOverview", "handlerInfo", "", "Lio/javalin/core/event/HandlerMetaInfo;", "wsHandlerInfo", "Lio/javalin/core/event/WsHandlerMetaInfo;", "createJsonOverview", "javalin"})
/* renamed from: io.javalin.core.util.RouteOverviewUtil */
/* loaded from: grasscutter.jar:io/javalin/core/util/RouteOverviewUtil.class */
public final class RouteOverviewUtil {
    @NotNull
    public static final RouteOverviewUtil INSTANCE = new RouteOverviewUtil();

    @JvmStatic
    public static /* synthetic */ void getMetaInfo$annotations(Object $this$getMetaInfo_u24annotations) {
    }

    private RouteOverviewUtil() {
    }

    @JvmStatic
    @NotNull
    public static final String createHtmlOverview(@NotNull List<HandlerMetaInfo> list, @NotNull List<WsHandlerMetaInfo> list2) {
        Intrinsics.checkNotNullParameter(list, "handlerInfo");
        Intrinsics.checkNotNullParameter(list2, "wsHandlerInfo");
        StringBuilder append = new StringBuilder().append("\n        <meta name='viewport' content='width=device-width, initial-scale=1'>\n        <style>\n            * {\n                box-sizing: border-box;\n            }\n            b, thead {\n                font-weight: 700;\n            }\n            html {\n                background: #363e4c;\n            }\n            body {\n                font-family: monospace;\n                padding: 25px;\n            }\n            table {\n                background: #fff;\n                border-spacing: 0;\n                font-size: 14px;\n                width: 100%;\n                white-space: pre;\n                box-shadow: 0 5px 25px rgba(0,0,0,0.25);\n            }\n            thead {\n                background: #1a202b;\n                color: #fff;\n            }\n            thead td {\n                border-bottom: 2px solid #000;\n                cursor: pointer;\n            }\n            tr + tr td {\n                border-top: 1px solid rgba(0, 0, 0, 0.25);\n            }\n            tr + tr td:first-of-type {\n                border-top: 1px solid rgba(0, 0, 0, 0.35);\n            }\n            td {\n                padding: 10px 15px;\n            }\n            tbody td:not(:first-of-type) {\n                background-color: rgba(255,255,255,0.925);\n            }\n            tbody tr:hover td:not(:first-of-type) {\n                background-color: rgba(255,255,255,0.85);\n            }\n            .method td:first-of-type {\n                text-align: center;\n                max-width: 90px;\n            }\n            tbody .method td:first-of-type {\n                font-weight: 700;\n                color: #fff;\n                text-shadow: 1px 1px 0px rgba(0,0,0,0.5);\n                border-left: 6px solid rgba(0, 0, 0, 0.35);\n                border-right: 1px solid rgba(0, 0, 0, 0.15);\n            }\n            .GET {\n                background: #5a76ff;\n            }\n            .POST {\n                background: #5dca5d;\n            }\n            .PUT {\n                background: #d9cc00;\n            }\n            .PATCH {\n                background: #ef9a00;\n            }\n            .DELETE {\n                background: #e44848;\n            }\n            .HEAD, .TRACE, .OPTIONS, .CONNECT  {\n                background: #00b9b9;\n            }\n            .BEFORE, .AFTER {\n                background: #777;\n            }\n            .WEBSOCKET, .WS_BEFORE, .WS_AFTER {\n                background: #546E7A;\n            }\n        </style>\n        <body>\n            <table>\n                <thead>\n                    <tr class=\"method\">\n                        <td width=\"105px\">Method</td>\n                        <td>Path</td>\n                        <td>Handler</td>\n                        <td>Roles</td>\n                    </tr>\n                </thead>\n                ");
        List<HandlerMetaInfo> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (HandlerMetaInfo $dstr$handlerType$path$handler$roles : $this$map$iv) {
            HandlerType handlerType = $dstr$handlerType$path$handler$roles.component1();
            String path = $dstr$handlerType$path$handler$roles.component2();
            Object handler = $dstr$handlerType$path$handler$roles.component3();
            destination$iv$iv.add("\n                    <tr class=\"method " + handlerType + "\">\n                        <td>" + handlerType + "</span></td>\n                        <td>" + path + "</td>\n                        <td><b>" + getMetaInfo(handler) + "</b></td>\n                        <td>" + $dstr$handlerType$path$handler$roles.component4() + "</td>\n                    </tr>\n                    ");
        }
        StringBuilder append2 = append.append(CollectionsKt.joinToString$default((List) destination$iv$iv, "", null, null, 0, null, null, 62, null)).append("\n                ");
        List<WsHandlerMetaInfo> $this$map$iv2 = list2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (WsHandlerMetaInfo $dstr$wsHandlerType$path$handler$roles : $this$map$iv2) {
            WsHandlerType wsHandlerType = $dstr$wsHandlerType$path$handler$roles.component1();
            String path2 = $dstr$wsHandlerType$path$handler$roles.component2();
            Object handler2 = $dstr$wsHandlerType$path$handler$roles.component3();
            destination$iv$iv2.add("\n                    <tr class=\"method " + wsHandlerType + "\">\n                        <td>" + wsHandlerType + "</span></td>\n                        <td>" + path2 + "</td>\n                        <td><b>" + getMetaInfo(handler2) + "</b></td>\n                        <td>" + $dstr$wsHandlerType$path$handler$roles.component4() + "</td>\n                    </tr>\n                    ");
        }
        return append2.append(CollectionsKt.joinToString$default((List) destination$iv$iv2, "", null, null, 0, null, null, 62, null)).append("\n            </table>\n            <script>\n                const cachedRows = Array.from(document.querySelectorAll(\"tbody tr\"));\n                const verbOrder = [\"BEFORE\", \"GET\", \"POST\", \"PUT\", \"PATCH\", \"DELETE\", \"CONNECT\", \"OPTIONS\", \"TRACE\", \"HEAD\", \"AFTER\", \"WS_BEFORE\", \"WEBSOCKET\", \"WS_AFTER\"];\n                document.querySelector(\"thead\").addEventListener(\"click\", function (e) {\n                    cachedRows.map(function (el) {\n                        return {key: el.children[e.target.cellIndex].textContent, row: el};\n                    }).sort((a, b) => {\n                        if (e.target.textContent === \"Method\") {\n                            return verbOrder.indexOf(a.key) - verbOrder.indexOf(b.key);\n                        }\n                        return a.key.localeCompare(b.key);\n                    }).forEach((pair, i) => {\n                        document.querySelector(\"tbody\").children[i].outerHTML = pair.row.outerHTML\n                    });\n                });\n            </script>\n        </body>\n    ").toString();
    }

    @JvmStatic
    @NotNull
    public static final String createJsonOverview(@NotNull List<HandlerMetaInfo> list, @NotNull List<WsHandlerMetaInfo> list2) {
        Intrinsics.checkNotNullParameter(list, "handlerInfo");
        Intrinsics.checkNotNullParameter(list2, "wsHandlerInfo");
        StringBuilder append = new StringBuilder().append("\n            {\n                \"handlers\": [\n                ");
        List<HandlerMetaInfo> $this$map$iv = list;
        Collection destination$iv$iv = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv, 10));
        for (HandlerMetaInfo $dstr$handlerType$path$handler$roles : $this$map$iv) {
            HandlerType handlerType = $dstr$handlerType$path$handler$roles.component1();
            String path = $dstr$handlerType$path$handler$roles.component2();
            Object handler = $dstr$handlerType$path$handler$roles.component3();
            destination$iv$iv.add("\n                    {\n                        \"path\": \"" + path + "\",\n                        \"handlerType\": \"" + handlerType + "\",\n                        \"metaInfo\": \"" + handler + ".metaInfo\",\n                        \"roles\": \"" + $dstr$handlerType$path$handler$roles.component4() + "\"\n                    }\n                    ");
        }
        StringBuilder append2 = append.append(CollectionsKt.joinToString$default((List) destination$iv$iv, ",", null, null, 0, null, null, 62, null)).append("\n                ],\n                \"wsHandlers\": [\n                ");
        List<WsHandlerMetaInfo> $this$map$iv2 = list2;
        Collection destination$iv$iv2 = new ArrayList(CollectionsKt.collectionSizeOrDefault($this$map$iv2, 10));
        for (WsHandlerMetaInfo $dstr$wsHandlerType$path$handler$roles : $this$map$iv2) {
            WsHandlerType wsHandlerType = $dstr$wsHandlerType$path$handler$roles.component1();
            String path2 = $dstr$wsHandlerType$path$handler$roles.component2();
            Object handler2 = $dstr$wsHandlerType$path$handler$roles.component3();
            destination$iv$iv2.add("\n                    {\n                        \"path\": \"" + path2 + "\",\n                        \"handlerType\": \"" + wsHandlerType + "\",\n                        \"metaInfo\": \"" + handler2 + ".metaInfo\",\n                        \"roles\": \"" + $dstr$wsHandlerType$path$handler$roles.component4() + "\"\n                    }\n                    ");
        }
        return append2.append(CollectionsKt.joinToString$default((List) destination$iv$iv2, ",", null, null, 0, null, null, 62, null)).append("\n                ]\n            }\n    ").toString();
    }

    @NotNull
    public static final String getMetaInfo(@NotNull Object $this$metaInfo) {
        Field field;
        Intrinsics.checkNotNullParameter($this$metaInfo, "<this>");
        if (ReflectionUtil.isClass($this$metaInfo)) {
            return Intrinsics.stringPlus(((Class) $this$metaInfo).getName(), ".class");
        }
        if (ReflectionUtil.isCrudFunction($this$metaInfo)) {
            return Intrinsics.stringPlus("ApiBuilder#crud::", ((CrudFunctionHandler) $this$metaInfo).getFunction().getValue());
        }
        if (!ReflectionUtil.isKotlinMethodReference($this$metaInfo)) {
            return ReflectionUtil.isKotlinAnonymousLambda($this$metaInfo) ? Intrinsics.stringPlus(ReflectionUtil.getParentClass($this$metaInfo).getName(), "::??? (anonymous lambda)") : ReflectionUtil.isKotlinField($this$metaInfo) ? ReflectionUtil.getParentClass($this$metaInfo).getName() + '.' + ReflectionUtil.getKotlinFieldName($this$metaInfo) : ReflectionUtil.getHasMethodName($this$metaInfo) ? ReflectionUtil.getParentClass($this$metaInfo).getName() + "::" + ((Object) ReflectionUtil.getMethodName($this$metaInfo)) : ReflectionUtil.isJavaField($this$metaInfo) ? ReflectionUtil.getParentClass($this$metaInfo).getName() + '.' + ((Object) ReflectionUtil.getJavaFieldName($this$metaInfo)) : ReflectionUtil.isJavaAnonymousLambda($this$metaInfo) ? Intrinsics.stringPlus(ReflectionUtil.getParentClass($this$metaInfo).getName(), "::??? (anonymous lambda)") : Intrinsics.stringPlus(ReflectionUtil.getImplementingClassName($this$metaInfo), ".class");
        }
        Field[] declaredFields = $this$metaInfo.getClass().getDeclaredFields();
        Intrinsics.checkNotNullExpressionValue(declaredFields, "this.javaClass.declaredFields");
        Field[] fieldArr = declaredFields;
        int length = fieldArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                field = null;
                break;
            }
            Field field2 = fieldArr[i];
            Field it = field2;
            if (Intrinsics.areEqual(it.getName(), "function") || Intrinsics.areEqual(it.getName(), "$tmp0")) {
                field = field2;
                break;
            }
            i++;
        }
        Intrinsics.checkNotNull(field);
        String fieldName = field.getName();
        Field $this$_get_metaInfo__u24lambda_u2d5 = $this$metaInfo.getClass().getDeclaredField(fieldName);
        $this$_get_metaInfo__u24lambda_u2d5.setAccessible(true);
        Object field3 = $this$_get_metaInfo__u24lambda_u2d5.get($this$metaInfo);
        if (Intrinsics.areEqual(fieldName, "function")) {
            StringBuilder sb = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue(field3, "field");
            return sb.append(ReflectionUtil.runMethod(ReflectionUtil.runMethod(ReflectionUtil.runMethod(field3, "getOwner"), "getJClass"), "getName")).append("::").append(ReflectionUtil.runMethod(field3, "getName")).toString();
        }
        Intrinsics.checkNotNullExpressionValue(field3, "field");
        return Intrinsics.stringPlus(ReflectionUtil.getImplementingClassName(field3), "::??? (anonymous lambda)");
    }
}
