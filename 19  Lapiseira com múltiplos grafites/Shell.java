import java.text.DecimalFormat;
import java.util.Scanner;
import java.util.ArrayList;
public class Shell {
    public static Pencil pencil = new Pencil(0.5f);
    public static void main(String[] _args) {

        while(true) {
            var line = scanner.nextLine();
            System.out.println("$" + line);

            var par = line.split(" ");
            var cmd = par[0];

            if (cmd.equals("end")) {
                break;
            }
            else if (cmd.equals("init")) {
                pencil = new Pencil(Float.parseFloat(par[1]));
            } 
            else if (cmd.equals("insert")) { 
                
                float thickness = Float.parseFloat(par[1]);
                String hardness = par[2];
                int size = Integer.parseInt(par[3]);
                pencil.insert(new Lead(thickness, hardness, size));
            } 
            else if (cmd.equals("remove")) {
                pencil.remove();
            } 
            else if (cmd.equals("show")) {
                System.out.println(pencil.toString());
            } 
            else if (cmd.equals("write")) {
                pencil.writePage();
            } 
            else if (cmd.equals("pull")) {
                pencil.pull();
            } 
            else {
                System.out.println("fail: comando invalido");
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
}