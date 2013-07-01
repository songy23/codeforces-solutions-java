package optimization.cp;

public interface Constraint<E> {

    void informAboutForget(Connector<E> connector);

    void informAboutNewValue(Connector<E> connector);

}
