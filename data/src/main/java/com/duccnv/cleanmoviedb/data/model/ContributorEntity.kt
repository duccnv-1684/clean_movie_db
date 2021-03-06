package com.duccnv.cleanmoviedb.data.model

import com.duccnv.cleanmoviedb.data.base.EntityMapper
import com.duccnv.cleanmoviedb.data.base.ModelEntity
import com.duccnv.cleanmoviedb.domain.model.Contributor
import com.google.gson.annotations.SerializedName
import javax.inject.Inject

data class ContributorEntity(
    @SerializedName("login") val login: String,
    @SerializedName("contributions") val contributions: Int,
    @SerializedName("avatar_url") val avatarUrl: String?
) : ModelEntity()

class ContributorEntityMapper @Inject constructor() : EntityMapper<Contributor, ContributorEntity> {

    override fun mapToDomain(entity: ContributorEntity) = Contributor(
        entity.login, entity.contributions, entity.avatarUrl
    )

    override fun mapToEntity(model: Contributor) = ContributorEntity(
        model.login, model.contributions, model.avatarUrl
    )
}
