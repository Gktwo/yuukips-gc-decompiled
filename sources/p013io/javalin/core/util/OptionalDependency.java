package p013io.javalin.core.util;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* compiled from: OptionalDependency.kt */
@Metadata(m371mv = {1, 5, 1}, m372k = 1, m369xi = 48, m374d1 = {"��\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n��\n\u0002\u0010\u000e\n\u0002\b\"\b\u0001\u0018��2\b\u0012\u0004\u0012\u00020��0\u0001B/\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000b\u0010\nR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\f\u0010\nR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\r\u0010\nR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n��\u001a\u0004\b\u000e\u0010\nj\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$¨\u0006%"}, m373d2 = {"Lio/javalin/core/util/OptionalDependency;", "", "displayName", "", "testClass", "groupId", "artifactId", "version", "(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getArtifactId", "()Ljava/lang/String;", "getDisplayName", "getGroupId", "getTestClass", "getVersion", "JACKSON", "JACKSON_KT", "JACKSON_JSR_310", "JACKSON_KTORM", "SLF4JSIMPLE", "SLF4J_PROVIDER_SIMPLE", "SLF4J_PROVIDER_API", "SWAGGERUI", "SWAGGERPARSER", "REDOC", "SWAGGER_CORE", "CLASS_GRAPH", "MICROMETER", "JVMBROTLI", "JTE", "JTE_KOTLIN", "VELOCITY", "FREEMARKER", "THYMELEAF", "MUSTACHE", "PEBBLE", "COMMONMARK", "javalin"})
/* renamed from: io.javalin.core.util.OptionalDependency */
/* loaded from: grasscutter.jar:io/javalin/core/util/OptionalDependency.class */
public enum OptionalDependency {
    JACKSON("Jackson", "com.fasterxml.jackson.databind.ObjectMapper", "com.fasterxml.jackson.core", "jackson-databind", "2.13.3"),
    JACKSON_KT("JacksonKt", "com.fasterxml.jackson.module.kotlin.KotlinModule", "com.fasterxml.jackson.module", "jackson-module-kotlin", "2.13.3"),
    JACKSON_JSR_310("JacksonJsr310", "com.fasterxml.jackson.datatype.jsr310.JavaTimeModule", "com.fasterxml.jackson.datatype", "jackson-datatype-jsr310", "2.13.3"),
    JACKSON_KTORM("Jackson Ktorm", "org.ktorm.jackson.KtormModule", "org.ktorm", "ktorm-jackson", "3.4.1"),
    SLF4JSIMPLE("Slf4j simple", "org.slf4j.impl.StaticLoggerBinder", "org.slf4j", "slf4j-simple", "1.7.31"),
    SLF4J_PROVIDER_SIMPLE("Slf4j simple with Provider", "org.slf4j.simple.SimpleServiceProvider", "org.slf4j", "slf4j-simple", "1.8.0-beta4"),
    SLF4J_PROVIDER_API("Slf4j simple with Provider", "org.slf4j.spi.SLF4JServiceProvider", "org.slf4j", "slf4j-api", "1.8.0-beta4"),
    SWAGGERUI("Swagger UI", "STATIC-FILES", "org.webjars", "swagger-ui", "4.10.3"),
    SWAGGERPARSER("Swagger Parser", "io.swagger.v3.parser.OpenAPIV3Parser", "io.swagger.parser.v3", "swagger-parser", "2.0.27"),
    REDOC("ReDoc", "STATIC-FILES", "org.webjars.npm", "redoc", "2.0.0-rc.45"),
    SWAGGER_CORE("Swagger Core", "io.swagger.v3.oas.models.OpenAPI", "io.swagger.core.v3", "swagger-models", "2.1.10"),
    CLASS_GRAPH("ClassGraph", "io.github.classgraph.ClassGraph", "io.github.classgraph", "classgraph", "4.8.102"),
    MICROMETER("Micrometer", "io.micrometer.core.instrument.Metrics", "io.micrometer", "micrometer-core", "1.7.3"),
    JVMBROTLI("Jvm-Brotli", "com.nixxcode.jvmbrotli.common.BrotliLoader", "com.nixxcode.jvmbrotli", "jvmbrotli", "0.2.0"),
    JTE("jte", "gg.jte.TemplateEngine", "gg.jte", "jte", "1.12.0"),
    JTE_KOTLIN("jte-kotlin", "gg.jte.compiler.kotlin.KotlinClassCompiler", "gg.jte", "jte-kotlin", "1.12.0"),
    VELOCITY("Velocity", "org.apache.velocity.app.VelocityEngine", "org.apache.velocity", "velocity-engine-core", "2.3"),
    FREEMARKER("Freemarker", "freemarker.template.Configuration", "org.freemarker", "freemarker", "2.3.30"),
    THYMELEAF("Thymeleaf", "org.thymeleaf.TemplateEngine", "org.thymeleaf", "thymeleaf", "3.0.12.RELEASE"),
    MUSTACHE("Mustache", "com.github.mustachejava.MustacheFactory", "com.github.spullara.mustache.java", "compiler", "0.9.7"),
    PEBBLE("Pebble", "com.mitchellbosecke.pebble.PebbleEngine", "io.pebbletemplates", "pebble", "3.1.5"),
    COMMONMARK("Commonmark", "org.commonmark.renderer.html.HtmlRenderer", "org.commonmark", "commonmark", "0.17.1");
    
    @NotNull
    private final String displayName;
    @NotNull
    private final String testClass;
    @NotNull
    private final String groupId;
    @NotNull
    private final String artifactId;
    @NotNull
    private final String version;

    OptionalDependency(String displayName, String testClass, String groupId, String artifactId, String version) {
        this.displayName = displayName;
        this.testClass = testClass;
        this.groupId = groupId;
        this.artifactId = artifactId;
        this.version = version;
    }

    @NotNull
    public final String getDisplayName() {
        return this.displayName;
    }

    @NotNull
    public final String getTestClass() {
        return this.testClass;
    }

    @NotNull
    public final String getGroupId() {
        return this.groupId;
    }

    @NotNull
    public final String getArtifactId() {
        return this.artifactId;
    }

    @NotNull
    public final String getVersion() {
        return this.version;
    }
}
