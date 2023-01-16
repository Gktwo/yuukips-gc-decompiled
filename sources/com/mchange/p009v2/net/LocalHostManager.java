package com.mchange.p009v2.net;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

/* renamed from: com.mchange.v2.net.LocalHostManager */
/* loaded from: grasscutter.jar:com/mchange/v2/net/LocalHostManager.class */
public class LocalHostManager {
    Set localAddresses;
    Set knownGoodNames;
    Set knownBadNames;

    public synchronized void update() throws SocketException {
        HashSet hashSet = new HashSet();
        Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
        while (networkInterfaces.hasMoreElements()) {
            Enumeration<InetAddress> inetAddresses = networkInterfaces.nextElement().getInetAddresses();
            while (inetAddresses.hasMoreElements()) {
                hashSet.add(inetAddresses.nextElement());
            }
        }
        this.localAddresses = Collections.unmodifiableSet(hashSet);
        this.knownGoodNames = new HashSet();
        this.knownBadNames = new HashSet();
    }

    public synchronized Set getLocalAddresses() {
        return this.localAddresses;
    }

    public synchronized boolean isLocalAddress(InetAddress inetAddress) {
        return this.localAddresses.contains(inetAddress);
    }

    public synchronized boolean isLocalHostName(String str) {
        if (this.knownGoodNames.contains(str)) {
            return true;
        }
        if (this.knownBadNames.contains(str)) {
            return false;
        }
        try {
            if (this.localAddresses.contains(InetAddress.getByName(str))) {
                this.knownGoodNames.add(str);
                return true;
            }
            this.knownBadNames.add(str);
            return false;
        } catch (UnknownHostException e) {
            this.knownBadNames.add(str);
            return false;
        }
    }

    public LocalHostManager() throws SocketException {
        update();
    }

    public static void main(String[] strArr) {
        try {
            System.out.println(new LocalHostManager().getLocalAddresses());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
