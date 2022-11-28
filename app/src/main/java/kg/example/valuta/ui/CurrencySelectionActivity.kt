package kg.example.valuta.ui

import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import kg.example.valuta.core.ui.BaseActivity
import kg.example.valuta.data.remote.model.Currency
import kg.example.valuta.databinding.ActivityCurrencySelectionBinding


class CurrencySelectionActivity: BaseActivity<ActivityCurrencySelectionBinding, SelectionViewModel>(), SelectionAdapter.Listener {
    override val viewModel: SelectionViewModel by lazy {
        ViewModelProvider(this)[SelectionViewModel::class.java]
    }
    private val adapter = SelectionAdapter(this)

    override fun initView() {
        binding.recyclerSelection.adapter = adapter
        onBackPressed()
    }

    override fun onBackPressed() {
        binding.onBack.setOnClickListener{
            startActivity(Intent(this, CurrencyConverterActivity::class.java))
        }
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

    override fun onClick(currency: Currency?){
            /*Toast.makeText(this, "Нажали на: ${currency?.char}", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, CurrencyConverterActivity::class.java)
            intent.putExtra("username", currency?.char.toString())
            intent.putExtra("username2", currency?.value.toString())
            startActivity(intent)*/
        val value = intent.getStringExtra("key").toString()
        switch(value,currency)

    }

    fun switch(value:String,currency: Currency?){
        val intent = Intent()
        if (value == "1"){
            intent.putExtra("result_char",currency?.char.toString())
            intent.putExtra("result_value",currency?.value.toString())
            setResult(RESULT_OK,intent)
            finish()
        } else if(value == "2") {
            intent.putExtra("result_char_2",currency?.char.toString())
            intent.putExtra("result_value_2",currency?.value.toString())
            setResult(RESULT_OK,intent)
            finish()
        }
    }

    override fun onClick2(currency: Currency?) {
        val intent = Intent()
        intent.putExtra("result_char_2",currency?.char.toString())
        intent.putExtra("result_value_2",currency?.value.toString())
        setResult(RESULT_OK,intent)
        finish()

    }


    override fun inflateVB(layoutInflater: LayoutInflater): ActivityCurrencySelectionBinding {
        return ActivityCurrencySelectionBinding.inflate(layoutInflater)
    }
}