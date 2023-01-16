package com.github.davidmoten.rtreemulti;

import java.awt.image.BufferedImage;
import java.io.File;
import java.util.concurrent.Callable;
import javax.imageio.ImageIO;

/* loaded from: grasscutter.jar:com/github/davidmoten/rtreemulti/ImageSaver.class */
final class ImageSaver {
    private ImageSaver() {
    }

    /* access modifiers changed from: package-private */
    public static void save(final BufferedImage image, final File file, final String imageFormat) {
        run(new Callable<Void>() { // from class: com.github.davidmoten.rtreemulti.ImageSaver.1
            @Override // java.util.concurrent.Callable
            public Void call() throws Exception {
                ImageIO.write(image, imageFormat, file);
                return null;
            }
        });
    }

    static void run(Callable<Void> callable) {
        try {
            callable.call();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
