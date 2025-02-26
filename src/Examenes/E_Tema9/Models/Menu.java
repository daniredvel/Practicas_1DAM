package Examenes.E_Tema9.Models;

public class Menu {
        public static final int MENU_INICIAL = 0;
        public static final int MENU_USUARIO = 1;

        /**
         * Array de menus, cada mensaje se relaciona
         * por posición con el menu correspondiente.
         */
        private static final String[] MENSAJE = {
                "1) Indicar usuario\n2) Borrar usuario\n3) Listar usuario\n4) Salir",
                "1) Añadir pensamiento\n2) Listar mis pensamientos\n3) Cerrar sesión"
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
