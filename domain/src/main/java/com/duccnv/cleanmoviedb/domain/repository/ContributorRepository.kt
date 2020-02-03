package com.duccnv.cleanmoviedb.domain.repository

import com.duccnv.cleanmoviedb.domain.model.Contributor
import io.reactivex.Observable

interface ContributorRepository {
    // get contributor from a repository on github
    fun getContribution(name: String, owner: String): Observable<List<Contributor>>
}