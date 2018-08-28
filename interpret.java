public int interpret(int value, String[] commands, int[] args) {
  int i = 0;
  int v = value;
  int[] arg = args;
  String[] command = commands;
  
  for(i = 0; i < command.length; i++){
    switch(command[i]){
      case "+":
        v = v + arg[i];
        //break;
      case "-":
        v = v - arg[i];
        //break;
      case "*":
        v = v * arg[i];
        //break;
      default:
        v = -1;
    }
  }
  return v;
}