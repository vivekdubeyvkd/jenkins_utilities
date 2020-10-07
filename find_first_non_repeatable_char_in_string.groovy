str = "asarvanis"
tmp = ""

for(index=0; index < str.size(); index++){
    val = str[index]
    if(tmp == ""){
        tmp = val
    } 
    
    if(tmp =~ val){
        tmp = tmp.replaceAll(val,'')
    } else {
       tmp = tmp + val
    }
}

println tmp[0]
