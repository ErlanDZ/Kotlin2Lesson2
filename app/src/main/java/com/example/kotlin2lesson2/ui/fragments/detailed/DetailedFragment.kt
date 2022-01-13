package com.example.kotlin2lesson2.ui.fragments.detailed

import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.common.base.BaseFragment
import com.example.kotlin2lesson2.databinding.FragmentDetailedBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailedFragment : BaseFragment<DetailedViewModel, FragmentDetailedBinding>(R.layout.fragment_detailed) {

    override val binding by viewBinding(FragmentDetailedBinding:: bind)
    override val viewModel: DetailedViewModel by viewModel()

}