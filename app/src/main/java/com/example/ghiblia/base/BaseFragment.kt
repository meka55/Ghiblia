package com.example.ghiblia.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.*
import androidx.viewbinding.ViewBinding
import com.example.ghiblia.common.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(@LayoutRes layoutId: Int) :
    Fragment(layoutId) {

    protected abstract val binding: VB
    protected abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initialization()
        setupListeners()
        setupViews()
        setUpObservers()
        swiperefresh()
    }

    open fun initialization() {}

    open fun setupListeners() {}

    open fun setupViews() {}

    open fun setUpObservers() {}

    open fun swiperefresh() {}

    protected open fun <T> Flow<Resource<T>>.subscribe(
        onError: (error: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Error -> {
                        onError(it.massage.toString())
                    }
                    is Resource.Loading -> {}

                    is Resource.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}