import sistema.Sistema;

import java.io.IOException;
/*RA da dupla
    Guilherme Ballardini  - 18.01353-8
    Yago Garcia Battaggia - 18.01099-7
 */

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
