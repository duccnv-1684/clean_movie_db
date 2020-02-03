package com.duccnv.cleanmoviedb.base

import com.duccnv.cleanmoviedb.domain.model.Model

interface ItemMapper<M : Model, MI : ModelItem> {
    fun mapToPresentation(model: M): ModelItem

    fun mapToDomain(modelItem: MI): Model
}