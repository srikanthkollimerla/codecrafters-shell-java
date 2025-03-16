import java.io.File;

public class TypeCommand implements Command {
    @Override
    public void execute(String input) {
        String commandName = input.substring(5).trim();
        if (CommandRegistry.hasCommand(commandName)) {
            System.out.println(commandName + " is a shell builtin");
            return;
        }
        String path = findExecutableInPath(commandName);
        if (path != null) {
            System.out.println(commandName + " is " + path);
        }
        else {
            System.out.println(commandName + ": not found");
        }
    }

    public String findExecutableInPath(String command) {
        String pathEnv = System.getenv("PATH");
        if (pathEnv == null || pathEnv.isEmpty()) return null;

        String[] paths = pathEnv.split(":");
        for (String dir : paths) {
            File file = new File(dir, command);
            if (file.exists() && file.canExecute()) {
                return file.getAbsolutePath();
            }
        }
        return null;
    }
}
