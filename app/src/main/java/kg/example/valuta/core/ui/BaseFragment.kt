package kg.example.valuta.core.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.viewbinding.ViewBinding


abstract class BaseFragment<VB : ViewBinding, VM: ViewModel>: Fragment() {
    protected lateinit var binding: VB
//    protected lateinit var viewModel: VM
     abstract fun inflateVB(layoutInflater: LayoutInflater): VB


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflateVB(layoutInflater)
        return binding.root
//        initView()
//        initViewModel()
//        initListener()
    }

//    abstract fun initListener()
//    abstract fun initViewModel()
//
//    abstract fun initView()
}