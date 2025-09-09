package Campo;

public class campo {
    private char simbolo;

    public campo() {
        this.simbolo = ' '; // campo vazio
    }

    public char getSimbolo() {
        return this.simbolo;
    }

    public boolean setSimbolo(char simbolo) {
        if (this.simbolo == ' ') {
            this.simbolo = simbolo;
            return true;
        } else {
            System.out.println("SELECIONE UM CAMPO DISPONIVEL");
            return false;
        }
    }
}
