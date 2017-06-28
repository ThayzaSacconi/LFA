package analisadorLexico;

public class ErroLexico extends RuntimeException {
    private char caractereEncontrado;
    private String caracteresEsperados;
 
    public ErroLexico(char _caracterEncontrado, String _caracteresEsperados) {
        this.caractereEncontrado = _caracterEncontrado;
        this.caracteresEsperados = _caracteresEsperados;
    }

    public String toString() {
        return "Caractere encontrado: " + ((char)this.caractereEncontrado) + "\n Era(m) esperado(s): " + this.caracteresEsperados;
    }
}
