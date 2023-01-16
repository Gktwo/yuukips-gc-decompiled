package com.mongodb.internal.dns;

import com.mongodb.MongoClientException;
import com.mongodb.MongoConfigurationException;
import dev.morphia.mapping.Mapper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Hashtable;
import java.util.List;
import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.InitialDirContext;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/mongodb/internal/dns/DefaultDnsResolver.class */
public final class DefaultDnsResolver implements DnsResolver {
    @Override // com.mongodb.internal.dns.DnsResolver
    public List<String> resolveHostFromSrvRecords(String srvHost) {
        InitialDirContext dirContext;
        try {
            List<String> srvHostDomainParts = Arrays.asList(srvHost.substring(srvHost.indexOf(46) + 1).split("\\."));
            List<String> hosts = new ArrayList<>();
            dirContext = createDnsDirContext();
            try {
                Attribute attribute = dirContext.getAttributes("_mongodb._tcp." + srvHost, new String[]{"SRV"}).get("SRV");
                if (attribute == null) {
                    throw new MongoConfigurationException("No SRV records available for host " + srvHost);
                }
                NamingEnumeration<?> srvRecordEnumeration = attribute.getAll();
                while (srvRecordEnumeration.hasMore()) {
                    String[] split = ((String) srvRecordEnumeration.next()).split(" ");
                    String resolvedHost = split[3].endsWith(Mapper.IGNORED_FIELDNAME) ? split[3].substring(0, split[3].length() - 1) : split[3];
                    if (!sameParentDomain(srvHostDomainParts, resolvedHost.substring(resolvedHost.indexOf(46) + 1))) {
                        throw new MongoConfigurationException(String.format("The SRV host name '%s'resolved to a host '%s 'that is not in a sub-domain of the SRV host.", srvHost, resolvedHost));
                    }
                    hosts.add(resolvedHost + EmitterKt.COMMENT_PREFIX + split[2]);
                }
                if (!hosts.isEmpty()) {
                    return hosts;
                }
                throw new MongoConfigurationException("Unable to find any SRV records for host " + srvHost);
            } catch (NamingException e) {
                throw new MongoConfigurationException("Unable to look up SRV record for host " + srvHost, e);
            }
        } finally {
            try {
                dirContext.close();
            } catch (NamingException e2) {
            }
        }
    }

    private static boolean sameParentDomain(List<String> srvHostDomainParts, String resolvedHostDomain) {
        List<String> resolvedHostDomainParts = Arrays.asList(resolvedHostDomain.split("\\."));
        if (srvHostDomainParts.size() > resolvedHostDomainParts.size()) {
            return false;
        }
        return resolvedHostDomainParts.subList(resolvedHostDomainParts.size() - srvHostDomainParts.size(), resolvedHostDomainParts.size()).equals(srvHostDomainParts);
    }

    @Override // com.mongodb.internal.dns.DnsResolver
    public String resolveAdditionalQueryParametersFromTxtRecords(String host) {
        InitialDirContext dirContext;
        try {
            String additionalQueryParameters = "";
            dirContext = createDnsDirContext();
            try {
                Attribute attribute = dirContext.getAttributes(host, new String[]{"TXT"}).get("TXT");
                if (attribute != null) {
                    NamingEnumeration<?> txtRecordEnumeration = attribute.getAll();
                    if (txtRecordEnumeration.hasMore()) {
                        additionalQueryParameters = ((String) txtRecordEnumeration.next()).replaceAll("\\s", "");
                        if (txtRecordEnumeration.hasMore()) {
                            throw new MongoConfigurationException(String.format("Multiple TXT records found for host '%s'.  Only one is permitted", host));
                        }
                    }
                }
                return additionalQueryParameters;
            } catch (NamingException e) {
                throw new MongoConfigurationException("Unable to look up TXT record for host " + host, e);
            }
        } finally {
            try {
                dirContext.close();
            } catch (NamingException e2) {
            }
        }
    }

    private static InitialDirContext createDnsDirContext() {
        Hashtable<String, String> envProps = new Hashtable<>();
        envProps.put("java.naming.factory.initial", "com.sun.jndi.dns.DnsContextFactory");
        envProps.put("java.naming.provider.url", "dns:");
        try {
            return new InitialDirContext(envProps);
        } catch (NamingException e) {
            throw new MongoClientException("Unable to support mongodb+srv// style connections as the 'com.sun.jndi.dns.DnsContextFactory' class is not available in this JRE. A JNDI context is required for resolving SRV records.", e);
        }
    }
}
