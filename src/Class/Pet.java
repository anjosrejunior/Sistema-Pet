package Class;

public class Pet {
    private final String nomeESobrenome;
    private TipoPet tipoPet;
    private SexoPet sexo;
    private final String numeroDaCasa;
    private final String cidade;
    private final String rua;
    private final String idade;
    private final String peso;
    private final String raca;

    public Pet(String nomeESobrenome, TipoPet tipoPet, SexoPet sexo, String numeroDaCasa, String cidade, String rua, String idade, String peso, String raca) {
        this.nomeESobrenome = nomeESobrenome;
        this.tipoPet = tipoPet;
        this.sexo = sexo;
        this.numeroDaCasa = numeroDaCasa;
        this.cidade = cidade;
        this.rua = rua;
        this.idade = idade;
        this.peso = peso;
        this.raca = raca;
    }

    public enum TipoPet{
        NaoInformado("NÃO INFORMADO"),
        CACHORRO("Cachorro"),
        GATO("Gato");

        private String tipo;

        TipoPet(String tipo) {
            this.tipo = tipo;
        }

        public String getTipo(TipoPet tipoPet) {
            return tipo;
        }
    }

    public enum SexoPet{
        NAOINFORMADO("Não informado"),
        MACHO("Macho"),
        FEMEA("Fêmea");

        private String sex;

        SexoPet(String sex) {
            this.sex = sex;
        }

        public String getSex(SexoPet sexPet){
            return sex;
        }
    }

    public String getNomeESobrenome() {
        return nomeESobrenome;
    }

    public TipoPet getTipoPet() {
        return tipoPet;
    }

    public SexoPet getSexo() {
        return sexo;
    }

    public String getNumeroDaCasa() {
        return numeroDaCasa;
    }

    public String getCidade() {
        return cidade;
    }

    public String getRua() {
        return rua;
    }

    public String getIdade() {
        return idade;
    }

    public String getPeso() {
        return peso;
    }

    public String getRaca() {
        return raca;
    }

    public static void cadastroPet(){
        Form.formAnswer();
    }

    public static void imprimirRepostaForm(Pet pet, TipoPet petType, SexoPet sexPet){
        System.out.println("\n--- Informações do Pet ---");
        System.out.println("Nome e Sobrenome do Pet: " + pet.getNomeESobrenome());
        System.out.println("Tipo do Pet: " + petType.getTipo(pet.getTipoPet()));
        System.out.println("Sexo animal: " + sexPet.getSex(pet.getSexo()));
        System.out.println("Idade do Pet: " + pet.getIdade());
        System.out.println("Peso do Pet: " + pet.getPeso());
        System.out.println("Raça do Pet: " + pet.getRaca());
        System.out.println("--- Endereço ---");
        System.out.println("Número da Casa: " + pet.getNumeroDaCasa());
        System.out.println("Cidade: " + pet.getCidade());
        System.out.println("Rua: " + pet.getRua());
    }
}
