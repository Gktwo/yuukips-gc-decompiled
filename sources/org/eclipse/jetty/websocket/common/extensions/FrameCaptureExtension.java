package org.eclipse.jetty.websocket.common.extensions;

import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SeekableByteChannel;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import org.eclipse.jetty.util.C5747IO;
import org.eclipse.jetty.util.StringUtil;
import org.eclipse.jetty.util.log.Log;
import org.eclipse.jetty.util.log.Logger;
import org.eclipse.jetty.websocket.api.BatchMode;
import org.eclipse.jetty.websocket.api.WebSocketPolicy;
import org.eclipse.jetty.websocket.api.WriteCallback;
import org.eclipse.jetty.websocket.api.extensions.ExtensionConfig;
import org.eclipse.jetty.websocket.api.extensions.Frame;
import org.eclipse.jetty.websocket.common.Generator;
import org.eclipse.jetty.websocket.common.WebSocketFrame;
import org.jline.builtins.Tmux;

/* loaded from: grasscutter.jar:org/eclipse/jetty/websocket/common/extensions/FrameCaptureExtension.class */
public class FrameCaptureExtension extends AbstractExtension {
    private static final Logger LOG = Log.getLogger(FrameCaptureExtension.class);
    private static final int BUFSIZE = 32768;
    private Generator generator;
    private Path outputDir;
    private Path incomingFramesPath;
    private Path outgoingFramesPath;
    private SeekableByteChannel incomingChannel;
    private SeekableByteChannel outgoingChannel;
    private String prefix = "frame";
    private AtomicInteger incomingCount = new AtomicInteger(0);
    private AtomicInteger outgoingCount = new AtomicInteger(0);

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension, org.eclipse.jetty.websocket.api.extensions.Extension
    public String getName() {
        return "@frame-capture";
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.IncomingFrames
    public void incomingFrame(Frame frame) {
        saveFrame(frame, false);
        try {
            nextIncomingFrame(frame);
        } catch (Throwable t) {
            C5747IO.close(this.incomingChannel);
            this.incomingChannel = null;
            throw t;
        }
    }

    @Override // org.eclipse.jetty.websocket.api.extensions.OutgoingFrames
    public void outgoingFrame(Frame frame, WriteCallback callback, BatchMode batchMode) {
        saveFrame(frame, true);
        try {
            nextOutgoingFrame(frame, callback, batchMode);
        } catch (Throwable t) {
            C5747IO.close(this.outgoingChannel);
            this.outgoingChannel = null;
            throw t;
        }
    }

    private void saveFrame(Frame frame, boolean outgoing) {
        ByteBuffer buf;
        if (this.outputDir != null && this.generator != null) {
            SeekableByteChannel channel = outgoing ? this.outgoingChannel : this.incomingChannel;
            if (channel != null) {
                try {
                    buf = getBufferPool().acquire(32768, false);
                    try {
                        WebSocketFrame f = WebSocketFrame.copy(frame);
                        f.setMasked(false);
                        this.generator.generateHeaderBytes(f, buf);
                        channel.write(buf);
                        if (frame.hasPayload()) {
                            channel.write(frame.getPayload().slice());
                        }
                        if (LOG.isDebugEnabled()) {
                            Logger logger = LOG;
                            Object[] objArr = new Object[2];
                            objArr[0] = outgoing ? "outgoing" : "incoming";
                            objArr[1] = Integer.valueOf(outgoing ? this.outgoingCount.incrementAndGet() : this.incomingCount.incrementAndGet());
                            logger.debug("Saved {} frame #{}", objArr);
                        }
                        getBufferPool().release(buf);
                    } catch (IOException e) {
                        LOG.warn("Unable to save frame: " + frame, e);
                        getBufferPool().release(buf);
                    }
                } catch (Throwable th) {
                    getBufferPool().release(buf);
                    throw th;
                }
            }
        }
    }

    @Override // org.eclipse.jetty.websocket.common.extensions.AbstractExtension
    public void setConfig(ExtensionConfig config) {
        setConfig(config);
        String cfgOutputDir = config.getParameter("output-dir", (String) null);
        if (StringUtil.isNotBlank(cfgOutputDir)) {
            Path path = new File(cfgOutputDir).toPath();
            if (!Files.isDirectory(path, new LinkOption[0]) || !Files.exists(path, new LinkOption[0]) || !Files.isWritable(path)) {
                LOG.warn("Unable to configure {}: not a valid output directory", path.toAbsolutePath().toString());
            } else {
                this.outputDir = path;
            }
        }
        String cfgPrefix = config.getParameter(Tmux.OPT_PREFIX, "frame");
        if (StringUtil.isNotBlank(cfgPrefix)) {
            this.prefix = cfgPrefix;
        }
        if (this.outputDir != null) {
            try {
                Path dir = this.outputDir.toRealPath(new LinkOption[0]);
                String tstamp = String.format("%1$tY%1$tm%1$td-%1$tH%1$tM%1$tS", Calendar.getInstance());
                this.incomingFramesPath = dir.resolve(String.format("%s-%s-incoming.dat", this.prefix, tstamp));
                this.outgoingFramesPath = dir.resolve(String.format("%s-%s-outgoing.dat", this.prefix, tstamp));
                this.incomingChannel = Files.newByteChannel(this.incomingFramesPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
                this.outgoingChannel = Files.newByteChannel(this.outgoingFramesPath, StandardOpenOption.CREATE, StandardOpenOption.WRITE);
                this.generator = new Generator(WebSocketPolicy.newServerPolicy(), getBufferPool(), false, true);
            } catch (IOException e) {
                LOG.warn("Unable to create capture file(s)", e);
            }
        }
    }
}
