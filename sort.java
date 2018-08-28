int[] sort(int[] a) {
  int[] array = a;
  int[] foo = new int[array.length];
  int l = array.length;
  int i, ref = 0;
  int c = 0;
  for(i = 0; i < array.length; i++){
    if(i == 0){
      foo[0] = array[0];
      ref = array[0];
      c++;
    }else if(!(array[i] == ref)){
      foo[c] = array[i];
      ref = array[i];
      c++;
    }
  }
  while(l > 0){
      if(!(foo[l-1] == 0)){
        break;
      }else{
        l = l - 1;
      }
    }
  int[] fooo = new int[l];
  for(int s = 0; s < l; s++){
    fooo[s] = foo[s];
  }
  return fooo;
  }
