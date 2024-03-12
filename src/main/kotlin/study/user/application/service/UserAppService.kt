package study.user.application.service

import study.user.domain.entity.User

interface UserAppService {
    fun register(name:String? , mobilePhoneNumber:String):Long
}