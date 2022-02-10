package pl.gawor.vapecatalogue.controller

import javafx.fxml.FXML
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.TextArea
import javafx.scene.control.TextField
import javafx.scene.image.ImageView
import javafx.scene.layout.GridPane

class Controller {
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
}