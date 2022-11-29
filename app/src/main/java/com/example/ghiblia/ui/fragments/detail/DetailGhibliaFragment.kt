package com.example.ghiblia.ui.fragments.detail

import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.ghiblia.R
import com.example.ghiblia.base.BaseFragment
import com.example.ghiblia.databinding.FragmentDetailGhibliaBinding
import com.example.ghiblia.databinding.FragmentGhibliaBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.subscribe

@AndroidEntryPoint
class DetailGhibliaFragment :
    BaseFragment<FragmentDetailGhibliaBinding, DetailGhibliaViewModel>(R.layout.fragment_detail_ghiblia) {

    override val binding by viewBinding(FragmentDetailGhibliaBinding::bind)
    override val viewModel: DetailGhibliaViewModel by viewModels()
    private val args by navArgs<DetailGhibliaFragmentArgs>()

    override fun setUpObservers() = with(binding) {
        viewModel.fetchDetailGhiblia(args.id).subscribe(
            onError = {},
            onSuccess = {
                txtIdTitleDetail.text = it.title
                txtIdProducerDetail.text = it.producer
                txtIdDescriptionDetail.text = it.description
                txtIdDetail.text = it.id.toString()
                Glide.with(imageGhibliaDetail).load(it.image).into(imageGhibliaDetail)
            }
        )
    }
}