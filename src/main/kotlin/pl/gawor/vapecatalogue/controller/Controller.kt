package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import pl.gawor.vapecatalogue.VapeCatalogueApplication
import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.model.ItemModel
import pl.gawor.vapecatalogue.repository.ItemRepository
import pl.gawor.vapecatalogue.service.ItemService
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class Controller : Initializable {
    @FXML
    private lateinit var button_add: Button

    @FXML
    private lateinit var button_delete: Button

    @FXML
    private lateinit var button_search: Button

    @FXML
    private lateinit var button_update: Button

    @FXML
    private lateinit var gridPane: GridPane

    @FXML
    private lateinit var imageView: ImageView

    @FXML
    private lateinit var label_aromatics: Label

    @FXML
    private lateinit var label_category: Label

    @FXML
    private lateinit var label_coils: Label

    @FXML
    private lateinit var label_dryCBDs: Label

    @FXML
    private lateinit var label_evaporator: Label

    @FXML
    private lateinit var label_liquids: Label

    @FXML
    private lateinit var label_mods: Label

    @FXML
    private lateinit var label_name: Label

    @FXML
    private lateinit var label_others: Label

    @FXML
    private lateinit var label_pods: Label

    @FXML
    private lateinit var label_premixes: Label

    @FXML
    private lateinit var label_price: Label

    @FXML
    private lateinit var label_specimens: Label

    @FXML
    private lateinit var label_sticks: Label

    @FXML
    private lateinit var label_vaporizers: Label

    @FXML
    private lateinit var textField_image: TextField

    @FXML
    private lateinit var textField_name: TextField

    @FXML
    private lateinit var textField_notes: TextArea

    @FXML
    private lateinit var textField_price: TextField

    @FXML
    private lateinit var textField_search: TextField

    private var itemService: ItemService

    var list = ArrayList<ItemModel>()

    init {
        val itemRepository = ItemRepository()
        itemService = ItemService(itemRepository)
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
       refreshList(CategoryModel(1,"Grzałki"))
    }

    private fun refreshList(category: CategoryModel) {
        list = itemService.list() as ArrayList<ItemModel>

        var column = 0
        var row = 1

        for (model in list) {
            val fxmlLoader = FXMLLoader(VapeCatalogueApplication::class.java.getResource("view/item.fxml"))
            val anchorPane: AnchorPane = fxmlLoader.load()

            val itemController = fxmlLoader.getController<ItemController>()
            itemController.set(model)
            if (column == 4) {
                column = 0
                row ++
            }
            gridPane.add(anchorPane, column++, row)
            gridPane.minWidth = Region.USE_COMPUTED_SIZE
            gridPane.minHeight = Region.USE_COMPUTED_SIZE
            gridPane.maxWidth = Region.USE_COMPUTED_SIZE
            gridPane.maxHeight = Region.USE_COMPUTED_SIZE
            gridPane.prefWidth = Region.USE_COMPUTED_SIZE
            gridPane.prefHeight = Region.USE_COMPUTED_SIZE
            GridPane.setMargin(anchorPane, Insets(9.0))
        }
    }

}