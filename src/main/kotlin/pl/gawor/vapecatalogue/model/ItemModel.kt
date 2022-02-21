package pl.gawor.vapecatalogue.model

data class ItemModel(
    val id: Int = 0,
    val name: String = "",
    val price: Double = 0.0,
    val imagePath: String = "",
    val notes: String = "",
    val categoryId: Int = 0
)
