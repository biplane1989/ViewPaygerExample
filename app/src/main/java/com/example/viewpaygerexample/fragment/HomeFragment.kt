package com.example.viewpaygerexample.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import com.example.viewpaygerexample.R
import com.example.viewpaygerexample.`object`.Apple
import com.example.viewpaygerexample.adapter.AppleAdapter
import com.example.viewpaygerexample.databinding.FragmentHomeBinding
import com.example.viewpaygerexample.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()
    private val adapter : AppleAdapter by lazy {
        AppleAdapter(this::onLongClick)
    }
    private val appleObserver = Observer<List<Apple>>{
            adapter.submitList(it)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner

        homeViewModel.homeliveData.observe(viewLifecycleOwner, appleObserver)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.vp2.adapter = adapter

    }

    private fun onLongClick(item: Apple){
        homeViewModel.delete(item)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment().apply {
            arguments = Bundle().apply {}
        }
    }
}