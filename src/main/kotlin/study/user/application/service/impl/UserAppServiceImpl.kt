package study.user.application.service.impl

import study.user.application.service.UserAppService
import study.user.domain.service.UserService

class UserAppServiceImpl(private val userService: UserService):UserAppService {

    override fun register(name:String? , mobilePhoneNumber:String):Long {
        return userService.register(name=name,mobilePhoneNumber=mobilePhoneNumber)
    }
}