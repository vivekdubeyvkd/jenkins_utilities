count =0 
import hudson.model.User
User.getAll().each { user ->
  if(user.getId()) {
    count++
  }
}
print count
