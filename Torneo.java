
/**
 * Write a description of class Torneo here.
 * 
 * @author (your name) 
 * @version (a version number or a dates
 */
import java.util.ArrayList;

public class Torneo
{
    private String nombretorneo;
    private ArrayList<Equipo> equiposparticipantes;
    private int cantmaxequipos;
    private boolean repOk(){
        if( this.nombretorneo==null || this.nombretorneo.equals("")){
            return false;
        }
        if(this.equiposparticipantes == null){
            return false;
        }
        if(this.equiposparticipantes.size() > this.cantmaxequipos){
            return false;
        }
        for( Equipo listequip : equiposparticipantes){
            if(listequip==null){
                return false;
            }
            String nombreequipo = listequip.getNombreEquipo();
            if(nombreequipo==null || nombreequipo.equals("")){
            return false;
            }
        }
        if( this.cantmaxequipos<=0){
            return false;
        }
        return true;
    }
    
    public Torneo( String nombretorneo , int cantmaxequipos ){
        if(nombretorneo==null || nombretorneo.equals("")){
            throw new IllegalArgumentException("El nombre del torneo esta vacio crack");
        }
        if(cantmaxequipos <=0){
            throw new IllegalArgumentException("La cantidad maxima de equipos debe ser mayor a cero");
        }
        
        this.nombretorneo = nombretorneo;
        equiposparticipantes = new ArrayList<>();
        this.cantmaxequipos = cantmaxequipos;
        
        assert repOk() : "El contructor fallo al salir que onda";
    }
    /**
     * Agregamos un equipo a la lista de equipos participantes, el checkeo de precondicion 
     * ya se encarga de realizarlo el constructor de la clase Equipo para los parametros.
     * le agragamos repOk() al entrar y salir al ser un metodo mutador;
     * agregamos un objeto anonimo a la lista.
     */
    public void agregarEquipo(String nombre, int cantjugadores){
        assert repOk() : "Invariante rota al entrar al metodo agregarEquipo(String nombre, int cantjugadores)";
        if( this.equiposparticipantes.size() >= this.cantmaxequipos){
            throw new IllegalStateException("Los equipos se pasaron del maximo");
        }
        this.equiposparticipantes.add(new Equipo(nombre , cantjugadores));
        assert repOk() :"Invariante rota al salir del metodo agregarEquipo(String nombre, int cantjugadores)";
    }
    /**
     * Eliminamos el equipo de la lista que nombramos en los parametros.
     * aplicamos un while el cual declaramos antes una variable indice para los elementos de la lista que se va a ir incrementando por cada ciclo.
     * aplicamos una variable boolean buscar que se incializa con false para cuando encontremos el equipo nos devuelva true.
     * de esta manera podemos crear nuestra condicion booleana del if y poder decir que si el while completo las vueltas y indice es >= a los elementos de la lista corta.
     * aplicamos una conjuncion para que si no se cumple esa se cumpla la otra que es que buscar sea no true para que corte.
     * recordar que remove se aplica a la lista en si aplicando remove(indice) no se aplica a la variable local "listaequipo" donde tenemos alojada la lista.
     */
    public void eliminarEquipo( String nombre){
        if( nombre == null || nombre.equals("")){
            throw new IllegalArgumentException("El nombre esta vacio crack");
        }
        assert repOk() : "Invariante rota al entrar al metodo eliminarEquipo";
        int indice = 0;
        boolean buscar = false;
            while( indice < this.equiposparticipantes.size() && !buscar){
                Equipo listaequipo = this.equiposparticipantes.get(indice);
               if( listaequipo.getNombreEquipo().equals(nombre)){
                   this.equiposparticipantes.remove(indice);
                   buscar = true;
                   System.out.println("Equipo " + ":" + listaequipo.getNombreEquipo() + "eliminado");
                    }
                indice++;
                }
        assert repOk() : "Invariante rota al salir del metodo eliminarEquipo";
    
    }   
    
    /**Buscamos si participa el equipo de la lista que nombramos en los parametros.
     * aplicamos un while el cual declaramos antes una variable indice para los elementos de la lista que se va a ir incrementando por cada ciclo.
     * aplicamos una variable boolean encontrado que se incializa con false para cuando encontremos el equipo nos devuelva true.
     * de esta manera podemos crear nuestra condicion booleana del if y poder decir que si el while completo las vueltas y indice es >= a los elementos de la lista corta.
     * aplicamos una conjuncion para que si no se cumple esa se cumpla la otra que es que buscar sea no true para que corte.
     */
    
    public boolean getParticipa( String buscar){
        if( buscar == null || buscar.equals("")){
            throw new IllegalArgumentException("El nombre esta vacio crack");
        }
        assert repOk() : "Invariante rota al entrar al metodo getParticipa( String buscar)";
    
        int indice = 0;
        boolean encontrado = false;
        while( indice < this.equiposparticipantes.size() && !encontrado){
            Equipo listelemento = this.equiposparticipantes.get(indice);
                if(listelemento.getNombreEquipo().equals(buscar)){
                 encontrado = true;
                }
            indice++;
        }
        return encontrado;
    
    }
    /**
     * returnamos la cantidad de equipos que tenemos en el torneo.
     */
    
    public int getCantEquipos(){
        assert repOk() : "Invariante rota al entrar al metodo getCantEquipos()";
       return this.equiposparticipantes.size();
    } 
    
    /**
     * returnamos si el torneo esta completo o no.
     */
    
    public boolean getTorneoCompleto(){
        assert repOk() : "Invariante rota al entrar al metodo getTorneoCompleto()";
        return getCantEquipos() == cantmaxequipos;
    }
    
    public int encontrarCoincidencias( String buscar){
        if( buscar == null || buscar.equals("")){
            throw new IllegalArgumentException("El buscar esta vacio crack");
        }
        assert repOk() : "Invariante rota al entrar al metodo encontrarCoincidencias( String buscar)";
        
        int equiposencontrados = 0;
        for( Equipo listequipo : this.equiposparticipantes){
            if(listequipo.getNombreEquipo().contains(buscar)){
            System.out.println(listequipo.getNombreEquipo());
            equiposencontrados++;
        }
    }
        return equiposencontrados;
    }
    
    public String nombreMasLargo(){
        assert repOk() : "Invariante rota al entrar al metodo nombreMasLargo()";
        String nombremaslargo= null;
        int maxlongitudactual = -1;
        for( Equipo listequipo : this.equiposparticipantes){
            int longitudactual = listequipo.getNombreEquipo().length();
            if( longitudactual > maxlongitudactual){
                maxlongitudactual = longitudactual;
                nombremaslargo = listequipo.getNombreEquipo();
            }
            }
        return nombremaslargo;
    }
    
    public String nombreMenosLargo(){
         assert repOk() : "Invariante rota al entrar al metodo nombreMenosLargo()";
        String nombremenoslargo = null;
        int menlongitud=Integer.MAX_VALUE;
        for( Equipo listequipo : this.equiposparticipantes){
            int longitudactual = listequipo.getNombreEquipo().length();
            if(longitudactual < menlongitud){
                menlongitud =  longitudactual;
                nombremenoslargo = listequipo.getNombreEquipo();
            }
        }
        return nombremenoslargo;
        
    }
    
    public Equipo nombreEquipoindice( int indice){
        if( indice<0 || indice >= this.equiposparticipantes.size()){
            throw new IllegalArgumentException(" el indice debe ir entre 0 y menos la longitud del arraylist");
        }
        assert repOk() : "Invariante rota al entrar al metodo nombreEquipoindice( int indice)";
        
        return this.equiposparticipantes.get(indice);
        
    }
    
    public Equipo[] arregloEquipos(){
        assert repOk() : "Invariante rota al entrar al metodo arregloEquipos()";
        Equipo[] arregloequipos = new Equipo[this.equiposparticipantes.size()];
        int indice = 0;
        while(indice < arregloequipos.length){
            arregloequipos [indice] = nombreEquipoindice(indice);
            indice++;
        }
        
        return arregloequipos;
        
    }
    
    public String[] arreglomaxymin(){
        assert repOk() : "Invariante rota al entrar al metodo arreglomaxymin()";
        String[] arreglo = new String[2];
        arreglo[0] = nombreMenosLargo();
        arreglo[1] = nombreMasLargo();
        return arreglo;
    }
    
    public boolean nombreRepetidos(){
        assert repOk() : "Invariante rota al entrar al metodo nombreRepetidos()";
        int indice = 0;       
        while ( indice < this.equiposparticipantes.size()){
            String nombre = this.equiposparticipantes.get(indice).getNombreEquipo();
            int indicej = indice + 1;
            while( indicej <this.equiposparticipantes.size()){
               String nombreimas = this.equiposparticipantes.get(indicej).getNombreEquipo();
                if( nombre.equals(nombreimas)){
                    return true;
                }
                indicej++;
            }
            indice++;
        }
        return false;
    }
    
    
}
