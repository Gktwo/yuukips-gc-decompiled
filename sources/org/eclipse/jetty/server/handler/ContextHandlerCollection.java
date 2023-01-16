package org.eclipse.jetty.server.handler;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.server.Handler;
import org.eclipse.jetty.server.HandlerContainer;
import org.eclipse.jetty.server.HttpChannelState;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.server.handler.HandlerCollection;
import org.eclipse.jetty.util.ArrayTernaryTrie;
import org.eclipse.jetty.util.ArrayUtil;
import org.eclipse.jetty.util.Callback;
import org.eclipse.jetty.util.Trie;
import org.eclipse.jetty.util.annotation.ManagedObject;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.thread.SerializedExecutor;

@ManagedObject("Context Handler Collection")
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandlerCollection.class */
public class ContextHandlerCollection extends HandlerCollection {
    private static final Logger LOG = Log.getLogger(ContextHandlerCollection.class);
    private final SerializedExecutor _serializedExecutor = new SerializedExecutor();
    @Deprecated
    private Class<? extends ContextHandler> _contextClass = ContextHandler.class;

    public ContextHandlerCollection() {
        super(true, new Handler[0]);
    }

    public ContextHandlerCollection(ContextHandler... contexts) {
        super(true, new Handler[0]);
        setHandlers(contexts);
    }

    @ManagedOperation("Update the mapping of context path to context")
    public void mapContexts() {
        this._serializedExecutor.execute(() -> {
            HandlerCollection.Handlers handlers;
            do {
                handlers = (HandlerCollection.Handlers) this._handlers.get();
                if (handlers == null) {
                    return;
                }
            } while (!updateHandlers(handlers, newHandlers(handlers.getHandlers())));
        });
    }

    @Override // org.eclipse.jetty.server.handler.HandlerCollection
    protected HandlerCollection.Handlers newHandlers(Handler[] handlers) {
        Mapping mapping;
        if (handlers == null || handlers.length == 0) {
            return null;
        }
        Map<String, Branch[]> path2Branches = new HashMap<>();
        for (Handler handler : handlers) {
            Branch branch = new Branch(handler);
            for (String contextPath : branch.getContextPaths()) {
                path2Branches.put(contextPath, (Branch[]) ArrayUtil.addToArray(path2Branches.get(contextPath), branch, Branch.class));
            }
        }
        for (Map.Entry<String, Branch[]> entry : path2Branches.entrySet()) {
            Branch[] branches = entry.getValue();
            Branch[] sorted = new Branch[branches.length];
            int i = 0;
            for (Branch branch2 : branches) {
                if (branch2.hasVirtualHost()) {
                    i++;
                    sorted[i] = branch2;
                }
            }
            for (Branch branch3 : branches) {
                if (!branch3.hasVirtualHost()) {
                    i++;
                    sorted[i] = branch3;
                }
            }
            entry.setValue(sorted);
        }
        int capacity = 512;
        loop5: while (true) {
            mapping = new Mapping(handlers, capacity);
            for (Map.Entry<String, Branch[]> entry2 : path2Branches.entrySet()) {
                if (!mapping._pathBranches.put(entry2.getKey().substring(1), entry2)) {
                    break;
                }
            }
            capacity += 512;
        }
        if (LOG.isDebugEnabled()) {
            for (String ctx : mapping._pathBranches.keySet()) {
                LOG.debug("{}->{}", ctx, Arrays.asList((Branch[]) ((Map.Entry) mapping._pathBranches.get(ctx)).getValue()));
            }
        }
        for (Branch[] branches2 : path2Branches.values()) {
            for (Branch branch4 : branches2) {
                for (ContextHandler context : branch4.getContextHandlers()) {
                    mapping._contextBranches.put(context, branch4.getHandler());
                }
            }
        }
        return mapping;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerCollection, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Handler[] handlers;
        Map.Entry<String, Branch[]> branches;
        ContextHandler context;
        Mapping mapping = (Mapping) this._handlers.get();
        if (mapping != null && (handlers = mapping.getHandlers()) != null && handlers.length != 0) {
            if (handlers.length == 1) {
                handlers[0].handle(target, baseRequest, request, response);
                return;
            }
            HttpChannelState async = baseRequest.getHttpChannelState();
            if (async.isAsync() && (context = async.getContextHandler()) != null) {
                Handler branch = (Handler) mapping._contextBranches.get(context);
                if (branch == null) {
                    context.handle(target, baseRequest, request, response);
                } else {
                    branch.handle(target, baseRequest, request, response);
                }
            } else if (target.startsWith("/")) {
                Trie<Map.Entry<String, Branch[]>> pathBranches = mapping._pathBranches;
                if (pathBranches != null) {
                    int length = target.length();
                    int i = 1;
                    while (true) {
                        int limit = length - i;
                        if (limit >= 0 && (branches = pathBranches.getBest(target, 1, limit)) != null) {
                            int l = branches.getKey().length();
                            if (l == 1 || target.length() == l || target.charAt(l) == '/') {
                                for (Branch branch2 : branches.getValue()) {
                                    branch2.getHandler().handle(target, baseRequest, request, response);
                                    if (baseRequest.isHandled()) {
                                        return;
                                    }
                                }
                                continue;
                            }
                            length = l;
                            i = 2;
                        } else {
                            return;
                        }
                    }
                }
            } else {
                for (Handler handler : handlers) {
                    handler.handle(target, baseRequest, request, response);
                    if (baseRequest.isHandled()) {
                        return;
                    }
                }
            }
        }
    }

    @Deprecated
    public ContextHandler addContext(String contextPath, String resourceBase) {
        try {
            ContextHandler context = (ContextHandler) this._contextClass.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            context.setContextPath(contextPath);
            context.setResourceBase(resourceBase);
            addHandler(context);
            return context;
        } catch (Exception e) {
            LOG.debug(e);
            throw new Error(e);
        }
    }

    public void deployHandler(final Handler handler, final Callback callback) {
        if (handler.getServer() != getServer()) {
            handler.setServer(getServer());
        }
        this._serializedExecutor.execute(new SerializedExecutor.ErrorHandlingTask() { // from class: org.eclipse.jetty.server.handler.ContextHandlerCollection.1
            @Override // java.lang.Runnable
            public void run() {
                ContextHandlerCollection.this.addHandler(handler);
                callback.succeeded();
            }

            public void accept(Throwable throwable) {
                callback.failed(throwable);
            }
        });
    }

    public void undeployHandler(final Handler handler, final Callback callback) {
        this._serializedExecutor.execute(new SerializedExecutor.ErrorHandlingTask() { // from class: org.eclipse.jetty.server.handler.ContextHandlerCollection.2
            @Override // java.lang.Runnable
            public void run() {
                ContextHandlerCollection.this.removeHandler(handler);
                callback.succeeded();
            }

            public void accept(Throwable throwable) {
                callback.failed(throwable);
            }
        });
    }

    @Deprecated
    public Class<?> getContextClass() {
        return this._contextClass;
    }

    @Deprecated
    public void setContextClass(Class<? extends ContextHandler> contextClass) {
        if (contextClass == null || !ContextHandler.class.isAssignableFrom(contextClass)) {
            throw new IllegalArgumentException();
        }
        this._contextClass = contextClass;
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandlerCollection$Branch.class */
    public static final class Branch {
        private final Handler _handler;
        private final ContextHandler[] _contexts;

        Branch(Handler handler) {
            this._handler = handler;
            if (handler instanceof ContextHandler) {
                this._contexts = new ContextHandler[]{(ContextHandler) handler};
            } else if (handler instanceof HandlerContainer) {
                Handler[] contexts = ((HandlerContainer) handler).getChildHandlersByClass(ContextHandler.class);
                this._contexts = new ContextHandler[contexts.length];
                System.arraycopy(contexts, 0, this._contexts, 0, contexts.length);
            } else {
                this._contexts = new ContextHandler[0];
            }
        }

        Set<String> getContextPaths() {
            Set<String> set = new HashSet<>();
            for (ContextHandler context : this._contexts) {
                set.add(context.getContextPath());
            }
            return set;
        }

        boolean hasVirtualHost() {
            ContextHandler[] contextHandlerArr = this._contexts;
            for (ContextHandler context : contextHandlerArr) {
                if (context.getVirtualHosts() != null && context.getVirtualHosts().length > 0) {
                    return true;
                }
            }
            return false;
        }

        ContextHandler[] getContextHandlers() {
            return this._contexts;
        }

        Handler getHandler() {
            return this._handler;
        }

        public String toString() {
            return String.format("{%s,%s}", this._handler, Arrays.asList(this._contexts));
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/ContextHandlerCollection$Mapping.class */
    public static class Mapping extends HandlerCollection.Handlers {
        private final Map<ContextHandler, Handler> _contextBranches;
        private final Trie<Map.Entry<String, Branch[]>> _pathBranches;

        private Mapping(Handler[] handlers, int capacity) {
            super(handlers);
            this._contextBranches = new HashMap();
            this._pathBranches = new ArrayTernaryTrie(false, capacity);
        }
    }
}
