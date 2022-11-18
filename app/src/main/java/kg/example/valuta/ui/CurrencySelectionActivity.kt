package kg.example.valuta.ui

import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.valuta.core.ui.BaseActivity
import kg.example.valuta.databinding.ActivityCurrencySelectionBinding

class CurrencySelectionActivity : BaseActivity<ActivityCurrencySelectionBinding, SelectionViewModel>() {
    override val viewModel: SelectionViewModel by lazy {
        ViewModelProvider(this)[SelectionViewModel::class.java]
    }

    override fun initViewModel() {
                viewModel.getCurrensys().observe(this){
            Log.e("jojojo", "initViewModel: ", )
            Toast.makeText(this, "jojojojojojojojo", Toast.LENGTH_SHORT).show()
        }

    }
    override fun inflateVB(layoutInflater: LayoutInflater): ActivityCurrencySelectionBinding {
        return ActivityCurrencySelectionBinding.inflate(layoutInflater)
    }
}