package utils.TExpections;

public class NoLengthMatchException extends Exception{
    public NoLengthMatchException(){
        super();
    }
    public NoLengthMatchException(String text){
        super(text);
    }
}
