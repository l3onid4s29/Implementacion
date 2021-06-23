
package test;

import dominio.Estudiante;
import java.util.Scanner;


public class TestPrueba {
     static Scanner datos = new Scanner(System.in);
    public static void main(String[] args) {
        int nroHombres;  
        System.out.print("Cuantos estudiantes desea ingresar: ");
        int n= datos.nextInt();
        Estudiante [] estudiantes = new Estudiante[n];
        llenaEstudiante(estudiantes);
        for(int i=0;i<estudiantes.length;i++){
            System.out.println(estudiantes[i].getNombre()+" "+estudiantes[i].getSexo()+
                    "  "+estudiantes[i].getNota());
        }
        
        nroHombres = porcentajegenero(estudiantes);    
        System.out.println("Porcentaje hombres + promedio "+porcentajePromedio(estudiantes, nroHombres, 'm'));
        System.out.println("Porcentaje mujeres + promedio "+porcentajePromedio(estudiantes, nroHombres, 'f'));
        
    }
    public static void llenaEstudiante(Estudiante est[]){
        String nombre;
        char sexo;
        double nota;
        for(int i=0;i<est.length;i++){
            datos.nextLine();
            System.out.println("Estudiante No "+(i+1));
            System.out.print("Nombre: ");
            nombre = datos.nextLine();
            System.out.println("Sexo: <<m>><<f>> ");
            sexo = datos.next().charAt(0);
            System.out.print("Nota : ");
            nota = datos.nextDouble();
            est[i] = new Estudiante(nombre,sexo,nota);            
        }
    }
    public static int porcentajegenero(Estudiante est[]){
        int cuentahombres=0,cuentamujeres=0;
        double porc;
        for(int i=0;i<est.length;i++){
            if(est[i].getSexo()=='m'){
                cuentahombres++;
            }
        }
        cuentamujeres = est.length-cuentahombres;
        System.out.println("Porcentaje hombres ="+(cuentahombres*100/est.length));
        System.out.println("Porcentaje mujeres ="+(cuentamujeres*100/est.length));
        return cuentahombres;
    }
    public static double porcentajePromedio(Estudiante est[],int nh,char sex){
        double promedio=0,ph,pm;
        int cuenta=0,nm;
        nm = est.length-nh;
        for(int i=0;i<est.length;i++)
            promedio+=est[i].getNota();
        promedio = promedio/est.length;
        //saco el porcentaje
        ph = nh*100/est.length;
        pm = (est.length-nh)*100/est.length;
        for(int i=0;i<est.length;i++){
            if(est[i].getSexo()==sex && est[i].getNota()>promedio){
                cuenta++;
            }
        }
        if(sex=='m'){
             ph = cuenta*ph/nh;
             return ph;
        }
        else{
            pm = cuenta*pm/nm;
        }
        return pm;
    }
}
