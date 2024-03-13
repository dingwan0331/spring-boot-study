package config

import io.kotest.core.spec.style.BehaviorSpec
import io.kotest.matchers.types.shouldBeInstanceOf
import org.junit.jupiter.api.assertThrows
import org.springframework.beans.factory.NoSuchBeanDefinitionException
import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.context.annotation.AnnotationConfigApplicationContext
import study.config.AppConfig
import study.user.domain.service.UserService

class TestAppConfig : BehaviorSpec(
    {
        given(
            "AppConfig 출력테스트"

        ) {
            val applicationContext: AnnotationConfigApplicationContext =
                AnnotationConfigApplicationContext(AppConfig::class.java)

            `when`(
                "어플리케이션에 직접등록한 빈 or 라이브러리 출력시"
            ) {
                val beanNames: Array<String> = applicationContext.getBeanDefinitionNames()
                then("출력") {
                    val beanNames: Array<String> = applicationContext.getBeanDefinitionNames()
                    for (beanName in beanNames) {
                        // 어플리케이션에 직접 등록한경우 OR 라이브러리들
                        val beanDefinition: BeanDefinition = applicationContext.getBeanDefinition(beanName)
                        if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                            val bean = applicationContext.getBean(beanName)
                            println(bean)
                        }
                    }
                }
            }
            `when`("이름으로 빈 찾기") {
                val bean = applicationContext.getBean("userService", UserService::class.java)
                then("출력") {
                    bean.shouldBeInstanceOf<UserService>()
                }
            }
            `when`("클래스로 빈 찾기 빈 찾기") {
                val bean = applicationContext.getBean(UserService::class.java)
                then("출력") {
                    bean.shouldBeInstanceOf<UserService>()
                }
            }
            `when`("없는 빈을 이름으로 찾을경우") {
                then("에러") {

                    assertThrows<NoSuchBeanDefinitionException> {
                        applicationContext.getBean(
                            "sasfasdgf",
                            UserService::class.java
                        )
                    }
                }
            }
        }
    }
)