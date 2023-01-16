package org.eclipse.jetty.server.handler;

import dev.morphia.mapping.Mapper;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.PathMap;
import org.eclipse.jetty.p023io.EndPoint;
import org.eclipse.jetty.server.HttpChannel;
import org.eclipse.jetty.server.Request;
import org.eclipse.jetty.util.IPAddressMap;
import org.eclipse.jetty.util.component.DumpableCollection;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

@Deprecated
/* loaded from: grasscutter.jar:org/eclipse/jetty/server/handler/IPAccessHandler.class */
public class IPAccessHandler extends HandlerWrapper {
    private static final Logger LOG = Log.getLogger(IPAccessHandler.class);
    PathMap<IPAddressMap<Boolean>> _white = new PathMap<>(true);
    PathMap<IPAddressMap<Boolean>> _black = new PathMap<>(true);
    boolean _whiteListByPath = false;

    public IPAccessHandler() {
    }

    public IPAccessHandler(String[] white, String[] black) {
        if (white != null && white.length > 0) {
            setWhite(white);
        }
        if (black != null && black.length > 0) {
            setBlack(black);
        }
    }

    public void addWhite(String entry) {
        add(entry, this._white);
    }

    public void addBlack(String entry) {
        add(entry, this._black);
    }

    public void setWhite(String[] entries) {
        set(entries, this._white);
    }

    public void setBlack(String[] entries) {
        set(entries, this._black);
    }

    public void setWhiteListByPath(boolean whiteListByPath) {
        this._whiteListByPath = whiteListByPath;
    }

    @Override // org.eclipse.jetty.server.handler.HandlerWrapper, org.eclipse.jetty.server.handler.AbstractHandler, org.eclipse.jetty.server.Handler
    public void handle(String target, Request baseRequest, HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        EndPoint endp;
        InetSocketAddress address;
        HttpChannel channel = baseRequest.getHttpChannel();
        if (channel == null || (endp = channel.getEndPoint()) == null || (address = endp.getRemoteAddress()) == null || isAddrUriAllowed(address.getHostString(), baseRequest.getMetaData().getURI().getDecodedPath())) {
            getHandler().handle(target, baseRequest, request, response);
            return;
        }
        response.sendError(403);
        baseRequest.setHandled(true);
    }

    protected void add(String entry, PathMap<IPAddressMap<Boolean>> patternMap) {
        int idx;
        if (entry != null && entry.length() > 0) {
            boolean deprecated = false;
            if (entry.indexOf(124) > 0) {
                idx = entry.indexOf(124);
            } else {
                idx = entry.indexOf(47);
                deprecated = idx >= 0;
            }
            String addr = idx > 0 ? entry.substring(0, idx) : entry;
            String path = idx > 0 ? entry.substring(idx) : "/*";
            if (addr.endsWith(Mapper.IGNORED_FIELDNAME)) {
                deprecated = true;
            }
            if (path != null && (path.startsWith("|") || path.startsWith("/*."))) {
                path = path.substring(1);
            }
            IPAddressMap<Boolean> addrMap = patternMap.get(path);
            if (addrMap == null) {
                addrMap = new IPAddressMap<>();
                patternMap.put(path, (String) addrMap);
            }
            if (addr != null && !"".equals(addr)) {
                addrMap.put(addr, (String) true);
            }
            if (deprecated) {
                LOG.debug(toString() + " - deprecated specification syntax: " + entry, new Object[0]);
            }
        }
    }

    protected void set(String[] entries, PathMap<IPAddressMap<Boolean>> patternMap) {
        patternMap.clear();
        if (entries != null && entries.length > 0) {
            for (String addrPath : entries) {
                add(addrPath, patternMap);
            }
        }
    }

    protected boolean isAddrUriAllowed(String addr, String path) {
        if (this._white.size() > 0) {
            boolean match = false;
            boolean matchedByPath = false;
            for (Map.Entry<String, IPAddressMap<Boolean>> entry : this._white.getMatches(path)) {
                matchedByPath = true;
                IPAddressMap<Boolean> addrMap = entry.getValue();
                if (addrMap != null && (addrMap.size() == 0 || addrMap.match(addr) != null)) {
                    match = true;
                    break;
                }
            }
            if (this._whiteListByPath) {
                if (matchedByPath && !match) {
                    return false;
                }
            } else if (!match) {
                return false;
            }
        }
        if (this._black.size() <= 0) {
            return true;
        }
        for (Map.Entry<String, IPAddressMap<Boolean>> entry2 : this._black.getMatches(path)) {
            IPAddressMap<Boolean> addrMap2 = entry2.getValue();
            if (addrMap2 != null && (addrMap2.size() == 0 || addrMap2.match(addr) != null)) {
                return false;
            }
        }
        return true;
    }

    @Override // org.eclipse.jetty.util.component.ContainerLifeCycle, org.eclipse.jetty.util.component.Dumpable
    public void dump(Appendable out, String indent) throws IOException {
        dumpObjects(out, indent, DumpableCollection.from("white", this._white), DumpableCollection.from("black", this._black), DumpableCollection.from("whiteListByPath", Boolean.valueOf(this._whiteListByPath)));
    }
}
