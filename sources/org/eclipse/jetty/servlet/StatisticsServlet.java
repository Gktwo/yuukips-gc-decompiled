package org.eclipse.jetty.servlet;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.eclipse.jetty.http.HttpHeader;
import org.eclipse.jetty.http.QuotedQualityCSV;
import org.eclipse.jetty.p023io.ConnectionStatistics;
import org.eclipse.jetty.server.AbstractConnector;
import org.eclipse.jetty.server.Connector;
import org.eclipse.jetty.server.ConnectorStatistics;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandler;
import org.eclipse.jetty.server.handler.StatisticsHandler;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.ajax.JSON;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.jline.reader.LineReader;
import p013io.javalin.http.ContentType;

/* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet.class */
public class StatisticsServlet extends HttpServlet {
    private static final Logger LOG = Log.getLogger(StatisticsServlet.class);
    boolean _restrictToLocalhost = true;
    private StatisticsHandler _statsHandler;
    private MemoryMXBean _memoryBean;
    private List<Connector> _connectors;

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet$OutputProducer.class */
    public interface OutputProducer {
        CharSequence generate(String str, Map<String, Object> map);
    }

    @Override // javax.servlet.GenericServlet
    public void init() throws ServletException {
        Server server = ((ContextHandler.Context) getServletContext()).getContextHandler().getServer();
        this._statsHandler = (StatisticsHandler) server.getChildHandlerByClass(StatisticsHandler.class);
        if (this._statsHandler == null) {
            LOG.warn("Statistics Handler not installed!", new Object[0]);
            return;
        }
        this._memoryBean = ManagementFactory.getMemoryMXBean();
        this._connectors = Arrays.asList(server.getConnectors());
        if (getInitParameter("restrictToLocalhost") != null) {
            this._restrictToLocalhost = C3P0Substitutions.DEBUG.equals(getInitParameter("restrictToLocalhost"));
        }
    }

    @Override // javax.servlet.http.HttpServlet
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    @Override // javax.servlet.http.HttpServlet
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (this._statsHandler == null) {
            LOG.warn("Statistics Handler not installed!", new Object[0]);
            response.sendError(503);
        } else if (this._restrictToLocalhost && !isLoopbackAddress(request.getRemoteAddr())) {
            response.sendError(403);
        } else if (Boolean.parseBoolean(request.getParameter("statsReset"))) {
            response.setStatus(200);
            this._statsHandler.statsReset();
        } else {
            if (request.getParameter("xml") != null) {
                LOG.warn("'xml' parameter is deprecated, use 'Accept' request header instead", new Object[0]);
            }
            for (String mimeType : getOrderedAcceptableMimeTypes(request)) {
                char c = 65535;
                switch (mimeType.hashCode()) {
                    case -1082243251:
                        if (mimeType.equals(ContentType.HTML)) {
                            c = 2;
                            break;
                        }
                        break;
                    case -1004727243:
                        if (mimeType.equals(ContentType.XML)) {
                            c = 1;
                            break;
                        }
                        break;
                    case -43840953:
                        if (mimeType.equals(ContentType.JSON)) {
                            c = 0;
                            break;
                        }
                        break;
                    case 41861:
                        if (mimeType.equals("*/*")) {
                            c = 4;
                            break;
                        }
                        break;
                    case 817335912:
                        if (mimeType.equals(ContentType.PLAIN)) {
                            c = 3;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        writeJsonResponse(response);
                        return;
                    case 1:
                        writeXmlResponse(response);
                        return;
                    case 2:
                        writeHtmlResponse(response);
                        return;
                    case 3:
                    case 4:
                        writeTextResponse(response);
                        return;
                    default:
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Ignoring unrecognized mime-type {}", mimeType);
                        }
                }
            }
            response.sendError(406);
        }
    }

    private void writeTextResponse(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(StringUtil.__UTF8);
        response.setContentType(ContentType.PLAIN);
        response.getWriter().print(generateResponse(new TextProducer()).toString());
    }

    private void writeHtmlResponse(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(StringUtil.__UTF8);
        response.setContentType(ContentType.HTML);
        Writer htmlWriter = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
        htmlWriter.append("<html><head><title>");
        htmlWriter.append(getClass().getSimpleName());
        htmlWriter.append("</title></head><body>\n");
        htmlWriter.append(generateResponse(new HtmlProducer()).toString());
        htmlWriter.append("\n</body></html>\n");
        htmlWriter.flush();
    }

    private void writeXmlResponse(HttpServletResponse response) throws IOException {
        response.setCharacterEncoding(StringUtil.__UTF8);
        response.setContentType(ContentType.XML);
        response.getWriter().print(generateResponse(new XmlProducer()).toString());
    }

    private void writeJsonResponse(HttpServletResponse response) throws IOException {
        response.setContentType(ContentType.JSON);
        CharSequence json = generateResponse(new JsonProducer());
        Writer jsonWriter = new OutputStreamWriter(response.getOutputStream(), StandardCharsets.UTF_8);
        jsonWriter.append(json);
        jsonWriter.flush();
    }

    private List<String> getOrderedAcceptableMimeTypes(HttpServletRequest request) {
        QuotedQualityCSV values = new QuotedQualityCSV(QuotedQualityCSV.MOST_SPECIFIC_MIME_ORDERING);
        String acceptParameter = request.getParameter("accept");
        if (acceptParameter != null) {
            values.addValue(acceptParameter);
        }
        Enumeration<String> enumAccept = request.getHeaders(HttpHeader.ACCEPT.toString());
        if (enumAccept != null) {
            while (enumAccept.hasMoreElements()) {
                String value = enumAccept.nextElement();
                if (StringUtil.isNotBlank(value)) {
                    values.addValue(value);
                }
            }
        }
        if (values.isEmpty()) {
            return Collections.singletonList("*/*");
        }
        return values.getValues();
    }

    private boolean isLoopbackAddress(String address) {
        try {
            return InetAddress.getByName(address).isLoopbackAddress();
        } catch (UnknownHostException e) {
            LOG.warn("Warning: attempt to access statistics servlet from " + address, e);
            return false;
        }
    }

    private CharSequence generateResponse(OutputProducer outputProducer) {
        Map<String, Object> top = new HashMap<>();
        Map<String, Number> requests = new HashMap<>();
        requests.put("statsOnMs", Long.valueOf(this._statsHandler.getStatsOnMs()));
        requests.put("requests", Integer.valueOf(this._statsHandler.getRequests()));
        requests.put("requestsActive", Integer.valueOf(this._statsHandler.getRequestsActive()));
        requests.put("requestsActiveMax", Integer.valueOf(this._statsHandler.getRequestsActiveMax()));
        requests.put("requestsTimeTotal", Long.valueOf(this._statsHandler.getRequestTimeTotal()));
        requests.put("requestsTimeMean", Double.valueOf(this._statsHandler.getRequestTimeMean()));
        requests.put("requestsTimeMax", Long.valueOf(this._statsHandler.getRequestTimeMax()));
        requests.put("requestsTimeStdDev", Double.valueOf(this._statsHandler.getRequestTimeStdDev()));
        requests.put("dispatched", Integer.valueOf(this._statsHandler.getDispatched()));
        requests.put("dispatchedActive", Integer.valueOf(this._statsHandler.getDispatchedActive()));
        requests.put("dispatchedActiveMax", Integer.valueOf(this._statsHandler.getDispatchedActiveMax()));
        requests.put("dispatchedTimeTotal", Long.valueOf(this._statsHandler.getDispatchedTimeTotal()));
        requests.put("dispatchedTimeMean", Double.valueOf(this._statsHandler.getDispatchedTimeMean()));
        requests.put("dispatchedTimeMax", Long.valueOf(this._statsHandler.getDispatchedTimeMax()));
        requests.put("dispatchedTimeStdDev", Double.valueOf(this._statsHandler.getDispatchedTimeStdDev()));
        requests.put("asyncRequests", Integer.valueOf(this._statsHandler.getAsyncRequests()));
        requests.put("requestsSuspended", Integer.valueOf(this._statsHandler.getAsyncDispatches()));
        requests.put("requestsSuspendedMax", Integer.valueOf(this._statsHandler.getAsyncRequestsWaiting()));
        requests.put("requestsResumed", Integer.valueOf(this._statsHandler.getAsyncRequestsWaitingMax()));
        requests.put("requestsExpired", Integer.valueOf(this._statsHandler.getExpires()));
        requests.put(LineReader.ERRORS, Integer.valueOf(this._statsHandler.getErrors()));
        top.put("requests", requests);
        Map<String, Number> responses = new HashMap<>();
        responses.put("responses1xx", Integer.valueOf(this._statsHandler.getResponses1xx()));
        responses.put("responses2xx", Integer.valueOf(this._statsHandler.getResponses2xx()));
        responses.put("responses3xx", Integer.valueOf(this._statsHandler.getResponses3xx()));
        responses.put("responses4xx", Integer.valueOf(this._statsHandler.getResponses4xx()));
        responses.put("responses5xx", Integer.valueOf(this._statsHandler.getResponses5xx()));
        responses.put("responsesBytesTotal", Long.valueOf(this._statsHandler.getResponsesBytesTotal()));
        top.put("responses", responses);
        List<Object> connections = new ArrayList<>();
        this._connectors.forEach(connector -> {
            HashMap hashMap = new HashMap();
            hashMap.put("name", String.format("%s@%X", connector.getClass().getName(), Integer.valueOf(connector.hashCode())));
            hashMap.put("protocols", connector.getProtocols());
            ConnectionStatistics connectionStats = null;
            if (connector instanceof AbstractConnector) {
                connectionStats = (ConnectionStatistics) connector.getBean(ConnectionStatistics.class);
            }
            if (connectionStats != null) {
                hashMap.put("statsOn", true);
                hashMap.put("connections", Long.valueOf(connectionStats.getConnectionsTotal()));
                hashMap.put("connectionsOpen", Long.valueOf(connectionStats.getConnections()));
                hashMap.put("connectionsOpenMax", Long.valueOf(connectionStats.getConnectionsMax()));
                hashMap.put("connectionsDurationMean", Double.valueOf(connectionStats.getConnectionDurationMean()));
                hashMap.put("connectionsDurationMax", Long.valueOf(connectionStats.getConnectionDurationMax()));
                hashMap.put("connectionsDurationStdDev", Double.valueOf(connectionStats.getConnectionDurationStdDev()));
                hashMap.put("bytesIn", Long.valueOf(connectionStats.getReceivedBytes()));
                hashMap.put("bytesOut", Long.valueOf(connectionStats.getSentBytes()));
                hashMap.put("messagesIn", Long.valueOf(connectionStats.getReceivedMessages()));
                hashMap.put("messagesOut", Long.valueOf(connectionStats.getSentMessages()));
            } else {
                ConnectorStatistics connectorStats = null;
                if (connector instanceof AbstractConnector) {
                    connectorStats = (ConnectorStatistics) connector.getBean(ConnectorStatistics.class);
                }
                if (connectorStats != null) {
                    hashMap.put("statsOn", true);
                    hashMap.put("connections", Integer.valueOf(connectorStats.getConnections()));
                    hashMap.put("connectionsOpen", Integer.valueOf(connectorStats.getConnectionsOpen()));
                    hashMap.put("connectionsOpenMax", Integer.valueOf(connectorStats.getConnectionsOpenMax()));
                    hashMap.put("connectionsDurationMean", Double.valueOf(connectorStats.getConnectionDurationMean()));
                    hashMap.put("connectionsDurationMax", Long.valueOf(connectorStats.getConnectionDurationMax()));
                    hashMap.put("connectionsDurationStdDev", Double.valueOf(connectorStats.getConnectionDurationStdDev()));
                    hashMap.put("messagesIn", Integer.valueOf(connectorStats.getMessagesIn()));
                    hashMap.put("messagesOut", Integer.valueOf(connectorStats.getMessagesIn()));
                    hashMap.put("elapsedMs", Long.valueOf(connectorStats.getStartedMillis()));
                } else {
                    hashMap.put("statsOn", false);
                }
            }
            connections.add(hashMap);
        });
        top.put("connections", connections);
        Map<String, Number> memoryMap = new HashMap<>();
        memoryMap.put("heapMemoryUsage", Long.valueOf(this._memoryBean.getHeapMemoryUsage().getUsed()));
        memoryMap.put("nonHeapMemoryUsage", Long.valueOf(this._memoryBean.getNonHeapMemoryUsage().getUsed()));
        top.put("memory", memoryMap);
        return outputProducer.generate("statistics", top);
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet$JsonProducer.class */
    public static class JsonProducer implements OutputProducer {
        private JsonProducer() {
        }

        @Override // org.eclipse.jetty.servlet.StatisticsServlet.OutputProducer
        public CharSequence generate(String id, Map<String, Object> map) {
            return JSON.toString((Map) map);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet$XmlProducer.class */
    public static class XmlProducer implements OutputProducer {
        private int indent = 0;

        /* renamed from: sb */
        private final StringBuilder f3154sb = new StringBuilder();

        @Override // org.eclipse.jetty.servlet.StatisticsServlet.OutputProducer
        public CharSequence generate(String id, Map<String, Object> map) {
            add(id, map);
            return this.f3154sb;
        }

        private void indent() {
            this.f3154sb.append("\n");
            for (int i = 0; i < this.indent; i++) {
                this.f3154sb.append(' ').append(' ');
            }
        }

        private void add(String id, Object obj) {
            this.f3154sb.append('<').append(StringUtil.sanitizeXmlString(id)).append('>');
            this.indent++;
            boolean wasIndented = false;
            if (obj instanceof Map) {
                addMap((Map) obj);
                wasIndented = true;
            } else if (obj instanceof List) {
                addList(id, (List) obj);
                wasIndented = true;
            } else {
                addObject(obj);
            }
            this.indent--;
            if (wasIndented) {
                indent();
            }
            this.f3154sb.append("</").append(id).append('>');
        }

        private void addMap(Map<String, ?> map) {
            map.keySet().stream().sorted().forEach(key -> {
                indent();
                add(map, map.get(map));
            });
        }

        private void addList(String parentId, List<?> list) {
            String childName = parentId.replaceFirst("s$", "");
            list.forEach(entry -> {
                indent();
                add(childName, childName);
            });
        }

        private void addObject(Object obj) {
            this.f3154sb.append(StringUtil.sanitizeXmlString(Objects.toString(obj)));
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet$TextProducer.class */
    public static class TextProducer implements OutputProducer {
        private int indent = 0;

        /* renamed from: sb */
        private final StringBuilder f3153sb = new StringBuilder();

        @Override // org.eclipse.jetty.servlet.StatisticsServlet.OutputProducer
        public CharSequence generate(String id, Map<String, Object> map) {
            add(id, map);
            return this.f3153sb;
        }

        private void indent() {
            for (int i = 0; i < this.indent; i++) {
                this.f3153sb.append(' ').append(' ');
            }
        }

        private void add(String id, Object obj) {
            indent();
            this.f3153sb.append(id).append(": ");
            this.indent++;
            if (obj instanceof Map) {
                this.f3153sb.append('\n');
                addMap((Map) obj);
            } else if (obj instanceof List) {
                this.f3153sb.append('\n');
                addList(id, (List) obj);
            } else {
                addObject(obj);
                this.f3153sb.append('\n');
            }
            this.indent--;
        }

        private void addMap(Map<String, ?> map) {
            map.keySet().stream().sorted().forEach(key -> {
                add(map, map.get(map));
            });
        }

        private void addList(String parentId, List<?> list) {
            String childName = parentId.replaceFirst("s$", "");
            list.forEach(entry -> {
                add(childName, childName);
            });
        }

        private void addObject(Object obj) {
            this.f3153sb.append(obj);
        }
    }

    /* access modifiers changed from: private */
    /* loaded from: grasscutter.jar:org/eclipse/jetty/servlet/StatisticsServlet$HtmlProducer.class */
    public static class HtmlProducer implements OutputProducer {
        private int indent = 0;

        /* renamed from: sb */
        private final StringBuilder f3152sb = new StringBuilder();

        @Override // org.eclipse.jetty.servlet.StatisticsServlet.OutputProducer
        public CharSequence generate(String id, Map<String, Object> map) {
            this.f3152sb.append("<ul>\n");
            add(id, map);
            this.f3152sb.append("</ul>\n");
            return this.f3152sb;
        }

        private void indent() {
            for (int i = 0; i < this.indent; i++) {
                this.f3152sb.append(' ').append(' ');
            }
        }

        private void add(String id, Object obj) {
            indent();
            this.indent++;
            this.f3152sb.append("<li><em>").append(StringUtil.sanitizeXmlString(id)).append("</em>: ");
            if (obj instanceof Map) {
                addMap((Map) obj);
                indent();
            } else if (obj instanceof List) {
                addList(id, (List) obj);
                indent();
            } else {
                addObject(obj);
            }
            this.f3152sb.append("</li>\n");
            this.indent--;
        }

        private void addMap(Map<String, ?> map) {
            this.f3152sb.append("\n");
            indent();
            this.f3152sb.append("<ul>\n");
            this.indent++;
            map.keySet().stream().sorted((v0, v1) -> {
                return v0.compareToIgnoreCase(v1);
            }).forEach(key -> {
                add(map, map.get(map));
            });
            this.indent--;
            indent();
            this.f3152sb.append("</ul>\n");
        }

        private void addList(String parentId, List<?> list) {
            this.f3152sb.append("\n");
            indent();
            this.f3152sb.append("<ul>\n");
            this.indent++;
            String childName = parentId.replaceFirst("s$", "");
            list.forEach(entry -> {
                add(childName, childName);
            });
            this.indent--;
            indent();
            this.f3152sb.append("</ul>\n");
        }

        private void addObject(Object obj) {
            this.f3152sb.append(StringUtil.sanitizeXmlString(Objects.toString(obj)));
        }
    }
}
