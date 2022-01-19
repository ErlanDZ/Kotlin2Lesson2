package com.example.kotlin2lesson2.presentation.ui.fragments.detailed

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentDetailedBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedFragment : BaseFragment<FragmentDetailedBinding, DetailedViewModel>
    (R.layout.fragment_detailed) {

    override val binding by viewBinding(FragmentDetailedBinding::bind)
    override val viewModel: DetailedViewModel by viewModels()


}