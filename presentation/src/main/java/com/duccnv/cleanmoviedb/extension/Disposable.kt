package com.duccnv.cleanmoviedb.extension

import com.duccnv.cleanmoviedb.base.BaseViewModel
import io.reactivex.disposables.Disposable

fun Disposable.add(viewModel: BaseViewModel) {
    viewModel.addDisposable(this)
}