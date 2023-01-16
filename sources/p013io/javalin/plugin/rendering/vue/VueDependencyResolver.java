package p013io.javalin.plugin.rendering.vue;

import java.nio.file.Path;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* renamed from: io.javalin.plugin.rendering.vue.VueDependencyResolver */
/* loaded from: grasscutter.jar:io/javalin/plugin/rendering/vue/VueDependencyResolver.class */
public class VueDependencyResolver {
    private final Pattern componentRegex;
    private final String appName;
    private final Pattern tagRegex = Pattern.compile("<\\s*([a-z0-9|-]*).*?>", 32);
    private final Map<String, String> componentIdToOwnContent = new HashMap();
    private final Map<String, String> componentIdToDependencyContent = new HashMap();

    public VueDependencyResolver(Set<Path> paths, String appVarName) {
        this.appName = appVarName;
        this.componentRegex = Pattern.compile(appVarName + ".component\\s*\\(\\s*[\"|'](.*)[\"|']\\s*,.*");
        paths.stream().filter(VueHandlerKt::isVueFile).forEach(path -> {
            String fileContent = VueHandlerKt.readText(path);
            Matcher matcher = this.componentRegex.matcher(fileContent);
            while (matcher.find()) {
                this.componentIdToOwnContent.put(matcher.group(1), fileContent);
            }
        });
    }

    public String resolve(String componentId) {
        if (!this.componentIdToOwnContent.containsKey(componentId)) {
            throw new IllegalArgumentException(String.format("Component %s not found in app %s", componentId, this.appName));
        } else if (this.componentIdToDependencyContent.containsKey(componentId)) {
            return this.componentIdToDependencyContent.get(componentId);
        } else {
            Set<String> dependencies = resolveTransitiveDependencies(componentId);
            StringBuilder builder = new StringBuilder();
            dependencies.forEach(dependency -> {
                builder.append("<!-- ").append(builder).append(" -->\n");
                builder.append(this.componentIdToOwnContent.get(builder));
                builder.append("\n");
            });
            String allDependencies = builder.toString();
            this.componentIdToDependencyContent.put(componentId, allDependencies);
            return allDependencies;
        }
    }

    private Set<String> resolveTransitiveDependencies(String componentId) {
        Set<String> requiredComponents = new HashSet<>();
        requiredComponents.add(componentId);
        Set<String> directDependencies = resolveDirectDependencies(componentId);
        requiredComponents.addAll(directDependencies);
        directDependencies.forEach(dependency -> {
            requiredComponents.addAll(resolveTransitiveDependencies(requiredComponents));
        });
        return requiredComponents;
    }

    private Set<String> resolveDirectDependencies(String componentId) {
        Set<String> dependencies = new HashSet<>();
        Matcher matcher = this.tagRegex.matcher(this.componentIdToOwnContent.get(componentId));
        while (matcher.find()) {
            String match = matcher.group(1);
            if (!match.equals(componentId) && this.componentIdToOwnContent.containsKey(match)) {
                dependencies.add(match);
            }
        }
        return dependencies;
    }
}
