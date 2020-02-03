package com.duccnv.cleanmoviedb.data.base

import com.duccnv.cleanmoviedb.domain.model.Model

interface EntityMapper<M : Model, ME : ModelEntity> {
    fun mapToDomain(entity: ME): M

    fun mapToEntity(model: M): ME
}