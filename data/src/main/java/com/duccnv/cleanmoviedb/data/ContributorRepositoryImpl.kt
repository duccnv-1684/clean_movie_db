package com.duccnv.cleanmoviedb.data

import com.duccnv.cleanmoviedb.data.model.ContributorEntityMapper
import com.duccnv.cleanmoviedb.data.remote.api.ContributorApi
import com.duccnv.cleanmoviedb.domain.model.Contributor
import com.duccnv.cleanmoviedb.domain.repository.ContributorRepository
import io.reactivex.Observable
import javax.inject.Inject

class ContributorRepositoryImpl @Inject constructor(
    private val contributorApi: ContributorApi,
    private val contributorEntityMapper: ContributorEntityMapper
) : ContributorRepository {

    override fun getContribution(name: String, owner: String): Observable<List<Contributor>> {
        return contributorApi.getContributors(owner, name)
            .map { it.map { contributorEntityMapper.mapToDomain(it) } }
    }
}