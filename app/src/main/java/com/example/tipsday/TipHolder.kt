package com.example.tipsday

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.tipsday.databinding.ItemLayoutBinding

class TipHolder(item: View): RecyclerView.ViewHolder(item) {
    val binding = ItemLayoutBinding.bind(item)
    fun bind(tip: DataTip) = with(binding){
        numberTip.setText(tip.numberTipId)
        titleTip.setText(tip.titleId)
        imageTip.setImageResource(tip.imageId)
        descriptionTip.setText(tip.descriptionId)


    }

}