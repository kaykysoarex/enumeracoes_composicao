# Composição em Java

Composição é uma forma de criar classes reutilizando outras classes como atributos. Em vez de uma classe **ser um tipo de** outra, ela **tem um** objeto que a ajuda a cumprir suas responsabilidades.

Por exemplo, um carro tem um motor. O motor pode existir como uma classe própria e ser usado por diferentes modelos de carro.

```java
class Motor {
    void ligar() {
        System.out.println("Motor ligado.");
    }
}

class Carro {
    private final Motor motor;

    Carro(Motor motor) {
        this.motor = motor;
    }

    void ligar() {
        motor.ligar();
        System.out.println("Carro pronto para andar.");
    }
}

public class Principal {
    public static void main(String[] args) {
        Motor motor = new Motor();
        Carro carro = new Carro(motor);
        carro.ligar();
    }
}
```

## Por que usar composição?

- **Reutilização:** a mesma classe pode ser usada em diferentes contextos.
- **Flexibilidade:** é mais simples trocar uma dependência por outra implementação.
- **Baixo acoplamento:** cada classe fica responsável por uma parte pequena do problema.
- **Manutenção:** alterações em um componente tendem a causar menos impacto nas outras classes.

## Composição e herança

Use herança quando houver uma relação clara de "é um" (`Cachorro` é um `Animal`). Prefira composição quando a relação for "tem um" (`Carro` tem um `Motor`).

Em geral, a composição é preferível porque permite combinar comportamentos sem criar hierarquias rígidas de classes.
