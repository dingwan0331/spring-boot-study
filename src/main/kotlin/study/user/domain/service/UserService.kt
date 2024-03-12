package study.user.domain.service

import study.user.domain.entity.User

interface UserService {
    fun register(name:String? , mobilePhoneNumber:String):Long
}