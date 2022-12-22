package projectsolid.project10.ServiceExceptions;

public class UserNotFoundException extends RuntimeException{
    public static final long serialVersionUID = 1L;

    public UserNotFoundException(Object id) {
        super("Não foi possivel encontrar o usuário: " + id);
    }
}
