package com.duccnv.cleanmoviedb.domain.model

import com.duccnv.cleanmoviedb.domain.annotation.Redirect

data class Redirect(@Redirect val redirect: Int, val redirectObject: Any? = null)