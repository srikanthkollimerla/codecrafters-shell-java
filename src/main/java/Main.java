import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {

        Scanner scanner = new Scanner(System.in);
        setCommands();
        while (true) {
            System.out.print("$ ");
            String input = scanner.nextLine();
            if (input.equals("exit 0"))
                break;
            String commandName = input.split(" ")[0];
            //System.out.println("this is command: " + commandName);
            Command command = CommandRegistry.getCommand(commandName);

            if(command != null) {
                command.execute(input);
            }
            else {
                System.out.println(commandName + ": not found");
            }
        }
    }

    private static void setCommands() {
        CommandRegistry.registerCommand("echo", new EchoCommand());
        CommandRegistry.registerCommand("exit", new ExitCommand());
        CommandRegistry.registerCommand("type", new TypeCommand());
    }
}
