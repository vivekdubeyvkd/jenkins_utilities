import jenkins.model.*
import hudson.*
import hudson.model.*
import java.time.LocalDate
import java.time.format.DateTimeFormatter

def compare_dates(dateString1, dateString2){
    def dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    myDate1 = LocalDate.parse(dateString1,  dateFormat)
    myDate2 = LocalDate.parse(dateString2,  dateFormat)
    if(myDate1 < myDate2){
        println(dateString2 + " is the latest date when compared to " + dateString1)
    } else{
        println(dateString1 + " is the latest date when compared to " + dateString2)
    }  
}

// You can call compare_dates functions as shown below

//sample call #1
compare_dates('2021-08-12', '2022-07-12')
// output : 2022-07-12 is the latest date when compared to 2021-08-12

//sample call #2
compare_dates('2022-08-12', '2022-07-12')
//output : 2022-08-12 is the latest date when compared to 2022-07-12
