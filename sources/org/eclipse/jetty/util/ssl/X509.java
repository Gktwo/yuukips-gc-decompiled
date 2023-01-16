package org.eclipse.jetty.util.ssl;

import java.net.InetAddress;
import java.security.cert.X509Certificate;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.naming.ldap.LdapName;
import javax.naming.ldap.Rdn;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/X509.class */
public class X509 {
    private static final Logger LOG = Log.getLogger(X509.class);
    private static final int KEY_USAGE__KEY_CERT_SIGN = 5;
    private static final int SUBJECT_ALTERNATIVE_NAMES__DNS_NAME = 2;
    private static final int SUBJECT_ALTERNATIVE_NAMES__IP_ADDRESS = 7;
    private final X509Certificate _x509;
    private final String _alias;
    private final Set<String> _hosts = new LinkedHashSet();
    private final Set<String> _wilds = new LinkedHashSet();
    private final Set<InetAddress> _addresses = new LinkedHashSet();

    public static boolean isCertSign(X509Certificate x509) {
        boolean[] keyUsage = x509.getKeyUsage();
        if (keyUsage == null || keyUsage.length <= 5) {
            return false;
        }
        return keyUsage[5];
    }

    public X509(String alias, X509Certificate x509) {
        this._alias = alias;
        this._x509 = x509;
        try {
            Collection<List<?>> altNames = x509.getSubjectAlternativeNames();
            if (altNames != null) {
                for (List<?> list : altNames) {
                    switch (((Number) list.get(0)).intValue()) {
                        case 2:
                            String name = list.get(1).toString();
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Certificate alias={} SAN dns={} in {}", alias, name, this);
                            }
                            addName(name);
                            break;
                        case 7:
                            String address = list.get(1).toString();
                            if (LOG.isDebugEnabled()) {
                                LOG.debug("Certificate alias={} SAN ip={} in {}", alias, address, this);
                            }
                            addAddress(address);
                            break;
                    }
                }
            }
            for (Rdn rdn : new LdapName(x509.getSubjectX500Principal().getName("RFC2253")).getRdns()) {
                if (rdn.getType().equalsIgnoreCase("CN")) {
                    String cn = rdn.getValue().toString();
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Certificate CN alias={} CN={} in {}", alias, cn, this);
                    }
                    addName(cn);
                }
            }
        } catch (Exception x) {
            throw new IllegalArgumentException(x);
        }
    }

    protected void addName(String cn) {
        if (cn != null) {
            String cn2 = StringUtil.asciiToLowerCase(cn);
            if (cn2.startsWith("*.")) {
                this._wilds.add(cn2.substring(2));
            } else {
                this._hosts.add(cn2);
            }
        }
    }

    private void addAddress(String host) {
        InetAddress address = toInetAddress(host);
        if (address != null) {
            this._addresses.add(address);
        }
    }

    private InetAddress toInetAddress(String address) {
        try {
            return InetAddress.getByName(address);
        } catch (Throwable x) {
            LOG.ignore(x);
            return null;
        }
    }

    public String getAlias() {
        return this._alias;
    }

    public X509Certificate getCertificate() {
        return this._x509;
    }

    public Set<String> getHosts() {
        return Collections.unmodifiableSet(this._hosts);
    }

    public Set<String> getWilds() {
        return Collections.unmodifiableSet(this._wilds);
    }

    public boolean matches(String host) {
        InetAddress address;
        String host2 = StringUtil.asciiToLowerCase(host);
        if (this._hosts.contains(host2) || this._wilds.contains(host2)) {
            return true;
        }
        int dot = host2.indexOf(46);
        if (dot >= 0) {
            if (this._wilds.contains(host2.substring(dot + 1))) {
                return true;
            }
        }
        if (!seemsIPAddress(host2) || (address = toInetAddress(host2)) == null) {
            return false;
        }
        return this._addresses.contains(address);
    }

    private static boolean seemsIPAddress(String host) {
        return host.matches("[0-9\\.]+") || (host.matches("[0-9a-fA-F:\\[\\]]+") && containsAtLeastTwoColons(host));
    }

    private static boolean containsAtLeastTwoColons(String host) {
        int index = host.indexOf(58);
        if (index >= 0) {
            index = host.indexOf(58, index + 1);
        }
        return index > 0;
    }

    public String toString() {
        return String.format("%s@%x(%s,h=%s,a=%s,w=%s)", getClass().getSimpleName(), Integer.valueOf(hashCode()), this._alias, this._hosts, this._addresses, this._wilds);
    }
}
