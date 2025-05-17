import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Form {
    static Scanner input = new Scanner(System.in);

    static private String nomeESobrenome;
    static Pet.TipoPet tipoPet;
    static private Pet.SexoPet sexo;
    static private String numeroDaCasa;
    static private String cidade;
    static private String rua;
    static private int idade;
    static private double peso;
    static private String raca;

    static String line;

    public static void formAnswer(){
        File form = new File("C:\\Users\\Nato\\Estudos-DEV\\Sistema-Pet\\assets\\formulario.txt");
        byte tick = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(form))) {
            while ((line = bf.readLine()) != null) {
                if (line.equals("1 - Qual o nome e sobrenome do pet?")) {
                    System.out.print(line);
                    nomeESobrenome = input.nextLine();
                }
                if (line.equals("2 - Qual o tipo do pet (Cachorro/Gato)?")) {
                    System.out.print(line);
                    String tipo = input.nextLine().toUpperCase();
                    tipoPet = Pet.TipoPet.valueOf(tipo); // Assume que o enum TipoPet tem CACHORRO e GATO
                }
                if (line.equals("3 - Qual o sexo do animal (Macho ou Fêmea)?")) {
                    System.out.print(line);
                    String sexoStr = input.nextLine().toUpperCase();
                    sexo = Pet.SexoPet.valueOf(sexoStr); // Assume que o enum SexoPet tem MACHO e FEMEA
                }
                if (line.equals("4 - Onde ele foi econtrado? Numero da Casa:")) {
                    System.out.print(line);
                    numeroDaCasa = input.nextLine();
                }
                if (line.equals("5 - Onde ele foi econtrado? Cidade:")) {
                    System.out.print(line);
                    cidade = input.nextLine();
                }
                if (line.equals("6 - Onde ele foi econtrado? Rua:")) {
                    System.out.print(line);
                    rua = input.nextLine();
                }
                if (line.equals("7 - Qual a idade aproximada do pet?")) {
                    System.out.print(line);
                    idade = Integer.parseInt(input.nextLine());
                }
                if (line.equals("8 - Qual o peso aproximado do pet?")) {
                    System.out.print(line);
                    peso = Double.parseDouble(input.nextLine());
                }
                if (line.equals("9 - Qual a raça do pet?")) {
                    System.out.print(line);
                    raca = input.nextLine();
                }
                tick++;
            }

            Pet pet = new Pet(
                    nomeESobrenome,
                    tipoPet,
                    sexo,
                    numeroDaCasa,
                    cidade,
                    rua,
                    idade,
                    peso,
                    raca
            );
        } catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage() + "\n"); // Captura a sua exceção personalizada
            e.printStackTrace();
        }
    }
}
