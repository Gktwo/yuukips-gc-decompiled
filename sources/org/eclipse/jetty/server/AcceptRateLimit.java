package org.eclipse.jetty.server;

import java.nio.channels.SelectableChannel;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.eclipse.jetty.p023io.SelectorManager;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.annotation.Name;
import org.eclipse.jetty.util.component.AbstractLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.RateStatistic;
import org.eclipse.jetty.util.thread.Scheduler;

@ManagedObject
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/AcceptRateLimit.class */
public class AcceptRateLimit extends AbstractLifeCycle implements SelectorManager.AcceptListener, Runnable {
    private static final Logger LOG = Log.getLogger(AcceptRateLimit.class);
    private final Server _server;
    private final List<AbstractConnector> _connectors;
    private final Rate _rate;
    private final int _acceptRateLimit;
    private boolean _limiting;
    private Scheduler.Task _task;

    public AcceptRateLimit(@Name("acceptRateLimit") int acceptRateLimit, @Name("period") long period, @Name("units") TimeUnit units, @Name("server") Server server) {
        this._connectors = new ArrayList();
        this._server = server;
        this._acceptRateLimit = acceptRateLimit;
        this._rate = new Rate(period, units);
    }

    public AcceptRateLimit(@Name("limit") int limit, @Name("period") long period, @Name("units") TimeUnit units, @Name("connectors") Connector... connectors) {
        this(limit, period, units, (Server) null);
        for (Connector c : connectors) {
            if (c instanceof AbstractConnector) {
                this._connectors.add((AbstractConnector) c);
            } else {
                LOG.warn("Connector {} is not an AbstractConnector. Connections not limited", c);
            }
        }
    }

    @ManagedAttribute("The accept rate limit")
    public int getAcceptRateLimit() {
        return this._acceptRateLimit;
    }

    @ManagedAttribute("The accept rate period")
    public long getPeriod() {
        return this._rate.getPeriod();
    }

    @ManagedAttribute("The accept rate period units")
    public TimeUnit getUnits() {
        return this._rate.getUnits();
    }

    @ManagedAttribute("The current accept rate")
    public int getRate() {
        return this._rate.getRate();
    }

    @ManagedAttribute("The maximum accept rate achieved")
    public long getMaxRate() {
        return this._rate.getMax();
    }

    @ManagedOperation(value = "Resets the accept rate", impact = "ACTION")
    public void reset() {
        synchronized (this._rate) {
            this._rate.reset();
            if (this._limiting) {
                this._limiting = false;
                unlimit();
            }
        }
    }

    protected void age(long period, TimeUnit units) {
        this._rate.age(period, units);
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStart() throws Exception {
        synchronized (this._rate) {
            if (this._server != null) {
                Connector[] connectors = this._server.getConnectors();
                for (Connector c : connectors) {
                    if (c instanceof AbstractConnector) {
                        this._connectors.add((AbstractConnector) c);
                    } else {
                        LOG.warn("Connector {} is not an AbstractConnector. Connections not limited", c);
                    }
                }
            }
            if (LOG.isDebugEnabled()) {
                LOG.debug("AcceptLimit accept<{} rate<{} in {} for {}", Integer.valueOf(this._acceptRateLimit), this._rate, this._connectors);
            }
            for (AbstractConnector c2 : this._connectors) {
                c2.addBean(this);
            }
        }
    }

    /* access modifiers changed from: protected */
    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle
    public void doStop() throws Exception {
        synchronized (this._rate) {
            if (this._task != null) {
                this._task.cancel();
            }
            this._task = null;
            for (AbstractConnector c : this._connectors) {
                c.removeBean(this);
            }
            if (this._server != null) {
                this._connectors.clear();
            }
            this._limiting = false;
        }
    }

    protected void limit() {
        for (AbstractConnector c : this._connectors) {
            c.setAccepting(false);
        }
        schedule();
    }

    protected void unlimit() {
        for (AbstractConnector c : this._connectors) {
            c.setAccepting(true);
        }
    }

    @Override // org.eclipse.jetty.p023io.SelectorManager.AcceptListener
    public void onAccepting(SelectableChannel channel) {
        synchronized (this._rate) {
            int rate = this._rate.record();
            if (LOG.isDebugEnabled()) {
                LOG.debug("onAccepting rate {}/{} for {} {}", Integer.valueOf(rate), Integer.valueOf(this._acceptRateLimit), this._rate, channel);
            }
            if (rate > this._acceptRateLimit && !this._limiting) {
                this._limiting = true;
                LOG.warn("AcceptLimit rate exceeded {}>{} on {}", Integer.valueOf(rate), Integer.valueOf(this._acceptRateLimit), this._connectors);
                limit();
            }
        }
    }

    /* JADX WARN: Type inference failed for: r0v2, types: [long] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r0v6, types: [long] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void schedule() {
        /*
            r8 = this;
            r0 = r8
            org.eclipse.jetty.server.AcceptRateLimit$Rate r0 = r0._rate
            java.util.concurrent.TimeUnit r1 = java.util.concurrent.TimeUnit.MILLISECONDS
            long r0 = r0.getOldest(r1)
            r9 = r0
            java.util.concurrent.TimeUnit r0 = java.util.concurrent.TimeUnit.MILLISECONDS
            r1 = r8
            org.eclipse.jetty.server.AcceptRateLimit$Rate r1 = r1._rate
            long r1 = r1.getPeriod()
            r2 = r8
            org.eclipse.jetty.server.AcceptRateLimit$Rate r2 = r2._rate
            java.util.concurrent.TimeUnit r2 = r2.getUnits()
            long r0 = r0.convert(r1, r2)
            r11 = r0
            r0 = r11
            r1 = r9
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x002b
            r1 = r9
            goto L_0x002c
        L_0x002b:
            r1 = 0
        L_0x002c:
            long r0 = r0 - r1
            r13 = r0
            r0 = r13
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r0 >= 0) goto L_0x0039
            r0 = 0
            r13 = r0
        L_0x0039:
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.AcceptRateLimit.LOG
            boolean r0 = r0.isDebugEnabled()
            if (r0 == 0) goto L_0x0060
            org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.server.AcceptRateLimit.LOG
            java.lang.String r1 = "schedule {} {}"
            r2 = 2
            java.lang.Object[] r2 = new java.lang.Object[r2]
            r3 = r2
            r4 = 0
            r5 = r13
            java.lang.Long r5 = java.lang.Long.valueOf(r5)
            r3[r4] = r5
            r3 = r2
            r4 = 1
            java.util.concurrent.TimeUnit r5 = java.util.concurrent.TimeUnit.MILLISECONDS
            r3[r4] = r5
            r0.debug(r1, r2)
        L_0x0060:
            r0 = r8
            r1 = r8
            java.util.List<org.eclipse.jetty.server.AbstractConnector> r1 = r1._connectors
            r2 = 0
            java.lang.Object r1 = r1.get(r2)
            org.eclipse.jetty.server.AbstractConnector r1 = (org.eclipse.jetty.server.AbstractConnector) r1
            org.eclipse.jetty.util.thread.Scheduler r1 = r1.getScheduler()
            r2 = r8
            r3 = r13
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS
            org.eclipse.jetty.util.thread.Scheduler$Task r1 = r1.schedule(r2, r3, r4)
            r0._task = r1
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.server.AcceptRateLimit.schedule():void");
    }

    @Override // java.lang.Runnable
    public void run() {
        synchronized (this._rate) {
            this._task = null;
            if (isRunning()) {
                int rate = this._rate.getRate();
                if (rate > this._acceptRateLimit) {
                    schedule();
                    return;
                }
                if (this._limiting) {
                    this._limiting = false;
                    LOG.warn("AcceptLimit rate OK {}<={} on {}", Integer.valueOf(rate), Integer.valueOf(this._acceptRateLimit), this._connectors);
                    unlimit();
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/AcceptRateLimit$Rate.class */
    public final class Rate extends RateStatistic {
        private Rate(long period, TimeUnit units) {
            super(period, units);
        }

        /* access modifiers changed from: protected */
        @Override // org.eclipse.jetty.util.statistic.RateStatistic
        public void age(long period, TimeUnit units) {
            age(period, units);
        }
    }
}
