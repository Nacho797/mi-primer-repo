package autobuses;

public class MasException extends Exception{
    public MasException(int n){
        super("Hay "+ n + "lineas que han recaudado menos");
    }
}
