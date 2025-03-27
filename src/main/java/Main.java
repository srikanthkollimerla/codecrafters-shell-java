import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
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

            if (command != null) {
                command.execute(input);
            } else {
                // Command not found in registry, try running as an external program

                String[] arguments = input.split(" ", 2).length > 1 ? input.split(" ", 2)[1].split(" ") : new String[]{};
                //input.split(" ", 2) : This splits the input string into two parts: command and arguments

                // Find the executable path using the PATH directories

                String pathEnv = System.getenv("PATH");
                String executablePath = findExecutable(pathEnv.split(":"), commandName);

                if (executablePath != null) {
                    runExternalProgram(executablePath, arguments);
                } else {
                    System.out.printf("%s: command not found%n", commandName);
                }
            }
        }
    }

    // Method to find the executable in directories listed in PATH
    private static String findExecutable(String[] pathDirectories, String command) {
        for (String dir : pathDirectories) {
            String filePath = dir + "/" + command;
            File file = new File(filePath);
            if (file.exists() && file.canExecute()) {
                return command;  // Return the command if executable found
            }
        }
        return null; // Return null if not found
    }

    // Method to run the external program and capture the output
    private static void runExternalProgram(String executablePath, String[] arguments) {
        try {
            // Construct the command with the full executable path and arguments
            ProcessBuilder processBuilder = new ProcessBuilder();
            processBuilder.command(combineCommand(executablePath, arguments));

            // Start the process and capture the output
            Process process = processBuilder.start();

            // Capture the standard output from the external program
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    System.out.println(line);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void setCommands() {
        CommandRegistry.registerCommand("echo", new EchoCommand());
        CommandRegistry.registerCommand("exit", new ExitCommand());
        CommandRegistry.registerCommand("type", new TypeCommand());
        CommandRegistry.registerCommand("pwd", new PwdCommand());
        CommandRegistry.registerCommand("cd", new CdCommand());
        CommandRegistry.registerCommand("cat", new CatCommand());
    }

    private static List<String> combineCommand(String executablePath, String[] arguments) {
        List<String> commandList = new ArrayList<>();
        commandList.add(executablePath);  // Add executable first
        commandList.addAll(Arrays.asList(arguments)); // Add arguments
        return commandList;
    }


}
