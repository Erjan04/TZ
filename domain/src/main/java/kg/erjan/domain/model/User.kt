package kg.erjan.domain.model

data class User(
    val firstName: String,
    val photo: String,
    val secondName: String,
    val education: String,
    val experience: String,
    val company: List<Company>
) {
    companion object {
        fun create(
            firstName: String,
            photo: String,
            secondName: String,
            education: String,
            experience: String,
            company: List<Company>
        ) = User(firstName, photo, secondName, education, experience, company)
    }
}

data class Company(
    val name: String,
    val position: String
) {
    companion object {
        fun create(
            name: String,
            position: String
        ) = Company(name, position)
    }
}
