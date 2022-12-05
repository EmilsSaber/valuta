package kg.example.valuta.ui
import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.view.LayoutInflater
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import androidx.lifecycle.ViewModelProvider
import kg.example.valuta.core.ui.BaseActivity
import kg.example.valuta.databinding.ActivityCurrencyConverterBinding
import kg.example.valuta.result.Status
import kg.example.valuta.utils.CheckConnectionInternet

class CurrencyConverterActivity : BaseActivity<ActivityCurrencyConverterBinding, ConverterViewModel>() {
    override val viewModel: ConverterViewModel by lazy {
        ViewModelProvider(this)[ConverterViewModel::class.java]
    }

    private var lunchForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val value = result.data?.getStringExtra("result_value")
            val char = result.data?.getStringExtra("result_char")

            binding.editText.setText(value)
            binding.Val1.text = char.toString()
        }
    }

    private var lunchForResult2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == RESULT_OK) {
            val value = result.data?.getStringExtra("result_value_2")
            val char = result.data?.getStringExtra("result_char_2")
            binding.editText2.setText(value)
            binding.Val2.text = char.toString()
        }
    }

    override fun initView() {
        bundle1()
        bundle2()
    }

// клик на изменение валют
private fun bundle1(){
        binding.change1.setOnClickListener {
            val intent = Intent(this,CurrencySelectionActivity::class.java)
            intent.putExtra("key","1")
            lunchForResult .launch(intent)
            //перехожу на выбор валют во 2й активити
        }
    }

    //клик на 2е изменение валют
    private fun bundle2(){
        binding.change2.setOnClickListener {
            val intent = Intent(this,CurrencySelectionActivity::class.java)
            intent.putExtra("key","2")
            lunchForResult2.launch(intent)
        }
    }

    override fun inflateVB(layoutInflater: LayoutInflater): ActivityCurrencyConverterBinding {
        return ActivityCurrencyConverterBinding.inflate(layoutInflater)
    }

}