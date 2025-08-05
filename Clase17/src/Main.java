import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main1(String[] args) {
        var array = new int[5];
        var num = 5;
        try {
            array[num] = 10;
            System.out.println(array[num]);
            var denominador = 0;
            array[num] /= denominador; // Esto lanzará una ArithmeticException
            System.out.println(array[num]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Ocurrió un error en el indice del array: " + e);
        }catch (ArithmeticException e){
            System.out.println("Ocurrió un error matematico");
        }
    }

    public static void main(String[] args) {
        try(var scanner = new Scanner(System.in)) {
            System.out.println("Bienvenido a la aplicacion, ingrese una cadena y la pasaré a mayusculas");
            var main = new Main();
            while (true) {
                try {
                    var text = main.readFromKeyboard(scanner);
                    var num = Integer.parseInt(text);
//                    System.out.printf("la cadena ingresada es: '%s'%n", text.toUpperCase());
                    System.err.println("El cuadrado del numero es: " + (num * num));
                    break;
                } catch (BlankStringException | NumberFormatException e) {
                    System.err.println("Acaba de ocurrir un error: " + e.getMessage());
                    e.printStackTrace(System.err);
                    System.out.println("Intente de nuevo");
                }
            }
        }
    }
    private String readFromKeyboard(Scanner sc) throws BlankStringException{
        System.out.println("Ingrese un valor: ");
        var input = sc.nextLine();
        if (input.isBlank()) {
            throw new BlankStringException("Error al ingresar el valor, no puede estar vacío.");
        }
        return input.trim();
    }
}