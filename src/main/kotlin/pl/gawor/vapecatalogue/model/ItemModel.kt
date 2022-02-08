package pl.gawor.vapecatalogue.model

data class ItemModel(
    val id: Int,
    val name: String,
    val price: Double,
    val imagePath: String,
    val notes: String,
    val categoryId: Int
)
