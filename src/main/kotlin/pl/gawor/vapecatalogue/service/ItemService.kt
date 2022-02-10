package pl.gawor.vapecatalogue.service

import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.model.ItemModel
import pl.gawor.vapecatalogue.repository.ItemRepository

class ItemService(private val repository: ItemRepository) : CRUDService<ItemModel> {

    override fun list(): List<ItemModel> {
        return repository.list()
    }

    override fun create(model: ItemModel): ItemModel {
        return repository.create(model)
    }

    override fun read(id: Int): ItemModel {
        return repository.read(id)
    }

    override fun update(id: Int, model: ItemModel): ItemModel {
        return repository.update(id, model)
    }

    override fun delete(id: Int): Boolean {
        return repository.delete(id)
    }

    fun list(category: CategoryModel): List<ItemModel> {
        return repository.list(category)
    }
}