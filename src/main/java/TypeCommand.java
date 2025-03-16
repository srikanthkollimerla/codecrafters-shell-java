public class TypeCommand implements Command {
    @Override
    public void execute(String input) {
        String commandName = input.substring(5);
        if (CommandRegistry.hasCommand(commandName)) {
            System.out.println(commandName + " is a shell builtin");
        } else {
            System.out.println(commandName + ": not found");
        }
    }
}
