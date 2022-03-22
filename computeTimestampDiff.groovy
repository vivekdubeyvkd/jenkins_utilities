import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.text.*

def computeTimeDiff(inputTimeStamp){
    def startString = inputTimeStamp.replace('Z','') 
    def endString = (java.time.LocalDateTime.now()).toString().replaceAll('\\..*','')
    def dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
    
    Date convertedStartDate = dateFormat.parse(startString)
    Date convertedEndDate = dateFormat.parse(endString)

    def duration = groovy.time.TimeCategory.minus(convertedEndDate, convertedStartDate)
    //println("Diff duration details : " + duration)
    def diffDays = duration.getDays()
    def diffHours = duration.getHours()
    return ((diffDays * 24) + diffHours)
}

// you can call computeTimeDiff function to get the time difference in hours between curren time and input time stamp i.e. 2021-03-22T01:01:54Z
timeDiffInHours = computeTimeDiff("2021-03-22T01:01:54Z")
println("Time diff in hours : " + timeDiffInHours)
