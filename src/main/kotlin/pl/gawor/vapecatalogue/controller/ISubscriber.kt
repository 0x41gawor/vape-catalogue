package pl.gawor.vapecatalogue.controller

import pl.gawor.vapecatalogue.model.ItemModel

//---// S U B S C R I B E R
interface ISubscriber {
    //---// U P D A T E
    fun update(model: ItemModel)
}