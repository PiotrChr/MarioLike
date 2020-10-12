package GameItems;

public abstract class GameResource {
    public final static String resourcePath = "src/main/resources";

    public String getFullPath(String path) {
        return resourcePath.concat(path);
    }
}
