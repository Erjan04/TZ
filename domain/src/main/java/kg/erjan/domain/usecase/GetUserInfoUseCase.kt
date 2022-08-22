package kg.erjan.domain.usecase

import kg.erjan.domain.repository.UserRepository
import javax.inject.Inject

class GetUserInfoUseCase @Inject constructor(private val repository: UserRepository) {

    fun invoke() = repository.getUserInfo()

}