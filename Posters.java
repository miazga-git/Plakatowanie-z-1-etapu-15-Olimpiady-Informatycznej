import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Posters {
    public static void main(String[] args) throws IOException {

        int counter=0;
        Stack stack = new Stack<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Buildings b = new Buildings();
        b.readNumberOfBuildings(reader);

        for(int i=0;i<b.getBn();i++){
            b.readHeight(reader);
            while(!stack.isEmpty() && (Integer)stack.peek()>b.getH()){
                stack.pop();
            }
            if(stack.isEmpty() || (Integer)stack.peek()<b.getH()){//i building is not redundant
                stack.push(b.getH());
                counter++;
            }

        }
        System.out.println(counter);
    }
}
class Buildings{
    private int h;
    private int bn;

    public int getH(){
        return h;
    }
    public int getBn() {
        return bn;
    }
    public void readHeight(BufferedReader reader) throws IOException {
        String line =reader.readLine();
        String[] values = line.split(" ");
        String height = values[1];
        h= Integer.parseInt(height); // height in h
    }
    public void readNumberOfBuildings(BufferedReader reader) throws IOException {
        String buildingsNumber =reader.readLine();
        bn = Integer.parseInt(buildingsNumber); // number of buildings in bn
    }

}
