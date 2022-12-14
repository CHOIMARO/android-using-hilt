package com.tngen.hilttest.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

abstract class BaseFragment<VM: BaseViewModel, VB: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
) : Fragment() {

    abstract val viewModel: VM

    protected lateinit var binding: VB

    private lateinit var fetchJob: Job

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, layoutId, container, false)
        binding.lifecycleOwner = viewLifecycleOwner
        initData()
        return binding.root
    }

    abstract fun initData()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initState()
    }

    open fun initState() {
        arguments?.let {
            viewModel.storeState(it)
        }
        initViews()
        fetchJob = viewModel.fetchData()
//        observeData()
    }

    open fun initViews() = Unit

//    abstract fun observeData()

    override fun onDestroyView() {
        super.onDestroyView()
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
    }

}
