package emu.grasscutter.server.http.documentation;

import emu.grasscutter.utils.Language;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.Context;

/*  JADX ERROR: NullPointerException in pass: ExtractFieldInit
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because "blocks" is null
    	at jadx.core.utils.BlockUtils.isAllBlocksEmpty(BlockUtils.java:894)
    	at jadx.core.dex.visitors.ExtractFieldInit.getConstructorsList(ExtractFieldInit.java:367)
    	at jadx.core.dex.visitors.ExtractFieldInit.moveCommonFieldsInit(ExtractFieldInit.java:119)
    	at jadx.core.dex.visitors.ExtractFieldInit.visit(ExtractFieldInit.java:49)
    */
/* loaded from: grasscutter.jar:emu/grasscutter/server/http/documentation/RootRequestHandler.class */
final class RootRequestHandler implements DocumentationHandler {
    private final String template;

    @Override // emu.grasscutter.server.http.documentation.DocumentationHandler
    public void handle(Context ctx) {
        if (this.template == null) {
            ctx.status(500);
            return;
        }
        String content = this.template.replace("{{TITLE}}", Language.translate("documentation.index.title", new Object[0])).replace("{{ITEM_HANDBOOK}}", Language.translate("documentation.index.handbook", new Object[0])).replace("{{ITEM_GACHA_MAPPING}}", Language.translate("documentation.index.gacha_mapping", new Object[0]));
        ctx.contentType(ContentType.TEXT_HTML);
        ctx.result(content);
    }
}
