package study.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import study.user.application.service.UserAppService
import study.user.application.service.impl.UserAppServiceImpl
import study.user.domain.service.UserService
import study.user.domain.service.impl.UserServiceImpl
import study.user.infra.db.UserRepository
import study.user.infra.db.impl.UserRepositoryImpl

@Configuration
open class AppConfig {

    @Bean
    open fun userRepository(): UserRepository = UserRepositoryImpl()

    @Bean
    open fun userService(): UserService = UserServiceImpl(userRepository())

    @Bean
    open fun userAppService(): UserAppService = UserAppServiceImpl(userService())
}

