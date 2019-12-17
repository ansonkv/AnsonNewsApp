package com.anson.newsapp.ui.newslist

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.anson.domain.entity.NewsItem

import com.anson.newsapp.R
import com.anson.newsapp.common.MyApplication
import com.anson.newsapp.databinding.NewsListFragmentBinding
import kotlinx.android.synthetic.main.news_list_fragment.*
import javax.inject.Inject

class NewsListFragment : Fragment() {

    companion object {
        fun newInstance() = NewsListFragment()
    }

    private lateinit var viewModel: NewsListViewModel
    private lateinit var binding: NewsListFragmentBinding

    @Inject
    lateinit var factory: NewsListVMFactory

    @Inject
    lateinit var adapter: NewsListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        ((activity?.application as MyApplication).newsComponent().inject(this))
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = NewsListFragmentBinding.inflate(layoutInflater, container, false)
        binding.toolbar?.let {
            (activity as AppCompatActivity)?.setSupportActionBar(it)
        }
        binding.lifecycleOwner = this
        binding.listItem.layoutManager = LinearLayoutManager(context)
        adapter.setListener(object : NewsListAdapter.NewsClickListener {
            override fun onClick(newsItem: NewsItem) {
                //navigate todetails screen
                val action =
                    NewsListFragmentDirections.actionNewsListFragmentToNewsDetailsFragment(newsItem)
                findNavController().navigate(action)
            }
        })
        binding.listItem.adapter = adapter
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(NewsListViewModel::class.java)
        viewModel.loadNews()
        viewModel.news.observe(this, Observer {
            adapter.setNews(it)
            progress_bar.visibility = View.GONE
        })
    }

}
