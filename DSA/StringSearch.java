
import java.util.Scanner;

public class StringSearch {
    public static boolean linearSearch(String statement, String target) {
        int statementLength = statement.length();
        int targetLength = target.length();

        // Iterate through the statement characters
        for (int i = 0; i <= statementLength-targetLength; i++) {
            // Check if the substring starting at index i matches the target string
            if (statement.substring(i, i + targetLength).equals(target)) {
            	
            	
                return true; // Found a match
            }
        }

        return false; // No match found
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
      
        System.out.print("Enter a statement: ");
        String userStatement = scanner.nextLine();

        System.out.print("Enter the string to search: ");
        String searchString = scanner.nextLine();

        if (linearSearch(userStatement, searchString)) {
          
			System.out.println("String found in the statement.");
        } else {
            System.out.println("String not found in the statement.");
        }

        scanner.close();
    }
}
