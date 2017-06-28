package analisadorLexico;
import java.io.IOException;
 
public class MyAnalisadorLexico extends AnalisadorLexico {
    public MyAnalisadorLexico(String _nomeArquivoEntrada) {
	super(_nomeArquivoEntrada);
    }

    public void q0() {
	if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q1();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q6();
	}
	else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q8();
        }
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q10();
        }
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q16();
        }
	else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q20();
        }
        else if(this.proxCaractere == PT_VIRG) {
            leProxCaractere();
            q23();
        }
        else if(this.proxCaractere == AP) {
            leProxCaractere();
            q24();
        }
        else if(this.proxCaractere == FP) {
            leProxCaractere();
            q25();
        }
        else if(this.proxCaractere == AC) {
            leProxCaractere();
            q26();
        }
        else if(this.proxCaractere == FC) {
            leProxCaractere();
            q27();
        }
        else if(this.proxCaractere == DOIS_PT) {
            leProxCaractere();
            q28();
        }
        else if(this.proxCaractere == IGUAL) {
            leProxCaractere();
            q30();
        }
        else if(this.proxCaractere == OP_UN) {
            leProxCaractere();
            q31();
        }
        else if((this.proxCaractere == MAIS) || (this.proxCaractere == MENOS)) {
            leProxCaractere();
            q33();
        }
        else if(this.proxCaractereIs(NUM)) {
            leProxCaractere();
            q37();
        }
        else if(this.proxCaractere == ASTERISCO) {
            leProxCaractere();
            q45();
        }
        else if(this.proxCaractere == BARRA) {
            leProxCaractere();
            q45();
        }
        else if(this.proxCaractere == PT) {
            leProxCaractere();
            q38();
        }
        else if(this.proxCaractere == COMERCIAL) {
            leProxCaractere();
            q32();
        }
        else if(this.proxCaractereIs(ASPA) ) {
            leProxCaractere();
            q34();
        }
        else if(this.proxCaractere == BARRA_OU) {
            leProxCaractere();
            q41();
        }
        else if((this.proxCaractere == MAIOR) || (this.proxCaractere == MENOR) || (this.proxCaractere == OP_UN)) {
            leProxCaractere();
            q43();
        }
	else {
            throw new ErroLexico(this.proxCaractere, CARACTER + VAR + NUM + WHILE + FOR + IF + SWITCH + CASE + DO);
	}
    }
    
    public void q1() {
	this.tokenReconhecido = Token.VAR;
	if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q2();
        }
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q2() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q3();
	}
	else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
	}
    }
	
    public void q3() {
	this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q4();
	}
	else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
	}
    }
    
    public void q4() {
	this.tokenReconhecido = Token.VAR;
	if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q5();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q5() { 
	this.tokenReconhecido = Token.WHILE;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
	}
    }

    public void q6() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q7();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q7() {
        this.tokenReconhecido = Token.DO;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q8() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q9();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q9() {
        this.tokenReconhecido = Token.IF;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q10() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q11();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q11() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q12();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q12() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q13();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q13() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q14();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q14() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q15();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q15() {
        this.tokenReconhecido = Token.SWITCH;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q16() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q17();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q17() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q18();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q18() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q19();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q19() {
        this.tokenReconhecido = Token.CASE;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q20() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q21();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q21() {
        this.tokenReconhecido = Token.VAR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q22();
	}
        else if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q22() {
        this.tokenReconhecido = Token.FOR;
        if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q23() {
        this.tokenReconhecido = Token.PT_VIRG;
    }
    
    public void q24() {
        this.tokenReconhecido = Token.AP;
    }
    
    public void q25() {
        this.tokenReconhecido = Token.FP;
    }
    
    public void q26() {
        this.tokenReconhecido = Token.AC;
    }
    
    public void q27() {
        this.tokenReconhecido = Token.FC;
    }
    
    public void q28() {
        this.tokenReconhecido = Token.DOIS_PT;
    }
    
    public void q29() {
	this.tokenReconhecido = Token.VAR;
	if(this.proxCaractereIs(VAR)) {
            leProxCaractere();
            q29();
        }
    }
    
    public void q30() {
        this.tokenReconhecido = Token.IGUAL;
    }
    
    public void q31() {
        this.tokenReconhecido = Token.OP_UN;
    }
    
    public void q32() {
        if(this.proxCaractere == COMERCIAL) {
            leProxCaractere();
            q40();
        }
    }
    
    public void q33() {
        this.tokenReconhecido = Token.OP_UN_BIN;
    }
    
    public void q34() {
        if(this.proxCaractereIs(VAR) || this.proxCaractereIs(NUM)) {
            leProxCaractere();
            q35();
        }
    }
    
    public void q35() {
        if(this.proxCaractereIs(ASPA)) {
            leProxCaractere();
            q36();
        }
    }
    
    public void q36() {
        this.tokenReconhecido = Token.CARACTER;
    }
    
    public void q37() {
        this.tokenReconhecido = Token.NUM;
        if​(this​.proxCaractereIs(NUM)) {
            leProxCaractere();
            q37(); //na máquina, esse estado precisa ser final pra tirar o que sai de q0 direto pro q39
        }
        else if​(this​.proxCaractere == PT) {
            leProxCaractere();
            q38();
        }
    }
    
    public void q38() {
        if​(this​.proxCaractereIs(NUM)) {
            leProxCaractere();
            q39();
        }
    }
    
    public void q39() {
        this.tokenReconhecido = Token.NUM;
        if​(this​.proxCaractereIs(NUM)) {
            leProxCaractere();
            q39();
        }
    }
    
    public void q40() {
        this.tokenReconhecido = Token.OP_BIN;
    }
    
    public void q41() {
        if​(this​.proxCaractere == BARRA_OU) {
            leProxCaractere();
            q42();
        }
    }
    
    public void q42() {
        this.tokenReconhecido = Token.OP_BIN;
    }
    
    public void q43() {
        if​(this​.proxCaractere == IGUAL) {
            leProxCaractere();
            q44();
        }
    }
    
    public void q44() {
        this.tokenReconhecido = Token.OP_BIN;
    }
    
    public void q45() {
        this.tokenReconhecido = Token.OP_BIN;
    }
}