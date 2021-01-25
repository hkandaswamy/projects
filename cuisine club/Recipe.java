import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Recipe
{
	// Global variable for the amount of current recipes.
	// Update if new recipes were added.
	static int AMOUNT_OF_RECIPES = 9;
	
	public void openRecipe(Scanner input) throws IOException
	{	
		// Creates an array containing all the available recipes.
		String[] recipes = {"-Corn on the Cob", "-Bucantini Alla Griccia With Gava Beans", "-Emergency Chicken",
				            "-Instant Pot Collard Greens", "-Oven baked Parsley Red", "-Pressure Cooker Hard Boiled Eggs",
						    "-Roasted Green Beans", "-Sauteed Radishes", "-Spaghetti Carbonara"};
		
		// Displays all the available recipes.
		System.out.println("\nHere's a list of the current recipes:");
		for (int i = 0; i < AMOUNT_OF_RECIPES; i++)
		{
			System.out.println(recipes[i]);
		}
		
		// Prompts user to choose a meal.
		System.out.println("\nWhich recipe do you wish to open?");
		
		// Consumes the left out \n from the previous nextInt scan.
		input.nextLine();
		
		// Gets the user's input.
		String Desired_Meal = input.nextLine();
		
		// Compares user's input with available meals.
		// If a match is found, it opens the file containing the recipe.
		if (Desired_Meal.equalsIgnoreCase("Corn on the Cob"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Corn_on_the_Cob.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Bucantini Alla Griccia With Gava Beans"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Bucatini_Alla_Griccia_With_Fava_Beans.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Emergency Chicken"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Emergency_Chicken.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Instant Pot Collard Greens"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Instant_Pot_Collard_Greens.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Oven baked Parsley Red"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Oven_Baked_Parsley_Red_Potatoes.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Pressure Cooker Hard Boiled Eggs"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Pressure_Cooker_Hard_Boiled_Eggs.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Roasted Green Beans"))
		{
			String path ="../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Roasted_Green_Beans.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Sauteed Radishes"))
		{
			String path ="../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Sauteed_Radishes.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else if (Desired_Meal.equalsIgnoreCase("Spaghetti Carbonara"))
		{
			String path = "../CSC-131-Project-Cuisine-Club/src/Meal_Recipes/Spaghetti_Carbonara.txt";
			File file = new File(path);
			Desktop.getDesktop().open(file);
		}
		else
		{
			System.out.println("That recipe is not currently available.");
		}
	}
}
