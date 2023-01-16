package org.eclipse.jetty.util.security;

import java.io.Serializable;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.Iterator;
import java.util.ServiceLoader;
import org.eclipse.jetty.util.TypeUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/Credential.class */
public abstract class Credential implements Serializable {
    private static final long serialVersionUID = -7760551052768181572L;
    private static final Logger LOG = Log.getLogger(Credential.class);
    private static final ServiceLoader<CredentialProvider> CREDENTIAL_PROVIDER_LOADER = ServiceLoader.load(CredentialProvider.class);

    public abstract boolean check(Object obj);

    public static Credential getCredential(String credential) {
        Credential credentialObj;
        if (credential.startsWith("CRYPT:")) {
            return new Crypt(credential);
        }
        if (credential.startsWith("MD5:")) {
            return new MD5(credential);
        }
        Iterator<CredentialProvider> it = CREDENTIAL_PROVIDER_LOADER.iterator();
        while (it.hasNext()) {
            CredentialProvider cp = it.next();
            if (credential.startsWith(cp.getPrefix()) && (credentialObj = cp.getCredential(credential)) != null) {
                return credentialObj;
            }
        }
        return new Password(credential);
    }

    protected static boolean stringEquals(String known, String unknown) {
        if (known == unknown) {
            return true;
        }
        if (known == null || unknown == null) {
            return false;
        }
        boolean result = true;
        int l1 = known.length();
        int l2 = unknown.length();
        for (int i = 0; i < l2; i++) {
            result &= (l1 == 0 ? unknown.charAt((l2 - i) - 1) : known.charAt(i % l1)) == unknown.charAt(i);
        }
        return result && l1 == l2;
    }

    protected static boolean byteEquals(byte[] known, byte[] unknown) {
        if (known == unknown) {
            return true;
        }
        if (known == null || unknown == null) {
            return false;
        }
        boolean result = true;
        int l1 = known.length;
        int l2 = unknown.length;
        for (int i = 0; i < l2; i++) {
            result &= (l1 == 0 ? unknown[(l2 - i) - 1] : known[i % l1]) == unknown[i];
        }
        return result && l1 == l2;
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/Credential$Crypt.class */
    public static class Crypt extends Credential {
        private static final long serialVersionUID = -2027792997664744210L;
        private static final String __TYPE = "CRYPT:";
        private final String _cooked;

        Crypt(String cooked) {
            this._cooked = cooked.startsWith(__TYPE) ? cooked.substring(__TYPE.length()) : cooked;
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object credentials) {
            if (credentials instanceof char[]) {
                credentials = new String((char[]) credentials);
            }
            if (!(credentials instanceof String) && !(credentials instanceof Password)) {
                Credential.LOG.warn("Can't check " + credentials.getClass() + " against CRYPT", new Object[0]);
            }
            return stringEquals(this._cooked, UnixCrypt.crypt(credentials.toString(), this._cooked));
        }

        @Override // java.lang.Object
        public boolean equals(Object credential) {
            if (!(credential instanceof Crypt)) {
                return false;
            }
            return stringEquals(this._cooked, ((Crypt) credential)._cooked);
        }

        public static String crypt(String user, String pw) {
            return __TYPE + UnixCrypt.crypt(pw, user);
        }
    }

    /* loaded from: grasscutter.jar:org/eclipse/jetty/util/security/Credential$MD5.class */
    public static class MD5 extends Credential {
        private static final long serialVersionUID = 5533846540822684240L;
        private static final String __TYPE = "MD5:";
        private static final Object __md5Lock = new Object();
        private static MessageDigest __md;
        private final byte[] _digest;

        MD5(String digest) {
            this._digest = TypeUtil.parseBytes(digest.startsWith(__TYPE) ? digest.substring(__TYPE.length()) : digest, 16);
        }

        public byte[] getDigest() {
            return this._digest;
        }

        @Override // org.eclipse.jetty.util.security.Credential
        public boolean check(Object credentials) {
            byte[] digest;
            try {
                if (credentials instanceof char[]) {
                    credentials = new String((char[]) credentials);
                }
                if ((credentials instanceof Password) || (credentials instanceof String)) {
                    synchronized (__md5Lock) {
                        if (__md == null) {
                            __md = MessageDigest.getInstance("MD5");
                        }
                        __md.reset();
                        __md.update(credentials.toString().getBytes(StandardCharsets.ISO_8859_1));
                        digest = __md.digest();
                    }
                    return byteEquals(this._digest, digest);
                } else if (credentials instanceof MD5) {
                    return equals(credentials);
                } else {
                    if (credentials instanceof Credential) {
                        return ((Credential) credentials).check(this);
                    }
                    Credential.LOG.warn("Can't check " + credentials.getClass() + " against MD5", new Object[0]);
                    return false;
                }
            } catch (Exception e) {
                Credential.LOG.warn(e);
                return false;
            }
        }

        @Override // java.lang.Object
        public boolean equals(Object obj) {
            if (obj instanceof MD5) {
                return byteEquals(this._digest, ((MD5) obj)._digest);
            }
            return false;
        }

        /*  JADX ERROR: JadxRuntimeException in pass: BlockProcessor
            jadx.core.utils.exceptions.JadxRuntimeException: Unreachable block: B:7:0x0017
            	at jadx.core.dex.visitors.blocks.BlockProcessor.checkForUnreachableBlocks(BlockProcessor.java:86)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.processBlocksTree(BlockProcessor.java:52)
            	at jadx.core.dex.visitors.blocks.BlockProcessor.visit(BlockProcessor.java:44)
            */
        public static java.lang.String digest(java.lang.String r4) {
            /*
                java.lang.Object r0 = org.eclipse.jetty.util.security.Credential.MD5.__md5Lock     // Catch: Exception -> 0x0064
                r1 = r0
                r6 = r1
                monitor-enter(r0)     // Catch: Exception -> 0x0064
                java.security.MessageDigest r0 = org.eclipse.jetty.util.security.Credential.MD5.__md     // Catch: all -> 0x0044, Exception -> 0x0064
                if (r0 != 0) goto L_0x0025
                java.lang.String r0 = "MD5"
                java.security.MessageDigest r0 = java.security.MessageDigest.getInstance(r0)     // Catch: Exception -> 0x0017, all -> 0x0044, Exception -> 0x0064
                org.eclipse.jetty.util.security.Credential.MD5.__md = r0     // Catch: Exception -> 0x0017, all -> 0x0044, Exception -> 0x0064
                goto L_0x0025
            L_0x0017:
                r7 = move-exception
                org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.security.Credential.access$000()     // Catch: all -> 0x0044, Exception -> 0x0064
                r1 = r7
                r0.warn(r1)     // Catch: all -> 0x0044, Exception -> 0x0064
                r0 = 0
                r1 = r6
                monitor-exit(r1)     // Catch: all -> 0x0044, Exception -> 0x0064
                return r0
            L_0x0025:
                java.security.MessageDigest r0 = org.eclipse.jetty.util.security.Credential.MD5.__md     // Catch: Exception -> 0x0064, all -> 0x0044
                r0.reset()     // Catch: Exception -> 0x0064, all -> 0x0044
                java.security.MessageDigest r0 = org.eclipse.jetty.util.security.Credential.MD5.__md     // Catch: Exception -> 0x0064, all -> 0x0044
                r1 = r4
                java.nio.charset.Charset r2 = java.nio.charset.StandardCharsets.ISO_8859_1     // Catch: Exception -> 0x0064, all -> 0x0044
                byte[] r1 = r1.getBytes(r2)     // Catch: Exception -> 0x0064, all -> 0x0044
                r0.update(r1)     // Catch: Exception -> 0x0064, all -> 0x0044
                java.security.MessageDigest r0 = org.eclipse.jetty.util.security.Credential.MD5.__md     // Catch: Exception -> 0x0064, all -> 0x0044
                byte[] r0 = r0.digest()     // Catch: Exception -> 0x0064, all -> 0x0044
                r5 = r0
                r0 = r6
                monitor-exit(r0)     // Catch: Exception -> 0x0064, all -> 0x0044
                goto L_0x004b
            L_0x0044:
                r8 = move-exception
                r0 = r6
                monitor-exit(r0)     // Catch: Exception -> 0x0064, all -> 0x0044
                r0 = r8
                throw r0     // Catch: Exception -> 0x0064
            L_0x004b:
                java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: Exception -> 0x0064
                r1 = r0
                r1.<init>()     // Catch: Exception -> 0x0064
                java.lang.String r1 = "MD5:"
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: Exception -> 0x0064
                r1 = r5
                r2 = 16
                java.lang.String r1 = org.eclipse.jetty.util.TypeUtil.toString(r1, r2)     // Catch: Exception -> 0x0064
                java.lang.StringBuilder r0 = r0.append(r1)     // Catch: Exception -> 0x0064
                java.lang.String r0 = r0.toString()     // Catch: Exception -> 0x0064
                return r0
            L_0x0064:
                r5 = move-exception
                org.eclipse.jetty.util.log.Logger r0 = org.eclipse.jetty.util.security.Credential.access$000()
                r1 = r5
                r0.warn(r1)
                r0 = 0
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: org.eclipse.jetty.util.security.Credential.MD5.digest(java.lang.String):java.lang.String");
        }
    }
}
