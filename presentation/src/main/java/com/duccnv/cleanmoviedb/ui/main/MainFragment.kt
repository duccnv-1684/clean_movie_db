package com.duccnv.cleanmoviedb.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.lifecycle.observe
import androidx.navigation.fragment.findNavController
import com.duccnv.cleanmoviedb.BR
import com.duccnv.cleanmoviedb.R
import com.duccnv.cleanmoviedb.base.BaseFragment
import com.duccnv.cleanmoviedb.binding.FragmentDataBindingComponent
import com.duccnv.cleanmoviedb.databinding.FragmentMainBinding
import com.duccnv.cleanmoviedb.util.autoCleared

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val layoutId: Int
        get() = R.layout.fragment_main

    override val viewModel: MainViewModel by viewModels { viewModelFactory }

    private var mainAdapter by autoCleared<MainAdapter>()

    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        subscribeUI()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val adapter = MainAdapter(bindingComponent) { item ->
            findNavController().navigate(MainFragmentDirections.actionMainFragmentToContributorFragment(item))
        }
        this.mainAdapter = adapter

        with(viewDataBinding) {
            listRepo.adapter = mainAdapter
        }
    }

    private fun subscribeUI() = with(viewModel) {
        data.observe(viewLifecycleOwner) {
            mainAdapter.submitList(it)
        }

        loading.observe(viewLifecycleOwner) { loading ->
            viewDataBinding.loading.visibility = if (loading) View.VISIBLE else View.GONE
        }
    }
}
