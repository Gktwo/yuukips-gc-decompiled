package org.eclipse.jetty.util.ssl;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import org.eclipse.jetty.util.Scanner;
import org.eclipse.jetty.util.annotation.ManagedAttribute;
import org.eclipse.jetty.util.annotation.ManagedOperation;
import org.eclipse.jetty.util.component.ContainerLifeCycle;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.util.resource.Resource;

/* loaded from: grasscutter.jar:org/eclipse/jetty/util/ssl/KeyStoreScanner.class */
public class KeyStoreScanner extends ContainerLifeCycle implements Scanner.DiscreteListener {
    private static final Logger LOG = Log.getLogger(KeyStoreScanner.class);
    private final SslContextFactory sslContextFactory;
    private final File keystoreFile;
    private final Scanner _scanner;

    public KeyStoreScanner(SslContextFactory sslContextFactory) {
        this.sslContextFactory = sslContextFactory;
        try {
            Resource keystoreResource = sslContextFactory.getKeyStoreResource();
            File monitoredFile = keystoreResource.getFile();
            if (monitoredFile == null || !monitoredFile.exists()) {
                throw new IllegalArgumentException("keystore file does not exist");
            } else if (monitoredFile.isDirectory()) {
                throw new IllegalArgumentException("expected keystore file not directory");
            } else {
                monitoredFile = keystoreResource.getAlias() != null ? new File(keystoreResource.getAlias()) : monitoredFile;
                this.keystoreFile = monitoredFile;
                if (LOG.isDebugEnabled()) {
                    LOG.debug("Monitored Keystore File: {}", monitoredFile);
                }
                File parentFile = this.keystoreFile.getParentFile();
                if (!parentFile.exists() || !parentFile.isDirectory()) {
                    throw new IllegalArgumentException("error obtaining keystore dir");
                }
                this._scanner = new Scanner();
                this._scanner.setScanDirs(Collections.singletonList(parentFile));
                this._scanner.setScanInterval(1);
                this._scanner.setReportDirs(false);
                this._scanner.setReportExistingFilesOnStartup(false);
                this._scanner.setScanDepth(1);
                this._scanner.addListener(this);
                addBean(this._scanner);
            }
        } catch (IOException e) {
            throw new IllegalArgumentException("could not obtain keystore file", e);
        }
    }

    @Override // org.eclipse.jetty.util.Scanner.DiscreteListener
    public void fileAdded(String filename) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("added {}", filename);
        }
        if (this.keystoreFile.toPath().toString().equals(filename)) {
            reload();
        }
    }

    @Override // org.eclipse.jetty.util.Scanner.DiscreteListener
    public void fileChanged(String filename) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("changed {}", filename);
        }
        if (this.keystoreFile.toPath().toString().equals(filename)) {
            reload();
        }
    }

    @Override // org.eclipse.jetty.util.Scanner.DiscreteListener
    public void fileRemoved(String filename) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("removed {}", filename);
        }
        if (this.keystoreFile.toPath().toString().equals(filename)) {
            reload();
        }
    }

    @ManagedOperation(value = "Scan for changes in the SSL Keystore", impact = "ACTION")
    public void scan() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("scanning", new Object[0]);
        }
        this._scanner.scan();
        this._scanner.scan();
    }

    @ManagedOperation(value = "Reload the SSL Keystore", impact = "ACTION")
    public void reload() {
        if (LOG.isDebugEnabled()) {
            LOG.debug("reloading keystore file {}", this.keystoreFile);
        }
        try {
            this.sslContextFactory.reload(scf -> {
            });
        } catch (Throwable t) {
            LOG.warn("Keystore Reload Failed", t);
        }
    }

    @ManagedAttribute("scanning interval to detect changes which need reloaded")
    public int getScanInterval() {
        return this._scanner.getScanInterval();
    }

    public void setScanInterval(int scanInterval) {
        this._scanner.setScanInterval(scanInterval);
    }
}
