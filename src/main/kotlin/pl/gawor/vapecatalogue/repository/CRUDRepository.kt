package pl.gawor.vapecatalogue.repository

interface CRUDrepository<Entity> {
    fun list(): List<Entity>?
    fun create(entity: Entity): Entity
    fun read(id: Int): Entity
    fun update(id: Int, entity: Entity): Entity
    fun delete(id: Int): Boolean
}