import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

public class SP1 {
    public static void main(String[] args) throws IOException {
        int lineNumber = countLines("TextIn");
        System.out.println(lineNumber);

        File file =new File("TextIn");
        Scanner scanner = new Scanner(file);
        StringBuilder line = new StringBuilder();
        for(int i=0; i<lineNumber; i++){
            line.append(scanner.nextLine() + " ");
        }
        String[] words = line.toString().split("[\\s\\-\\.\\?\\,\\_\\@\\(\\)\\\"\\+\\/\\\\]+"); // \\W
        words = new HashSet<String>(Arrays.asList(words)).toArray(new String[0]);
        System.out.println(Arrays.toString(words));
        scanner.close();

        StringBuilder answer = new StringBuilder();
        int len=0;
        char[] charWord;
        for(int i=0; i<words.length; i++) {
            charWord = words[i].toCharArray();
            len = charWord.length;
            for (int j = 0; j < len - 1; j++) {
                if (Character.isAlphabetic(charWord[j]) && charWord[j] == charWord[j + 1]
                        && charWord[j] != 'a'
                        && charWord[j] != 'e' && charWord[j] != 'y' && charWord[j] != 'u'
                        && charWord[j] != 'i' && charWord[j] != 'o' && charWord[j] != '\'' ) {
                    answer.append(words[i] + " ");
                    break;
                }
            }
        }
        System.out.println(answer.toString());
        writeAnswer(answer.toString());
    }

    public static int countLines(String path) throws IOException {

        File file = new File(path);

        FileReader fileReader = new FileReader(file);
        LineNumberReader lineNumberReader = new LineNumberReader(fileReader);
        int lineNumber = 0;
        while (lineNumberReader.readLine() != null){
            lineNumber++;
        }

        lineNumberReader.close();
        return lineNumber;
    }

    public static void writeAnswer(String toWrite) throws FileNotFoundException {
        File file = new File("TextOut");
        PrintWriter pw = new PrintWriter(file);
        pw.println(toWrite);
        pw.close();
    }


}
