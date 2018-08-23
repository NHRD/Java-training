public boolean canBalance(int[] nums) {
    Boolean result = true;
    float sum = 0;
    int var = 0;
    for(int num : nums){
      sum = sum + num;
    }
  
    for(int num: nums){
      if(!(sum % 2 == 0)){
      result = false;
      break;
        }
      var = var + num;
      if(var == sum/2){
        result = true;
        break;
      }else{
        result = false;
        }
      }
    return result;
  }