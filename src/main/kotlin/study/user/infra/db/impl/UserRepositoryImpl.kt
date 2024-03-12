package study.user.infra.db.impl

import study.user.domain.entity.User
import study.user.infra.db.UserRepository

val userMemory : HashMap<Long, User> = HashMap()

class UserRepositoryImpl: UserRepository {
    override fun insert(user: User):Unit{
        userMemory[user.getId()]= user
    }

    override fun findRecentId(): Long? = userMemory.keys.maxOrNull()

}