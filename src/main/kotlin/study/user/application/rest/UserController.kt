package study.user.application.rest

import org.springframework.context.annotation.AnnotationConfigApplicationContext
import study.config.AppConfig
import study.user.domain.service.UserService

class UserController {
    private val applicationContext: AnnotationConfigApplicationContext = AnnotationConfigApplicationContext(AppConfig::class.java)
    fun register(name:String?, mobilePhoneNumber:String):Long{
        val userService:UserService =  applicationContext.getBean("userService",UserService::class.java)
        return userService.register(name=name,mobilePhoneNumber=mobilePhoneNumber)
    }
}