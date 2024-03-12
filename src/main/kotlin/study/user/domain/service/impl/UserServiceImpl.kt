package study.user.domain.service.impl

import study.user.domain.entity.User
import study.user.domain.service.UserService
import study.user.infra.db.UserRepository


class UserServiceImpl (
    private val userRepository: UserRepository
):UserService{
    override fun register(name:String? , mobilePhoneNumber:String):Long{
        val newId = userRepository.findRecentId()?.let { it + 1 } ?: 1
        val user = User.register(id=newId,name=name,mobilePhoneNumber=mobilePhoneNumber)
        userRepository.insert(user=user)
        return userRepository.findRecentId()?: throw IllegalArgumentException("Insert failed")
    }
}