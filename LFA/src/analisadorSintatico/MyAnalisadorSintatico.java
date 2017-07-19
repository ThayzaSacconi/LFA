package analisadorSintatico;
import analisadorLexico.*;

/**
 *
 * @author Thayza , Amanda, Natalia, Fabricio
 */

public class MyAnalisadorSintatico extends AnalisadorSintatico {
	
    /**
     *
     * @param _nomeArquivoEntrada
     */
    
    public MyAnalisadorSintatico(String _nomeArquivoEntrada) {
        super(_nomeArquivoEntrada);
    }

    /**
     *função programa que pode chamar um de seus comandos(if,while,switch_case, for, do_while ou uma variável) ou pode ser vazia
     * GR: programa = comando programa | ? 
     */
    public void programa() {
	if(proxTokenIs(Token.WHILE) || proxTokenIs(Token.IF) || proxTokenIs(Token.SWITCH) 
        || proxTokenIs(Token.DO) || proxTokenIs(Token.FOR) || proxTokenIs(Token.VAR)) {
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
	
    /**
     * função comando pode ser chamada while ou if ou switch_case ou do_while ou for ou uma atribuição, seguidas das suas respectivas funções e de um programa (função anterior)
     * GR: comando = while | if | swicth_case  | do_while| for | atribuicao PT_VIRG
     */
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
            reconhece(Token.PT_VIRG);
        }
        else {
            Token[] tokensEsperados = {Token.VAR, Token.NUM, Token.EOF};
            throw new ErroSintatico(this.scanner.tokenReconhecido, tokensEsperados);
        }
    }
    
    /**
     *função exp pode receber um operador2 seguido de uma expressão e um R(operador1 seguido de uma expressão, R ou vazio) ou abre parênteses com uma expressão dentro, fecha parêntes e R, ou uma variável e R, ou um número e R, ou um sinal(-,+) seguido de um número e R
     * exp = operador2 exp R | AP exp FP R | VAR R | NUM R| SINAL NUM R
     */
    public void exp() {
        if(proxTokenIs(Token.OP_UN_BIN) || proxTokenIs(Token.OP_UN)) {
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
    
    /**
     * função R é um operador1 seguido de uma expressão e chamando a própria função R ou vazia
     * GR: R = operador1 exp R | ?
     */
    public void R() {
        if(proxTokenIs(Token.OP_UN_BIN) || proxTokenIs(Token.OP_BIN)) {
            operador1();
            exp();
            R();
        }
        else if(proxTokenIs(Token.EOF))
            reconhece(Token.EOF);
    }
    
    /**
     *função bloco abre parênteses com um programa dentro e fecha parênteses ou pode ser apenas um comando  
     * GR: bloco = AC programa FC | comando
     */
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
    
    /**
     *função while reconhece o while seguido de abre parênteses com uma expressão dentro e fecha parêntenses seguido de um bloco
     * while = WHILE AP exp FP bloco
     */
    public void funcaoWhile() {
        reconhece(Token.WHILE);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    /**
     *função if reconhece o if seguido de abre parênteses com uma expressão dentro e fecha parêntenses seguido de um bloco
     * GR: if = IF AP exp FP bloco
     */
    public void funcaoIf() {
        reconhece(Token.IF);
        reconhece(Token.AP);
        exp();
        reconhece(Token.FP);
        bloco();
    }
    
    /**
     * função switch reconhece o switch eguido de abre parênteses com uma variável dentro e fecha parênteses seguido de abre chaves com um case dentro e fecha chaves
     * GR: switch_case = SWITCH AP VAR FP AC listaCase FC
     */
    public void funcaoSwitch() {
        reconhece(Token.SWITCH);
        reconhece(Token.AP);
        reconhece(Token.VAR) ;
        reconhece(Token.FP);
        reconhece(Token.AC);
        listaCase();
        reconhece(Token.FC);
    }
    
    /**
     *função switch reconhece o switch eguido de abre parênteses com uma variável dentro e fecha parênteses seguido de abre chaves com um case dentro e fecha chaves
     * GR: switch_case = SWITCH AP VAR FP AC listaCase FC
     */
    public void listaCase() {
        if(proxTokenIs(Token.EOF)){
            reconhece(Token.EOF);
            
        }
        else if(proxTokenIs(Token.CASE)){  
            funcaoCase();
            listaCase();
        }
    }
    
    /**
     * função listaCase case pode ser uma função vazia ou um case  
     * GR: listaCase = ?  | case listaCase
     */
    public void identCase() {
        if (proxTokenIs(Token.NUM)){
            reconhece(Token.NUM);
        }
        else if(proxTokenIs(Token.VAR)){
            reconhece(Token.VAR);
        }
        else if(proxTokenIs(Token.CARACTER)){
            reconhece(Token.CARACTER);
        }
    }
    
    /**
     * função identCase pode ser um número, ou uma variável ou um caracter
     * GR: identCase = NUM | VAR| CARACTER
     */
    public void funcaoCase() {
        reconhece(Token.CASE);
        identCase();
        reconhece(Token.DOIS_PT);
        bloco();
        listaCase();
    }
    
    /**
     * função for reconhece o token for, em seguida abre parênteses com uma atribuição dentro, ponto e vírgula, depois uma expressão, ponto e vírgula, atribuição e fecha parênteses seguido de um bloco  
     * GR: for = FOR AP atribuicao PT_VIRG exp PT_VIRG atribuicao FP bloco 
     */

    public void funcaoFor() {
        reconhece(Token.FOR);
        reconhece(Token.AP);
        atribuicao();
        reconhece(Token.PT_VIRG);
        exp();
        reconhece(Token.PT_VIRG);
        if(proxTokenIs(Token.IGUAL)) {
            atribuicao();  
        }
        else if(proxTokenIs(Token.INCREMENTO)) {
            reconhece(Token.INCREMENTO);
        }
        else if(proxTokenIs(Token.DECREMENTO)) {
            reconhece(Token.DECREMENTO);
        }
        
        reconhece(Token.FP);
        bloco();
    }
    
    /**
     *função atribuição pode ser uma variável ou igual seguido de uma expressão  
     * GR: atribuicao = VAR IGUAL exp
     */
    public void atribuicao() {
        reconhece(Token.VAR);
        reconhece(Token.IGUAL);
        exp();
    }
    
    /**
     * função operador1 que pode ser um operador unário binário ou só um operador binário
     * GR: operador1 = OP_UN_BIN | OP_BIN
     */
    public void operador1() {
        if (proxTokenIs(Token.OP_UN_BIN)){
            reconhece(Token.OP_UN_BIN);
        }
        else if (proxTokenIs(Token.OP_BIN)){
            reconhece(Token.OP_BIN);
        }
    }

    /**
     * função operador2 que pode ser um operador unário binário ou só um operador unário 
     * GR: operador2 = OP_UN_BIN | OP_UN
     */
    public void operador2() {
        if (proxTokenIs(Token.OP_UN_BIN)){
            reconhece(Token.OP_UN_BIN);
        }
        else if (proxTokenIs(Token.OP_UN)){
            reconhece(Token.OP_UN);
        }
    }
    
    /**
     * função DoWhile reconhece o token DO seguido de um abre chaves com um bloco dentro e fecha chaves, depois um while, abre parênteses com uma expressão dentro e fecha parênteses
     * GR: do_while = DO AC bloco FC WHILE AP exp FP
     */
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