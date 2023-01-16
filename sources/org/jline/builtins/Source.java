package org.jline.builtins;

import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.OpenOption;
import java.nio.file.Path;
import java.util.Objects;

/* loaded from: grasscutter.jar:org/jline/builtins/Source.class */
public interface Source {
    String getName();

    InputStream read() throws IOException;

    Long lines();

    /* loaded from: grasscutter.jar:org/jline/builtins/Source$URLSource.class */
    public static class URLSource implements Source {
        final URL url;
        final String name;

        public URLSource(URL url, String name) {
            this.url = (URL) Objects.requireNonNull(url);
            this.name = name;
        }

        @Override // org.jline.builtins.Source
        public String getName() {
            return this.name;
        }

        @Override // org.jline.builtins.Source
        public InputStream read() throws IOException {
            return this.url.openStream();
        }

        @Override // org.jline.builtins.Source
        public Long lines() {
            Long out = null;
            try {
                out = Long.valueOf(Files.lines(new File(this.url.toURI()).toPath()).count());
            } catch (Exception e) {
            }
            return out;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Source$PathSource.class */
    public static class PathSource implements Source {
        final Path path;
        final String name;

        public PathSource(File file, String name) {
            this(((File) Objects.requireNonNull(file)).toPath(), name);
        }

        public PathSource(Path path, String name) {
            this.path = (Path) Objects.requireNonNull(path);
            this.name = name;
        }

        @Override // org.jline.builtins.Source
        public String getName() {
            return this.name;
        }

        @Override // org.jline.builtins.Source
        public InputStream read() throws IOException {
            return Files.newInputStream(this.path, new OpenOption[0]);
        }

        @Override // org.jline.builtins.Source
        public Long lines() {
            Long out = null;
            try {
                out = Long.valueOf(Files.lines(this.path).count());
            } catch (Exception e) {
            }
            return out;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Source$InputStreamSource.class */
    public static class InputStreamSource implements Source {

        /* renamed from: in */
        final InputStream f3205in;
        final String name;

        public InputStreamSource(InputStream in, boolean close, String name) {
            Objects.requireNonNull(in);
            if (close) {
                this.f3205in = in;
            } else {
                this.f3205in = new FilterInputStream(in) { // from class: org.jline.builtins.Source.InputStreamSource.1
                    @Override // java.io.FilterInputStream, java.io.Closeable, java.lang.AutoCloseable, java.io.InputStream
                    public void close() throws IOException {
                    }
                };
            }
            this.name = name;
        }

        @Override // org.jline.builtins.Source
        public String getName() {
            return this.name;
        }

        @Override // org.jline.builtins.Source
        public InputStream read() throws IOException {
            return this.f3205in;
        }

        @Override // org.jline.builtins.Source
        public Long lines() {
            return null;
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Source$StdInSource.class */
    public static class StdInSource extends InputStreamSource {
        public StdInSource() {
            this(System.in);
        }

        public StdInSource(InputStream in) {
            super(in, false, null);
        }
    }

    /* loaded from: grasscutter.jar:org/jline/builtins/Source$ResourceSource.class */
    public static class ResourceSource implements Source {
        final String resource;
        final String name;

        public ResourceSource(String resource) {
            this(resource, resource);
        }

        public ResourceSource(String resource, String name) {
            this.resource = (String) Objects.requireNonNull(resource);
            this.name = name;
        }

        @Override // org.jline.builtins.Source
        public String getName() {
            return this.name;
        }

        @Override // org.jline.builtins.Source
        public InputStream read() throws IOException {
            return getClass().getResourceAsStream(this.resource);
        }

        @Override // org.jline.builtins.Source
        public Long lines() {
            return null;
        }
    }
}
