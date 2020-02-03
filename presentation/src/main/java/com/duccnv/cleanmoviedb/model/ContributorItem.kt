package com.duccnv.cleanmoviedb.model

import com.duccnv.cleanmoviedb.base.ItemMapper
import com.duccnv.cleanmoviedb.base.ModelItem
import com.duccnv.cleanmoviedb.domain.model.Contributor
import javax.inject.Inject

data class ContributorItem(
    val login: String,
    val contributions: Int,
    val avatarUrl: String?
) : ModelItem()

class ContributorItemMapper @Inject constructor() : ItemMapper<Contributor, ContributorItem> {

    override fun mapToDomain(modelItem: ContributorItem) = Contributor(
        modelItem.login, modelItem.contributions, modelItem.avatarUrl
    )

    override fun mapToPresentation(model: Contributor) = ContributorItem(
        model.login, model.contributions, model.avatarUrl
    )
}
