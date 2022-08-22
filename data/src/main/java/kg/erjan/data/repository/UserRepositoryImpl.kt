package kg.erjan.data.repository

import android.content.Context
import kg.erjan.core.extensions.readAssetsFile
import kg.erjan.data.dto.CompanyDto
import kg.erjan.data.dto.UserDto
import kg.erjan.data.dto.toDomain
import kg.erjan.domain.model.User
import kg.erjan.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import org.json.JSONObject

class UserRepositoryImpl(val context: Context) : UserRepository {

    override fun getUserInfo(): Flow<User> {
        return flow {
            val result = context.assets.readAssetsFile("file.json")

            val jObject = JSONObject(result)
            val user = jObject.getString(USER)
            val userObject = JSONObject(user)

            val firstName = userObject.getString(FIRST_NAME)
            val photo = userObject.getString(PHOTO)
            val secondName = userObject.getString(SECOND_NAME)
            val experience = userObject.getString(EXPERIENCE)
            val education = userObject.getString(EDUCATION)

            val userDto = UserDto(
                firstName,
                photo,
                secondName,
                education,
                experience,
                getCompanyList(userObject)
            )
            emit(userDto.toDomain())
        }
    }

    private fun getCompanyList(jsonObject: JSONObject): ArrayList<CompanyDto> {
        val jsonArray = jsonObject.getJSONArray(COMPANY)
        val arrayList = arrayListOf<CompanyDto>()
        for (i in 0 until jsonArray.length()) {
            val itemArray = jsonArray.getJSONObject(i)
            val name = itemArray.getString(NAME)
            val position = itemArray.getString(POSITION)

            arrayList.add(
                CompanyDto(
                    name = name,
                    position = position
                )
            )
        }

        return arrayList
    }

    companion object {
        private const val USER = "user"
        private const val NAME = "name"
        private const val FIRST_NAME = "first_name"
        private const val SECOND_NAME = "second_name"
        private const val PHOTO = "photo"
        private const val EXPERIENCE = "experience"
        private const val EDUCATION = "education"
        private const val COMPANY = "company"
        private const val POSITION = "position"
    }
}