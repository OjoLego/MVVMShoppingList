package com.example.shoppinglist.data.repositories

import com.example.shoppinglist.data.db.ShoppingDataBase
import com.example.shoppinglist.data.db.entities.ShoppingItem

class ShoppingRepository(
    private val db: ShoppingDataBase
) {
    suspend fun upsert (item: ShoppingItem) = db.getShoppingDao().upsert(item)

    suspend fun delete (item: ShoppingItem) = db.getShoppingDao().delete(item)

    fun getAllShoppingItems() = db.getShoppingDao().getAllShoppingItems()
}