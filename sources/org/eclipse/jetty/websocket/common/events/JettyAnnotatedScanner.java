package org.eclipse.jetty.websocket.common.events;

import java.io.InputStream;
import java.io.Reader;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketClose;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketConnect;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketError;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketFrame;
import org.eclipse.jetty.websocket.api.annotations.OnWebSocketMessage;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.events.annotated.AbstractMethodAnnotationScanner;
import org.eclipse.jetty.websocket.common.events.annotated.CallableMethod;
import org.eclipse.jetty.websocket.common.events.annotated.InvalidSignatureException;
import org.eclipse.jetty.websocket.common.events.annotated.OptionalSessionCallableMethod;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/events/JettyAnnotatedScanner.class */
public class JettyAnnotatedScanner extends AbstractMethodAnnotationScanner<JettyAnnotatedMetadata> {
    private static final Logger LOG = Log.getLogger(JettyAnnotatedScanner.class);
    private static final ParamList validConnectParams = new ParamList();
    private static final ParamList validCloseParams = new ParamList();
    private static final ParamList validErrorParams = new ParamList();
    private static final ParamList validTextParams = new ParamList();
    private static final ParamList validBinaryParams = new ParamList();
    private static final ParamList validFrameParams = new ParamList();

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object, java.lang.Class, java.lang.reflect.Method, java.lang.annotation.Annotation] */
    @Override // org.eclipse.jetty.websocket.common.events.annotated.AbstractMethodAnnotationScanner
    public /* bridge */ /* synthetic */ void onMethodAnnotation(JettyAnnotatedMetadata jettyAnnotatedMetadata, Class cls, Method method, Annotation annotation) {
        onMethodAnnotation(jettyAnnotatedMetadata, (Class<?>) cls, method, annotation);
    }

    static {
        validConnectParams.addParams(Session.class);
        validCloseParams.addParams(Integer.TYPE, String.class);
        validCloseParams.addParams(Session.class, Integer.TYPE, String.class);
        validErrorParams.addParams(Throwable.class);
        validErrorParams.addParams(Session.class, Throwable.class);
        validTextParams.addParams(String.class);
        validTextParams.addParams(Session.class, String.class);
        validTextParams.addParams(Reader.class);
        validTextParams.addParams(Session.class, Reader.class);
        validBinaryParams.addParams(byte[].class, Integer.TYPE, Integer.TYPE);
        validBinaryParams.addParams(Session.class, byte[].class, Integer.TYPE, Integer.TYPE);
        validBinaryParams.addParams(InputStream.class);
        validBinaryParams.addParams(Session.class, InputStream.class);
        validFrameParams.addParams(Frame.class);
        validFrameParams.addParams(Session.class, Frame.class);
    }

    public void onMethodAnnotation(JettyAnnotatedMetadata metadata, Class<?> pojo, Method method, Annotation annotation) {
        if (LOG.isDebugEnabled()) {
            LOG.debug("onMethodAnnotation({}, {}, {}, {})", metadata, pojo, method, annotation);
        }
        if (isAnnotation(annotation, OnWebSocketConnect.class)) {
            assertValidSignature(method, OnWebSocketConnect.class, validConnectParams);
            assertUnset(metadata.onConnect, OnWebSocketConnect.class, method);
            metadata.onConnect = new CallableMethod(pojo, method);
        } else if (isAnnotation(annotation, OnWebSocketMessage.class)) {
            if (isSignatureMatch(method, validTextParams)) {
                assertUnset(metadata.onText, OnWebSocketMessage.class, method);
                metadata.onText = new OptionalSessionCallableMethod(pojo, method);
            } else if (isSignatureMatch(method, validBinaryParams)) {
                assertUnset(metadata.onBinary, OnWebSocketMessage.class, method);
                metadata.onBinary = new OptionalSessionCallableMethod(pojo, method);
            } else {
                throw InvalidSignatureException.build(method, OnWebSocketMessage.class, validTextParams, validBinaryParams);
            }
        } else if (isAnnotation(annotation, OnWebSocketClose.class)) {
            assertValidSignature(method, OnWebSocketClose.class, validCloseParams);
            assertUnset(metadata.onClose, OnWebSocketClose.class, method);
            metadata.onClose = new OptionalSessionCallableMethod(pojo, method);
        } else if (isAnnotation(annotation, OnWebSocketError.class)) {
            assertValidSignature(method, OnWebSocketError.class, validErrorParams);
            assertUnset(metadata.onError, OnWebSocketError.class, method);
            metadata.onError = new OptionalSessionCallableMethod(pojo, method);
        } else if (isAnnotation(annotation, OnWebSocketFrame.class)) {
            assertValidSignature(method, OnWebSocketFrame.class, validFrameParams);
            assertUnset(metadata.onFrame, OnWebSocketFrame.class, method);
            metadata.onFrame = new OptionalSessionCallableMethod(pojo, method);
        }
    }

    public JettyAnnotatedMetadata scan(Class<?> pojo) {
        JettyAnnotatedMetadata metadata = new JettyAnnotatedMetadata();
        scanMethodAnnotations(metadata, pojo);
        return metadata;
    }
}
