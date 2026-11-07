package enumeracoes;

public class enumExplicacao {

    public static void main(String[] args) {

        // ---------------------------------------------------------------
        // 1) USAR UMA CONSTANTE DO ENUM
        //    Escreve-se NomeDoEnum.CONSTANTE. Não existe "new" em enum.
        // ---------------------------------------------------------------
        OrderStatus os1 = OrderStatus.DELIVERED;
        System.out.println("os1 = " + os1);                        // os1 = DELIVERED

        // ---------------------------------------------------------------
        // 2) CONVERTER TEXTO PARA ENUM (valueOf)
        //    O texto precisa ser IDÊNTICO ao nome da constante, inclusive maiúsculas.
        // ---------------------------------------------------------------
        OrderStatus os2 = OrderStatus.valueOf("DELIVERED");
        System.out.println("os2 = " + os2);                        // os2 = DELIVERED

        // Os dois são a MESMA constante. Em enum, comparar com == é o jeito certo.
        System.out.println("os1 == os2: " + (os1 == os2));         // os1 == os2: true

        // OrderStatus.valueOf("delivered");   // erro em tempo de execução: IllegalArgumentException
        //                                     // (minúsculo não bate com nenhuma constante)
        // ---------------------------------------------------------------
        // 3) ENUM COMO TIPO DE UM ATRIBUTO
        //    O status do pedido só aceita um dos 4 valores do enum.
        // ---------------------------------------------------------------
        Order order = new Order(1, OrderStatus.PENDING_PAYMENT);
        System.out.println(order);                                  // Order 1 - PENDING_PAYMENT

        order.setStatus(OrderStatus.PROCESSING);                    // pedido avançou no ciclo de vida
        System.out.println(order);                                  // Order 1 - PROCESSING

        // order.setStatus("PROCESSING");      // erro de COMPILAÇÃO: String não é OrderStatus
        // order.setStatus(OrderStatus.SENT);  // erro de COMPILAÇÃO: essa constante não existe
        // Esta é a vantagem: o compilador avisa o erro antes de rodar.
        // ---------------------------------------------------------------
        // 4) EXTRA (vai além do slide): percorrer as constantes
        //    values() devolve todas, na ordem em que foram declaradas.
        //    ordinal() é a posição (começa em 0), a mesma do diagrama UML da aula.
        // ---------------------------------------------------------------
        for (OrderStatus s : OrderStatus.values()) {
            System.out.println(s.ordinal() + " = " + s);
        }
        // 0 = PENDING_PAYMENT
        // 1 = PROCESSING
        // 2 = SHIPPED
        // 3 = DELIVERED
    }
}

// Ciclo de vida de um pedido: PENDING_PAYMENT -> PROCESSING -> SHIPPED -> DELIVERED
// Na aula, o enum fica em um arquivo próprio (pacote entities.enums).
// Aqui ele está no mesmo arquivo só para o exemplo rodar sozinho.
enum OrderStatus {
    PENDING_PAYMENT,
    PROCESSING,
    SHIPPED,
    DELIVERED;
}

class Order {

    private Integer id;
    private OrderStatus status;     // o tipo do atributo é o enum

    public Order(Integer id, OrderStatus status) {
        this.id = id;
        this.status = status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order " + id + " - " + status;
    }
}
