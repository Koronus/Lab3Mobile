package com.example.tipsday

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView


class TipAdapter(private val onTipClickListener: OnTipClickListener) :
    RecyclerView.Adapter<TipHolder>() {

    private val collectionTip = CollectionTip()
    private val tips = collectionTip.tips

    interface OnTipClickListener {
        fun onTipClick(tip: DataTip, position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TipHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return TipHolder(view)

    }

    override fun onBindViewHolder(holder: TipHolder, position: Int) {

        val tip = tips[position]
        holder.bind(tip)


        holder.itemView.setOnClickListener {
            onTipClickListener.onTipClick(tip, position)
        }
    }

    override fun getItemCount(): Int {
        return tips.size
    }

}