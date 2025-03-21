package t_o_o_fi_Find_All_Possible_Recipes_Given_Supplies


class FindAllPossibleRecipesGivenSupplies {
    fun findAllRecipes(recipes: Array<String>, ingredients: List<List<String>>, supplies: Array<String>): List<String> {
        val result = mutableListOf<String>()
        val available = HashSet<String>()
        val queue = ArrayDeque<Int>()
        var lastSize = 0

        supplies.forEach {
            available.add(it)
        }

        for (i in recipes.indices) {
            queue.addLast(i)
        }

        while (available.size > lastSize) {
            lastSize = available.size
            var queueSize = queue.size

            while (queueSize-- > 0) {
                var canCreate = true
                val recipeIndex = queue.removeFirst()

                for (i in ingredients[recipeIndex].indices) {
                    if (!available.contains(ingredients[recipeIndex][i])) {
                        canCreate = false
                        break;
                    }
                }

                if (!canCreate) {
                    queue.addLast(recipeIndex)
                } else {
                    available.add(recipes[recipeIndex])
                    result.add(recipes[recipeIndex])
                }
            }
        }

        return result
    }
}