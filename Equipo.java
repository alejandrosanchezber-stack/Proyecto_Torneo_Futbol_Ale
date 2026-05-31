public class Equipo
{
    private String nombreequipo;
    private int cantjugadores;
    private boolean repOk(){
        if( this.nombreequipo.equals("") || this.nombreequipo==null){
            return false;
        }
        if( this.cantjugadores<=0 || this.cantjugadores>11){
            return false;
        }
        return true;
    }
    
    public Equipo(String nombreequipo, int cantjugadores){
        if(nombreequipo.equals("") || nombreequipo==null){
            throw new IllegalArgumentException(" El nombre del equipo no puede estar vacio");
        }
        if(cantjugadores<=0 || cantjugadores>11){
            throw new IllegalArgumentException("La cantidad de jugadores debe ser mayor a 0 o menor a igual 11");
        }
        this.nombreequipo = nombreequipo;
        this.cantjugadores = cantjugadores;
        
        assert repOk() : "El constructor fallo al salir ẃachin que onda";
        
    }
    
    public String getNombreEquipo(){
        assert repOk() : "Invariante rota al entrar al metodo getNombreEquipo()";
        return this.nombreequipo;
    }
    public int getCantJugadores(){
        assert repOk() : "Invariante rota al entrar al metodo getCantJugadores()";
        return cantjugadores;
    }
   
}