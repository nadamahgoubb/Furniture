package com.example.furniture.ui.fragment.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.furniture.R
import com.example.furniture.databinding.FragmentHomeBinding
import com.example.furniture.ui.IItemClickListener
import com.example.furniture.ui.adapter.OffersAdapter
import com.example.furniture.util.Extension.hideProgressBar
import com.example.furniture.util.Extension.init
import com.example.furniture.util.Extension.showProgressBar
import com.example.furniture.util.Extension.withFragment
import com.example.furniture.util.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint

class HomeFragment : Fragment(), IItemClickListener {


    private var isLoading: Boolean=false

    //   private lateinit var homeVm: HomeViewModel
    private lateinit var adapter: OffersAdapter
    private lateinit var binding: FragmentHomeBinding
    private val homeVm: HomeViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home,
            container,
            false
        )

        setVm()

        return binding.root
    }

    private fun setVm() {
        with(binding) {
            withFragment(this)
            binding.lifecycleOwner = this.lifecycleOwner
            //
            activity?.let { homeVm.setActivity(it) }
        }
        homeVm.getOffers()
        adapter = activity?.let { OffersAdapter(it, this) }!!
        binding.recOffers.init(requireContext(), adapter)
        getData()
    }

    private fun getData() {
        homeVm.offersList.observe(viewLifecycleOwner, Observer { response ->
            when (response) {
                is Resource.Success -> {
                    hideProgressBar(binding.progressBar)
                    isLoading = false
                    response.data?.let { newsResponse ->
                        adapter.setList(response.data.offers)

                        adapter.notifyDataSetChanged()
                    }
                }
                is Resource.Error -> {
                    hideProgressBar(binding.progressBar)
                    isLoading = false

                    response.message?.let { message ->
                        Toast.makeText(activity, "An error occured: $message", Toast.LENGTH_LONG)
                            .show()
                    }
                }
                is Resource.Loading -> {
                    showProgressBar(binding.progressBar)
                    isLoading = true
                }
            }
        })
    }


    override fun onItemClickListener(view: View, itemId: Int) {
        TODO("Not yet implemented")
    }
}
