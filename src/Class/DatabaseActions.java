package Class;

import javax.sound.midi.SysexMessage;
import java.io.*;
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

    public static void readFiles() {
        String PET_DIR = "petsCadastrados\\";
        File[] arquivos = null;
        try {
            File dir = new File(PET_DIR);
            if (!dir.exists() || !dir.isDirectory()) {
                throw new FileNotFoundException("Diretório de pets não encontrado.");
            }
            arquivos = dir.listFiles();
            if (arquivos == null || arquivos.length == 0) {
                throw new FileNotFoundException("Nenhum arquivo pet encontrado.");
            }
        } catch (FileNotFoundException e) {
            System.out.println("\nErro: " + e.getMessage() + "\n");
        } catch (IOException e) {
            e.printStackTrace();
        }

        for (File arquivo : arquivos) {
            if (arquivo.isFile()) {
                try (BufferedReader bfr = new BufferedReader(new FileReader(arquivo))){
                    String linha;
                    while ((linha = bfr.readLine()) != null){
                        System.out.println(linha);
                    }
                } catch (IOException e) {
                    System.out.println("Erro ao ler o arquivo: " + arquivo.getName());
                }
            }
        }
    }
}
