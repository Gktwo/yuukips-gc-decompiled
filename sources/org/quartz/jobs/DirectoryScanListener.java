package org.quartz.jobs;

import java.io.File;

/* loaded from: grasscutter.jar:org/quartz/jobs/DirectoryScanListener.class */
public interface DirectoryScanListener {
    void filesUpdatedOrAdded(File[] fileArr);
}
