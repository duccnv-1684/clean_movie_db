package com.duccnv.cleanmoviedb.data

import com.duccnv.cleanmoviedb.data.model.ItemEntity
import com.duccnv.cleanmoviedb.data.model.OwnerEntity
import com.duccnv.cleanmoviedb.domain.model.Item
import com.duccnv.cleanmoviedb.domain.model.Owner

fun createItemEntity() = ItemEntity(
        id = 1,
        name = "Bach",
        fullName = "Bach Hoan",
        description = "framgia",
        url = "",
        stars = 1,
        ownerEntity = OwnerEntity(id = 1, login = null, avatar = null)
)

fun createItem() = Item(
        id = 2,
        name = "Hoan",
        fullName = "Bach Hoan",
        description = "ha nam",
        url = "",
        stars = 1,
        owner = Owner(id = 1, login = null, avatar = null)
)