import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class Form {
    static String answer;
    static Scanner input = new Scanner(System.in);

    public static void FormAnswer(){
        String[] answers = new String[9];
        File form = new File("C:\\Users\\anjos\\Estudos-DEV\\Logica-de-Programacao-Java\\Escrevendo o README\\Sistema de Cadastro para PETS\\assets\\formulario.txt");

        try (BufferedReader bf = new BufferedReader(new FileReader(form))) {
            String line;
            byte tick = 0;

            while ((line = bf.readLine()) != null) {
                System.out.print(line + " ");
                answer = input.nextLine();
                answers[tick] = answer;

                if (answers[0] == null || answers[0].isEmpty()) {
                    throw new FormNameException("É obrigatório escrever um nome válido");
                } else if (FormNameException.regexNameError(answers[0])) {
                    throw new FormNameException("Caracter especial encontrado, escreva um nome válido.");
                }
                if (AgeException.regexAgeError(answers[6])) {
                    throw new AgeException("Você escreveu a Idade errado escreva novamente");
                }
                if (answer.equalsIgnoreCase("")) {
                    answers[tick] = "NÃO INFORMADO";
                }
                if (tick == 8) {
                    break;
                }
                tick++;
            }

            Pet pet = new Pet(
                    answers[0],// Nome
                    Pet.TipoPet.chooseAnimal(answers[1]), // Tipo do Pet
                    Pet.SexoPet.chooseSexAnimal(answers[2]), // Sexo do Pet
                    answers[3],
                    answers[4],
                    answers[5],
                    Integer.parseInt(answers[6]), // Idade
                    Double.parseDouble(answers[7]), // Peso
                    answers[8]
            );

            Pet.imprimirRepostaForm(pet, Pet.TipoPet.chooseAnimal(answers[1]), Pet.SexoPet.chooseSexAnimal(answers[2]));
        } catch (FormNameException e) {
            System.out.println("\nErro: " + e.getMessage() + "\n"); // Captura a sua exceção personalizada
            Form.FormAnswer();
        } catch (AgeException e) {
            System.out.println("\nErro: " + e.getMessage() + "\n"); // Captura a sua exceção personalizada
        } catch (Exception e) {
            System.out.println("\nErro: " + e.getMessage() + "\n"); // Captura a sua exceção personalizada
            e.printStackTrace();
        }
    }
}
