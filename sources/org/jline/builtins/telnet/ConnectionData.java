package org.jline.builtins.telnet;

import dev.morphia.mapping.Mapper;
import java.net.InetAddress;
import java.net.Socket;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

/* loaded from: grasscutter.jar:org/jline/builtins/telnet/ConnectionData.class */
public class ConnectionData {
    private ConnectionManager connectionManager;
    private Socket socket;
    private InetAddress address;
    private String hostName;
    private String hostAddress;
    private int port;
    private Locale locale;
    private long lastActivity;
    private boolean warned;
    private String loginShell;
    private boolean terminalGeometryChanged = true;
    private boolean lineMode = false;
    private int[] terminalGeometry = new int[2];
    private String negotiatedTerminalType = "default";
    private Map<String, String> environment = new HashMap(20);

    public ConnectionData(Socket sock, ConnectionManager cm) {
        this.socket = sock;
        this.connectionManager = cm;
        this.address = sock.getInetAddress();
        setHostName();
        setHostAddress();
        setLocale();
        this.port = sock.getPort();
        this.terminalGeometry[0] = 80;
        this.terminalGeometry[1] = 25;
        activity();
    }

    public ConnectionManager getManager() {
        return this.connectionManager;
    }

    public Socket getSocket() {
        return this.socket;
    }

    public int getPort() {
        return this.port;
    }

    public String getHostName() {
        return this.hostName;
    }

    public String getHostAddress() {
        return this.hostAddress;
    }

    public InetAddress getInetAddress() {
        return this.address;
    }

    public Locale getLocale() {
        return this.locale;
    }

    public long getLastActivity() {
        return this.lastActivity;
    }

    public void activity() {
        this.warned = false;
        this.lastActivity = System.currentTimeMillis();
    }

    public boolean isWarned() {
        return this.warned;
    }

    public void setWarned(boolean bool) {
        this.warned = bool;
        if (!bool) {
            this.lastActivity = System.currentTimeMillis();
        }
    }

    public void setTerminalGeometry(int width, int height) {
        this.terminalGeometry[0] = width;
        this.terminalGeometry[1] = height;
        this.terminalGeometryChanged = true;
    }

    public int[] getTerminalGeometry() {
        if (this.terminalGeometryChanged) {
            this.terminalGeometryChanged = false;
        }
        return this.terminalGeometry;
    }

    public int getTerminalColumns() {
        return this.terminalGeometry[0];
    }

    public int getTerminalRows() {
        return this.terminalGeometry[1];
    }

    public boolean isTerminalGeometryChanged() {
        return this.terminalGeometryChanged;
    }

    public String getNegotiatedTerminalType() {
        return this.negotiatedTerminalType;
    }

    public void setNegotiatedTerminalType(String termtype) {
        this.negotiatedTerminalType = termtype;
    }

    public Map<String, String> getEnvironment() {
        return this.environment;
    }

    public String getLoginShell() {
        return this.loginShell;
    }

    public void setLoginShell(String s) {
        this.loginShell = s;
    }

    public boolean isLineMode() {
        return this.lineMode;
    }

    public void setLineMode(boolean b) {
        this.lineMode = b;
    }

    private void setHostName() {
        this.hostName = this.address.getHostName();
    }

    private void setHostAddress() {
        this.hostAddress = this.address.getHostAddress();
    }

    private void setLocale() {
        String country = getHostName();
        try {
            String country2 = country.substring(country.lastIndexOf(Mapper.IGNORED_FIELDNAME) + 1);
            if (country2.equals("at")) {
                this.locale = new Locale("de", "AT");
            } else if (country2.equals("de")) {
                this.locale = new Locale("de", "DE");
            } else if (country2.equals("mx")) {
                this.locale = new Locale("es", "MX");
            } else if (country2.equals("es")) {
                this.locale = new Locale("es", "ES");
            } else if (country2.equals("it")) {
                this.locale = Locale.ITALY;
            } else if (country2.equals("fr")) {
                this.locale = Locale.FRANCE;
            } else if (country2.equals("uk")) {
                this.locale = new Locale("en", "GB");
            } else if (country2.equals("arpa")) {
                this.locale = Locale.US;
            } else if (country2.equals("com")) {
                this.locale = Locale.US;
            } else if (country2.equals("edu")) {
                this.locale = Locale.US;
            } else if (country2.equals("gov")) {
                this.locale = Locale.US;
            } else if (country2.equals("org")) {
                this.locale = Locale.US;
            } else if (country2.equals("mil")) {
                this.locale = Locale.US;
            } else {
                this.locale = Locale.ENGLISH;
            }
        } catch (Exception e) {
            this.locale = Locale.ENGLISH;
        }
    }
}
