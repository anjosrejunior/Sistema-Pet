public class Pet {
    private String nomeESobrenome;
    private TipoPet tipoPet;
    private SexoPet sexo;
    private String numeroDaCasa;
    private String cidade;
    private String rua;
    private int idade;
    private double peso;
    private String raca;

    public Pet(String nomeESobrenome, TipoPet tipoPet, SexoPet sexo, String numeroDaCasa, String cidade, String rua, int idade, double peso, String raca) {
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

//        public static TipoPet chooseAnimal(String answer){
//            if (answer == null) {
//                return TipoPet.NaoInformado; // Tratamento para entrada nula
//            }
//            if (answer.equalsIgnoreCase("Cachorro")) {
//                return TipoPet.CACHORRO;
//            } else if (answer.equalsIgnoreCase("Gato")) {
//                return TipoPet.GATO;
//            }
//            return TipoPet.NaoInformado; // Valor padrão para entradas inválidas
//        }
    }
//
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

//        public static SexoPet chooseSexAnimal(String sexo){
//            if (sexo.equalsIgnoreCase("macho")) {
//                return MACHO;
//            } else if (sexo.equalsIgnoreCase("femea")) {
//                return FEMEA;
//            }
//            return NAOINFORMADO;
//        }
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

    public int getIdade() {
        return idade;
    }

    public double getPeso() {
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
