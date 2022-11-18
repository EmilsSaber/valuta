package kg.example.valuta.utils

import android.app.Application
import kg.example.valuta.repository.Repository

class App: Application() {
    val repository: Repository by lazy {
        Repository()
    }
}