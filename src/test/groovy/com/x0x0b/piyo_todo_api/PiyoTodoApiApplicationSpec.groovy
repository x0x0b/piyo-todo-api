package com.x0x0b.piyo_todo_api

import org.springframework.boot.test.context.SpringBootTest
import spock.lang.Specification

@SpringBootTest
class PiyoTodoApiApplicationSpec extends Specification {

    def "context loads"() {
        expect:
        true
    }
}
