public class EchoCommand implements Command {
    @Override
    public void execute(String input) {
        System.out.println(input.substring(5)); // Extract after "echo "
    }
}
