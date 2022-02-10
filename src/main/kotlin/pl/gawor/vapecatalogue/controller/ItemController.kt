package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import pl.gawor.vapecatalogue.VapeCatalogueApplication
import pl.gawor.vapecatalogue.model.ItemModel

class ItemController {
    @FXML
    private lateinit var imageView: ImageView

    @FXML
    private lateinit var label_name: Label

    @FXML
    private lateinit var label_price: Label

    private lateinit var model: ItemModel

    fun set(model: ItemModel) {
        this.model = model
        label_name.text = model.name
        label_price.text = model.price.toString()
        val image = Image(VapeCatalogueApplication::class.java.getResourceAsStream(model.imagePath))
        imageView.image = image
    }
}