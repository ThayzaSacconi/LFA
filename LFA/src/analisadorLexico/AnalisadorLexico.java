package analisadorLexico;
import java.io.FileReader;
import java.io.IOException;

public class AnalisadorLexico extends Analisador {
    protected char proxCaractere;  // caractere disponível no cabeçote de leitura
    protected int linha = 1;  // linha atual do arquivo fonte
    protected StringBuffer entrada = new StringBuffer(); // armazena o conteúdo do arquivo
    protected int posicao = 0; // posição do caractere a ser lido na entrada  
    public Token tokenReconhecido; // último token lido

    // transfere o arquivo para o buffer ‘entrada’
    public AnalisadorLexico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
        try {
            FileReader file = new FileReader(_nomeArquivoEntrada);
            int c;
            while((c = file.read()) != -1) {
                this.entrada.append((char)c);
            }
            file.close();
            leProxCaractere();
        } catch (IOException e) {
            throw new RuntimeException("Erro de leitura no arquivo " + _nomeArquivoEntrada);
        }
    }
  
    public void leProxCaractere() { // lê o próximo caractere do buffer. Se for o fim, retorna EOF
        try {
            this.proxCaractere = this.entrada.charAt(this.posicao++); // avança o ponteiro de leitura 1 posição
        } catch(IndexOutOfBoundsException e) {
            this.proxCaractere = EOF;
        }
    }
	
    // verifica se o próximo caractere é um dos que estão em ‘s’
    // N O avança o ponteiro de leitura
    public boolean proxCaractereIs(String s) {
        if (s.indexOf(this.proxCaractere) != -1)
            return true;
        else
            return false;
    }
}