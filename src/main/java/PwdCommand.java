public class PwdCommand implements Command{
    @Override
    public void execute(String input) {
        //Path path = Paths.get("");
        //String currPath = path.toAbsolutePath().toString();
        System.out.println(ShellContext.getCurrentPath());
    }
}
