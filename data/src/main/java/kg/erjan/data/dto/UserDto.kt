package kg.erjan.data.dto

import com.google.gson.annotations.SerializedName
import kg.erjan.domain.model.Company
import kg.erjan.domain.model.User

data class UserDto(
    @SerializedName("first_name")
    val firstName: String,
    @SerializedName("photo")
    val photo: String,
    @SerializedName("second_name")
    val secondName: String,
    @SerializedName("education")
    val education: String,
    @SerializedName("experience")
    val experience: String,
    @SerializedName("company")
    val company: List<CompanyDto>
)

fun UserDto.toDomain() =
    User(firstName, photo, secondName, education, experience, company.map { it.toDomain() })

data class CompanyDto(
    @SerializedName("name")
    val name: String,
    @SerializedName("position")
    val position: String
)

fun CompanyDto.toDomain(): Company {
    return Company(name, position)
}
