package kg.example.valuta.ui
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.valuta.core.ui.BaseActivity

import kg.example.valuta.databinding.ActivityCurrencySelectionBinding

class CurrencySelectionActivity :
    BaseActivity<ActivityCurrencySelectionBinding, SelectionViewModel>() {
    override val viewModel: SelectionViewModel by lazy {
        ViewModelProvider(this)[SelectionViewModel::class.java]
    }
    private val adapter = SelectionAdapter()

    override fun initView() {
        binding.recyclerSelection.adapter = adapter
    }

    override fun initViewModel() {
        viewModel.getCurrensys().observe(this) {
            Log.e("jojojo", "initViewModel: ")
            Toast.makeText(this, "jojojojojojojojo", Toast.LENGTH_SHORT).show()
            adapter.addCurrency(it.data?.valute?.eUR)
            adapter.addCurrency(it.data?.valute?.aUD)
            adapter.addCurrency(it.data?.valute?.bRL)
        }
    }


    override fun inflateVB(layoutInflater: LayoutInflater): ActivityCurrencySelectionBinding {
        return ActivityCurrencySelectionBinding.inflate(layoutInflater)
    }
}