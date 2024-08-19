package Hack2;

import java.util.*;

public class QualityEdu {
    private static final Map<String, String> statesAndCapitals = new HashMap<>();
    
    private static final List<String> questions = new ArrayList<>();
    
    private static final Map<String, Integer> studentScores = new HashMap<>();
    
    static {
        statesAndCapitals.put("Andhra Pradesh","Amaravati");
        statesAndCapitals.put("Arunachal Pradesh" ,"Itanagar");
        statesAndCapitals.put("Assam","Dispur");
        statesAndCapitals.put("Bihar","Patna");
        statesAndCapitals.put("Chhattisgarh","Raipur");
        statesAndCapitals.put("Goa","Panaji");
        statesAndCapitals.put("Gujarat","Gandhinagar");
        statesAndCapitals.put("Haryana","Chandigarh");
        statesAndCapitals.put("Himachal Pradesh","Shimla");
        statesAndCapitals.put("Jharkhand","Ranchi");
        statesAndCapitals.put("Karnataka","Bengaluru");
        statesAndCapitals.put("Kerala","Thiruvananthapuram");
        statesAndCapitals.put("Madhya Pradesh","Bhopal");
        statesAndCapitals.put("Maharashtra","Mumbai");
        statesAndCapitals.put("Manipur","Imphal");
        statesAndCapitals.put("Meghalaya","Shillong");
        statesAndCapitals.put("Mizoram","Aizawl");
        statesAndCapitals.put("Nagaland","Kohima");
        statesAndCapitals.put("Odisha","Bhubaneswar");
        statesAndCapitals.put("Punjab","Chandigarh");
        statesAndCapitals.put("Rajasthan","Jaipur");
        statesAndCapitals.put("Sikkim","Gangtok");
        statesAndCapitals.put("Tamil Nadu","Chennai");
        statesAndCapitals.put("Telangana","Hyderabad");
        statesAndCapitals.put("Tripura","Agartala");
        statesAndCapitals.put("Uttar Pradesh","Lucknow");
        statesAndCapitals.put("Uttarakhand","Dehradun");
        statesAndCapitals.put("West Bengal","Kolkata");
    }
    
    private static void createQuizQuestions() {
        for (String state : statesAndCapitals.keySet()) {
            questions.add("What is the capital of " + state + "?");
        }
    }
    
    private static void conductQuiz(String studentName,int ques_size) {
        Scanner scanner = new Scanner(System.in);
        int score = 0;
        
        Collections.shuffle(questions); 
        
        System.out.println("Quiz started for: " + studentName);
        for (int i=0;i<ques_size;i++) {
            System.out.println("Q "+(i+1)+". "+questions.get(i));
            String state = questions.get(i).replace("What is the capital of ", "").replace("?", "");
            String correctAnswer = statesAndCapitals.get(state);
            
            System.out.print("Answer : ");
            String studentAnswer = scanner.nextLine().trim();
            if (studentAnswer.equalsIgnoreCase(correctAnswer)) {
                score++;
            }
        }
        studentScores.put(studentName, score);
        System.out.println("Quiz ended for " + studentName + ". Your Score: " + score + "/"+ques_size);
    }
    
    private static void displayLeaderboard() {
        System.out.println("\n--- Leaderboard ---");
        studentScores.entrySet()
                     .stream()
                     .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
                     .forEach(entry -> System.out.println(entry.getKey() + ": " + entry.getValue() + " points"));
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        createQuizQuestions(); // Create the quiz questions
        
        System.out.print("Enter the number of students participating : ");
        int numberOfStudents = scanner.nextInt();
        System.out.print("Enter the number of Questions per Quiz : ");
        int numberOfQues = scanner.nextInt();
        scanner.nextLine(); 
        
        for (int i = 1; i <= numberOfStudents; i++) {
            System.out.print("Enter the name of student " + i + ": ");
            String studentName = scanner.nextLine().trim();
            conductQuiz(studentName,numberOfQues); 
        }
        displayLeaderboard(); 
    }
}
