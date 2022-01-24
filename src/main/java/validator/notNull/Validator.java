package validator.notNull;

  public interface Validator <T> {

    boolean notNull(T t);
    boolean notCopyName(T t);


}
