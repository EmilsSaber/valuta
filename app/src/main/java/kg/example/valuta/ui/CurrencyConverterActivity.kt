package kg.example.valuta.ui

import android.annotation.SuppressLint
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultCallback
import androidx.activity.result.contract.ActivityResultContracts
import androidx.lifecycle.ViewModelProvider
import kg.example.valuta.R
import kg.example.valuta.core.ui.BaseActivity
import kg.example.valuta.data.prefs.StoragePreferences
import kg.example.valuta.databinding.ActivityCurrencyConverterBinding


class CurrencyConverterActivity : BaseActivity<ActivityCurrencyConverterBinding, ConverterViewModel>() {

    val prefs: StoragePreferences by lazy {
        StoragePreferences(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding.Val1.text = prefs.currents
    }

    override val viewModel: ConverterViewModel by lazy {
        ViewModelProvider(this)[ConverterViewModel::class.java]
    }

    var launchForResult = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> { result ->
            if (result.resultCode === RESULT_OK) {


                val value =result.data?.getStringExtra("result_value")
                val char =result.data?.getStringExtra("result_char")

                binding.editText.setText(value)
                binding.Val1.text = char.toString()
                /*prefs.currents = char.toString()*/

            }
        })

    var launchForResult2 = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult(),
        ActivityResultCallback<ActivityResult> { result ->
            if (result.resultCode === RESULT_OK) {

                val _value =result.data?.getStringExtra("result_value_2")
                val _char =result.data?.getStringExtra("result_char_2")
                binding.editText2.setText(_value)
                binding.Val2.text = _char.toString()
               /* prefs.current2 = _char.toString()*/

            }
        })

    override fun initView() {
        bundle1()
        bundle2()
    }

    override fun onResume() {
        super.onResume()
        binding.Val1.text = prefs.currents
        binding.Val2.text = prefs.current2
    }

// клик на изменение валют
    fun bundle1(){
        binding.change1.setOnClickListener {
            val intent = Intent(this,CurrencySelectionActivity::class.java)
            intent.putExtra("key","1")
            launchForResult.launch(intent)
            //перехожу на выбор валют во 2й активити
        }
    }

    //клик на 2е изменение валют
    fun bundle2(){
        binding.change2.setOnClickListener {
            val intent = Intent(this,CurrencySelectionActivity::class.java)
            intent.putExtra("key","2")
            launchForResult2.launch(intent)
        }
    }

    override fun inflateVB(layoutInflater: LayoutInflater): ActivityCurrencyConverterBinding {
        return ActivityCurrencyConverterBinding.inflate(layoutInflater)
    }

}