package com.duccnv.cleanmoviedb.domain.repository

import com.duccnv.cleanmoviedb.domain.model.Item
import io.reactivex.Single

interface ItemRepository : Repository {
    fun getItem(id: Int): Single<Item>

    fun searchItems(query: String, page: Int? = 1): Single<List<Item>>
}