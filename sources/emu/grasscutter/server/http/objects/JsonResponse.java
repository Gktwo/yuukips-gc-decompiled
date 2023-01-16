package emu.grasscutter.server.http.objects;

import emu.grasscutter.utils.Utils;
import p013io.javalin.http.Context;
import p013io.javalin.http.Handler;

/* loaded from: grasscutter.jar:emu/grasscutter/server/http/objects/JsonResponse.class */
public final class JsonResponse implements Handler {
    public int retcode;
    public String message;
    public Object data;

    public JsonResponse() {
        this.retcode = 200;
        this.message = "Success";
    }

    public JsonResponse(int code, String message) {
        this.retcode = 200;
        this.message = "Success";
        this.retcode = code;
        this.message = message;
    }

    public JsonResponse(int code, String message, Object data) {
        this.retcode = 200;
        this.message = "Success";
        this.retcode = code;
        this.message = message;
        this.data = data;
    }

    public JsonResponse(int code, String message, String data) {
        this.retcode = 200;
        this.message = "Success";
        this.retcode = code;
        this.message = message;
        this.data = Utils.stringToJSONObject(data) == null ? data : Utils.stringToJSONObject(data);
    }

    public JsonResponse(Object data) {
        this.retcode = 200;
        this.message = "Success";
        this.data = data;
    }

    public JsonResponse(String data) {
        this.retcode = 200;
        this.message = "Success";
        this.data = Utils.stringToJSONObject(data) == null ? data : Utils.stringToJSONObject(data);
    }

    @Override // p013io.javalin.http.Handler
    public void handle(Context ctx) throws Exception {
        ctx.json(this);
    }
}
