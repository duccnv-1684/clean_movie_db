package com.duccnv.cleanmoviedb.domain.exception

import com.duccnv.cleanmoviedb.domain.annotation.ExceptionType

class ToastException(
    override val code: Int,
    override val message: String
) : CleanException(code, ExceptionType.TOAST, message)