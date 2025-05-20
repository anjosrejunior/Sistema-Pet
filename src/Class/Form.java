package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;
import Exceptions.AgeException;
import Exceptions.FormNameException;
import Exceptions.HouseNumberException;
import Exceptions.InvalidEnumException;

public class Form {
    static Scanner input = new Scanner(System.in);

    static private String nomeESobrenome;
    static Pet.TipoPet tipoPet;
    static private Pet.SexoPet sexo;
    static private String numeroDaCasa;
    static private String cidade;
    static private String rua;
    static private double idade;
    static private double peso;
    static private String raca;

    public static void formAnswer() {
        File form = new File("C:\\Users\\Nato\\Estudos-DEV\\Sistema-Pet\\assets\\formulario.txt");
        byte tick = 0;

        try (BufferedReader bf = new BufferedReader(new FileReader(form))) {
            String line;
            while ((line = bf.readLine()) != null) {
                tick++;
                boolean validInput = false;

                while (!validInput) {
                    try {
                        if (line.equals("1 - Qual o nome e sobrenome do pet?")) {
                            System.out.print(line + " ");
                            nomeESobrenome = input.nextLine();
                            if (nomeESobrenome.isEmpty()) {
                                throw new FormNameException("É obrigatório pree ncher um nome");
                            }
                            if (FormNameException.regexNameError(nomeESobrenome)) {
                                throw new FormNameException("Nome escrito errado, escreva novamente");
                            }
                            validInput = true;
                        }
                        else if (line.equals("2 - Qual o tipo do pet (Cachorro/Gato)?")) {
                            System.out.print(line + " ");
                            String tipo = input.nextLine().toUpperCase();
                            try {
                                tipoPet = Pet.TipoPet.valueOf(tipo);
                                validInput = true;
                            } catch (InvalidEnumException e) {
                                System.out.println("\nErro: " + e.getMessage() + "\n");
                            }
                        }
                        else if (line.equals("3 - Qual o sexo do animal (Macho ou Fêmea)?")) {
                            System.out.print(line + " ");
                            String sexoStr = input.nextLine().toUpperCase();
                            try {
                                sexo = Pet.SexoPet.valueOf(sexoStr);
                                validInput = true;
                            } catch (InvalidEnumException e) {
                                System.out.println("\nErro: " + e.getMessage() + "\n");
                            }
                        }
                        else if (line.equals("4 - Onde ele foi econtrado? Numero da Casa:")) {
                            System.out.print(line + " ");
                            numeroDaCasa = input.nextLine();
                            if (HouseNumberException.regexHouseNumberError(numeroDaCasa)) {
                                throw new HouseNumberException("Escreva apenas caracteres numéricos.");
                            }
                            validInput = true;
                        }
                        else if (line.equals("5 - Onde ele foi econtrado? Cidade:")) {
                            System.out.print(line + " ");
                            cidade = input.nextLine();
                            if (HouseNumberException.regexHouseNumberError(numeroDaCasa)) {
                                throw new HouseNumberException("Escreva apenas caracteres numéricos.");
                            }
                            validInput = true;
                        }
                        else if (line.equals("6 - Onde ele foi econtrado? Rua:")) {
                            System.out.print(line + " ");
                            rua = input.nextLine();
                            validInput = true;
                        }
                        else if (line.equals("7 - Qual a idade aproximada do pet?")) {
                            System.out.print(line + " ");
                            String idadeStr = input.nextLine();
                            idade = Double.parseDouble(idadeStr);
                            if (idade == 0.0) {
                                throw new AgeException("Idade é nula, reescreva a idade");
                            }
                            if (AgeException.regexAgeError(idadeStr)) {
                                throw new AgeException("Idade escrita errada, escreva novamente");
                            }
                            validInput = true;
                        }
                        else if (line.equals("8 - Qual o peso aproximado do pet?")) {
                            System.out.print(line + " ");
                            peso = Double.parseDouble(input.nextLine());
                            validInput = true;
                        }
                        else if (line.equals("9 - Qual a raça do pet?")) {
                            System.out.print(line + " ");
                            raca = input.nextLine();
                            validInput = true;
                        }
                    } catch (FormNameException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (HouseNumberException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nErro: Entrada inválida para tipo ou sexo do pet. Tente novamente.\n");
                    }
                }
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
            System.out.println("Pet cadastrado com sucesso: " + pet.toString());
        } catch (Exception e) {
            System.out.println("\nErro ao ler o arquivo: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}