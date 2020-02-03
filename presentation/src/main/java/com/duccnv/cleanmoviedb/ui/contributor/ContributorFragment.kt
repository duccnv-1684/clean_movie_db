package com.duccnv.cleanmoviedb.ui.contributor

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.duccnv.cleanmoviedb.BR
import com.duccnv.cleanmoviedb.R
import androidx.lifecycle.observe
import com.duccnv.cleanmoviedb.base.BaseFragment
import com.duccnv.cleanmoviedb.binding.FragmentDataBindingComponent
import com.duccnv.cleanmoviedb.databinding.FragmentContributorBinding
import com.duccnv.cleanmoviedb.util.autoCleared

class ContributorFragment : BaseFragment<FragmentContributorBinding, ContributorViewModel>() {

    override val bindingVariable: Int
        get() = BR.viewModel

    override val viewModel: ContributorViewModel by viewModels { viewModelFactory }

    override val layoutId: Int = R.layout.fragment_contributor

    private val args by navArgs<ContributorFragmentArgs>()

    private var contributorAdapter by autoCleared<ContributorAdapter>()
    private var bindingComponent = FragmentDataBindingComponent(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.repoItem.value = args.repo
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = ContributorAdapter(bindingComponent) { contribute ->
        }
        this.contributorAdapter = adapter

        with(viewDataBinding) {
            listContributor.adapter = contributorAdapter
        }
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        subscribeUI()
    }

    private fun subscribeUI() = with(viewModel) {
        getContributions().observe(viewLifecycleOwner) { contributions ->
            contributorAdapter.submitList(contributions)
        }
    }
}