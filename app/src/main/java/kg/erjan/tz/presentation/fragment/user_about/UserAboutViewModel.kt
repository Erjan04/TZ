package kg.erjan.tz.presentation.fragment.user_about

import androidx.lifecycle.viewModelScope
import kg.erjan.core.base.BaseViewModel
import kg.erjan.domain.model.User
import kg.erjan.domain.usecase.GetUserInfoUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

class UserAboutViewModel @Inject constructor(private val getUserInfoUseCase: GetUserInfoUseCase) :
    BaseViewModel() {

    private val _getUserInfoState = MutableStateFlow<User?>(null)
    val getUserInfoState = _getUserInfoState.asStateFlow()

    init {
        getUserInfo()
    }

    private fun getUserInfo() {
        viewModelScope.launch {
            getUserInfoUseCase.invoke().collectLatest {
                _getUserInfoState.value = it
            }
        }
    }

}