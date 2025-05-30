package Class;

import java.io.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class DatabaseActions {

    private static final Scanner input = new Scanner(System.in);

    public static void createPetFile(){
        Form.formAnswer();
    }

    public static void savePetFile(Pet pet) {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy'T'HHmm");
        String nowTimeStr = nowTime.format(formatter);
        String fileNamePattern = nowTimeStr + "-" + pet.getNomeESobrenome().toUpperCase();

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter("C:\\Users\\Nato\\Estudos-DEV\\Sistema-Pet\\petsCadastrados\\" + fileNamePattern + ".txt"))){
            bfw.write(pet.getNomeESobrenome());
            bfw.newLine();
            bfw.write(pet.getTipoPet().getType());
            bfw.newLine();
            bfw.write(pet.getSex().getSexStr());
            bfw.newLine();
            bfw.write(pet.getRua() + ", " + pet.getNumeroDaCasa() + ", " + pet.getCidade());
            bfw.newLine();
            bfw.write(pet.getIdade() + " anos");
            bfw.newLine();
            bfw.write(pet.getPeso() + "KG");
            bfw.newLine();
            bfw.write(pet.getRaca());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ficha de inscrição do Pet cadastrada com Sucesso!");
    }

    public static File[] createFile() {
        String PET_DIR = "petsCadastrados\\";
        File[] arquivos;
        try {
            File dir = new File(PET_DIR);
            if (!dir.exists() || !dir.isDirectory()) {
                throw new FileNotFoundException("Diretório de pets não encontrado.");
            }
            arquivos = dir.listFiles();
            if (arquivos == null || arquivos.length == 0) {
                throw new FileNotFoundException("Nenhum arquivo pet encontrado.");
            }
            return arquivos;
        } catch (FileNotFoundException e) {
            System.out.println("\nErro: " + e.getMessage() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return arquivos = null;
    }

    public static void listAllPets(){
        for (File arquivo : createFile()) {
            if (arquivo.isFile()) {
                try (BufferedReader bfr = new BufferedReader(new FileReader(arquivo))){
                    String line;
                    while ((line = bfr.readLine()) != null){
                        System.out.println(line);
                    }
                    System.out.println();
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                }
            }
        }
    }

    public static void sortSearch(){
        String nomeESobrenome;
        String endereco;
        String idade;
        String peso;
        String raca;
        String[] options = {"1 - Nome ou sobrenome", "2 - Sexo", "3 - Idade", "4 - Peso", "5 - Raça", "4 - Endereço"};
        byte tick = 0;
        String selected = "";
        int currentOption;

        System.out.println("---- Você selecionou o menu de busca segmentada! ----");

        System.out.println();

        System.out.print("Deseja utilizar um ou dois filtros de pesquisa?");
        int tickAux = input.nextInt();

        try {
            while (tick < tickAux){
                Boolean validInput = false;
                while (!validInput){
                    System.out.println("Escolha qual critério deseja utilizar:");
                    for (String option : options) {
                        System.out.println(option);
                    }
                    System.out.print("\nResposta: ");
                    String select = input.nextLine();
                    if (selected.equals(select)){
                        System.out.println("\nVocê já utilizou este método de pesquisa. Digite um método não utilizado ainda.\n");
                        break;
                    }

                    switch (select) {
                        case "1":
                            System.out.println("\nVocê selecionou: Nome ou sobrenome");
                            System.out.print("Digite o nome ou sobrenome: ");
                            nomeESobrenome = input.nextLine();
                            System.out.println();
                            validInput = true;
                            break;
                        case "2":
                            System.out.println("\nVocê selecionou: Sexo");
                            System.out.print("Digite o sexo (ex.: M/F): ");
                            String sexo = input.nextLine();
                            System.out.println();
                            validInput = true;
                            break;
                        case "3":
                            System.out.println("\nVocê selecionou: Idade");
                            System.out.print("Digite a idade: ");
                            idade = input.nextLine();
                            validInput = true;
                            break;
                        case "4":
                            System.out.println("\nVocê selecionou: Peso");
                            System.out.print("Digite o peso (ex.: 5.2): ");
                            peso = input.nextLine();
                            System.out.println();
                            validInput = true;
                            break;
                        case "5":
                            System.out.println("\nVocê selecionou: Raça");
                            System.out.print("Digite a raça: ");
                            raca = input.nextLine();
                            System.out.println();
                            validInput = true;
                            break;
                        case "6":
                            System.out.println("\nVocê selecionou: Endereço");
                            System.out.print("Digite o endereço: ");
                            endereco = input.nextLine();
                            System.out.println();
                            validInput = true;
                            break;
                        default:
                            System.out.println("Opção inválida! Por favor, escolha um número entre 1 e 6.");
                            break;
                    }
                    currentOption = Integer.parseInt(select) - 1;
                    options[currentOption] = options[currentOption] + " (Critério Utilizado)";
                    selected = select;
                    tick ++;
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        input.close();
    }
}
