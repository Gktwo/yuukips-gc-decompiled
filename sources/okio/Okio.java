package okio;

import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.functions.Function1;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 5, 1}, m372k = 4, m369xi = 48, m374d1 = {"okio/Okio__JvmOkioKt", "okio/Okio__OkioKt"})
/* loaded from: grasscutter.jar:okio/Okio.class */
public final class Okio {
    @NotNull
    public static final Sink sink(@NotNull OutputStream $this$sink) {
        return JvmOkio.sink($this$sink);
    }

    @NotNull
    public static final Source source(@NotNull InputStream $this$source) {
        return JvmOkio.source($this$source);
    }

    @NotNull
    public static final Sink sink(@NotNull Socket $this$sink) throws IOException {
        return JvmOkio.sink($this$sink);
    }

    @NotNull
    public static final Source source(@NotNull Socket $this$source) throws IOException {
        return JvmOkio.source($this$source);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File $this$sink, boolean append) throws FileNotFoundException {
        return JvmOkio.sink($this$sink, append);
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File $this$appendingSink) throws FileNotFoundException {
        return JvmOkio.appendingSink($this$appendingSink);
    }

    @NotNull
    public static final Source source(@NotNull File $this$source) throws FileNotFoundException {
        return JvmOkio.source($this$source);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path $this$sink, @NotNull OpenOption... options) throws IOException {
        return JvmOkio.sink($this$sink, options);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path $this$source, @NotNull OpenOption... options) throws IOException {
        return JvmOkio.source($this$source, options);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink $this$cipherSink, @NotNull Cipher cipher) {
        return JvmOkio.cipherSink($this$cipherSink, cipher);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source $this$cipherSource, @NotNull Cipher cipher) {
        return JvmOkio.cipherSource($this$cipherSource, cipher);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink $this$hashingSink, @NotNull Mac mac) {
        return JvmOkio.hashingSink($this$hashingSink, mac);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source $this$hashingSource, @NotNull Mac mac) {
        return JvmOkio.hashingSource($this$hashingSource, mac);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink $this$hashingSink, @NotNull MessageDigest digest) {
        return JvmOkio.hashingSink($this$hashingSink, digest);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source $this$hashingSource, @NotNull MessageDigest digest) {
        return JvmOkio.hashingSource($this$hashingSource, digest);
    }

    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem $this$openZip, @NotNull Path zipPath) throws IOException {
        return JvmOkio.openZip($this$openZip, zipPath);
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader $this$asResourceFileSystem) {
        return JvmOkio.asResourceFileSystem($this$asResourceFileSystem);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError $this$isAndroidGetsocknameError) {
        return JvmOkio.isAndroidGetsocknameError($this$isAndroidGetsocknameError);
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File $this$sink) throws FileNotFoundException {
        return JvmOkio.sink($this$sink);
    }

    @NotNull
    public static final BufferedSource buffer(@NotNull Source $this$buffer) {
        return Okio__OkioKt.buffer($this$buffer);
    }

    @NotNull
    public static final BufferedSink buffer(@NotNull Sink $this$buffer) {
        return Okio__OkioKt.buffer($this$buffer);
    }

    @JvmName(name = "blackhole")
    @NotNull
    public static final Sink blackhole() {
        return Okio__OkioKt.blackhole();
    }

    public static final <T extends Closeable, R> R use(T t, @NotNull Function1<? super T, ? extends R> function1) {
        return (R) Okio__OkioKt.use(t, function1);
    }
}
