package kg.example.valuta.ui

import androidx.lifecycle.MutableLiveData
import kg.example.valuta.core.ui.BaseViewModel
import kg.example.valuta.data.remote.model.CurrensyModel
import kg.example.valuta.result.Resource
import kg.example.valuta.utils.App

class SelectionViewModel: BaseViewModel() {


    fun getCurrensys(): MutableLiveData<Resource<CurrensyModel>> {
        return App().repository.getCurrensys()
    }
}