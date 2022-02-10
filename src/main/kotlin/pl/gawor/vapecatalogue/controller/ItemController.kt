package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.ImageView

class ItemController {
    @FXML
    private lateinit var imageView: ImageView

    @FXML
    private lateinit var label_name: Label

    @FXML
    private lateinit var label_price: Label
}