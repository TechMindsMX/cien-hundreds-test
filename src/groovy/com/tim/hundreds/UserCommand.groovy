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
    confirmEmail nullable:true
    confirmPassword nullable:true
    firstName blank:false,size:1..100
    middleName blank:false,size:1..100
    lastName blank:false,size:1..100
    email blank:false,email:true,unique:true,size:1..200
    phone nullable:true,blank:false,matches:/^[0-9]*$/,size:10..10
    username blank:false,size:6..50
    password blank:false,size:6..50
  }
}

