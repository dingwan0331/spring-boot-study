package study.user.infra.db

import study.user.domain.entity.User

interface UserRepository {
    fun insert(user: User):Unit
    fun findRecentId():Long?
}