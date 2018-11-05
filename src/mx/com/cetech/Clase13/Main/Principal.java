package mx.com.cetech.Clase13.Main;

import java.io.LineNumberInputStream;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;

import mx.com.cetech.Clase13.BD.ConexionBD;
import mx.com.cetech.Clase13.Bean.Persona;
import mx.com.cetech.Clase13.DAO.ConsultaPersonaDao;

public class Principal {

	public static void main(String[] args) {
	
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Bienvenido al Directorio");
		
		System.out.println("1.- Ver personas");
		System.out.println("2.- Buscar personas");
		System.out.println("3.- Editr");
		System.out.println("4.- Eliminar peronas");
		System.out.println("5.- Agregar personas");

		int seleccionUsuario = teclado.nextInt();
		ConsultaPersonaDao consutaPersonaDao = new ConsultaPersonaDao();
		switch (seleccionUsuario) {
		case 1:
			
			
			Map<String, String> mapaPersonas = consutaPersonaDao.getAllPersonas();
			
			for(Map.Entry<String, String> contador: mapaPersonas.entrySet()){
					
					System.out.println(contador.getKey()+ "/" + contador.getValue());}
			break;
		
		case 2:
			System.out.println("Ingrese el nombre de la persona a encontrar");
			String nombreSolicitud = teclado.next();
			
			
			ArrayList<Persona>  alv= consutaPersonaDao.getPersonas(nombreSolicitud);
			
			System.out.println(alv.isEmpty()? "Sin Registros ":"");
			
			for(Persona per: alv){
				System.out.println(per.getNombre() + per.getCelular());
			}
			break;	
		case 3:
			
			Persona persona = new Persona();
			
			System.out.println("ESCRIA EL NOMBRE DE LA PERSONA QUE DESEA EDITAR");
			String nombredeConsulta = teclado.next();
		
			System.out.println("Nombre nuevo a atualizar");
			
			persona.setNombre(teclado.next());
			
			System.out.println(consutaPersonaDao.editPersonas(persona, nombredeConsulta, null));
			
			
			break;
			
		case 4:
	
			break;
	
		case 5:
	
			break;

		default:
			break;
		}
		
		
		
		
	}

}
