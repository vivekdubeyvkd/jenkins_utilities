/* Hello World in Groovy */
/** 
    # This programs counts consecutive occurences of a word in a string and creates a compressed message digest e.g.
    # If input string is aabcdrsss, then output will be a2bcdrs3
    # If input string is abc, then output will be abc
    # If input string is abbbac, then output will be ab3ac
    # If input string is abbbacdssssb, then output will be ab3acds4b
**/

def createCompressedMessageDigestFromAString(message){
    messageList = message as String[]
    compressedString = ""
    for(index1 = 0; index1 < messageList.size(); index1++){
        counter =  1
        for(index2 = index1 + 1; index2 < messageList.size(); index2++){
            if(messageList[index1] == messageList[index2]){
                counter = counter + 1
            }else {
                break
            }
        } 
        
        
        if(counter == 1){
            if(compressedString == "" || compressedString.length() == 1){
                compressedString = compressedString + messageList[index1]
            }else {
                lastTwoCharInCompressed = compressedString.substring(compressedString.length() - 2)
                if(! lastTwoCharInCompressed.contains(messageList[index1])){
                    compressedString = compressedString + messageList[index1]
                }    
            }
        }else{
            if(compressedString == ""){
                compressedString = compressedString + messageList[index1] + counter
            } else if(! compressedString.contains(messageList[index1])){
                compressedString = compressedString + messageList[index1] + counter
            }    
        }
    }
    println(compressedString)
}


createCompressedMessageDigestFromAString("aabcdrsss") 
createCompressedMessageDigestFromAString("abc") 
createCompressedMessageDigestFromAString("abbbac") 
createCompressedMessageDigestFromAString("abbbacdssssb")
