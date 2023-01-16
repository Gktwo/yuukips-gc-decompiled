package com.google.gson;

import com.google.gson.internal.Streams;
import com.google.gson.stream.JsonReader;
import java.io.EOFException;
import java.io.Reader;
import java.io.StringReader;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: grasscutter.jar:com/google/gson/JsonStreamParser.class */
public final class JsonStreamParser implements Iterator<JsonElement> {
    private final JsonReader parser;
    private final Object lock;

    public JsonStreamParser(String json) {
        this(new StringReader(json));
    }

    public JsonStreamParser(Reader reader) {
        this.parser = new JsonReader(reader);
        this.parser.setLenient(true);
        this.lock = new Object();
    }

    @Override // java.util.Iterator
    public JsonElement next() throws JsonParseException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        try {
            return Streams.parse(this.parser);
        } catch (JsonParseException e) {
            if (e.getCause() instanceof EOFException) {
                throw new NoSuchElementException();
            }
            throw e;
        } catch (OutOfMemoryError e2) {
            throw new JsonParseException("Failed parsing JSON source to Json", e2);
        } catch (StackOverflowError e3) {
            throw new JsonParseException("Failed parsing JSON source to Json", e3);
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x001c
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // java.util.Iterator
    public boolean hasNext() {
        /*
            r4 = this;
            r0 = r4
            java.lang.Object r0 = r0.lock
            r1 = r0
            r5 = r1
            monitor-enter(r0)
            r0 = r4
            com.google.gson.stream.JsonReader r0 = r0.parser     // Catch: all -> 0x0030, MalformedJsonException -> 0x001c, IOException -> 0x0026
            com.google.gson.stream.JsonToken r0 = r0.peek()     // Catch: all -> 0x0030, MalformedJsonException -> 0x001c, IOException -> 0x0026
            com.google.gson.stream.JsonToken r1 = com.google.gson.stream.JsonToken.END_DOCUMENT     // Catch: all -> 0x0030, MalformedJsonException -> 0x001c, IOException -> 0x0026
            if (r0 == r1) goto L_0x0018
            r0 = 1
            goto L_0x0019
        L_0x0018:
            r0 = 0
        L_0x0019:
            r1 = r5
            monitor-exit(r1)     // Catch: all -> 0x0030
            return r0
        L_0x001c:
            r6 = move-exception
            com.google.gson.JsonSyntaxException r0 = new com.google.gson.JsonSyntaxException     // Catch: all -> 0x0030
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: all -> 0x0030
            throw r0     // Catch: all -> 0x0030
        L_0x0026:
            r6 = move-exception
            com.google.gson.JsonIOException r0 = new com.google.gson.JsonIOException     // Catch: all -> 0x0030
            r1 = r0
            r2 = r6
            r1.<init>(r2)     // Catch: all -> 0x0030
            throw r0     // Catch: all -> 0x0030
        L_0x0030:
            r7 = move-exception
            r0 = r5
            monitor-exit(r0)     // Catch: all -> 0x0030
            r0 = r7
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.gson.JsonStreamParser.hasNext():boolean");
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
