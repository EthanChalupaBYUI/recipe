import java.util.Scanner

data class Recipe(var name: String, var ingredients: String, var instructions: String)

class RecipeManager {
    private val recipes = mutableListOf<Recipe>()

    fun addRecipe(recipe: Recipe) {
        recipes.add(recipe)
    }

    fun editRecipe(index: Int, recipe: Recipe) {
        if (index in 0 until recipes.size) {
            recipes[index] = recipe
        } else {
            println("Recipe index out of bounds.")
        }
    }

    fun removeRecipe(index: Int) {
        if (index in 0 until recipes.size) {
            recipes.removeAt(index)
        } else {
            println("Recipe index out of bounds.")
        }
    }

    fun listRecipes() {
        if (recipes.isEmpty()) {
            println("No recipes found.")
        } else {
            println("Recipes:")
            recipes.forEachIndexed { index, recipe ->
                println("$index: ${recipe.name}")
            }
        }
    }

    fun getRecipe(index: Int): Recipe? {
        return if (index in 0 until recipes.size) {
            recipes[index]
        } else {
            println("Recipe index out of bounds.")
            null
        }
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val recipeManager = RecipeManager()

    while (true) {
        println("\nMenu:")
        println("1. Add Recipe")
        println("2. Edit Recipe")
        println("3. Remove Recipe")
        println("4. List Recipes")
        println("5. Exit")
        print("Enter your choice: ")
        when (scanner.nextInt()) {
            1 -> {
                println("Enter recipe details:")
                print("Name: ")
                val name = scanner.next()
                scanner.nextLine() // Consume newline
                print("Ingredients: ")
                val ingredients = scanner.nextLine()
                print("Instructions: ")
                val instructions = scanner.nextLine()
                recipeManager.addRecipe(Recipe(name, ingredients, instructions))
                println("Recipe added successfully.")
            }
            2 -> {
                print("Enter recipe index to edit: ")
                val index = scanner.nextInt()
                val recipe = recipeManager.getRecipe(index)
                if (recipe != null) {
                    println("Enter new recipe details:")
                    print("Name: ")
                    val name = scanner.next()
                    scanner.nextLine() // Consume newline
                    print("Ingredients: ")
                    val ingredients = scanner.nextLine()
                    print("Instructions: ")
                    val instructions = scanner.nextLine()
                    recipeManager.editRecipe(index, Recipe(name, ingredients, instructions))
                    println("Recipe edited successfully.")
                }
            }
            3 -> {
                print("Enter recipe index to remove: ")
                val index = scanner.nextInt()
                recipeManager.removeRecipe(index)
                println("Recipe removed successfully.")
            }
            4 -> recipeManager.listRecipes()
            5 -> {
                println("Exiting...")
                return
            }
            else -> println("Invalid choice.")
        }
    }
}