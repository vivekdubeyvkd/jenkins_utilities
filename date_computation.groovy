/**
  This utility shows examples how to compute future & past data and time wrt current date
  Few date formats shows can be used in GitHub rest API calls to compute open, merged or closed PRs over a time range
**/

import jenkins.*
import jenkins.model.*
import hudson.*
import hudson.model.* 
import groovy.time.*

def setDateVars(){
    stage("Set TimeStamp Vars"){
       currentDate =  java.time.LocalDateTime.now()

       tmpTimeStampBackTo70hours = currentDate.minusHours(70)
       tmpTimeStampAfter48hours = currentDate.plusHours(48)
       
       echo """
             Current Date                   :   ${currentDate}
             Date and Time 70 hours back    :   ${tmpTimeStampBackTo70hours}
             Date and Time after 48 hours   :   ${tmpTimeStampAfter48hours}
       """
       
       // below date and time format can be used with GitHub rest API for computing open, closed or merged PRs over a period of time
       timeStampBackTo70hours = tmpTimeStampBackTo70hours.toString().replaceAll("\\..*","Z")
       timeStampBackTo48hours = tmpTimeStampAfter48hours.toString().replaceAll("\\..*","Z")
       
       echo """
             Current Date                   :   ${currentDate}
             Date and Time 70 hours back    :   ${timeStampBackTo70hours}
             Date and Time after 48 hours   :   ${timeStampBackTo48hours}
       """       
    }
}

// call this function as shown below
 setDateVars()

