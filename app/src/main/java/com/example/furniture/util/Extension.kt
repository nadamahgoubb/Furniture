package com.example.furniture.util
import android.content.Context
import android.view.View
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example. furniture.R


object Extension {

    fun Fragment.withFragment(dataBinding: ViewDataBinding) {
        dataBinding.lifecycleOwner = this.viewLifecycleOwner
    }

    fun ImageView.loadImage(url: String, context: Context) {
        Glide.with(context)
            .load(url)
            .apply(RequestOptions().placeholder(R.drawable.progress))
            .into(this)
    }

    fun RecyclerView.init(
        context: Context?,
        adapter: RecyclerView.Adapter<*>?,
    ) {
        val layoutManager = LinearLayoutManager(context)
        this.layoutManager = layoutManager
        this.setHasFixedSize(true)
        this.adapter = adapter
    }


    fun hideProgressBar(progressBar: ProgressBar) {

        progressBar.visibility = View.INVISIBLE
    }

    fun showProgressBar(progressBar: ProgressBar) {
        progressBar.visibility = View.VISIBLE
    }

    fun capitalize(str: String): String {
        return str.trim().split("\\s+".toRegex())
            .map { it.capitalize() }.joinToString(" ")
    }
}