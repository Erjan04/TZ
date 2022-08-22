package kg.erjan.tz.presentation.fragment.gallery

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kg.erjan.domain.usecase.GetImagesUseCase
import javax.inject.Inject

class GalleryViewModelFactory @Inject constructor(val getImagesUseCase: GetImagesUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GalleryViewModel(getImagesUseCase) as T
    }

}