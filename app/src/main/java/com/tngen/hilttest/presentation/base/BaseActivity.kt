package com.tngen.hilttest.presentation.base

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.viewbinding.ViewBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Job

abstract class BaseActivity<VM: BaseViewModel, VB: ViewDataBinding>(
    @LayoutRes private val layoutId: Int
): AppCompatActivity() {

    abstract val viewModel: VM

    protected lateinit var binding: VB

    private lateinit var fetchJob: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, layoutId)
        binding.lifecycleOwner = this
        initData()
        initState()
    }

    abstract fun initData()

    open fun initState() {
        initViews()
        fetchJob = viewModel.fetchData()
//        observeData()
    }

    open fun initViews() = Unit

//    abstract fun observeData()

    override fun onDestroy() {
        if (fetchJob.isActive) {
            fetchJob.cancel()
        }
        super.onDestroy()
    }

}
