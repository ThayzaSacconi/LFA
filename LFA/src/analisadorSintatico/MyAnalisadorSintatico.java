package analisadorSintatico;
import analisadorLexico.*;

public class MyAnalisadorSintatico extends AnalisadorSintatico {
	
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }

    public void programa() {
	if(proxTokenIs(Token.WHILE) || proxTokenIs(Token.IF) || proxTokenIs(Token.SWITCH) 
        || proxTokenIs(Token.CASE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || proxTokenIs(Token.VAR)) {
            comando(); 
        }
        else if(proxTokenIs(Token.EOF)) {
            reconhece(Token.EOF);
        }
        else {
            Token[] tokensEsperados = {Token.VAR, Token.NUM, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }
	
    public void comando() {
        if(proxTokenIs(Token.WHILE)) {
            funcaoWhile();
            programa();
        }
        else if(proxTokenIs(Token.IF)) {
            funcaoIf();
            programa();
        }
        else if(proxTokenIs(Token.SWITCH)) {
            funcaoSwitch();
            programa();
        }
        else if(proxTokenIs(Token.CASE)) {
            funcaoCase();
            programa();
        }
        else if(proxTokenIs(Token.DO)) {
            funcaoDoWhile();
            programa();
        }
        else if(proxTokenIs(Token.FOR)) {
            funcaoFor();
            programa();
        }
        else if(proxTokenIs(Token.EOF)) {
            reconhece(Token.EOF);
        }
        else if(proxTokenIs(Token.VAR)) {
            atribuicao();
        }
        else {
            Token[] tokensEsperados = {Token.VAR, Token.NUM, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }
    
    public void exp() {
        if(proxTokenIs(Token.OP_UN_BIN) || proxTokenIs(Token.OP_BIN)) {
            operador2();
            exp();
            R();
        }
        else if(proxTokenIs(Token.AP)) {
            reconhece(Token.AP);
            exp();
            reconhece(Token.FP);
            R();
        }
        else if(proxTokenIs(Token.VAR)) {
            reconhece(Token.VAR);
            R();
        }
        else if(proxTokenIs(Token.NUM)) {
            reconhece(Token.NUM);
            R();
        }
        else if(proxTokenIs(Token.OP_UN_BIN)) { //aqui é sinal: apenas + ou -. Então é OP_UN_BIN
            reconhece(Token.OP_UN_BIN);
            reconhece(Token.NUM);
            R();
        }
    }
    
    public void R() {
        if(proxTokenIs(Token.OP_UN_BIN) || proxTokenIs(Token.OP_BIN)) {
            operador1();
            exp();
            R();
            reconhece(Token.PT_VIRG);
        }
        else if(proxTokenIs(Token.EOF))
            ;
    }
    
    public void bloco() {
        if(proxTokenIs(Token.AC)) {
            reconhece(Token.AC);
            programa();
            reconhece(Token.FC);
        }
        else if(proxTokenIs(Token.WHILE) || proxTokenIs(Token.IF) || proxTokenIs(Token.SWITCH) 
        || proxTokenIs(Token.CASE) || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR)) {
            comando();
        }
    }
    
    public void funcaoWhile() {
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    public void funcaoIf() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    public void funcaoSwitch() {
        reconhece(Token.SWITCH);
        reconhece(Token.AP);
        reconhece(Token.VAR) ;
        reconhece(Token.FP);
        reconhece(Token.AC);
        listaCase();
        reconhece(Token.FC);
    }
    
    public void listaCase() {
        funcaoCase();
        reconhece(Token.EOF);
    }
    
    public void identCase() {
        reconhece(Token.NUM);
        reconhece(Token.VAR);
        reconhece(Token.CARACTER);
    }
    
    public void funcaoCase() {
        reconhece(Token.CASE);
        identCase();
        reconhece(Token.DOIS_PT);
        bloco();
        listaCase();
    }
    
    public void funcaoFor() {
        reconhece(Token.FOR);
        reconhece(Token.AP);
        atribuicao();
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.PT_VIRG);
        atribuicao();
        reconhece(Token.FP);
        bloco();
    }
    
    public void atribuicao() {
        reconhece(Token.VAR);
        reconhece(Token.IGUAL);
        exp();
        reconhece(Token.PT_VIRG);
    }
    
    public void operador1() {
        reconhece(Token.OP_UN_BIN);
        reconhece(Token.OP_BIN);
    }

    public void operador2() {
        reconhece(Token.OP_UN_BIN);
        reconhece(Token.OP_UN);
    }
    
    public void funcaoDoWhile() {
        reconhece(Token.DO);
        reconhece(Token.AC);
        bloco();
        reconhece(Token.FC);
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        reconhece(Token.PT_VIRG);
    }
}