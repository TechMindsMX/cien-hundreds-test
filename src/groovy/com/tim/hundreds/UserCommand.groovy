package com.tim.hundreds

import grails.validation.Validateable

@Validateable
class UserCommand{
  String firstName
  String middleName
  String lastName

  String email
  String confirmEmail

  String username
  String password
  String confirmPassword

  String phone

  static constraints = {
    importFrom Profile
  }
}

