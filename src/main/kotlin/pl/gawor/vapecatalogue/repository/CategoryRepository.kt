package pl.gawor.vapecatalogue.repository

import pl.gawor.vapecatalogue.model.CategoryModel
import pl.gawor.vapecatalogue.repository.dbhelper.DbHelper
import java.sql.ResultSet
import java.sql.SQLException
import java.sql.Statement

class CategoryRepository : CRUDrepository<CategoryModel> {

    private val dbHelper = DbHelper()

    override fun list(): List<CategoryModel>? {
        val list = ArrayList<CategoryModel>()
        val connection = dbHelper.getConnection()
        val query =  "select * from category"
        val statement: Statement
        val resultSet: ResultSet

        try {
            statement = connection!!.createStatement()
            resultSet = statement.executeQuery(query)
            var entity: CategoryModel?
            while (resultSet.next()) {
                entity = CategoryModel(
                    resultSet.getInt("id"),
                    resultSet.getString("name"),
                )
                list.add(entity)
            }
        } catch (ex: SQLException) {
            ex.printStackTrace()
        }
        return list
    }

    override fun create(entity: CategoryModel): CategoryModel {
        val query = "insert into category values (${entity.id}, '${entity.name}')"
        dbHelper.executeQuery(query)
        //TODO get created model
        return entity
    }

    override fun read(id: Int): CategoryModel {
        //TODO implement
        return CategoryModel(0,"")
    }

    override fun update(id: Int, entity: CategoryModel): CategoryModel {
        val query = "update category set name = '${entity.name}' where id = $id"
        dbHelper.executeQuery(query)
        //TODO get updated model
        return entity
    }

    override fun delete(id: Int): Boolean {
        val query = "delete from category where id = $id"
        dbHelper.executeQuery(query)
        //TODO return true if deletion is completed
        return true
    }
}