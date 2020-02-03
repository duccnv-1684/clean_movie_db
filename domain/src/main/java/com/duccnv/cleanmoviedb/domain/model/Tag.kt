package com.duccnv.cleanmoviedb.domain.model

import com.duccnv.cleanmoviedb.domain.annotation.TagName

data class Tag(@TagName val name: String, val message: String?)