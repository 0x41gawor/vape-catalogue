package pl.gawor.vapecatalogue.service

import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.repository.CategoryRepository

class CategoryService(private val repository: CategoryRepository) : CRUDService<CategoryModel> {

    override fun list(): List<CategoryModel> {
        return repository.list()
    }

    override fun create(model: CategoryModel): CategoryModel {
        return repository.create(model)
    }

    override fun read(id: Int): CategoryModel {
        return repository.read(id)
    }

    override fun update(id: Int, model: CategoryModel): CategoryModel {
        return repository.update(id, model)
    }

    override fun delete(id: Int): Boolean {
        return repository.delete(id)
    }
}