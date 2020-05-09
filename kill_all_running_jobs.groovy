import jenkins.model.*
import hudson.model.* 

for (job in Jenkins.instance.getAllItems(AbstractProject.class)) {
      for (build in job.builds) {
          if (build.isBuilding()) { 
               println(build)
               build.doStop()
          }
      }
}
