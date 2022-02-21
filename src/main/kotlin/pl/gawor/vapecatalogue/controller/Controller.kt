package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.fxml.FXMLLoader
import javafx.fxml.Initializable
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.image.Image
import javafx.scene.image.ImageView
import javafx.scene.input.MouseEvent
import javafx.scene.layout.AnchorPane
import javafx.scene.layout.GridPane
import javafx.scene.layout.Region
import pl.gawor.vapecatalogue.VapeCatalogueApplication
import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.model.ItemModel
import pl.gawor.vapecatalogue.repository.CategoryRepository
import pl.gawor.vapecatalogue.repository.ItemRepository
import pl.gawor.vapecatalogue.service.CategoryService
import pl.gawor.vapecatalogue.service.ItemService
import java.net.URL
import java.util.*
import kotlin.collections.ArrayList

class Controller : Initializable,ISubscriber {
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
    private lateinit var label_others: Label

    @FXML
    private lateinit var label_pods: Label

    @FXML
    private lateinit var label_premixes: Label

    @FXML
    private lateinit var label_specimens: Label

    @FXML
    private lateinit var label_sticks: Label

    @FXML
    private lateinit var label_vaporizers: Label

    @FXML
    private lateinit var label_name: Label

    @FXML
    private lateinit var imageView: ImageView

    @FXML
    private lateinit var label_price: Label

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

    private var categoryService: CategoryService

    var list = ArrayList<ItemModel>()

    var selectedCategory: CategoryModel = CategoryModel(1, "Grzałki")

    var selectedItem: ItemModel = ItemModel()

    init {
        val itemRepository = ItemRepository()
        itemService = ItemService(itemRepository)
        val categoryRepository = CategoryRepository()
        categoryService = CategoryService(categoryRepository)
    }

    override fun initialize(p0: URL?, p1: ResourceBundle?) {
        refreshList()
        refreshCategoryName()
        refreshSelectedItem()
    }

    @FXML
    private fun label_onMouseClicked(event: MouseEvent) {
        selectedCategory = when(event.source) {
            label_coils -> categoryService.read(1)
            label_pods -> categoryService.read(2)
            label_mods -> categoryService.read(3)
            label_sticks -> categoryService.read(4)
            label_evaporator -> categoryService.read(5)
            label_dryCBDs -> categoryService.read(6)
            label_vaporizers -> categoryService.read(7)
            label_premixes -> categoryService.read(8)
            label_liquids -> categoryService.read(9)
            label_specimens -> categoryService.read(10)
            label_aromatics -> categoryService.read(11)
            label_others -> categoryService.read(12)
            else -> CategoryModel(1, "Gaworex Error")
        }
        refreshList()
        refreshCategoryName()
        selectedItem = ItemModel()
        refreshSelectedItem()
    }

    private fun refreshList() {
        list = itemService.list(selectedCategory) as ArrayList<ItemModel>

        gridPane.children.clear()

        var column = 0
        var row = 1

        for (model in list) {
            val fxmlLoader = FXMLLoader(VapeCatalogueApplication::class.java.getResource("view/item.fxml"))
            val anchorPane: AnchorPane = fxmlLoader.load()

            val itemController = fxmlLoader.getController<ItemController>()
            itemController.set(model)
            itemController.subscribe(this)
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

    private fun refreshCategoryName() {
        label_category.text = when(selectedCategory.id) {
            1 -> "Grzałki"
            2 -> "Pody"
            3 -> "Mody"
            4 -> "Sticki"
            5 -> "Parowniki"
            6 -> "Susz&CBD"
            7 -> "Vaporyzatory"
            8 -> "Premixy"
            9 -> "Liqiudy"
            10 -> "Preparaty"
            11 -> "Aromatyzujące"
            12 -> "Inne"
            else -> "Gaworex Error"
        }
    }

    override fun update(model: ItemModel) {
        selectedItem = model
        refreshSelectedItem()
    }

    private fun refreshSelectedItem() {
        label_name.text = selectedItem.name
        label_price.text = if (selectedItem.price != 0.0) selectedItem.price.toString() else ""
        val image: Image
        if (selectedItem.imagePath != "") {
            image = Image(VapeCatalogueApplication::class.java.getResourceAsStream(selectedItem.imagePath))
        } else {
            image = Image(VapeCatalogueApplication::class.java.getResourceAsStream("view/img/1.png"))
        }

        imageView.image = image

        textField_name.text = selectedItem.name
        textField_image.text = selectedItem.imagePath
        textField_price.text = if (selectedItem.price != 0.0) selectedItem.price.toString() else ""
        textField_notes.text = selectedItem.notes
    }

}