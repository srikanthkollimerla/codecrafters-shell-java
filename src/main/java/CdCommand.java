import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class CdCommand implements Command{
    @Override
    public void execute(String input) {
        String newPath = input.split(" ")[1];
        if(newPath.equals("./"))
            return;
        else if(newPath.startsWith("../")){
            Path path = Paths.get(ShellContext.getCurrentPath()).resolve(newPath).normalize();
            ShellContext.setCurrentPath(path.toString());
            return;
        }
        else if(newPath.startsWith("./"))
            newPath = ShellContext.getCurrentPath() + newPath.replaceFirst("^\\./", "/"); //manual way

        File newDir = new File(newPath);
        if (!newDir.isDirectory()) {
            System.out.println("cd: " + newPath + ": No such file or directory");
            return;
        }
        // Change the working directory
       ShellContext.setCurrentPath(newPath);
    }

    //manual way to resolve the path.
    /*
    private String resolve(String dir) {
        String[] input = dir.split("/");
        int count = 0;
        for(String curr : input) {
            if(curr.equals(".."))
                count++;
        }
        File file = new File(ShellContext.getCurrentPath());
        while(count > 0) {
            file = file.getParentFile();
            count--;
        }
        return file.getAbsolutePath();
    }*/
}
