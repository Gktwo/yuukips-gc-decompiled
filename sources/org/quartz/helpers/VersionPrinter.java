package org.quartz.helpers;

import dev.morphia.mapping.Mapper;
import org.quartz.core.QuartzScheduler;

/* loaded from: grasscutter.jar:org/quartz/helpers/VersionPrinter.class */
public class VersionPrinter {
    private VersionPrinter() {
    }

    public static void main(String[] args) {
        System.out.println("Quartz version: " + QuartzScheduler.getVersionMajor() + Mapper.IGNORED_FIELDNAME + QuartzScheduler.getVersionMinor() + Mapper.IGNORED_FIELDNAME + QuartzScheduler.getVersionIteration());
    }
}
