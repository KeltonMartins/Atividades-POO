import java.util.Scanner;
import java.util.Locale;

enum Planeta {
    MERCURY(3.303e+23, 2.4397e6),
    VENUS(4.869e+24, 6.0518e6),
    EARTH(5.976e+24, 6.37814e6),
    MARS(6.421e+23, 3.3972e6),
    JUPITER(1.9e+27, 7.1492e7),
    SATURN(5.688e+26, 6.0268e7),
    URANUS(8.686e+25, 2.5559e7),
    NEPTUNE(1.024e+26, 2.4746e7);

    private static final double G = 6.67300E-11;
    private final double mass;   // em kg
    private final double radius; // em metros

    Planeta(double mass, double radius) {
        this.mass = mass;
        this.radius = radius;
    }

    public double forcaGravitacional() {
        return (G * mass) / (radius * radius);
    }

    public double pesoSuperficie(double otherMass) {
        return otherMass * forcaGravitacional() / EARTH.forcaGravitacional();
    }
}

class Pessoa {
    private String nome;
    private double mass;
    private Planeta planeta;

    public Pessoa(String nome, double mass, Planeta planeta) {
        this.nome = nome;
        this.mass = mass;
        this.planeta = planeta;
    }

    public double massaEquivalente(Planeta otherPlanet) {
        double gravidade = otherPlanet.forcaGravitacional();
        System.out.printf(Locale.US, "A forca gravitacional no planeta %s é %.2f\n", otherPlanet, gravidade);
        return otherPlanet.pesoSuperficie(this.mass);
    }

    public String toString() {
        return String.format(Locale.US, "nome: %s mass: %.2f planeta: %s", nome, mass, planeta);
    }
}

class Solver {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.US);
        Pessoa p = new Pessoa("", 0, Planeta.EARTH);

        while (true) {
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            System.out.println("$" + line);
            if (ui[0].equals("end")) {
                break;
            } else if (ui[0].equals("init")) {
                p = new Pessoa(ui[1], Double.parseDouble(ui[2]), Planeta.valueOf(ui[3]));
            } else if (ui[0].equals("massaEquivalente")) {
                System.out.printf(Locale.US, "%.2f\n", p.massaEquivalente(Planeta.valueOf(ui[1])));
            } else if (ui[0].equals("show")) {
                System.out.println(p);
            } else {
                System.out.println("fail: comando invalido");
            }
        }
        scanner.close();
    }
}