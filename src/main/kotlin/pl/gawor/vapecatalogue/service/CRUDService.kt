package pl.gawor.vapecatalogue.service

interface CRUDService<Model> {
    fun list(): List<Model>?
    fun create(model: Model): Model
    fun read(id: Int): Model
    fun update(id: Int, model: Model): Model
    fun delete(id: Int): Boolean
}