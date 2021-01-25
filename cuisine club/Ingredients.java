import java.awt.Desktop;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Ingredients
{
	// Global variable for the amount of current recipes.
	// Update if new recipes were added.
	private static int AMOUNT_OF_RECIPES = 9;
	
	/**
	 * Method that displays a meal's ingredients of the user's choosing.
	 * @throws IOException
	 */
    public void openIngredients(Scanner input) throws IOException
    {
    	// Creates an array containing all the available meals.
    	String[] meals = {"-Corn in the Cob", "-Bucantini Alla Griccia With Gava Beans", "-Emergency Chicken",
    					    "-Instant Pot Collard Greens", "-Oven baked Parsley Red", "-Pressure Cooker Hard Boiled Eggs",
    					    "-Roasted Green Beans", "-Sauteed Radishes", "-Spaghetti Carbonara"};
    	
    	// Displays all the available meals.
    	System.out.println("\nHere's a list of the current meals:");
    	for (int i = 0; i < AMOUNT_OF_RECIPES; i++)
    	{
    		System.out.println(meals[i]);
    	}
    	
		// Consumes the left out \n from the previous nextInt scan.
		input.nextLine();
		
    	// Prompts the users to choose a meal whose ingredients will be displayed.
    	System.out.println("\nWhich meal's ingredients would you like to see?");
		String choice = input.nextLine();

		// Compares user's input with available meals.
		// If a match is found, it opens the file containing the recipe.
		if (choice.equalsIgnoreCase("Corn on the Cob"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Corn_on_the_Cob_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Bucantini Alla Griccia With Gava Beans"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Bucatini_Alla_Griccia_With_Fava_Beans_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Emergency Chicken"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Emergency_Chicken_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Instant Pot Collard Greens"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Instant_Pot_Collard_Greens_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Oven baked Parsley Red"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Oven_Baked_Parsley_Red_Potatoes_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Pressure Cooker Hard Boiled Eggs"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Pressure_Cooker_Hard_Boiled_Eggs_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Roasted Green Beans"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Roasted_Green_Beans_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Sauteed Radishes"))
		{
			String path ="../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Sauteed_Radishes_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (choice.equalsIgnoreCase("Spaghetti Carbonara"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Ingredients/Spaghetti_Carbonara_igr.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else
		{
			System.out.println("That meal is not currently available.");
		}
    }
    
    /**
     * Method that saves the user's ingredients into a file.
     */
	public void saveIngredients(Scanner console)
	{
		// Creates arraylists to stores the user's ingredients and their quantities.
		ArrayList<String> ingredientName = new ArrayList<String>();
		ArrayList<String> amount = new ArrayList<String>();
		
		// Consumes the left out \n from the previous nextInt scan.
		console.nextLine();
		
    	// Informs the user of how to exit the loop.
    	System.out.println("Type 'exit' to end the loop.");
		
		// Gather's the user's ingredients until they wish to stop.
	    while(true)
	    {
	    	// Asks the user for the ingredient's name.
	        System.out.print("Enter name of ingredient: ");
	        
	        // Saves the ingredient name.
	        String ingredient = console.nextLine();
	        
	        // Checks if user wants to stop the loop.
	        if (ingredient.toLowerCase().equals("exit"))
	        {
	            break;
	        }
	        
	        // Asks the user how many of the previous ingredient he owns.
	        System.out.print("Please enter the amount: ");
	        
	        // Saves the ingredient quantity.
	        String quantity = console.nextLine();
	        
	        // Adds the ingredient name and quantity to the lists.
	        amount.add(quantity);
	        ingredientName.add(ingredient);
        }
	    
	    try
	    {
	    	// Creates a new file to store the user's ingredients.
	        BufferedWriter out = new BufferedWriter(new FileWriter("curr_igr.txt"));
	        
	        // Writes the contents of the lists into the file.
	        for (int i = 0; i < amount.size(); i++)
	        {
	            out.write(amount.get(i) + " " + ingredientName.get(i)+ "\n");
	        }
	        
	        // Feedback for user.
	        System.out.println("Your ingredients have been saved in curr_igr.txt");
	        
	        // Closes the writer.
	        out.close();                               
	    }
	    catch (IOException e)
	    {
	       System.out.println("Exception ");
	    }
	}
	
	public void ingredientsChecker(BufferedReader required) throws IOException
	{
        BufferedReader  hasTheseIngredients  = new BufferedReader(new FileReader("curr_ingr.txt"));
		PrintWriter     missingIngredients   = new PrintWriter("missingIngredients.txt");
		String checker                       = hasTheseIngredients.readLine();
		String lineCompare                   = required.readLine();

		
		while(checker != null)
		{
		    if (lineCompare.equals(checker))
		    {
				lineCompare = required.readLine();
				checker = hasTheseIngredients.readLine();
			}
			else
			{
				missingIngredients.print(lineCompare + "\n");
				lineCompare = required.readLine();
				checker = hasTheseIngredients.readLine();
			}
		}
		
		hasTheseIngredients.close();
		required.close();
		missingIngredients.close();
	}
	
	public void allergyChecker() throws IOException
	{
	    //read list of allergies from allergy_info.txt
	    BufferedReader in = new BufferedReader(new FileReader("allergy_info.txt"));
	    
	    String line;
	    while((line = in.readLine()) != null)
	    {
	        System.out.println(line);
	    }
	    in.close();
	}
	
	public void allergySaver(Scanner console) throws IOException 
	{   
	    System.out.println("Enter name of allergy: ");
	    console.nextLine();
	    String newAllergy = console.nextLine();
	    
	    BufferedWriter writer = new BufferedWriter(new FileWriter("allergy_info.txt", true));  
	    writer.newLine();
	    writer.write(newAllergy);
	    writer.close();
	}
	
}