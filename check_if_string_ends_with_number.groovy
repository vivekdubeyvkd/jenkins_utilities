input_str1 = 'abc'
input_str2 = 'abc22'

// no match , so nothing will be printed
if(input_str1 =~ "\\d+\$"){
  println input_str1 
} 

//match , so nothing will be printed
if(input_str2 =~ "\\d+\$"){
  println input_str2 
} 
  
  
