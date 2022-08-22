package kg.erjan.data.repository

import android.annotation.SuppressLint
import android.content.Context
import android.database.Cursor
import android.net.Uri
import android.provider.MediaStore
import kg.erjan.domain.repository.GalleryRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GalleryRepositoryImpl(val context: Context) : GalleryRepository {

    @SuppressLint("Recycle")
    override fun getImages(): Flow<List<String>> {
        return flow {
            val cursor: Cursor
            val listOfAllImages: ArrayList<String> = ArrayList()
            var absolutePathOfImage: String
            val uri: Uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI

            val projection =
                arrayOf(MediaStore.MediaColumns.DATA, MediaStore.Images.Media.BUCKET_DISPLAY_NAME)
            val orderBy: String = MediaStore.Images.Media.DATE_TAKEN
            cursor = context.contentResolver.query(uri, projection, null, null, orderBy + " DESC")!!
            val columnIndexData: Int = cursor.getColumnIndexOrThrow(MediaStore.MediaColumns.DATA)

            while (cursor.moveToNext()) {
                absolutePathOfImage = cursor.getString(columnIndexData)
                listOfAllImages.add(absolutePathOfImage)
            }

            emit(listOfAllImages)
        }
    }
}