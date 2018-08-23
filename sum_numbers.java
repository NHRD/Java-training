public int sumNumbers(String str) {
    String buffer = "";
    int result = 0;
    char[] character = str.toCharArray();
    for(char c: character){
      if(Character.isDigit(c) == true){
         buffer = buffer + c;
      }
      else if(!(buffer == "")){
        result = result + Integer.parseInt(buffer);
        buffer = "";
      }
    }
    if(!(buffer == "")){
      result = result + Integer.parseInt(buffer);
    }
    return result;
  }