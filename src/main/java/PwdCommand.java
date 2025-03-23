import java.nio.file.Path;
import java.nio.file.Paths;

public class PwdCommand implements Command{
    @Override
    public void execute(String input) {
        Path path = Paths.get("");
        String currentPath = path.toAbsolutePath().toString();
        System.out.println(currentPath);
    }
}
