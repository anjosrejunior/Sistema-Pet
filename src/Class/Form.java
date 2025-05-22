package Class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

import Exceptions.*;

public class Form {
    static Scanner input = new Scanner(System.in);

    static private String nomeESobrenome;
    static private Pet.TipoPet tipoPet;
    static private Pet.SexoPet sexo;
    static private String numeroDaCasa;
    static private String cidade;
    static private String rua;
    static private String idade;
    static private String peso;
    static private String raca;

    public static void formAnswer() {
        File form = new File("C:\\Users\\Nato\\Estudos-DEV\\Sistema-Pet\\assets\\formulario.txt");

        try (BufferedReader bf = new BufferedReader(new FileReader(form))) {
            String line;
            while ((line = bf.readLine()) != null) {
                boolean validInput = false;
                while (!validInput) {
                    try {
                        if (line.equals("1 - Qual o nome e sobrenome do pet?")) {
                            System.out.print(line + " ");
                            nomeESobrenome = input.nextLine();
                            if (nomeESobrenome.isBlank()) {
                                nomeESobrenome = "NÃO INFORMADO";
                            } else if (FormNameException.regexNameError(nomeESobrenome)) {
                                throw new FormNameException("Nome escrito errado, escreva novamente");
                            }
                            validInput = true;
                        } else if (line.equals("2 - Qual o tipo do pet (Cachorro/Gato)?")) {
                            System.out.print(line + " ");
                            String tipo = input.nextLine().toUpperCase();
                            try {
                                tipoPet = Pet.TipoPet.valueOf(tipo);
                                validInput = true;
                            } catch (InvalidEnumException e) {
                                System.out.println("\nErro: " + e.getMessage() + "\n");
                            }
                        } else if (line.equals("3 - Qual o sexo do animal (Macho ou Fêmea)?")) {
                            System.out.print(line + " ");
                            String sexoStr = input.nextLine().toUpperCase();
                            try {
                                sexo = Pet.SexoPet.valueOf(sexoStr);
                                validInput = true;
                            } catch (InvalidEnumException e) {
                                System.out.println("\nErro: " + e.getMessage() + "\n");
                            }
                        } else if (line.equals("4 - Onde ele foi econtrado? Numero da Casa:")) {
                            System.out.print(line + " ");
                            numeroDaCasa = input.nextLine();
                            if (numeroDaCasa.isBlank()) {
                                numeroDaCasa = "NÃO INFORMADO";
                            }
                            else if (AdressException.regexHouseNumberError(numeroDaCasa)) {
                                throw new AdressException("Escreva apenas caracteres numéricos.");
                            }
                            validInput = true;
                        } else if (line.equals("5 - Onde ele foi econtrado? Cidade:")) {
                            System.out.print(line + " ");
                            cidade = input.nextLine();
                            if (cidade.isBlank()) {
                                cidade = "NÃO INFORMADO";
                            } else if (AdressException.regexCityAndStreetError(cidade)) {
                                throw new AdressException("Escreva a Cidade apenas utilizando letras maíusculas o minúsculas");
                            }
                            validInput = true;
                        } else if (line.equals("6 - Onde ele foi econtrado? Rua:")) {
                            System.out.print(line + " ");
                            rua = input.nextLine();
                            if (rua.isBlank()) {
                                rua = "NÃO INFORMADO";
                            } else if (AdressException.regexCityAndStreetError(rua)) {
                                throw new AdressException("Rua inválida, utilize apenas letras maíusculas e minúsculas");
                            }
                            validInput = true;
                        } else if (line.equals("7 - Qual a idade aproximada do pet?")) {
                            System.out.print(line + " ");
                            idade = input.nextLine();
                            if (idade.isBlank()) {
                                idade = "NÃO INFORMADO";
                                break;
                            } else if (Double.parseDouble(idade) <= 0.0 || Double.parseDouble(idade) > 20.0) {
                                throw new AgeOrWeightException("Idade inválida, permitido apenas entre (0.1) Mêses ou (20.0) Anos.");
                            } else if (AgeOrWeightException.regexOnlyNumberError(idade)) {
                                throw new AgeOrWeightException("Idade inválida, utilize apenas numeros!");
                            }
                            validInput = true;
                        } else if (line.equals("8 - Qual o peso aproximado do pet?")) {
                            System.out.print(line + " ");
                            peso = input.nextLine();
                            if (peso.isBlank()) {
                                peso = "NÃO INFORMADO";
                            } else if (Double.parseDouble(peso) < 0.5 || Double.parseDouble(peso) > 60.0) {
                                throw new AgeOrWeightException("Peso inválido, permitido apenas entre (0.5) ou (60.0) KG");
                            } else if (AgeOrWeightException.regexOnlyNumberError(peso)) {
                                throw new AgeOrWeightException("Idade escrita errada, escreva novamente");
                            }
                            validInput = true;
                        } else if (line.equals("9 - Qual a raça do pet?")) {
                            System.out.print(line + " ");
                            raca = input.nextLine();
                            if (raca.isBlank()) {
                                raca = "NÃO INFORMADO";
                            } else if (RaceException.regexRaceError(raca)) {
                                throw new RaceException("Raça inválida, utilize apenas letras maiúsculas e minúculas!");
                            }
                            validInput = true;
                        }

                    } catch (RaceException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (AgeOrWeightException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (AdressException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (FormNameException e) {
                        System.out.println("\nErro: " + e.getMessage() + "\n");
                    } catch (IllegalArgumentException e) {
                        System.out.println("\nErro: Entrada inválida. Tente novamente.\n");
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

            Pet.imprimirRepostaForm(pet,tipoPet,sexo);
        } catch (Exception e) {
            System.out.println("\nErro ao ler o arquivo: " + e.getMessage() + "\n");
            e.printStackTrace();
        }
    }
}