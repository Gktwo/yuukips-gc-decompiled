package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.AsyncContextEvent;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HttpChannelState;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.Response;
import org.eclipse.jetty.util.FutureCallback;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.Graceful;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.statistic.CounterStatistic;
import org.eclipse.jetty.util.statistic.SampleStatistic;

@ManagedObject("Request Statistics Gathering")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/StatisticsHandler.class */
public class StatisticsHandler extends HandlerWrapper implements Graceful {
    private static final Logger LOG = Log.getLogger(StatisticsHandler.class);
    private final AtomicLong _statsStartedAt = new AtomicLong();
    private final CounterStatistic _requestStats = new CounterStatistic();
    private final SampleStatistic _requestTimeStats = new SampleStatistic();
    private final CounterStatistic _dispatchedStats = new CounterStatistic();
    private final SampleStatistic _dispatchedTimeStats = new SampleStatistic();
    private final CounterStatistic _asyncWaitStats = new CounterStatistic();
    private final LongAdder _asyncDispatches = new LongAdder();
    private final LongAdder _expires = new LongAdder();
    private final LongAdder _errors = new LongAdder();
    private final LongAdder _responsesThrown = new LongAdder();
    private final LongAdder _responses1xx = new LongAdder();
    private final LongAdder _responses2xx = new LongAdder();
    private final LongAdder _responses3xx = new LongAdder();
    private final LongAdder _responses4xx = new LongAdder();
    private final LongAdder _responses5xx = new LongAdder();
    private final LongAdder _responsesTotalBytes = new LongAdder();
    private boolean _gracefulShutdownWaitsForRequests = true;
    private final Graceful.Shutdown _shutdown = new Graceful.Shutdown() { // from class: org.eclipse.jetty.server.handler.StatisticsHandler.1
        @Override // org.eclipse.jetty.util.component.Graceful.Shutdown
        protected FutureCallback newShutdownCallback() {
            return new FutureCallback(StatisticsHandler.this._requestStats.getCurrent() == 0);
        }
    };
    private final AsyncListener _onCompletion = new AsyncListener() { // from class: org.eclipse.jetty.server.handler.StatisticsHandler.2
        @Override // javax.servlet.AsyncListener
        public void onStartAsync(AsyncEvent event) {
            event.getAsyncContext().addListener(this);
        }

        @Override // javax.servlet.AsyncListener
        public void onTimeout(AsyncEvent event) {
            StatisticsHandler.this._expires.increment();
        }

        @Override // javax.servlet.AsyncListener
        public void onError(AsyncEvent event) {
            StatisticsHandler.this._errors.increment();
        }

        @Override // javax.servlet.AsyncListener
        public void onComplete(AsyncEvent event) {
            FutureCallback shutdown;
            Request request = ((AsyncContextEvent) event).getHttpChannelState().getBaseRequest();
            long elapsed = System.currentTimeMillis() - request.getTimeStamp();
            long numRequests = StatisticsHandler.this._requestStats.decrement();
            StatisticsHandler.this._requestTimeStats.record(elapsed);
            StatisticsHandler.this.updateResponse(request, false);
            StatisticsHandler.this._asyncWaitStats.decrement();
            if (numRequests == 0 && StatisticsHandler.this._gracefulShutdownWaitsForRequests && (shutdown = StatisticsHandler.this._shutdown.get()) != null) {
                shutdown.succeeded();
            }
        }
    };

    @ManagedOperation(value = "resets statistics", impact = "ACTION")
    public void statsReset() {
        this._statsStartedAt.set(System.currentTimeMillis());
        this._requestStats.reset();
        this._requestTimeStats.reset();
        this._dispatchedStats.reset();
        this._dispatchedTimeStats.reset();
        this._asyncWaitStats.reset();
        this._asyncDispatches.reset();
        this._expires.reset();
        this._responses1xx.reset();
        this._responses2xx.reset();
        this._responses3xx.reset();
        this._responses4xx.reset();
        this._responses5xx.reset();
        this._responsesTotalBytes.reset();
    }

    /* JADX WARN: Type inference failed for: r0v91, types: [long] */
    /* JADX WARN: Type inference failed for: r0v98, types: [long] */
    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String path, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        char c;
        Handler handler = getHandler();
        if (handler != null && isStarted() && !isShutdown()) {
            this._dispatchedStats.increment();
            HttpChannelState state = baseRequest.getHttpChannelState();
            if (state.isInitial()) {
                this._requestStats.increment();
                c = baseRequest.getTimeStamp();
            } else {
                c = System.currentTimeMillis();
                this._asyncDispatches.increment();
            }
            try {
                handler.handle(path, baseRequest, request, response);
                long dispatched = System.currentTimeMillis() - c;
                char c2 = 65535;
                long numDispatches = this._dispatchedStats.decrement();
                this._dispatchedTimeStats.record(dispatched);
                long numRequests = c2;
                if (state.isInitial()) {
                    if (state.isAsyncStarted()) {
                        state.addListener(this._onCompletion);
                        this._asyncWaitStats.increment();
                        numRequests = c2;
                    } else {
                        long numRequests2 = this._requestStats.decrement();
                        this._requestTimeStats.record(dispatched);
                        updateResponse(baseRequest, false);
                        numRequests = numRequests2;
                    }
                }
                FutureCallback shutdown = this._shutdown.get();
                if (shutdown != null) {
                    response.flushBuffer();
                    if (this._gracefulShutdownWaitsForRequests) {
                        if ((numRequests == 1 ? 1 : 0) != 0) {
                            return;
                        }
                    } else if (numDispatches != 0) {
                        return;
                    }
                    shutdown.succeeded();
                }
            } catch (Throwable th) {
                long dispatched2 = System.currentTimeMillis() - c;
                char c3 = 65535;
                long numDispatches2 = this._dispatchedStats.decrement();
                this._dispatchedTimeStats.record(dispatched2);
                long numRequests3 = c3;
                if (state.isInitial()) {
                    if (state.isAsyncStarted()) {
                        state.addListener(this._onCompletion);
                        this._asyncWaitStats.increment();
                        numRequests3 = c3;
                    } else {
                        long numRequests4 = this._requestStats.decrement();
                        this._requestTimeStats.record(dispatched2);
                        updateResponse(baseRequest, false);
                        numRequests3 = numRequests4;
                    }
                }
                FutureCallback shutdown2 = this._shutdown.get();
                if (shutdown2 != null) {
                    response.flushBuffer();
                    if (!this._gracefulShutdownWaitsForRequests ? numDispatches2 == 0 : (numRequests3 == 1 ? 1 : 0) == 0) {
                        shutdown2.succeeded();
                    }
                }
                throw th;
            }
        } else if (!baseRequest.getResponse().isCommitted()) {
            response.sendError(503);
        }
    }

    protected void updateResponse(Request request, boolean thrownError) {
        Response response = request.getResponse();
        if (thrownError) {
            this._responsesThrown.increment();
        } else if (request.isHandled()) {
            switch (response.getStatus() / 100) {
                case 1:
                    this._responses1xx.increment();
                    break;
                case 2:
                    this._responses2xx.increment();
                    break;
                case 3:
                    this._responses3xx.increment();
                    break;
                case 4:
                    this._responses4xx.increment();
                    break;
                case 5:
                    this._responses5xx.increment();
                    break;
            }
        } else {
            this._responses4xx.increment();
        }
        this._responsesTotalBytes.add(response.getContentCount());
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStart() throws Exception {
        if (getHandler() == null) {
            throw new IllegalStateException("StatisticsHandler has no Wrapped Handler");
        }
        this._shutdown.cancel();
        doStart();
        statsReset();
    }

    @Override // org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.AbstractLifeCycle
    protected void doStop() throws Exception {
        this._shutdown.cancel();
        doStop();
    }

    public void setGracefulShutdownWaitsForRequests(boolean gracefulShutdownWaitsForRequests) {
        this._gracefulShutdownWaitsForRequests = gracefulShutdownWaitsForRequests;
    }

    @ManagedAttribute("if graceful shutdown will wait for all requests")
    public boolean getGracefulShutdownWaitsForRequests() {
        return this._gracefulShutdownWaitsForRequests;
    }

    @ManagedAttribute("number of requests")
    public int getRequests() {
        return (int) this._requestStats.getTotal();
    }

    @ManagedAttribute("number of requests currently active")
    public int getRequestsActive() {
        return (int) this._requestStats.getCurrent();
    }

    @ManagedAttribute("maximum number of active requests")
    public int getRequestsActiveMax() {
        return (int) this._requestStats.getMax();
    }

    @ManagedAttribute("maximum time spend handling requests (in ms)")
    public long getRequestTimeMax() {
        return this._requestTimeStats.getMax();
    }

    @ManagedAttribute("total time spend in all request handling (in ms)")
    public long getRequestTimeTotal() {
        return this._requestTimeStats.getTotal();
    }

    @ManagedAttribute("mean time spent handling requests (in ms)")
    public double getRequestTimeMean() {
        return this._requestTimeStats.getMean();
    }

    @ManagedAttribute("standard deviation for request handling (in ms)")
    public double getRequestTimeStdDev() {
        return this._requestTimeStats.getStdDev();
    }

    @ManagedAttribute("number of dispatches")
    public int getDispatched() {
        return (int) this._dispatchedStats.getTotal();
    }

    @ManagedAttribute("number of dispatches currently active")
    public int getDispatchedActive() {
        return (int) this._dispatchedStats.getCurrent();
    }

    @ManagedAttribute("maximum number of active dispatches being handled")
    public int getDispatchedActiveMax() {
        return (int) this._dispatchedStats.getMax();
    }

    @ManagedAttribute("maximum time spend in dispatch handling")
    public long getDispatchedTimeMax() {
        return this._dispatchedTimeStats.getMax();
    }

    @ManagedAttribute("total time spent in dispatch handling (in ms)")
    public long getDispatchedTimeTotal() {
        return this._dispatchedTimeStats.getTotal();
    }

    @ManagedAttribute("mean time spent in dispatch handling (in ms)")
    public double getDispatchedTimeMean() {
        return this._dispatchedTimeStats.getMean();
    }

    @ManagedAttribute("standard deviation for dispatch handling (in ms)")
    public double getDispatchedTimeStdDev() {
        return this._dispatchedTimeStats.getStdDev();
    }

    @ManagedAttribute("total number of async requests")
    public int getAsyncRequests() {
        return (int) this._asyncWaitStats.getTotal();
    }

    @ManagedAttribute("currently waiting async requests")
    public int getAsyncRequestsWaiting() {
        return (int) this._asyncWaitStats.getCurrent();
    }

    @ManagedAttribute("maximum number of waiting async requests")
    public int getAsyncRequestsWaitingMax() {
        return (int) this._asyncWaitStats.getMax();
    }

    @ManagedAttribute("number of requested that have been asynchronously dispatched")
    public int getAsyncDispatches() {
        return this._asyncDispatches.intValue();
    }

    @ManagedAttribute("number of async requests requests that have expired")
    public int getExpires() {
        return this._expires.intValue();
    }

    @ManagedAttribute("number of async errors that occurred")
    public int getErrors() {
        return this._errors.intValue();
    }

    @ManagedAttribute("number of requests with 1xx response status")
    public int getResponses1xx() {
        return this._responses1xx.intValue();
    }

    @ManagedAttribute("number of requests with 2xx response status")
    public int getResponses2xx() {
        return this._responses2xx.intValue();
    }

    @ManagedAttribute("number of requests with 3xx response status")
    public int getResponses3xx() {
        return this._responses3xx.intValue();
    }

    @ManagedAttribute("number of requests with 4xx response status")
    public int getResponses4xx() {
        return this._responses4xx.intValue();
    }

    @ManagedAttribute("number of requests with 5xx response status")
    public int getResponses5xx() {
        return this._responses5xx.intValue();
    }

    @ManagedAttribute("number of requests that threw an exception during handling")
    public int getResponsesThrown() {
        return this._responsesThrown.intValue();
    }

    @ManagedAttribute("time in milliseconds stats have been collected for")
    public long getStatsOnMs() {
        return System.currentTimeMillis() - this._statsStartedAt.get();
    }

    @ManagedAttribute("total number of bytes across all responses")
    public long getResponsesBytesTotal() {
        return this._responsesTotalBytes.longValue();
    }

    public String toStatsHTML() {
        StringBuilder sb = new StringBuilder();
        sb.append("<h1>Statistics:</h1>\n");
        sb.append("Statistics gathering started ").append(getStatsOnMs()).append("ms ago").append("<br />\n");
        sb.append("<h2>Requests:</h2>\n");
        sb.append("Total requests: ").append(getRequests()).append("<br />\n");
        sb.append("Active requests: ").append(getRequestsActive()).append("<br />\n");
        sb.append("Max active requests: ").append(getRequestsActiveMax()).append("<br />\n");
        sb.append("Total requests time: ").append(getRequestTimeTotal()).append("<br />\n");
        sb.append("Mean request time: ").append(getRequestTimeMean()).append("<br />\n");
        sb.append("Max request time: ").append(getRequestTimeMax()).append("<br />\n");
        sb.append("Request time standard deviation: ").append(getRequestTimeStdDev()).append("<br />\n");
        sb.append("<h2>Dispatches:</h2>\n");
        sb.append("Total dispatched: ").append(getDispatched()).append("<br />\n");
        sb.append("Active dispatched: ").append(getDispatchedActive()).append("<br />\n");
        sb.append("Max active dispatched: ").append(getDispatchedActiveMax()).append("<br />\n");
        sb.append("Total dispatched time: ").append(getDispatchedTimeTotal()).append("<br />\n");
        sb.append("Mean dispatched time: ").append(getDispatchedTimeMean()).append("<br />\n");
        sb.append("Max dispatched time: ").append(getDispatchedTimeMax()).append("<br />\n");
        sb.append("Dispatched time standard deviation: ").append(getDispatchedTimeStdDev()).append("<br />\n");
        sb.append("Total requests suspended: ").append(getAsyncRequests()).append("<br />\n");
        sb.append("Total requests expired: ").append(getExpires()).append("<br />\n");
        sb.append("Total requests resumed: ").append(getAsyncDispatches()).append("<br />\n");
        sb.append("<h2>Responses:</h2>\n");
        sb.append("1xx responses: ").append(getResponses1xx()).append("<br />\n");
        sb.append("2xx responses: ").append(getResponses2xx()).append("<br />\n");
        sb.append("3xx responses: ").append(getResponses3xx()).append("<br />\n");
        sb.append("4xx responses: ").append(getResponses4xx()).append("<br />\n");
        sb.append("5xx responses: ").append(getResponses5xx()).append("<br />\n");
        sb.append("responses thrown: ").append(getResponsesThrown()).append("<br />\n");
        sb.append("Bytes sent total: ").append(getResponsesBytesTotal()).append("<br />\n");
        return sb.toString();
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    public Future<Void> shutdown() {
        return this._shutdown.shutdown();
    }

    @Override // org.eclipse.jetty.util.component.Graceful
    public boolean isShutdown() {
        return this._shutdown.isShutdown();
    }

    @Override // org.eclipse.jetty.util.component.AbstractLifeCycle, java.lang.Object
    public String toString() {
        return String.format("%s@%x{%s,r=%d,d=%d}", getClass().getSimpleName(), Integer.valueOf(hashCode()), getState(), Long.valueOf(this._requestStats.getCurrent()), Long.valueOf(this._dispatchedStats.getCurrent()));
    }
}
