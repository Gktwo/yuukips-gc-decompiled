package okio;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.Mac;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import okio.internal.ResourceFileSystem;
import okio.internal.zip;
import org.codehaus.mojo.animal_sniffer.IgnoreJRERequirement;
import org.jetbrains.annotations.NotNull;

@Metadata(m371mv = {1, 5, 1}, m372k = 5, m369xi = 48, m374d1 = {"��\u0001\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n��\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\n\u0010\b\u001a\u00020\t*\u00020\n\u001a\n\u0010\u000b\u001a\u00020\f*\u00020\r\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\t2\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0012\u001a\u00020\u0013*\u00020\u00142\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u0015\u001a\u00020\u0016*\u00020\t2\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018\u001a\u0012\u0010\u001b\u001a\u00020\u001c*\u00020\u00142\u0006\u0010\u0019\u001a\u00020\u001a\u001a\u0012\u0010\u001d\u001a\u00020\f*\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f\u001a\u0016\u0010 \u001a\u00020\t*\u00020\n2\b\b\u0002\u0010!\u001a\u00020\u0004H\u0007\u001a\n\u0010 \u001a\u00020\t*\u00020\"\u001a\n\u0010 \u001a\u00020\t*\u00020#\u001a%\u0010 \u001a\u00020\t*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007¢\u0006\u0002\u0010(\u001a\n\u0010)\u001a\u00020\u0014*\u00020\n\u001a\n\u0010)\u001a\u00020\u0014*\u00020*\u001a\n\u0010)\u001a\u00020\u0014*\u00020#\u001a%\u0010)\u001a\u00020\u0014*\u00020$2\u0012\u0010%\u001a\n\u0012\u0006\b\u0001\u0012\u00020'0&\"\u00020'H\u0007¢\u0006\u0002\u0010+\"\u0016\u0010��\u001a\n \u0002*\u0004\u0018\u00010\u00010\u0001X\u0004¢\u0006\u0002\n��\"\u001c\u0010\u0003\u001a\u00020\u0004*\u00060\u0005j\u0002`\u00068@X\u0004¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0007¨\u0006,"}, m373d2 = {"logger", "Ljava/util/logging/Logger;", "kotlin.jvm.PlatformType", "isAndroidGetsocknameError", "", "Ljava/lang/AssertionError;", "Lkotlin/AssertionError;", "(Ljava/lang/AssertionError;)Z", "appendingSink", "Lokio/Sink;", "Ljava/io/File;", "asResourceFileSystem", "Lokio/FileSystem;", "Ljava/lang/ClassLoader;", "cipherSink", "Lokio/CipherSink;", "cipher", "Ljavax/crypto/Cipher;", "cipherSource", "Lokio/CipherSource;", "Lokio/Source;", "hashingSink", "Lokio/HashingSink;", "digest", "Ljava/security/MessageDigest;", "mac", "Ljavax/crypto/Mac;", "hashingSource", "Lokio/HashingSource;", "openZip", "zipPath", "Lokio/Path;", "sink", "append", "Ljava/io/OutputStream;", "Ljava/net/Socket;", "Ljava/nio/file/Path;", "options", "", "Ljava/nio/file/OpenOption;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Sink;", "source", "Ljava/io/InputStream;", "(Ljava/nio/file/Path;[Ljava/nio/file/OpenOption;)Lokio/Source;", "okio"}, m368xs = "okio/Okio")
/* renamed from: okio.Okio__JvmOkioKt */
/* loaded from: grasscutter.jar:okio/Okio__JvmOkioKt.class */
public final /* synthetic */ class JvmOkio {
    private static final Logger logger = Logger.getLogger("okio.Okio");

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File $this$sink) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return sink$default($this$sink, false, 1, null);
    }

    @NotNull
    public static final Sink sink(@NotNull OutputStream $this$sink) {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return new OutputStreamSink($this$sink, new Timeout());
    }

    @NotNull
    public static final Source source(@NotNull InputStream $this$source) {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        return new InputStreamSource($this$source, new Timeout());
    }

    @NotNull
    public static final Sink sink(@NotNull Socket $this$sink) throws IOException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        SocketAsyncTimeout timeout = new SocketAsyncTimeout($this$sink);
        OutputStream outputStream = $this$sink.getOutputStream();
        Intrinsics.checkNotNullExpressionValue(outputStream, "getOutputStream()");
        return timeout.sink(new OutputStreamSink(outputStream, timeout));
    }

    @NotNull
    public static final Source source(@NotNull Socket $this$source) throws IOException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        SocketAsyncTimeout timeout = new SocketAsyncTimeout($this$source);
        InputStream inputStream = $this$source.getInputStream();
        Intrinsics.checkNotNullExpressionValue(inputStream, "getInputStream()");
        return timeout.source(new InputStreamSource(inputStream, timeout));
    }

    @JvmOverloads
    @NotNull
    public static final Sink sink(@NotNull File $this$sink, boolean append) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        return Okio.sink(new FileOutputStream($this$sink, append));
    }

    public static /* synthetic */ Sink sink$default(File file, boolean z, int i, Object obj) throws FileNotFoundException {
        if ((i & 1) != 0) {
            z = false;
        }
        return Okio.sink(file, z);
    }

    @NotNull
    public static final Sink appendingSink(@NotNull File $this$appendingSink) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$appendingSink, "<this>");
        return Okio.sink(new FileOutputStream($this$appendingSink, true));
    }

    @NotNull
    public static final Source source(@NotNull File $this$source) throws FileNotFoundException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        return new InputStreamSource(new FileInputStream($this$source), Timeout.NONE);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Sink sink(@NotNull Path $this$sink, @NotNull OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$sink, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        OutputStream newOutputStream = Files.newOutputStream($this$sink, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newOutputStream, "newOutputStream(this, *options)");
        return Okio.sink(newOutputStream);
    }

    @IgnoreJRERequirement
    @NotNull
    public static final Source source(@NotNull Path $this$source, @NotNull OpenOption... options) throws IOException {
        Intrinsics.checkNotNullParameter($this$source, "<this>");
        Intrinsics.checkNotNullParameter(options, "options");
        InputStream newInputStream = Files.newInputStream($this$source, (OpenOption[]) Arrays.copyOf(options, options.length));
        Intrinsics.checkNotNullExpressionValue(newInputStream, "newInputStream(this, *options)");
        return Okio.source(newInputStream);
    }

    @NotNull
    public static final CipherSink cipherSink(@NotNull Sink $this$cipherSink, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter($this$cipherSink, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSink(Okio.buffer($this$cipherSink), cipher);
    }

    @NotNull
    public static final CipherSource cipherSource(@NotNull Source $this$cipherSource, @NotNull Cipher cipher) {
        Intrinsics.checkNotNullParameter($this$cipherSource, "<this>");
        Intrinsics.checkNotNullParameter(cipher, "cipher");
        return new CipherSource(Okio.buffer($this$cipherSource), cipher);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink $this$hashingSink, @NotNull Mac mac) {
        Intrinsics.checkNotNullParameter($this$hashingSink, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSink($this$hashingSink, mac);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source $this$hashingSource, @NotNull Mac mac) {
        Intrinsics.checkNotNullParameter($this$hashingSource, "<this>");
        Intrinsics.checkNotNullParameter(mac, "mac");
        return new HashingSource($this$hashingSource, mac);
    }

    @NotNull
    public static final HashingSink hashingSink(@NotNull Sink $this$hashingSink, @NotNull MessageDigest digest) {
        Intrinsics.checkNotNullParameter($this$hashingSink, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSink($this$hashingSink, digest);
    }

    @NotNull
    public static final HashingSource hashingSource(@NotNull Source $this$hashingSource, @NotNull MessageDigest digest) {
        Intrinsics.checkNotNullParameter($this$hashingSource, "<this>");
        Intrinsics.checkNotNullParameter(digest, "digest");
        return new HashingSource($this$hashingSource, digest);
    }

    @NotNull
    public static final FileSystem openZip(@NotNull FileSystem $this$openZip, @NotNull Path zipPath) throws IOException {
        Intrinsics.checkNotNullParameter($this$openZip, "<this>");
        Intrinsics.checkNotNullParameter(zipPath, "zipPath");
        return zip.openZip$default(zipPath, $this$openZip, null, 4, null);
    }

    @NotNull
    public static final FileSystem asResourceFileSystem(@NotNull ClassLoader $this$asResourceFileSystem) {
        Intrinsics.checkNotNullParameter($this$asResourceFileSystem, "<this>");
        return new ResourceFileSystem($this$asResourceFileSystem, true);
    }

    public static final boolean isAndroidGetsocknameError(@NotNull AssertionError $this$isAndroidGetsocknameError) {
        Intrinsics.checkNotNullParameter($this$isAndroidGetsocknameError, "<this>");
        if ($this$isAndroidGetsocknameError.getCause() != null) {
            String message = $this$isAndroidGetsocknameError.getMessage();
            if (message == null ? false : StringsKt.contains$default((CharSequence) message, (CharSequence) "getsockname failed", false, 2, (Object) null)) {
                return true;
            }
        }
        return false;
    }
}
