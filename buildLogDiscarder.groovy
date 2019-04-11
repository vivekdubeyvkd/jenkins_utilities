//ref https://support.cloudbees.com/hc/en-us/articles/215549798-Best-Strategy-for-Disk-Space-Management-Clean-Up-Old-Builds

import jenkins.model.Jenkins
import hudson.model.Job
import jenkins.model.BuildDiscarderProperty
import hudson.tasks.LogRotator

daysToKeep= -1    //If not -1, history is only kept up to this days.
numToKeep= 20   //If not -1, only this number of build logs are kept.
artifactDaysToKeep=-1   // If not -1 nor null, artifacts are only kept up to this days.
artifactNumToKeep=10  //If not -1 nor null, only this number of builds have their artifacts kept.

Jenkins.instance.getAllItems(Job).each { job ->
    if (job.isBuildable() && job.supportsLogRotator() && job.getProperty(BuildDiscarderProperty) == null) {
            println "Processing \"${job.fullDisplayName}\""
            // adding a property implicitly saves so no explicit one
            job.setBuildDiscarder(new hudson.tasks.LogRotator ( daysToKeep, numToKeep, artifactDaysToKeep, artifactNumToKeep))
            println "$job.name is updated"
        }
   
}
