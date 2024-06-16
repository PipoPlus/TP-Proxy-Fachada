package org.example;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public class Proxy implements Set<Telefono> {
    private PersonaDao personaDao;

    public Proxy(PersonaDao persona){
        this.personaDao = persona;
    }

    @Override
    public Object[] toArray(Object[] a) {
        Set<Telefono> telefonos = this.personaDao.telefonoPorId();
        //System.out.println("Anda el Proxy");
        return telefonos.toArray(new Telefono[telefonos.size()]);
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(Telefono telefono) {
        return false;
    }



    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }
}
