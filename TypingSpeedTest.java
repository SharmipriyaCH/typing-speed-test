import java.util.Scanner;
import java.util.Random;

public class TypingSpeedTest {

    // Array of sample sentences
    static String[] sentences = {
        "Practice makes a man perfect.",
        "Java programming is fun and powerful.",
        "Always believe in yourself.",
        "Typing speed improves with practice.",
        "Consistency is the key to success."
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Pick a random sentence
        String testSentence = sentences[random.nextInt(sentences.length)];
        System.out.println("🔥 Typing Speed Test 🔥");
        System.out.println("Type the following sentence exactly as shown:");
        System.out.println("\n👉 " + testSentence);
        System.out.println("\nPress Enter when you're ready...");
        scanner.nextLine(); // Wait for Enter

        // Start the timer
        long startTime = System.currentTimeMillis();

        // Get user input
        System.out.println("\nStart typing below:");
        String userInput = scanner.nextLine();

        // End the timer
        long endTime = System.currentTimeMillis();

        // Calculate time taken
        long timeTaken = endTime - startTime; // in milliseconds
        double timeInSeconds = timeTaken / 1000.0;

        // Calculate words per minute (WPM)
        int wordCount = testSentence.split("\\s+").length;
        double wpm = (wordCount / timeInSeconds) * 60;

        // Calculate accuracy
        int correctChars = 0;
        int lengthToCompare = Math.min(userInput.length(), testSentence.length());

        for (int i = 0; i < lengthToCompare; i++) {
            if (userInput.charAt(i) == testSentence.charAt(i)) {
                correctChars++;
            }
        }

        double accuracy = ((double) correctChars / testSentence.length()) * 100;

        // Show results
        System.out.println("\n⏱️ Time Taken: " + timeInSeconds + " seconds");
        System.out.println("💨 Typing Speed: " + String.format("%.2f", wpm) + " WPM");
        System.out.println("🎯 Accuracy: " + String.format("%.2f", accuracy) + "%");

        // Bonus motivational message
        if (accuracy >= 90 && wpm >= 40) {
            System.out.println("🌟 Amazing! You're a typing ninja!");
        } else if (accuracy >= 75) {
            System.out.println("👍 Good job! Keep practicing.");
        } else {
            System.out.println("💪 Don't worry. You'll get better with practice!");
        }

        scanner.close();
    }
}
