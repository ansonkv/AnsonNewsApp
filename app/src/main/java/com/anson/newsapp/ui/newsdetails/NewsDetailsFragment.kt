package com.anson.newsapp.ui.newsdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.anson.domain.entity.NewsItem
import com.anson.newsapp.R
import com.anson.newsapp.databinding.NewsDetailsFragmentBinding

class NewsDetailsFragment : Fragment() {

    companion object {
        fun newInstance() = NewsDetailsFragment()
    }

    private lateinit var viewModel: NewsDetailsViewModel


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = NewsDetailsFragmentBinding.inflate(layoutInflater, container, false)
        binding.lifecycleOwner = this
        binding.toolbar?.let{
            (activity as AppCompatActivity)?.setSupportActionBar(it)
        }
        arguments?.let {
            binding.newsItem = NewsDetailsFragmentArgs.fromBundle(it).newsItem
        }
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(NewsDetailsViewModel::class.java)
    }

}
