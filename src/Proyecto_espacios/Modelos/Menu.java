package Proyecto_espacios.Modelos;

public class Menu {
        public static final int MENU_INICIAL = 0;
        public static final int MENU_ADMINISTRADOR = 1;
        public static final int MENU_DEPARTAMENTO = 2;



        /**
         * Array demenus, cada mensaje se relaciona
         * por posición con el menu correspondiente.
         */
        private static final String[] MENSAJE = {
                "1) Login de aministrador\n2) Login de departamento\n3) Salir",
                "1) Listar departamentos\n2) Añadir departamentos\n3) Eliminar departamento\n4) Listar salas\n5) Añadir salas\n6) Eliminar salas\n7) Listar todas las reservas\n8) Cerrar sesión",
                "1) Añadir reserva\n2) Cancelar reserva\n3) Listar todas las reservas\n4) Cerrar sesión"
        };

        /**
         * Método que devuelve el menú correspondiente al código
         * @param codigo Código de menú
         * @return Menú
         */
        public static String getMensaje(int codigo){
            return MENSAJE[codigo];
        }

}
