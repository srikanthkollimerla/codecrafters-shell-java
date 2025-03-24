public class ShellContext {
    private static String currentPath = System.getProperty("user.dir");

    public static String getCurrentPath() {
        return currentPath;
    }

    public static void setCurrentPath(String newPath) {
        currentPath = newPath;
    }
}
