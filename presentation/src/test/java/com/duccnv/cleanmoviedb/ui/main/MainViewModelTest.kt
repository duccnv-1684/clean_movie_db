package com.duccnv.cleanmoviedb.ui.main

import androidx.lifecycle.Observer
import com.duccnv.cleanmoviedb.createItem
import com.duccnv.cleanmoviedb.domain.model.Item
import com.duccnv.cleanmoviedb.domain.usecase.item.SearchItemUseCase
import com.duccnv.cleanmoviedb.mock
import com.duccnv.cleanmoviedb.model.OwnerItemMapper
import com.duccnv.cleanmoviedb.model.RepoItem
import com.duccnv.cleanmoviedb.model.RepoItemMapper
import com.duccnv.cleanmoviedb.ui.BaseViewModelTest
import io.reactivex.Single
import org.hamcrest.Matchers.nullValue
import org.junit.Assert.assertEquals
import org.junit.Assert.assertThat
import org.junit.Test
import org.mockito.BDDMockito.given
import org.mockito.Mock

/**
 * Unit Test for [MainViewModel]
 */
class MainViewModelTest : BaseViewModelTest() {

    @Mock
    private lateinit var searchItemUseCase: SearchItemUseCase

    private lateinit var mainViewModel: MainViewModel
    private val ownerItemMapper = OwnerItemMapper()
    private val repoItemMapper = RepoItemMapper(ownerItemMapper)

    override fun setup() {
        super.setup()
        mainViewModel = MainViewModel(searchItemUseCase, repoItemMapper)
    }

    @Test
    fun searchNull() {
        mainViewModel.query.value = null
        mainViewModel.searchRepo()

        assertThat(mainViewModel.data.value, nullValue())
        assertEquals(mainViewModel.loading.value, false)
    }

    @Test
    fun testSearchUserId() {
        val query = "Bach"
        mainViewModel.query.value = query

        val item = createItem()
        val listItem: List<Item> = arrayListOf(item)
        given(searchItemUseCase.createObservable(SearchItemUseCase.Params(query = query))).willReturn(
            Single.just(
                listItem
            )
        )

        val observer = mock<Observer<List<RepoItem>>>()
        mainViewModel.data.observeForever(observer)

        mainViewModel.searchRepo()
        assertEquals(mainViewModel.data.value, listItem.map { repoItemMapper.mapToPresentation(item) })
    }
}