package com.duccnv.cleanmoviedb.domain.exception

import com.duccnv.cleanmoviedb.domain.annotation.ExceptionType

class SnackBarException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.SNACK, message)