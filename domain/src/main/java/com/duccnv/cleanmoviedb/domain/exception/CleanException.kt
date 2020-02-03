package com.duccnv.cleanmoviedb.domain.exception

import com.duccnv.cleanmoviedb.domain.annotation.ExceptionType

open class CleanException(
    open val code: Int,
    @ExceptionType val exceptionType: Int,
    override val message: String?
) : Throwable(message)