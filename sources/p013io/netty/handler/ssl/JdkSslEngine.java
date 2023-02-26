package p013io.netty.handler.ssl;

import java.nio.ByteBuffer;
import javax.net.ssl.SSLEngine;
import javax.net.ssl.SSLEngineResult;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLParameters;
import javax.net.ssl.SSLSession;
import p013io.netty.util.internal.SuppressJava6Requirement;

/* renamed from: io.netty.handler.ssl.JdkSslEngine */
/* loaded from: grasscutter.jar:io/netty/handler/ssl/JdkSslEngine.class */
class JdkSslEngine extends SSLEngine implements ApplicationProtocolAccessor {
    private final SSLEngine engine;
    private volatile String applicationProtocol;

    /* access modifiers changed from: package-private */
    public JdkSslEngine(SSLEngine engine) {
        this.engine = engine;
    }

    @Override // p013io.netty.handler.ssl.ApplicationProtocolAccessor
    public String getNegotiatedApplicationProtocol() {
        return this.applicationProtocol;
    }

    /* access modifiers changed from: package-private */
    public void setNegotiatedApplicationProtocol(String applicationProtocol) {
        this.applicationProtocol = applicationProtocol;
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLSession getSession() {
        return this.engine.getSession();
    }

    public SSLEngine getWrappedEngine() {
        return this.engine;
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeInbound() throws SSLException {
        this.engine.closeInbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public void closeOutbound() {
        this.engine.closeOutbound();
    }

    @Override // javax.net.ssl.SSLEngine
    public String getPeerHost() {
        return this.engine.getPeerHost();
    }

    @Override // javax.net.ssl.SSLEngine
    public int getPeerPort() {
        return this.engine.getPeerPort();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.wrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBuffers, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBuffers, byteBuffer);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult wrap(ByteBuffer[] byteBuffers, int i, int i2, ByteBuffer byteBuffer) throws SSLException {
        return this.engine.wrap(byteBuffers, i, i2, byteBuffer);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer byteBuffer2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffer2);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBuffers) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffers);
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult unwrap(ByteBuffer byteBuffer, ByteBuffer[] byteBuffers, int i, int i2) throws SSLException {
        return this.engine.unwrap(byteBuffer, byteBuffers, i, i2);
    }

    @Override // javax.net.ssl.SSLEngine
    public Runnable getDelegatedTask() {
        return this.engine.getDelegatedTask();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isInboundDone() {
        return this.engine.isInboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean isOutboundDone() {
        return this.engine.isOutboundDone();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedCipherSuites() {
        return this.engine.getSupportedCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledCipherSuites() {
        return this.engine.getEnabledCipherSuites();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledCipherSuites(String[] strings) {
        this.engine.setEnabledCipherSuites(strings);
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getSupportedProtocols() {
        return this.engine.getSupportedProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public String[] getEnabledProtocols() {
        return this.engine.getEnabledProtocols();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnabledProtocols(String[] strings) {
        this.engine.setEnabledProtocols(strings);
    }

    @Override // javax.net.ssl.SSLEngine
    @SuppressJava6Requirement(reason = "Can only be called when running on JDK7+")
    public SSLSession getHandshakeSession() {
        return this.engine.getHandshakeSession();
    }

    @Override // javax.net.ssl.SSLEngine
    public void beginHandshake() throws SSLException {
        this.engine.beginHandshake();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLEngineResult.HandshakeStatus getHandshakeStatus() {
        return this.engine.getHandshakeStatus();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setUseClientMode(boolean b) {
        this.engine.setUseClientMode(b);
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getUseClientMode() {
        return this.engine.getUseClientMode();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setNeedClientAuth(boolean b) {
        this.engine.setNeedClientAuth(b);
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getNeedClientAuth() {
        return this.engine.getNeedClientAuth();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setWantClientAuth(boolean b) {
        this.engine.setWantClientAuth(b);
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getWantClientAuth() {
        return this.engine.getWantClientAuth();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setEnableSessionCreation(boolean b) {
        this.engine.setEnableSessionCreation(b);
    }

    @Override // javax.net.ssl.SSLEngine
    public boolean getEnableSessionCreation() {
        return this.engine.getEnableSessionCreation();
    }

    @Override // javax.net.ssl.SSLEngine
    public SSLParameters getSSLParameters() {
        return this.engine.getSSLParameters();
    }

    @Override // javax.net.ssl.SSLEngine
    public void setSSLParameters(SSLParameters sslParameters) {
        this.engine.setSSLParameters(sslParameters);
    }
}
