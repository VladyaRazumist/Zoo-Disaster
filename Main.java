
package newpackage;

import java.util.*;


class Main {
    public static boolean eatLeft (Map <String,String> map,int i,ArrayList <String> list){
        if (i==0) return false;
        if (list.size()<2) return false;
       String second= list.get(i);
       String first=list.get(i-1);
        if (map.containsKey(second) && map.get(second).contains(first)){
           
            list.remove(i-1);
            
            return true;
        }
        return false;
    }
     public static boolean eatRight(Map <String,String> map,int i,ArrayList <String> list){
        if (i==list.size()-1) return false;
        if (list.size()<2) return false;
       String second= list.get(i+1);
       String first=list.get(i);
       if (map.containsKey(first) && map.get(first).contains(second)){
           
            list.remove(i+1);
            return true;
        }
       return false;
    }
  

    public static void main(String args[]) 
    { 

            final String input = "giraffe,leaves,leaves,leaves,bear,bug,leaves,leaves,panda";
            String [] st=whoEatsWho(input);
            for (String s:st){
              System.out.println(s);
            }
   
      }
   public static String[] whoEatsWho(final String zoo) {
       System.out.println(zoo);
       boolean eaten=false;
      String [] animals =zoo.split(",");
    ArrayList <String> animalsList = new ArrayList<>(Arrays.asList(animals)); // list of animals
      String [] actions=new String [zoo.length()];
       int i=0;
    Map <String,String> map = new HashMap <>();
    map.put("antelope", "grass");
    map.put("big-fish", "little-fish");
    map.put("bug", "leaves");
    map.put("bear"," big-fish bug chicken cow leaves sheep");
    map.put("chicken", "bug");
    map.put("cow", "grass");
    map.put("fox", "chicken sheep");
    map.put("giraffe", "leaves");
    map.put("lion", "antelope  cow");
    map.put("panda", "leaves");
    map.put("sheep", "grass");
for (int j=0;j<animals.length;j++){ // 
     for (int k=0;k<animalsList.size();k++){
          String first="";
          String second="";
          if (k!=0 && animalsList.size()>=2){
              first=animalsList.get(k);
              second=animalsList.get(k-1);
          }
         eaten=eatLeft(map,k,animalsList);
         
         if (eaten){
              actions[i]=first+ " eats " + second ;
              i++;
              break;
         }
         if (k!=animalsList.size()-1 && animalsList.size()>=2){
              first=animalsList.get(k);
              second=animalsList.get(k+1);
          }
         eaten=eatRight(map,k,animalsList);
            if (eaten) {
                actions[i]=first+ " eats " + second ;
                i++;
                break;
            }
         
     }
}
int q=0;


 for (String st:actions){
   if (st!=null) {
    
   q++;
   }
  }

 String [] finalString=new String [q+2];
 finalString[0]=zoo;
 for (int j=0;j<q;j++){
     finalString[j+1]=actions[j];
     
 }
 String help=animalsList.get(0);
 for (int j=1;j<animalsList.size();j++){
     help=help+","+animalsList.get(j); 
 }
 finalString[q+1]=help;
 
    return finalString;
  }
}


       
    
    
  

    
    
  
