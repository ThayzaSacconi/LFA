package analisadorSintatico;
import analisadorLexico.*;

public class MyAnalisadorSintatico extends AnalisadorSintatico {
	
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }

    public void inicio() {
	corpo(); 
	reconhece(Token.EOF);
    }
	
    public void corpo() {	
        if(proxTokenIs(Token.VAR)) {
            comandoAtribuicao();
            reconhece(Token.PT_VIRG);
            corpo();
	}
	else if(proxTokenIs(Token.EOF))
            ;
	else {
            Token[] tokensEsperados = {Token.VAR,Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
	}
    }
	
    public void comandoAtribuicao() {
	reconhece(Token.VAR);
	reconhece(Token.NUM);
	exp();
    }
	
    public void exp() {
        if(proxTokenIs(Token.NUM)) 
            leProxToken();
        else if(proxTokenIs(Token.NUM)) 
            leProxToken();
        else {
            Token[] tokensEsperados = {Token.NUM,Token.NUM};
            throw new ErroSintatico(this.scanner.tokenReconhecido,tokensEsperados);
        }
    }
}
