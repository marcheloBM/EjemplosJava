/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentacion;
import datos.Lector;
import java.io.*;
import Listas.*;
import java.util.*;
import Entidades.*;

public class Ejecutar {
    
    public static void main(String[] args) throws IOException {
        Emp_planilla emp_planilla;
        Emp_eventual emp_eventual;
        Medico medico;
        Paciente paciente;
        Cita cita;
        HistoriaClinica historiaClinica;
        Lista_cita lista_cita=new Lista_cita();
        Lista_eventual lista_eventual=new Lista_eventual();
        Lista_historia lista_historia=new Lista_historia();
        Lista_medico lista_medico=new Lista_medico();
        Lista_paciente lista_paciente=new Lista_paciente();
        Lista_planilla lista_planilla=new Lista_planilla();
        int opc=0, hora, minutos;
        String dni, nombre, apellido, direccion, ciudad, codigo, area, cargo;
        String especialidad, servicio, nro_historia, sexo, grupo_sanguineo, medicamentos;
        String cod_empleado, cod_medico, diagnostico;
        int horas_extra, dia, mes, año, nro_consultorio;
        double salario, porcentaje, pagohora, horasnormales;
        GregorianCalendar fecha=new GregorianCalendar();
        GregorianCalendar fecha_ingreso=new GregorianCalendar();
        GregorianCalendar fecha_termino=new GregorianCalendar();
        do{
            System.out.println("\n..:::::: Sistema Hospital ::::::..\n"+
                    "\n [1]. Registrar Empleado Planilla"+
                    "\n [2]. Registrar Empleado Eventual"+
                    "\n [3]. Registrar Medico"+
                    "\n [4]. Registrar Paciente"+
                    "\n [5]. Registrar Cita"+
                    "\n [6]. Registrar Historial Clinico"+
                    "\n [7]. Listar Medicos desc"+
                    "\n [8]. Lista pacientes por medico"+
                    "\n [9]. Salir...");
            do{
                opc=Integer.parseInt(Lector.leer("Ingrese opcion: "));
            }while(opc<=0 || opc>9);
            switch(opc){
                case 1: // registrar Planilla
                    emp_planilla=new Emp_planilla();
                    System.out.println("\n Registro Empleado planilla:\n");  
                    do{
                        dni=Lector.leer("Dni: ");
                    }while(lista_planilla.buscar_dni(dni)>=0 || lista_eventual.buscar_dni(dni)>=0
                            || lista_medico.buscar_dni(dni)>=0 || lista_paciente.buscar_dni(dni)>=0);
                    nombre=Lector.leer("Nombre: ");
                    apellido=Lector.leer("Apellido: ");
                    do{
                        System.out.println("\n Fecha de nacimiento: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha=new GregorianCalendar(año, mes, dia);
                    direccion=Lector.leer("Direccion: ");
                    ciudad=Lector.leer("Ciudad: ");
                    do{
                        codigo=Lector.leer("Codigo: ");
                    }while(lista_planilla.buscar_codigo(codigo)>=0 || lista_eventual.buscar_codigo(codigo)>=0
                            || lista_medico.buscar_codigo(codigo)>=0);       
                    do{
                        horas_extra=Integer.parseInt(Lector.leer("Horas extra: "));
                    }while(horas_extra<0);
                    do{
                        System.out.println("\n Fecha de Ingreso: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha_ingreso=new GregorianCalendar(año, mes, dia);
                    area=Lector.leer("Area: ");
                    cargo=Lector.leer("Cargo: ");
                    do{
                        salario=Double.parseDouble(Lector.leer("Salario: "));
                    }while(salario<=0);
                    porcentaje=Double.parseDouble(Lector.leer("Porcentaje: "));
                    emp_planilla=new Emp_planilla(dni, nombre, apellido, fecha, direccion, 
                            ciudad, codigo, horas_extra, fecha_ingreso, area, cargo, salario, porcentaje);
                    lista_planilla.setPlanilla(emp_planilla);
                    break;
                case 2: // registrar eventual
                    emp_eventual=new Emp_eventual();
                    System.out.println("\n Registrar Empleado Eventual: \n");
                    do{
                        dni=Lector.leer("Dni: ");
                    }while(lista_eventual.buscar_dni(dni)>=0 || lista_planilla.buscar_dni(dni)>=0
                            || lista_medico.buscar_dni(dni)>=0 || lista_paciente.buscar_dni(dni)>=0);
                    nombre=Lector.leer("Nombre: ");
                    apellido=Lector.leer("Apellido: ");
                    
                    do{
                        System.out.println("\n Fecha de nacimiento: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha=new GregorianCalendar(año, mes, dia);
                    direccion=Lector.leer("Direccion: ");
                    ciudad=Lector.leer("Ciudad: ");
                    do{
                        codigo=Lector.leer("Codigo: ");
                    }while(lista_eventual.buscar_codigo(codigo)>=0 || lista_planilla.buscar_codigo(codigo)>=0
                            || lista_medico.buscar_codigo(codigo)>=0);   
                    do{
                        horas_extra=Integer.parseInt(Lector.leer("Horas extra: "));
                    }while(horas_extra<0);
                    do{
                        System.out.println("\n Fecha de Ingreso: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha_ingreso=new GregorianCalendar(año, mes, dia);
                    area=Lector.leer("Area: ");
                    cargo=Lector.leer("Cargo: ");   
                    do{
                        pagohora=Double.parseDouble(Lector.leer("Pago por hora: "));
                    }while(pagohora<=0);          
                    do{
                        horasnormales= Double.parseDouble(Lector.leer("Horas normales: "));
                    }while(horasnormales<=0);
                    do{
                        System.out.println("\n Fecha de Termino: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año)); 
                    fecha_termino=new GregorianCalendar(año, mes, dia);
                    emp_eventual=new Emp_eventual(dni, nombre, apellido, fecha, direccion, ciudad,
                            codigo, horas_extra, fecha_ingreso, area, cargo, pagohora, horasnormales, fecha_termino);
                    lista_eventual.setEventual(emp_eventual);
                    break;
                case 3: // registrar medico
                    System.out.println("\n Registro de Medico: \n");
                    medico=new Medico();
                    do{
                        dni=Lector.leer("Dni: ");
                    }while(lista_medico.buscar_dni(dni)>=0 || lista_planilla.buscar_dni(dni)>=0
                            || lista_eventual.buscar_dni(dni)>=0 || lista_paciente.buscar_dni(dni)>=0);
                    nombre=Lector.leer("Nombre: ");
                    apellido=Lector.leer("Apellido: ");
                    do{
                        System.out.println("\n Fecha de nacimiento: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha=new GregorianCalendar(año, mes, dia);
                    direccion=Lector.leer("Direccion: ");
                    ciudad=Lector.leer("Ciudad: ");
                    do{
                        codigo=Lector.leer("Codigo: ");
                    }while(lista_medico.buscar_codigo(codigo)>=0 || lista_planilla.buscar_codigo(codigo)>=0
                            || lista_eventual.buscar_codigo(codigo)>=0);    
                    do{
                        horas_extra=Integer.parseInt(Lector.leer("Horas extra: "));
                    }while(horas_extra<0);
                    do{
                        System.out.println("\n Fecha de Ingreso: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha_ingreso=new GregorianCalendar(año, mes, dia);
                    area=Lector.leer("Area: ");
                    cargo=Lector.leer("Cargo: "); 
                    do{
                        salario=Double.parseDouble(Lector.leer("Salario: "));
                    }while(salario<=0);
                    porcentaje=Double.parseDouble(Lector.leer("Porcentaje: "));
                    especialidad=Lector.leer("Especialidad: ");
                    servicio=Lector.leer("Servicio: ");
                    nro_consultorio=Integer.parseInt(Lector.leer("Nro consultorio: "));
                    medico=new Medico(dni, nombre, apellido, fecha, direccion, ciudad, codigo, 
                            horas_extra, fecha_ingreso, area, cargo, salario, porcentaje, especialidad, servicio, nro_consultorio);
                    lista_medico.setMedico(medico);
                    break;
                case 4: // registrar paciente
                    System.out.println("\n Registro de Paciente: \n");
                    paciente=new Paciente();
                    do{
                        dni=Lector.leer("Dni: ");
                    }while(lista_paciente.buscar_dni(dni)>=0 || lista_eventual.buscar_dni(dni)>=0
                            || lista_planilla.buscar_dni(dni)>=0 || lista_medico.buscar_dni(dni)>=0);
                    nombre=Lector.leer("Nombre: ");
                    apellido=Lector.leer("Apellido: ");
                    do{
                        System.out.println("\n Fecha de nacimiento: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha=new GregorianCalendar(año, mes, dia);
                    direccion=Lector.leer("Direccion: ");
                    ciudad=Lector.leer("Ciudad: ");
                    do{
                        nro_historia=Lector.leer("Nro de historia: ");
                    }while(lista_paciente.buscar_nro_historia(nro_historia));
                    sexo=Lector.leer("Sexo: ");
                    grupo_sanguineo=Lector.leer("Grupo sanguineo: ");
                    medicamentos=Lector.leer("Medicamentos a que es Alergico: ");
                    paciente=new Paciente(dni, nombre, apellido, fecha_termino, direccion, ciudad, 
                            nro_historia, sexo, grupo_sanguineo, medicamentos);
                    lista_paciente.setPaciente(paciente);
                    break;
                case 5: // registrar cita
                    System.out.println("\n Registrar Cita: \n");
                    cita=new Cita();
                    do{
                        dni=Lector.leer("Dni del paciente: ");
                    }while(lista_paciente.buscar_dni(dni)<0);
                    do{
                        System.out.println("Fecha y Hora:");
                        do{
                            dia=Integer.parseInt(Lector.leer("Dia: "));
                            mes=Integer.parseInt(Lector.leer("Mes: "));
                            año=Integer.parseInt(Lector.leer("Año YYYY: "));
                        }while(!validarFecha(dia, mes, año));
                        hora=Integer.parseInt(Lector.leer("Hora: "));
                        minutos=Integer.parseInt(Lector.leer("Minutos: "));
                        fecha=new GregorianCalendar(año, mes, dia, hora, minutos);
                    }while(lista_cita.buscar_cita_paciente(dni, fecha)); 
                   do{
                       cod_empleado=Lector.leer("Codigo Empleado: ");
                   }while(lista_planilla.buscar_codigo(cod_empleado)<0 && lista_eventual.buscar_codigo(cod_empleado)<0);
                   do{
                       cod_medico=Lector.leer("Codigo Medico: ");
                   }while(lista_cita.cantidad_cita_medico(cod_medico, fecha)>16 || lista_cita.buscar_cita_medico(cod_medico, fecha)
                           || lista_medico.buscar_codigo(cod_medico)<0);
                   cita=new Cita(dni, cod_empleado, cod_medico, fecha);
                   lista_cita.setCita(cita);
                   break;
                case 6: // registrar historial clinico
                    System.out.println("\n Registro de Historia Clinica: \n");
                    historiaClinica=new HistoriaClinica();
                    do{
                        nro_historia=Lector.leer("Nro de historia: ");
                    }while(!lista_paciente.buscar_nro_historia(nro_historia));
                    do{
                        System.out.println("\n Fecha de Apertura: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha_ingreso=new GregorianCalendar(año, mes, dia);
                    do{
                        cod_empleado=Lector.leer("Codigo de Empleado: ");
                    }while(lista_planilla.buscar_codigo(cod_empleado)<0 && lista_eventual.buscar_codigo(cod_empleado)<0);
                    do{
                        dni=Lector.leer("Dni paciente: ");
                    }while(lista_paciente.buscar_dni(dni)<0);
                    do{
                        System.out.println("\n Fecha de Cita: ");
                        dia=Integer.parseInt(Lector.leer("Dia: "));
                        mes=Integer.parseInt(Lector.leer("Mes: "));
                        año=Integer.parseInt(Lector.leer("Año YYYY: "));
                    }while(!validarFecha(dia, mes, año));
                    fecha=new GregorianCalendar(año, mes, dia);
                    servicio=Lector.leer("Servicio: ");
                    do{
                        cod_medico=Lector.leer("Codigo de medico: ");
                    }while(lista_medico.buscar_codigo(cod_medico)<0);
                    diagnostico=Lector.leer("Diagnostico: ");
                    historiaClinica=new HistoriaClinica(nro_historia, fecha_ingreso, cod_empleado, dni,
                            fecha, servicio, cod_medico, diagnostico);
                    lista_historia.setHistoria(historiaClinica);
                    break;
                case 7: // lista medicos desc
                    System.out.println(lista_medico.reporte_especialidad());
                    break;
                case 8: // listar pacientes por medico, en el historial
                    ArrayList<String> lista=new ArrayList<String>();
                    dni="";
                    System.out.println("\n Pacientes atendidos por un medico: \n");
                    do {
                        cod_medico=Lector.leer("Codigo: ");
                    } while (lista_medico.buscar_codigo(cod_medico)<0);
                    lista=lista_historia.busca_pacientes_medico(cod_medico);
                    // isEmpty ? Lista esta vacia
                    if(lista.isEmpty()){
                        System.out.println("\n Medico no atendio pacientes aun!...");
                    }else{
                        for (int i = 0; i < lista.size(); i++) {
                            dni=lista.get(i);
                            System.out.println(lista_paciente.mostrar_por_dni(dni));
                         }
                    }
                    
                    break;
                case 9:
                    break;
            }

        }while(opc!=9);  
    }
    
    public static boolean esBisiesto(int año){
        return ((año%4==0 && año%100!=0)||año%400==0);
    }
      
    public static boolean validarFecha(int dia,int mes,int año){
          int diaMes[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
          boolean bandera=false;
          switch(mes){
              case 2:
                  if(esBisiesto(año)){
                      if(dia>=1 && dia<=29){
                          bandera=true;
                      }
                  }
                  else{
                      if(dia>=1 && dia<=diaMes[mes]){
                          bandera=true;
                      }
                  };
                  break;
              default:
                      if(dia>=1 && dia<=diaMes[mes]){
                          bandera=true;   
                      }
          }
        return bandera;
    }
    
    
}
