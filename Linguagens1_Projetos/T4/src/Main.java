import sistema.Sistema;

import java.io.IOException;

/**
 * Classe concreta que representa o main do programa. Ela que vai chamar o sistema.
 * @author Guilherme Ballardini - Guiballa@hotmail.com
 * @author Yago Garcia Battaggia - yagobattaggia@gmail.com
 * @since 04/12/2020
 * @version 1.0
 */

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Sistema sistema = new Sistema();
        sistema.run();
    }
}
