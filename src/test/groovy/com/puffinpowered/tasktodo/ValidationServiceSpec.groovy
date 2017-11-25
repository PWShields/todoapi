package com.puffinpowered.tasktodo

import com.puffinpowered.tasktodo.service.ValidationService
import com.puffinpowered.tasktodo.service.ValidationServiceImpl
import spock.lang.Shared
import spock.lang.Specification

class ValidationServiceSpec extends Specification {



    @Shared
    ValidationService validationService


    def setup(){
        validationService = new ValidationServiceImpl();
    }

    def "Brackets are balanced" (){
       given: "A list of strings containing brackets"
        expect: "if the brackets are even we get true"
        assert validationService.checkBrackets(input) == expectedResult
        where:
        input <<  ["(dfdfd)", "[(dddd)]", "{dd}", "[d]"]
        expectedResult << [true, true, true, true]
    }

    def "Brackets are notbalanced" (){
        given: "A list of strings containing brackets"
        expect: "if the brackets are not balanced we get false"
        assert validationService.checkBrackets(input) == expectedResult
        where:
        input <<  ["(dfdfd", "]{}[", "{[}]", "[{)]"]
        expectedResult << [false, false, false, false]
    }

    def "Input is valid" (){
        given: "input between 1 and 50 characters"
        String input = 'fdfdfdfdfdfdfdf'
        when: "we validate it"
        Boolean isValid = validationService.validateText(input)
        then: "it is valid"
        assert isValid
    }

    def "Input is invalid"(){
        given: "input that is less than 1 or more than 50 characters long"
        expect: "it not to be valid"
        assert validationService.validateText(input) == false
        where:
        input << ["", "dfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfddf"]
    }

}
