package kg.erjan.domain.repository

import kg.erjan.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {

    fun getUserInfo(): Flow<User>

}