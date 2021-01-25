
import java.io.IOException;
import java.util.Scanner;

public class MainClass
{
	public static void main(String[] args) throws IOException
	{
		// Creates objects to access the necessary classes.
		Ingredients ingr = new Ingredients();
		Recipe recip = new Recipe();
		
		// Starts the scanner.
		Scanner input = new Scanner(System.in);
		
		// Loop setup.
		int choice;
		boolean repeat = true;
		
		while (repeat)
		{
			// Menu for the user.
			System.out.print("==============================="
							+ "\nMenu:"
							+ "\n1. Open meal's recipe."
							+ "\n2. Open meal's ingredients."
			                + "\n3. Save my ingredients."
							+ "\n4. Check my ingredients."
			                + "\n5. Save my allergies."
							+ "\n6. Check my allergies."
							+ "\n0. Exit the program."
							+ "\nAnswer: ");
			
			// Gather user's input.
			choice = input.nextInt();
			
			// Runs the method according to the user's choice.
			if (choice == 1)
			{
				recip.openRecipe(input);
			}
			else if (choice == 2)
			{
				ingr.openIngredients(input);
			}
			else if (choice == 3)
			{
	            ingr.saveIngredients(input);
			}
			else if (choice == 4)
			{
				// ingr.ingredientsChecker(input);
			}
			else if (choice == 5)
			{
			    //save allergies
			    ingr.allergySaver(input);
			}
			else if (choice == 6)
			{
			    //check allergies
			    ingr.allergyChecker();
			}
			else if (choice == 0)
			{
				break;
			}
		}
		
		// Closes the scanner.
		input.close();
	}
}
