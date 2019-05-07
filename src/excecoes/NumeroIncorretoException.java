package excecoes;

public class NumeroIncorretoException extends RuntimeException {

    Exception excp;

    public NumeroIncorretoException(String msg){
        super(msg);
    }

    public NumeroIncorretoException(String msg, Exception excp){
        super(msg,excp);
        this.setExcp(excp);
    }

    public Exception getExcp() {
        return excp;
    }

    public void setExcp(Exception excp) {
        this.excp = excp;
    }
}
