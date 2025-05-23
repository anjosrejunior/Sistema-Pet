package Class;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.*;
import java.time.format.DateTimeFormatter;

public class DatabaseActions {

    public static void createPetFile(){
        Form.formAnswer();
    }

    public static void savePetFile(Pet pet) {
        LocalDateTime nowTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("ddMMyyyy'T'HHmm");
        String nowTimeStr = nowTime.format(formatter);
        String fileNamePattern = nowTimeStr + "-" + pet.getNomeESobrenome().toUpperCase();

        try (BufferedWriter bfw = new BufferedWriter(new FileWriter("C:\\Users\\Nato\\Estudos-DEV\\Sistema-Pet\\petsCadastrados\\" + fileNamePattern + ".txt"))){
            bfw.write("1 - " + pet.getNomeESobrenome());
            bfw.newLine();
            bfw.write("2 - " + pet.getTipoPet());
            bfw.newLine();
            bfw.write("3 - " + pet.getSexo());
            bfw.newLine();
            bfw.write("4 - " + pet.getRua() + ", " + pet.getNumeroDaCasa() + ", " + pet.getCidade());
            bfw.newLine();
            bfw.write("5 - " + pet.getIdade() + " anos");
            bfw.newLine();
            bfw.write("6 - " + pet.getPeso() + "KG");
            bfw.newLine();
            bfw.write("7 - " + pet.getRaca());
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("Ficha de inscrição do Pet cadastrada com Sucesso!");
    }
}
