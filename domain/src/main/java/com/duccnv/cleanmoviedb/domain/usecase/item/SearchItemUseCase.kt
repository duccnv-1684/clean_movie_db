package com.duccnv.cleanmoviedb.domain.usecase.item

import com.duccnv.cleanmoviedb.domain.model.Item
import com.duccnv.cleanmoviedb.domain.repository.ItemRepository
import com.duccnv.cleanmoviedb.domain.usecase.UseCase
import io.reactivex.Single
import javax.inject.Inject

open class SearchItemUseCase @Inject constructor(
    private val itemRepository: ItemRepository
) : UseCase<SearchItemUseCase.Params, Single<List<Item>>>() {
    override fun createObservable(params: Params?): Single<List<Item>> {
        params?.let { return itemRepository.searchItems(query = params.query, page = params.pageNumber) }

        return Single.error(Throwable(""))
    }

    override fun onCleared() {
    }

    data class Params(val query: String, val pageNumber: Int? = 1)
}