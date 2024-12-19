package textadventure.util;

/**
 *
 * @author qaffqa
 */
public class TextFormatter {
    /*
    Contains helper methods for formatting text,
    like centering or adding visual effects
    (e.g., capitalizing room names or adding line breaks).
    */
    public static String formatText(String text, boolean center, int maxLineLength) {
    if (center) {
        text = centerText(text, 40);  // Center the text with a width of 40
    }
    
    text = addLineBreaks(text, maxLineLength);  // Break the lines at a max length
    
    return text;
}
    public static String centerText(String text, int width) {
        int padding = (width - text.length()) / 2;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < padding; i++) {
            sb.append(" ");
    }
    sb.append(text);
    return sb.toString();
    }
    
    public static String addLineBreaks(String text, int maxLineLength) {
        StringBuilder sb = new StringBuilder();
        String[] words = text.split(" ");
        int lineLength = 0;
    
        for (String word : words) {
            if (lineLength + word.length() > maxLineLength) {
                sb.append("\n");
                lineLength = 0;
            }
            sb.append(word).append(" ");
            lineLength += word.length() + 1;
        }
        return sb.toString().trim();
    }
}
