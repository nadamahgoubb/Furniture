package com.example.furniture.ui.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.furniture.R
import com.example.furniture.data.entity.Offers
import com.example.furniture.databinding.RowOffersBinding
import com.example.furniture.ui.IItemClickListener

class OffersAdapter(
    val context: Context,
    private val onClick: IItemClickListener
) : RecyclerView.Adapter<OffersAdapter.OffersViewHolder>() {

    private var offersList: ArrayList<Offers> = ArrayList()

    fun getOffersList(): List<Offers?> {
        return offersList
    }


    @SuppressLint("NotifyDataSetChanged")
    fun setOffersList(offersList: List<Offers>) {
        this.offersList = offersList as ArrayList<Offers>
        this.notifyDataSetChanged()
    }


    inner class OffersViewHolder(
        private val binding: RowOffersBinding,
        private val mOnItemClickListener: IItemClickListener
    ) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        private var mItemClickListener: IItemClickListener? = null

        @SuppressLint("SetTextI18n", "ResourceType")
        fun bind(products: Offers) {
            binding.apply {
                binding.tvName.text = products.name
                binding.tvPrice.text = products.price.toString()
                if (products.images!!.isEmpty()) {
                    Glide.with(context).load(context.resources.getString(R.drawable.ic_arrow_left))
                        .into(binding.imgProduct)

                } else {
                    Glide.with(context).load(products.images.get(0)).into(binding.imgProduct)

                }
                /*  if (products.discount != 0) {
                      binding.tvDiscountPercent.text = products.discount.toString() + "%"
                      binding.txtCategoryProductRegularPrice.text = products.price.toString()
                      binding.tvPrice.paintFlags =
                          binding.tvPrice.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
                  } else {
                      binding.tvDiscountPercent.visibility = View.INVISIBLE
                      binding.txtCategoryProductRegularPrice.visibility = View.INVISIBLE
                  }
                  mItemClickListener = mOnItemClickListener
                  binding.imgList.setOnClickListener(this@Off)
              }*/

            }


        }

        override fun onClick(p0: View?) {
            p0?.let { mItemClickListener?.onItemClickListener(it, layoutPosition) }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OffersViewHolder {
        val li = LayoutInflater.from(context)
        return OffersViewHolder(
            RowOffersBinding.inflate(li), onClick
        )
    }

    override fun onBindViewHolder(holder: OffersViewHolder, position: Int) {
        val currentItem = offersList[position]
        holder.bind(currentItem)
    }

    override fun getItemCount(): Int {
        return offersList.size
    }

    fun setList(offers: ArrayList<Offers>) {
        this.offersList = offers
        this.notifyDataSetChanged()
    }


}
