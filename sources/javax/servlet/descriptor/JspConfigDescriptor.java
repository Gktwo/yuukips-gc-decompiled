package javax.servlet.descriptor;

import java.util.Collection;

/* loaded from: grasscutter.jar:javax/servlet/descriptor/JspConfigDescriptor.class */
public interface JspConfigDescriptor {
    Collection<TaglibDescriptor> getTaglibs();

    Collection<JspPropertyGroupDescriptor> getJspPropertyGroups();
}
