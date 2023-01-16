package com.mongodb.gridfs;

import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.DBObjectCodecProvider;
import com.mongodb.MongoException;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.bson.BSONObject;
import org.bson.codecs.BsonValueCodecProvider;
import org.bson.codecs.EncoderContext;
import org.bson.codecs.ValueCodecProvider;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.bson.json.JsonWriter;
import org.bson.json.JsonWriterSettings;

/* loaded from: grasscutter.jar:com/mongodb/gridfs/GridFSFile.class */
public abstract class GridFSFile implements DBObject {
    private static final CodecRegistry DEFAULT_REGISTRY = CodecRegistries.fromProviders(Arrays.asList(new ValueCodecProvider(), new BsonValueCodecProvider(), new DBObjectCodecProvider()));
    private static final Set<String> VALID_FIELDS = Collections.unmodifiableSet(new HashSet(Arrays.asList(DBCollection.ID_FIELD_NAME, "filename", "contentType", "length", "chunkSize", "uploadDate", "aliases")));
    final DBObject extra = new BasicDBObject();

    /* renamed from: fs */
    GridFS f452fs;

    /* renamed from: id */
    Object f453id;
    String filename;
    String contentType;
    long length;
    long chunkSize;
    Date uploadDate;

    public void save() {
        if (this.f452fs == null) {
            throw new MongoException("need fs");
        }
        this.f452fs.getFilesCollection().save(this);
    }

    public int numChunks() {
        return (int) Math.ceil(((double) this.length) / ((double) this.chunkSize));
    }

    public Object getId() {
        return this.f453id;
    }

    public String getFilename() {
        return this.filename;
    }

    public String getContentType() {
        return this.contentType;
    }

    public long getLength() {
        return this.length;
    }

    public long getChunkSize() {
        return this.chunkSize;
    }

    public Date getUploadDate() {
        return this.uploadDate;
    }

    public List<String> getAliases() {
        return (List) this.extra.get("aliases");
    }

    public DBObject getMetaData() {
        return (DBObject) this.extra.get("metadata");
    }

    public void setMetaData(DBObject metadata) {
        this.extra.put("metadata", metadata);
    }

    @Override // org.bson.BSONObject
    public Object put(String key, Object v) {
        if (key == null) {
            throw new RuntimeException("key should never be null");
        }
        if (key.equals(DBCollection.ID_FIELD_NAME)) {
            this.f453id = v;
        } else if (key.equals("filename")) {
            this.filename = v == null ? null : v.toString();
        } else if (key.equals("contentType")) {
            this.contentType = (String) v;
        } else if (key.equals("length")) {
            this.length = ((Number) v).longValue();
        } else if (key.equals("chunkSize")) {
            this.chunkSize = ((Number) v).longValue();
        } else if (key.equals("uploadDate")) {
            this.uploadDate = (Date) v;
        } else {
            this.extra.put(key, v);
        }
        return v;
    }

    @Override // org.bson.BSONObject
    public Object get(String key) {
        if (key == null) {
            throw new IllegalArgumentException("Key should never be null");
        } else if (key.equals(DBCollection.ID_FIELD_NAME)) {
            return this.f453id;
        } else {
            if (key.equals("filename")) {
                return this.filename;
            }
            if (key.equals("contentType")) {
                return this.contentType;
            }
            if (key.equals("length")) {
                return Long.valueOf(this.length);
            }
            if (key.equals("chunkSize")) {
                return Long.valueOf(this.chunkSize);
            }
            if (key.equals("uploadDate")) {
                return this.uploadDate;
            }
            return this.extra.get(key);
        }
    }

    @Override // org.bson.BSONObject
    public boolean containsField(String s) {
        return keySet().contains(s);
    }

    @Override // org.bson.BSONObject
    public Set<String> keySet() {
        Set<String> keys = new HashSet<>();
        keys.addAll(VALID_FIELDS);
        keys.addAll(this.extra.keySet());
        return keys;
    }

    @Override // com.mongodb.DBObject
    public boolean isPartialObject() {
        return false;
    }

    @Override // com.mongodb.DBObject
    public void markAsPartialObject() {
        throw new MongoException("Can't load partial GridFSFile file");
    }

    public String toString() {
        JsonWriter writer = new JsonWriter(new StringWriter(), JsonWriterSettings.builder().build());
        DEFAULT_REGISTRY.get(GridFSFile.class).encode(writer, this, EncoderContext.builder().isEncodingCollectibleDocument(true).build());
        return writer.getWriter().toString();
    }

    protected void setGridFS(GridFS fs) {
        this.f452fs = fs;
    }

    protected GridFS getGridFS() {
        return this.f452fs;
    }

    @Override // org.bson.BSONObject
    public void putAll(BSONObject o) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BSONObject
    public void putAll(Map m) {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BSONObject
    public Map<?, ?> toMap() {
        throw new UnsupportedOperationException();
    }

    @Override // org.bson.BSONObject
    public Object removeField(String key) {
        throw new UnsupportedOperationException();
    }
}
