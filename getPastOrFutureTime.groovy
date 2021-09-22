currentDate =  java.time.LocalDateTime.now()

// get 75 hours older time from now 
timeBackTo75hours = currentDate.minusHours(75)

// get 56 hours future time from now
timeForNext56hours = currentDate.plusHours(56)


println  timeBackTo75hours
println  timeForNext56hours
