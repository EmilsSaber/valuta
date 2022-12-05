package kg.example.valuta.ui

import androidx.lifecycle.MutableLiveData
import kg.example.valuta.core.ui.BaseViewModel
import kg.example.valuta.result.Resource
import kg.example.valuta.App
import kg.example.valuta.data.remote.model.Currencies

class SelectionViewModel: BaseViewModel() {
    fun getCurrents(): MutableLiveData<Resource<Currencies>> {
        return App().repository.getCurrency()
    }
}