/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repaso;

/**
 *
 * @author user-
 */
public class TdaFecha {
    private int dia, mes, anio;
    private String cadenaFecha;
    
    //Constructores
    
    public TdaFecha(int dia, int mes, int anio){
        
        if(validarFecha(dia, mes, anio) == false){
            this.dia = 00;
            this.mes = 00;
            this.anio = 0000;
            this.cadenaFecha = generarCadena();
        }else{
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
            this.cadenaFecha = generarCadena();
        }
        
    }
    
    //Observadores
    
    public String getFecha(){
        return this.cadenaFecha;
    }
    
    public boolean equals(TdaFecha fecha){
        boolean igual = true;
        if(this.dia != fecha.dia){
            igual = false;
        }else{
            if(this.mes != fecha.mes){
                igual = false;
            }else{
                if(this.anio != fecha.anio){
                    igual = false;
                }else{
                    if(!this.cadenaFecha.equals(fecha.cadenaFecha)){
                        igual = false;
                    }
                }
            }
        }
        return igual;
    }
    
    public String toString(){
        String cadena;
        cadena = "\n"+String.valueOf(this.anio)+"\n"+String.valueOf(this.mes)+"\n"+String.valueOf(this.dia)+"\n";
        return cadena;
    }
    
    //Modificadores
    
    public void setFecha(int dia, int mes, int anio){
        if(validarFecha(dia, mes, anio) == false){
            this.dia = 00;
            this.mes = 00;
            this.anio = 0000;
            this.cadenaFecha = generarCadena();
        }else{
            this.dia = dia;
            this.mes = mes;
            this.anio = anio;
            this.cadenaFecha = generarCadena();
        }
    }
    
    //Propios del Tipo
    
    private String generarCadena(){
        /**Retorna los atributos de la instancia agrupados en un String 
         * de la forma "AAAAMMDD"**/
        String cadena = "", aux1;
       
        aux1 = String.valueOf(this.anio);
        while(aux1.length()<4){
            aux1 = "0"+aux1;
        }
        cadena = cadena + aux1;
        aux1 = String.valueOf(this.mes);
        while(aux1.length()<2){
            aux1 = "0"+aux1;
        }
        aux1 = "." + aux1;
        cadena = cadena + aux1;
        aux1 = String.valueOf(this.dia);
        while(aux1.length()<2){
            aux1 = "0" + aux1;
        }
        aux1 = "." + aux1;
        cadena = cadena + aux1;
        return cadena;
        
    }
    
    private boolean validarFecha(int dia, int mes, int anio){
        /**Retorna true si la fecha de la instancia es 
         * valida, retorna false en caso contrario**/
        boolean esValido = true;
        
        if(anio <= 0 || anio > 9999){
            esValido = false;
        }else{
            if(mes < 1 || mes > 12){
                esValido = false;
            }else{
                if(dia > 31 || dia < 1){
                    esValido = false;
                }else{
                    switch(dia){
                    case 31:
                        if(!(mes == 1 || mes == 3 || mes == 5 || mes == 7 || mes == 8 || mes == 10 || mes == 12)){
                            esValido = false;
                        }
                        break;
                    case 30:
                        if(mes == 2){
                            esValido = false;
                        }
                        break;
                    case 29:
                        if(anio % 4 != 0 && mes == 2){
                            esValido = false;
                        }
                        break;
                    }
                }
            }
        }
        return esValido;
    }
    
    
}
