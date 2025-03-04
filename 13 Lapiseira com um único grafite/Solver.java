import java.util.Scanner;

public class Solver {
    public static void main(String[] _args) {
        Pencil adp = new Pencil(0.5f);

        while (true) {
            String line = input();
            String[] args = line.split(" ");
            write('$' + line);

            if("end".equals(args[0])){
                break;
            }
            else if ("init".equals(args[0])){
                adp = new Pencil(number(args[1]));
            }
            else if ("insert".equals(args[0])){
                adp.insert(new Lead(number(args[1]), args[2], (int) number(args[3])));
            }
            else if ("remove".equals(args[0])){
                adp.remove();
            }
            else if ("write".equals(args[0])){
                adp.writePage();
            }
            else if ("show".equals(args[0])){
                write(adp.toString());
            }
        }
    }

    static Scanner scanner = new Scanner(System.in);
    public static String input(){
        return scanner.nextLine();
    }
    public static void write(String value){
        System.out.println(value);
    }
    public static float number(String str){
        return Float.parseFloat(str);
    }
}
