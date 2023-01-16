package emu.grasscutter.server.http.documentation;

import emu.grasscutter.server.http.Router;
import java.util.Objects;
import p013io.javalin.Javalin;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/documentation/DocumentationServerHandler.class */
public final class DocumentationServerHandler implements Router {
    @Override // emu.grasscutter.server.http.Router
    public void applyRoutes(Javalin javalin) {
        RootRequestHandler root = new RootRequestHandler();
        HandbookRequestHandler handbook = new HandbookRequestHandler();
        GachaMappingRequestHandler gachaMapping = new GachaMappingRequestHandler();
        Objects.requireNonNull(handbook);
        javalin.get("/documentation/handbook", this::handle);
        Objects.requireNonNull(gachaMapping);
        javalin.get("/documentation/gachamapping", this::handle);
        Objects.requireNonNull(root);
        javalin.get("/documentation", this::handle);
    }
}
