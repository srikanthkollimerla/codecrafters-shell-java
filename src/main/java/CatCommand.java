import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class CatCommand implements Command{
    @Override
    public void execute(String input) {
        List<String> filePaths = new ArrayList<>();
        String[] parts = input.split("'"); // Split by single quote
        StringBuilder output = new StringBuilder();

        for (int i = 1; i < parts.length; i += 2) { // Extract file names in odd indexes
            filePaths.add(parts[i]);
        }

        // Prepare and execute the cat command
        List<String> command = new ArrayList<>();
        command.add("cat");
        command.addAll(filePaths); // Pass file names separately to handle spaces properly

        try {
            ProcessBuilder processBuilder = new ProcessBuilder(command);
            Process process = processBuilder.start();

            // Capture command output
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                output.append(line).append(" ");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        System.out.println(output.toString().trim());
    }
}
