package org.eclipse.jetty.server.session;

import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/session/AbstractSessionDataStore.class */
public abstract class AbstractSessionDataStore extends ContainerLifeCycle implements SessionDataStore {
    static final Logger LOG = Log.getLogger("org.eclipse.jetty.server.session");
    protected SessionContext _context;
    protected int _gracePeriodSec = 3600;
    protected long _lastExpiryCheckTime = 0;
    protected int _savePeriodSec = 0;

    public abstract void doStore(String str, SessionData sessionData, long j) throws Exception;

    public abstract SessionData doLoad(String str) throws Exception;

    public abstract Set<String> doGetExpired(Set<String> set);

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public void initialize(SessionContext context) throws Exception {
        if (isStarted()) {
            throw new IllegalStateException("Context set after SessionDataStore started");
        }
        this._context = context;
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public SessionData load(String id) throws Exception {
        if (!isStarted()) {
            throw new IllegalStateException("Not started");
        }
        AtomicReference<SessionData> reference = new AtomicReference<>();
        AtomicReference<Exception> exception = new AtomicReference<>();
        this._context.run(()
        /*  JADX ERROR: Method code generation error
            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0032: INVOKE  
              (wrap: org.eclipse.jetty.server.session.SessionContext : 0x002d: IGET  (r0v7 org.eclipse.jetty.server.session.SessionContext A[REMOVE]) = 
              (r5v0 'this' org.eclipse.jetty.server.session.AbstractSessionDataStore A[D('this' org.eclipse.jetty.server.session.AbstractSessionDataStore), IMMUTABLE_TYPE, THIS])
             org.eclipse.jetty.server.session.AbstractSessionDataStore._context org.eclipse.jetty.server.session.SessionContext)
              (wrap: java.lang.Runnable : 0x0025: INVOKE_CUSTOM (r0v5 'r' java.lang.Runnable A[REMOVE]) = 
              (r5v0 'this' org.eclipse.jetty.server.session.AbstractSessionDataStore A[D('this' org.eclipse.jetty.server.session.AbstractSessionDataStore), DONT_INLINE, IMMUTABLE_TYPE, THIS])
              (r0v2 'reference' java.util.concurrent.atomic.AtomicReference<org.eclipse.jetty.server.session.SessionData> A[D('reference' java.util.concurrent.atomic.AtomicReference<org.eclipse.jetty.server.session.SessionData>), DONT_INLINE])
              (r6v0 'id' java.lang.String A[D('id' java.lang.String), DONT_INLINE])
              (r0v3 'exception' java.util.concurrent.atomic.AtomicReference<java.lang.Exception> A[D('exception' java.util.concurrent.atomic.AtomicReference<java.lang.Exception>), DONT_INLINE])
            
             handle type: INVOKE_DIRECT
             lambda: java.lang.Runnable.run():void
             call insn: ?: INVOKE  
              (r0 I:org.eclipse.jetty.server.session.AbstractSessionDataStore)
              (r1 I:java.util.concurrent.atomic.AtomicReference)
              (r2 I:java.lang.String)
              (r3 I:java.util.concurrent.atomic.AtomicReference)
             type: DIRECT call: org.eclipse.jetty.server.session.AbstractSessionDataStore.lambda$load$0(java.util.concurrent.atomic.AtomicReference, java.lang.String, java.util.concurrent.atomic.AtomicReference):void)
             type: VIRTUAL call: org.eclipse.jetty.server.session.SessionContext.run(java.lang.Runnable):void in method: org.eclipse.jetty.server.session.AbstractSessionDataStore.load(java.lang.String):org.eclipse.jetty.server.session.SessionData, file: grasscutter.jar:org/eclipse/jetty/server/session/AbstractSessionDataStore.class
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:285)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:248)
            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:105)
            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.dex.regions.Region.generate(Region.java:35)
            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:65)
            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:261)
            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:254)
            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:349)
            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:302)
            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$2(ClassGen.java:271)
            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:183)
            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1511)
            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:258)
            Caused by: java.lang.IndexOutOfBoundsException: Index 3 out of bounds for length 3
            	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
            	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
            	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:266)
            	at java.base/java.util.Objects.checkIndex(Objects.java:359)
            	at java.base/java.util.ArrayList.get(ArrayList.java:427)
            	at jadx.core.codegen.InsnGen.makeInlinedLambdaMethod(InsnGen.java:909)
            	at jadx.core.codegen.InsnGen.makeInvokeLambda(InsnGen.java:814)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:756)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:141)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:120)
            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:104)
            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:976)
            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:801)
            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:397)
            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:278)
            	... 19 more
            */
        /*
            this = this;
            r0 = r5
            boolean r0 = r0.isStarted()
            if (r0 != 0) goto L_0x0011
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            r1 = r0
            java.lang.String r2 = "Not started"
            r1.<init>(r2)
            throw r0
        L_0x0011:
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r1 = r0
            r1.<init>()
            r7 = r0
            java.util.concurrent.atomic.AtomicReference r0 = new java.util.concurrent.atomic.AtomicReference
            r1 = r0
            r1.<init>()
            r8 = r0
            r0 = r5
            r1 = r7
            r2 = r6
            r3 = r8
            org.eclipse.jetty.server.session.SessionData r0 = () -> { // java.lang.Runnable.run():void
                r0.lambda$load$0(r1, r2, r3);
            }
            r9 = r0
            r0 = r5
            org.eclipse.jetty.server.session.SessionContext r0 = r0._context
            r1 = r9
            r0.run(r1)
            r0 = r8
            java.lang.Object r0 = r0.get()
            if (r0 == 0) goto L_0x0044
            r0 = r8
            java.lang.Object r0 = r0.get()
            java.lang.Exception r0 = (java.lang.Exception) r0
            throw r0
        L_0x0044:
            r0 = r7
            java.lang.Object r0 = r0.get()
            org.eclipse.jetty.server.session.SessionData r0 = (org.eclipse.jetty.server.session.SessionData) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.session.AbstractSessionDataStore.load(java.lang.String):org.eclipse.jetty.server.session.SessionData");
    }

    @Override // org.eclipse.jetty.server.session.SessionDataMap
    public void store(final String id, final SessionData data) throws Exception {
        if (!isStarted()) {
            throw new IllegalStateException("Not started");
        } else if (data != null) {
            final AtomicReference<Exception> exception = new AtomicReference<>();
            this._context.run(new Runnable() { // from class: org.eclipse.jetty.server.session.AbstractSessionDataStore.1
                @Override // java.lang.Runnable
                public void run() {
                    long lastSave = data.getLastSaved();
                    long savePeriodMs = AbstractSessionDataStore.this._savePeriodSec <= 0 ? 0 : TimeUnit.SECONDS.toMillis((long) AbstractSessionDataStore.this._savePeriodSec);
                    if (AbstractSessionDataStore.LOG.isDebugEnabled()) {
                        AbstractSessionDataStore.LOG.debug("Store: id={}, mdirty={}, dirty={}, lsave={}, period={}, elapsed={}", id, Boolean.valueOf(data.isMetaDataDirty()), Boolean.valueOf(data.isDirty()), Long.valueOf(data.getLastSaved()), Long.valueOf(savePeriodMs), Long.valueOf(System.currentTimeMillis() - lastSave));
                    }
                    if (data.isDirty() || lastSave <= 0 || (data.isMetaDataDirty() && System.currentTimeMillis() - lastSave >= savePeriodMs)) {
                        data.setLastSaved(System.currentTimeMillis());
                        try {
                            AbstractSessionDataStore.this.doStore(id, data, lastSave);
                            data.clean();
                        } catch (Exception e) {
                            data.setLastSaved(lastSave);
                            exception.set(e);
                        }
                    }
                }
            });
            if (exception.get() != null) {
                throw exception.get();
            }
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public Set<String> getExpired(Set<String> candidates) {
        if (!isStarted()) {
            throw new IllegalStateException("Not started");
        }
        try {
            return doGetExpired(candidates);
        } finally {
            this._lastExpiryCheckTime = System.currentTimeMillis();
        }
    }

    @Override // org.eclipse.jetty.server.session.SessionDataStore
    public SessionData newSessionData(String id, long created, long accessed, long lastAccessed, long maxInactiveMs) {
        return new SessionData(id, this._context.getCanonicalContextPath(), this._context.getVhost(), created, accessed, lastAccessed, maxInactiveMs);
    }

    protected void checkStarted() throws IllegalStateException {
        if (isStarted()) {
            throw new IllegalStateException("Already started");
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        if (this._context == null) {
            throw new IllegalStateException("No SessionContext");
        }
        doStart();
    }

    @ManagedAttribute(value = "interval in secs to prevent too eager session scavenging", readonly = true)
    public int getGracePeriodSec() {
        return this._gracePeriodSec;
    }

    public void setGracePeriodSec(int sec) {
        this._gracePeriodSec = sec;
    }

    @ManagedAttribute(value = "min secs between saves", readonly = true)
    public int getSavePeriodSec() {
        return this._savePeriodSec;
    }

    public void setSavePeriodSec(int savePeriodSec) {
        this._savePeriodSec = savePeriodSec;
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x[passivating=%b,graceSec=%d]", getClass().getName(), Integer.valueOf(hashCode()), Boolean.valueOf(isPassivating()), Integer.valueOf(getGracePeriodSec()));
    }
}
