package ${packageName}

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ${viewModelFactoryName} : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return super.create(modelClass)
    }

}