package com.example.furniture.ui.fragment.home

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.furniture.R
import com.example.furniture.databinding.FragmentHomeBinding
import com.example.furniture.ui.adapter.OffersAdapter


class HomeFragment : Fragment() {


    private lateinit var homeVm: HomeViewModel
    private  lateinit var  adapter: OffersAdapter
    private lateinit var binding: FragmentHomeBinding

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

    private fun setVm()  {
        with(binding) {
            withFragment(this)
            //  binding.vm = this@HomeFragment.homeVm
            binding.lifecycleOwner = this.lifecycleOwner
            homeVm = ViewModelProvider(requireActivity()).get(HomeViewModel::class.java)
            activity?.let { homeVm.setActivity(it) }
        }
        binding.recOffers.init(requireContext(), adapter, 2)

    }

    fun RecyclerView.init(
        context: Context?,
        adapter: RecyclerView.Adapter<*>?,
        column: Int
    ) {
        val layoutManager = GridLayoutManager(context, column)
        this.layoutManager = layoutManager
        this.setHasFixedSize(true)
        this.adapter = adapter
    }
}

fun Fragment.withFragment(dataBinding: ViewDataBinding) {
    dataBinding.lifecycleOwner = this.viewLifecycleOwner
}