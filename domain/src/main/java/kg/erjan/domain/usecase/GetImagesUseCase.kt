package kg.erjan.domain.usecase

import kg.erjan.domain.repository.GalleryRepository
import javax.inject.Inject

class GetImagesUseCase @Inject constructor(private val repository: GalleryRepository) {

    fun invoke() = repository.getImages()

}