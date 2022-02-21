package pl.gawor.vapecatalogue.repository


import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.model.ItemModel
import pl.gawor.vapecatalogue.repository.dbhelper.DbHelper
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class ItemRepository : CRUDrepository<ItemModel> {

    private val dbHelper = DbHelper()

    override fun list(): List<ItemModel> {
        val list = ArrayList<ItemModel>()
        val connection = dbHelper.getConnection()
        val query =  "select * from item"
        val statement: Statement
        val resultSet: ResultSet

        try {
            statement = connection!!.createStatement()
            resultSet = statement.executeQuery(query)
            var entity: ItemModel?
            while (resultSet.next()) {
                entity = ItemModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getString("imagePath"),
                    resultSet.getString("notes"),
                    resultSet.getInt("category_id")
                )
                list.add(entity)
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
        return list
    }

    override fun create(entity: ItemModel): ItemModel {
        val query = "insert into item values (" +
                "${entity.id}, " +
                "'${entity.name}', " +
                "${entity.price}, " +
                "'${entity.imagePath}', " +
                "'${entity.notes}', " +
                "${entity.categoryId}" +
                ")"
        dbHelper.executeQuery(query)
        //TODO get created model
        return entity
    }

    override fun read(id: Int): ItemModel {
        //TODO implement
        return ItemModel(0,"", 0.0, "", "", 0)
    }

    override fun update(id: Int, entity: ItemModel): ItemModel {
        val query = "update item set name = '${entity.name}', " +
                " price = ${entity.price}, " +
                " imagePath = '${entity.imagePath}', " +
                " notes = '${entity.notes}', " +
                " category_id = ${entity.categoryId}" +
                " where id = $id"
        dbHelper.executeQuery(query)
        //TODO get updated model
        return entity
    }

    override fun delete(id: Int): Boolean {
        val query = "delete from item where id = $id"
        dbHelper.executeQuery(query)
        //TODO return true if deletion is completed
        return true
    }

    fun list(category: CategoryModel): List<ItemModel> {
        val list = ArrayList<ItemModel>()
        val connection = dbHelper.getConnection()
        val query =  "select * from item where category_id = ${category.id}"
        val statement: Statement
        val resultSet: ResultSet

        try {
            statement = connection!!.createStatement()
            resultSet = statement.executeQuery(query)
            var entity: ItemModel?
            while (resultSet.next()) {
                entity = ItemModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getString("imagePath"),
                    resultSet.getString("notes"),
                    resultSet.getInt("category_id")
                )
                list.add(entity)
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
        return list
    }

    fun read(template: String, category: CategoryModel) : List<ItemModel> {
        val list = ArrayList<ItemModel>()
        val connection = dbHelper.getConnection()
        val query =  "select * from item where  category_id = ${category.id} and name like '%$template%'"
        val statement: Statement
        val resultSet: ResultSet
        try {
            statement = connection!!.createStatement()
            resultSet = statement.executeQuery(query)
            var entity: ItemModel?
            while (resultSet.next()) {
                entity = ItemModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                    resultSet.getDouble("price"),
                    resultSet.getString("imagePath"),
                    resultSet.getString("notes"),
                    resultSet.getInt("category_id")
                )
                list.add(entity)
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
        return list
    }
}