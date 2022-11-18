package kg.example.less2.Base

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding

abstract class BaseActivity<VB: ViewBinding, VM: ViewModel> : AppCompatActivity() {
    protected lateinit var binding: VB
    protected abstract val viewModel: VM
    protected abstract fun inflateVB(layoutInflater: LayoutInflater):VB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = inflateVB(layoutInflater)
            setContentView(binding.root)
        initView()
        initViewModel()
        initListener()
}

    open fun initView(){}
    open fun initViewModel(){}
    open fun initListener(){}




}