package com.example.ghiblia.ui.fragments

import android.util.Log
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.ghiblia.R
import com.example.ghiblia.base.BaseFragment
import com.example.ghiblia.databinding.FragmentGhibliaBinding
import com.example.ghiblia.ui.adapters.GhibliaAdapter
import com.example.ghiblia.ui.adapters.OnClick
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.subscribe


@AndroidEntryPoint
class GhibliaFragment :
    BaseFragment<FragmentGhibliaBinding, GhibliaViewModel>(R.layout.fragment_ghiblia), OnClick {

    override val binding by viewBinding(FragmentGhibliaBinding::bind)
    override val viewModel: GhibliaViewModel by viewModels()
    private val ghibliaAdapter = GhibliaAdapter(this)

    override fun initialization() {
        binding.recyclerGhiblia.adapter = ghibliaAdapter
        binding.recyclerGhiblia.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
    }

    override fun setUpObservers() {
        viewModel.fetchGhiblia() .subscribe(onError = {
            Toast.makeText(requireContext(), it, Toast.LENGTH_SHORT).show()
        }, onSuccess = {
                ghibliaAdapter.submitList(it.body())
            Toast.makeText(requireContext(), "GH", Toast.LENGTH_SHORT).show()
        })
    }

    override fun listener(id: String?) {
        id?.let {
            findNavController().navigate(
                GhibliaFragmentDirections.actionGhibliaFragmentToDetailGhibliaFragment(it.toString())
            )
        }
    }


}
