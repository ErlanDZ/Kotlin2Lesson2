package com.example.kotlin2lesson2.ui.fragments.main


import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.common.base.BaseFragment
import com.example.kotlin2lesson2.databinding.FragmentMainBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment :
    BaseFragment<MainViewModel, FragmentMainBinding>(R.layout.fragment_main) {

    override val binding by viewBinding(FragmentMainBinding :: bind)
    override val viewModel: MainViewModel by viewModel()

}