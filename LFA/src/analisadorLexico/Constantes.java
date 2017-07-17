package analisadorLexico;

public interface Constantes {
    enum Token { CARACTER, VAR, NUM, WHILE, FOR, IF, SWITCH, CASE, DO, OP_UN, OP_BIN, OP_UN_BIN, EOF, AP, FP, AC, FC, 
                 PT_VIRG, DOIS_PT, PT, IGUAL, VAZIOS, ASPA, INCREMENTO, DECREMENTO };
    
    String  CARACTER = "'abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMOPQRSTUVWXYZ'",
            VAR = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMOPQRSTUVWXYZ",
            NUM = "0123456789",
            WHILE = "while",
            FOR = "for",
            IF = "if",
            SWITCH = "switch",
            CASE = "case",
            DO = "do",
            ASPA = "'",
            VAZIOS = "\r\n\t" ;
 
    char    ASTERISCO = '*',
            BARRA = '/',
            BARRA_OU = '|',
            COMERCIAL = '&',
            MAIOR = '>',
            MENOR = '<',
            PORCENTO = '%',
            MAIS = '+',
            MENOS = '-',
            EOF = 0,
            AP = '(',
            FP = ')',
            AC = '{',
            FC = '}',
            OP_UN = '!',
            PT_VIRG = ';',
            DOIS_PT = ':',
            PT = '.',
            IGUAL = '=';
 
    String NOME_DEFAULT_ARQUIVO_ENTRADA = "entradaTeste.txt";
}
