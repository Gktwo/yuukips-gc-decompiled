package emu.grasscutter.server.http.documentation;

import emu.grasscutter.config.Configuration;
import emu.grasscutter.utils.Language;
import java.util.List;
import p013io.javalin.http.ContentType;
import p013io.javalin.http.Context;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/documentation/GachaMappingRequestHandler.class */
final class GachaMappingRequestHandler implements DocumentationHandler {
    private List<String> gachaJsons;

    @Override // emu.grasscutter.server.http.documentation.DocumentationHandler
    public void handle(Context ctx) {
        ctx.contentType(ContentType.APPLICATION_JSON).result(this.gachaJsons.get(Language.TextStrings.MAP_LANGUAGES.getOrDefault(Configuration.DOCUMENT_LANGUAGE, 0)));
    }
}
