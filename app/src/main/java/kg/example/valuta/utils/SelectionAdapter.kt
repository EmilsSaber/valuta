package kg.example.valuta.utils

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.valuta.databinding.ItemSelectionBinding

class SelectionAdapter(private var list: List<String>):
    RecyclerView.Adapter<SelectionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(ItemSelectionBinding.inflate(LayoutInflater.from(parent.context),parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(list[position])
    }

    override fun getItemCount(): Int {
        return list.size
    }


    inner class ViewHolder(private var binding: ItemSelectionBinding): RecyclerView.ViewHolder(binding.root){
        fun bind(s: String) {
            TODO("Not yet implemented")
        }
    }
}