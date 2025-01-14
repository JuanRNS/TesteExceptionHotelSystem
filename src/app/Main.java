package app;

import entities.Reserva;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;
import exception.ExceptionMain;

public class Main {
    public static void main(String[] args)  {

        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        try {
            System.out.println("Número do quarto: ");
            int quarto = sc.nextInt();
            System.out.println("Data do check-in (dd/MM/yyyy): ");
            Date checkIn = sdf.parse(sc.next());
            System.out.println("Data do check-out (dd/MM/yyyy): ");
            Date checkOut = sdf.parse(sc.next());

            Reserva reserva = new Reserva(quarto, checkIn, checkOut);
            System.out.println("Reserva: " + reserva);

            System.out.println();
            System.out.println("Digite a data para atualizar a reserva: ");
            System.out.println("Data do check-in (dd/MM/yyyy): ");
            Date checkIn2 = sdf.parse(sc.next());
            System.out.println("Data do check-out (dd/MM/yyyy): ");
            Date checkOut2 = sdf.parse(sc.next());

            reserva.update(checkIn2, checkOut2);
            System.out.println("Reserva: " + reserva);
        }
        catch (ParseException e) {
            System.out.println("Erro no formato da data");
        }
        catch (ExceptionMain e) {
            System.out.println("Erro na reserva: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Erro inesperado!");
        }
    }
}