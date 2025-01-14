package exception;

import java.io.Serial;

public class ExceptionMain extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;

    public ExceptionMain(String msg) {
        super(msg);
    }
}
