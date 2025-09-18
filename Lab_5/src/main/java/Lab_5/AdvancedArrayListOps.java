package Lab_5;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AdvancedArrayListOps {
    private ArrayList<String> list;


    public AdvancedArrayListOps(){
        list = new ArrayList<>();
    }

    public void append(String str1){
        list.add(str1);
    }
    public void insert(String str1,int index){
        list.add(index,str1);
    }

    public boolean Search(String str1){
        for (int i=0;i<list.size();i++){
            if (list.get(i).equals(str1)){
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> Starts(String ch1){
        ArrayList<String> list1;
        list1=new ArrayList<>();
        for (int i=0;i<list.size();i++){
            if (list.get(i).startsWith(ch1)){
                list1.add(list.get(i));
            }
        }
        return list1;
    }
    public void AscendingSortList(){
        String temp;
        for (int j = 0; j < list.size(); j++) {
   	        for (int i = j + 1; i < list.size(); i++) {
		        if (list.get(i).compareTo(list.get(j)) < 0) {
			        temp = list.get(j);
			        list.set(j,list.get(i));
			        list.set(i,temp);
		        }
	        }
        }
    }
    public void DescendingSortList(){
        String temp;
        for (int j = 0; j < list.size(); j++) {
   	        for (int i = j + 1; i < list.size(); i++) {
		        if (list.get(i).compareTo(list.get(j)) > 0) {
			        temp = list.get(j);
			        list.set(j,list.get(i));
			        list.set(i,temp);
		        }
	        }
        }
    }
    public ArrayList<String> match(String ch1){
        ArrayList<String> list1;
        String s;
        list1=new ArrayList<>();
        Pattern pattern=Pattern.compile(ch1,Pattern.CASE_INSENSITIVE);
        for (int i=0;i<list.size();i++){
            s=list.get(i);
            Matcher matcher=pattern.matcher(s);   
            if (matcher.find()){
                list1.add(s);
            }
        }
        return list1;
    }
    public ArrayList<String> RemoveDuplicate(){
        ArrayList<String> list1;
        list1=new ArrayList<>();
        HashSet<String> hs = new HashSet<String>();
        for (int i=0;i<list.size();i++){
            hs.add(list.get(i));
        }
        for (String j : hs){
            list1.add(j);
        }
        return list1;
    }
    public void display() {
        if (list.isEmpty()) {
            System.out.println("The list is empty.");
        }   
        else {
            System.out.println("Current List: " + list);
        }
    }


}
