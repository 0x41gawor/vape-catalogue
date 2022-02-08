package pl.gawor.vapecatalogue

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage
import pl.gawor.vapecatalogue.model.ItemModel
import pl.gawor.vapecatalogue.repository.ItemRepository

class VapeCatalogueApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(VapeCatalogueApplication::class.java.getResource("view/view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
        val repo = ItemRepository()
        repo.update(2, ItemModel(2, "sd", 6.9, "fsdgsd", "fd", 2))
    }
}

fun main() {
    Application.launch(VapeCatalogueApplication::class.java)
}