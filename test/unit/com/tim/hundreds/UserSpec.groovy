package com.tim.hundreds

import grails.test.mixin.TestFor
import spock.lang.Specification
import spock.lang.Unroll

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(User)
class UserSpec extends Specification {

  @Unroll
  void """When we have user with values: firstName: #firstName, middleName: #middleName, lastName: #lastName, email: #email, username: #username, password: #password, phone: #phone and we want validate this values we expect result is: #result"""() {
  given: "An user command"
    UserCommand user = new UserCommand()
  when: "We assign values"
    user.firstName = firstName
    user.middleName = middleName
    user.lastName = lastName
    user.email = email
    user.username = username
    user.password = password
    user.phone = phone
    user.validate()
   then: "We validate result"
    result == user.validate()
   where: "We have next values"
   firstName | middleName   | lastName   | email              | username | password     | phone         || result
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | null          || true
   'J'       | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   'Jose'    | 'D'          | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'M'        | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | 'a234567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | 'aA34567890' | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || true
   ''        | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   null      | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | ''           | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | null         | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | ''         | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | null       | 'josdem@email.com' | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email'     | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdememail.com'  | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem'           | 'josdem' | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josde'  | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | ''       | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | null     | '1234567890' | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '123456789'  | '1234567890'  || true
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | ''           | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | null         | '1234567890'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '123456789'   || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '12345678901' || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '123456789a'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | '123456789B'  || false
   'Jose'    | 'De la Cruz' | 'Morales'  | 'josdem@email.com' | 'josdem' | '1234567890' | ''            || false
  }

}
