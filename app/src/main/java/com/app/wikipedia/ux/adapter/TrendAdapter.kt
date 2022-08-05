package com.app.wikipedia.ux.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.wikipedia.databinding.ItemTrendBinding
import com.app.wikipedia.ux.data.ItemPost
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CenterInside
import com.bumptech.glide.load.resource.bitmap.RoundedCorners

class TrendAdapter( private val data: ArrayList<ItemPost> ) :
    RecyclerView.Adapter<TrendAdapter.TrendViewHolder>() {
    lateinit var binding: ItemTrendBinding

    inner class TrendViewHolder( itemView: View ) : RecyclerView.ViewHolder(itemView) {

        fun bindViews( itemPost: ItemPost ) {

            val glide = Glide
                .with( itemView.context )
                .load( itemPost.imgUrl )
                .transform(CenterInside(), RoundedCorners(16))
                .into( binding.imgTrendMain )

            binding.txtTrendTitle.text = itemPost.txtTitle
            binding.txtTrendSubtitle.text = itemPost.txtSubtitle
            binding.txtTrendInsight.text = itemPost.insight
            binding.txtTrendPageNumber.text = ( adapterPosition + 1 ).toString()

        }

    }

    override fun onCreateViewHolder( parent: ViewGroup, viewType: Int ): TrendViewHolder {
        binding = ItemTrendBinding.inflate( LayoutInflater.from( parent.context ), parent, false )

        return TrendViewHolder(binding.root)
    }

    override fun onBindViewHolder( holder: TrendViewHolder, position: Int ) {

        holder.bindViews( data[position] )

    }

    override fun getItemCount(): Int {
        return data.size
    }

}