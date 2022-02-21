package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.scene.control.Label
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import pl.gawor.vapecatalogue.VapeCatalogueApplication
import pl.gawor.vapecatalogue.model.ItemModel
import kotlin.collections.ArrayList


//---// P U B L I S H E R
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

    @FXML
    fun anchorPane_onMouseClicked() {
        notifySubscribers()
    }

    //---// S U B S C R I B E R S
    private val subscribers: ArrayList<ISubscriber> = ArrayList<ISubscriber>()

    //---// S U B S C R I B E
    fun subscribe(s: ISubscriber) {
        subscribers.add(s)
    }

    //---// U N S U B S C R I B E
    fun unsubscribe(s: ISubscriber) {
        subscribers.remove(s)
    }

    //---// N O T I F Y  S U B S C R I B E R S
    private fun notifySubscribers() {
        for (s in subscribers) {
            s.update(model)
        }
    }
}