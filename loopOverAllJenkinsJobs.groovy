import jenkins.model.*
import hudson.model.* 

Jenkins.instance.getAllItems(AbstractProject.class).each { 
    if(it.fullName =~ "abc"){
          println(it.fullName+":"+it.disabled)
          //it.disabled=true
          //it.save()
          //println(it.fullName+":"+it.disabled)
      }
}
