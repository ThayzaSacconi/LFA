package analisadorSintatico;
import analisadorLexico.*;

/**
 *
 * @author Thayza
 */

public class TesteAnalisadorSintatico {
	
    /**
     *
     */
    static public MyAnalisadorSintatico parser;
	
    /**
     *
     * @param args
     */
    
    public static void main(String[] args) {
        new Saida().setVisible(true);
        
	try {
            if(args.length != 1)
		throw new RuntimeException("esqueceu de escrever o nome do arquivo de entrada! \n" + 
                                           "No Eclipse insira em: Run - Open Run Dialog - Arguments");
		parser = new MyAnalisadorSintatico(args[0]);
		parser.programa();
		System.out.println("Análise realizada com sucesso no arquivo " + parser.nomeArquivoEntrada);
	} catch(ErroLexico e) {
            System.out.println("Erro léxico: " + e.toString());
        } catch(ErroSintatico e) {
            System.out.println("Erro sintático: " + e.toString());
	} catch(RuntimeException e) {
            System.out.println("Erro: " + e.getMessage());
	}
    }
}
