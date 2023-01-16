package emu.grasscutter.plugin;

/* loaded from: grasscutter.jar:emu/grasscutter/plugin/PluginConfig.class */
public final class PluginConfig {
    public String name;
    public String description;
    public String version;
    public String mainClass;
    public String[] authors;
    public String[] loadAfter;

    public boolean validate() {
        return (this.name == null || this.description == null || this.mainClass == null) ? false : true;
    }
}
