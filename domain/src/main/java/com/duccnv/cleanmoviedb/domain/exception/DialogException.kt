package com.duccnv.cleanmoviedb.domain.exception

import com.duccnv.cleanmoviedb.domain.annotation.ExceptionType
import com.duccnv.cleanmoviedb.domain.model.Dialog

class DialogException(
    override val code: Int,
    val dialog: Dialog
) : CleanException(code, ExceptionType.DIALOG, null)