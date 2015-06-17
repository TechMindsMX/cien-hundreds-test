import com.tim.hundreds.Role
import com.tim.hundreds.User
import com.tim.hundreds.Profile
import com.tim.hundreds.UserRole

class BootStrap {

    def init = { servletContext ->
      createUserRole()
    }
    def destroy = {
    }

    def createUserRole(){
      def userRole = new Role(authority: 'ROLE_USER').save(flush: true)

      def user = new User(username: 'cien', password: '12345678')
      def  profile = new Profile(email:'me@techminds.com.mx', firstName:'me', middleName:'middleName', lastName:'lastName',phone:'1234567890').save()
      user.profile = profile
      user.enabled = true
      user.save(flush: true)

      UserRole.create user, userRole, true

      assert User.count() == 1
      assert Role.count() == 1
      assert UserRole.count() == 1
    }

}
