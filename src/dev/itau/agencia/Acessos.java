package dev.itau.agencia;

public enum Acessos implements UserCredenciaisImp {
    ADMINISTRADOR {
        @Override
        public String usuario() {
            return "ADMIN";
        }

        @Override
        public String senha() {
            return "ADMIN";
        }

    },

    GERENTE{
        @Override
        public String usuario() {
            return "GER123";
        }

        @Override
        public  String senha(){
            return "GER123";
        }

    }
}






