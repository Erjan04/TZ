package kg.erjan.tz.presentation.fragment.user_about

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kg.erjan.domain.usecase.GetUserInfoUseCase
import javax.inject.Inject

class UserAboutViewModelFactory @Inject constructor(val getUserInfoUseCase: GetUserInfoUseCase) :
    ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return UserAboutViewModel(getUserInfoUseCase) as T
    }

}