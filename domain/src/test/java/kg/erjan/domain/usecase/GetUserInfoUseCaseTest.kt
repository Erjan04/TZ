package kg.erjan.domain.usecase

import kg.erjan.domain.model.Company
import kg.erjan.domain.model.User
import kg.erjan.domain.repository.UserRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetUserInfoUseCaseTest {

    private val userRepository = mock<UserRepository>()

    @Test
    fun `get user info use case test`() = runBlocking {
        val companyList = mutableListOf(
            Company("Весь мир", "Че нах#й?")
        )
        val testList =
            User(
                "Казуя",
                "Не будет тебе фото Казуи",
                "Мишима",
                "Он и есть знание",
                "100000000000лет",
                companyList
            )
        val flow = flow {
            emit(testList)
        }
        Mockito.`when`(userRepository.getUserInfo()).thenReturn(flow)

        val useCase = GetUserInfoUseCase(userRepository)
        val actual = useCase.invoke().first()
        val expected = User(
            "Казуя",
            "Не будет тебе фото Казуи",
            "Мишима",
            "Он и есть знание",
            "100000000000лет",
            companyList
        )
        Assertions.assertEquals(expected, actual)

    }

}