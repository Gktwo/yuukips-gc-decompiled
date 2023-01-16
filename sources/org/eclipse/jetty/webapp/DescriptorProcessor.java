package org.eclipse.jetty.webapp;

/* loaded from: grasscutter.jar:org/eclipse/jetty/webapp/DescriptorProcessor.class */
public interface DescriptorProcessor {
    void process(WebAppContext webAppContext, Descriptor descriptor) throws Exception;
}
