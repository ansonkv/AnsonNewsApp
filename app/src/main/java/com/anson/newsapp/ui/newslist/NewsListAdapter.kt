package com.anson.newsapp.ui.newslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.anson.domain.entity.NewsItem
import com.anson.newsapp.databinding.ViewNewsListSingleItemBinding

class NewsListAdapter : RecyclerView.Adapter<NewsListAdapter.ViewHolder>() {
    private var news: List<NewsItem> = ArrayList()
    private lateinit var listener: NewsClickListener

    fun setNews(news: List<NewsItem>) {
        this.news = news
        notifyDataSetChanged()
    }

    fun setListener(listener: NewsClickListener) {
        this.listener = listener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater: LayoutInflater = LayoutInflater.from(parent.context)
        return ViewHolder(ViewNewsListSingleItemBinding.inflate(inflater, parent, false))
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news.get(position))
    }

    inner class ViewHolder(val binding: ViewNewsListSingleItemBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(newsItem: NewsItem) {
            binding.root.setOnClickListener {
                listener.onClick(newsItem)
            }
            binding.newsItem = newsItem
            binding.executePendingBindings()
        }
    }

    interface NewsClickListener {
        fun onClick(newsItem: NewsItem)
    }
}