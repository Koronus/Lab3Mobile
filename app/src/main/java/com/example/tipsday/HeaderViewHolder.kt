package com.example.tipsday

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val tvHeaderTitle: TextView = itemView.findViewById(R.id.tvHeaderTitle)
    private val tvHeaderSubtitle: TextView = itemView.findViewById(R.id.tvHeaderSubtitle)

}