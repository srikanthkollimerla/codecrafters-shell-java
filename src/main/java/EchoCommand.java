import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EchoCommand implements Command {
    @Override
    public void execute(String input) {
        String result = input.replaceFirst("^echo\\s+", "").trim();

        StringBuilder stringBuilder = new StringBuilder();

        int counter = 0;
        for (char ch : result.toCharArray()) {
            if (ch == '\'') {
                counter++;
                continue;
            }
            if (ch == ' ' && counter % 2 == 0) {
                if (stringBuilder.charAt(stringBuilder.length() - 1) == ' ')
                    continue;
            }
            stringBuilder.append(ch);
        }
        System.out.println(stringBuilder.toString());
    }
}
