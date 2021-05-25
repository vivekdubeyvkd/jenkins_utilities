
def extractBuildParametersForABuild(jobeName, jobBuildNumber) {
      Jenkins.instance.allItems.findAll() {
         it.fullName.matches(jobeName)
      }.each { job ->
        builds = job.getBuilds()
        builds.each { build ->
          if(build.number == jobBuildNumber){
               param1 = build.actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'param1'}?.value
               param2 = build.actions.find{ it instanceof ParametersAction }?.parameters.find{it.name == 'param2'}?.value
               println param1
               println param2
          }  
        }
      }
}

// to extract the job paramters for job with number 120 for example, please call extractBuildParametersForABuild as shown below
 extractBuildParametersForABuild("my-test-job", '120')
