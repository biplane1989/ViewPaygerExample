package com.example.viewpaygerexample

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.example.viewpaygerexample.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!
    private val homeViewModel: HomeViewModel by viewModels()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        binding.viewmodel = homeViewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val listUrl = ArrayList<Int>()
        listUrl.add(R.drawable.h1)
        listUrl.add(R.drawable.h2)
        listUrl.add(R.drawable.h3)
        listUrl.add(R.drawable.h4)
        listUrl.add(R.drawable.h5)
        listUrl.add(R.drawable.h6)
        listUrl.add(R.drawable.h1)

        val adapter = ViewPagerAdapter()
        adapter.setList(listUrl)
        binding.vp2.adapter = adapter

        binding.btnAdd.setOnClickListener {
            listUrl.add(R.drawable.h7)
            adapter.setList(listUrl)
        }


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