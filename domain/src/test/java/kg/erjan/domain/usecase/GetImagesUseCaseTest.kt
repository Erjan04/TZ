package kg.erjan.domain.usecase

import kg.erjan.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.mockito.Mockito
import org.mockito.kotlin.mock

class GetImagesUseCaseTest {

    private val galleryRepository = mock<GalleryRepository>()

    @Test
    fun `get image use case test`() = runBlocking {
        val testList =
            mutableListOf("http//photo//ты знаешь казуя мишима?Он сейчас тебя ебан#т ты ж охуе##ь")
        val flow = flow {
            emit(testList)
        }
        Mockito.`when`(galleryRepository.getImages()).thenReturn(flow)

        val useCase = GetImagesUseCase(galleryRepository)
        val actual = useCase.invoke().first()
        val expected =
            mutableListOf("http//photo//ты знаешь казуя мишима?Он сейчас тебя ебан#т ты ж охуе##ь")
        assertEquals(expected, actual)

    }

}