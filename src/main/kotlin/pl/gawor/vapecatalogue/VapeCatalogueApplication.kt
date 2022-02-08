package pl.gawor.vapecatalogue

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class VapeCatalogueApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(VapeCatalogueApplication::class.java.getResource("view/view.fxml"))
        val scene = Scene(fxmlLoader.load(), 320.0, 240.0)
        stage.title = "Hello!"
        stage.scene = scene
        stage.show()
    }
}

fun main() {
    Application.launch(VapeCatalogueApplication::class.java)
}