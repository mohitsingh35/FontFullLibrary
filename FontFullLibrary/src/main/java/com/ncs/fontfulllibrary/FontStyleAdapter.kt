package com.ncs.fontfulllibrary

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.res.ResourcesCompat
import androidx.recyclerview.widget.RecyclerView

class FontStyleAdapter(
    private var fontStyleList: List<Int>,
    private val onItemClick: (Int) -> Unit
) : RecyclerView.Adapter<FontStyleAdapter.FontStyleViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FontStyleViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_font_style, parent, false)
        return FontStyleViewHolder(view)
    }

    override fun onBindViewHolder(holder: FontStyleViewHolder, position: Int) {
        val fontStyle = fontStyleList[position]
        holder.bind(fontStyle)
    }

    override fun getItemCount(): Int {
        return fontStyleList.size
    }

    inner class FontStyleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val textView: TextView = itemView.findViewById(R.id.fontStyleTextView)

        fun bind(fontStyle: Int) {
            val typeface = ResourcesCompat.getFont(itemView.context, fontStyle)
            textView.typeface = typeface
            itemView.setOnClickListener {
                onItemClick(fontStyle)
            }
        }
    }
    fun setItems(fontStyleList: List<Int>) {
        this.fontStyleList = fontStyleList
        notifyDataSetChanged()
    }

}
