package com.haydar.crudbasic.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import androidx.room.PrimaryKey
import androidx.viewpager.widget.PagerTitleStrip
import com.haydar.crudbasic.R
import com.haydar.crudbasic.databinding.ItemListBinding
import com.haydar.crudbasic.db.Subscriber
import com.haydar.crudbasic.generated.callback.OnClickListener

class MyRecyclerViewAdapter(
    private val subscriberList: List<Subscriber>,
    private val clickListener: (Subscriber) -> Unit
) :
    RecyclerView.Adapter<MyViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: ItemListBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.item_list, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(subscriberList[position],clickListener)
    }

    override fun getItemCount() = subscriberList.size

}

class MyViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root) {
    fun bind(subscriber: Subscriber, clickListener: (Subscriber) -> Unit ) {
        binding.nameTextView.text = subscriber.name
        binding.emailTextView.text = subscriber.email
        binding.listItemLayout.setOnClickListener {
            clickListener(subscriber)
        }

    }
}