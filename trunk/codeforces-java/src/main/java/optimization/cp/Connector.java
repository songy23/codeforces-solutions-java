package optimization.cp;

import java.util.Collection;

import com.google.common.base.Optional;
import com.google.common.collect.Sets;

public class Connector<E> {

    private Optional<E> value;
    private Object informant;
    private final Collection<Constraint<E>> constraints = Sets.newLinkedHashSet();

    public Connector() {
        this.value = Optional.absent();
    }

    public Connector(Object informant, E value) {
        setValue(informant, value);
    }

    public boolean hasValue() {
        return value.isPresent();
    }

    public final void forgetValue(Object retractor) {
        if (retractor == informant) {
            this.value = Optional.absent();
            informAboutForget();
        }
    }

    private void informAboutForget() {
        for (Constraint<E> constraint : constraints) {
            constraint.informAboutForget(this);
        }
    }

    public final void setValue(Object informant, E value) {
        this.informant = informant;
        this.value = Optional.of(value);
        informAboutNewValue();
    }

    private void informAboutNewValue() {
        for (Constraint<E> constraint : constraints) {
            constraint.informAboutNewValue(this);
        }
    }

    public E getValue() {
        return value.get();
    }

    public void addConstraint(Constraint<E> constraint) {
        constraints.add(constraint);

        if (hasValue()) {
            constraint.informAboutNewValue(this);
        }
    }

    public void removeConstraint(Constraint<?> constraint) {
        constraints.remove(constraint);
    }

}
