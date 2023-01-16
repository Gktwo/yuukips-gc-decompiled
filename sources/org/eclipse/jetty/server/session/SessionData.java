package org.eclipse.jetty.server.session;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.eclipse.jetty.util.ClassLoadingObjectInputStream;
import org.eclipse.jetty.util.ClassVisibilityChecker;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/SessionData.class */
public class SessionData implements Serializable {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    private static final long serialVersionUID = 1;
    protected String _id;
    protected String _contextPath;
    protected String _vhost;
    protected String _lastNode;
    protected long _expiry;
    protected long _created;
    protected long _cookieSet;
    protected long _accessed;
    protected long _lastAccessed;
    protected long _maxInactiveMs;
    protected Map<String, Object> _attributes;
    protected boolean _dirty;
    protected long _lastSaved;
    protected boolean _metaDataDirty;

    public static void serializeAttributes(SessionData data, ObjectOutputStream out) throws IOException {
        boolean isContextLoader;
        out.writeObject(Integer.valueOf(data._attributes.size()));
        for (Map.Entry<String, Object> entry : data._attributes.entrySet()) {
            out.writeUTF(entry.getKey());
            Class<?> clazz = entry.getValue().getClass();
            ClassLoader loader = clazz.getClassLoader();
            ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
            if (loader == contextLoader) {
                isContextLoader = true;
            } else if (contextLoader == null) {
                isContextLoader = false;
            } else if (contextLoader instanceof ClassVisibilityChecker) {
                ClassVisibilityChecker checker = (ClassVisibilityChecker) contextLoader;
                isContextLoader = checker.isSystemClass(clazz) && !checker.isServerClass(clazz);
            } else {
                try {
                    isContextLoader = contextLoader.loadClass(clazz.getName()) == clazz;
                } catch (Throwable th) {
                    isContextLoader = false;
                }
            }
            if (LOG.isDebugEnabled()) {
                Logger logger = LOG;
                Object[] objArr = new Object[3];
                objArr[0] = entry.getKey();
                objArr[1] = clazz.getName();
                objArr[2] = Boolean.valueOf(!isContextLoader);
                logger.debug("Attribute {} class={} isServerLoader={}", objArr);
            }
            out.writeBoolean(!isContextLoader);
            out.writeObject(entry.getValue());
        }
    }

    public static void deserializeAttributes(SessionData data, ObjectInputStream in) throws IOException, ClassNotFoundException {
        Object o = in.readObject();
        if (!(o instanceof Integer)) {
            LOG.info("Legacy serialization detected for {}", data.getId());
            data._attributes = new ConcurrentHashMap();
            data.putAllAttributes((Map) o);
        } else if (!ClassLoadingObjectInputStream.class.isAssignableFrom(in.getClass())) {
            throw new IOException("Not ClassLoadingObjectInputStream");
        } else {
            data._attributes = new ConcurrentHashMap();
            int entries = ((Integer) o).intValue();
            ClassLoader contextLoader = Thread.currentThread().getContextClassLoader();
            ClassLoader serverLoader = SessionData.class.getClassLoader();
            for (int i = 0; i < entries; i++) {
                String name = in.readUTF();
                boolean isServerClassLoader = in.readBoolean();
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Deserialize {} isServerLoader={} serverLoader={} tccl={}", name, Boolean.valueOf(isServerClassLoader), serverLoader, contextLoader);
                }
                data._attributes.put(name, ((ClassLoadingObjectInputStream) in).readObject(isServerClassLoader ? serverLoader : contextLoader));
            }
        }
    }

    public SessionData(String id, String cpath, String vhost, long created, long accessed, long lastAccessed, long maxInactiveMs) {
        this._id = id;
        setContextPath(cpath);
        setVhost(vhost);
        this._created = created;
        this._accessed = accessed;
        this._lastAccessed = lastAccessed;
        this._maxInactiveMs = maxInactiveMs;
        calcAndSetExpiry();
        this._attributes = new ConcurrentHashMap();
    }

    public SessionData(String id, String cpath, String vhost, long created, long accessed, long lastAccessed, long maxInactiveMs, Map<String, Object> attributes) {
        this(id, cpath, vhost, created, accessed, lastAccessed, maxInactiveMs);
        putAllAttributes(attributes);
    }

    public void copy(SessionData data) {
        if (data != null) {
            if (data.getId() == null || !getId().equals(data.getId())) {
                throw new IllegalStateException("Can only copy data for same session id");
            } else if (data != this) {
                setLastNode(data.getLastNode());
                setContextPath(data.getContextPath());
                setVhost(data.getVhost());
                setCookieSet(data.getCookieSet());
                setCreated(data.getCreated());
                setAccessed(data.getAccessed());
                setLastAccessed(data.getLastAccessed());
                setMaxInactiveMs(data.getMaxInactiveMs());
                setExpiry(data.getExpiry());
                setLastSaved(data.getLastSaved());
                clearAllAttributes();
                putAllAttributes(data.getAllAttributes());
            }
        }
    }

    public long getLastSaved() {
        return this._lastSaved;
    }

    public void setLastSaved(long lastSaved) {
        this._lastSaved = lastSaved;
    }

    public boolean isDirty() {
        return this._dirty;
    }

    public void setDirty(boolean dirty) {
        this._dirty = dirty;
    }

    public boolean isMetaDataDirty() {
        return this._metaDataDirty;
    }

    public void setMetaDataDirty(boolean metaDataDirty) {
        this._metaDataDirty = metaDataDirty;
    }

    public Object getAttribute(String name) {
        return this._attributes.get(name);
    }

    public Set<String> getKeys() {
        return this._attributes.keySet();
    }

    public Object setAttribute(String name, Object value) {
        Object old = value == null ? this._attributes.remove(name) : this._attributes.put(name, value);
        if (value == null && old == null) {
            return old;
        }
        setDirty(name);
        return old;
    }

    public void setDirty(String name) {
        setDirty(true);
    }

    public void clean() {
        setDirty(false);
        setMetaDataDirty(false);
    }

    public void putAllAttributes(Map<String, Object> attributes) {
        this._attributes.putAll(attributes);
    }

    public void clearAllAttributes() {
        this._attributes.clear();
    }

    public Map<String, Object> getAllAttributes() {
        return Collections.unmodifiableMap(this._attributes);
    }

    public String getId() {
        return this._id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getContextPath() {
        return this._contextPath;
    }

    public void setContextPath(String contextPath) {
        this._contextPath = contextPath;
    }

    public String getVhost() {
        return this._vhost;
    }

    public void setVhost(String vhost) {
        this._vhost = vhost;
    }

    public String getLastNode() {
        return this._lastNode;
    }

    public void setLastNode(String lastNode) {
        this._lastNode = lastNode;
    }

    public long getExpiry() {
        return this._expiry;
    }

    public void setExpiry(long expiry) {
        this._expiry = expiry;
    }

    public long calcExpiry() {
        return calcExpiry(System.currentTimeMillis());
    }

    public long calcExpiry(long time) {
        if (getMaxInactiveMs() <= 0) {
            return 0;
        }
        return time + getMaxInactiveMs();
    }

    public void calcAndSetExpiry(long time) {
        setExpiry(calcExpiry(time));
        setMetaDataDirty(true);
    }

    public void calcAndSetExpiry() {
        setExpiry(calcExpiry());
        setMetaDataDirty(true);
    }

    public long getCreated() {
        return this._created;
    }

    public void setCreated(long created) {
        this._created = created;
    }

    public long getCookieSet() {
        return this._cookieSet;
    }

    public void setCookieSet(long cookieSet) {
        this._cookieSet = cookieSet;
    }

    public long getAccessed() {
        return this._accessed;
    }

    public void setAccessed(long accessed) {
        this._accessed = accessed;
    }

    public long getLastAccessed() {
        return this._lastAccessed;
    }

    public void setLastAccessed(long lastAccessed) {
        this._lastAccessed = lastAccessed;
    }

    public long getMaxInactiveMs() {
        return this._maxInactiveMs;
    }

    public void setMaxInactiveMs(long maxInactive) {
        this._maxInactiveMs = maxInactive;
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.writeUTF(this._id);
        out.writeUTF(this._contextPath);
        out.writeUTF(this._vhost);
        out.writeLong(this._accessed);
        out.writeLong(this._lastAccessed);
        out.writeLong(this._created);
        out.writeLong(this._cookieSet);
        out.writeUTF(this._lastNode);
        out.writeLong(this._expiry);
        out.writeLong(this._maxInactiveMs);
        serializeAttributes(this, out);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        this._id = in.readUTF();
        this._contextPath = in.readUTF();
        this._vhost = in.readUTF();
        this._accessed = in.readLong();
        this._lastAccessed = in.readLong();
        this._created = in.readLong();
        this._cookieSet = in.readLong();
        this._lastNode = in.readUTF();
        this._expiry = in.readLong();
        this._maxInactiveMs = in.readLong();
        deserializeAttributes(this, in);
    }

    public boolean isExpiredAt(long time) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Testing expiry on session {}: expires at {} now {} maxIdle {}", this._id, Long.valueOf(getExpiry()), Long.valueOf(time), Long.valueOf(getMaxInactiveMs()));
        }
        return getMaxInactiveMs() > 0 && getExpiry() <= time;
    }

    @Override // java.lang.Object
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("id=" + this._id);
        builder.append(", contextpath=" + this._contextPath);
        builder.append(", vhost=" + this._vhost);
        builder.append(", accessed=" + this._accessed);
        builder.append(", lastaccessed=" + this._lastAccessed);
        builder.append(", created=" + this._created);
        builder.append(", cookieset=" + this._cookieSet);
        builder.append(", lastnode=" + this._lastNode);
        builder.append(", expiry=" + this._expiry);
        builder.append(", maxinactive=" + this._maxInactiveMs);
        return builder.toString();
    }
}
