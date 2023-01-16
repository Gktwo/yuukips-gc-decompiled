package com.mongodb.internal.dns;

import java.util.List;

/* loaded from: grasscutter.jar:com/mongodb/internal/dns/DnsResolver.class */
public interface DnsResolver {
    List<String> resolveHostFromSrvRecords(String str);

    String resolveAdditionalQueryParametersFromTxtRecords(String str);
}
