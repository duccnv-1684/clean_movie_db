package com.duccnv.cleanmoviedb.domain.exception

import com.duccnv.cleanmoviedb.domain.annotation.ExceptionType
import com.duccnv.cleanmoviedb.domain.model.Tag

class InlineException(
    override val code: Int,
    vararg val tags: Tag
) : CleanException(code, ExceptionType.INLINE, null)