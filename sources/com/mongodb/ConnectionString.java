package com.mongodb;

import com.mchange.p009v2.c3p0.subst.C3P0Substitutions;
import com.mongodb.diagnostics.logging.Logger;
import com.mongodb.diagnostics.logging.Loggers;
import com.mongodb.internal.dns.DefaultDnsResolver;
import com.mongodb.lang.Nullable;
import dev.morphia.mapping.Mapper;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import org.bson.UuidRepresentation;
import org.slf4j.Marker;
import p013io.javalin.http.sse.EmitterKt;

/* loaded from: grasscutter.jar:com/mongodb/ConnectionString.class */
public class ConnectionString {
    private static final String MONGODB_PREFIX = "mongodb://";
    private static final String MONGODB_SRV_PREFIX = "mongodb+srv://";
    private static final String UTF_8 = "UTF-8";
    private final MongoCredential credential;
    private final boolean isSrvProtocol;
    private final List<String> hosts;
    private final String database;
    private final String collection;
    private final String connectionString;
    private Boolean directConnection;
    private ReadPreference readPreference;
    private WriteConcern writeConcern;
    private Boolean retryWrites;
    private Boolean retryReads;
    private ReadConcern readConcern;
    private Integer minConnectionPoolSize;
    private Integer maxConnectionPoolSize;
    private Integer maxWaitTime;
    private Integer maxConnectionIdleTime;
    private Integer maxConnectionLifeTime;
    private Integer connectTimeout;
    private Integer socketTimeout;
    private Boolean sslEnabled;
    private Boolean sslInvalidHostnameAllowed;
    private String requiredReplicaSetName;
    private Integer serverSelectionTimeout;
    private Integer localThreshold;
    private Integer heartbeatFrequency;
    private String applicationName;
    private List<MongoCompressor> compressorList;
    private UuidRepresentation uuidRepresentation;
    private static final Set<String> ALLOWED_OPTIONS_IN_TXT_RECORD = new HashSet(Arrays.asList("authsource", "replicaset"));
    private static final Logger LOGGER = Loggers.getLogger("uri");
    private static final Set<String> GENERAL_OPTIONS_KEYS = new LinkedHashSet();
    private static final Set<String> AUTH_KEYS = new HashSet();
    private static final Set<String> READ_PREFERENCE_KEYS = new HashSet();
    private static final Set<String> WRITE_CONCERN_KEYS = new HashSet();
    private static final Set<String> COMPRESSOR_KEYS = new HashSet();
    private static final Set<String> ALL_KEYS = new HashSet();
    private static final Set<String> TRUE_VALUES = new HashSet(Arrays.asList(C3P0Substitutions.DEBUG, "yes", "1"));
    private static final Set<String> FALSE_VALUES = new HashSet(Arrays.asList("false", "no", "0"));

    static {
        GENERAL_OPTIONS_KEYS.add("minpoolsize");
        GENERAL_OPTIONS_KEYS.add("maxpoolsize");
        GENERAL_OPTIONS_KEYS.add("waitqueuetimeoutms");
        GENERAL_OPTIONS_KEYS.add("connecttimeoutms");
        GENERAL_OPTIONS_KEYS.add("maxidletimems");
        GENERAL_OPTIONS_KEYS.add("maxlifetimems");
        GENERAL_OPTIONS_KEYS.add("sockettimeoutms");
        GENERAL_OPTIONS_KEYS.add("ssl");
        GENERAL_OPTIONS_KEYS.add("tls");
        GENERAL_OPTIONS_KEYS.add("tlsinsecure");
        GENERAL_OPTIONS_KEYS.add("sslinvalidhostnameallowed");
        GENERAL_OPTIONS_KEYS.add("tlsallowinvalidhostnames");
        GENERAL_OPTIONS_KEYS.add("replicaset");
        GENERAL_OPTIONS_KEYS.add("readconcernlevel");
        GENERAL_OPTIONS_KEYS.add("serverselectiontimeoutms");
        GENERAL_OPTIONS_KEYS.add("localthresholdms");
        GENERAL_OPTIONS_KEYS.add("heartbeatfrequencyms");
        GENERAL_OPTIONS_KEYS.add("retrywrites");
        GENERAL_OPTIONS_KEYS.add("retryreads");
        GENERAL_OPTIONS_KEYS.add("appname");
        GENERAL_OPTIONS_KEYS.add("uuidrepresentation");
        GENERAL_OPTIONS_KEYS.add("directconnection");
        COMPRESSOR_KEYS.add("compressors");
        COMPRESSOR_KEYS.add("zlibcompressionlevel");
        READ_PREFERENCE_KEYS.add("readpreference");
        READ_PREFERENCE_KEYS.add("readpreferencetags");
        READ_PREFERENCE_KEYS.add("maxstalenessseconds");
        WRITE_CONCERN_KEYS.add("safe");
        WRITE_CONCERN_KEYS.add("w");
        WRITE_CONCERN_KEYS.add("wtimeoutms");
        WRITE_CONCERN_KEYS.add("journal");
        AUTH_KEYS.add("authmechanism");
        AUTH_KEYS.add("authsource");
        AUTH_KEYS.add("gssapiservicename");
        AUTH_KEYS.add("authmechanismproperties");
        ALL_KEYS.addAll(GENERAL_OPTIONS_KEYS);
        ALL_KEYS.addAll(AUTH_KEYS);
        ALL_KEYS.addAll(READ_PREFERENCE_KEYS);
        ALL_KEYS.addAll(WRITE_CONCERN_KEYS);
        ALL_KEYS.addAll(COMPRESSOR_KEYS);
    }

    public ConnectionString(String connectionString) {
        String unprocessedConnectionString;
        String userAndHostInformation;
        String unprocessedConnectionString2;
        String hostIdentifier;
        String nsPart;
        String unprocessedConnectionString3;
        this.connectionString = connectionString;
        boolean isMongoDBProtocol = connectionString.startsWith(MONGODB_PREFIX);
        this.isSrvProtocol = connectionString.startsWith(MONGODB_SRV_PREFIX);
        if (isMongoDBProtocol || this.isSrvProtocol) {
            if (isMongoDBProtocol) {
                unprocessedConnectionString = connectionString.substring(MONGODB_PREFIX.length());
            } else {
                unprocessedConnectionString = connectionString.substring(MONGODB_SRV_PREFIX.length());
            }
            int idx = unprocessedConnectionString.indexOf("/");
            if (idx != -1) {
                userAndHostInformation = unprocessedConnectionString.substring(0, idx);
                unprocessedConnectionString2 = unprocessedConnectionString.substring(idx + 1);
            } else if (unprocessedConnectionString.contains("?")) {
                throw new IllegalArgumentException("The connection string contains options without trailing slash");
            } else {
                userAndHostInformation = unprocessedConnectionString;
                unprocessedConnectionString2 = "";
            }
            String userName = null;
            char[] password = null;
            int idx2 = userAndHostInformation.lastIndexOf("@");
            if (idx2 > 0) {
                String userInfo = userAndHostInformation.substring(0, idx2).replace(Marker.ANY_NON_NULL_MARKER, "%2B");
                hostIdentifier = userAndHostInformation.substring(idx2 + 1);
                int colonCount = countOccurrences(userInfo, EmitterKt.COMMENT_PREFIX);
                if (userInfo.contains("@") || colonCount > 1) {
                    throw new IllegalArgumentException("The connection string contains invalid user information. If the username or password contains a colon (:) or an at-sign (@) then it must be urlencoded");
                } else if (colonCount == 0) {
                    userName = urldecode(userInfo);
                } else {
                    int idx3 = userInfo.indexOf(EmitterKt.COMMENT_PREFIX);
                    if (idx3 == 0) {
                        throw new IllegalArgumentException("No username is provided in the connection string");
                    }
                    userName = urldecode(userInfo.substring(0, idx3));
                    password = urldecode(userInfo.substring(idx3 + 1), true).toCharArray();
                }
            } else if (idx2 == 0) {
                throw new IllegalArgumentException("The connection string contains an at-sign (@) without a user name");
            } else {
                hostIdentifier = userAndHostInformation;
            }
            List<String> unresolvedHosts = Collections.unmodifiableList(parseHosts(Arrays.asList(hostIdentifier.split(","))));
            if (this.isSrvProtocol) {
                if (unresolvedHosts.size() > 1) {
                    throw new IllegalArgumentException("Only one host allowed when using mongodb+srv protocol");
                } else if (unresolvedHosts.get(0).contains(EmitterKt.COMMENT_PREFIX)) {
                    throw new IllegalArgumentException("Host for when using mongodb+srv protocol can not contain a port");
                }
            }
            this.hosts = unresolvedHosts;
            int idx4 = unprocessedConnectionString2.indexOf("?");
            if (idx4 == -1) {
                nsPart = unprocessedConnectionString2;
                unprocessedConnectionString3 = "";
            } else {
                nsPart = unprocessedConnectionString2.substring(0, idx4);
                unprocessedConnectionString3 = unprocessedConnectionString2.substring(idx4 + 1);
            }
            if (nsPart.length() > 0) {
                String nsPart2 = urldecode(nsPart);
                int idx5 = nsPart2.indexOf(Mapper.IGNORED_FIELDNAME);
                if (idx5 < 0) {
                    this.database = nsPart2;
                    this.collection = null;
                } else {
                    this.database = nsPart2.substring(0, idx5);
                    this.collection = nsPart2.substring(idx5 + 1);
                }
                MongoNamespace.checkDatabaseNameValidity(this.database);
            } else {
                this.database = null;
                this.collection = null;
            }
            String txtRecordsQueryParameters = this.isSrvProtocol ? new DefaultDnsResolver().resolveAdditionalQueryParametersFromTxtRecords(unresolvedHosts.get(0)) : "";
            Map<String, List<String>> connectionStringOptionsMap = parseOptions(unprocessedConnectionString3);
            Map<String, List<String>> txtRecordsOptionsMap = parseOptions(txtRecordsQueryParameters);
            if (!ALLOWED_OPTIONS_IN_TXT_RECORD.containsAll(txtRecordsOptionsMap.keySet())) {
                throw new MongoConfigurationException(String.format("A TXT record is only permitted to contain the keys %s, but the TXT record for '%s' contains the keys %s", ALLOWED_OPTIONS_IN_TXT_RECORD, unresolvedHosts.get(0), txtRecordsOptionsMap.keySet()));
            }
            Map<String, List<String>> combinedOptionsMaps = combineOptionsMaps(txtRecordsOptionsMap, connectionStringOptionsMap);
            if (this.isSrvProtocol && !combinedOptionsMaps.containsKey("ssl")) {
                combinedOptionsMaps.put("ssl", Collections.singletonList(C3P0Substitutions.DEBUG));
            }
            translateOptions(combinedOptionsMaps);
            if (this.directConnection != null && this.directConnection.booleanValue()) {
                if (this.isSrvProtocol) {
                    throw new IllegalArgumentException("Direct connections are not supported when using mongodb+srv protocol");
                } else if (this.hosts.size() > 1) {
                    throw new IllegalArgumentException("Direct connections are not supported when using multiple hosts");
                }
            }
            this.credential = createCredentials(combinedOptionsMaps, userName, password);
            warnOnUnsupportedOptions(combinedOptionsMaps);
            return;
        }
        throw new IllegalArgumentException(String.format("The connection string is invalid. Connection strings must start with either '%s' or '%s", MONGODB_PREFIX, MONGODB_SRV_PREFIX));
    }

    private Map<String, List<String>> combineOptionsMaps(Map<String, List<String>> txtRecordsOptionsMap, Map<String, List<String>> connectionStringOptionsMap) {
        Map<String, List<String>> combinedOptionsMaps = new HashMap<>(txtRecordsOptionsMap);
        for (Map.Entry<String, List<String>> entry : connectionStringOptionsMap.entrySet()) {
            combinedOptionsMaps.put(entry.getKey(), entry.getValue());
        }
        return combinedOptionsMaps;
    }

    private void warnOnUnsupportedOptions(Map<String, List<String>> optionsMap) {
        for (String key : optionsMap.keySet()) {
            if (!ALL_KEYS.contains(key) && LOGGER.isWarnEnabled()) {
                LOGGER.warn(String.format("Connection string contains unsupported option '%s'.", key));
            }
        }
    }

    private void translateOptions(Map<String, List<String>> optionsMap) {
        boolean tlsInsecureSet = false;
        boolean tlsAllowInvalidHostnamesSet = false;
        for (String key : GENERAL_OPTIONS_KEYS) {
            String value = getLastValue(optionsMap, key);
            if (value != null) {
                if (key.equals("maxpoolsize")) {
                    this.maxConnectionPoolSize = Integer.valueOf(parseInteger(value, "maxpoolsize"));
                } else if (key.equals("minpoolsize")) {
                    this.minConnectionPoolSize = Integer.valueOf(parseInteger(value, "minpoolsize"));
                } else if (key.equals("maxidletimems")) {
                    this.maxConnectionIdleTime = Integer.valueOf(parseInteger(value, "maxidletimems"));
                } else if (key.equals("maxlifetimems")) {
                    this.maxConnectionLifeTime = Integer.valueOf(parseInteger(value, "maxlifetimems"));
                } else if (key.equals("waitqueuetimeoutms")) {
                    this.maxWaitTime = Integer.valueOf(parseInteger(value, "waitqueuetimeoutms"));
                } else if (key.equals("connecttimeoutms")) {
                    this.connectTimeout = Integer.valueOf(parseInteger(value, "connecttimeoutms"));
                } else if (key.equals("sockettimeoutms")) {
                    this.socketTimeout = Integer.valueOf(parseInteger(value, "sockettimeoutms"));
                } else if (key.equals("tlsallowinvalidhostnames")) {
                    this.sslInvalidHostnameAllowed = parseBoolean(value, "tlsAllowInvalidHostnames");
                    tlsAllowInvalidHostnamesSet = true;
                } else if (key.equals("sslinvalidhostnameallowed")) {
                    this.sslInvalidHostnameAllowed = parseBoolean(value, "sslinvalidhostnameallowed");
                    tlsAllowInvalidHostnamesSet = true;
                } else if (key.equals("tlsinsecure")) {
                    this.sslInvalidHostnameAllowed = parseBoolean(value, "tlsinsecure");
                    tlsInsecureSet = true;
                } else if (key.equals("ssl")) {
                    initializeSslEnabled("ssl", value);
                } else if (key.equals("tls")) {
                    initializeSslEnabled("tls", value);
                } else if (key.equals("replicaset")) {
                    this.requiredReplicaSetName = value;
                } else if (key.equals("readconcernlevel")) {
                    this.readConcern = new ReadConcern(ReadConcernLevel.fromString(value));
                } else if (key.equals("serverselectiontimeoutms")) {
                    this.serverSelectionTimeout = Integer.valueOf(parseInteger(value, "serverselectiontimeoutms"));
                } else if (key.equals("localthresholdms")) {
                    this.localThreshold = Integer.valueOf(parseInteger(value, "localthresholdms"));
                } else if (key.equals("heartbeatfrequencyms")) {
                    this.heartbeatFrequency = Integer.valueOf(parseInteger(value, "heartbeatfrequencyms"));
                } else if (key.equals("appname")) {
                    this.applicationName = value;
                } else if (key.equals("retrywrites")) {
                    this.retryWrites = parseBoolean(value, "retrywrites");
                } else if (key.equals("retryreads")) {
                    this.retryReads = parseBoolean(value, "retryreads");
                } else if (key.equals("uuidrepresentation")) {
                    this.uuidRepresentation = createUuidRepresentation(value);
                } else if (key.equals("directconnection")) {
                    this.directConnection = parseBoolean(value, "directconnection");
                }
            }
        }
        if (!tlsInsecureSet || !tlsAllowInvalidHostnamesSet) {
            this.writeConcern = createWriteConcern(optionsMap);
            this.readPreference = createReadPreference(optionsMap);
            this.compressorList = createCompressors(optionsMap);
            return;
        }
        throw new IllegalArgumentException("tlsAllowInvalidHostnames or sslInvalidHostnameAllowed set along with tlsInsecure is not allowed");
    }

    private void initializeSslEnabled(String key, String value) {
        Boolean booleanValue = parseBoolean(value, key);
        if (this.sslEnabled == null || this.sslEnabled.equals(booleanValue)) {
            this.sslEnabled = booleanValue;
            return;
        }
        throw new IllegalArgumentException("Conflicting tls and ssl parameter values are not allowed");
    }

    private List<MongoCompressor> createCompressors(Map<String, List<String>> optionsMap) {
        String compressors = "";
        Integer zlibCompressionLevel = null;
        for (String key : COMPRESSOR_KEYS) {
            String value = getLastValue(optionsMap, key);
            if (value != null) {
                if (key.equals("compressors")) {
                    compressors = value;
                } else if (key.equals("zlibcompressionlevel")) {
                    zlibCompressionLevel = Integer.valueOf(Integer.parseInt(value));
                }
            }
        }
        return buildCompressors(compressors, zlibCompressionLevel);
    }

    private List<MongoCompressor> buildCompressors(String compressors, @Nullable Integer zlibCompressionLevel) {
        List<MongoCompressor> compressorsList = new ArrayList<>();
        String[] split = compressors.split(",");
        for (String cur : split) {
            if (cur.equals("zlib")) {
                MongoCompressor zlibCompressor = MongoCompressor.createZlibCompressor();
                if (zlibCompressionLevel != null) {
                    zlibCompressor = zlibCompressor.withProperty(MongoCompressor.LEVEL, zlibCompressionLevel);
                }
                compressorsList.add(zlibCompressor);
            } else if (cur.equals("snappy")) {
                compressorsList.add(MongoCompressor.createSnappyCompressor());
            } else if (cur.equals("zstd")) {
                compressorsList.add(MongoCompressor.createZstdCompressor());
            } else if (!cur.isEmpty()) {
                throw new IllegalArgumentException("Unsupported compressor '" + cur + "'");
            }
        }
        return Collections.unmodifiableList(compressorsList);
    }

    @Nullable
    private WriteConcern createWriteConcern(Map<String, List<String>> optionsMap) {
        String w = null;
        Integer wTimeout = null;
        Boolean safe = null;
        Boolean journal = null;
        for (String key : WRITE_CONCERN_KEYS) {
            String value = getLastValue(optionsMap, key);
            if (value != null) {
                if (key.equals("safe")) {
                    safe = parseBoolean(value, "safe");
                } else if (key.equals("w")) {
                    w = value;
                } else if (key.equals("wtimeoutms")) {
                    wTimeout = Integer.valueOf(Integer.parseInt(value));
                } else if (key.equals("journal")) {
                    journal = parseBoolean(value, "journal");
                }
            }
        }
        return buildWriteConcern(safe, w, wTimeout, journal);
    }

    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:28:0x0019 */
    /* JADX DEBUG: Failed to insert an additional move for type inference into block B:29:0x0019 */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1 */
    /* JADX WARN: Type inference failed for: r10v2 */
    /* JADX WARN: Type inference failed for: r10v3, types: [long] */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.mongodb.lang.Nullable
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.mongodb.ReadPreference createReadPreference(java.util.Map<java.lang.String, java.util.List<java.lang.String>> r7) {
        /*
            r6 = this;
            r0 = 0
            r8 = r0
            java.util.ArrayList r0 = new java.util.ArrayList
            r1 = r0
            r1.<init>()
            r9 = r0
            r0 = -1
            r10 = r0
            java.util.Set<java.lang.String> r0 = com.mongodb.ConnectionString.READ_PREFERENCE_KEYS
            java.util.Iterator r0 = r0.iterator()
            r12 = r0
        L_0x0019:
            r0 = r12
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00b4
            r0 = r12
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r13 = r0
            r0 = r6
            r1 = r7
            r2 = r13
            java.lang.String r0 = r0.getLastValue(r1, r2)
            r14 = r0
            r0 = r14
            if (r0 != 0) goto L_0x0040
            goto L_0x0019
        L_0x0040:
            r0 = r13
            java.lang.String r1 = "readpreference"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0050
            r0 = r14
            r8 = r0
            goto L_0x00b1
        L_0x0050:
            r0 = r13
            java.lang.String r1 = "maxstalenessseconds"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x0068
            r0 = r6
            r1 = r14
            java.lang.String r2 = "maxstalenessseconds"
            int r0 = r0.parseInteger(r1, r2)
            long r0 = (long) r0
            r10 = r0
            goto L_0x00b1
        L_0x0068:
            r0 = r13
            java.lang.String r1 = "readpreferencetags"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x00b1
            r0 = r7
            r1 = r13
            java.lang.Object r0 = r0.get(r1)
            java.util.List r0 = (java.util.List) r0
            java.util.Iterator r0 = r0.iterator()
            r15 = r0
        L_0x0084:
            r0 = r15
            boolean r0 = r0.hasNext()
            if (r0 == 0) goto L_0x00b1
            r0 = r15
            java.lang.Object r0 = r0.next()
            java.lang.String r0 = (java.lang.String) r0
            r16 = r0
            r0 = r6
            r1 = r16
            java.lang.String r1 = r1.trim()
            com.mongodb.TagSet r0 = r0.getTags(r1)
            r17 = r0
            r0 = r9
            r1 = r17
            boolean r0 = r0.add(r1)
            goto L_0x0084
        L_0x00b1:
            goto L_0x0019
        L_0x00b4:
            r0 = r6
            r1 = r8
            r2 = r9
            r3 = r10
            com.mongodb.ReadPreference r0 = r0.buildReadPreference(r1, r2, r3)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mongodb.ConnectionString.createReadPreference(java.util.Map):com.mongodb.ReadPreference");
    }

    private UuidRepresentation createUuidRepresentation(String value) {
        if (value.equalsIgnoreCase("unspecified")) {
            return UuidRepresentation.UNSPECIFIED;
        }
        if (value.equalsIgnoreCase("javaLegacy")) {
            return UuidRepresentation.JAVA_LEGACY;
        }
        if (value.equalsIgnoreCase("csharpLegacy")) {
            return UuidRepresentation.C_SHARP_LEGACY;
        }
        if (value.equalsIgnoreCase("pythonLegacy")) {
            return UuidRepresentation.PYTHON_LEGACY;
        }
        if (value.equalsIgnoreCase("standard")) {
            return UuidRepresentation.STANDARD;
        }
        throw new IllegalArgumentException("Unknown uuid representation: " + value);
    }

    @Nullable
    private MongoCredential createCredentials(Map<String, List<String>> optionsMap, @Nullable String userName, @Nullable char[] password) {
        AuthenticationMechanism mechanism = null;
        String authSource = null;
        String gssapiServiceName = null;
        String authMechanismProperties = null;
        for (String key : AUTH_KEYS) {
            String value = getLastValue(optionsMap, key);
            if (value != null) {
                if (key.equals("authmechanism")) {
                    if (!value.equals("MONGODB-CR")) {
                        mechanism = AuthenticationMechanism.fromMechanismName(value);
                    } else if (userName == null) {
                        throw new IllegalArgumentException("username can not be null");
                    } else {
                        LOGGER.warn("Deprecated MONGDOB-CR authentication mechanism used in connection string");
                    }
                } else if (key.equals("authsource")) {
                    if (value.equals("")) {
                        throw new IllegalArgumentException("authSource can not be an empty string");
                    }
                    authSource = value;
                } else if (key.equals("gssapiservicename")) {
                    gssapiServiceName = value;
                } else if (key.equals("authmechanismproperties")) {
                    authMechanismProperties = value;
                }
            }
        }
        MongoCredential credential = null;
        if (mechanism != null) {
            credential = createMongoCredentialWithMechanism(mechanism, userName, password, authSource, gssapiServiceName);
        } else if (userName != null) {
            credential = MongoCredential.createCredential(userName, getAuthSourceOrDefault(authSource, this.database != null ? this.database : "admin"), password);
        }
        if (!(credential == null || authMechanismProperties == null)) {
            String[] split = authMechanismProperties.split(",");
            for (String part : split) {
                String[] mechanismPropertyKeyValue = part.split(EmitterKt.COMMENT_PREFIX);
                if (mechanismPropertyKeyValue.length != 2) {
                    throw new IllegalArgumentException(String.format("The connection string contains invalid authentication properties. '%s' is not a key value pair", part));
                }
                String key2 = mechanismPropertyKeyValue[0].trim().toLowerCase();
                String value2 = mechanismPropertyKeyValue[1].trim();
                if (key2.equals("canonicalize_host_name")) {
                    credential = credential.withMechanismProperty(key2, Boolean.valueOf(value2));
                } else {
                    credential = credential.withMechanismProperty(key2, value2);
                }
            }
        }
        return credential;
    }

    private MongoCredential createMongoCredentialWithMechanism(AuthenticationMechanism mechanism, String userName, @Nullable char[] password, @Nullable String authSource, @Nullable String gssapiServiceName) {
        String mechanismAuthSource;
        MongoCredential credential;
        switch (mechanism) {
            case PLAIN:
                mechanismAuthSource = getAuthSourceOrDefault(authSource, this.database != null ? this.database : "$external");
                break;
            case GSSAPI:
            case MONGODB_X509:
                mechanismAuthSource = getAuthSourceOrDefault(authSource, "$external");
                if (!mechanismAuthSource.equals("$external")) {
                    throw new IllegalArgumentException(String.format("Invalid authSource for %s, it must be '$external'", mechanism));
                }
                break;
            default:
                mechanismAuthSource = getAuthSourceOrDefault(authSource, this.database != null ? this.database : "admin");
                break;
        }
        switch (mechanism) {
            case PLAIN:
                credential = MongoCredential.createPlainCredential(userName, mechanismAuthSource, password);
                break;
            case GSSAPI:
                credential = MongoCredential.createGSSAPICredential(userName);
                if (gssapiServiceName != null) {
                    credential = credential.withMechanismProperty(MongoCredential.SERVICE_NAME_KEY, gssapiServiceName);
                }
                if (password != null && LOGGER.isWarnEnabled()) {
                    LOGGER.warn("Password in connection string not used with MONGODB_X509 authentication mechanism.");
                    break;
                }
                break;
            case MONGODB_X509:
                if (password == null) {
                    credential = MongoCredential.createMongoX509Credential(userName);
                    break;
                } else {
                    throw new IllegalArgumentException("Invalid mechanism, MONGODB_x509 does not support passwords");
                }
            case SCRAM_SHA_1:
                credential = MongoCredential.createScramSha1Credential(userName, mechanismAuthSource, password);
                break;
            case SCRAM_SHA_256:
                credential = MongoCredential.createScramSha256Credential(userName, mechanismAuthSource, password);
                break;
            case MONGODB_AWS:
                credential = MongoCredential.createAwsCredential(userName, password);
                break;
            default:
                throw new UnsupportedOperationException(String.format("The connection string contains an invalid authentication mechanism'. '%s' is not a supported authentication mechanism", mechanism));
        }
        return credential;
    }

    private String getAuthSourceOrDefault(@Nullable String authSource, String defaultAuthSource) {
        if (authSource != null) {
            return authSource;
        }
        return defaultAuthSource;
    }

    @Nullable
    private String getLastValue(Map<String, List<String>> optionsMap, String key) {
        List<String> valueList = optionsMap.get(key);
        if (valueList == null) {
            return null;
        }
        return valueList.get(valueList.size() - 1);
    }

    private Map<String, List<String>> parseOptions(String optionsPart) {
        Map<String, List<String>> optionsMap = new HashMap<>();
        if (optionsPart.length() == 0) {
            return optionsMap;
        }
        String[] split = optionsPart.split("&|;");
        for (String part : split) {
            if (part.length() != 0) {
                int idx = part.indexOf("=");
                if (idx >= 0) {
                    String key = part.substring(0, idx).toLowerCase();
                    String value = part.substring(idx + 1);
                    List<String> valueList = optionsMap.get(key);
                    if (valueList == null) {
                        valueList = new ArrayList(1);
                    }
                    valueList.add(urldecode(value));
                    optionsMap.put(key, valueList);
                } else {
                    throw new IllegalArgumentException(String.format("The connection string contains an invalid option '%s'. '%s' is missing the value delimiter eg '%s=value'", optionsPart, part, part));
                }
            }
        }
        if (optionsMap.containsKey("wtimeout") && !optionsMap.containsKey("wtimeoutms")) {
            optionsMap.put("wtimeoutms", optionsMap.remove("wtimeout"));
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Uri option 'wtimeout' has been deprecated, use 'wtimeoutms' instead.");
            }
        }
        String slaveok = getLastValue(optionsMap, "slaveok");
        if (slaveok != null && !optionsMap.containsKey("readpreference")) {
            optionsMap.put("readpreference", Collections.singletonList(Boolean.TRUE.equals(parseBoolean(slaveok, "slaveok")) ? "secondaryPreferred" : "primary"));
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Uri option 'slaveok' has been deprecated, use 'readpreference' instead.");
            }
        }
        if (optionsMap.containsKey("j") && !optionsMap.containsKey("journal")) {
            optionsMap.put("journal", optionsMap.remove("j"));
            if (LOGGER.isWarnEnabled()) {
                LOGGER.warn("Uri option 'j' has been deprecated, use 'journal' instead.");
            }
        }
        return optionsMap;
    }

    @Nullable
    private ReadPreference buildReadPreference(@Nullable String readPreferenceType, List<TagSet> tagSetList, long maxStalenessSeconds) {
        if (readPreferenceType != null) {
            if (tagSetList.isEmpty() && maxStalenessSeconds == -1) {
                return ReadPreference.valueOf(readPreferenceType);
            }
            if (maxStalenessSeconds == -1) {
                return ReadPreference.valueOf(readPreferenceType, tagSetList);
            }
            return ReadPreference.valueOf(readPreferenceType, tagSetList, maxStalenessSeconds, TimeUnit.SECONDS);
        } else if (tagSetList.isEmpty() && maxStalenessSeconds == -1) {
            return null;
        } else {
            throw new IllegalArgumentException("Read preference mode must be specified if either read preference tags or max staleness is specified");
        }
    }

    @Nullable
    private WriteConcern buildWriteConcern(@Nullable Boolean safe, @Nullable String w, @Nullable Integer wTimeout, @Nullable Boolean journal) {
        WriteConcern retVal;
        WriteConcern retVal2 = null;
        if (w == null && wTimeout == null && journal == null) {
            if (safe != null) {
                if (safe.booleanValue()) {
                    retVal2 = WriteConcern.ACKNOWLEDGED;
                } else {
                    retVal2 = WriteConcern.UNACKNOWLEDGED;
                }
            }
            return retVal2;
        }
        if (w == null) {
            retVal = WriteConcern.ACKNOWLEDGED;
        } else {
            try {
                retVal = new WriteConcern(Integer.parseInt(w));
            } catch (NumberFormatException e) {
                retVal = new WriteConcern(w);
            }
        }
        if (wTimeout != null) {
            retVal = retVal.withWTimeout((long) wTimeout.intValue(), TimeUnit.MILLISECONDS);
        }
        if (journal != null) {
            retVal = retVal.withJournal(journal);
        }
        return retVal;
    }

    private TagSet getTags(String tagSetString) {
        List<Tag> tagList = new ArrayList<>();
        if (tagSetString.length() > 0) {
            for (String tag : tagSetString.split(",")) {
                String[] tagKeyValuePair = tag.split(EmitterKt.COMMENT_PREFIX);
                if (tagKeyValuePair.length != 2) {
                    throw new IllegalArgumentException(String.format("The connection string contains an invalid read preference tag. '%s' is not a key value pair", tagSetString));
                }
                tagList.add(new Tag(tagKeyValuePair[0].trim(), tagKeyValuePair[1].trim()));
            }
        }
        return new TagSet(tagList);
    }

    @Nullable
    private Boolean parseBoolean(String input, String key) {
        String trimmedInput = input.trim().toLowerCase();
        if (TRUE_VALUES.contains(trimmedInput)) {
            if (!trimmedInput.equals(C3P0Substitutions.DEBUG)) {
                LOGGER.warn(String.format("Deprecated boolean value '%s' in the connection string for '%s'. Replace with 'true'", trimmedInput, key));
            }
            return true;
        } else if (FALSE_VALUES.contains(trimmedInput)) {
            if (!trimmedInput.equals("false")) {
                LOGGER.warn(String.format("Deprecated boolean value '%s' in the connection string for '%s'. Replace with'false'", trimmedInput, key));
            }
            return false;
        } else {
            LOGGER.warn(String.format("Ignoring unrecognized boolean value '%s' in the connection string for '%s'. Replace with either 'true' or 'false'", trimmedInput, key));
            return null;
        }
    }

    private int parseInteger(String input, String key) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(String.format("The connection string contains an invalid value for '%s'. '%s' is not a valid integer", key, input));
        }
    }

    private List<String> parseHosts(List<String> rawHosts) {
        if (rawHosts.size() == 0) {
            throw new IllegalArgumentException("The connection string must contain at least one host");
        }
        List<String> hosts = new ArrayList<>();
        for (String host : rawHosts) {
            if (host.length() == 0) {
                throw new IllegalArgumentException(String.format("The connection string contains an empty host '%s'. ", rawHosts));
            }
            if (host.endsWith(".sock")) {
                host = urldecode(host);
            } else if (!host.startsWith("[")) {
                int colonCount = countOccurrences(host, EmitterKt.COMMENT_PREFIX);
                if (colonCount > 1) {
                    throw new IllegalArgumentException(String.format("The connection string contains an invalid host '%s'. Reserved characters such as ':' must be escaped according RFC 2396. Any IPv6 address literal must be enclosed in '[' and ']' according to RFC 2732.", host));
                } else if (colonCount == 1) {
                    validatePort(host, host.substring(host.indexOf(EmitterKt.COMMENT_PREFIX) + 1));
                }
            } else if (!host.contains("]")) {
                throw new IllegalArgumentException(String.format("The connection string contains an invalid host '%s'. IPv6 address literals must be enclosed in '[' and ']' according to RFC 2732", host));
            } else {
                int idx = host.indexOf("]:");
                if (idx != -1) {
                    validatePort(host, host.substring(idx + 2));
                }
            }
            hosts.add(host);
        }
        Collections.sort(hosts);
        return hosts;
    }

    private void validatePort(String host, String port) {
        boolean invalidPort = false;
        try {
            int portInt = Integer.parseInt(port);
            if (portInt <= 0 || portInt > 65535) {
                invalidPort = true;
            }
        } catch (NumberFormatException e) {
            invalidPort = true;
        }
        if (invalidPort) {
            throw new IllegalArgumentException(String.format("The connection string contains an invalid host '%s'. The port '%s' is not a valid, it must be an integer between 0 and 65535", host, port));
        }
    }

    private int countOccurrences(String haystack, String needle) {
        return haystack.length() - haystack.replace(needle, "").length();
    }

    private String urldecode(String input) {
        return urldecode(input, false);
    }

    private String urldecode(String input, boolean password) {
        try {
            return URLDecoder.decode(input, UTF_8);
        } catch (UnsupportedEncodingException e) {
            if (password) {
                throw new IllegalArgumentException("The connection string contained unsupported characters in the password.");
            }
            throw new IllegalArgumentException(String.format("The connection string contained unsupported characters: '%s'.Decoding produced the following error: %s", input, e.getMessage()));
        }
    }

    @Nullable
    public String getUsername() {
        if (this.credential != null) {
            return this.credential.getUserName();
        }
        return null;
    }

    @Nullable
    public char[] getPassword() {
        if (this.credential != null) {
            return this.credential.getPassword();
        }
        return null;
    }

    public boolean isSrvProtocol() {
        return this.isSrvProtocol;
    }

    public List<String> getHosts() {
        return this.hosts;
    }

    @Nullable
    public String getDatabase() {
        return this.database;
    }

    @Nullable
    public String getCollection() {
        return this.collection;
    }

    @Nullable
    public Boolean isDirectConnection() {
        return this.directConnection;
    }

    public String getConnectionString() {
        return this.connectionString;
    }

    @Nullable
    public MongoCredential getCredential() {
        return this.credential;
    }

    @Nullable
    public ReadPreference getReadPreference() {
        return this.readPreference;
    }

    @Nullable
    public ReadConcern getReadConcern() {
        return this.readConcern;
    }

    @Nullable
    public WriteConcern getWriteConcern() {
        return this.writeConcern;
    }

    @Nullable
    public Boolean getRetryWritesValue() {
        return this.retryWrites;
    }

    @Nullable
    public Boolean getRetryReads() {
        return this.retryReads;
    }

    @Nullable
    public Integer getMinConnectionPoolSize() {
        return this.minConnectionPoolSize;
    }

    @Nullable
    public Integer getMaxConnectionPoolSize() {
        return this.maxConnectionPoolSize;
    }

    @Nullable
    public Integer getMaxWaitTime() {
        return this.maxWaitTime;
    }

    @Nullable
    public Integer getMaxConnectionIdleTime() {
        return this.maxConnectionIdleTime;
    }

    @Nullable
    public Integer getMaxConnectionLifeTime() {
        return this.maxConnectionLifeTime;
    }

    @Nullable
    public Integer getConnectTimeout() {
        return this.connectTimeout;
    }

    @Nullable
    public Integer getSocketTimeout() {
        return this.socketTimeout;
    }

    @Nullable
    public Boolean getSslEnabled() {
        return this.sslEnabled;
    }

    @Nullable
    public Boolean getSslInvalidHostnameAllowed() {
        return this.sslInvalidHostnameAllowed;
    }

    @Nullable
    public String getRequiredReplicaSetName() {
        return this.requiredReplicaSetName;
    }

    @Nullable
    public Integer getServerSelectionTimeout() {
        return this.serverSelectionTimeout;
    }

    @Nullable
    public Integer getLocalThreshold() {
        return this.localThreshold;
    }

    @Nullable
    public Integer getHeartbeatFrequency() {
        return this.heartbeatFrequency;
    }

    @Nullable
    public String getApplicationName() {
        return this.applicationName;
    }

    public List<MongoCompressor> getCompressorList() {
        return this.compressorList;
    }

    @Nullable
    public UuidRepresentation getUuidRepresentation() {
        return this.uuidRepresentation;
    }

    public String toString() {
        return this.connectionString;
    }

    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ConnectionString that = (ConnectionString) o;
        return this.isSrvProtocol == that.isSrvProtocol && Objects.equals(this.directConnection, that.directConnection) && Objects.equals(this.credential, that.credential) && Objects.equals(this.hosts, that.hosts) && Objects.equals(this.database, that.database) && Objects.equals(this.collection, that.collection) && Objects.equals(this.readPreference, that.readPreference) && Objects.equals(this.writeConcern, that.writeConcern) && Objects.equals(this.retryWrites, that.retryWrites) && Objects.equals(this.retryReads, that.retryReads) && Objects.equals(this.readConcern, that.readConcern) && Objects.equals(this.minConnectionPoolSize, that.minConnectionPoolSize) && Objects.equals(this.maxConnectionPoolSize, that.maxConnectionPoolSize) && Objects.equals(this.maxWaitTime, that.maxWaitTime) && Objects.equals(this.maxConnectionIdleTime, that.maxConnectionIdleTime) && Objects.equals(this.maxConnectionLifeTime, that.maxConnectionLifeTime) && Objects.equals(this.connectTimeout, that.connectTimeout) && Objects.equals(this.socketTimeout, that.socketTimeout) && Objects.equals(this.sslEnabled, that.sslEnabled) && Objects.equals(this.sslInvalidHostnameAllowed, that.sslInvalidHostnameAllowed) && Objects.equals(this.requiredReplicaSetName, that.requiredReplicaSetName) && Objects.equals(this.serverSelectionTimeout, that.serverSelectionTimeout) && Objects.equals(this.localThreshold, that.localThreshold) && Objects.equals(this.heartbeatFrequency, that.heartbeatFrequency) && Objects.equals(this.applicationName, that.applicationName) && Objects.equals(this.compressorList, that.compressorList) && Objects.equals(this.uuidRepresentation, that.uuidRepresentation);
    }

    public int hashCode() {
        return Objects.hash(this.credential, Boolean.valueOf(this.isSrvProtocol), this.hosts, this.database, this.collection, this.directConnection, this.readPreference, this.writeConcern, this.retryWrites, this.retryReads, this.readConcern, this.minConnectionPoolSize, this.maxConnectionPoolSize, this.maxWaitTime, this.maxConnectionIdleTime, this.maxConnectionLifeTime, this.connectTimeout, this.socketTimeout, this.sslEnabled, this.sslInvalidHostnameAllowed, this.requiredReplicaSetName, this.serverSelectionTimeout, this.localThreshold, this.heartbeatFrequency, this.applicationName, this.compressorList, this.uuidRepresentation);
    }
}
