package analisadorLexico;

public abstract class Analisador implements Constantes {
    public String nomeArquivoEntrada;

    public Analisador(String _nomeArquivoEntrada) {
        this.nomeArquivoEntrada = _nomeArquivoEntrada;
    }

    public Analisador() {
        this.nomeArquivoEntrada = NOME_DEFAULT_ARQUIVO_ENTRADA;
    }
}