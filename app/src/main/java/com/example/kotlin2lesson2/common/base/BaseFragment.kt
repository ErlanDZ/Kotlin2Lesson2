package com.example.kotlin2lesson2.common.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.viewbinding.ViewBinding

abstract class BaseFragment<viewModel: BaseViewModel, viewBinding: ViewBinding>(
    @LayoutRes layoutId: Int) : Fragment(layoutId){

    protected abstract val binding: viewBinding
    protected abstract val viewModel: viewModel

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}