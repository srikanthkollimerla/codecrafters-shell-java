import java.io.File;

public class CdCommand implements Command{
    @Override
    public void execute(String input) {
        String newPath = input.split(" ")[1];
        File newDir = new File(newPath);
        if (!newDir.isDirectory()) {
            System.out.println("cd: " + newPath + ": No such file or directory");
            return;
        }
        // Change the working directory
       ShellContext.setCurrentPath(newPath);
    }
}
