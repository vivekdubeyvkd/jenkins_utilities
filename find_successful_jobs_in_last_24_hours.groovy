import hudson.model.Job
import hudson.model.Result
import hudson.model.Run
import java.util.Calendar
import jenkins.model.Jenkins

count = 0
//24 hours in a day, 3600 seconds in 1 hour, 1000 milliseconds in 1 second
long time_in_millis = 24*3600*1000
Calendar rightNow = Calendar.getInstance()

Jenkins.instance.getAllItems(Job.class).findAll { Job job ->
    !job.isBuilding()
}.collect { Job job ->
    job.builds.findAll { Run run ->
        job.lastBuild.result == Result.SUCCESS && ((rightNow.getTimeInMillis() - run.getStartTimeInMillis()) <= time_in_millis)
    } ?: []
}.sum().each{ job -> 
  if(job.result.toString() == 'SUCCESS') {
    println "${job} ${job.result}" 
    count++
  }
}

println("Number of successful jobs in 24 hours : " + count)
