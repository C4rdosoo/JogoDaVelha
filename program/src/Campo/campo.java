package Campo;

public class campo {
    private char simbolo;

    public campo() {
        this.simbolo = ' ';
    }

    public char getSimbolo() {
        return simbolo;
    }

    // Só permite marcar se estiver vazio
    public boolean setSimbolo(char s) {
        if (this.simbolo == ' ') {
            this.simbolo = s;
            return true;
        }
        return false;
    }
}
