package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String args[]) {

        PersonaDao dao = new PersonaDao();
        Persona p = dao.personaPorId(1);
        System.out.println(p.nombre());

        for (Telefono telefono : p.telefonos()) {
            System.out.println(telefono);
        }

    }
}