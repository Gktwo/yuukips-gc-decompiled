package okhttp3;

import emu.grasscutter.net.packet.PacketOpcodes;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.JvmField;
import kotlin.jvm.JvmName;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;
import org.jline.console.Printer;
import p013io.netty.handler.ssl.Ciphers;

/* compiled from: CipherSuite.kt */
@Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010��\n��\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018�� \b2\u00020\u0001:\u0001\bB\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\r\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\b\u0006J\b\u0010\u0007\u001a\u00020\u0003H\u0016R\u0013\u0010\u0002\u001a\u00020\u00038\u0007¢\u0006\b\n��\u001a\u0004\b\u0002\u0010\u0005¨\u0006\t"}, m373d2 = {"Lokhttp3/CipherSuite;", "", "javaName", "", "(Ljava/lang/String;)V", "()Ljava/lang/String;", "-deprecated_javaName", Printer.TO_STRING, "Companion", "okhttp"})
/* loaded from: grasscutter.jar:okhttp3/CipherSuite.class */
public final class CipherSuite {
    @NotNull
    private final String javaName;
    @NotNull
    public static final Companion Companion = new Companion(null);
    @NotNull
    private static final Comparator<String> ORDER_BY_NAME = new Comparator<String>() { // from class: okhttp3.CipherSuite$Companion$ORDER_BY_NAME$1
        public int compare(@NotNull String a, @NotNull String b) {
            Intrinsics.checkNotNullParameter(a, "a");
            Intrinsics.checkNotNullParameter(b, "b");
            int limit = Math.min(a.length(), b.length());
            for (int i = 4; i < limit; i++) {
                char charA = a.charAt(i);
                char charB = b.charAt(i);
                if (charA != charB) {
                    return Intrinsics.compare((int) charA, (int) charB) < 0 ? -1 : 1;
                }
            }
            int lengthA = a.length();
            int lengthB = b.length();
            if (lengthA != lengthB) {
                return lengthA < lengthB ? -1 : 1;
            }
            return 0;
        }
    };
    @NotNull
    private static final Map<String, CipherSuite> INSTANCES = new LinkedHashMap();
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_MD5 = Companion.init("SSL_RSA_WITH_NULL_MD5", 1);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA = Companion.init("SSL_RSA_WITH_NULL_SHA", 2);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_RSA_EXPORT_WITH_RC4_40_MD5", 3);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_RC4_128_MD5 = Companion.init("SSL_RSA_WITH_RC4_128_MD5", 4);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_RC4_128_SHA = Companion.init("SSL_RSA_WITH_RC4_128_SHA", 5);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_RSA_EXPORT_WITH_DES40_CBC_SHA", 8);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_RSA_WITH_DES_CBC_SHA", 9);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", 17);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_DES_CBC_SHA", 18);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_DSS_WITH_3DES_EDE_CBC_SHA", 19);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", 20);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_DES_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_DES_CBC_SHA", 21);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DHE_RSA_WITH_3DES_EDE_CBC_SHA", 22);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_RC4_40_MD5 = Companion.init("SSL_DH_anon_EXPORT_WITH_RC4_40_MD5", 23);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_RC4_128_MD5 = Companion.init("SSL_DH_anon_WITH_RC4_128_MD5", 24);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA = Companion.init("SSL_DH_anon_EXPORT_WITH_DES40_CBC_SHA", 25);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_DES_CBC_SHA = Companion.init("SSL_DH_anon_WITH_DES_CBC_SHA", 26);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("SSL_DH_anon_WITH_3DES_EDE_CBC_SHA", 27);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_SHA = Companion.init("TLS_KRB5_WITH_DES_CBC_SHA", 30);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_SHA", 31);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_SHA = Companion.init("TLS_KRB5_WITH_RC4_128_SHA", 32);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_DES_CBC_MD5 = Companion.init("TLS_KRB5_WITH_DES_CBC_MD5", 34);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_3DES_EDE_CBC_MD5 = Companion.init("TLS_KRB5_WITH_3DES_EDE_CBC_MD5", 35);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_WITH_RC4_128_MD5 = Companion.init("TLS_KRB5_WITH_RC4_128_MD5", 36);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", 38);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_SHA = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_SHA", 40);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", 41);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_KRB5_EXPORT_WITH_RC4_40_MD5 = Companion.init("TLS_KRB5_EXPORT_WITH_RC4_40_MD5", 43);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA, 47);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, 50);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, 51);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA, 52);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA, 53);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA, 56);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, 57);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA, 58);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_NULL_SHA256 = Companion.init("TLS_RSA_WITH_NULL_SHA256", 59);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA256, 60);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA256 = Companion.init(Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA256, 61);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256, 64);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", 65);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", 68);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", 69);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256, 103);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_CBC_SHA256 = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256, 106);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_CBC_SHA256 = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256, 107);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA256, 108);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_CBC_SHA256 = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA256, 109);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", 132);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", 135);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA = Companion.init("TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", 136);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_RC4_128_SHA = Companion.init("TLS_PSK_WITH_RC4_128_SHA", 138);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_PSK_WITH_3DES_EDE_CBC_SHA", 139);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_PSK_WITH_AES_128_CBC_SHA, 140);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_PSK_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_PSK_WITH_AES_256_CBC_SHA, 141);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_SEED_CBC_SHA = Companion.init("TLS_RSA_WITH_SEED_CBC_SHA", 150);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256, 156);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_RSA_WITH_AES_256_GCM_SHA384, 157);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, 158);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, 159);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, 162);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_DSS_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, 163);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_128_GCM_SHA256, 166);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DH_anon_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_DH_anon_WITH_AES_256_GCM_SHA384, 167);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_EMPTY_RENEGOTIATION_INFO_SCSV = Companion.init("TLS_EMPTY_RENEGOTIATION_INFO_SCSV", 255);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_FALLBACK_SCSV = Companion.init("TLS_FALLBACK_SCSV", 22016);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_NULL_SHA", 49153);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_RC4_128_SHA", 49154);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", 49155);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", 49156);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", 49157);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_NULL_SHA", 49158);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", 49159);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", 49160);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, 49161);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, 49162);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDH_RSA_WITH_NULL_SHA", 49163);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_RSA_WITH_RC4_128_SHA", 49164);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", 49165);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", 49166);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", 49167);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_NULL_SHA = Companion.init("TLS_ECDHE_RSA_WITH_NULL_SHA", 49168);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_RC4_128_SHA = Companion.init("TLS_ECDHE_RSA_WITH_RC4_128_SHA", 49169);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", 49170);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, 49171);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, 49172);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_NULL_SHA = Companion.init("TLS_ECDH_anon_WITH_NULL_SHA", 49173);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_RC4_128_SHA = Companion.init("TLS_ECDH_anon_WITH_RC4_128_SHA", 49174);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA = Companion.init("TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", 49175);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_ECDH_anon_WITH_AES_128_CBC_SHA, 49176);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_anon_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_ECDH_anon_WITH_AES_256_CBC_SHA, 49177);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, 49187);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384, 49188);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", 49189);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", 49190);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256 = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, 49191);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384 = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, 49192);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", 49193);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", 49194);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, 49195);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, 49196);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", 49197);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", 49198);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, 49199);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, 49200);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256 = Companion.init("TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", 49201);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384 = Companion.init("TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", 49202);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA, 49205);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA = Companion.init(Ciphers.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA, 49206);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init(Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, 52392);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init(Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, 52393);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = Companion.init(Ciphers.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256, 52394);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256 = Companion.init(Ciphers.TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256, 52396);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_GCM_SHA256 = Companion.init(Ciphers.TLS_AES_128_GCM_SHA256, PacketOpcodes.HomeLimitedShopBuyGoodsRsp);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_256_GCM_SHA384 = Companion.init(Ciphers.TLS_AES_256_GCM_SHA384, 4866);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_CHACHA20_POLY1305_SHA256 = Companion.init(Ciphers.TLS_CHACHA20_POLY1305_SHA256, 4867);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_CCM_SHA256 = Companion.init("TLS_AES_128_CCM_SHA256", 4868);
    @JvmField
    @NotNull
    public static final CipherSuite TLS_AES_128_CCM_8_SHA256 = Companion.init("TLS_AES_128_CCM_8_SHA256", PacketOpcodes.PlayerApplyEnterHomeResultRsp);

    @JvmStatic
    @NotNull
    public static final synchronized CipherSuite forJavaName(@NotNull String javaName) {
        return Companion.forJavaName(javaName);
    }

    public /* synthetic */ CipherSuite(String javaName, DefaultConstructorMarker $constructor_marker) {
        this(javaName);
    }

    private CipherSuite(String javaName) {
        this.javaName = javaName;
    }

    @JvmName(name = "javaName")
    @NotNull
    public final String javaName() {
        return this.javaName;
    }

    @Deprecated(message = "moved to val", replaceWith = @ReplaceWith(expression = "javaName", imports = {}), level = DeprecationLevel.ERROR)
    @JvmName(name = "-deprecated_javaName")
    @NotNull
    /* renamed from: -deprecated_javaName  reason: not valid java name */
    public final String m9167deprecated_javaName() {
        return this.javaName;
    }

    @NotNull
    public String toString() {
        return this.javaName;
    }

    /* compiled from: CipherSuite.kt */
    @Metadata(m371mv = {1, 6, 0}, m372k = 1, m369xi = 48, m374d1 = {"��.\n\u0002\u0018\u0002\n\u0002\u0010��\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n��\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b}\n\u0002\u0010\b\n\u0002\b\u0002\b\u0003\u0018��2\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u0005H\u0007J\u001c\u0010\u0001\u001a\u00020\u00062\u0007\u0010\u0001\u001a\u00020\u00052\b\u0010\u0001\u001a\u00030\u0001H\u0002J\u0012\u0010\u0001\u001a\u00020\u00052\u0007\u0010\u0001\u001a\u00020\u0005H\u0002R\u001a\u0010\u0003\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00060\u0004X\u0004¢\u0006\u0002\n��R$\u0010\u0007\u001a\u0012\u0012\u0004\u0012\u00020\u00050\bj\b\u0012\u0004\u0012\u00020\u0005`\tX\u0004¢\u0006\b\n��\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\r\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u000e\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u000f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0010\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0011\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0012\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0013\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0014\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0015\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0016\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0017\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0018\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u0019\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001a\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001c\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001d\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001e\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010 \u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010!\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\"\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010#\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010$\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010%\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010&\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010'\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010(\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010)\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010*\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010+\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010,\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010-\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010.\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010/\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00100\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00101\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00102\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00103\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00104\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00105\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00106\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00107\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00108\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u00109\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010:\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010;\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010<\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010=\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010>\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010?\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010@\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010A\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010B\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010C\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010D\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010E\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010F\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010G\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010H\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010I\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010J\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010K\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010L\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010M\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010N\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010O\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010P\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010Q\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010R\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010S\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010T\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010U\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010V\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010W\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010X\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010Y\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010Z\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010[\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\\\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010]\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010^\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010_\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010`\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010a\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010b\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010c\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010d\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010e\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010f\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010g\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010h\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010i\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010j\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010k\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010l\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010m\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010n\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010o\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010p\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010q\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010r\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010s\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010t\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010u\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010v\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010w\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010x\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010y\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010z\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010{\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010|\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010}\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010~\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0010\u0010\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0001\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0001\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��R\u0011\u0010\u0001\u001a\u00020\u00068\u0006X\u0004¢\u0006\u0002\n��¨\u0006\u0001"}, m373d2 = {"Lokhttp3/CipherSuite$Companion;", "", "()V", "INSTANCES", "", "", "Lokhttp3/CipherSuite;", "ORDER_BY_NAME", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "getORDER_BY_NAME$okhttp", "()Ljava/util/Comparator;", "TLS_AES_128_CCM_8_SHA256", "TLS_AES_128_CCM_SHA256", Ciphers.TLS_AES_128_GCM_SHA256, Ciphers.TLS_AES_256_GCM_SHA384, Ciphers.TLS_CHACHA20_POLY1305_SHA256, "TLS_DHE_DSS_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_DSS_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA, Ciphers.TLS_DHE_DSS_WITH_AES_128_CBC_SHA256, Ciphers.TLS_DHE_DSS_WITH_AES_128_GCM_SHA256, Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA, Ciphers.TLS_DHE_DSS_WITH_AES_256_CBC_SHA256, Ciphers.TLS_DHE_DSS_WITH_AES_256_GCM_SHA384, "TLS_DHE_DSS_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_DSS_WITH_CAMELLIA_256_CBC_SHA", "TLS_DHE_DSS_WITH_DES_CBC_SHA", "TLS_DHE_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_DHE_RSA_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA, Ciphers.TLS_DHE_RSA_WITH_AES_128_CBC_SHA256, Ciphers.TLS_DHE_RSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA, Ciphers.TLS_DHE_RSA_WITH_AES_256_CBC_SHA256, Ciphers.TLS_DHE_RSA_WITH_AES_256_GCM_SHA384, "TLS_DHE_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_DHE_RSA_WITH_CAMELLIA_256_CBC_SHA", Ciphers.TLS_DHE_RSA_WITH_CHACHA20_POLY1305_SHA256, "TLS_DHE_RSA_WITH_DES_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_DES40_CBC_SHA", "TLS_DH_anon_EXPORT_WITH_RC4_40_MD5", "TLS_DH_anon_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA, Ciphers.TLS_DH_anon_WITH_AES_128_CBC_SHA256, Ciphers.TLS_DH_anon_WITH_AES_128_GCM_SHA256, Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA, Ciphers.TLS_DH_anon_WITH_AES_256_CBC_SHA256, Ciphers.TLS_DH_anon_WITH_AES_256_GCM_SHA384, "TLS_DH_anon_WITH_DES_CBC_SHA", "TLS_DH_anon_WITH_RC4_128_MD5", "TLS_ECDHE_ECDSA_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA256, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA384, Ciphers.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, "TLS_ECDHE_ECDSA_WITH_NULL_SHA", "TLS_ECDHE_ECDSA_WITH_RC4_128_SHA", Ciphers.TLS_ECDHE_PSK_WITH_AES_128_CBC_SHA, Ciphers.TLS_ECDHE_PSK_WITH_AES_256_CBC_SHA, Ciphers.TLS_ECDHE_PSK_WITH_CHACHA20_POLY1305_SHA256, "TLS_ECDHE_RSA_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, Ciphers.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, Ciphers.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA384, Ciphers.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, Ciphers.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, "TLS_ECDHE_RSA_WITH_NULL_SHA", "TLS_ECDHE_RSA_WITH_RC4_128_SHA", "TLS_ECDH_ECDSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_ECDSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_ECDSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_ECDSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_ECDSA_WITH_NULL_SHA", "TLS_ECDH_ECDSA_WITH_RC4_128_SHA", "TLS_ECDH_RSA_WITH_3DES_EDE_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_128_CBC_SHA256", "TLS_ECDH_RSA_WITH_AES_128_GCM_SHA256", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA", "TLS_ECDH_RSA_WITH_AES_256_CBC_SHA384", "TLS_ECDH_RSA_WITH_AES_256_GCM_SHA384", "TLS_ECDH_RSA_WITH_NULL_SHA", "TLS_ECDH_RSA_WITH_RC4_128_SHA", "TLS_ECDH_anon_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_ECDH_anon_WITH_AES_128_CBC_SHA, Ciphers.TLS_ECDH_anon_WITH_AES_256_CBC_SHA, "TLS_ECDH_anon_WITH_NULL_SHA", "TLS_ECDH_anon_WITH_RC4_128_SHA", "TLS_EMPTY_RENEGOTIATION_INFO_SCSV", "TLS_FALLBACK_SCSV", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_MD5", "TLS_KRB5_EXPORT_WITH_DES_CBC_40_SHA", "TLS_KRB5_EXPORT_WITH_RC4_40_MD5", "TLS_KRB5_EXPORT_WITH_RC4_40_SHA", "TLS_KRB5_WITH_3DES_EDE_CBC_MD5", "TLS_KRB5_WITH_3DES_EDE_CBC_SHA", "TLS_KRB5_WITH_DES_CBC_MD5", "TLS_KRB5_WITH_DES_CBC_SHA", "TLS_KRB5_WITH_RC4_128_MD5", "TLS_KRB5_WITH_RC4_128_SHA", "TLS_PSK_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_PSK_WITH_AES_128_CBC_SHA, Ciphers.TLS_PSK_WITH_AES_256_CBC_SHA, "TLS_PSK_WITH_RC4_128_SHA", "TLS_RSA_EXPORT_WITH_DES40_CBC_SHA", "TLS_RSA_EXPORT_WITH_RC4_40_MD5", "TLS_RSA_WITH_3DES_EDE_CBC_SHA", Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA, Ciphers.TLS_RSA_WITH_AES_128_CBC_SHA256, Ciphers.TLS_RSA_WITH_AES_128_GCM_SHA256, Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA, Ciphers.TLS_RSA_WITH_AES_256_CBC_SHA256, Ciphers.TLS_RSA_WITH_AES_256_GCM_SHA384, "TLS_RSA_WITH_CAMELLIA_128_CBC_SHA", "TLS_RSA_WITH_CAMELLIA_256_CBC_SHA", "TLS_RSA_WITH_DES_CBC_SHA", "TLS_RSA_WITH_NULL_MD5", "TLS_RSA_WITH_NULL_SHA", "TLS_RSA_WITH_NULL_SHA256", "TLS_RSA_WITH_RC4_128_MD5", "TLS_RSA_WITH_RC4_128_SHA", "TLS_RSA_WITH_SEED_CBC_SHA", "forJavaName", "javaName", "init", "value", "", "secondaryName", "okhttp"})
    /* loaded from: grasscutter.jar:okhttp3/CipherSuite$Companion.class */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker $constructor_marker) {
            this();
        }

        private Companion() {
        }

        @NotNull
        public final Comparator<String> getORDER_BY_NAME$okhttp() {
            return CipherSuite.ORDER_BY_NAME;
        }

        @JvmStatic
        @NotNull
        public final synchronized CipherSuite forJavaName(@NotNull String javaName) {
            Intrinsics.checkNotNullParameter(javaName, "javaName");
            CipherSuite result = (CipherSuite) CipherSuite.INSTANCES.get(javaName);
            if (result == null) {
                result = (CipherSuite) CipherSuite.INSTANCES.get(secondaryName(javaName));
                if (result == null) {
                    result = new CipherSuite(javaName, null);
                }
                CipherSuite.INSTANCES.put(javaName, result);
            }
            return result;
        }

        private final String secondaryName(String javaName) {
            if (StringsKt.startsWith$default(javaName, "TLS_", false, 2, (Object) null)) {
                String substring = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(substring, "this as java.lang.String).substring(startIndex)");
                return Intrinsics.stringPlus("SSL_", substring);
            } else if (!StringsKt.startsWith$default(javaName, "SSL_", false, 2, (Object) null)) {
                return javaName;
            } else {
                String substring2 = javaName.substring(4);
                Intrinsics.checkNotNullExpressionValue(substring2, "this as java.lang.String).substring(startIndex)");
                return Intrinsics.stringPlus("TLS_", substring2);
            }
        }

        /* access modifiers changed from: private */
        public final CipherSuite init(String javaName, int value) {
            CipherSuite suite = new CipherSuite(javaName, null);
            CipherSuite.INSTANCES.put(javaName, suite);
            return suite;
        }
    }
}
