package org.quartz.management;

/* loaded from: grasscutter.jar:org/quartz/management/ManagementRESTServiceConfiguration.class */
public class ManagementRESTServiceConfiguration {
    public static final String DEFAULT_BIND = "0.0.0.0:9888";
    public static final int DEFAULT_SECURITY_SVC_TIMEOUT = 5000;
    private volatile String securityServiceLocation;
    private volatile boolean enabled = false;
    private volatile int securityServiceTimeout = 5000;
    private volatile String bind = DEFAULT_BIND;

    public boolean isEnabled() {
        return this.enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getSecurityServiceLocation() {
        return this.securityServiceLocation;
    }

    public void setSecurityServiceLocation(String securityServiceURL) {
        this.securityServiceLocation = securityServiceURL;
    }

    public int getSecurityServiceTimeout() {
        return this.securityServiceTimeout;
    }

    public void setSecurityServiceTimeout(int securityServiceTimeout) {
        this.securityServiceTimeout = securityServiceTimeout;
    }

    public String getBind() {
        return this.bind;
    }

    public String getHost() {
        if (this.bind == null) {
            return null;
        }
        return this.bind.split("\\:")[0];
    }

    public int getPort() {
        if (this.bind == null) {
            return -1;
        }
        String[] split = this.bind.split("\\:");
        if (split.length == 2) {
            return Integer.parseInt(split[1]);
        }
        throw new IllegalArgumentException("invalid bind format (should be IP:port)");
    }

    public void setBind(String bind) {
        this.bind = bind;
    }
}
