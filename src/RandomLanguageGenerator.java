import java.util.Random;

public class RandomLanguageGenerator {
    static String[] highLanguages = {"C++", "Java", "Python3", "C", "C#", "Javascript"};
    static String[] mediumLangs = {"Ruby", "Swift", "Go", "Scala", "Kotlin", "Rust", "PHP", "Typescript"};
    static String[] lowLangs = {"Racket", "Erlang", "Elixir", "Dart"};
    static Random rand = new Random();

    public static void main(String[] args) {
        String[] selectLangs = new String[9];

        for (int i = 0; i < 5; i++) {
            selectLangs[i] = highLanguages[rand.nextInt(highLanguages.length)];
        }
        for (int i = 5; i < 8; i++) {
            selectLangs[i] = mediumLangs[rand.nextInt(mediumLangs.length)];
        }
        selectLangs[8] = lowLangs[rand.nextInt(lowLangs.length)];

        System.out.println(selectLangs[rand.nextInt(selectLangs.length)]);
    }
}
