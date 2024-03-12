package study.user.application.rest

import study.user.application.service.UserAppService

class UserController(private val userAppService: UserAppService) {
    fun register(name:String?, mobilePhoneNumber:String):Long{
        return userAppService.register(name=name,mobilePhoneNumber=mobilePhoneNumber)
    }
}