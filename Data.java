/*
Autor: Mateus Santos e Silva
DRE: 115065935
lab 3 - Classe Data para validar data.
*/
//constroi Data




//ACHO QUE VOCÊ PODERIA TRABALHAR MAIS OS ESPAÇOS PARA DAR CLAREZA AO CÓDIGO



public class Data {
	private int dia, mes, ano;
    //verifica se o ano é valido
    public int anoValido (int ano){
        if (ano!=0 && ano>0) return 1;
        else return 0;
    }
    //verifica se o ano é bissexto
    public int anoBissex (int ano) {
        if (ano%4==0 && (ano%100!=0 || ano%400==0)) return 1;
        else return 0;
    }
    //verifica se o mes é valido
    public int mesValido(int mes){
        int a;
        a = (mes>12 || mes<1) ? 0 : 1;
        return a;
    }
    //verifica se o dia é valido
    public int diaValido(int dia, int mes){
        if (dia>31||dia<1) return 0;
        else if ((mes == 4 || mes == 6 || mes == 9 || mes == 11)&&(dia>30)) return 0;
        else return 1;
    }
    //verifica somente em caso de pedir o mes 2
    public int fevereiro (int dia, int mes, int ano) {
        int a = anoBissex(ano);
        if (mes == 2 && dia <= 29 && a == 1) return 1;
        else if(mes!=2) return 1;
        else if (mes == 2 && dia <=28 && a == 0) return 1;
        else return 0;
    } 
    //garante que a data é valida ou invalida
    public int avaliaData (int dia, int mes, int ano) {
        int a, b, c, d;
        a = anoValido(ano);
        b = mesValido(mes);
        c = diaValido(dia, mes);
        d = fevereiro(dia, mes, ano);
        if (a == 1 && b == 1 && c == 1 && d == 1) return 1;
        else return 0;
    }
    //modifica os valores privados de dia, mes e ano e retorna
    //Data Válida + Data
    //ou
    //Erro + Data Inválida
    public int setData (int dia, int mes, int ano) throws Exception{
 
    	if (avaliaData(dia,mes,ano) == 1) {
    		this.dia = dia;
    		this.mes = mes;
    		this.ano = ano;
    		validoOuInvalido();//diz que a data é valida
    	}
    	else  {
    		throw new Exception ("Data Inválida");//mostra erro
    	}
    	return 0;
    }
    //retorna os valores desejados em String
    public String toString () {
    	return ("" + dia +" " + mes + " " + ano);
    }
    //informa se a data é valida ou não
    public boolean validoOuInvalido () {
    	if (avaliaData(this.dia, this.mes, this.ano) == 1) {
    			System.out.println("Data Válida");
    			return true;
    		}
    	else { 
    			System.out.println("Data Inválida");
    			return false;
    		}
     }
}
