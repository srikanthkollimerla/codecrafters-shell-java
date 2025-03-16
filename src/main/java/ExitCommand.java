public class ExitCommand implements Command {
    @Override
    public void execute(String input) {
        System.out.println("Exiting...");
        System.exit(0);
    }
}