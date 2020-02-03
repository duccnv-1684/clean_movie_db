package com.duccnv.cleanmoviedb.data

import com.duccnv.cleanmoviedb.data.model.ItemEntityMapper
import com.duccnv.cleanmoviedb.data.remote.api.ItemApi
import com.duccnv.cleanmoviedb.domain.model.Item
import com.duccnv.cleanmoviedb.domain.repository.ItemRepository
import io.reactivex.Single
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ItemRepositoryImpl @Inject constructor(
    private val itemApi: ItemApi,
    private val itemEntityMapper: ItemEntityMapper
) : ItemRepository {
    override fun searchItems(query: String, page: Int?): Single<List<Item>> {
        return itemApi.searchRepos(query = query, page = if (page == null) 0 else page)
            .map { response ->
                response.items.map { itemEntityMapper.mapToDomain(it) }
            }
            .doOnError { Throwable("Not found!") }
    }

    override fun getItem(id: Int): Single<Item> {
        return Single.error(Throwable(""))
    }
}