package pl.gawor.vapecatalogue

import javafx.application.Application
import javafx.fxml.FXMLLoader
import javafx.scene.Scene
import javafx.stage.Stage

class VapeCatalogueApplication : Application() {
    override fun start(stage: Stage) {
        val fxmlLoader = FXMLLoader(VapeCatalogueApplication::class.java.getResource("view/view.fxml"))
        val scene = Scene(fxmlLoader.load(),  1920.0, 1013.0)
        stage.isMaximized = true
        stage.title = "Vape catalogue - gaworex software"
        stage.scene = scene
        stage.show()
    }

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            launch(VapeCatalogueApplication::class.java)
        }
    }
}