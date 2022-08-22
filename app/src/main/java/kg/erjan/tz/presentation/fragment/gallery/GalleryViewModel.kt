package  kg.erjan.tz.presentation.fragment.gallery

import androidx.lifecycle.viewModelScope
import kg.erjan.core.base.BaseViewModel
import kg.erjan.domain.usecase.GetImagesUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class GalleryViewModel @Inject constructor(private val getImagesUseCase: GetImagesUseCase) :
    BaseViewModel() {

    private val _getImageState = MutableStateFlow<List<String>?>(null)
    val getImageState = _getImageState.asStateFlow()

    fun getImage() {
        viewModelScope.launch {
            getImagesUseCase.invoke().collectLatest {
                _getImageState.value = it
            }
        }
    }

}