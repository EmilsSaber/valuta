package kg.example.valuta.ui
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kg.example.valuta.data.remote.model.Currency
import kg.example.valuta.databinding.ItemSelectionBinding

class SelectionAdapter(val listener: Listener): RecyclerView.Adapter<SelectionAdapter.ViewHolder>() {
    private val currencyList = arrayListOf<Currency>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSelectionBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(currencyList[position])
    }

    override fun getItemCount(): Int {
        return currencyList.size
    }

    fun addCurrency(currency: Currency?) {
        currency?.let { currencyList.add(it) }
        notifyItemInserted(currencyList.lastIndex)
    }

    interface Listener{
        fun onClick(currency: Currency?){
        }
        fun onClick2(currency: Currency?){

        }
    }

    inner class ViewHolder(private var binding: ItemSelectionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(currency: Currency, ) {
            binding.nameOfCurrency1.text = currency.name
            binding.nameOfCurrency2.text = currency.char

            itemView.setOnClickListener{
                listener.onClick(currency)
            }
        }
    }}