public class  Candidatos {
    private String _nome, _numero;
    private int _votos;
    public int incrementarVotos;

    public Candidatos(){

    }

    public Candidatos(String nome, String numero){
        this._nome = nome;
        this._numero = numero;
        this._votos = 0;
    }

        public String getNome(){
            return _nome;
        }

        public String getNumero(){
            return _numero;
        
        }

        public int getVotos(){
            return _votos;
        }

        public void incrementarVotos(){
            this._votos++;
        }

      
 }
