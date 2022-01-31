package com.example.kotlin2lesson2.presentation.ui.fragments.detailed

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import coil.load
import com.example.kotlin2lesson2.R
import com.example.kotlin2lesson2.databinding.FragmentDetailedBinding
import com.example.kotlin2lesson2.presentation.base.BaseFragment
import com.example.kotlin2lesson2.presentation.ui.fragments.main.topnews.MainViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailedFragment : BaseFragment<FragmentDetailedBinding, MainViewModel>
    (R.layout.fragment_detailed) {

    override val binding by viewBinding(FragmentDetailedBinding::bind)
    override val viewModel: MainViewModel by viewModels()
    private val args: DetailedFragmentArgs by navArgs()

    override fun initialize(): Unit = with(binding) {
        newsTitle.text = args.item.title
        newsDate.text = args.item.publishedAt
        authorImg.setImageResource(R.drawable.news_image)
        if (args.item.author == null) {
            val users = "No name"
            authorName.text = users
        } else {
            authorName.text = args.item.author
        }
        if (args.item.urlToImage == "") {
            mewsImg.setImageResource(R.drawable.news_image)
        } else {
            mewsImg.load(args.item.urlToImage)
        }
        newsDescription.text = args.item.description

        backFab.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}