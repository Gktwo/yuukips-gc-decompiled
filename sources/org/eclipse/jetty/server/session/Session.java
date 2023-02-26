package org.eclipse.jetty.server.session;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;
import javax.servlet.http.HttpSessionContext;
import javax.servlet.http.HttpSessionEvent;
import org.eclipse.jetty.p023io.CyclicTimeout;
import org.eclipse.jetty.server.session.SessionHandler;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.Locker;

/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/Session.class */
public class Session implements SessionHandler.SessionIf {
    private static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    public static final String SESSION_CREATED_SECURE = "org.eclipse.jetty.security.sessionCreatedSecure";
    protected final SessionData _sessionData;
    protected final SessionHandler _handler;
    protected String _extendedId;
    protected long _requests;
    protected boolean _idChanged;
    protected boolean _newSession;
    protected State _state;
    protected Locker _lock;
    protected Condition _stateChangeCompleted;
    protected boolean _resident;
    protected final SessionInactivityTimer _sessionInactivityTimer;

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/Session$IdState.class */
    public enum IdState {
        SET,
        CHANGING
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/Session$State.class */
    public enum State {
        VALID,
        INVALID,
        INVALIDATING,
        CHANGING
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/Session$SessionInactivityTimer.class */
    public class SessionInactivityTimer {
        protected final CyclicTimeout _timer;

        public SessionInactivityTimer() {
            this._timer = new CyclicTimeout(Session.this.getSessionHandler().getScheduler(), Session.this) { // from class: org.eclipse.jetty.server.session.Session.SessionInactivityTimer.1
                @Override // org.eclipse.jetty.p023io.CyclicTimeout
                public void onTimeoutExpired() {
                    if (Session.LOG.isDebugEnabled()) {
                        Session.LOG.debug("Timer expired for session {}", Session.this.getId());
                    }
                    long now = System.currentTimeMillis();
                    Session.this.getSessionHandler().sessionInactivityTimerExpired(Session.this, now);
                    Locker.Lock lock = Session.this.lock();
                    try {
                        if (Session.this.isResident() && Session.this.getRequests() <= 0 && Session.this.isValid() && !Session.this.isExpiredAt(now)) {
                            SessionInactivityTimer.this.schedule(Session.this.calculateInactivityTimeout(now));
                        }
                        if (lock != null) {
                            lock.close();
                        }
                    } catch (Throwable th) {
                        if (lock != null) {
                            try {
                                lock.close();
                            } catch (Throwable th2) {
                                th.addSuppressed(th2);
                            }
                        }
                        throw th;
                    }
                }
            };
        }

        @Deprecated
        public void schedule() {
            schedule(Session.this.calculateInactivityTimeout(System.currentTimeMillis()));
        }

        public void schedule(long time) {
            if (time >= 0) {
                if (Session.LOG.isDebugEnabled()) {
                    Session.LOG.debug("(Re)starting timer for session {} at {}ms", Session.this.getId(), Long.valueOf(time));
                }
                this._timer.schedule(time, TimeUnit.MILLISECONDS);
            } else if (Session.LOG.isDebugEnabled()) {
                Session.LOG.debug("Not starting timer for session {}", Session.this.getId());
            }
        }

        public void cancel() {
            this._timer.cancel();
            if (Session.LOG.isDebugEnabled()) {
                Session.LOG.debug("Cancelled timer for session {}", Session.this.getId());
            }
        }

        public void destroy() {
            this._timer.destroy();
            if (Session.LOG.isDebugEnabled()) {
                Session.LOG.debug("Destroyed timer for session {}", Session.this.getId());
            }
        }
    }

    public Session(SessionHandler handler, HttpServletRequest request, SessionData data) {
        this._state = State.VALID;
        this._lock = new Locker();
        this._stateChangeCompleted = this._lock.newCondition();
        this._resident = false;
        this._handler = handler;
        this._sessionData = data;
        this._newSession = true;
        this._sessionData.setDirty(true);
        this._sessionInactivityTimer = new SessionInactivityTimer();
    }

    public Session(SessionHandler handler, SessionData data) {
        this._state = State.VALID;
        this._lock = new Locker();
        this._stateChangeCompleted = this._lock.newCondition();
        this._resident = false;
        this._handler = handler;
        this._sessionData = data;
        this._sessionInactivityTimer = new SessionInactivityTimer();
    }

    public long getRequests() {
        Locker.Lock lock = this._lock.lock();
        try {
            long j = this._requests;
            if (lock != null) {
                lock.close();
            }
            return j;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setExtendedId(String extendedId) {
        this._extendedId = extendedId;
    }

    /* access modifiers changed from: protected */
    public void cookieSet() {
        Locker.Lock lock = this._lock.lock();
        try {
            this._sessionData.setCookieSet(this._sessionData.getAccessed());
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void use() {
        Locker.Lock lock = this._lock.lock();
        try {
            this._requests++;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Session {} in use, stopping timer, active requests={}", getId(), Long.valueOf(this._requests));
            }
            this._sessionInactivityTimer.cancel();
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean access(long time) {
        Locker.Lock lock = this._lock.lock();
        try {
            if (!isValid() || !isResident()) {
                if (lock != null) {
                    lock.close();
                }
                return false;
            }
            this._newSession = false;
            long lastAccessed = this._sessionData.getAccessed();
            this._sessionData.setAccessed(time);
            this._sessionData.setLastAccessed(lastAccessed);
            this._sessionData.calcAndSetExpiry(time);
            if (isExpiredAt(time)) {
                invalidate();
                if (lock != null) {
                    lock.close();
                }
                return false;
            }
            if (lock != null) {
                lock.close();
            }
            return true;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public void complete() {
        Locker.Lock lock = this._lock.lock();
        try {
            this._requests--;
            if (LOG.isDebugEnabled()) {
                LOG.debug("Session {} complete, active requests={}", getId(), Long.valueOf(this._requests));
            }
            if (this._requests == 0) {
                long now = System.currentTimeMillis();
                this._sessionData.calcAndSetExpiry(now);
                this._sessionInactivityTimer.schedule(calculateInactivityTimeout(now));
            }
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isExpiredAt(long time) {
        Locker.Lock lock = this._lock.lock();
        try {
            boolean isExpiredAt = this._sessionData.isExpiredAt(time);
            if (lock != null) {
                lock.close();
            }
            return isExpiredAt;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* access modifiers changed from: protected */
    public boolean isIdleLongerThan(int sec) {
        long now = System.currentTimeMillis();
        Locker.Lock lock = this._lock.lock();
        try {
            boolean z = this._sessionData.getAccessed() + ((long) (sec * 1000)) <= now;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    protected void callSessionAttributeListeners(String name, Object newValue, Object oldValue) {
        if (newValue == null || !newValue.equals(oldValue)) {
            if (oldValue != null) {
                unbindValue(name, oldValue);
            }
            if (newValue != null) {
                bindValue(name, newValue);
            }
            if (this._handler == null) {
                throw new IllegalStateException("No session manager for session " + this._sessionData.getId());
            }
            this._handler.doSessionAttributeListeners(this, name, oldValue, newValue);
        }
    }

    public void unbindValue(String name, Object value) {
        if (value != null && (value instanceof HttpSessionBindingListener)) {
            ((HttpSessionBindingListener) value).valueUnbound(new HttpSessionBindingEvent(this, name));
        }
    }

    public void bindValue(String name, Object value) {
        if (value != null && (value instanceof HttpSessionBindingListener)) {
            ((HttpSessionBindingListener) value).valueBound(new HttpSessionBindingEvent(this, name));
        }
    }

    public void didActivate() {
        boolean dirty = getSessionData().isDirty();
        try {
            HttpSessionEvent event = new HttpSessionEvent(this);
            for (String str : this._sessionData.getKeys()) {
                Object value = this._sessionData.getAttribute(str);
                if (value instanceof HttpSessionActivationListener) {
                    ((HttpSessionActivationListener) value).sessionDidActivate(event);
                }
            }
        } finally {
            getSessionData().setDirty(dirty);
        }
    }

    public void willPassivate() {
        HttpSessionEvent event = new HttpSessionEvent(this);
        for (String str : this._sessionData.getKeys()) {
            Object value = this._sessionData.getAttribute(str);
            if (value instanceof HttpSessionActivationListener) {
                ((HttpSessionActivationListener) value).sessionWillPassivate(event);
            }
        }
    }

    public boolean isValid() {
        Locker.Lock lock = this._lock.lock();
        try {
            boolean z = this._state == State.VALID;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0026  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isInvalid() {
        /*
            r3 = this;
            r0 = r3
            org.eclipse.jetty.util.thread.Locker r0 = r0._lock
            org.eclipse.jetty.util.thread.Locker$Lock r0 = r0.lock()
            r4 = r0
            r0 = r3
            org.eclipse.jetty.server.session.Session$State r0 = r0._state     // Catch: Throwable -> 0x002c
            org.eclipse.jetty.server.session.Session$State r1 = org.eclipse.jetty.server.session.Session.State.INVALID     // Catch: Throwable -> 0x002c
            if (r0 == r1) goto L_0x001c
            r0 = r3
            org.eclipse.jetty.server.session.Session$State r0 = r0._state     // Catch: Throwable -> 0x002c
            org.eclipse.jetty.server.session.Session$State r1 = org.eclipse.jetty.server.session.Session.State.INVALIDATING     // Catch: Throwable -> 0x002c
            if (r0 != r1) goto L_0x0020
        L_0x001c:
            r0 = 1
            goto L_0x0021
        L_0x0020:
            r0 = 0
        L_0x0021:
            r5 = r0
            r0 = r4
            if (r0 == 0) goto L_0x002a
            r0 = r4
            r0.close()
        L_0x002a:
            r0 = r5
            return r0
        L_0x002c:
            r5 = move-exception
            r0 = r4
            if (r0 == 0) goto L_0x003e
            r0 = r4
            r0.close()     // Catch: Throwable -> 0x0038
            goto L_0x003e
        L_0x0038:
            r6 = move-exception
            r0 = r5
            r1 = r6
            r0.addSuppressed(r1)
        L_0x003e:
            r0 = r5
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.isInvalid():boolean");
    }

    public boolean isChanging() {
        checkLocked();
        return this._state == State.CHANGING;
    }

    public long getCookieSetTime() {
        Locker.Lock lock = this._lock.lock();
        try {
            long cookieSet = this._sessionData.getCookieSet();
            if (lock != null) {
                lock.close();
            }
            return cookieSet;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    public long getCreationTime() throws IllegalStateException {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            long created = this._sessionData.getCreated();
            if (lock != null) {
                lock.close();
            }
            return created;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    public String getId() {
        Locker.Lock lock = this._lock.lock();
        try {
            String id = this._sessionData.getId();
            if (lock != null) {
                lock.close();
            }
            return id;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public String getExtendedId() {
        return this._extendedId;
    }

    public String getContextPath() {
        return this._sessionData.getContextPath();
    }

    public String getVHost() {
        return this._sessionData.getVhost();
    }

    @Override // javax.servlet.http.HttpSession
    public long getLastAccessedTime() {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            long lastAccessed = this._sessionData.getLastAccessed();
            if (lock != null) {
                lock.close();
            }
            return lastAccessed;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    public ServletContext getServletContext() {
        if (this._handler != null) {
            return this._handler._context;
        }
        throw new IllegalStateException("No session manager for session " + this._sessionData.getId());
    }

    @Override // javax.servlet.http.HttpSession
    public void setMaxInactiveInterval(int secs) {
        Locker.Lock lock = this._lock.lock();
        try {
            this._sessionData.setMaxInactiveMs(((long) secs) * 1000);
            this._sessionData.calcAndSetExpiry();
            this._sessionData.setDirty(true);
            if (LOG.isDebugEnabled()) {
                if (secs <= 0) {
                    LOG.debug("Session {} is now immortal (maxInactiveInterval={})", this._sessionData.getId(), Integer.valueOf(secs));
                } else {
                    LOG.debug("Session {} maxInactiveInterval={}", this._sessionData.getId(), Integer.valueOf(secs));
                }
            }
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Deprecated
    public void updateInactivityTimer() {
    }

    /* JADX WARN: Type inference failed for: r0v11, types: [long] */
    /* JADX WARN: Type inference failed for: r11v4 */
    /* JADX WARN: Type inference failed for: r0v45 */
    /* JADX WARN: Type inference failed for: r0v46 */
    /* JADX WARNING: Unknown variable types count: 2 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public long calculateInactivityTimeout(long r9) {
        /*
        // Method dump skipped, instructions count: 365
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.calculateInactivityTimeout(long):long");
    }

    @Override // javax.servlet.http.HttpSession
    public int getMaxInactiveInterval() {
        Locker.Lock lock = this._lock.lock();
        try {
            long maxInactiveMs = this._sessionData.getMaxInactiveMs();
            int i = (int) (maxInactiveMs < 0 ? -1 : maxInactiveMs / 1000);
            if (lock != null) {
                lock.close();
            }
            return i;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    @Deprecated
    public HttpSessionContext getSessionContext() {
        checkValidForRead();
        return SessionHandler.__nullSessionContext;
    }

    public SessionHandler getSessionHandler() {
        return this._handler;
    }

    /* access modifiers changed from: protected */
    public void checkValidForWrite() throws IllegalStateException {
        checkLocked();
        if (this._state == State.INVALID) {
            throw new IllegalStateException("Not valid for write: id=" + this._sessionData.getId() + " created=" + this._sessionData.getCreated() + " accessed=" + this._sessionData.getAccessed() + " lastaccessed=" + this._sessionData.getLastAccessed() + " maxInactiveMs=" + this._sessionData.getMaxInactiveMs() + " expiry=" + this._sessionData.getExpiry());
        } else if (this._state != State.INVALIDATING && !isResident()) {
            throw new IllegalStateException("Not valid for write: id=" + this._sessionData.getId() + " not resident");
        }
    }

    protected void checkValidForRead() throws IllegalStateException {
        checkLocked();
        if (this._state == State.INVALID) {
            throw new IllegalStateException("Invalid for read: id=" + this._sessionData.getId() + " created=" + this._sessionData.getCreated() + " accessed=" + this._sessionData.getAccessed() + " lastaccessed=" + this._sessionData.getLastAccessed() + " maxInactiveMs=" + this._sessionData.getMaxInactiveMs() + " expiry=" + this._sessionData.getExpiry());
        } else if (this._state != State.INVALIDATING && !isResident()) {
            throw new IllegalStateException("Invalid for read: id=" + this._sessionData.getId() + " not resident");
        }
    }

    protected void checkLocked() throws IllegalStateException {
        if (!this._lock.isLocked()) {
            throw new IllegalStateException("Session not locked");
        }
    }

    @Override // javax.servlet.http.HttpSession
    public Object getAttribute(String name) {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            Object attribute = this._sessionData.getAttribute(name);
            if (lock != null) {
                lock.close();
            }
            return attribute;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    @Deprecated
    public Object getValue(String name) {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            Object attribute = this._sessionData.getAttribute(name);
            if (lock != null) {
                lock.close();
            }
            return attribute;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    public Enumeration<String> getAttributeNames() {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            final Iterator<String> itor = this._sessionData.getKeys().iterator();
            C57161 r0 = new Enumeration<String>() { // from class: org.eclipse.jetty.server.session.Session.1
                @Override // java.util.Enumeration
                public boolean hasMoreElements() {
                    return itor.hasNext();
                }

                @Override // java.util.Enumeration
                public String nextElement() {
                    return (String) itor.next();
                }
            };
            if (lock != null) {
                lock.close();
            }
            return r0;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public int getAttributes() {
        return this._sessionData.getKeys().size();
    }

    public Set<String> getNames() {
        return Collections.unmodifiableSet(this._sessionData.getKeys());
    }

    @Override // javax.servlet.http.HttpSession
    @Deprecated
    public String[] getValueNames() throws IllegalStateException {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            Iterator<String> itor = this._sessionData.getKeys().iterator();
            if (!itor.hasNext()) {
                String[] strArr = new String[0];
                if (lock != null) {
                    lock.close();
                }
                return strArr;
            }
            ArrayList<String> names = new ArrayList<>();
            while (itor.hasNext()) {
                names.add(itor.next());
            }
            String[] strArr2 = (String[]) names.toArray(new String[names.size()]);
            if (lock != null) {
                lock.close();
            }
            return strArr2;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    public void setAttribute(String name, Object value) {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForWrite();
            Object old = this._sessionData.setAttribute(name, value);
            if (lock != null) {
                lock.close();
            }
            if (value != null || old != null) {
                callSessionAttributeListeners(name, value, old);
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // javax.servlet.http.HttpSession
    @Deprecated
    public void putValue(String name, Object value) {
        setAttribute(name, value);
    }

    @Override // javax.servlet.http.HttpSession
    public void removeAttribute(String name) {
        setAttribute(name, null);
    }

    @Override // javax.servlet.http.HttpSession
    @Deprecated
    public void removeValue(String name) {
        setAttribute(name, null);
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:12:0x0074
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    public void renewId(javax.servlet.http.HttpServletRequest r6) {
        /*
        // Method dump skipped, instructions count: 394
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.renewId(javax.servlet.http.HttpServletRequest):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: org.eclipse.jetty.server.session.Session$2 */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/Session$2.class */
    public static /* synthetic */ class C57172 {
        static final /* synthetic */ int[] $SwitchMap$org$eclipse$jetty$server$session$Session$State = new int[State.values().length];

        static {
            try {
                $SwitchMap$org$eclipse$jetty$server$session$Session$State[State.INVALID.ordinal()] = 1;
            } catch (NoSuchFieldError e) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$server$session$Session$State[State.INVALIDATING.ordinal()] = 2;
            } catch (NoSuchFieldError e2) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$server$session$Session$State[State.CHANGING.ordinal()] = 3;
            } catch (NoSuchFieldError e3) {
            }
            try {
                $SwitchMap$org$eclipse$jetty$server$session$Session$State[State.VALID.ordinal()] = 4;
            } catch (NoSuchFieldError e4) {
            }
        }
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:11:0x0053
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    @Override // javax.servlet.http.HttpSession
    public void invalidate() {
        /*
            r5 = this;
            r0 = r5
            org.eclipse.jetty.server.session.SessionHandler r0 = r0._handler
            if (r0 != 0) goto L_0x0028
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r3 = r2
            r3.<init>()
            java.lang.String r3 = "No session manager for session "
            java.lang.StringBuilder r2 = r2.append(r3)
            r3 = r5
            org.eclipse.jetty.server.session.SessionData r3 = r3._sessionData
            java.lang.String r3 = r3.getId()
            java.lang.StringBuilder r2 = r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2)
            throw r0
        L_0x0028:
            r0 = r5
            boolean r0 = r0.beginInvalidate()
            r6 = r0
            r0 = r6
            if (r0 == 0) goto L_0x0093
            r0 = r5
            org.eclipse.jetty.server.session.SessionHandler r0 = r0._handler     // Catch: Exception -> 0x0053, all -> 0x0079, Exception -> 0x0096
            r1 = r5
            r0.callSessionDestroyedListeners(r1)     // Catch: Exception -> 0x0053, all -> 0x0079, Exception -> 0x0096
            r0 = r5
            r0.finishInvalidate()     // Catch: Exception -> 0x0096
            r0 = r5
            org.eclipse.jetty.server.session.SessionHandler r0 = r0._handler     // Catch: Exception -> 0x0096
            org.eclipse.jetty.server.SessionIdManager r0 = r0.getSessionIdManager()     // Catch: Exception -> 0x0096
            r1 = r5
            org.eclipse.jetty.server.session.SessionData r1 = r1._sessionData     // Catch: Exception -> 0x0096
            java.lang.String r1 = r1.getId()     // Catch: Exception -> 0x0096
            r0.invalidateAll(r1)     // Catch: Exception -> 0x0096
            goto L_0x0093
        L_0x0053:
            r7 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG     // Catch: all -> 0x0079, Exception -> 0x0096
            java.lang.String r1 = "Error during Session destroy listener"
            r2 = r7
            r0.warn(r1, r2)     // Catch: all -> 0x0079, Exception -> 0x0096
            r0 = r5
            r0.finishInvalidate()     // Catch: Exception -> 0x0096
            r0 = r5
            org.eclipse.jetty.server.session.SessionHandler r0 = r0._handler     // Catch: Exception -> 0x0096
            org.eclipse.jetty.server.SessionIdManager r0 = r0.getSessionIdManager()     // Catch: Exception -> 0x0096
            r1 = r5
            org.eclipse.jetty.server.session.SessionData r1 = r1._sessionData     // Catch: Exception -> 0x0096
            java.lang.String r1 = r1.getId()     // Catch: Exception -> 0x0096
            r0.invalidateAll(r1)     // Catch: Exception -> 0x0096
            goto L_0x0093
        L_0x0079:
            r8 = move-exception
            r0 = r5
            r0.finishInvalidate()     // Catch: Exception -> 0x0096
            r0 = r5
            org.eclipse.jetty.server.session.SessionHandler r0 = r0._handler     // Catch: Exception -> 0x0096
            org.eclipse.jetty.server.SessionIdManager r0 = r0.getSessionIdManager()     // Catch: Exception -> 0x0096
            r1 = r5
            org.eclipse.jetty.server.session.SessionData r1 = r1._sessionData     // Catch: Exception -> 0x0096
            java.lang.String r1 = r1.getId()     // Catch: Exception -> 0x0096
            r0.invalidateAll(r1)     // Catch: Exception -> 0x0096
            r0 = r8
            throw r0     // Catch: Exception -> 0x0096
        L_0x0093:
            goto L_0x00a0
        L_0x0096:
            r7 = move-exception
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG
            r1 = r7
            r0.warn(r1)
        L_0x00a0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.invalidate():void");
    }

    public Locker.Lock lock() {
        return this._lock.lock();
    }

    /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
        jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:14:0x0091
        	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
        	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
        */
    protected boolean beginInvalidate() {
        /*
            r7 = this;
            r0 = 0
            r8 = r0
            r0 = r7
            org.eclipse.jetty.util.thread.Locker r0 = r0._lock
            org.eclipse.jetty.util.thread.Locker$Lock r0 = r0.lock()
            r9 = r0
        L_0x000a:
            int[] r0 = org.eclipse.jetty.server.session.Session.C57172.$SwitchMap$org$eclipse$jetty$server$session$Session$State     // Catch: Throwable -> 0x00ba
            r1 = r7
            org.eclipse.jetty.server.session.Session$State r1 = r1._state     // Catch: Throwable -> 0x00ba
            int r1 = r1.ordinal()     // Catch: Throwable -> 0x00ba
            r0 = r0[r1]     // Catch: Throwable -> 0x00ba
            switch(r0) {
                case 1: goto L_0x0034;
                case 2: goto L_0x003c;
                case 3: goto L_0x0062;
                case 4: goto L_0x009b;
                default: goto L_0x00a7;
            }     // Catch: Throwable -> 0x00ba
        L_0x0034:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: Throwable -> 0x00ba
            r1 = r0
            r1.<init>()     // Catch: Throwable -> 0x00ba
            throw r0     // Catch: Throwable -> 0x00ba
        L_0x003c:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG     // Catch: Throwable -> 0x00ba
            boolean r0 = r0.isDebugEnabled()     // Catch: Throwable -> 0x00ba
            if (r0 == 0) goto L_0x00af
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG     // Catch: Throwable -> 0x00ba
            java.lang.String r1 = "Session {} already being invalidated"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: Throwable -> 0x00ba
            r3 = r2
            r4 = 0
            r5 = r7
            org.eclipse.jetty.server.session.SessionData r5 = r5._sessionData     // Catch: Throwable -> 0x00ba
            java.lang.String r5 = r5.getId()     // Catch: Throwable -> 0x00ba
            r3[r4] = r5     // Catch: Throwable -> 0x00ba
            r0.debug(r1, r2)     // Catch: Throwable -> 0x00ba
            goto L_0x00af
        L_0x0062:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            boolean r0 = r0.isDebugEnabled()     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            if (r0 == 0) goto L_0x0085
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.session.Session.LOG     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            java.lang.String r1 = "Session {} waiting for id change to complete"
            r2 = 1
            java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            r3 = r2
            r4 = 0
            r5 = r7
            org.eclipse.jetty.server.session.SessionData r5 = r5._sessionData     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            java.lang.String r5 = r5.getId()     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            r3[r4] = r5     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            r0.debug(r1, r2)     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
        L_0x0085:
            r0 = r7
            java.util.concurrent.locks.Condition r0 = r0._stateChangeCompleted     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            r0.await()     // Catch: InterruptedException -> 0x0091, Throwable -> 0x00ba
            goto L_0x000a
        L_0x0091:
            r10 = move-exception
            java.lang.RuntimeException r0 = new java.lang.RuntimeException     // Catch: Throwable -> 0x00ba
            r1 = r0
            r2 = r10
            r1.<init>(r2)     // Catch: Throwable -> 0x00ba
            throw r0     // Catch: Throwable -> 0x00ba
        L_0x009b:
            r0 = 1
            r8 = r0
            r0 = r7
            org.eclipse.jetty.server.session.Session$State r1 = org.eclipse.jetty.server.session.Session.State.INVALIDATING     // Catch: Throwable -> 0x00ba
            r0._state = r1     // Catch: Throwable -> 0x00ba
            goto L_0x00af
        L_0x00a7:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException     // Catch: Throwable -> 0x00ba
            r1 = r0
            r1.<init>()     // Catch: Throwable -> 0x00ba
            throw r0     // Catch: Throwable -> 0x00ba
        L_0x00af:
            r0 = r9
            if (r0 == 0) goto L_0x00d0
            r0 = r9
            r0.close()
            goto L_0x00d0
        L_0x00ba:
            r10 = move-exception
            r0 = r9
            if (r0 == 0) goto L_0x00ce
            r0 = r9
            r0.close()     // Catch: Throwable -> 0x00c6
            goto L_0x00ce
        L_0x00c6:
            r11 = move-exception
            r0 = r10
            r1 = r11
            r0.addSuppressed(r1)
        L_0x00ce:
            r0 = r10
            throw r0
        L_0x00d0:
            r0 = r8
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.beginInvalidate():boolean");
    }

    @Deprecated
    protected void doInvalidate() throws IllegalStateException {
        finishInvalidate();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e4 A[ORIG_RETURN, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x00d5 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void finishInvalidate() throws java.lang.IllegalStateException {
        /*
        // Method dump skipped, instructions count: 229
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.Session.finishInvalidate():void");
    }

    @Override // javax.servlet.http.HttpSession
    public boolean isNew() throws IllegalStateException {
        Locker.Lock lock = this._lock.lock();
        try {
            checkValidForRead();
            boolean z = this._newSession;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public void setIdChanged(boolean changed) {
        Locker.Lock lock = this._lock.lock();
        try {
            this._idChanged = changed;
            if (lock != null) {
                lock.close();
            }
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    public boolean isIdChanged() {
        Locker.Lock lock = this._lock.lock();
        try {
            boolean z = this._idChanged;
            if (lock != null) {
                lock.close();
            }
            return z;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionHandler.SessionIf
    public Session getSession() {
        return this;
    }

    /* access modifiers changed from: protected */
    public SessionData getSessionData() {
        return this._sessionData;
    }

    public void setResident(boolean resident) {
        this._resident = resident;
        if (!this._resident) {
            this._sessionInactivityTimer.destroy();
        }
    }

    public boolean isResident() {
        return this._resident;
    }

    public String toString() {
        Locker.Lock lock = this._lock.lock();
        try {
            String format = String.format("%s@%x{id=%s,x=%s,req=%d,res=%b}", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._sessionData.getId(), this._extendedId, Long.valueOf(this._requests), Boolean.valueOf(this._resident));
            if (lock != null) {
                lock.close();
            }
            return format;
        } catch (Throwable th) {
            if (lock != null) {
                try {
                    lock.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
            }
            throw th;
        }
    }
}
