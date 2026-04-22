package barbeariakins;

import java.time.LocalDateTime;

public class Agendamento {
    int id;
    BarbeariaKins cliente;
    Servico servico;
    LocalDateTime dataHora;
    String staus;                          //Realizado, Pendente ou Cancelado
   
}
