import java.util.Scanner;

public class QuizProgram {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        do {
            playQuiz(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgain = scanner.next().toLowerCase();

            if (!playAgain.equals("yes")) {
                break;
            }

        } while (true);

        System.out.println("Thank you for playing! Goodbye.");

        scanner.close();
    }

    private static void playQuiz(Scanner scanner) {
        System.out.println("Welcome to the General Knowledge and Computer Quiz!");
        System.out.println("----------------------------------------------------");
        System.out.println("Instructions:");
        System.out.println("1. Answer each question by typing the letter corresponding to your choice.");
        System.out.println("2. Each correct answer earns you a point.");
        System.out.println("3. The quiz consists of both general knowledge and computer-based questions.");
        System.out.println("4. At the end of the quiz, your score and the correct answers will be displayed.");
        System.out.println("----------------------------------------------------\n");

        System.out.print("Enter your name: ");
        String contestantName = scanner.nextLine();

        String[] generalQuestions = {
                "What is the capital of Japan?",
                "Who wrote 'Romeo and Juliet'?",
                "Which ocean is the largest?",
                "In what year did World War II end?",
                "What is the currency of India?",
        };

        String[][] generalChoices = {
                {"A) Beijing", "B) Seoul", "C) Tokyo", "D) Bangkok"},
                {"A) Charles Dickens", "B) William Shakespeare", "C) Jane Austen", "D) Mark Twain"},
                {"A) Atlantic Ocean", "B) Indian Ocean", "C) Southern Ocean", "D) Pacific Ocean"},
                {"A) 1943", "B) 1944", "C) 1945", "D) 1946"},
                {"A) Yen", "B) Won", "C) Ringgit", "D) Rupee"},
        };

        char[] generalCorrectAnswers = {'C', 'B', 'D', 'C', 'D'};

        String[] computerQuestions = {
                "What does HTML stand for?",
                "Who is the co-founder of Microsoft?",
                "What is the main function of RAM in a computer?",
                "Which programming language is widely used for web development?",
                "What does GUI stand for?",
        };

        String[][] computerChoices = {
                {"A) Hyper Text Markup Language", "B) High-level Text Manipulation Language", "C) Hyperlink and Text Markup Language", "D) High-level Text Markup Language"},
                {"A) Steve Jobs", "B) Bill Gates", "C) Mark Zuckerberg", "D) Larry Page"},
                {"A) Provides long-term storage", "B) Manages input and output devices", "C) Stores the operating system", "D) Provides temporary storage for data and programs"},
                {"A) Java", "B) Python", "C) C++", "D) HTML"},
                {"A) Graphic User Interface", "B) General User Interface", "C) Graphical User Instruction", "D) General User Instruction"},
        };

        char[] computerCorrectAnswers = {'A', 'B', 'D', 'A', 'A'};

        int totalGeneralQuestions = generalQuestions.length;
        int totalComputerQuestions = computerQuestions.length;
        int score = 0;
        long startTime = System.currentTimeMillis();

        for (int i = 0; i < totalGeneralQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + generalQuestions[i]);

            for (String choice : generalChoices[i]) {
                System.out.println(choice);
            }

            System.out.print("Your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == generalCorrectAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + generalCorrectAnswers[i] + ".\n");
            }
        }

        for (int i = 0; i < totalComputerQuestions; i++) {
            System.out.println("Question " + (i + 1 + totalGeneralQuestions) + ": " + computerQuestions[i]);

            for (String choice : computerChoices[i]) {
                System.out.println(choice);
            }

            System.out.print("Your answer: ");
            char userAnswer = scanner.next().toUpperCase().charAt(0);

            if (userAnswer == computerCorrectAnswers[i]) {
                System.out.println("Correct!\n");
                score++;
            } else {
                System.out.println("Incorrect. The correct answer is " + computerCorrectAnswers[i] + ".\n");
            }
        }

        System.out.println("Correct Answers:");

        for (int i = 0; i < totalGeneralQuestions; i++) {
            System.out.println("Question " + (i + 1) + ": " + generalCorrectAnswers[i]);
        }

        for (int i = 0; i < totalComputerQuestions; i++) {
            System.out.println("Question " + (i + 1 + totalGeneralQuestions) + ": " + computerCorrectAnswers[i]);
        }

        long endTime = System.currentTimeMillis();
        long totalTime = endTime - startTime;

        System.out.println("Quiz completed!");
        System.out.println("Contestant: " + contestantName);
        System.out.println("Score: " + score + " out of " + (totalGeneralQuestions + totalComputerQuestions));
        System.out.println("Time taken: " + totalTime / 1000 + " seconds");
    }
}
